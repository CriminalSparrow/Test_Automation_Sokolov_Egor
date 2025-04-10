package tests.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import data.TestData;
import tests.BaseTest;

import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("Auth")
public class LoginTest extends BaseTest {
    private static final List<String> WRONG_PASSWORDS = List.of("wrongpassword", "123456");
    private LoginPage loginPage;

    static Stream<String> passwordProvider() {
        return WRONG_PASSWORDS.stream();
    }

    @BeforeEach
    void init() {
        loginPage = new LoginPage();
    }

    @Test
    @DisplayName("Успешный вход")
    @Timeout(10)
    void testSuccessfulLogin() {
        String actualUserName = loginPage.enterEmail(TestData.LOGIN)
                .enterPassword(TestData.PASSWORD)
                .clickLoginSuccess()
                .getUserName();

        assertEquals(TestData.NAME, actualUserName, "Имя пользователя не совпадает");
    }

    @ParameterizedTest
    @MethodSource("passwordProvider")
    @DisplayName("Неуспешный вход")
    void testFailedLogin(String wrongPassword) {
        String actualError = loginPage.enterEmail(TestData.LOGIN)
                .enterPassword(wrongPassword)
                .clickLoginFail()
                .getErrorMessageText();

        assertEquals(TestData.LOGIN_ERROR_MESSAGE, actualError, "Сообщение об ошибке при неверном входе не совпадает");
    }

    @AfterEach
    void tearDown() {
        loginPage = null;
    }
}