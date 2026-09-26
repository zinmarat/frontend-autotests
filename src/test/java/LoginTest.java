import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void successfulLoginTest() {
        // 1. Запускаем браузер
        WebDriver driver = new ChromeDriver();

        try {
            // 2. Открываем сайт
            driver.get("https://www.saucedemo.com"); // ← вставь URL

            // 3. Находим поле логина и вводим логин
            WebElement usernameField = driver.findElement(By.id("user-name")); // ← какой id?
            usernameField.sendKeys("standard_user"); // ← какой логин?

            // 4. Находим поле пароля и вводим пароль
            WebElement passwordField = driver.findElement(By.id("password")); // ← какой id?
            passwordField.sendKeys("secret_sauce"); // ← какой пароль?

            // 5. Находим кнопку Login и кликаем
            WebElement loginButton = driver.findElement(By.id("login-button")); // ← какой id?
            loginButton.click(); // ← какой метод? (click / sendKeys)

            // 6. Находим заголовок страницы
            WebElement title = driver.findElement(By.className("title")); // ← какой class?
            String actualTitle = title.getText(); // ← какой метод? (getText / getTagName)

            // 7. Проверяем заголовок
            assertEquals("Products", actualTitle, "Заголовок не совпал!");

            System.out.println("✅ Логин успешен. Заголовок: " + actualTitle);

        } finally {
            driver.quit();
        }
    }
}