import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.beans.Transient;
import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Messages {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;

    @BeforeClass
    public static void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://www.reddit.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time

        // Click login shortcut
        WebElement loginShortcut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login-button']")));
        loginShortcut.click();

        // Enter username
        WebElement loginUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login-username']")));
        loginUsername.sendKeys("Perfect-Tourist-9337");
        Thread.sleep(1000);

        // Enter password
        WebElement loginPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login-password']")));
        loginPassword.sendKeys("reddit1234***");
        Thread.sleep(1000);
        loginPassword.sendKeys(Keys.ENTER);
    }

    @Test(priority = 35)
    void checkInbox() throws InterruptedException {
        Thread.sleep(2000);
        try {
            WebElement inbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("header-action-item-chat-button")));
            inbox.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(5000);
        driver.navigate().back();
    }

    @Test(priority = 36)
    void minimize() throws InterruptedException {
        driver.get("https://www.reddit.com/");
        Thread.sleep(2000);
        for(int i = 0; i < 14; i++) {
            // Perform Shift + Tab
            actions.sendKeys(Keys.TAB).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        WebElement inbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("header-action-item-chat-button")));
        inbox.click();
        Thread.sleep(5000);
        for(int i = 0; i < 7; i++) {
            // Perform Shift + Tab
            actions.sendKeys(Keys.TAB).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
    }

    @Test(priority = 37)
    void maximize() throws InterruptedException {
        driver.get("https://www.reddit.com/");
        Thread.sleep(2000);
        for(int i = 0; i < 9; i++) {
            // Perform Shift + Tab
            actions.sendKeys(Keys.TAB).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
    }

    @Test(priority = 38)
    void popout() throws InterruptedException {
        driver.get("https://www.reddit.com/");
        Thread.sleep(2000);
        for(int i = 0; i < 14; i++) {
            // Perform Shift + Tab
            actions.sendKeys(Keys.TAB).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        WebElement inbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("header-action-item-chat-button")));
        inbox.click();
        Thread.sleep(5000);

        for(int i = 0; i < 8; i++) {
            // Perform Shift + Tab
            actions.sendKeys(Keys.TAB).perform();
        }

        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);

        // Store the current window handle
        String originalWindow = driver.getWindowHandle();

        // Switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Close the new tab
        driver.close();

        // Switch back to the original tab
        driver.switchTo().window(originalWindow);
        Thread.sleep(1000);
    }

    @Test(priority = 39)
    void newChat() throws InterruptedException {
        driver.get("https://www.reddit.com/");
        Thread.sleep(2000);
        for(int i = 0; i < 14; i++) {
            // Perform Shift + Tab
            actions.sendKeys(Keys.TAB).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        WebElement inbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("header-action-item-chat-button")));
        inbox.click();
        Thread.sleep(5000);

        for(int i = 0; i < 4; i++) {
            // Perform Shift + Tab
            actions.sendKeys(Keys.TAB).perform();
        }

        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        actions.sendKeys("MrStuffsalot").perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        actions.sendKeys("test").perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);
    }


    @Test(priority = 40)
    void options() throws InterruptedException {
        driver.get("https://www.reddit.com/");
        Thread.sleep(2000);
        for(int i = 0; i < 3; i++){
            // Perform Shift + Tab
            actions.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
        }

        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        WebElement inbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("header-action-item-chat-button")));
        inbox.click();
        Thread.sleep(5000);

        for(int i = 0; i < 6; i++){
            // Perform Shift + Tab
            actions.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
        }

        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @Test(priority = 41)
    void closeInbox() throws InterruptedException {
        driver.get("https://www.reddit.com/");
        Thread.sleep(5000);
        for(int i = 0; i < 14; i++) {
            // Perform Shift + Tab
            actions.sendKeys(Keys.TAB).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
    }

    @AfterClass
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
