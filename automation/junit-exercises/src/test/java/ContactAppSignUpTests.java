import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactAppSignUpTests {
    static WebDriver driver;

    @BeforeAll
    public static void before() {
        ChromeOptions chromeOption = new ChromeOptions();

        chromeOption.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
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
        driver = new ChromeDriver(chromeOption); // ← o singura data!
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterAll
    public static void after() {
        //driver.close(); // closes current instance of browser / tab
        driver.quit(); // closes all tabs

    }

    @Test //@Disabled
    public void signUpButtonIsEnabled() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        WebElement signUpButton = driver.findElement(By.id("signup"));

        signUpButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains("addUser"));
        Assertions.assertTrue(
                driver.getCurrentUrl().contains("addUser"),
                "Sign up-ul nu a reusit! URL actual: " + driver.getCurrentUrl()
        );
    }

    @Test @Disabled
    public void signUpFormWithValidCred() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/addUser");

        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        WebElement submitButton = driver.findElement(By.id("submit"));

        firstNameInput.sendKeys("bianca");
        lastNameInput.sendKeys("manole");
        emailInput.sendKeys("bianca@manole.com");
        passwordInput.sendKeys("1234567");

        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("contactList"));
        Assertions.assertTrue(
                driver.getCurrentUrl().contains("contactList"),
                "Sign up-ul nu a reusit! URL actual: " + driver.getCurrentUrl()
        );
    }

    @Test
    public void signUpFormExistingCred() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/addUser");

        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        WebElement submitButton = driver.findElement(By.id("submit"));

        firstNameInput.sendKeys("bianca");
        lastNameInput.sendKeys("manole");
        emailInput.sendKeys("bianca@manole.com");
        passwordInput.sendKeys("1234567");

        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("error"))
        );
        Assertions.assertTrue(errorMsg.isDisplayed());


    }


}
