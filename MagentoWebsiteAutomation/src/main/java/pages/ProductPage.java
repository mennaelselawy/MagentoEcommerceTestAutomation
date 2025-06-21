package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductPage extends BasePage {
    private By sizeOption = By.id("option-label-size-143-item-168"); //M
    private By colorOption = By.id("option-label-color-93-item-49");  //Black
    private By addToCartButton = By.cssSelector("button#product-addtocart-button");
    private By successMessage = By.cssSelector("div[data-ui-id='message-success']");

    private By sizeValidationMessage = By.id("super_attribute[143]-error");
    private By colorValidationMessage = By.id("super_attribute[93]-error");

    private By reviewsTab = By.cssSelector("a[href='#reviews']");
    private By nicknameField = By.id("nickname_field");
    private By summaryField = By.id("summary_field");
    private By reviewField = By.id("review_field");
    private By submitReviewButton = By.cssSelector("button.action.submit.primary");
//    private By reviewSuccessMessage = By.cssSelector(".message-success.success.message");
    private By postedReviewText = By.cssSelector(".review-content"); // Might vary
    private By fifthRatingStar = By.cssSelector("input[id^='Rating_5']");
    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void selectSizeM(){
        waitForElement(sizeOption).click();
    }

    public void selectColorBlack() {
        waitForElement(colorOption).click();
    }

    public void clickAddToCart() {
        waitForElement(addToCartButton).click();
    }

    public String getSuccessMessage() {
        return waitForElement(successMessage).getText();
    }

    public String getSizeValidation(){
        return waitForElement(sizeValidationMessage).getText();
    }
    public String getColorValidation(){
        return waitForElement(colorValidationMessage).getText();
    }

    public void clickReviewsTab() {
        waitForElement(reviewsTab).click();
    }
    public void submitReview(String nickname, String summary, String review) {
        waitForElement(nicknameField).sendKeys(nickname);
        waitForElement(summaryField).sendKeys(summary);
        waitForElement(reviewField).sendKeys(review);
        waitForElement(submitReviewButton).click();
    }
    public boolean isReviewVisible(String reviewText) {
        try {
            return waitForElement(postedReviewText).getText().contains(reviewText);
        } catch (Exception e) {
            return false;
        }
    }
    public void selectRating() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ratingStar = wait.until(ExpectedConditions.elementToBeClickable(fifthRatingStar));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ratingStar);
    }

}
