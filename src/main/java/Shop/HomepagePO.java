package Shop;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomepagePO extends BasePO {

    @FindBy(css = ".user-info .hidden-sm-down")
    private WebElement signInOut;

    public void clickSignInOutButton(){
        signInOut.click();
    }

    public HomepagePO(WebDriver driver) {
        super(driver);
        ownUrl = "http://146.59.32.4";
    }
}
