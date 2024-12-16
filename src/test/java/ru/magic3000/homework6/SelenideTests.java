package ru.magic3000.homework6;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTests extends BaseTest {

    @BeforeMethod
    void initBeforeMethod() {
        open("/");
    }

    @Test(description = "Open OutStaff page")
    public void openOutStaffPageTest() {
        page(MainPage.class)
                .goToOutstaff()
                .checkOutstuffingPageIsOpen()
                .showRequestModal()
                .checkModalWindowVisible()
                .checkTextInput();

        sleep(5000);
    }
}
