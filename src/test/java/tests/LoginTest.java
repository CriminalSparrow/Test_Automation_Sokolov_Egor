package tests;

import pages.LoginPage;
import org.junit.jupiter.api.Test;


public class LoginTest {
    private static final String NAME = "Тест Тестов";
    private static final String LOGIN = "79936402680";
    private static final String PASSWORD = "testtesttest";
    private static final String LoginErrorMessage = "Неправильно указан логин и/или пароль";

    public static String getLogin() {
        return LOGIN;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.open()
                .enterEmail(LOGIN)
                .enterPassword(PASSWORD)
                .clickLoginSuccess()
                .verifyUserName(NAME);

    }

    @Test
    public void testFailedLogin() {
        new LoginPage().open()
                .enterEmail(LOGIN)
                .enterPassword("wrongpassword")
                .clickLoginFail()
                .verifyErrorMessage(LoginErrorMessage);
    }
}