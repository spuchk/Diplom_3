package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.Matchers.containsString;

public  class MainPage {

    private final SelenideElement constructorButton = $(byXpath(".//p[text() = 'Конструктор']"));
    private final SelenideElement loginButtonMainPage = $(byXpath("//button[text()='Войти в аккаунт']"));
    private final SelenideElement personalAccountButton = $(byXpath(".//p[text()='Личный Кабинет']"));
    private final SelenideElement checkoutButton = $(byXpath(".//button[text() = 'Оформить заказ']"));
    private final SelenideElement burgerConstructorLabel = $(byXpath(".//h1[text() = 'Соберите бургер']"));
    private final SelenideElement sauceButton = $(byXpath(".//span[text() = 'Соусы']"));
    private final SelenideElement bunButton = $(byXpath(".//span[text() = 'Булки']"));
    private final SelenideElement ingredientsButton = $(byXpath(".//span[text() = 'Начинки']"));
    private final SelenideElement fluorescentBun = $(byXpath(".//p[text() = 'Флюоресцентная булка R2-D3']"));
    private final SelenideElement sauce = $(byXpath(".//p[text() = 'Соус Spicy-X']"));
    private final SelenideElement ingredients = $(byXpath(".//p[text() = 'Мясо бессмертных моллюсков Protostomia']"));

    private final SelenideElement enterText = $(byXpath(".//h2[text() = 'Вход']"));
    WebDriver driver;

    @Step("Нажать на кнопку Булки")
    public MainPage clickBunButton() {
        sauceButton.click();
        bunButton.click();
        return this;
    }

    @Step("Нажать на кнопку Соусы")
    public MainPage clickSauceButton() {
        sauceButton.click();
        return this;
    }

    @Step("Нажать на кнопку Начинки")
    public MainPage clickIngredientsButton() {
        ingredientsButton.click();
        return this;
    }

    @Step("Нажать на кнопку личного кабинета")
    public MainPage clickPersonalAccountButton() {
        personalAccountButton.click();
        return this;
    }

    @Step("Проверить переход на главную страницу")
    public MainPage checkLoginPage() {
        Assert.assertThat(enterText.getText(), containsString("Вход"));
        return this;
    }

    @Step("Проверить переход на вкладку Булки")
    public MainPage checkingTransitionToBun() {
        WebElement element =
                driver.findElement(By.xpath(".//img[@alt='Флюоресцентная булка R2-D3']"));

        boolean isElementInViewport =
                new WebDriverWait(driver, Duration.ofSeconds(1))
                        .until(
                                driver -> {
                                    Rectangle rect = element.getRect();
                                    Dimension windowSize = driver.manage().window().getSize();

                                    // условие, которое проверяем внутри явного ожидания
                                    return rect.getX() >= 0
                                            && rect.getY() >= 0
                                            && rect.getX() + rect.getWidth() <= windowSize.getWidth()
                                            && rect.getY() + rect.getHeight() <= windowSize.getHeight();
                                });
        return this;
    }

    @Step("Проверить переход на вкладку Соусы")
    public MainPage checkingTransitionToSauce(){
        WebElement element =
                driver.findElement(By.xpath(".//img[@alt='Соус Spicy-X']"));

        boolean isElementInViewport =
                new WebDriverWait(driver, Duration.ofSeconds(1))
                        .until(
                                driver -> {
                                    Rectangle rect = element.getRect();
                                    Dimension windowSize = driver.manage().window().getSize();

                                    // условие, которое проверяем внутри явного ожидания
                                    return rect.getX() >= 0
                                            && rect.getY() >= 0
                                            && rect.getX() + rect.getWidth() <= windowSize.getWidth()
                                            && rect.getY() + rect.getHeight() <= windowSize.getHeight();
                                });
    return this;
    }
    @Step("Проверить переход на вкладку Начинки")
    public MainPage checkingTransitionToIngredients() {
        WebElement element =
                driver.findElement(By.xpath(".//img[@alt='Мясо бессмертных моллюсков Protostomia']"));

        boolean isElementInViewport =
                new WebDriverWait(driver, Duration.ofSeconds(1))
                        .until(
                                driver -> {
                                    Rectangle rect = element.getRect();
                                    Dimension windowSize = driver.manage().window().getSize();

                                    // условие, которое проверяем внутри явного ожидания
                                    return rect.getX() >= 0
                                            && rect.getY() >= 0
                                            && rect.getX() + rect.getWidth() <= windowSize.getWidth()
                                            && rect.getY() + rect.getHeight() <= windowSize.getHeight();
                                });
        return this;
    }
}