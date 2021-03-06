package Day5;

import Day4.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormPoTest extends TestBase {

    @Test
    public void formTest() {
        FormPO formPO = new FormPO(driver);
        formPO.ownUrl = "https://seleniumui.moderntester.pl/form.php";
        formPO.openMe();
        formPO.fillName("Jan","Kowalski");
        formPO.fillName("Bogdan", "Wiadro");
        formPO.fillEmail("test@test.com");
        formPO.selectMale();
        formPO.fillAge(45);
        formPO.selectRandomExperience();
        formPO.selectManualTester();
        formPO.selectRandomContinent();
        formPO.selectRandomCommand();
        formPO.fillFileInput();
        formPO.fillAdditionalInformation("Tralalala");
        formPO.submit();

        Assert.assertEquals(formPO.getValidatorMessageText(), "Form send with success");
    }

    @Test
    public void progressBarTest() {
    ProgressBarPO progressBarPO = new ProgressBarPO(driver);
    progressBarPO.openMe();
    Assert.assertTrue(progressBarPO.progressBarIsComplete());
    }

    @Test
    public void testDelayedAlert(){
        AlertPO alertPO = new AlertPO(driver);
        alertPO.openMe();
        alertPO.clickDelayedAlertButton();
        alertPO.waitForAlertAndAccept();
        Assert.assertEquals(alertPO.getDelayedAlertLabelText(), "OK button pressed");
    }

}
