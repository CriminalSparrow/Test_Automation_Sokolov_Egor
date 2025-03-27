package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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

    // Нажатие кнопки "Войти"
    public MainPage clickLogin() {
        loginButton.click();
        return new MainPage();
    }

    // Комбинированный метод для быстрого входа
    public MainPage login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
        return new MainPage();
    }
}
