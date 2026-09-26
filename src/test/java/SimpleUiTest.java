import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleUiTest {

    @Test
    public void checkPageTitle() {
        // 1. Запускаем браузер
        WebDriver driver = new ChromeDriver();

        try {
            // 2. Открываем сайт
            driver.get("https://www.saucedemo.com");

            // 3. Получаем заголовок вкладки
            String title = driver.getTitle();

            // 4. Проверяем, что заголовок правильный
            assertEquals("Swag Labs", title, "Заголовок не совпал!");

            // 5. Логируем для себя
            System.out.println("✅ Заголовок: " + title);

        } finally {
            // 6. Закрываем браузер (в любом случае)
            driver.quit();
        }
    }
}