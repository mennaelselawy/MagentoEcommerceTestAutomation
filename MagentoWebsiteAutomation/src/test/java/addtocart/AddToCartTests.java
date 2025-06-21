package addtocart;

import base.BaseTests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddToCartTests extends BaseTests {

    @BeforeMethod
    public void setUp(){
        driver.get("https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html");
        clickByProductName("Teton Pullover Hoodie");
    }
    @Test(priority = 1)
    public void testAddToCartWithoutSizeOption(){

        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        String sizeValidationMessage = productPage.getSizeValidation();
        assertEquals(sizeValidationMessage,"This is a required field.","Expected size validation message not found.");
        String colorValidationMessage = productPage.getColorValidation();
        assertEquals(colorValidationMessage,"This is a required field.","Expected color validation message not found.");
    }
    @Test(priority = 2)
    public void testAddHoodieToCart(){
        String successMessage = addHoodieToCart();
        assertTrue(successMessage.contains("You added Teton Pullover Hoodie to your shopping cart"),
                "Expected success message not found: " + successMessage);
    }
}
