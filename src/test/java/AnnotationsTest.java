import org.testng.annotations.*;

public class AnnotationsTest {

    @BeforeClass
    public void beforeClass(){System.out.println("To wypisze się przed wszystkim");}

    @BeforeMethod
    public void beforeMethod(){System.out.println("To się wykona przed każdym testem");}

    @Test
    public void test1() { System.out.println("To nasz pierwszy test"); }

    @Test
    public void test2() { System.out.println("To nasz drugi test"); }

    @AfterMethod
    public void afterMethod(){ System.out.println("To się wykona po każdym teście"); }

    @AfterClass
    public void afterClass(){ System.out.println("To się wykona po wszystkim"); }
}
