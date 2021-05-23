package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class FormTest extends TestBase {


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
        Assert.assertEquals(confirmationMessage.getText(), "Form send with success");
    }

}
