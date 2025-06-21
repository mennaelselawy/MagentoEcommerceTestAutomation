package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.ProductPage;

public class BaseTests {
    protected static WebDriver driver;

    @BeforeSuite
    public void setUp(){
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://magento.softwaretestingboard.com/");
        }
    }

    @AfterSuite
    public void tearDown(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    //Reusable method
    public String addHoodieToCart() {
//        driver.get("https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html");
//        driver.findElement(By.xpath("//img[@alt='Teton Pullover Hoodie']/ancestor::a")).click();
        ProductPage productPage = new ProductPage(driver);
        productPage.selectSizeM();
        productPage.selectColorBlack();
        productPage.clickAddToCart();
       return productPage.getSuccessMessage();
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void clickByProductName(String productName) {
        driver.findElement(By.xpath("//img[@alt='" + productName + "']/ancestor::a")).click();
    }
}
