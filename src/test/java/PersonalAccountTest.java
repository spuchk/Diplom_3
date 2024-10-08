
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import PageObject.AccountPage;
import PageObject.LoginPage;
import PageObject.MainPage;



@DisplayName("Проверить личный кабинет")
public class PersonalAccountTest extends BaseTest {
    private static User user;
    private final DeleteUser deleteUser = new DeleteUser();
    private final RegisterUser registrationUser = new RegisterUser();

    @Before
    public void setUp() {
        Configuration.headless = true;
        optionBrowser("chrome");
        user = UserData.defaultUserData();
        registrationUser.registrationUser();
    }

    @Test
    @DisplayName("Проверить переход по клику на Личный кабинет")
    public void loginPersonalAccount() {
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
        new MainPage().clickPersonalAccountButton();
        new AccountPage().checkSuccessfulAccountLogin();
    }

    @Test
    @DisplayName("Проверить переход по клику на Конструктор")
    public void transitionToConstructor() {
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
        new MainPage().clickPersonalAccountButton();
        new AccountPage().checkSuccessfulAccountLogin()
                .clickConstructorButton().checkTransitionMainPage();
    }

    @Test
    @DisplayName("Проверить переход по клику на Stellar Burgers")
    public void transitionToLogo() {
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
        new MainPage().clickPersonalAccountButton();
        new AccountPage().checkSuccessfulAccountLogin()
                .clickLogoButton().checkTransitionMainPage();
    }

    @Test
    @DisplayName("Проверить выход по кнопке Выйти в личном кабинете")
    public void exitFromPersonalAccount() {
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
        new MainPage().clickPersonalAccountButton();
        new AccountPage().checkSuccessfulAccountLogin()
                .clickExitButton().checkExitPersonalAccount();
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
        deleteUser.deleteDefaultUser();
    }
}
