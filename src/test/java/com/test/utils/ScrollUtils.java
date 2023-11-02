/**
 * This utility class provides methods for scrolling down a web page using JavaScript 
 * in a WebDriver-based Selenium automation framework. It allows for controlled scrolling 
 * at a specified speed and distance.
 * 
 * The class is designed to be used in conjunction with WebDriver for automating scrolling 
 * actions in test scripts.
 * 
 * Example Usage:
 * To use this class for scrolling in your test scripts, create an instance of ScrollUtils 
 * and call the `scrollDownWithSpeed` method with the desired scroll speed and total scroll distance.
 * 
 * Author: Yassin ben Khalifa
 * Version: 1.0
 * Since: 2023-11-02
 */
package com.test.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollUtils {
    private WebDriver driver;

    /**
     * Initializes the ScrollUtils with the WebDriver instance.
     *
     * @param driver The WebDriver instance to use for scrolling.
     */
    public ScrollUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Scrolls down the page with a specified speed and total scroll distance.
     *
     * @param scrollSpeed       The speed of scrolling.
     * @param totalScrollDistance The total distance to scroll.
     */
    public void scrollDownWithSpeed(int scrollSpeed, int totalScrollDistance) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < totalScrollDistance; i += scrollSpeed) {
            js.executeScript("window.scrollBy(0, " + scrollSpeed + ");");
            try {
                Thread.sleep(100); // Adjust this sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
