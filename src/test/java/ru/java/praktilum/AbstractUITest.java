package ru.java.praktilum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.WebStorage;

import java.util.concurrent.TimeUnit;

public class AbstractUITest {
    protected static WebDriver webDriver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.chromedriver().setup();
        webDriver = new FirefoxDriver();
        //webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void clearData(){
        webDriver.manage().deleteAllCookies();
        ((WebStorage)webDriver).getLocalStorage().clear();
        ((WebStorage)webDriver).getSessionStorage().clear();
    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();
    }
}
