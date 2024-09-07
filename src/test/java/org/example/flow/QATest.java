package org.example.flow;

import org.example.pages.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class QATest extends MainTest {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    @Parameterized.Parameter
    public int questionNumber;

    @Parameterized.Parameter(1)
    public String answerText;

    //сделала проверки незывисимыми  - добавлена параметризация для каждого вопроса и ответа.
    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
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

        //получение текста ответа
        String answerTextFact = mainPage.getAnswerText(questionNumber);
        assertEquals("Текст ответа на воспрос " + questionNumber + " некорректный", answerText, answerTextFact);
    }
}
