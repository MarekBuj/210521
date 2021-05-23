package Day4;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void openAlertPage() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
    }

    @Test
    public void simplAlert() {
        driver.findElement(By.id("simple-alert")).click();
        driver.switchTo().alert().accept();
        String validationMessage = driver.findElement(By.id("simple-alert-label")).getText();
        Assert.assertEquals(validationMessage, "OK button pressed");
    }

    @Test
    public void promptAlert(){
        driver.findElement(By.id("prompt-alert")).click();
        driver.switchTo().alert().sendKeys("Lord Vader");
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("prompt-label"))
                .getText(), "Hello Lord Vader! How are you today?");

    }

    @Test
    public void confirmAlert(){
        driver.findElement(By.id("confirm-alert")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("confirm-label")).getText(), "You pressed OK!");
        driver.findElement(By.id("confirm-alert")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(driver.findElement(By.id("confirm-label")).getText(), "You pressed Cancel!");
    }
}
