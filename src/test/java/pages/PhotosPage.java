package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;
import java.io.File;
import com.codeborne.selenide.SelenideElement;


public class PhotosPage {
    private final SelenideElement uploadInput = $x("//input[@aria-label='Добавить фото']");
    private final SelenideElement photoCountElement = $x("//div[@class='stream-count-photo__f3a42']");

    public void uploadPhoto(String filePath) {
        int OldCount = getPhotoCount();
        uploadInput.uploadFile(new File(filePath));
        photoCountElement.shouldHave(text(String.valueOf(OldCount + 1))); // Оно тут добавляет ожидание загрузки, проверяя счётчик
    }

    public int getPhotoCount() {
        photoCountElement.shouldBe(visible.because("Счётчик фото должен быть виден"));
        return Integer.parseInt(photoCountElement.getText());
    }
}
