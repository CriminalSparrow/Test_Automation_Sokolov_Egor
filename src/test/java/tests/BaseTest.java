package tests;

import data.TestData;
import org.junit.jupiter.api.*;
import com.codeborne.selenide.Selenide;

public abstract class BaseTest {

    // Открываем сайт перед началом каждого теста
    @BeforeEach
    void openBaseUrl() {
        Selenide.open(TestData.BASE_URL);
    }
}
