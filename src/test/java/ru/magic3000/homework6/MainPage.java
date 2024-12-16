package ru.magic3000.homework6;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy(xpath = "//*[contains(@class,'gh-nav-item--services')]")
    private SelenideElement navItemServices;

    @Step("Проверить, что при наведении на элемент меню Услуги появляется ссылка Аутстаффинг IT-специалистов")
    public OutstaffPage goToOutstaff() {
        navItemServices
                .shouldHave(text("Услуги"))
                .hover();
        $(By.linkText("Аутстаффинг IT-специалистов"))
                .shouldHave(text("Аутстаффинг IT-специалистов"))
                .click();
        return page(OutstaffPage.class);
    }
}
