import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.Keys;

import java.beans.Transient;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class SubReddit {

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
    void joinSubReddit() throws InterruptedException {
        //Joining SubReddit
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(2000);
        searchBar.sendKeys("cats");
        WebElement catsSubreddit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"reddit-typeahead-results-partial-container\"]/faceplate-tracker[1]/faceplate-tracker/li/a")));
        catsSubreddit.click();
        WebElement subredditJoin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/dsa-transparency-modal-provider/div/div[1]/div[1]/section/div/div[2]/shreddit-subreddit-header-buttons")));
        //Requires Account Login
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
        subredditJoin.click();

        Thread.sleep(5000);
        driver.navigate().back();
    }

    @Test(priority = 2)
    void unJoinSubReddit() throws InterruptedException {
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(2000);
        searchBar.sendKeys("cats");
        WebElement catsSubreddit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"reddit-typeahead-results-partial-container\"]/faceplate-tracker[1]/faceplate-tracker/li/a")));
        catsSubreddit.click();
        WebElement subredditJoin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/dsa-transparency-modal-provider/div/div[1]/div[1]/section/div/div[2]/shreddit-subreddit-header-buttons")));
        //Requires Account Login
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
        subredditJoin.click();

        WebElement unjoinButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/dsa-transparency-modal-provider/report-flow-provider/div/div[1]/div[1]/section/div/div[2]/shreddit-subreddit-header-buttons//div/faceplate-tracker/shreddit-join-button//button")));

        unjoinButton.click();
        Thread.sleep(5000);
        driver.navigate().back();
    }

    @Test(priority = 3)
    void selectPost() throws InterruptedException {
        //Select Post
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(2000);
        searchBar.sendKeys("cats");
        searchBar.sendKeys(Keys.ENTER);

        WebElement firstPost = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-content\"]/div[2]/article[1]")));
        firstPost.click();
        Thread.sleep(5000);
        driver.navigate().back();
    }

    @Test(priority = 4)
    void interactWithPost() throws InterruptedException {
        //Scroll to Post
        //Select Post
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(2000);
        searchBar.sendKeys("cats");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().back();
    }

    @Test(priority = 5)
    void upvoteDownvotePost() throws InterruptedException {
        //Upvote
        //Downvote
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(2000);
        searchBar.sendKeys("cats");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().back();
    }

    @Test(priority = 6)
    void commentOnPost() throws InterruptedException {
        //Comment
        //ReplyToComment
        //DeleteComment
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(2000);
        searchBar.sendKeys("cats");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().back();
    }

    @Test(priority = 7)
    void emojiOnPost() throws InterruptedException {
        //Emoji Comment
        //ReplyToComment
        //DeleteComment
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(2000);
        searchBar.sendKeys("cats");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().back();
    }

    @Test(priority = 8)
    void communityBookmarks() throws InterruptedException {
        //Back to Main Page
        //First 3 Community Bookmarks
        //First one is fine next 2 redirect
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(2000);
        searchBar.sendKeys("cats");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().back();
    }

    @Test(priority = 9)
    void sortByFlairCategories() throws InterruptedException {
        //Back to Main Page
        //First 3 Community Bookmarks
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(2000);
        searchBar.sendKeys("cats");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().back();
    }

}
