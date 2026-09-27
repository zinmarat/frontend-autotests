import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

public class CartSelenideTest {

    @BeforeAll
    public static void setup() {
        // Настройки Selenide (один раз для всех тестов)
        Configuration.browser = "chrome";
        Configuration.headless = false; // показывать браузер
        Configuration.timeout = 10000;  // 10 секунд ожидание по умолчанию

        // Отключаем окно о "слитом" пароле
        System.setProperty("chromeoptions.prefs",
                "profile.password_manager_leak_detection=false");
    }

    @Test
    public void addToCartTest() {
        // 1. Открываем сайт и логинимся
        open("https://www.saucedemo.com");
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();

        // 2. Ждём загрузки страницы товаров (автоматически через URL)
        // Selenide сам ждёт — ничего писать не нужно!

        // 3. Находим все кнопки "Add to cart" и кликаем по первой
        $$(".btn_inventory").first().click();

        // 4. Проверяем счётчик корзины
        $(".shopping_cart_badge").shouldHave(text("1"));

        System.out.println("✅ Товар добавлен. Счётчик корзины: " +
                $(".shopping_cart_badge").getText());
    }
}