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

//        // Find the SubReddit
//        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
//        searchBar.click();
//        Thread.sleep(2000);
//        searchBar.sendKeys("cats");
//        WebElement catsSubreddit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='reddit-typeahead-results-partial-container']/faceplate-tracker[1]/faceplate-tracker/li/a")));
//        catsSubreddit.click();
    }

    @Test(priority = 1)
    void joinSubReddit() throws InterruptedException {
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(2000);
        searchBar.sendKeys("cats");
        //Joining SubReddit
        WebElement subredditJoin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/dsa-transparency-modal-provider/div/div[1]/div[1]/section/div/div[2]/shreddit-subreddit-header-buttons")));
        subredditJoin.click();

        Thread.sleep(5000);
        driver.navigate().back();
    }

    @Test(priority = 2)
    void unJoinSubReddit() throws InterruptedException {
        WebElement unjoinButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/dsa-transparency-modal-provider/report-flow-provider/div/div[1]/div[1]/section/div/div[2]/shreddit-subreddit-header-buttons//div/faceplate-tracker/shreddit-join-button//button")));

        unjoinButton.click();
        Thread.sleep(5000);
        driver.navigate().back();
    }

    @Test(priority = 3)
    void selectPost() throws InterruptedException {
        //Select Post
        WebElement firstPost = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-content\"]/div[2]/article[1]")));
        firstPost.click();
        Thread.sleep(5000);
        driver.navigate().back();
    }

    @Test(priority = 4)
    void upvoteDownvotePost() throws InterruptedException {
        driver.get("https://www.reddit.com/r/cats/comments/1c4qrb3/moth_has_breached_the_perimeter_target_acquired/");
        //Upvote
        WebElement upvote = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"t3_1c4qrb3\"]//div[2]/span/span/shreddit-async-loader/give-gold-hovercard/button")));
        upvote.click();
        Thread.sleep(200);
        upvote.click();
        //Downvote
        WebElement downvote = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"t3_1c4qrb3\"]//div[2]/span/span/button")));
        downvote.click();
        Thread.sleep(200);
        downvote.click();
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    void commentOnPost() throws InterruptedException {
        driver.get("https://www.reddit.com/r/cats/comments/1c4qrb3/moth_has_breached_the_perimeter_target_acquired/");
        //Comment
        WebElement commentBlock = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-content\"]/shreddit-async-loader/comment-body-header")));
        commentBlock.click();
        commentBlock.sendKeys("So cute!");


        //ReplyToComment



        //DeleteComment


    }

    @Test(priority = 6)
    void communityBookmarks() throws InterruptedException {
        //Back to Main Page
        //First 3 Community Bookmarks
        //First one is fine next 2 redirect

    }

    @Test(priority = 7)
    void sortByFlairCategories() throws InterruptedException {
        //Back to Main Page
        //First 3 Community Bookmarks

    }

}
