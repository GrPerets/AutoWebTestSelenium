package com.grperets.autowebtestselenium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;

@Slf4j
public class FirstTestWithSelenium {

    private static ChromeDriverService service;
    private static WebDriver webDriver;
    private static final String PATH_CHROMEDRIVER = "C://Users//grperets//IdeaProjects//chromedriver.exe";


    @BeforeAll
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(PATH_CHROMEDRIVER))
                .usingAnyFreePort()
                .build();
        service.start();
        log.info("Built service.");
    }

    @AfterAll
    public static void stopService() {
        service.stop();
        log.info("Stoped service.");
    }

    @BeforeEach
    public void createDriver() {
        webDriver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
        log.info("Started Google Chrome.");
    }

    @AfterEach
    public void quitDriver() {
        webDriver.quit();
        log.info("Quited driver.");
    }


    @Test
    public void firstTest(){
        webDriver.get("https://google.com");

        WebElement input = webDriver.findElement(By.xpath("//a[@class=\"gb_4 gb_5 gb_be gb_5c\"]"));
        //input.sendKeys("Погода");
        input.click();
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        log.info("Opened Google.com.");
    }

    @Test
    public void secondTest(){
        webDriver.get("https://google.com");

        WebElement input = webDriver.findElement(By.xpath("//a[@class=\"gb_4 gb_5 gb_be gb_5c\"]"));
        //input.sendKeys("Погода");
        input.click();
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        log.info("Opened Google.com.");
    }

}
