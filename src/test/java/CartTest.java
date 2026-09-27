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
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    @Test
    public void addToCartTest() {
        // ⚙️ Настройки Chrome
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // 1. Открываем сайт и логинимся
            driver.get("https://www.saucedemo.com");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // 2. Ждём, пока загрузится страница товаров
            wait.until(ExpectedConditions.urlContains("inventory.html"));

            // 3. Находим ВСЕ кнопки "Add to cart"
            List<WebElement> addButtons = driver.findElements(By.className("btn_inventory")); // ← какой локатор?

            // 4. Нажимаем на первую кнопку
            addButtons.get(0).click(); // ← какой метод? (get / size)

            // 5. Проверяем счётчик корзины
            WebElement cartBadge = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")) // ← какой class?
            );
            String badgeText = cartBadge.getText(); // ← какой метод? (getText / sendKeys)

            // 6. Проверяем, что счётчик = "1"
            assertEquals("1", badgeText, "Счётчик корзины не равен 1!"); // ← что ожидаем?

            System.out.println("✅ Товар добавлен. Счётчик корзины: " + badgeText);

        } finally {
            driver.quit();
        }
    }
}