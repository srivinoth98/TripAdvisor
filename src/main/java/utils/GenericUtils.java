package utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.DriverSetUp;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class GenericUtils extends DriverSetUp {

    public static final long IMPLICIT_WAIT = 20;
    public static final long PAGE_LOAD_WAIT = 20;
    public static final long EXPLICIT_WAIT = 20;

    public static void waitUntilElementToBeClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void iterateElement(List<WebElement> elements, String productName) {

        for (WebElement e : elements) {
            if (e.getText().equalsIgnoreCase(productName)) {
                e.click();
                break;
            }
        }
    }

    public static void scrollDownByPixel() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,10000)");

    }

    public static void getWindowHandle() {
        String parentId = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        for (String s : allWindow) {
            if (!parentId.contentEquals(s)) {
                driver.switchTo().window(s);
                driver.close();
            }
            driver.switchTo().window(parentId);
        }
    }
}




