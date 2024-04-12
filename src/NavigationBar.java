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

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class NavigationBar {
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
    void topicGaming() throws InterruptedException {
        // Find the summary element for the "Gaming" topic with an increased wait time
        WebElement gamingTopicSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//summary[contains(., 'Gaming')]")));

        // Check if the "Gaming" dropdown is currently collapsed
        String isOpenAttribute = gamingTopicSummary.getAttribute("aria-expanded");

        // If it's collapsed, click to expand it
        if (isOpenAttribute != null && isOpenAttribute.equals("false")) {
            gamingTopicSummary.click();
            Thread.sleep(500); // Add a short delay to allow the dropdown to expand
        }

        // Find the parent element of the "Gaming" topic
        WebElement gamingParent = driver.findElement(By.id("Gaming"));

        // Find all topic items under Gaming
        List<WebElement> topicItems = gamingParent.findElements(By.tagName("left-nav-topic-tracker"));

        // Iterate through each topic item
        for (int i = 0; i < topicItems.size(); i++) {
            // Re-find the parent element of the "Gaming" topic after navigating back
            gamingParent = driver.findElement(By.id("Gaming"));

            // Re-find all topic items under Gaming
            topicItems = gamingParent.findElements(By.tagName("left-nav-topic-tracker"));

            // Get the link for the current topic item
            WebElement link = topicItems.get(i).findElement(By.tagName("a"));

            // Get the text of the link
            String topicName = link.getText();

            // Click on the link
            link.click();
            System.out.println("Clicked on topic: " + topicName);

            // Navigate back to the main page
            driver.navigate().back();
            Thread.sleep(1000); // Add a short delay to allow the page to load

            // Re-find the summary element for the "Gaming" topic
            gamingTopicSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//summary[contains(., 'Gaming')]")));

            // Check if the "Gaming" dropdown is currently collapsed after navigation back
            isOpenAttribute = gamingTopicSummary.getAttribute("aria-expanded");

            // If it's collapsed, click to expand it again
            if (isOpenAttribute != null && isOpenAttribute.equals("false")) {
                gamingTopicSummary.click();
                Thread.sleep(1000); // Add a short delay to allow the dropdown to expand
            }
        }
    }

    @Test(priority = 2)
    void topicSports() throws InterruptedException {
        // Find the summary element for the "Sports" topic with an increased wait time
        WebElement gamingTopicSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//summary[contains(., 'Sports')]")));

        // Check if the "Sports" dropdown is currently collapsed
        String isOpenAttribute = gamingTopicSummary.getAttribute("aria-expanded");

        // If it's collapsed, click to expand it
        if (isOpenAttribute != null && isOpenAttribute.equals("false")) {
            gamingTopicSummary.click();
            Thread.sleep(500); // Add a short delay to allow the dropdown to expand
        }

        // Find the parent element of the "Sports" topic
        WebElement gamingParent = driver.findElement(By.id("Sports"));

        // Find all topic items under Sports
        List<WebElement> topicItems = gamingParent.findElements(By.tagName("left-nav-topic-tracker"));

        // Iterate through each topic item
        for (int i = 0; i < topicItems.size(); i++) {
            // Re-find the parent element of the "Sports" topic after navigating back
            gamingParent = driver.findElement(By.id("Sports"));

            // Re-find all topic items under Sports
            topicItems = gamingParent.findElements(By.tagName("left-nav-topic-tracker"));

            // Get the link for the current topic item
            WebElement link = topicItems.get(i).findElement(By.tagName("a"));

            // Get the text of the link
            String topicName = link.getText();

            // Click on the link
            link.click();
            System.out.println("Clicked on topic: " + topicName);

            // Navigate back to the main page
            driver.navigate().back();
            Thread.sleep(1000); // Add a short delay to allow the page to load

            // Re-find the summary element for the "Sports" topic
            gamingTopicSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//summary[contains(., 'Sports')]")));

            // Check if the "Sports" dropdown is currently collapsed after navigation back
            isOpenAttribute = gamingTopicSummary.getAttribute("aria-expanded");

            // If it's collapsed, click to expand it again
            if (isOpenAttribute != null && isOpenAttribute.equals("false")) {
                gamingTopicSummary.click();
                Thread.sleep(1000); // Add a short delay to allow the dropdown to expand
            }
        }
    }
    @Test(priority = 3)
    void topicBusiness() throws InterruptedException {
        // Find the summary element for the "Business" topic with an increased wait time
        WebElement gamingTopicSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//summary[contains(., 'Business')]")));

        // Check if the "Business" dropdown is currently collapsed
        String isOpenAttribute = gamingTopicSummary.getAttribute("aria-expanded");

        // If it's collapsed, click to expand it
        if (isOpenAttribute != null && isOpenAttribute.equals("false")) {
            gamingTopicSummary.click();
            Thread.sleep(500); // Add a short delay to allow the dropdown to expand
        }

        // Find the parent element of the "Business" topic
        WebElement gamingParent = driver.findElement(By.id("Business"));

        // Find all topic items under Business
        List<WebElement> topicItems = gamingParent.findElements(By.tagName("left-nav-topic-tracker"));

        // Iterate through each topic item
        for (int i = 0; i < topicItems.size(); i++) {
            // Re-find the parent element of the "Business" topic after navigating back
            gamingParent = driver.findElement(By.id("Business"));

            // Re-find all topic items under Business
            topicItems = gamingParent.findElements(By.tagName("left-nav-topic-tracker"));

            // Get the link for the current topic item
            WebElement link = topicItems.get(i).findElement(By.tagName("a"));

            // Get the text of the link
            String topicName = link.getText();

            // Click on the link
            link.click();
            System.out.println("Clicked on topic: " + topicName);

            // Navigate back to the main page
            driver.navigate().back();
            Thread.sleep(1000); // Add a short delay to allow the page to load

            // Re-find the summary element for the "Business" topic
            gamingTopicSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//summary[contains(., 'Business')]")));

            // Check if the "Business" dropdown is currently collapsed after navigation back
            isOpenAttribute = gamingTopicSummary.getAttribute("aria-expanded");

            // If it's collapsed, click to expand it again
            if (isOpenAttribute != null && isOpenAttribute.equals("false")) {
                gamingTopicSummary.click();
                Thread.sleep(1000); // Add a short delay to allow the dropdown to expand
            }
        }
    }

    @Test(priority = 4)
    void topicCrypto() throws InterruptedException {
        // Find the summary element for the "Crypto" topic with an increased wait time
        WebElement gamingTopicSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//summary[contains(., 'Crypto')]")));

        // Check if the "Crypto" dropdown is currently collapsed
        String isOpenAttribute = gamingTopicSummary.getAttribute("aria-expanded");

        // If it's collapsed, click to expand it
        if (isOpenAttribute != null && isOpenAttribute.equals("false")) {
            gamingTopicSummary.click();
            Thread.sleep(500); // Add a short delay to allow the dropdown to expand
        }

        // Find the parent element of the "Crypto" topic
        WebElement gamingParent = driver.findElement(By.id("Crypto"));

        // Find all topic items under Crypto
        List<WebElement> topicItems = gamingParent.findElements(By.tagName("left-nav-topic-tracker"));

        // Iterate through each topic item
        for (int i = 0; i < topicItems.size(); i++) {
            // Re-find the parent element of the "Crypto" topic after navigating back
            gamingParent = driver.findElement(By.id("Crypto"));

            // Re-find all topic items under Crypto
            topicItems = gamingParent.findElements(By.tagName("left-nav-topic-tracker"));

            // Get the link for the current topic item
            WebElement link = topicItems.get(i).findElement(By.tagName("a"));

            // Get the text of the link
            String topicName = link.getText();

            // Click on the link
            link.click();
            System.out.println("Clicked on topic: " + topicName);

            // Navigate back to the main page
            driver.navigate().back();
            Thread.sleep(1000); // Add a short delay to allow the page to load

            // Re-find the summary element for the "Crypto" topic
            gamingTopicSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//summary[contains(., 'Crypto')]")));

            // Check if the "Crypto" dropdown is currently collapsed after navigation back
            isOpenAttribute = gamingTopicSummary.getAttribute("aria-expanded");

            // If it's collapsed, click to expand it again
            if (isOpenAttribute != null && isOpenAttribute.equals("false")) {
                gamingTopicSummary.click();
                Thread.sleep(1000); // Add a short delay to allow the dropdown to expand
            }
        }
    }

    @Test(priority = 5)
    void topicTelevision() throws InterruptedException {
        // Find the summary element for the "Television" topic with an increased wait time
        WebElement gamingTopicSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//summary[contains(., 'Television')]")));

        // Check if the "Television" dropdown is currently collapsed
        String isOpenAttribute = gamingTopicSummary.getAttribute("aria-expanded");

        // If it's collapsed, click to expand it
        if (isOpenAttribute != null && isOpenAttribute.equals("false")) {
            gamingTopicSummary.click();
            Thread.sleep(500); // Add a short delay to allow the dropdown to expand
        }

        // Find the parent element of the "Television" topic
        WebElement gamingParent = driver.findElement(By.id("Television"));

        // Find all topic items under Television
        List<WebElement> topicItems = gamingParent.findElements(By.tagName("left-nav-topic-tracker"));

        // Iterate through each topic item
        for (int i = 0; i < topicItems.size(); i++) {
            // Re-find the parent element of the "Television" topic after navigating back
            gamingParent = driver.findElement(By.id("Television"));

            // Re-find all topic items under Television
            topicItems = gamingParent.findElements(By.tagName("left-nav-topic-tracker"));

            // Get the link for the current topic item
            WebElement link = topicItems.get(i).findElement(By.tagName("a"));

            // Get the text of the link
            String topicName = link.getText();

            // Click on the link
            link.click();
            System.out.println("Clicked on topic: " + topicName);

            // Navigate back to the main page
            driver.navigate().back();
            Thread.sleep(1000); // Add a short delay to allow the page to load

            // Re-find the summary element for the "Television" topic
            gamingTopicSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//summary[contains(., 'Television')]")));

            // Check if the "Television" dropdown is currently collapsed after navigation back
            isOpenAttribute = gamingTopicSummary.getAttribute("aria-expanded");

            // If it's collapsed, click to expand it again
            if (isOpenAttribute != null && isOpenAttribute.equals("false")) {
                gamingTopicSummary.click();
                Thread.sleep(1000); // Add a short delay to allow the dropdown to expand
            }
        }
    }

    @Test(priority = 6)
    void topicCelebrity() throws InterruptedException {
        // Find the summary element for the "Celebrity" topic with an increased wait time
        WebElement gamingTopicSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//summary[contains(., 'Celebrity')]")));

        // Check if the "Celebrity" dropdown is currently collapsed
        String isOpenAttribute = gamingTopicSummary.getAttribute("aria-expanded");

        // If it's collapsed, click to expand it
        if (isOpenAttribute != null && isOpenAttribute.equals("false")) {
            gamingTopicSummary.click();
            Thread.sleep(500); // Add a short delay to allow the dropdown to expand
        }

        // Find the parent element of the "Celebrity" topic
        WebElement gamingParent = driver.findElement(By.id("Crypto"));

        // Find all topic items under Crypto
        List<WebElement> topicItems = gamingParent.findElements(By.tagName("left-nav-topic-tracker"));

        // Iterate through each topic item
        for (int i = 0; i < topicItems.size(); i++) {
            // Re-find the parent element of the "Celebrity" topic after navigating back
            gamingParent = driver.findElement(By.id("Celebrity"));

            // Re-find all topic items under Celebrity
            topicItems = gamingParent.findElements(By.tagName("left-nav-topic-tracker"));

            // Get the link for the current topic item
            WebElement link = topicItems.get(i).findElement(By.tagName("a"));

            // Get the text of the link
            String topicName = link.getText();

            // Click on the link
            link.click();
            System.out.println("Clicked on topic: " + topicName);

            // Navigate back to the main page
            driver.navigate().back();
            Thread.sleep(1000); // Add a short delay to allow the page to load

            // Re-find the summary element for the "Celebrity" topic
            gamingTopicSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//summary[contains(., 'Celebrity')]")));

            // Check if the "Celebrity" dropdown is currently collapsed after navigation back
            isOpenAttribute = gamingTopicSummary.getAttribute("aria-expanded");

            // If it's collapsed, click to expand it again
            if (isOpenAttribute != null && isOpenAttribute.equals("false")) {
                gamingTopicSummary.click();
                Thread.sleep(1000); // Add a short delay to allow the dropdown to expand
            }
        }
    }

    @Test(priority = 7)
    void seeMore() throws InterruptedException {
        // Find the element containing the shadow root
        WebElement shadowHost = driver.findElement(By.tagName("hui-left-nav-see-more"));
        Set<String> clickedTopics = new HashSet<>();

        // Execute JavaScript to click the "See more" button within the shadow root
        ((JavascriptExecutor) driver).executeScript("arguments[0].shadowRoot.querySelector('button').click();", shadowHost);
        Thread.sleep(1000); // Add a short delay to allow the page to load after clicking "See more"

        // Keep track of whether there are more topics to click
        boolean hasMoreTopics = true;

        // Iterate as long as there are more topics to click
        while (hasMoreTopics) {
            // Find the element containing the expanded topics
            WebElement expandedTopicsContainer = driver.findElement(By.id("left-nav-more-topics"));

            // Find all topic items within the expanded topics container
            List<WebElement> topics = expandedTopicsContainer.findElements(By.tagName("left-nav-topic-tracker"));

            // Iterate through each topic item
            for (WebElement topic : topics) {
                // Get the link for the current topic item
                WebElement link = topic.findElement(By.tagName("a"));

                // Get the text of the link
                String topicName = link.getText();

                // Check if the topic has already been clicked
                if (clickedTopics.contains(topicName)) {
                    continue; // Skip this topic if already clicked
                }

                // Click on the link
                link.click();
                System.out.println("Clicked on topic: " + topicName);
                clickedTopics.add(topicName);

                // Navigate back to the main page
                driver.navigate().back();
                Thread.sleep(1000); // Add a short delay to allow the page to load

                // Check if the "See more" button exists
                shadowHost = driver.findElement(By.tagName("hui-left-nav-see-more"));
                WebElement seeMoreButton = null;
                try {
                    seeMoreButton = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot.querySelector('button')", shadowHost);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // If the button exists and its text is "See More", click it
                if (seeMoreButton != null && seeMoreButton.getText().trim().equalsIgnoreCase("See more")) {
                    seeMoreButton.click();
                    Thread.sleep(1000); // Add a short delay to allow the page to load after clicking "See more"
                    break; // Break out of the loop to re-evaluate the topics
                }
            }

            // Check if there are no more topics to click
            if (topics.size() == clickedTopics.size()) {
                hasMoreTopics = false;
            }
        }
    }

    @Test(priority = 8)
    void test_8() throws InterruptedException {

    }

    @Test(priority = 9)
    void test_9() throws InterruptedException {

    }
    
    @AfterClass
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}