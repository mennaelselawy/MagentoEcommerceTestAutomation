# 🛒 Magento E-Commerce Test Automation Project

## 📋 Project Overview
This project automates **end-to-end UI testing** for the demo Magento e-commerce website:  
🔗 [https://magento.softwaretestingboard.com](https://magento.softwaretestingboard.com)
### ✅ Goals
- Automate key user flows like search, add-to-cart, checkout, and review submission.
- Validate frontend input behavior and edge cases.
- Ensure test reliability using industry-standard best practices.

### 🔧 Tech Stack
- **Java 21**
- **Selenium WebDriver**
- **TestNG** (with built-in HTML reports)
- **Page Object Model (POM)**
- **Maven** for build & dependency management

## 📄 [Test Cases Sheet](https://docs.google.com/spreadsheets/d/1FKtGo0C9r2JM5o55GOhqGsgcpqp9pPJWF-PFyacDgzA/edit?usp=sharing)
https://docs.google.com/spreadsheets/d/1FKtGo0C9r2JM5o55GOhqGsgcpqp9pPJWF-PFyacDgzA/edit?usp=sharing

## 🐞Bug reports
[Submitted Product Reviews Not Visible](https://drive.google.com/file/d/1ecAp7Wzg4tXM8400X9MKcPe1iG2UEKaD/view?usp=sharing)

[Missing Validation in Shipping Address Form](https://drive.google.com/file/d/1xmDiqP-uN4cbXyivr675RkBLH5CUpDan/view?usp=sharing)


---

## 📁 Project Structure

```bash
MagentoWebsite/
├── resources/
│   ├── screenshots/                  # Failed test screenshots
│   │   ├── testInvalidShippingInfoValidation.png
│   │   └── testSubmitReviewAppearsInReviewsTab.png
│   └── chromedriver.exe             # WebDriver binary
│
├── src/
│   ├── main/java/pages/             # Page classes (POM)
│   │   ├── BasePage.java
│   │   ├── HomePage.java
│   │   ├── SearchResultsPage.java
│   │   ├── ProductPage.java
│   │   └── CheckoutPage.java
│
│   └── test/java/
│       ├── base/                    # Base setup class
│       │   └── BaseTests.java
│
│       ├── checkout/                # Checkout-related test cases
│       │   ├── CheckOutTests.java
│       │   └── EmptyCartCheckOutTests.java
│
│       ├── search/                  # Search-related test cases
│       │   └── SearchTests.java
│
│       ├── addtocart/               # Add-to-cart test cases
│       │   └── AddToCartTests.java
│
│       ├── reviews/                 # Review submission test cases
│       │   └── ReviewsTests.java
│
│       └── listeners/               # Listener for screenshot on failure
│           └── TestListener.java
│
├── testng.xml                       # TestNG suite configuration
├── pom.xml                          # Maven configuration
```

## 🧪 Test Cases Automated

| TC ID | Description                                 | Status |
|-------|---------------------------------------------|--------|
| TC001 | Search for an existing product              | ✅ Pass |
| TC002 | Add hoodie to cart                          | ✅ Pass |
| TC003 | Guest checkout                              | ✅ Pass |
| TC004 | Invalid search with special characters      | ✅ Pass |
| TC005 | Add to cart without selecting size          | ✅ Pass |
| TC006 | Checkout with empty cart                    | ✅ Pass |
| TC007 | Submitted product review visibility         | ❌ Fail |
| TC008 | Input validation in global search           | ✅ Pass |
| TC009 | Validate address and phone during checkout  | ❌ Fail |


## 🛠️ How to Setup

### 1️⃣ Clone the repo:
```bash
   git clone https://github.com/mennaelselawy/MagentoEcommerceTestAutomation
   cd MagentoEcommerceTestAutomation
```

### 2️⃣  Make sure ChromeDriver matches your browser version. If needed, update it in:

```
    resources/chromedriver.exe
```

### 3️⃣  Install dependencies:
```bash
    mvn clean install
```

## ▶️ Run Tests
```bash
    mvn clean test
```

## 📊 View Test Report
After running, view the report here:
```bash
    MagentoWebsite/target/surefire-reports/index.html
    MagentoWebsite/target/surefire-reports/emailable-report.html
```
Or open:
```bash
    start target/surefire-reports/index.html
```

## 📷 Screenshots:

Failed test screenshots are saved in:
    
```
    resources/screenshots/
    resources/screenshots/testInvalidShippingInfoValidation.png
    resources/screenshots/testSubmitReviewAppearsInReviewsTab.png
```

