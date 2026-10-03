import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginTest {

    @BeforeEach
    public void openLoginPage() {
        open(TestConfig.BASE_URL);
    }

    @Test
    public void successfulLoginTest() {
        LoginSteps.loginAsStandardUser();

        $(".title").shouldHave(text("Products"));
    }
}