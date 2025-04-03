package pages;

import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;

public class MainPage {
    // Локаторы
    private final SelenideElement userName = $x("//div[@class='toolbar_accounts-user_name']");
    private final SelenideElement dropdownButton = $x("//button[@aria-label='Настройки профиля']");
    private final SelenideElement photosButton = $x("//a[@data-l='t,userPhotos']");
    // Метод для проверки имени
    public void verifyUserName(String expectedName) {
        // Кликаем по кнопке, чтобы раскрыть меню, чтоб сделать userName видимым
        dropdownButton.click();

        userName
                .shouldBe(visible)
                .shouldHave(text(expectedName)); // Проверка точного совпадения UserName
    }

    // Перейти на Фото
    public PhotosPage clickPhotos() {
        photosButton.click();
        return new PhotosPage();
    }
}