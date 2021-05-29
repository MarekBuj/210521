package Day5;

import Day4.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {

    //przesun slider na 50
    //przesun slider na 20
    //przesun slider na 20
    //przesun slider na 75


    @Test
    public void sliderTest() {
        driver.get("https://seleniumui.moderntester.pl/slider.php");
        moveTo(50);
        moveTo(20);
        moveTo(20);
        moveTo(75);
    }

    private int getSliderValue() {
        return Integer.parseInt(
                driver.findElement(By.id("custom-handle")).getText()
        );
    }

    private void moveSlider(int expectedSliderValue, Keys key) {
        while (getSliderValue() != expectedSliderValue) {
            driver.findElement(By.id("custom-handle")).sendKeys(key);
        }
    }

    private void moveTo(int excpectedSliderValue) {
        int actualSliderValue = getSliderValue();

        if(actualSliderValue > excpectedSliderValue) {
            moveSlider(excpectedSliderValue, Keys.ARROW_LEFT);
        } else if (actualSliderValue < excpectedSliderValue) {
            moveSlider(excpectedSliderValue, Keys.ARROW_RIGHT);
        }
    }
}
