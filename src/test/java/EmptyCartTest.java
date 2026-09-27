import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyBinTest {

    @BeforeAll
    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.timeout = TestConfig.TIMEOUT;
    }

    @BeforeEach
    public void login() {
        open(TestConfig.BASE_URL);
        $("#user-name").setValue(TestConfig.STANDARD_USER);
        $("#password").setValue(TestConfig.STANDARD_PASSWORD);
        $("#login-button").click();
    }

    public void emptyCartTest() {
        // Проверка 1: значка корзины нет
        $(".shopping_cart_badge").shouldNot(exist);

        // Проверка 2: у ссылки корзины aria-label = "Cart, empty"
        $(".shopping_cart_link").shouldHave(attribute("aria-label", "Cart, empty"));

        System.out.println("✅ Корзина пуста");
    }
}