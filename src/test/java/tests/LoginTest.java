package tests;

import pages.LoginPage;
import org.junit.jupiter.api.Test;


public class LoginTest {
    private final String NAME = "Тест Тестов";
    private final String LOGIN = "79936402680";
    private final String PASSWORD = "testtesttest";

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.open()
                .enterEmail(LOGIN)
                .enterPassword(PASSWORD)
                .clickLogin()
                .verifyUserName(NAME);

    }
}