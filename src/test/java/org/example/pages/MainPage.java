package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //добавляю локаторы для раскрывающихся списков в разделе Вопросы о важном
    private final By firstQuestion = By.id("accordion__heading-0");
    private final By firstAnswer = By.id("accordion__panel-0");

    private final By secondQuestion = By.id("accordion__heading-1");
    private final By secondAnswer = By.id("accordion__panel-1");

    private final By thirdQuestion = By.id("accordion__heading-2");
    private final By thirdAnswer = By.id("accordion__panel-2");

    private final By fourthQuestion = By.id("accordion__heading-3");
    private final By fourthAnswer = By.id("accordion__panel-3");

    private final By fifthQuestion = By.id("accordion__heading-4");
    private final By fifthAnswer = By.id("accordion__panel-4");

    private final By sixthQuestion = By.id("accordion__heading-5");
    private final By sixthAnswer = By.id("accordion__panel-5");

    private final By seventhQuestion = By.id("accordion__heading-6");
    private final By seventhAnswer = By.id("accordion__panel-6");

    private final By eighthQuestion = By.id("accordion__heading-7");
    private final By eighthAnswer = By.id("accordion__panel-7");

    //метод для нажатия кнопки Заказать

    public void clickOrderButton(String exactOrderButtonCSS) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector(exactOrderButtonCSS)));
        driver.findElement(By.cssSelector(exactOrderButtonCSS)).click();
    }

    //методы для кликанья по раскрывающимся спискам в разделе Вопросы о важном и проверки что они раскрываются

    public void clickFirstQuestion(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(firstQuestion));
        driver.findElement(firstQuestion).click();
    }

    public boolean isFirstAnswerOpen(){
        return driver.findElement(firstAnswer).isDisplayed();
    }

    public void clickSecondQuestion(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(secondQuestion));
        driver.findElement(secondQuestion).click();
    }

    public boolean isSecondAnswerOpen(){
        return driver.findElement(secondAnswer).isDisplayed();
    }


    public void clickThirdQuestion(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(thirdQuestion));
        driver.findElement(thirdQuestion).click();
    }

    public boolean isThirdAnswerOpen(){
        return driver.findElement(thirdAnswer).isDisplayed();
    }


    public void clickFourthQuestion(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(fourthQuestion));
        driver.findElement(fourthQuestion).click();
    }

    public boolean isFourthAnswerOpen(){
        return driver.findElement(fourthAnswer).isDisplayed();
    }


    public void clickFifthQuestion(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(fifthQuestion));
        driver.findElement(fifthQuestion).click();
    }

    public boolean isFifthAnswerOpen(){
        return driver.findElement(fifthAnswer).isDisplayed();
    }


    public void clickSixthQuestion(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(sixthQuestion));
        driver.findElement(sixthQuestion).click();
    }

    public boolean isSixthAnswerOpen(){
        return driver.findElement(sixthAnswer).isDisplayed();
    }


    public void clickSeventhQuestion(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(seventhQuestion));
        driver.findElement(seventhQuestion).click();
    }

    public boolean isSeventhAnswerOpen(){
        return driver.findElement(seventhAnswer).isDisplayed();
    }


    public void clickEighthQuestion(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(eighthQuestion));
        driver.findElement(eighthQuestion).click();
    }

    public boolean isEighthAnswerOpen(){
        return driver.findElement(eighthAnswer).isDisplayed();
    }
}
