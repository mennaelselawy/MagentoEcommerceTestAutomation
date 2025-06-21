package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private By emailField = By.id("customer-email");
    private By firstNameField = By.name("firstname");
    private By lastNameField = By.name("lastname");
    private By companyField = By.name("company");
    private By streetField = By.name("street[0]");
    private By cityField = By.name("city");
    private By regionDropdown = By.name("region_id");
    private By zipField = By.name("postcode");
    private By countryDropdown = By.name("country_id");
    private By phoneField = By.name("telephone");
    private By shippingMethod = By.cssSelector("input[name='ko_unique_1']"); // might vary
    private By nextButton = By.cssSelector("button.continue");

    private By placeOrderButton = By.cssSelector("button.action.primary.checkout");

    private By confirmationMessage = By.cssSelector(".checkout-success p:nth-of-type(1)");

    private By shippingMethodSection = By.id("checkout-shipping-method-load");

    public void fillGuestDetails() {
        waitForElement(emailField).sendKeys("test@example.com");
        waitForElement(firstNameField).sendKeys("John");
        waitForElement(lastNameField).sendKeys("Doe");
        waitForElement(companyField).sendKeys("Sprints");
        waitForElement(streetField).sendKeys("123 Main St");
        waitForElement(cityField).sendKeys("New York");

        waitForElement(regionDropdown); // Make sure it's visible before selecting
        Select regionSelect = new Select(driver.findElement(regionDropdown));
        regionSelect.selectByVisibleText("New York");

        waitForElement(zipField).sendKeys("10001");

        Select countrySelect = new Select(driver.findElement(countryDropdown));
        countrySelect.selectByVisibleText("United States");

        waitForElement(phoneField).sendKeys("1234567890");
    }

    public void enterWrongValuesInShippingForm(){
        waitForElement(emailField).sendKeys("test@example.com");
        waitForElement(firstNameField).sendKeys("j");
        waitForElement(lastNameField).sendKeys("D");
        waitForElement(companyField).sendKeys("S");
        waitForElement(streetField).sendKeys("test");
        waitForElement(cityField).sendKeys("New");

        waitForElement(regionDropdown); // Make sure it's visible before selecting
        Select regionSelect = new Select(driver.findElement(regionDropdown));
        regionSelect.selectByVisibleText("New York");

        waitForElement(zipField).sendKeys("10001");

        Select countrySelect = new Select(driver.findElement(countryDropdown));
        countrySelect.selectByVisibleText("United States");

        waitForElement(phoneField).sendKeys("abc");
    }

    public void selectShippingMethod() {
        waitForElement(shippingMethod).click();
        waitForElement(nextButton).click();
    }

    public void placeOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-mask")));
        WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        placeOrderBtn.click();
    }


    public String getConfirmationMessage() {
        return waitForElement(confirmationMessage).getText();
    }

    public boolean isShippingMethodDisplayed() {
        try {
            return waitForElement(shippingMethodSection).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

