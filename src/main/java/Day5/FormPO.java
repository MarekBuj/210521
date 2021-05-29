package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPO extends BasePO {



    @FindBy(css = "#inputFirstName3")
    private WebElement inputFirstName;

    @FindBy(css = "#inputLastName3")
    private WebElement inputLastName;

    @FindBy(css = "#inputEmail3")
    private WebElement inputEmail;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearsOfExperience;

    @FindBy(css = "input[value='male']")
    private WebElement maleRadioButton;

    @FindBy(id = "gridCheckManulTester")
    private WebElement manualTesterGrid;

    @FindBy(id = "selectContinents")
    private WebElement selectContinents;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement commands;

    @FindBy(id = "chooseFile")
    private WebElement fileInput;

    @FindBy(id = "additionalInformations")
    private WebElement additionalInformationTextBox;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(id = "validator-message")
    private WebElement validatorMessage;

    @FindBy(id = "inputAge3")
    private WebElement ageTextBox;

    public FormPO(WebDriver driver) {
        super(driver);
        ownUrl = "https://seleniumui.moderntester.pl/form.php";
    }

    public void selectRandomExperience() {
        getRandomElement(yearsOfExperience).click();
    }

    public void fillAge(int age) {
        ageTextBox.sendKeys(Integer.toString(age));
    }

    public String getValidatorMessageText() {
        return validatorMessage.getText();
    }


    public void submit() {
        submitButton.click();
    }


    public void fillAdditionalInformation(String text) {
        additionalInformationTextBox.sendKeys(text);
    }


    public void fillFileInput() {
        File file = new File("src/main/resources/emptyFile.txt");
        fileInput.sendKeys(file.getAbsolutePath());
    }

    public void selectRandomCommand() {
        Select commandSelect = new Select(commands);
        List<WebElement> commandsOptions = commandSelect.getOptions();
        getRandomElement(commandsOptions).click();
    }


    public void selectRandomContinent() {
        Select continents = new Select(selectContinents);
        List<WebElement> continentsOptions = continents.getOptions();
        continentsOptions.remove(0);
        WebElement randomOption = getRandomElement(continentsOptions);
        continents.selectByVisibleText(randomOption.getText());
    }

    public void selectManualTester() {
        manualTesterGrid.click();
    }

    public void selectMale() {
        maleRadioButton.click();
    }

    public void fillEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void fillName(String firstName, String lastName) {
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
    }




}
