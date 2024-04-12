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
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

public class SearchBar {
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
    void SearchBar() throws InterruptedException {
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(2000);

        WebElement trendingParent = driver.findElement(By.id("reddit-trending-searches-partial-container"));

        List<WebElement> trendingItems = trendingParent.findElements(By.tagName("ul"));

        for (WebElement trendingItem : trendingItems) {
            WebElement link = trendingItem.findElement(By.tagName("faceplate-tracker"));

            // Get the text of the link
            String topicName = link.getText();

            // Click on the link
            link.click();
            System.out.println("Clicked on topic: " + topicName);

            // Navigate back to the main page
            driver.navigate().back();
            searchBar.click();
            Thread.sleep(1000); // Add a short delay to allow the page to load
        }
    }

////*[@id="reddit-trending-searches-partial-container"]
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

    @Test

    @AfterClass
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}