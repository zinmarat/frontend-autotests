import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class FirstUiTest {

    @Test
    public void duckDuckGoSearchTest() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://duckduckgo.com");

            WebElement searchField = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.name("q"))
            );

            searchField.sendKeys("Selenium Java");
            searchField.sendKeys(Keys.ENTER);

            wait.until(ExpectedConditions.titleContains("Selenium Java"));

            String title = driver.getTitle();
            assertTrue(title.contains("Selenium Java"),
                    "Заголовок не содержит запрос! Реальный: " + title);

            System.out.println("✅ Заголовок: " + title);

        } finally {
            driver.quit();
        }
    }
}