package org.example.flow;

import org.example.pages.MainPage;
import org.example.pages.ScooterData;
import org.example.pages.UserData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends MainTest {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    private final String firstName;
    private final String secondName;
    private final String deliveryAddress;
    private final String metroStation;
    private final String phoneNumber;
    private final String dateReceiving;
    private final String rentPeriod;
    private final String scooterColor;
    private final String courierComment;

    public OrderTest(String firstName, String secondName, String deliveryAddress, String metroStation, String phoneNumber,
                     String dateReceiving, String rentPeriod, String scooterColor, String courierComment) {
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

    @Override
    protected WebDriver createDriver() {
        return new ChromeDriver();
    }

    @Override
    protected String getUrl() {
        return URL;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Иван", "Петров", "ул Ленина, д12", "Сокольники", "890677775544", "03.09.2024",
                        "двое суток", "grey", "Комментарий"},
                {"Марина", "Иванова", "ул Рябиновая,д 120", "Лубянка", "89107778899", "10.09.2024", "сутки", "black",
                        "Комментарий Комментарий"}
        });
    }

    @Test
    public void testHeaderOrderFlow() {
        MainPage mainPage = new MainPage(driver);
        UserData userData = new UserData(driver);
        ScooterData scooterData = new ScooterData(driver);
        //кликаем по кнопке Заказать в хэдере
        mainPage.clickHeaderOrderButton();

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

    @Test
    public void testBodyOrderFlow() {
        MainPage mainPage = new MainPage(driver);
        UserData userData = new UserData(driver);
        ScooterData scooterData = new ScooterData(driver);
        //кликаем по кнопке Заказать в хэдере
        mainPage.clickBodyOrderButton();

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
}
