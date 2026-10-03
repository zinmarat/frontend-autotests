import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginWithBlankLoginTest {
    @BeforeEach
    public void openLoginPage() {
        open(TestConfig.BASE_URL);
    }

    @Test
    public void login() {
        $("[data-test='username']").setValue(TestConfig.EMPTY);
        $("[data-test='password']").setValue(TestConfig.STANDARD_PASSWORD);
        $("[data-test='login-button']").click();
        $("[data-test='error']").shouldHave(text("Epic sadface: Username is required"));
    }
}
