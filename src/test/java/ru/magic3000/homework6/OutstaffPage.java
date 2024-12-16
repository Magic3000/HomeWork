package ru.magic3000.homework6;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class OutstaffPage {

    @Step("Проверить, что страница аутстаффинг открылась")
    public OutstaffPage checkOutstuffingPageIsOpen() {
        $(By.xpath("//h1"))
                .shouldHave(text("Аутстаффинг* IT‑специалистов"))
                .shouldBe(visible);
        return this;
    }

    @FindBy(xpath = "//a[@data-gclick='showModalFeedback']")
    private SelenideElement requestButton;

    @Step("Нажать кнопку оставить заявку")
    public RequestModal showRequestModal() {
        requestButton
                .should(exist)
                .shouldBe(visible)
                .click();
        return page(RequestModal.class);
    }
}
