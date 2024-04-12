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
    void test_1() throws InterruptedException {
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

    @Test(priority = 2)
    void test_2() throws InterruptedException {
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        searchBar.sendKeys("dogs");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    void test_3() throws InterruptedException {
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        searchBar.sendKeys("dogs");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }
}