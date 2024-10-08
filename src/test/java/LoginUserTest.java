import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.PasswordRecoveryPage;
import PageObject.RegisterPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@DisplayName("Проверить аутентификацию")
public class LoginUserTest extends BaseTest {
    private static final DeleteUser deleteUser = new DeleteUser();
    private static final RegisterUser registrationUser = new RegisterUser();
    private static User user;

    @Before
    public void setUp() {
        Configuration.headless = true;
        optionBrowser("chrome");
        user = UserData.defaultUserData();
        registrationUser.registrationUser();
    }

    @Test
    @DisplayName("Проверить аутентификацию по кнопке Войти в аккаунт на главной странице")
    public void authUserLoginPage() {
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
    }

    @Test
    @DisplayName("Проверить вход через кнопку Личный кабинет")
    public void authUserMainPage() {
        Selenide.open("https://stellarburgers.nomoreparties.site/");
        new MainPage().clickPersonalAccountButton().checkLoginPage();
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
    }

    @Test
    @DisplayName("Проверить вход через кнопку в форме регистрации")
    public void authUserRegistrationPage() {
        Selenide.open("https://stellarburgers.nomoreparties.site/register");
        new RegisterPage().clickEnterButton().checkLoginPage();
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
    }

    @Test
    @DisplayName("Проверить вход через кнопку в форме восстановления пароля")
    public void authUserPasswordRecoveryPage() {
        Selenide.open("https://stellarburgers.nomoreparties.site/forgot-password");
        new PasswordRecoveryPage().clickEnter().checkLoginPage();
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
        deleteUser.deleteDefaultUser();
    }

}
