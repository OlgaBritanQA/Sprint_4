package org.example.flow;

import org.example.pages.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class QATest extends MainTest {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    @Parameterized.Parameter
    public int questionNumber;

    //сделала проверки незывисимыми  - добавлена параметризация для каждого вопроса и ответа.
    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}
        });
    }

    @Override
    protected WebDriver createDriver() {
        return new ChromeDriver();
    }

    @Override
    protected String getUrl() {
        return URL;
    }

    @Test
    public void testQAFlow() {
        MainPage mainPage = new MainPage(driver);

        //клик по вопросам в разделе Вопросы о важном и проверка, что ответы раскрываются
        mainPage.clickQuestionByIndex(questionNumber);
        assertTrue("Ответ на вопрос " + questionNumber + " не раскрылся",
                mainPage.isQuestionAnswerOpenByIndex(questionNumber)
        );
    }
}
