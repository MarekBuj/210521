package Day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AssertionsTest {

    @Test
    public void thisCanPass() throws FileNotFoundException {

        Assert.assertEquals(1, 1);
        String expectedText = "asd";
        Assert.assertEquals(expectedText, "asd");
        Assert.assertTrue(1==1);
        Assert.assertTrue(true);

        String content = new Scanner(new File("src/main/resources/secret2.txt")).useDelimiter("\\Z").next();
        System.out.println(content);
    }

    @Test
    public void youShallNotPass() throws FileNotFoundException {

        String content = new Scanner(new File("src/main/resources/secret.txt")).useDelimiter("\\Z").next();
        System.out.println(content);

        Assert.assertTrue(false);

    }

}
