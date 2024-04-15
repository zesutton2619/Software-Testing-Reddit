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
import java.util.Set;
import java.util.HashSet;

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
    void searchBar() throws InterruptedException {
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(2000);
        searchBar.sendKeys("dogs");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().back();
    }

////*[@id="reddit-trending-searches-partial-container"]
@Test(priority = 2)
void clearSearch() throws InterruptedException {
    WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
    searchBar.click();
    searchBar.sendKeys("dogs");

    Thread.sleep(2000);

    // Find the element containing the shadow root
    WebElement shadowHost = driver.findElement(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large"));

    // Execute JavaScript to click the "Clear Search" button within the shadow root
    ((JavascriptExecutor) driver).executeScript("arguments[0].shadowRoot.querySelector('#search-input-clear-button').click();", shadowHost);

    Thread.sleep(2000); // Optional: wait for 2 seconds to see the result
}


    @Test(priority = 3)
    void clickTrendingTopics() throws InterruptedException {
        // Find the element containing the shadow root
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
        searchBar.click();
        Thread.sleep(2000);
        // Execute JavaScript to find the trending topics container within the shadow root
        WebElement trendingContainer = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot.querySelector('#reddit-trending-searches-partial-container')", searchBar);
        Thread.sleep(1000); // Add a short delay to allow the page to load after finding the trending container

        // Get all the trending topic links within the container
        List<WebElement> trendingTopics = trendingContainer.findElements(By.tagName("a"));

        // Iterate through each trending topic and click on it
        Set<String> clickedTopics = new HashSet<>();
        for (WebElement topic : trendingTopics) {
            String topicName = topic.getText();
            if (!clickedTopics.contains(topicName)) {
                topic.click();
                System.out.println("Clicked on trending topic: " + topicName);
                clickedTopics.add(topicName);
                driver.navigate().back();
                Thread.sleep(1000);
            }
        }
    }

    @AfterClass
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}