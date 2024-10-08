package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.Matchers.containsString;

public class PasswordRecoveryPage {
    private final SelenideElement enterButton = $(byXpath(".//a[text() = 'Войти']"));
    private final SelenideElement enterText = $(byXpath(".//h2[text() = 'Вход']"));

    @Step("Клик по кнопке входа")
    public PasswordRecoveryPage clickEnter() {
        enterButton.click();
        return this;
    }

    @Step("Проверить переход на страницу входа")
    public PasswordRecoveryPage checkLoginPage() {
        Assert.assertThat(enterText.getText(), containsString("Вход"));
        return this;
    }
}
