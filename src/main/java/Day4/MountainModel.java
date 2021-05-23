package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MountainModel {
    private String name;
    private int height;

    public MountainModel(WebElement row) {
        List<WebElement> partsOfRow = row.findElements(By.cssSelector("td"));
        this.name = partsOfRow.get(0).getText();
        this.height = Integer.valueOf(partsOfRow.get(3).getText());
//        this.name = row.findElement(By.cssSelector("")).getText();
//        this.height = row.findElement(By.cssSelector("")).getText();
    }

    @Override
    public String toString() {
        return "MountainModel{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
