package pages;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;

public class MainPage {
    // Локаторы
    private final SelenideElement userName = $("div.toolbar_accounts-user_name");
    private final SelenideElement dropdownButton = $("#hook_Block_ToolbarUserDropdown > div > button");
    private final SelenideElement photosButton = $("#hook_Block_Navigation > div > div > div:nth-child(5) > a");

    // Метод для проверки имени
    public void verifyUserName(String expectedName) {
        // Кликаем по кнопке, чтобы раскрыть меню, чтоб сделать userName видимым
        dropdownButton.click();

        userName
                .shouldBe(visible)
                .shouldHave(text(expectedName)); // Проверка точного совпадения
    }

    // Перейти на Фото
    public PhotosPage clickPhotos() {
        photosButton.click();
        return new PhotosPage();
    }
}