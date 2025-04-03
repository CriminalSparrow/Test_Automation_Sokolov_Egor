package tests.features;

import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.PhotosPage;
import data.TestData;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("Features")
public class PhotosTest {
    private PhotosPage photoPage;

    @BeforeAll // Перед всеми тестами, которые будут использовать страницу photoPage, откроем её
    void setup() {
        photoPage = new LoginPage()
                .open()
                .enterEmail(TestData.LOGIN)
                .enterPassword(TestData.PASSWORD)
                .clickLoginSuccess()
                .clickPhotos();
    }

    @AfterEach // После каждого теста удаляем фото, если оно было добавлено
    void cleanup() {
        photoPage.deletePhotoIfExists();
    }

    @Test
    @DisplayName("Добавление фото")
    @Timeout(10) // Провалим тест, если добавление фотки занимает неприлично много времени
    void addPhoto() {
        photoPage.uploadPhoto(TestData.PHOTO_PATH)
                .verifyPhotoIsUploaded();
    }

    @Disabled
    @Test
    @DisplayName("Удаление фото")
    @Timeout(10)
    void deletePhoto() {
        // Добавляем фото
        photoPage.uploadPhoto(TestData.PHOTO_PATH)
                .verifyPhotoIsUploaded();

        // Затем удаляем фото
        //photoPage.deletePhotoIfExists().verifyPhotoIsDeleted(); (Не написан ещё)
    }
}