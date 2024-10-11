
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.MainPage;

@DisplayName("Проверить  переход к разделам")
public class RedirectionTest extends BaseTest{

    @Before
    public void setUp() {
        String browserName = System.getenv(BROWSER_NAME_ENV_VARIABLE);

        driver = getWebDriver(Browser.valueOf(browserName));
        Selenide.open(Url.URL_BASE);
    }
    @Test
    @DisplayName("Проверить переход на вкладку Булки")
    public void switchToTabBun() {
        new MainPage().clickBunButton().checkingTransitionToBun();
    }
    @Test
    @DisplayName("Проверить переход на вкладку Соусы")
    public void switchToTabSauces() {
        new MainPage().clickSauceButton().checkingTransitionToSauce();
    }
    @Test
    @DisplayName("Проверить переход на вкладку Начинки")
    public void switchToTabToppings() {
        new MainPage().clickIngredientsButton().checkingTransitionToIngredients();
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
    }
}