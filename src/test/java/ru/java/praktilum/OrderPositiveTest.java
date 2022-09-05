package ru.java.praktilum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.MainPage;
import ru.yandex.praktikum.OrderPage;
import ru.yandex.praktikum.pojos.CustomerInformation;

@RunWith(Parameterized.class)
public class OrderPositiveTest extends AbstractUITest{

    public OrderPositiveTest(String buttonPosition, CustomerInformation customerInformation) {
        this.buttonPosition = buttonPosition;
        this.customerInformation = customerInformation;

    }
    private String buttonPosition;
    private CustomerInformation customerInformation;
    private static MainPage mainPage;
    private static OrderPage orderPage;
    private static CustomerInformation firstCustomer = new CustomerInformation("Иван", "Иванов", "Москва", "+77055854316", "Сокольники");
    private static CustomerInformation secondCustomer = new CustomerInformation("Петр", "Петров", "Домодедово", "+7705214624", "Аэропорт");

    @Parameterized.Parameters
    public static Object[][] sendTestDetails() {
        return new Object[][] {
                { "header", firstCustomer},
                { "middle", secondCustomer},
        };
    }

    @Test
    public void positiveOrderComplete(){
        mainPage = new MainPage(webDriver);
        orderPage = new OrderPage(webDriver);
        mainPage.open();
        mainPage.acceptCookiesBtnClick();
        mainPage.clickOrderBtn(buttonPosition);
        orderPage.inputUserDetails(customerInformation);
        Assert.assertTrue("order complete message should be visible", orderPage.isOrderComplete());
    }
}
