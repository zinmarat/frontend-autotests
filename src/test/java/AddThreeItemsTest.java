import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

public class AddMultipleItemsTest {

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
    }

    @Test
    public void addThreeItemsTest() {
        // Логин уже выполнен в @BeforeEach!
        // Сразу работаем с товарами
        $$(".btn_inventory").first().click();
        $$(".btn_inventory").get(2).click();
        $$(".btn_inventory").last().click();

        $(".shopping_cart_badge").shouldHave(text("3"));
        $(".shopping_cart_link").click();

        int itemsCount = $$(".cart_item").size();
        assertEquals(3, itemsCount, "В корзине не 3 товара!");

        System.out.println("✅ В корзине товаров: " + itemsCount);
    }

    @Test
    public void addOneItemTest() {
        // Логин снова выполнен автоматически
        $$(".btn_inventory").first().click();
        $(".shopping_cart_badge").shouldHave(text("1"));
    }
}