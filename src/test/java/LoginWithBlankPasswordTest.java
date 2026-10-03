import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginWithBlankPasswordTest {
        @BeforeEach
        public void openLoginPage() {
            open("https://www.saucedemo.com/");
        }

        @Test
        public void login() {
          $("[data-test='username']").setValue("standard_user");
          $("[data-test='password']").setValue("");
          $("[data-test='login-button']").click();
          $("[data-test='error']").shouldHave(text("Epic sadface: Password is required"));
        }
    }
