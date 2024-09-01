package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserData {
    private WebDriver driver;

    public UserData(WebDriver driver) {
        this.driver = driver;
    }
    //добавляю локаторы для полей заполнения заказа

    //локатор для поля Имя
    private final By firstNameInput = By.xpath("//input[@placeholder='* Имя']");

    //локатор для поля Фамилия
    private final By secondNameInput = By.xpath("//input[@placeholder='* Фамилия']");

    //локатор для поля Адрес куда привезти
    private final By deliveryAddressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    //локатор для поля Станция метро
    private final By metroInput = By.xpath("//input[@placeholder='* Станция метро']");

    //локатор для поля Телефон
    private final By phoneNumberInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    //локатор для кнопки Далее
    private final By nextButton = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM");

    //локатор для cookie
    private final By cookieButton = By.className("App_CookieButton__3cvqF");


    //методы для заполнения полей

    //метод для заполнения поля Имя
    public void firstNameFulfil(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    //метод для заполнения поля Фамилия
    public void secondNameFulfil(String secondName) {
        driver.findElement(secondNameInput).sendKeys(secondName);
    }

    //метод для заполнения поля Адрес куда привезти
    public void deliveryAddressFulfil(String deliveryAddress) {
        driver.findElement(deliveryAddressInput).sendKeys(deliveryAddress);
    }

    //метод для заполнения поля Станция метро
    public void metroSelect(String metroStation) {
        driver.findElement(metroInput).sendKeys(metroStation);
        driver.findElement(By.xpath("//div[text()='" + metroStation + "']")).click();
    }

    //метод для заполнения поля Телефон
    public void phoneNumberFulfil(String phoneNumber) {
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    //принимаем cookie
    public void clickAcceptCookie() {
        driver.findElement(cookieButton).click();
    }

    //нажать по кнопке Далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}
