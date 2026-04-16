import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class AddContactTests {
    static WebDriver driver;

    @BeforeAll
    public static void before() {
        ChromeOptions chromeOption = new ChromeOptions();

        chromeOption.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        chromeOption.addArguments("disable-infobars");
        chromeOption.addArguments("disable-popup-blocking");
        chromeOption.addArguments("disable-default-apps");
        chromeOption.addArguments("no-first-run");
        chromeOption.addArguments("no-default-browser-check");
        chromeOption.addArguments("--disable-search-engine-choice-screen");
        chromeOption.addArguments("start-maximized");
        chromeOption.addArguments("disable-notifications");
        chromeOption.addArguments("disable-extensions");
        chromeOption.addArguments("guest");

        System.setProperty("webdriver.chrome.driver", "src/source/chromedriver.exe");
        driver = new ChromeDriver(chromeOption);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        login("bianca_manole@outlook.com", "1234567");
    }

    public static void login(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
    }

    @BeforeEach
    public void setUp() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/addContact");
    }


}
