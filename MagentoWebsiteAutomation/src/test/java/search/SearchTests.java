package search;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

public class SearchTests extends BaseTests {

    private HomePage homePage;

    @BeforeMethod
    public void setUpHomePage() {
        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void testInvalidSearchWithSpecialCharacters() {
        SearchResultsPage resultsPage = homePage.searchForProduct("!@#$%^&*()");

        String expectedMessage = "Your search returned no results.";
        String actualMessage = resultsPage.getEmptySearchMessage();

        Assert.assertEquals(actualMessage, expectedMessage, "Search with invalid input did not show expected message.");
    }

    @Test(priority = 2)
    public void testSearchSecurityWithMaliciousInput() {
        // XSS test
        SearchResultsPage resultsPage1 = homePage.searchForProduct("<script>alert(1)</script>");
        Assert.assertTrue(
                resultsPage1.getSearchHeadingText().contains("<script>alert(1)</script>") ||
                        resultsPage1.getEmptySearchMessage().length() > 0,
                "XSS input did not behave as expected"
        );

        // SQL Injection test
        SearchResultsPage resultsPage2 = homePage.searchForProduct("' OR '1'='1");
        Assert.assertTrue(
                resultsPage2.getSearchHeadingText().contains("' OR '1'='1") ||
                        resultsPage2.getEmptySearchMessage().length() > 0,
                "SQL-like input did not behave as expected"
        );
    }

    @Test(priority = 3)
    public void testSearchForValidProduct(){
        SearchResultsPage resultsPage = homePage.searchForProduct("hoodie");

        Assert.assertTrue(
                resultsPage.isResultHeadingContains("hoodie"),
                "Search result page heading does not contain the expected text."
        );
    }
}
