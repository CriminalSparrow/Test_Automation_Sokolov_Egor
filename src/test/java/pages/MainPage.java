package pages;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;

public class MainPage {
    // Локатор элемента с именем пользователя
    private final SelenideElement userName = $("div.toolbar_accounts-user_name");
    private final SelenideElement dropdownButton = $("#hook_Block_ToolbarUserDropdown > div > button");

    // Метод для проверки имени
    public MainPage verifyUserName(String expectedName) {
        // Кликаем по кнопке, чтобы раскрыть меню, чтоб сделать userName видимым
        dropdownButton.click();

        userName
                .shouldBe(visible)
                .shouldHave(text(expectedName)); // Проверка точного совпадения
        return this; // Для поддержки цепочки вызовов
    }
}