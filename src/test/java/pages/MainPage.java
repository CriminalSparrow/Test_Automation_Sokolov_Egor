package pages;

import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;

public class MainPage {

    // Локаторы
    private final SelenideElement userName = $x("//div[@class='toolbar_accounts-user_name']");
    private final SelenideElement dropdownButton = $x("//button[@aria-label='Настройки профиля']");
    private final SelenideElement photosButton = $x("//a[@data-l='t,userPhotos']");

    // Получение имени пользователя после открытия выпадающей менюшки
    public String getUserName() {
        dropdownButton
                .shouldBe(visible.because("Кнопка раскрытия меню профиля должна быть видимой"))
                .click();

        return userName
                .shouldBe(visible.because("Имя пользователя должно быть видимым после открытия меню"))
                .getText();
    }

    // Переход на страницу фотографий
    public PhotosPage clickPhotos() {
        photosButton
                .shouldBe(visible.because("Кнопка перехода к фотографиям должна быть видимой"))
                .click();
        return new PhotosPage();
    }
}