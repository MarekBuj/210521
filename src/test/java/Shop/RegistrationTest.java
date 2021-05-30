package Shop;

import Day4.TestBase;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @Test
    public void successfulUserRegistrationTest() {
        String firstName = "Bogdan";
        String lastname = "Wiadro";
        String email = "test" + System.currentTimeMillis() + "@test.com";
        HomepagePO homepagePO = new HomepagePO(driver);
        homepagePO.openMe();
        MenuPO menuPO = new MenuPO(driver);
        menuPO.clickSignInOutButton();
        LoginPO loginPO = new LoginPO(driver);
        loginPO.clickCreateAccountLink();
        CreateAccountPO createAccountPO = new CreateAccountPO(driver);
        createAccountPO.fillFormAndSubmit(true,
                firstName,
                lastname,
                email,
                "AAAABBBB",
                "2000-08-01");

    }


}
