package ru.magic3000.homework5;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SelenideExample {
    private static Logger logger = LoggerFactory.getLogger(SelenideExample.class);

    @BeforeClass
    void init() {
        Configuration.baseUrl = "https://www.simbirsoft.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 30000;
    }

    @Test
    public void test1() {
        open(Configuration.baseUrl);
        logger.info("Opened url " + Configuration.baseUrl);
        $(By.className("gh-tools-lang"))
                .shouldBe(visible)
                .shouldHave(text("EN"))
                .click();
        logger.info("\"EN\" clicked");
        sleep(5000);
    }

    @Test
    public void test2() {
        open(Configuration.baseUrl);
        logger.info("Opened url " + Configuration.baseUrl);
        $(By.xpath("//*[contains(@class,'gh-nav-item--services')]"))
                .shouldHave(text("Услуги"))
                .hover();
        logger.info("\"Услуги\" clicked");
        $(By.linkText("Аутстаффинг IT-специалистов"))
                .shouldHave(text("Аутстаффинг IT-специалистов"))
                .click();
        logger.info("\"Аутстаффинг IT-специалистов\" clicked");
        $(By.xpath("//h1"))
                .shouldHave(text("Аутстаффинг* IT‑специалистов"))
                .shouldBe(visible);
        logger.info("Header 1 found");
        webdriver().shouldHave(url(Configuration.baseUrl + "help/outstaffing/"));
        logger.info("\"Outstaffing\" url found");
        sleep(5000);
    }

    @Test
    public void test3() {
        open("https://vk.com/");
        logger.info("Opened url \"https://vk.com/\"");
        $(By.className("login_all_products_button"))
                .shouldBe(visible)
                .shouldHave(text("All products"))
                .click();
        logger.info("\"All products\" clicked");
        $(By.xpath("//h1"))
                .shouldHave(text("VK"))
                .shouldBe(visible);
        logger.info("\"VK\" text found");
        webdriver().shouldHave(url("https://vk.com/products"));
        logger.info("\"Products\" url found");
        $(By.className("AppStoreLink"))
                .shouldBe(visible)
                .shouldHave(attribute("href", "https://itunes.apple.com/app/id564177498"))
                .click();
        logger.info("Href attribute found");
        sleep(5000);
    }
}
