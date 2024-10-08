import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.RegisterPage;



@DisplayName("Проверить регистрацию пользователя")
public class RegisterTest extends BaseTest {
    private User user;
    private final DeleteUser deleteUser = new DeleteUser();
    private boolean createUser;
    @Before
    public void setUp() {
        Configuration.headless = false;
        optionBrowser("chrome");
        Selenide.open("https://stellarburgers.nomoreparties.site/");
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
