package reviews;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ProductPage;

import static org.testng.Assert.assertTrue;

public class ReviewsTests extends BaseTests {

    @Test(priority = 1)
    public void testSubmittedReviewAppearsInReviewsTab() {
        driver.get("https://magento.softwaretestingboard.com/teton-pullover-hoodie.html");

        ProductPage productPage = new ProductPage(driver);

        productPage.clickReviewsTab();
        productPage.selectRating();
        productPage.submitReview(
                "testuser",
                "Great product!",
                "I love the material and fit."
        );

//        boolean messageVisible = productPage.isSuccessMessageVisible();
//        assertTrue(messageVisible, "Success message not shown after submitting review.");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".message-success.success.message")));

        driver.navigate().refresh();
        productPage.clickReviewsTab();

        boolean reviewFound = productPage.isReviewVisible("I love the material and fit.");
        assertTrue(reviewFound, "Submitted review is NOT visible in the Reviews tab.");
    }
}
