import static com.codeborne.selenide.Selenide.$;

public class LoginSteps {

    public static void login(String username, String password) {
        $("[data-test='username']").setValue(username);
        $("[data-test='password']").setValue(password);
        $("[data-test='login-button']").click();
    }

    public static void loginAsStandardUser() {
        login(TestConfig.STANDARD_USER, TestConfig.STANDARD_PASSWORD);
    }
    public static void loginAsWrongUser() {
        login(TestConfig.WRONG_USER, TestConfig.STANDARD_PASSWORD);
    }
    public static void loginWithWrongPassword() {
        login(TestConfig.STANDARD_USER, TestConfig.WRONG_PASSWORD);
    }
}