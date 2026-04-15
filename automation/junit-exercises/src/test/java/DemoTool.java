import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

    @Test @Disabled // @Disabled will ignore the tests
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

    @Test @Disabled
    public void alerts() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        //simple alert
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        Thread.sleep(1000);

        Assertions.assertEquals("You clicked a button", driver.switchTo().alert().getText()); // because we can find an alert through HTML, we use switchTo().alert() to make the switch and get the text

        Thread.sleep(1000);
        driver.switchTo().alert().accept(); // to click the "OK" or "Accept" button from the alert
        //you can click user .dismiss() instead of .accept() to select "Cancel" or "No"
        Thread.sleep(1000);
        //prompt alert
        WebElement promptButton = driver.findElement(By.id("promtButton"));
        promptButton.click();
        Thread.sleep(1000);

        Assertions.assertEquals("Please enter your name", driver.switchTo().alert().getText());

        Thread.sleep(3000);

        driver.switchTo().alert().sendKeys("bianca"); // to input text in the alert field

        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        Thread.sleep(1000);
    }

    @Test @Disabled
    public void modals() {
        //verify that "Small Modal" modal is opened with text"This is a small modal. It has very less content"
        //and that the close button is enabled

        driver.get("https://demoqa.com/modal-dialogs");
        WebElement smallModalButton = driver.findElement(By.id("showSmallModal"));
        smallModalButton.click();

        WebElement modalTitle = driver.findElement(By.id("example-modal-sizes-title-sm"));
        WebElement modalContent = driver.findElement(By.xpath("//div[@class=\"modal-body\"]"));
        WebElement closeButton = driver.findElement(By.id("closeSmallModal"));

        Assertions.assertEquals("Small Modal", modalTitle.getText()); //check if the expected title "Small Modal" is the same with the actual modalTtitle.getText() - which gets the title of the element
        Assertions.assertEquals("This is a small modal. It has very less content", modalContent.getText()); //check if the expected context "This is a small modal. It has very less content"
        //is the same with the actual modalContent.getText() - which gets the content of the element
        Assertions.assertTrue(closeButton.isEnabled()); // checks if the button is enabled - checks the state of the element
    }


    @Test @Disabled
    public void keyboardActions() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");
        Thread.sleep(3000);


        WebElement currentAddressTextarea = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddressTextarea = driver.findElement(By.id("permanentAddress"));

        currentAddressTextarea.sendKeys("vine vacanta"); // input the text
        currentAddressTextarea.sendKeys(Keys.CONTROL+"A"); // ctrl+a - selects the text
        currentAddressTextarea.sendKeys(Keys.CONTROL+"C"); // ctrl+c - copies the text
        currentAddressTextarea.sendKeys(Keys.TAB); // tab- move to next area
        permanentAddressTextarea.sendKeys(Keys.CONTROL+"V"); // ctrl+v - pastes the text
        Thread.sleep(3000);

        //currentAddressTextarea.clear(); // empties the field

        currentAddressTextarea.sendKeys(Keys.CONTROL+"A");
        currentAddressTextarea.sendKeys(Keys.DELETE);
        Thread.sleep(3000);

        for(int i = 0; i < 10; i++) {
            permanentAddressTextarea.sendKeys(Keys.BACK_SPACE);
        }
        Thread.sleep(3000);
    }


    @Test @Disabled // element states
    public void elementState() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");
        Thread.sleep(3000);

        WebElement header = driver.findElement(By.xpath("//h1"));
        //is displayed
        System.out.println(header.isDisplayed());
        //is enabled
        System.out.println(header.isEnabled());
        //is selected
        System.out.println(header.isSelected());
    }



    @Test @Disabled
    public void elementAttributes() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");
        Thread.sleep(3000);

        WebElement header = driver.findElement(By.xpath("//h1"));

        //get text
        System.out.println(header.getText());
        //get tag
        System.out.println(header.getTagName());
        //get location
        System.out.println(header.getLocation());
        //get size
        System.out.println(header.getSize());
        //get attribute
        System.out.println(header.getDomAttribute("class"));

    }

    @Test @Disabled
    public void dynamicProperties() {
        driver.get("https://demoqa.com/dynamic-properties");
       // WebElement visibleAfterButton = driver.findElement(By.id("visibleAfter"));
        //visibleAfterButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement visibleAfterButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        visibleAfterButton.click();
    }

    @Test @Disabled
    public void buttonIsClickable() {
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement isClickableAfter = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        isClickableAfter.click();
    }


    @Test @Disabled
    public void frames() {
        driver.get("https://demoqa.com/frames");

        driver.switchTo().frame("frame1"); //switch to html frame1 from within existing html
        WebElement sampleText = driver.findElement(By.id("sampleHeading"));
        Assertions.assertEquals("This is a sample page", sampleText.getText());

        driver.switchTo().parentFrame();
        WebElement infoLabel = driver.findElement(By.xpath("//div[@id=\"framesWrapper\"]/div[1]"));
        Assertions.assertTrue(infoLabel.getText().contains("frame"));
    }

    @Test
    public void tables() {
        driver.get("https://demoqa.com/webtables");
        //find an element inside the table
        //v1 - check if the element exists in the table - not recommended
        WebElement table = driver.findElement(By.xpath("//table"));
        Assertions.assertTrue(table.getText().contains("Kierra"));

        //v2 - take all elements from column First Name
        List<WebElement> firstNameCells = driver.findElements(By.xpath("//tr/td[1]"));
        //v2.a
        boolean isPresent = false;
        for(WebElement cell:firstNameCells) {
            if(cell.getText().equalsIgnoreCase("Kierra")) {
                isPresent = true;
                break;
            }
        }
        Assertions.assertTrue(isPresent);
        //v2.b - Recommended
        List<String> firstNameValues = new ArrayList<>();
        for(WebElement cell:firstNameCells) {
            firstNameValues.add(cell.getText());
        }
        Assertions.assertTrue(firstNameValues.contains("Kierra"));
    }

}
