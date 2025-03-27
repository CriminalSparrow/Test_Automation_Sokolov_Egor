package tests;

import pages.PhotosPage;
import pages.LoginPage;
import org.junit.jupiter.api.Test;



public class AddPhotoTest {


    @Test
    public void SuccessfullAddPhoto() {
        PhotosPage photoPage = new LoginPage()
                .open()
                .enterEmail(LoginTest.getLogin())
                .enterPassword(LoginTest.getPassword())
                .clickLoginSuccess()
                .clickPhotos();


        photoPage.uploadPhoto("src/test/resources/kinder.jpeg")
                .verifyPhotoIsUploaded();
    }
}