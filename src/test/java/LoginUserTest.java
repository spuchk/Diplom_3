import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.PasswordRecoveryPage;
import pageobject.RegisterPage;
import org.openqa.selenium.WebDriver;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;




@DisplayName("Проверить аутентификацию")
public  class LoginUserTest extends BaseTest {
    private WebDriver driver;
    private static final DeleteUser deleteUser = new DeleteUser();
    private static final RegisterUser registrationUser = new RegisterUser();
    private static User user;
    public static final String BROWSER_NAME_ENV_VARIABLE = "BROWSER_NAME";
    @Before
    public void setUp() {

        String browserName = System.getenv(BROWSER_NAME_ENV_VARIABLE);
     
        driver = getWebDriver(Browser.valueOf(browserName));


        user = UserData.defaultUserData();
        registrationUser.registrationUser();
    }

    @Test
    @DisplayName("Проверить аутентификацию по кнопке Войти в аккаунт на главной странице")
    public void authUserLoginPage() {
        Selenide.open(Url.URL_LOGIN);
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
    }

    @Test
    @DisplayName("Проверить вход через кнопку Личный кабинет")
    public void authUserMainPage() {
        Selenide.open(Url.URL_BASE);
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
        Selenide.open(Url.URL_REGISTER);
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
        Selenide.open(Url.URL_PASSWORD_RECOVERY );
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
