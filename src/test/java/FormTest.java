import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

        WebElement professionAuto = driver.findElement(By.id("gridCheckAutomationTester"));
        professionAuto.click();

        WebElement additionalInfo = driver.findElement(By.cssSelector("#additionalInformations"));
        additionalInfo.sendKeys("TEST");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
