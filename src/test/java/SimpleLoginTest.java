import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SimpleLoginTest {

    @BeforeEach
    public void openLoginPage() {
        open("https://www.saucedemo.com/");
    }

    @Test
    public void login() {
        $("[data-test='username']").setValue("standard_user");
        $("[data-test='password']").setValue("secret_sauce");
        $("[data-test='login-button']").click();
        $("[data-test='inventory-container']").shouldBe(visible);
    }
}