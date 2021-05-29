package Day5;

import Day4.TestBase;
import org.testng.annotations.Test;

public class FormPoTest extends TestBase {

    @Test
    public void formTest() {
        FormPO formPO = new FormPO(driver);
        formPO.ownUrl = "https://seleniumui.moderntester.pl/form.php";
        formPO.openMe();
        formPO.fillName("Jan","Kowalski");
    }

}
