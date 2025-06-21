package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public By cartIcon = By.cssSelector(".showcart");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickCartIcon(){
         driver.findElement(cartIcon).click();
    }

}
