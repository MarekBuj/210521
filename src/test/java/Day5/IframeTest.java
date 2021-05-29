package Day5;

import Day4.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class IframeTest extends TestBase {

    @Test
    public void iframeTest(){
        driver.get("https://seleniumui.moderntester.pl/iframes.php");

        // 1st frame
        driver.switchTo().frame("iframe1");
        driver.findElement(By.id("inputFirstName3")).sendKeys("Jan");
        driver.findElement(By.id("inputSurname3")).sendKeys("Wiadro");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // 2nd frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame("iframe2");

        driver.findElement(By.id("inputLogin")).sendKeys("Tomasz");
        driver.findElement(By.id("inputPassword")).sendKeys("1234");
        new Select(driver.findElement(By.id("inlineFormCustomSelectPref"))).selectByIndex(1);
        driver.findElement(By.id("gridRadios4")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();



        driver.switchTo().defaultContent();
    }
}
