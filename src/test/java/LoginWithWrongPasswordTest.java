import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginWithWrongPasswordTest {
        @BeforeEach
        public void openLoginPage() {
            open("https://www.saucedemo.com/");
        }

        @Test
        public void login() {
          $("[data-test='username']").setValue("standard_user");
          $("[data-test='password']").setValue("wrongPassword");
          $("[data-test='login-button']").click();
          $("[data-test='error']").shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
        }
    }
