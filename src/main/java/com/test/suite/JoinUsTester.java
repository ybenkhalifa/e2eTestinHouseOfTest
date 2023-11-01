package com.test.suite;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.utils.ScrollUtils;

public class JoinUsTester {
    private WebDriver driver;
    private String baseUrl = "https://www.houseoftest.ch/";
    private String serviceTitleLocator = "h1.display";
    private String itemSegment = "join-us";
    private String loggingMsg = "****************Our locator  is working well! here is the extracted content:   ";
    private ScrollUtils scrollUtils;
    @BeforeTest
    public void setUp() {
        // Get the WebDriver instance from the Singleton class
        driver = WebDriverSingleton.getDriver();

        // Navigate to the page
        driver.get(baseUrl);
        scrollUtils = new ScrollUtils(driver);
    }

    @Test
    public void testJoinUsPage() {
        driver.get(baseUrl + itemSegment);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cssElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(serviceTitleLocator)));
        System.out.print(loggingMsg + cssElement.getText() + " ***\n\n");
    }
    @Test
    public void scrollDownPageWithSpeed() {
        int scrollSpeed = 200; // Increase or decrease this value for faster or slower scrolling
        int totalScrollDistance = 1000; // Adjust this value as needed

        scrollUtils.scrollDownWithSpeed(scrollSpeed, totalScrollDistance);
    }


    @AfterTest
    public void tearDown() {
        // Close the browser using the instance's closeDriver() method
        WebDriverSingleton webDriverSingleton = new WebDriverSingleton();
        webDriverSingleton.closeDriver();
    }
}
