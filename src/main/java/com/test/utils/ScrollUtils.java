package com.test.utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollUtils {
    private WebDriver driver;

    public ScrollUtils(WebDriver driver) {
        this.driver = driver;
    }

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
