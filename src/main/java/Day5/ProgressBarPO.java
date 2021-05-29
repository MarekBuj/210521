package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProgressBarPO extends BasePO {

    @FindBy(css = ".ui-progressbar-complete")
    private WebElement completedProgressBar;

    public boolean progressBarIsComplete(){
        wait.until(ExpectedConditions.visibilityOf(completedProgressBar));
        return completedProgressBar.isDisplayed();
    }

    public ProgressBarPO(WebDriver driver) {
        super(driver);
        ownUrl = "https://seleniumui.moderntester.pl/progressbar.php";

    }
}
