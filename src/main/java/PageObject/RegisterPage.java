package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.Matchers.containsString;

public class RegisterPage {
    private final SelenideElement namePlaceholder = $(byXpath(".//label[text() = 'Имя']/following-sibling::input"));
    private final SelenideElement emailPlaceholder = $(byXpath(".//label[text() = 'Email']/following-sibling::input"));
    private final SelenideElement passwordPlaceholder = $(byXpath(".//label[text() = 'Пароль']/following-sibling::input"));
    private final SelenideElement registrationButton = $(byXpath(".//button[text() = 'Зарегистрироваться']"));
    private final SelenideElement errorPasswordWarning = $(byXpath(".//p[@class = 'input__error text_type_main-default']"));
    private final SelenideElement enterButton = $(byXpath(".//a[text() = 'Войти']"));
    private final SelenideElement enterText = $(byXpath(".//h2[text() = 'Вход']"));

    @Step("Заполнить поле имя")
    public RegisterPage setName(String name) {
        namePlaceholder.setValue(name);
        return this;
    }
    @Step("Заполнить поле  email")
    public RegisterPage setEmail(String email) {
        emailPlaceholder.setValue(email);
        return this;
    }

    @Step("Заполнить поле  пароль")
    public RegisterPage setPassword(String password) {
        passwordPlaceholder.setValue(password);
        return this;
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public RegisterPage clickRegistration() {
        registrationButton.click();
        return this;
    }
    @Step("Клик по кнопке Войти")
    public RegisterPage clickEnterButton() {
        enterButton.click();
        return this;
    }
    @Step("Отображение ошибки при вводе неверного пароля")
    public RegisterPage errorPassword() {
        errorPasswordWarning.shouldHave(Condition.text("Некорректный пароль"));
        return this;
    }

    @Step("Проверить переход на страницу входа")
    public RegisterPage checkLoginPage() {
        Assert.assertThat(enterText.getText(), containsString("Вход"));
        return this;
    }





}
