package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScooterData {
    private final WebDriver driver;

    public ScooterData(WebDriver driver) {
        this.driver = driver;
    }
    //добавляю локаторы для полей заполнения заказа

    //локатор для даты Когда привезти самокат
    private final By dateReceivingInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    //локатор для срока аренды
    private final By rentalPeriodDropdown = By.className("Dropdown-placeholder");

    //локатор для комментария курьеру
    private final By courierCommentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");

    //локатор для кнопки заказать
    private final By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //локатор для кнопки ДА на всплывающем окне
    private final By yesButton = By.xpath("//button[text()='Да']");

    //локатор для созданной формы заказа
    private final By createdOrderForm = By.xpath("//div[text()='Заказ оформлен']");


    //методы для заполнения полей

    //заполняем дату когда привезти
    public void selectDateReceiving(String dateReceiving) {
        driver.findElement(dateReceivingInput).sendKeys(dateReceiving + Keys.ENTER);
    }

    //заполняем срок аренды
    public void selectRentPeriod(String rentPeriod) {
        driver.findElement(rentalPeriodDropdown).click();
        driver.findElement(By.xpath("//div[@class='Dropdown-menu']/div[text()='" + rentPeriod + "']")).click();
    }

    //выбираем цвет самоката
    public void selectColor(String scooterColor) {
        driver.findElement(By.id(scooterColor)).click();
    }

    //пишем комментарий курьеру
    public void writeComment(String courierComment) {
        driver.findElement(courierCommentInput).sendKeys(courierComment);
    }

    //нажимаем на кнопку заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    // нажимаем на кнопку ДА на всплывающем окне
    public void clickYesButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(yesButton));
        button.click();
    }

    // проверяем что заказ создался и появилось модальное окно
    public boolean isOrderCreated() {
        try {
            return driver.findElement(createdOrderForm).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
