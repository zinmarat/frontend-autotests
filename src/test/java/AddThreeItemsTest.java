import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.size;

public class AddThreeItemsTest {

    @BeforeAll
    public static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = TestConfig.TIMEOUT;
        Configuration.headless = Boolean.parseBoolean(
                System.getProperty("headless", "false"));
    }

    @BeforeEach
    public void login() {
        open(TestConfig.BASE_URL);
        $("#user-name").setValue(TestConfig.STANDARD_USER);
        $("#password").setValue(TestConfig.STANDARD_PASSWORD);
        $("#login-button").click();
        $(".inventory_list").shouldBe(visible);   // дождались логина
    }

    @Test
    public void addThreeItemsTest() {
        // Стабильные селекторы через data-test (SauceDemo их поддерживает)
        $("[data-test='add-to-cart-sauce-labs-backpack']").click();
        $("[data-test='add-to-cart-sauce-labs-bike-light']").click();
        $("[data-test='add-to-cart-sauce-labs-bolt-t-shirt']").click();

        $(".shopping_cart_badge").shouldHave(text("3"));

        $(".shopping_cart_link").click();

        // Умное ожидание: 3 товара в корзине
        $$(".cart_item").shouldHave(size(3));

        Selenide.screenshot("cart_with_items");
    }
}