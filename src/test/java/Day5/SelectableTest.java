package Day5;

import Day4.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectableTest extends TestBase {

    @Test
    public void shouldSelectItem() {
        driver.get("https://seleniumui.moderntester.pl/selectable.php");
        List<WebElement> items = driver.findElements(By.cssSelector(".ui-widget-content.ui-selectee"));
        items.get(3).click();

        Assert.assertEquals(driver.findElement(By.id("select-result")).getText(), "#4");
    }

    @Test
    public void shouldSelectItems() {
        driver.get("https://seleniumui.moderntester.pl/selectable.php");
        List<WebElement> items = driver.findElements(By.cssSelector(".ui-widget-content.ui-selectee"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(items.get(3))
                .click(items.get(0))
                .click(items.get(5))
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        Assert.assertEquals(driver.findElement(By.id("select-result")).getText(), "#1 #4 #6");
    }
}
