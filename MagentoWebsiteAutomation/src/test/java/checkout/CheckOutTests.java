package checkout;

import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CheckoutPage;

import static org.testng.Assert.*;

public class CheckOutTests extends BaseTests {

    @Test(priority = 1)
    public void testGuestCheckout() {

        driver.get("https://magento.softwaretestingboard.com/checkout/");

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.fillGuestDetails();
        checkoutPage.selectShippingMethod();
        checkoutPage.placeOrder();

        String confirmation = checkoutPage.getConfirmationMessage();
        assertTrue(confirmation.contains("Your order # is: "),
                "Expected confirmation message not found: " + confirmation);
    }

    @Test(priority = 2)
    public void testInvalidShippingInfoValidation() {
        driver.get("https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html");
        clickByProductName("Teton Pullover Hoodie");
//        driver.findElement(By.xpath("//img[@alt='Teton Pullover Hoodie']/ancestor::a")).click();
        String successMessage = addHoodieToCart();
        assertTrue(successMessage.contains("Teton Pullover Hoodie"));
        driver.get("https://magento.softwaretestingboard.com/checkout/");
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.waitForPageToLoadFully();
        checkoutPage.enterWrongValuesInShippingForm();
        checkoutPage.selectShippingMethod();
        checkoutPage.placeOrder();

        boolean orderPlaced = false;
        try {
            String confirmationMessage = checkoutPage.getConfirmationMessage();
            if (confirmationMessage.contains("Your order # is: ")) {
                orderPlaced = true;
            }
        } catch (Exception e) {
            // Expected: no confirmation message — do nothing
        }

        // Final assertion to make sure order was NOT placed
        assertFalse(orderPlaced, "Order was placed despite invalid shipping info — this is a bug!");

    }
}
