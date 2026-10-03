import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginWithWrongPasswordTest {
        @BeforeEach
        public void openLoginPage() {
            open(TestConfig.BASE_URL);
        }

        @Test
        public void loginWithWrongPasswordTest() {
         LoginSteps.loginWithWrongPassword();
          $("[data-test='error']").shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
        }
    }
