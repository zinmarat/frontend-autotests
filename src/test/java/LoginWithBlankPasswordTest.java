import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginWithBlankPasswordTest {
    @BeforeEach
    public void openLoginPage() {
        open(TestConfig.BASE_URL);
    }

    @Test
    public void login() {
        $("[data-test='username']").setValue(TestConfig.STANDARD_USER);
        $("[data-test='password']").setValue(TestConfig.EMPTY);
        $("[data-test='login-button']").click();
        $("[data-test='error']").shouldHave(text("Epic sadface: Password is required"));
    }
}
