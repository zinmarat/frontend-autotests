import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BurgerMenuTest {

    @BeforeAll
    public static void setup() {
        Configuration.timeout = TestConfig.TIMEOUT;
    }

    @BeforeEach
    public void openLoginPage() {
        open(TestConfig.BASE_URL);
    }

    @Test
    public void burgerWorkingTest() {
        LoginSteps.loginAsStandardUser();

        $("#react-burger-menu-btn").click();
        $(".bm-menu-wrap").shouldHave(attribute("aria-hidden", "false"));

        $("body").pressEscape();
        $(".bm-menu-wrap").shouldHave(attribute("aria-hidden", "true"));
    }
}