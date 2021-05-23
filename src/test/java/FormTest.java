import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "ścieżka do chromedriver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");
        options.addArguments("disable-extensions");
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(3440, 0)); //NIE KOPIOWAC
        wait = new WebDriverWait(driver, 10);
    }

    @Test(invocationCount = 1)
    public void shouldFillOutTheForm() {
        driver.get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstNameTextBox = driver.findElement(By.cssSelector("#inputFirstName3"));
        wait.until(ExpectedConditions.visibilityOf(firstNameTextBox));
        firstNameTextBox.sendKeys("Jan");

        WebElement lastNameTextBox = driver.findElement(By.cssSelector("#inputLastName3"));
        lastNameTextBox.sendKeys("Kowalski");

        WebElement emailNameTextBox = driver.findElement(By.cssSelector("#inputEmail3"));
        emailNameTextBox.sendKeys("Jan@wp.pl");

        WebElement male = driver.findElement(By.cssSelector("input[value='male']"));
        male.click();

        WebElement age = driver.findElement(By.id("inputAge3"));
        age.sendKeys("45");

        List<WebElement> years = driver.findElements(By.name("gridRadiosExperience"));
        WebElement randomYear = getRandomElement(years);
        randomYear.click();

        WebElement professionAuto = driver.findElement(By.id("gridCheckAutomationTester"));
        professionAuto.click();

        List<WebElement> continents = driver.findElements(By.cssSelector("#selectContinents option:nth-of-type(1n+2)"));
        getRandomElement(continents).click();

        Select continentSelect = new Select(driver.findElement(By.id("selectContinents")));
        List<WebElement> continentSelectOptions = continentSelect.getOptions();
        continentSelectOptions.remove(0); //usuwamy choose
        WebElement randomContinent = getRandomElement(continentSelectOptions);
        continentSelect.selectByVisibleText(randomContinent.getText());

        //continentSelect.selectByValue("europe");
        Select seleniumCommands = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        List<WebElement> seleniumCommandsOptions = seleniumCommands.getOptions();
        getRandomElement(seleniumCommandsOptions).click();

        WebElement fileInput = driver.findElement(By.id("chooseFile"));
        File file = new File("src\\main\\resources\\emptyFile.txt");
        fileInput.sendKeys(file.getAbsolutePath());

        WebElement additionalInfo = driver.findElement(By.cssSelector("#additionalInformations"));
        additionalInfo.sendKeys("TEST");

        WebElement signInButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        signInButton.click();

        WebElement confirmationMessage = driver.findElement(By.cssSelector("#validator-message"));
        Assert.assertEquals(confirmationMessage.getText(),"Form send with success");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebElement getRandomElement (List<WebElement> elements) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(elements.size());
        return elements.get(randomNumber);

    }

}
