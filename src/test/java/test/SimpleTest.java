package test;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({AllureTestNg.class})
@Epic("Web Testing")                    // ← ƏLAVƏ
@Feature("Google Search")                // ← ƏLAVƏ
public class SimpleTest {
    WebDriver driver;

    @BeforeClass
    @Step("Setup browser")               // ← ƏLAVƏ
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
    }

    @Test
    @Description("Open Google and verify title")  // ← ƏLAVƏ
    @Severity(SeverityLevel.CRITICAL)             // ← ƏLAVƏ
    @Story("User opens Google homepage")          // ← ƏLAVƏ
    public void openGoogle() {
        openPage("https://www.google.com");
        String title = driver.getTitle();

        System.out.println("Title: " + title);

        // Allure report üçün assertion əlavə edin
        Assert.assertTrue(title.contains("Google"),
                "Title should contain 'Google'");  // ← ƏLAVƏ
    }

    @Step("Open page: {url}")
    public void openPage(String url) {
        driver.get(url);

        // Screenshot əlavə edin (optional)
        Allure.addAttachment("Page URL", "text/plain", url);  // ← ƏLAVƏ
    }

    @AfterClass
    @Step("Close browser")               // ← ƏLAVƏ
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}