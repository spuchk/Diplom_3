
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;



@DisplayName("Проверить регистрацию пользователя")
public class RegisterTest extends BaseTest {
    private User user;
    private final DeleteUser deleteUser = new DeleteUser();
    private boolean createUser;
    @Before
    public void setUp() {
        String browserName = System.getenv(BROWSER_NAME_ENV_VARIABLE);

        driver = getWebDriver(Browser.valueOf(browserName));
        Selenide.open(Url.URL_BASE);
        new MainPage().clickPersonalAccountButton();
        new LoginPage().clickRegistrationLink();
    }
    @Test
    @DisplayName("Проверить успешную регистрацию профиля пользователя")
    public void registrationUser() {
        createUser = true;
        user = UserData.defaultUserData();
        new RegisterPage()
                .setName(user.getName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickRegistration()
                .checkLoginPage();

    }

    @Test
    @DisplayName("Проверить регистрацию профиля пользователя с некорректным паролем")
    public void registrationUserWithIncorrectPassword() {
        createUser = false;
        user = UserData.userDataIncorrectPassword();
        new RegisterPage()
                .setName(user.getName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickRegistration()
                .errorPassword();
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
        if (createUser) {
            deleteUser.deleteDefaultUser();
        }
    }
}
