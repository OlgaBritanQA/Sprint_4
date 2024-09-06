package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //локаторы для кнопок Заказать
    private final By headerOrderButton = By.cssSelector(".Button_Button__ra12g");
    private final By bodyOrderButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    //методы для нажатия кнопки Заказать
    public void clickHeaderOrderButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(headerOrderButton));
        driver.findElement(headerOrderButton).click();
    }

    public void clickBodyOrderButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(bodyOrderButton));
        driver.findElement(bodyOrderButton).click();
    }

    //методы для кликанья по раскрывающимся спискам в разделе Вопросы о важном и проверки что они раскрываются
    public void clickQuestionByIndex(int questionIndex) {
        By questionLocator = By.id("accordion__heading-" + questionIndex);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(questionLocator));
        driver.findElement(questionLocator).click();
    }

    public boolean isQuestionAnswerOpenByIndex(int questionIndex) {
        By answerLocator = By.id("accordion__panel-" + questionIndex);
        return driver.findElement(answerLocator).isDisplayed();
    }
}
