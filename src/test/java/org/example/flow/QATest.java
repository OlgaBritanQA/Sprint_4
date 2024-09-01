package org.example.flow;

import org.example.pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class QATest {
    private MainPage mainPage;
    private WebDriver driver;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
    }
    @Test
    public void testQAFlow() {

        //клик по первому вопрос в разделе Вопросы о важном
        mainPage.clickFirstQuestion();
        assertTrue("Ответ на первый вопрос не раскрывается", mainPage.isFirstAnswerOpen());

        //клик по второму вопросу в разделе Вопросы о важном
        mainPage.clickSecondQuestion();
        assertTrue("Ответ на второй вопрос не раскрывается", mainPage.isSecondAnswerOpen());

        //клик по третьему вопросу в разделе Вопросы о важном
        mainPage.clickThirdQuestion();
        assertTrue("Ответ на третий вопрос не раскрывается", mainPage.isThirdAnswerOpen());

        //клик по четвертому вопросу в разделе Вопросы о важном
        mainPage.clickFourthQuestion();
        assertTrue("Ответ на четвертый вопрос не раскрывается", mainPage.isFourthAnswerOpen());

        //клик по пятому вопросу в разделе Вопросы о важном
        mainPage.clickFifthQuestion();
        assertTrue("Ответ на пятый вопрос не раскрывается", mainPage.isFifthAnswerOpen());

        //клик по шестому вопросу в разделе Вопросы о важном
        mainPage.clickSixthQuestion();
        assertTrue("Ответ на шестой вопрос не раскрывается", mainPage.isSixthAnswerOpen());

        //клик по седьмому вопросу в разделе Вопросы о важном
        mainPage.clickSeventhQuestion();
        assertTrue("Ответ на седьмой вопрос не раскрывается", mainPage.isSeventhAnswerOpen());

        //клик по восьмому вопросу в разделе Вопросы о важном
        mainPage.clickEighthQuestion();
        assertTrue("Ответ на восьмой вопрос не раскрывается", mainPage.isEighthAnswerOpen());
    }

    @After
    public void driverQuit() {
        driver.quit();
    }
}
