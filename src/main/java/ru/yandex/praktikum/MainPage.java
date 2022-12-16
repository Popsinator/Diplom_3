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

    //подсветка раздела Соусы
    private final By buttonSousLight = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc" +
            " pt-4 pr-10 pb-4 pl-10 noselect']" +
            "/span[@class = 'text text_type_main-default'][text() = 'Соусы']");

    //локатор подсветки
    private final By buttonLight = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc" +
            " pt-4 pr-10 pb-4 pl-10 noselect']");

    //локатор кнопки Булки
    private final By buttonBulks = By.xpath(".//span[@class = 'text text_type_main-default']" +
            "[text() = 'Булки']");

    //подсветка раздела Булки
    private final By buttonBulksLight = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc" +
            " pt-4 pr-10 pb-4 pl-10 noselect']" +
            "/span[@class = 'text text_type_main-default'][text() = 'Булки']");

    //локатор Флюоресцентной булки R2-D3
    private final By buttonFlBulksR2D3 = By.xpath(".//p[@class = 'BurgerIngredient_ingredient__text__yp3dH']" +
            "[text() = 'Флюоресцентная булка R2-D3']");

    //локатор кнопки Начинки
    private final By buttonFillings = By.xpath(".//span[@class = 'text text_type_main-default']" +
            "[text() = 'Начинки']");

    //подсветка раздела Начинки
    private final By buttonFillingsLight = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc" +
            " pt-4 pr-10 pb-4 pl-10 noselect']" +
            "/span[@class = 'text text_type_main-default'][text() = 'Начинки']");

    //локатор Мяса бессмертных моллюсков Protostomia
    private final By buttonFillingsProtostomia = By.xpath(".//p[@class = 'BurgerIngredient_ingredient__text__yp3dH']" +
            "[text() = 'Мясо бессмертных моллюсков Protostomia']");


    public MainPage clickSousButton() throws InterruptedException {
        if (driver.findElement(buttonSous).isDisplayed()) {
            driver.findElement(buttonSous).click();
        }
        new WebDriverWait(driver, 1000).until(ExpectedConditions
                .visibilityOfElementLocated(buttonSousLight));
        Thread.sleep(500);
        return this;
    }

    public MainPage clickBulksButton() throws InterruptedException {
        if (driver.findElement(buttonBulks).isDisplayed()) {
            driver.findElement(buttonBulks).click();
        }
        new WebDriverWait(driver, 1000).until(ExpectedConditions
                .visibilityOfElementLocated(buttonBulksLight));
        Thread.sleep(500);
        return this;
    }

    public MainPage clickFillingsButton() throws InterruptedException {
        if (driver.findElement(buttonFillings).isDisplayed()) {
            driver.findElement(buttonFillings).click();
        }
        new WebDriverWait(driver, 1000).until(ExpectedConditions
                .visibilityOfElementLocated(buttonFillingsLight));
        Thread.sleep(1000);
        return this;
    }

    public boolean checkButtonFillingsLight() {
        return driver.findElement(buttonFillingsLight).isDisplayed();
    }

    public boolean checkButtonBulksLight() {
        return driver.findElement(buttonBulksLight).isDisplayed();
    }

    public boolean checkButtonSousLight() {
        return driver.findElement(buttonSousLight).isDisplayed();
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
