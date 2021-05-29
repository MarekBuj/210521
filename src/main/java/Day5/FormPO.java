package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class FormPO {

    protected WebDriver driver;
    protected String ownUrl;
    protected WebDriverWait wait;


    @FindBy(css = "#inputFirstName3")
    private WebElement inputFirstName;

    @FindBy(css = "#inputLastName3")
    private WebElement inputLastName;


    public void fillName(String firstName, String lastName) {
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
    }

    public void openMe() {
        driver.get(ownUrl);
    }

    public FormPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(elements.size());
        return elements.get(randomNumber);

    }
}
