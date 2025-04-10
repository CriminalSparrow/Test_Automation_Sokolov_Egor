package tests.features;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.PhotosPage;
import data.TestData;
import tests.BaseTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("Features")
public class PhotosTest extends BaseTest {
    private PhotosPage photoPage;

    @BeforeEach
    void init() {
        photoPage = new LoginPage()
                .enterEmail(TestData.LOGIN)
                .enterPassword(TestData.PASSWORD)
                .clickLoginSuccess()
                .clickPhotos();
    }

    @Test
    @DisplayName("Добавление фото")
    @Timeout(10)
    void addPhoto() {
        int oldCount = photoPage.getPhotoCount();

        photoPage.uploadPhoto(TestData.PHOTO_PATH);

        int newCount = photoPage.getPhotoCount();
        assertEquals(oldCount + 1, newCount, "Количество фото должно увеличиться на 1 после загрузки");
    }
}