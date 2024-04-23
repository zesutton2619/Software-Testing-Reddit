import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class LoginSignUp {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.reddit.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 24)
    void signUp() throws InterruptedException {
        WebElement loginShortcut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-button\"]")));
        loginShortcut.click();
        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        try {
            // Focus on the body of the page
            actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"login-password\"]"))).click().perform();

            // Execute JavaScript to click the join button
            for(int i = 0; i < 2; i++){
                actions.sendKeys(Keys.TAB).perform();
            }
            actions.sendKeys(Keys.ENTER).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }


        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"register-email\"]")));
        emailInput.sendKeys("burneraccount249902935@gmail.com");

        // Continue
        emailInput.sendKeys(Keys.ENTER);
        Thread.sleep(1000);


        // Change the username
        for(int i = 0; i < 2; i++){
            actions.sendKeys(Keys.TAB).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(500);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("booglywoogly1234*").perform();

        // Captcha. need to manually intervene
        Thread.sleep(45000);
        for(int i = 0; i < 3; i++){
            actions.sendKeys(Keys.TAB).perform();
        }
        Thread.sleep(1000);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        Thread.sleep(1000);
        for(int i = 0; i < 15; i++){
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(500);
        }
        for(int i = 0; i < 2; i++){
            actions.sendKeys(Keys.TAB).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

    }
    //#login > auth-flow-modal > div.w-100 > faceplate-tracker > button

    @Test(priority = 25)
    void incorrectSignUp() throws InterruptedException {
        WebElement loginShortcut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-button\"]")));
        loginShortcut.click();

        WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login\"]/auth-flow-modal/div[1]/div[3]/auth-flow-link")));
        signUpButton.click();

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"register-email\"]")));
        emailInput.sendKeys("asd232rfd@gomsdif");
        emailInput.sendKeys(Keys.ENTER);
    }

    @Test(priority = 26)
    void login() throws InterruptedException {
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
        // Login
        Thread.sleep(1000);
        loginPassword.sendKeys(Keys.ENTER);
    }

    @Test(priority = 27)
    void incorrectLogin() throws InterruptedException {
        // Click login shortcut
        WebElement loginShortcut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-button\"]")));
        loginShortcut.click();

        // Enter username
        WebElement loginUsername = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-username\"]")));
        loginUsername.click();
        loginUsername.sendKeys("Not-Perfect-Tourist-9337");
        Thread.sleep(100);

        // Enter password
        WebElement loginPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-password\"]")));
        loginPassword.click();
        loginPassword.sendKeys("reddit1234***");
        Thread.sleep(100);

        // Login but fail
        Thread.sleep(1000);
        loginPassword.sendKeys(Keys.ENTER);
    }
}