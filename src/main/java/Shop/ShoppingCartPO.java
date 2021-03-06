package Shop;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPO extends BasePO {
    @FindBy(css = ".cart-item")
    private List<WebElement> allCartItems;

    @FindBy(css = "#cart-subtotal-products .value")
    private WebElement subtotal;

    @FindBy(css = ".js-subtotal")
    private WebElement numberOfTotalItems;

    public int getTotalNumberofItemsInTheCart() {
        return Integer.parseInt(numberOfTotalItems.getText().replace(" sztuk", ""));
    }

    public double getSubtotal() {
        return Double.valueOf(subtotal.getText().replace(" zł", "")
                                                .replace(",", "."));
    }

    public String getNthCartItemsName(int n) {
        return getCartItems().get(n).getName();
    }


    private List<CartItemPO> getCartItems() {
        List<CartItemPO> cartItems = new ArrayList<>();
        for (WebElement e : allCartItems) {
            cartItems.add(new CartItemPO(e));
        }
        return cartItems;
    }

    public ShoppingCartPO(WebDriver driver) {
        super(driver);
    }
}
