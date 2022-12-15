package ru.yandex.praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LogInTest {
    private WebDriver driver;
    MainPage page;
    String name;
    String email;
    String password;
    int count = 10;
    boolean temp;

    public LogInTest(boolean temp) {
        this.temp = temp;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {false},
                {true}
        };
    }

    @Before
    public void startUp() {
        if (temp) {
            System.setProperty("webdriver.chrome.driver",
                    "c:\\Users\\Public\\Java\\QADiplomChapterThree\\Diplom_3\\src\\main\\resources\\yandexdriver.exe");
        }
        driver = new ChromeDriver();
        page = new MainPage(driver);
        name = RandomStringUtils.randomAlphabetic(count);
        email = RandomStringUtils.randomAlphabetic(count) + "@mail.ru";
        password = RandomStringUtils.randomAlphabetic(count);
    }

    @Test
    public void logInAcrossButtonOnMainTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .clickRegistrationButton()
                .registrationUser(name, email, password)
                .expectPersonalAccount()
                .clickConstructorButton()
                .clickGoInAccountButton()
                .logInUser(email, password)
                .expectMainPage()
                .checkButtonCreateOrder();
        assertTrue(flag);
    }

    @Test
    public void logInAcrossPersonalAccountTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .clickRegistrationButton()
                .registrationUser(name, email, password)
                .expectPersonalAccount()
                .clickConstructorButton()
                .clickPersonalAccountButton()
                .logInUser(email, password)
                .expectMainPage()
                .checkButtonCreateOrder();
        assertTrue(flag);
    }

    @Test
    public void logInAcrossFormRegistrationTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .clickRegistrationButton()
                .registrationUser(name, email, password)
                .expectPersonalAccount()
                .clickRegistrationButton()
                .clickButtonInOnPageRegistration()
                .logInUser(email, password)
                .expectMainPage()
                .checkButtonCreateOrder();
        assertTrue(flag);
    }

    @Test
    public void logInAcrossFormReanimatePasswordTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .clickRegistrationButton()
                .registrationUser(name, email, password)
                .expectPersonalAccount()
                .clickReanimatePasswordButton()
                .clickLogInButton()
                .logInUser(email, password)
                .expectMainPage()
                .checkButtonCreateOrder();
        assertTrue(flag);
    }

    @Test
    public void logOutTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .clickRegistrationButton()
                .registrationUser(name, email, password)
                .expectPersonalAccount()
                .logInUser(email, password)
                .expectMainPage()
                .clickPersonalAccountButton()
                .expectPersonalAccountButtonLogout()
                .clickLogOutButton()
                .expectPersonalAccount()
                .checkElementIn();
        assertTrue(flag);
    }

    @After
    public void teardown() {
        // Закрытие браузера
        driver.quit();
    }
}
