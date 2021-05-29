package Day5;

import Day4.TestBase;
import org.testng.annotations.Test;

public class IframeTest extends TestBase {

    @Test
    public void iframeTest(){
        driver.get("https://seleniumui.moderntester.pl/iframes.php");

        // 1st frame
        driver.switchTo().frame("iframe1");

        driver.switchTo().defaultContent();
    }
}
