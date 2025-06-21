package checkout;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class EmptyCartCheckOutTests extends BaseTests {

    @Test
    public void testProceedToCheckoutWithEmptyCart() {
        driver.get("https://magento.softwaretestingboard.com/");

        HomePage homePage = new HomePage(driver);
        homePage.clickCartIcon();

        By cartEmptyMessage = By.cssSelector(".minicart-wrapper .subtitle.empty");
        WebElement emptyMsgElement = homePage.waitForElement(cartEmptyMessage);
        String expectedMessage = "You have no items in your shopping cart.";
        String actualMessage = emptyMsgElement.getText();

        assertEquals(actualMessage, expectedMessage, "Cart did not display the correct empty message.");
    }
}
