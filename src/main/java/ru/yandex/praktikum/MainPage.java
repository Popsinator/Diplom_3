package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {

    //драйвер для браузера
    private final WebDriver driver;

    private static final String URL_BURGER = "https://stellarburgers.nomoreparties.site/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(URL_BURGER);
        return this;
    }

    //локатор кнопки личный кабинет
    private final By buttonPersonalAccount = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2']" +
            "[text() = 'Личный Кабинет']");

    //локатор кнопки войти в аккаунт
    private final By buttonGoInAccount = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']" +
            "[text() = 'Войти в аккаунт']");

    //локатор кнопки оформить заказ
    private final By buttonCreateOrder = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']" +
            "[text() = 'Оформить заказ']");

    //локатор кнопки Соусы
    private final By buttonSous = By.xpath(".//span[@class = 'text text_type_main-default']" +
            "[text() = 'Соусы']");

    //локатор Соуса Spicy-X
    private final By buttonSousSpicyX = By.xpath(".//p[@class = 'BurgerIngredient_ingredient__text__yp3dH']" +
            "[text() = 'Соус Spicy-X']");

    //локатор кнопки Булки
    private final By buttonBulks = By.xpath(".//span[@class = 'text text_type_main-default']" +
            "[text() = 'Булки']");

    //локатор Флюоресцентной булки R2-D3
    private final By buttonFlBulksR2D3 = By.xpath(".//p[@class = 'BurgerIngredient_ingredient__text__yp3dH']" +
            "[text() = 'Флюоресцентная булка R2-D3']");

    //локатор кнопки Начинки
    private final By buttonFillings = By.xpath(".//span[@class = 'text text_type_main-default']" +
            "[text() = 'Начинки']");

    //локатор Мяса бессмертных моллюсков Protostomia
    private final By buttonFillingsProtostomia = By.xpath(".//p[@class = 'BurgerIngredient_ingredient__text__yp3dH']" +
            "[text() = 'Мясо бессмертных моллюсков Protostomia']");


    public MainPage clickSousButton() {
        if (driver.findElement(buttonSous).isDisplayed()) {
            driver.findElement(buttonSous).click();
        }
        new WebDriverWait(driver, 1000).until(ExpectedConditions.
                textToBePresentInElementLocated(buttonSousSpicyX, "Соус Spicy-X"));
        return this;
    }

    public MainPage clickBulksButton() {
        if (driver.findElement(buttonBulks).isDisplayed()) {
            driver.findElement(buttonBulks).click();
        }
        new WebDriverWait(driver, 1000).until(ExpectedConditions.
                textToBePresentInElementLocated(buttonFlBulksR2D3, "Флюоресцентная булка R2-D3"));
        return this;
    }

    public MainPage clickFillingsButton() {
        if (driver.findElement(buttonFillings).isDisplayed()) {
            driver.findElement(buttonFillings).click();
        }
        new WebDriverWait(driver, 1000).until(ExpectedConditions.
                textToBePresentInElementLocated(buttonFillingsProtostomia, "Мясо бессмертных моллюсков Protostomia"));
        return this;
    }

    public boolean checkButtonFillingsProtostomia() {
        return driver.findElement(buttonFillingsProtostomia).isDisplayed();
    }

    public boolean checkButtonFlBulksR2D3() {
        return driver.findElement(buttonFlBulksR2D3).isDisplayed();
    }

    public boolean checkButtonSousSpicyX() {
        return driver.findElement(buttonSousSpicyX).isDisplayed();
    }

    public PagePersonalAccount clickPersonalAccountButton() {
        if (driver.findElement(buttonPersonalAccount).isDisplayed()) {
            driver.findElement(buttonPersonalAccount).click();
        }
        return new PagePersonalAccount(driver);
    }

    public PagePersonalAccount clickGoInAccountButton() {
        if (driver.findElement(buttonGoInAccount).isDisplayed()) {
            driver.findElement(buttonGoInAccount).click();
        }
        return new PagePersonalAccount(driver);
    }

    public boolean checkButtonCreateOrder() {
        return driver.findElement(buttonCreateOrder).isDisplayed();
    }

    public boolean checkButtonLogInAccount() {
        return driver.findElement(buttonGoInAccount).isDisplayed();
    }

    public MainPage expectMainPage() {
        new WebDriverWait(driver, 1000).until(ExpectedConditions.
                textToBePresentInElementLocated(buttonCreateOrder, "Оформить заказ"));
        return this;
    }

    public MainPage expectMainPageLogInAccount() {
        new WebDriverWait(driver, 1000).until(ExpectedConditions.
                textToBePresentInElementLocated(buttonGoInAccount, "Войти в аккаунт"));
        return this;
    }

}
