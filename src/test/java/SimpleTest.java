import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        // ChromeDriver path container-də olmalı və ya webdriver manager istifadə et
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogle() {
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
