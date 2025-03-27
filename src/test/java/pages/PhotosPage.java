package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;
import java.io.File;
import com.codeborne.selenide.SelenideElement;

public class PhotosPage {

    // Локаторы
    private final SelenideElement uploadInput = $x("//input[@aria-label='Добавить фото']");
    private final SelenideElement photoCountElement = $(".stream-count-photo__f3a42");
    int oldCount = Integer.parseInt(photoCountElement.getText());

    public PhotosPage uploadPhoto(String filePath) {
        uploadInput.uploadFile(new File(filePath));  // Загружаем файл
        return this;  // Поддержка цепочки вызовов
    }

    public void verifyPhotoIsUploaded() {
        photoCountElement.shouldHave(text(String.valueOf(oldCount + 1)));
    }

}
