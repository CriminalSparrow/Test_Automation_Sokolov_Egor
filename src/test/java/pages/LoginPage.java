package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {

    // Url
    private final String URL = "https://ok.ru";
    // Локаторы элементов страницы
    private final SelenideElement emailField = $("#field_email");
    private final SelenideElement passwordField = $("#field_password");
    private final SelenideElement loginButton = $x("//input[@value='Войти в Одноклассники']");

    // Открытие страницы логина
    public LoginPage open() {
        Selenide.open(URL);
        return this;
    }

    // Ввод email
    public LoginPage enterEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    // Ввод пароля
    public LoginPage enterPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    // Успешное нажатие кнопки "Войти"
    public MainPage clickLoginSuccess() {
        loginButton.click();
        return new MainPage();
    }

    // Неуспешное нажатие кнопки "Войти"
    public LoginPage clickLoginFail() {
        loginButton.click();
        return this;
    }

    public void verifyErrorMessage(String LoginErrorMessage) {
        final SelenideElement FoundLoginErrorMessage = $x("//div[contains(@class, 'login_error')]");
        FoundLoginErrorMessage
                .shouldBe(visible)
                .shouldHave(text(LoginErrorMessage)); // Проверка точного совпадения
    }
}
