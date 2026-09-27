public class TestConfig {

    // 🌐 URL сайта
    public static final String BASE_URL = "https://www.saucedemo.com";

    // 👤 Тестовые пользователи
    public static final String STANDARD_USER = "standard_user";
    public static final String STANDARD_PASSWORD = "secret_sauce";
    public static final String WRONG_PASSWORD = "wrong_password";

    // ⏱ Таймауты
    public static final int TIMEOUT = 10000;

    // 🔒 Приватный конструктор — чтобы никто не создавал объекты этого класса
    private TestConfig() {
    }
}