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
import org.testng.Assert;

import java.beans.Transient;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class SubReddit {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setUp() throws InterruptedException {
        driver = new ChromeDriver();
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

        //Search for Subreddit
        Thread.sleep(5000);
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(2000);
        searchBar.sendKeys("cats");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        // Wait for the search results tabs to be present
        WebElement tabGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-results-page-tabgroup")));

        // Get the tab links
        List<WebElement> tabs = tabGroup.findElements(By.tagName("a"));

        // Wait for the page to load
        Thread.sleep(2000);
        tabGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-results-page-tabgroup")));
        tabs = tabGroup.findElements(By.tagName("a"));

        // Get the tab text
        String tabText = tabs.get(1).findElement(By.tagName("span")).getText().trim();

        // Click on the tab
        tabs.get(1).click();
        System.out.println("Clicked on tab: " + tabText);

        // Wait for the page to load
        Thread.sleep(5000);

        WebElement catsSubreddit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-content\"]/div/reddit-feed/faceplate-tracker[1]")));
        catsSubreddit.click();
        //Joining SubReddit
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    void joinSubReddit() throws InterruptedException {
        Actions actions = new Actions(driver);
        try {
            // Focus on the body of the page
            actions.moveToElement(driver.findElement(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large"))).click().perform();

            // Execute JavaScript to click the join button
            for(int i = 0; i < 7; i++){
                actions.sendKeys(Keys.TAB).perform();
            }
            actions.sendKeys(Keys.ENTER).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(5000);
    }

    @Test(priority = 2)
    void unJoinSubReddit() throws InterruptedException {
        Actions actions = new Actions(driver);
        try {
            // Focus on the body of the page
            actions.moveToElement(driver.findElement(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large"))).click().perform();

            // Execute JavaScript to click the join button
            for(int i = 0; i < 8; i++){
                actions.sendKeys(Keys.TAB).perform();
            }
            actions.sendKeys(Keys.ENTER).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(5000);
    }


    @Test(priority = 3)
    void communityBookmarks() throws InterruptedException {
        //Back to Main Page
        //First 3 Community Bookmarks
        //First one is fine next 2 redirect

    }

    @Test(priority = 4)
    void sortByFlairCategories() throws InterruptedException {
        //Back to Main Page
        //First 3 Community Bookmarks

    }

    @AfterClass
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}
