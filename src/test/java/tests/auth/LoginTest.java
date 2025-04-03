package tests.auth;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LoginPage;
import data.TestData;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("Auth")
public class LoginTest {

    private LoginPage loginPage;

    @BeforeEach
    void setup() {
        loginPage = new LoginPage().open();
    }

    @Test
    @DisplayName("Успешный вход")
    @Timeout(10) // Завершим тест, если зависнем на входе
    void testSuccessfulLogin() {
        loginPage.enterEmail(TestData.LOGIN)
                .enterPassword(TestData.PASSWORD)
                .clickLoginSuccess()
                .verifyUserName(TestData.NAME); // Сверяем UserName на главной странице
    }

    @ParameterizedTest
    @ValueSource(strings = {"wrongpassword", "123456"})
    @DisplayName("Неуспешный вход")
    void testFailedLogin(String wrongPassword) {
        loginPage.enterEmail(TestData.LOGIN)
                .enterPassword(wrongPassword)
                .clickLoginFail()
                .verifyErrorMessage(TestData.LOGIN_ERROR_MESSAGE);
    }

    @AfterEach
    void tearDown() {
        loginPage = null;
    }
}