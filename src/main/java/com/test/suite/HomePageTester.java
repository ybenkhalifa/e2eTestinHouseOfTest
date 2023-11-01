package com.test.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.utils.ScrollUtils;

public class HomePageTester {

    private WebDriver driver;
    private String baseUrl = "https://www.houseoftest.ch/";
    private ScrollUtils scrollUtils;
    @BeforeTest
    public void setUp() {
        // Get the WebDriver instance from the Singleton class
        driver = WebDriverSingleton.getDriver();
        scrollUtils = new ScrollUtils(driver);
        // Navigate to the page
        driver.get(baseUrl);
    }

    @Test
    public void testHomePage() {
        // Find the element containing the "Rebels" text
        WebElement welcomeElement = driver.findElement(By.xpath("//*[contains(text(),'Rebels')]"));

        // Assert that the "Rebels" text is present on the page
        Assert.assertTrue(welcomeElement.isDisplayed(), "The home page is not displayed");
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
