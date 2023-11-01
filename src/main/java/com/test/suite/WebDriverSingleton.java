package com.test.suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class WebDriverSingleton {
    private static WebDriver driver;

    // Private constructor to prevent external instantiation
    public WebDriverSingleton() {
    }

    // Method to get the WebDriver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
    
    // Method to close and quit the WebDriver
    @AfterSuite
    public  void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
