import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginWithWrongLoginTest {
    @BeforeEach
    public void openLoginPage() {
        open(TestConfig.BASE_URL);
    }

    @Test
    public void login() {
        $("[data-test='username']").setValue(TestConfig.WRONG_USER);
        $("[data-test='password']").setValue(TestConfig.STANDARD_PASSWORD);
        $("[data-test='login-button']").click();
        $("[data-test='error']").shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
    }
}
