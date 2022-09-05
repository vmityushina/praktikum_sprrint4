package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.pojos.CustomerInformation;

import java.util.concurrent.TimeUnit;

public class OrderPage extends AbstractPage{
    public OrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    //input for name
    private By inputName = By.xpath(".//*[contains(@placeholder, 'Имя')]");
    //input for last name
    private By inputLastName = By.xpath(".//*[contains(@placeholder, 'Фамилия')]");
    //input for address
    private By inputAddress = By.xpath(".//*[contains(@placeholder, 'Адрес')]");
    //input for phone number
    private By inputPhoneNumber = By.xpath(".//*[contains(@placeholder, 'Телефон')]");
    //input for metro station
    private By metroStation = By.xpath(".//*[contains(@placeholder, 'метро')]");
    //submit inputs on the first page
    private By nextBtn = By.xpath("//button[contains(text(),'Далее')]");
    //input for date
    private By startDateInput = By.xpath(".//*[contains(@placeholder, 'Когда привезти самокат')]");
    //locator to find 14th day in current month
    private By startDate = By.xpath("//div[@class='react-datepicker__day react-datepicker__day--014']");
    //input for rent term
    private By rentPeriodInput = By.xpath("//div[contains(text(),'Срок аренды')]");
    //locator to select first term from dropdown
    private By rentPeriod = By.xpath("//div[text()='сутки']");
    //colour checkbox
    private By colour = By.xpath("//input[@id='black']");
    //order button from the bottom
    private By orderBtn = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(),'Заказать')]");
    //confirm button
    private By confirmOrderBtn = By.xpath("//button[contains(text(),'Да')]");
    //order complete message
    private By orderComplete = By.xpath("//div[contains(text(),'Заказ оформлен')]");

    public void inputUserDetails(CustomerInformation customer)  {
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.findElement(inputName).sendKeys(customer.getName());
        webDriver.findElement(inputLastName).sendKeys(customer.getLastname());
        webDriver.findElement(inputAddress).sendKeys(customer.getAddress());
        webDriver.findElement(inputPhoneNumber).sendKeys(customer.getPhoneNumber());
        webDriver.findElement(metroStation).click();
        webDriver.findElement(metroStation).findElement(By.xpath("//div[contains(text(), '" + customer.getMetroStation() + "')]")).click();
        webDriver.findElement(nextBtn).click();
        webDriver.findElement(startDateInput).click();
        webDriver.findElement(startDate).click();
        webDriver.findElement(rentPeriodInput).click();
        webDriver.findElement(rentPeriod).click();
        webDriver.findElement(colour).click();
        webDriver.findElement(orderBtn).click();
        webDriver.findElement(confirmOrderBtn).click();
    }

    public boolean isOrderComplete(){
        return webDriver.findElement(orderComplete).isDisplayed();
    }
}
