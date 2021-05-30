package Shop;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {
    @FindBy(css = "[data-link-action='display-register-form']")
    private WebElement createAccountLink;

    public void clickCreateAccountLink(){
        createAccountLink.click();
    }



    public LoginPO(WebDriver driver) {
        super(driver);
        ownUrl = "146.59.32.4/login";
    }
}
