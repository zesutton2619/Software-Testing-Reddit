import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class PopularCommunities {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.reddit.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 22)
    void visiblePopularCommunities() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increased waiting time

        try {
            // Wait for the entire page to load
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

            // Find the "Popular Communities" aside element
            WebElement popularCommunitiesAside = driver.findElement(By.xpath("//aside[@aria-label='Popular Communities']"));

            // Find the subreddit links inside the "Popular Communities" aside element
            List<WebElement> subredditLinks = popularCommunitiesAside.findElements(By.xpath(".//li[@data-testid='listItem']//a"));

            // Click on each subreddit link
            for (int i = 0; i < 5; i++) {
                subredditLinks.get(i).click();

                // Wait for the page to load
                wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

                // Print the title of the clicked subreddit page
                System.out.println("Clicked on subreddit: " + driver.getTitle());

                // Navigate back to the "Popular Communities" page
                driver.navigate().back();

                // Wait for the "Popular Communities" section to be visible again
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//aside[@aria-label='Popular Communities']")));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    @Test(priority = 23)
    void seeMorePopularCommunities() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increased waiting time

        try {
            // Wait for the entire page to load
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

            // Find the "Popular Communities" aside element
            WebElement popularCommunitiesAside = driver.findElement(By.xpath("//aside[@aria-label='Popular Communities']"));

            // Find the subreddit links inside the "Popular Communities" aside element
            List<WebElement> subredditLinks = popularCommunitiesAside.findElements(By.xpath(".//li[@data-testid='listItem']//a"));
            WebElement seeMore = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"popular-communities-list-see-more\"]")));
            seeMore.click();

            // Click on each subreddit link
            for (int i = 5; i < subredditLinks.size(); i++) {
                subredditLinks.get(i).click();

                // Wait for the page to load
                wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

                // Print the title of the clicked subreddit page
                System.out.println("Clicked on subreddit: " + driver.getTitle());

                Thread.sleep(1000);

                // Navigate back to the "Popular Communities" page
                driver.navigate().back();

                // Wait for the "Popular Communities" section to be visible again
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//aside[@aria-label='Popular Communities']")));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    @AfterClass
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}