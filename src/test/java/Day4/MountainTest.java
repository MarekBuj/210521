package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MountainTest extends TestBase {

    @Test
    public void shouldReturnMountainsHigherThan4500(){

        driver.get("https://seleniumui.moderntester.pl/");

        List<WebElement> mountainsRow = driver.findElements(By.cssSelector("tbody tr"));
        List<MountainModel> mountainModels = new ArrayList<>();
        List<String> mountainsHigherThan4500 = new ArrayList<>();

        for (WebElement element : mountainsRow) {
            mountainModels.add(new MountainModel(element));
        }

        for (MountainModel mountainModel : mountainModels) {
            if(mountainModel.getHeight()>4500) {
                mountainsHigherThan4500.add(mountainModel.getName());
            }
        }

        Assert.assertEquals(mountainsHigherThan4500,
                Arrays.asList("Mont Blanc", "Dufourspitze", "Dom", "Weisshorn", "Matterhorn"));

    }
}
