/**
 * This class contains a series of test methods for verifying the functionality and behavior 
 * of the services page on the House of Test website. It utilizes Selenium WebDriver for browser 
 * automation and TestNG for test execution.
 * 
 * The class includes methods to perform the following tasks:
 * 1. Set up the WebDriver instance and navigate to the base URL before running tests.
 * 2. Test the service page by locating and printing the content of a specific element on the page.
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
package test.java.com.test.suite;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.com.test.utils.ScrollUtils;

import test.java.Singleton.WebDriverSingleton;

public class ServiceTester {
    private WebDriver driver;
    private String baseUrl = "https://www.houseoftest.ch/";
    private String serviceTitleLocator = "h1.display";
    private String itemSegment = "services";
    private String loggingMsg = "****************Our locator is working well! Here is the extracted content: ";
    private ScrollUtils scrollUtils;

    /**
     * Sets up the WebDriver instance and navigates to the base URL before running tests.
     */
    @BeforeTest
    public void setUp() {
        // Get the WebDriver instance from the Singleton class
        driver = WebDriverSingleton.getDriver();
        scrollUtils = new ScrollUtils(driver);
        // Navigate to the page
        driver.get(baseUrl);
    }

    /**
     * Tests the service page by locating and printing the content of a specific element on the page.
     */
    @Test
    public void testServicePage() {
        driver.get(baseUrl + itemSegment);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cssElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(serviceTitleLocator)));
        System.out.print(loggingMsg + cssElement.getText() + " \n\n");
    }
    
    /**
     * Scrolls down the page at a specified speed.
     */
    @Test
    public void scrollDownPageWithSpeed() {
        int scrollSpeed = 200; // Increase or decrease this value for faster or slower scrolling
        int totalScrollDistance = 1000; // Adjust this value as needed

        scrollUtils.scrollDownWithSpeed(scrollSpeed, totalScrollDistance);
    }

    /**
     * Closes the WebDriver instance after the test suite has completed.
     */
    @AfterTest
    public void tearDown() {
        // Close the browser using the instance's closeDriver() method
        WebDriverSingleton webDriverSingleton = new WebDriverSingleton();
        webDriverSingleton.closeDriver();
    }
}
