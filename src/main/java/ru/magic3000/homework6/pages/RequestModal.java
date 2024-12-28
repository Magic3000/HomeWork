package ru.magic3000.homework6.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

/**
 * Класс модального окна заявки.
 */
public class RequestModal {

    final String FEEDBACK_MODAL = "//*[@class='fmo-parent']//*[@class='fb-modal-default']";

    @FindBy(xpath = FEEDBACK_MODAL)
    private SelenideElement feedbackModalWindow;

    @FindBy(xpath = FEEDBACK_MODAL + "//input[@data-clear='text']/../..")
    private SelenideElement textInput;

    /**
     * Проверяет, что модальное окно Оставить заявку отобразилось на странице.
     * @return текущий экземпляр класса
     */
    @Step("Проверить, что модальное окно Оставить заявку отобразилось на странице")
    public RequestModal checkModalWindowVisible() {
        feedbackModalWindow.shouldBe(visible);
        return this;
    }

    /**
     * Проверяет, что текстовое поле присутствует.
     * @return текущий экземпляр класса
     */
    @Step("Проверить, что текстовое поле присутствует")
    public RequestModal checkTextInput() {
        textInput.shouldHave(text("Имя или организация"));
        return this;
    }
}
