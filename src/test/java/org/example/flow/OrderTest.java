package org.example.flow;

import org.example.pages.ScooterData;
import org.example.pages.UserData;
import org.example.pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest {
    private MainPage mainPage;
    private UserData userData;
    private ScooterData scooterData;

    private final WebDriver driver;
    private final String firstName;
    private final String secondName;
    private final String deliveryAddress;
    private final String metroStation;
    private final String phoneNumber;
    private final String dateReceiving;
    private final String rentPeriod;
    private final String scooterColor;
    private final String courierComment;
    private final String exactOrderButtonCSS;

    public OrderTest(WebDriver driver, String exactOrderButtonCSS, String firstName, String secondName, String deliveryAddress, String metroStation, String phoneNumber,
                     String dateReceiving, String rentPeriod, String scooterColor, String courierComment) {
        this.driver = driver;
        this.exactOrderButtonCSS = exactOrderButtonCSS;
        this.firstName = firstName;
        this.secondName = secondName;
        this.deliveryAddress = deliveryAddress;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.dateReceiving = dateReceiving;
        this.rentPeriod = rentPeriod;
        this.scooterColor = scooterColor;
        this.courierComment = courierComment;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {new ChromeDriver(), ".Button_Button__ra12g", "Иван", "Петров", "ул Ленина, д12", "Сокольники", "890677775544", "03.09.2024",
                        "двое суток", "grey", "Комментарий"},
                {new ChromeDriver(), ".Button_Button__ra12g.Button_Middle__1CSJM", "Марина", "Иванова", "ул Рябиновая,д 120", "Лубянка", "89107778899", "10.09.2024", "сутки", "black", "Комментарий Комментарий"}
        });
    }

    @Before
    public void setUp() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
        userData = new UserData(driver);
        scooterData = new ScooterData(driver);
    }

    @Test
    public void testOrderFlow() {
        //кликаем по кнопке Заказать в хэдере
        mainPage.clickOrderButton(exactOrderButtonCSS);

        //заполняем первую страницу формы заказа
        userData.firstNameFulfil(firstName);
        userData.secondNameFulfil(secondName);
        userData.deliveryAddressFulfil(deliveryAddress);
        userData.metroSelect(metroStation);
        userData.phoneNumberFulfil(phoneNumber);

        //принимаем куки
        userData.clickAcceptCookie();

        //Нажать кнопку далее
        userData.clickNextButton();

        //заполняем детали заказа на второй странице
        scooterData.selectDateReceiving(dateReceiving);
        scooterData.selectRentPeriod(rentPeriod);
        scooterData.selectColor(scooterColor);
        scooterData.writeComment(courierComment);

        //нажимаем кнопку заказать
        scooterData.clickOrderButton();

        //нажимаем кнопку Да на форме подтверждения заказа
        scooterData.clickYesButton();

        //проверям что заказ успешно создан
        assertTrue("Заказ не создается", scooterData.isOrderCreated());
    }

    @After
    public void driverQuit() {
        driver.quit();
    }
}
