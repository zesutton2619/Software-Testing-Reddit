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

    @Test(priority = 1)
    void signUp() throws InterruptedException {
        WebElement loginShortcut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-button\"]")));
        loginShortcut.click();

        WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(" Sign Up ")));

        signUpButton.click();

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"register-email\"]")));
        emailInput.sendKeys("burneraccount274939402935@gmail.com");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"register\"]/faceplate-tabpanel/auth-flow-modal[1]/div[2]/faceplate-tracker/button")));
        continueButton.click();

        WebElement switchUsername = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"register-username\"]/span[2]/button")));
        switchUsername.click();
        switchUsername.click();
        switchUsername.click();

        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"register-password-container\"]")));
        passwordInput.sendKeys("booglywoogly1234*");

        WebElement continueButtonAgain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"register\"]/faceplate-tabpanel/auth-flow-modal[2]/div[2]/faceplate-tracker/button")));
        continueButtonAgain.click();

        //Selects "I prefer not to say"
        WebElement definitelyNotARobot = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/dsa-transparency-modal-provider/shreddit-overlay-display//shreddit-signup-drawer//shreddit-drawer/div/shreddit-async-loader/div/shreddit-slotter//span/shreddit-async-loader/onboarding-flow/shreddit-slotter//span/shreddit-async-loader/faceplate-tracker/ob-gender-selection/auth-flow-modal/div/div/button[4]")));
        definitelyNotARobot.click();

        //Selects category "Am I the A**hole?"
        WebElement bestAnswer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"eae456ec-3277-44d5-b364-6881106d262f\"]")));
        bestAnswer.click();

        WebElement continueAgainAgain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/dsa-transparency-modal-provider/shreddit-overlay-display//shreddit-signup-drawer//shreddit-drawer/div/shreddit-async-loader/div/shreddit-slotter//span/shreddit-async-loader/onboarding-flow/shreddit-slotter//span/shreddit-async-loader/faceplate-tracker/ob-interest-picker/auth-flow-modal/div[2]/button")));
        continueAgainAgain.click();
        Thread.sleep(5000);
    }
    //#login > auth-flow-modal > div.w-100 > faceplate-tracker > button

    @Test(priority = 2)
    void incorrectSignUp() throws InterruptedException {
        WebElement loginShortcut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-button\"]")));
        loginShortcut.click();

        WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login\"]/auth-flow-modal/div[1]/div[3]/auth-flow-link")));
        signUpButton.click();

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"register-email\"]")));
        emailInput.sendKeys("burneraccount274939402935@notarealemailtag.com");
    }

    @Test(priority = 3)
    void login() throws InterruptedException {
        WebElement loginShortcut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-button\"]")));
        loginShortcut.click();

        WebElement loginUsername = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-username\"]")));
        loginUsername.click();
        loginUsername.sendKeys("Perfect-Tourist-9337");
        Thread.sleep(100);

        WebElement loginPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-password\"]")));
        loginPassword.click();
        loginPassword.sendKeys("reddit1234***");
        Thread.sleep(100);

        //does not work
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login\"]/auth-flow-modal/div[2]/faceplate-tracker/button")));
        loginButton.click();
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    void incorrectLogin() throws InterruptedException {
        WebElement loginShortcut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-button\"]")));
        loginShortcut.click();

        WebElement loginUsername = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-username\"]")));
        loginUsername.click();
        loginUsername.sendKeys("Not-Perfect-Tourist-9337");
        Thread.sleep(100);

        WebElement loginPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-password\"]")));
        loginPassword.click();
        loginPassword.sendKeys("reddit1234***");
        Thread.sleep(100);

        //does not work
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login\"]/auth-flow-modal/div[2]/faceplate-tracker/button")));
        loginButton.click();
        Thread.sleep(5000);
    }
}