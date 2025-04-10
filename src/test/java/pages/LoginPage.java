package pages;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {

    private final SelenideElement emailField = $x("//input[@id='field_email']");
    private final SelenideElement passwordField = $x("//input[@id='field_password']");
    private final SelenideElement loginButton = $x("//input[@value='Войти в Одноклассники']");
    private final SelenideElement errorMessage = $x("//div[contains(@class, 'login_error')]");

    // Проверяем видимость кнопки ввода Email и вводим Email
    public LoginPage enterEmail(String email) {
        emailField.shouldBe(visible.because("Поле Email должно быть видно")).setValue(email);
        return this;
    }

    // Проверяем видимость кнопки ввода пароля и вводим пароль
    public LoginPage enterPassword(String password) {
        passwordField.shouldBe(visible.because("Поле пароля должно быть видно")).setValue(password);
        return this;
    }

    // Проверяем видимость кнопки входа и входим
    public MainPage clickLoginSuccess() {
        loginButton.shouldBe(visible.because("Кнопка входа должна быть видна")).click();
        return new MainPage();
    }

    // Проверяем видимость кнопки входа, входим, но претерпеваем неудачу
    public LoginPage clickLoginFail() {
        loginButton.shouldBe(visible.because("Кнопка входа должна быть видна")).click();
        return this;
    }

    // Проверяем видимость сообщения об ошибке входа и возвращаем её текст
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible.because("Сообщение об ошибке должно быть видно")).getText();
    }
}