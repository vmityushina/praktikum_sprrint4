package ru.java.praktilum;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import ru.yandex.praktikum.MainPage;

public class QuestionsTest extends AbstractUITest{

    private static MainPage mainPage;

    @Before
    public void goToFAQ(){
        mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.acceptCookiesBtnClick();
        mainPage.scrollToFAQ();
    }

    @Test
    public void answer1IsCorrect(){
        boolean isAnswerIsCorrect = mainPage.checkIfAnswerIsCorrect(0, mainPage.getListOfQuestions());
        Assert.assertTrue("answer should be visible with the right text", isAnswerIsCorrect);
    }

    @Test
    public void answer2IsCorrect(){
        boolean isAnswerIsCorrect = mainPage.checkIfAnswerIsCorrect(1, mainPage.getListOfQuestions());
        Assert.assertTrue("answer should be visible with the right text", isAnswerIsCorrect);
    }

    @Test
    public void answer3IsCorrect(){
        boolean isAnswerIsCorrect = mainPage.checkIfAnswerIsCorrect(2, mainPage.getListOfQuestions());
        Assert.assertTrue("answer should be visible with the right text", isAnswerIsCorrect);
    }

    @Test
    public void answer4IsCorrect(){
        boolean isAnswerIsCorrect = mainPage.checkIfAnswerIsCorrect(3, mainPage.getListOfQuestions());
        Assert.assertTrue("answer should be visible with the right text", isAnswerIsCorrect);
    }

    @Test
    public void answer5IsCorrect(){
        boolean isAnswerIsCorrect = mainPage.checkIfAnswerIsCorrect(4, mainPage.getListOfQuestions());
        Assert.assertTrue("answer should be visible with the right text", isAnswerIsCorrect);
    }

    @Test
    public void answer6IsCorrect(){
        boolean isAnswerIsCorrect = mainPage.checkIfAnswerIsCorrect(5, mainPage.getListOfQuestions());
        Assert.assertTrue("answer should be visible with the right text", isAnswerIsCorrect);
    }

    @Test
    public void answer7IsCorrect(){
        boolean isAnswerIsCorrect = mainPage.checkIfAnswerIsCorrect(6, mainPage.getListOfQuestions());
        Assert.assertTrue("answer should be visible with the right text", isAnswerIsCorrect);
    }

    @Test
    public void answer8IsCorrect(){
        boolean isAnswerIsCorrect = mainPage.checkIfAnswerIsCorrect(7, mainPage.getListOfQuestions());
        Assert.assertTrue("answer should be visible with the right text", isAnswerIsCorrect);
    }
}
