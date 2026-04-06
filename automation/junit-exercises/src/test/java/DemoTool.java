import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DemoTool {

    static WebDriver driver;

    @BeforeAll
    public static void before() {
        WebDriverManager.chromedriver().setup();

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



        driver = new ChromeDriver(chromeOption);  //
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterAll
    public static void after() {
        driver.close(); // closes current instance of browser / tab
        driver.quit(); // closes all tabs
    }

    @Test
    public void registerUser() throws InterruptedException {
        driver.get("https://demoqa.com/text-box"); //driver.get(String url)
        Thread.sleep(3000); //pauses the execution for x ms - adds exception

        WebElement usernameInput = driver.findElement(By.id("userName")); // find web element by id
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        WebElement currentAddressTextarea = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddressTextarea = driver.findElement(By.id("permanentAddress"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameInput.sendKeys("bianca");  // add text to the input
        emailInput.sendKeys("bianca@outlook.com");
        currentAddressTextarea.sendKeys("bucuresti");
        permanentAddressTextarea.sendKeys("bucuresti");

        Thread.sleep(5000);

        submitButton.click();

        WebElement nameParagraph = driver.findElement(By.id("name"));
        //String nameText = nameParagraph.getText();
        //Assertions.assertTrue(nameText.contains("bianca")); // check if the input is displayed correctly - first method with a String variable
        Assertions.assertTrue(nameParagraph.getText().contains("bianca")); // second method without variable

        Thread.sleep(5000);
        //WebElement emailParagraph = driver.findElement(By.id("email"));
    }

}
