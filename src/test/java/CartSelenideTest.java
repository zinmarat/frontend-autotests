import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CartSelenideTest {

    @BeforeAll
    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = TestConfig.TIMEOUT;

        System.setProperty("chromeoptions.prefs",
                "profile.password_manager_leak_detection=false");

    }

    @BeforeEach

    public void openLoginPage() {
        open(TestConfig.BASE_URL);
    }

    @Test
    public void addToCartTest() {
        // 1. Открываем сайт и логинимся

        LoginSteps.loginAsStandardUser();

        // 2. Находим все кнопки "Add to cart" и кликаем по первой
        $$(".btn_inventory").first().click();

        // 3. Проверяем счётчик корзины
        $(".shopping_cart_badge").shouldHave(text("1"));

        System.out.println("✅ Товар добавлен. Счётчик корзины: " +
                $(".shopping_cart_badge").getText());
    }
}