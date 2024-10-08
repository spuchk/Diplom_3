
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {

    public void optionBrowser(String browser) {
        if ("yandex".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\5G\\chromedriver-win64");
            Configuration.browser = "chrome";
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\5G\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            WebDriver webDriver = new ChromeDriver(options);
            setWebDriver(webDriver);
        }
    }
}
