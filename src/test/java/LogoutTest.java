import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class LogoutTest {

    @Test
    public void logoutTest() {
        // ⚙️ Настройки Chrome — отключаем предупреждение о пароле
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("credentials_enable_service", false);

        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.saucedemo.com");

            // Логин
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Меню + Logout
            WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
            menuButton.click();

            WebElement logoutLink = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))
            );
            logoutLink.click();

            // Ждём возврата на страницу логина
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));

            String currentUrl = driver.getCurrentUrl();
            assertEquals("https://www.saucedemo.com/", currentUrl, "Не вернулись на страницу логина!");

            System.out.println("✅ Logout успешен. URL: " + currentUrl);

        } finally {
            driver.quit();
        }
    }
}