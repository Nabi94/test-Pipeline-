import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        // WebDriverManager avtomatik ChromeDriver yükləyir
        WebDriverManager.chromedriver().setup();

        // Headless mode ilə container-də testlərin çalışması
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // GUI olmadan aç
        options.addArguments("--no-sandbox"); // Docker üçün
        options.addArguments("--disable-dev-shm-usage"); // shared memory problemi üçün

        driver = new ChromeDriver(options);
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
