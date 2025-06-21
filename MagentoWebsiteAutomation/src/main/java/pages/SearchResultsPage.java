package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage{

    private By resultHeading = By.cssSelector(".page-title span");
    private By noResultsMessage = By.cssSelector("div.message.notice");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchHeadingText() {
        WebElement heading = waitForElement(resultHeading);
        return heading.getText();
    }

    public boolean isResultHeadingContains(String term) {
        return getSearchHeadingText().toLowerCase().contains(term.toLowerCase());
    }

    public String getEmptySearchMessage() {
        WebElement noResult = waitForElement(noResultsMessage);
        return noResult.getText();
    }
}
