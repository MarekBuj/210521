package Shop;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPO extends BasePO {
    @FindBy(css = ".user-info .hidden-sm-down")
    private WebElement signInOut;

    public void clickSignInOutButton(){
        signInOut.click();
    }

    public MenuPO(WebDriver driver) {
        super(driver);
    }
}
