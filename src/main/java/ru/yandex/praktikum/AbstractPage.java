package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected final WebDriver webDriver;

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
