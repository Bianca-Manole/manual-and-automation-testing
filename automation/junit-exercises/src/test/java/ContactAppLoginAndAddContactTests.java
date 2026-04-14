import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactAppLoginAndAddContactTests {
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
        driver = new ChromeDriver(chromeOption); // ← o singura data!
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterAll
    public static void after() {
        //driver.close(); // closes current instance of browser / tab
        driver.quit(); // closes all tabs

    }

    @BeforeEach
    public void setUp() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        login("bianca_manole@outlook.com", "1234567");
    }

    public static void login(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
    }

    @Test
    @Disabled
    public void validLogin() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("contactList"));
        Assertions.assertTrue(
                driver.getCurrentUrl().contains("contactList"),
                "Sign up-ul nu a reusit! URL actual: " + driver.getCurrentUrl()
        );
    }

    @Test
    @Disabled
    public void invalidLogin() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/logout");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement usernameInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("email"))
        );
        usernameInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // pentru a suprascrie autopopulated email
        usernameInput.sendKeys("bianca.manole@outlook.com");
        driver.findElement(By.id("password")).sendKeys("1234567");
        driver.findElement(By.id("submit")).click();

        WebElement errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("error"))
        );
        Assertions.assertTrue(errorMsg.isDisplayed());
    }

    @Test //@Disabled
    public void addNewContactButtonIsEnabled() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/contactList");

        WebElement newContactButton = driver.findElement(By.id("add-contact"));

        newContactButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("addContact"));
        Assertions.assertTrue(
                driver.getCurrentUrl().contains("addContact"),
                "Sign up-ul nu a reusit! URL actual: " + driver.getCurrentUrl()
        );
    }

    @Test
    @Disabled
    public void addContactWithMandatoryFields() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/addContact");

        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        firstNameInput.sendKeys("andreea");
        lastNameInput.sendKeys("manole");

        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement contactNameDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[td[1][text()='andreea manole']]"))
        );
        Assertions.assertTrue(contactNameDisplayed.isDisplayed());

    }

    @Test
    @Disabled
    public void addContactWithAllFields() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/addContact");

        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        WebElement dateOfBirthInput = driver.findElement(By.id("birthdate"));
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement phoneInput = driver.findElement(By.id("phone"));
        WebElement streetAddressOne = driver.findElement(By.id("street1"));
        WebElement streetAddressTwo = driver.findElement(By.id("street2"));
        WebElement cityInput = driver.findElement(By.id("city"));
        WebElement stateInput = driver.findElement(By.id("stateProvince"));
        WebElement postalCodeInput = driver.findElement(By.id("postalCode"));
        WebElement countryInput = driver.findElement(By.id("country"));

        WebElement submitButton = driver.findElement(By.id("submit"));

        firstNameInput.sendKeys("bianca");
        lastNameInput.sendKeys("manole");
        dateOfBirthInput.sendKeys("1994-02-07");
        emailInput.sendKeys("bianca@outlook.com");
        phoneInput.sendKeys("0722782380");
        streetAddressOne.sendKeys("lacul tei");
        streetAddressTwo.sendKeys("vidin");
        cityInput.sendKeys("Bucuresti");
        stateInput.sendKeys("Bucuresti");
        postalCodeInput.sendKeys("123456");
        countryInput.sendKeys("Romania");

        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[td[contains(text(),'bianca manole')]]"))
        );
        Assertions.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'bianca manole')]]")).isDisplayed(),
                "Numele nu este in coloana corecta!");
        Assertions.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'1994-02-07')]]")).isDisplayed(),
                "Telefonul nu este in coloana corecta!");
        Assertions.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'bianca@outlook.com')]]")).isDisplayed(),
                "Adresa de mail nu este in coloana corecta");
        Assertions.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'0722782380')]]")).isDisplayed(),
                "Numarul de telefon nu este in coloana corecta");
        Assertions.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'lacul tei')]]")).isDisplayed(),
                "Adresa 1 nu este in coloana corecta");
        Assertions.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'vidin')]]")).isDisplayed(),
                "Adresa 2 nu este in coloana corecta");
        Assertions.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'Bucuresti')]]")).isDisplayed(),
                "Orasul nu este in coloana corecta");
        Assertions.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'Bucuresti')]]")).isDisplayed(),
                "Judetul nu este in coloana corecta");
        Assertions.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'123456')]]")).isDisplayed(),
                "Codul Postal nu este in coloana corecta");
        Assertions.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'Romania')]]")).isDisplayed(),
                "Tara nu este in coloana corecta");

    }

    @Test
    @Disabled
    public void addContactWithEmptyFirstName() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/addContact");

        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        firstNameInput.sendKeys("");
        lastNameInput.sendKeys("manole");

        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("error"))
        );
        Assertions.assertTrue(errorMsg.isDisplayed());
    }

}
