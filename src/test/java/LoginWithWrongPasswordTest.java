import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithWrongPasswordTest {

    @Test
    public void loginWithWrongPasswordTest() {
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
            passwordField.sendKeys("secret_sauce1"); // ← какой пароль?

            // 5. Находим кнопку Login и кликаем
            WebElement loginButton = driver.findElement(By.id("login-button")); // ← какой id?
            loginButton.click(); // ← какой метод? (click / sendKeys)

            // 6. Находим сообщение об ошибке
            // ⚠️ Локатор: By.cssSelector("h3[data-test='error']")
            WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")); // ← вставь локатор

            // 7. Получаем текст ошибки
            String actualError = errorMessage.getText(); // ← какой метод? (getText / sendKeys)

            // 8. Проверяем, что текст содержит ожидаемое сообщение
            assertTrue(actualError.contains("Epic sadface: Username and password do not match any user in this service"), // ← какое сообщение?
                    "Сообщение об ошибке не совпало! Реальное: " + actualError);

            System.out.println("✅ Ошибка появилась: " + actualError);

        } finally {
            driver.quit();
        }
    }
}
