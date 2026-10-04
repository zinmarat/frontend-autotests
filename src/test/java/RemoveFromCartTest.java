import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RemoveFromCartTest {

    @BeforeEach
    public void openPage() {
        open(TestConfig.BASE_URL);
        LoginSteps.loginAsStandardUser();
    }

    @Test
    public void removeFromCartTest() {
        // 1. добавить товар
        $("#add-to-cart-sauce-labs-bolt-t-shirt").click();

        // 2. проверить бейдж
        $("[data-test='shopping-cart-badge']").shouldHave(text("1"));

        // 3. перейти в корзину
        $("[data-test='shopping-cart-link']").click();

        // 4. удалить
        $("#remove-sauce-labs-bolt-t-shirt").click();

        // 5. проверить, что бейдж пропал
        $("[data-test='shopping-cart-badge']").shouldNot(exist);
    }
}