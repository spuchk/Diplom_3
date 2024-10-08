package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;

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
        Assert.assertThat(fluorescentBun.getText(), containsString("Флюоресцентная булка R2-D3"));
        return this;
    }
    @Step("Проверить переход на вкладку Соусы")
    public MainPage checkingTransitionToSauce() {
        Assert.assertThat(sauce.getText(), containsString("Соус Spicy-X"));
        return this;
    }
    @Step("Проверить переход на вкладку Начинки")
    public MainPage checkingTransitionToIngredients() {
        Assert.assertThat(ingredients.getText(), containsString("Мясо бессмертных моллюсков Protostomia"));
        return this;
    }
}