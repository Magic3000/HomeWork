package ru.magic3000.homework6;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

/**
 * Базовый класс тестов.
 */
public class BaseTest {

    @BeforeClass
    void initBeforeClass() {
        Configuration.baseUrl = "https://www.simbirsoft.com";
        Configuration.browserSize = "1920x2100";
        Configuration.timeout = 30000;
    }
}
