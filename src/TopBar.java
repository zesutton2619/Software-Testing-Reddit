import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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

public class TopBar {
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
    void redditHomeButton() throws InterruptedException {
        WebElement redditButt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[1]/faceplate-tracker")));
        redditButt.click();
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    void searchButton() throws InterruptedException {
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    void getAppButton() throws InterruptedException {
        WebElement getAppButt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[3]/span[2]/span/faceplate-tooltip/faceplate-tracker")));
        getAppButt.click();
        Thread.sleep(2000);
        WebElement xButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"close-dialog\"]")));
        xButton.click();
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    void loginButton() throws InterruptedException {
        WebElement loginShortcut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-button\"]")));
        loginShortcut.click();
        Thread.sleep(2000);
        driver.get("https://www.reddit.com/");
    }

    @Test(priority = 5)
    void threeDotsButton() throws InterruptedException {
        // Click on the three dots dropdown
        WebElement threeDots = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"expand-user-drawer-button\"]")));
        threeDots.click();
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-list-item\"]/a")));
        System.out.println("Clicked Option: " + firstOption.getText());
        firstOption.click();
        Thread.sleep(2000);
        driver.get("https://www.reddit.com/");
        threeDots = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"expand-user-drawer-button\"]")));
        threeDots.click();
        WebElement secondOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='w-100 p-0 m-0 list-none my-xs']/faceplate-tracker[2]/li/a")));
        System.out.println("Clicked Option: " + secondOption.getText());
        secondOption.click();
        Thread.sleep(2000);
        driver.navigate().back();
        threeDots = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"expand-user-drawer-button\"]")));
        threeDots.click();
        WebElement thirdOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"avatar-shop-list-item\"]/a")));
        System.out.println("Clicked Option: " + thirdOption.getText());
        thirdOption.click();
    }

    @AfterClass
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}
