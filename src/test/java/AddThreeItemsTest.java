import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

public class AddThreeItemsTest {

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

    @Test
    public void addThreeItemsTest() {
        $$(".btn_inventory").first().click();
        $$(".btn_inventory").get(2).click();
        $$(".btn_inventory").last().click();

        $(".shopping_cart_badge").shouldHave(text("3"));
        $(".shopping_cart_link").click();


        $(".shopping_cart_link").click();

// Пауза 5 секунд для визуальной проверки
        Selenide.sleep(5000);

// Скриншот (сохранится в build/reports/tests)
        Selenide.screenshot("cart_with_items");

        int itemsCount = $$(".cart_item").size();
        assertEquals(3, itemsCount, "В корзине не 3 товара!");

    }
}