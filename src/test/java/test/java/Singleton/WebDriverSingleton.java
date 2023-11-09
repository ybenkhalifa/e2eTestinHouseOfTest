
package test.java.Singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
/**
 * This class is responsible for managing a singleton instance of the WebDriver for Selenium tests.
 * It ensures that only one WebDriver instance is created and shared among test classes, 
 * enhancing test execution efficiency and reducing resource usage.
 * 
 * The class uses Google Chrome as the default browser, and it provides a method to obtain the 
 * WebDriver instance. Additionally, it includes an @AfterSuite method to automatically close 
 * and quit the WebDriver after the test suite has completed.
 * 
 * To use this class, simply call the 'getDriver()' method to retrieve the WebDriver instance in 
 * your test classes.
 * 
 * Example Usage:
 * WebDriver driver = WebDriverSingleton.getDriver();
 * driver.get("https://example.com");
 * // Perform test actions
 * 
 * Author: Yassin ben Khalifa
 * Version: 1.0
 * Since: 2023-11-02
 */


public class WebDriverSingleton {
    private static WebDriver driver;

    // Private constructor to prevent external instantiation
    public WebDriverSingleton() {
    }

    /**
     * Get the WebDriver instance.
     * If the instance doesn't exist, create a new one.
     *
     * @return The WebDriver instance.
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
        return driver;
    }
    
    /**
     * Close and quit the WebDriver after the test suite has completed.
     */
    @AfterSuite
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
