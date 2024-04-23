package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import configs.UserConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProfilePage {
    UserConfig userConfig = ConfigFactory.create(UserConfig.class);
    private ElementsCollection listCells = $$("[role=gridcell]");
    private SelenideElement emptyMessage = $(".rt-noData"),
    userName = $("#userName-value");


    @Step("Открыть страницу профиля")
    public ProfilePage openPage() {
        open("/profile");
        userName.shouldHave(Condition.text(userConfig.userName()));
        return this;
    }

    @Step("Проверка, что список книг в профиле пуст")
    public ProfilePage checkEmptyList() {
        for (SelenideElement cell : listCells) {
            cell.shouldHave(Condition.empty);
        }
        return this;
    }

    @Step("Проверка текста сообщения о пустом списке книг")
    public ProfilePage checkEmptyListMessage() {
        emptyMessage.shouldHave(text("No rows found"));
        return this;
    }
}
