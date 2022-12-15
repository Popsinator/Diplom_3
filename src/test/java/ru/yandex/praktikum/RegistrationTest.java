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
public class RegistrationTest {
    private WebDriver driver;
    MainPage page;
    String name;
    String email;
    String password;
    String passwordIncorrect;
    int count = 10;
    int countForPasswordIncorrect = 1;
    boolean temp;

    public RegistrationTest(boolean temp) {
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
        passwordIncorrect = RandomStringUtils.randomAlphabetic(countForPasswordIncorrect);
    }

    @Test
    public void registrationWithCorrectPasswordTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .clickRegistrationButton()
                .registrationUser(name, email, password)
                .expectPersonalAccount()
                .checkElementIn();
        assertTrue(flag);
    }

    @Test
    public void registrationWithExistUserTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .clickRegistrationButton()
                .registrationUser(name, email, password)
                .expectPersonalAccount()
                .clickRegistrationButton()
                .registrationUserError(name, email, password)
                .scroll()
                .checkErrorRegistrationExistUser();
        assertTrue(flag);
    }

    @Test
    public void registrationWithIncorrectPasswordTest() {
        boolean flag = page.open()
                .clickPersonalAccountButton()
                .clickRegistrationButton()
                .registrationUserError(name, email, passwordIncorrect)
                .checkErrorRegistrationIncorrectPassword();
        assertTrue(flag);
    }

    @After
    public void teardown() {
        // Закрытие браузера
        driver.quit();
    }
}
