import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RemoveCartTest {

    @BeforeAll
    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = TestConfig.TIMEOUT;
        System.setProperty("chromeoptions.prefs",
                "profile.password_manager_leak_detection=false");
    }

    @BeforeEach
    public void login() {
        open(TestConfig.BASE_URL);
        $("#user-name").setValue(TestConfig.STANDARD_USER);
        $("#password").setValue(TestConfig.STANDARD_PASSWORD);
        $("#login-button").click();
        $$(".btn_inventory").first().click();
        System.out.println("✅ Товар был добавлен");
        // Пауза 5 секунд для визуальной проверки
        Selenide.sleep(2000);
    }

    @Test
    public void emptyCartTest() {

        // Проверяем, что кнопка стала "Remove"
        $$(".btn_inventory").first().shouldHave(text("Remove"));
        System.out.println("✅ Кнопка под товаром стала Remove");
        // Пауза 5 секунд для визуальной проверки
        Selenide.sleep(1000);
        $$(".btn_inventory").first().click();
        System.out.println("✅ Товар был удалён");
        // Пауза 5 секунд для визуальной проверки
        Selenide.sleep(2000);
        // Проверка 1: значка корзины нет
        $(".shopping_cart_badge").shouldNot(exist);

        // Проверка 2: у ссылки корзины aria-label = "Cart, empty"
        $(".shopping_cart_link").shouldHave(attribute("aria-label", "Cart, empty"));
        $$(".btn_inventory").first().shouldHave(text("Add to cart"));
        System.out.println("✅ Кнопка под товаром стала Add to Cart");

        // Пауза 5 секунд для визуальной проверки
        Selenide.sleep(2000);
        System.out.println("✅ Корзина пуста");

    }
}