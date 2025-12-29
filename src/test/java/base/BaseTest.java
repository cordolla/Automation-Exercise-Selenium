package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertiesLoader;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void iniciarNavegador() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String urlSite = PropertiesLoader.loadProperty("url");
        driver.get(urlSite);
    }

    @AfterEach
    public void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}
