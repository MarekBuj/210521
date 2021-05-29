package Day5;

import Day4.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatePickerTest extends TestBase {

    @Test
    public void calendarTest(){
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
        // wybranie 5 dat oraz sprawdzenie czy odpowiednia data została wybrana
        selectDate("10", "October", 2019);
        Assert.assertEquals(getSelectedDate(), "10/10/2019");

        selectDate("10", "December", 2019);
        Assert.assertEquals(getSelectedDate(), "12/10/2019");

        selectDate("10", "April", 2020);
        Assert.assertEquals(getSelectedDate(), "04/10/2020");

        selectDate("27", "January", 2020);
        Assert.assertEquals(getSelectedDate(), "01/27/2020");

        selectDate("12", "December", 2019);
        Assert.assertEquals(getSelectedDate(), "12/12/2019");
    }

    private String getSelectedDate() {
        return "";
    }

    private void selectDate(String s, String december, int i) {
    }
}
