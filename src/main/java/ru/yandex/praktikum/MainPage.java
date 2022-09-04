package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends AbstractPage {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    //список ответов, которые должны отображаться по клику на вопрос
    private static final ArrayList<String> rightAnswers = new ArrayList<>(
            Arrays.asList("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                    "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                    "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                    "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области."));

    //весь див с вопросами и ответами
    private By questions = By.className("accordion");
    //потомки любого элемента
    private By childElements = By.xpath("./child::*");
    //кнопка понять и простить
    private By acceptCookiesBtn = By.xpath("//button[@id='rcc-confirm-button']");
    //Кнопка заказать из хэдэра
    private By orderBtnFromHeader = By.className("Button_Button__ra12g");
    //Див, где находится кнопка "Заказать" с середины страницы
    private By homeFinishBtn = By.xpath("//div[@class='Home_FinishButton__1_cWm']");
    //кнопка заказать с середины страницы
    private By orderBtnFromMiddle = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");

    public void open() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickOrderBtn(String btnPosition) {
        if (btnPosition.equals("header")) {
            webDriver.findElement(orderBtnFromHeader).click();
        }
        else {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(homeFinishBtn));
            webDriver.findElement(orderBtnFromMiddle).click();
        }
    }

    public void scrollToFAQ() {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void acceptCookiesBtnClick() {
        webDriver.findElement(acceptCookiesBtn).click();
    }

    public List<WebElement> getListOfQuestions() {
        return webDriver.findElement(questions).findElements(childElements);
    }

    public boolean checkIfAnswerIsCorrect(int questionNum, List<WebElement> listOfQuestions) {
        listOfQuestions.get(questionNum).click();
        //в слаке сказали так можно >_<
        //если локаторы похожи, они отвечают за однообразные элементы и в них меняется только какая то часть, то это нормально использовать
        // например, String.format для их формирования внутри одного метода
        String answer = webDriver.findElement(By.id(String.format("accordion__panel-%d", questionNum))).getText();
        if (!rightAnswers.get(questionNum).equals(answer)){
            return false;
        }
        return true;
    }

}
