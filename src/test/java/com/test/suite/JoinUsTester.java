/**
 * This class contains a series of test methods for verifying the functionality and behavior 
 * of the "Join Us" page on the House of Test website. It utilizes Selenium WebDriver for browser 
 * automation and TestNG for test execution.
 * 
 * The class includes methods to perform the following tasks:
 * 1. Set up the WebDriver instance and navigate to the base URL before running tests.
 * 2. Test the "Join Us" page by locating and printing the content of a specific element on the page.
 * 3. Scroll down the page at a specified speed using a custom utility class.
 * 4. Close the WebDriver instance after the test suite has completed.
 * 
 * Example Usage:
 * To execute these tests, create a test suite XML file and include this class in the suite. 
 * Ensure that the WebDriverSingleton class is used to manage the WebDriver instance.
 * 
 * @author Yassin ben Khalifa
 * @version 1.0
 * @since 2023-11-02
 */
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

import Singleton.WebDriverSingleton;

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
