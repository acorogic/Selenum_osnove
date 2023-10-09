package d05_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import p05_10_2023.SwagLabsRetry;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SwagLabsTests {
    private WebDriver driver;
    private WebDriverWait wait;

    private String baseUrl = "https://www.saucedemo.com/";


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforMethod() {
        driver.manage().deleteAllCookies();
        driver.navigate().to(baseUrl);
    }

    @Test
    public void VerifyErrorIsDisplayedWhenUsernameIsMissing() throws InterruptedException {


//        Test #1:  Verify error is displayed when username is missing
//        Koraci:
//        Ucitati home stranicu
//        Klik na login dugme
//        Verifikovati da je prikazana poruka Epic sadface: Username is required
        driver.findElement(By.id("user-name"))
                .click();

        driver.findElement(By.id("login-button"))
                .click();

        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        wait.withMessage("message didn't show")
                .until(ExpectedConditions
                        .textToBePresentInElement(errorMessage, "Epic sadface: Username is required"));
        System.out.println("error message works");
    }

    @Test
    public void VerifyErrorIsDisplayedWhenPasswordIsMissing() throws InterruptedException {

//    Test #2:  Verify error is displayed when password is missing
//    Koraci:
//    Ucitati home stranicu
//    Uneti username
//    Klik na login dugme
//    Verifikovati da je prikazana poruka Epic sadface: Password is required
        driver.findElement(By.id("user-name"))
                .sendKeys("testerUser");

        driver.findElement(By.id("login-button"))
                .click();

        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        wait.withMessage("message didn't show")
                .until(ExpectedConditions
                        .textToBePresentInElement(errorMessage, "Epic sadface: Password is required"));


    }

    @Test

    public void VerifyErrorIsDisplayedWhenCredentialsAreWrong() throws InterruptedException {

        //        Test #3:  Verify error is displayed when credentials are wrong
//        Podaci:
//        username: standard_user
//        password: invalidpassword
//        Koraci:
//        Ucitati home stranicu
//        Uneti username i password
//        Klik na login dugme
//        Verifikovati da je prikazana poruka Epic sadface: Username and password do not match any user in this service

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("invalidpassword");

        driver.findElement(By.id("login-button"))
                .click();

        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        wait.withMessage("message didn't show")
                .until(ExpectedConditions
                        .textToBePresentInElement(errorMessage,
                                "Epic sadface: Username and password do not match any user in this service"));



    }


    @Test

    public void VerifyErrorIsDisplayedWhenUserIsLocked() throws InterruptedException {
//        Test #4:  Verify error is displayed when user is locked
//        Podaci:
//        username: locked_out_user
//        password: secret_sauce
//        Koraci:
//        Ucitati home stranicu
//        Uneti username i password
//        Klik na login dugme
//        Verifikovati da je prikazana poruka Epic sadface: Sorry, this user has been locked out.

        driver.findElement(By.id("user-name"))
                .sendKeys("locked_out_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        wait.withMessage("message didn't show")
                .until(ExpectedConditions
                        .textToBePresentInElement(errorMessage,
                                "Epic sadface: Sorry, this user has been locked out."));



    }

    @Test


    public void VerifySuccessfulLogin() throws InterruptedException {


//    Test #5:  Verify successful login
//    Podaci:
//    username: standard_user
//    password: secret_sauce
//    Koraci:
//    Ucitati home stranicu
//    Uneti username i password
//    Klik na login dugme
//    Verifikovati da je url stranice /inventory.html
//    Klik na Menu iz gornjeg lovog ugla
//    Sacekati da se prikaze meni
//    Verifikovati da Logout dugme postoji
//    Klik na logout
//    Verifikovati da je prikazana login forma

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        Thread.sleep(2000);


        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"),
                "URl is not correct");

        driver.findElement(By.id("react-burger-menu-btn"))
                .click();

        WebElement logOutButton = driver.findElement(By.id("logout_sidebar_link"));

        // Assert.assertTrue(logOutButton.isDisplayed(), "login button is not displayed");

        wait
                .withMessage("login button is not displayed")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));

        logOutButton
                .click();

        wait.withMessage("log in form is not dispayed")
                .until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));

        //driver.findElement(By.id("login-button"))
        //                .click();


    }

    @Test (priority = 1, retryAnalyzer = SwagLabsRetry.class)
    //povezuje ga sa klasom koja ponavlja test odredjeni broj puta
    public void AddingProductsToCart () throws InterruptedException {
//        Test #6:  Adding Products to Cart
//        Podaci:
//        username: standard_user
//        password: secret_sauce
//        Koraci:
//        Ucitati home stranicu
//        Uneti username i password
//        Klik na login dugme
//        Verifikovati da je url stranice /inventory.html

//        Pronađite proizvod "Sauce Labs Backpack" na početnoj stranici.
//                Klik na Add to cart pored proizvoda.
//        Proverite da se pojavilo Remove dugme
//        Proverite da li se broj proizvoda u korpi povećao na 1.

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        Thread.sleep(2000);


        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"),
                "URl is not correct");

driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
        .click();

Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-backpack"))
        .getText().equals("Remove"), "remove button is not present");
Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"))
        .getText().equals("1"));


    }


    @Test

    public void ViewingProductDetails () throws InterruptedException {


//        Test #7: Viewing Product Details
//        Podaci:
//        username: standard_user
//        password: secret_sauce
//        Koraci:
//        Ucitati home stranicu
//        Uneti username i password
//        Klik na login dugme
//        Verifikovati da je url stranice /inventory.html

//        Pronađite proizvod "Sauce Labs Backpack" na početnoj stranici.
//                Klik na proizvod
//        Proverite da li se prikazuju detalji proizvoda, uključujući cenu,
//                opis i dugme za dodavanje u korpu

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        Thread.sleep(2000);


        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"),
                "URl is not correct");

        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']"))
                .click();

Assert.assertTrue(driver
        .findElement(By.cssSelector(".inventory_details_desc.large_size"))
        .getText().contains("carry.allTheThings() with the sleek, streamlined " +
                "Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."),
        "description doesn't exist");

Assert.assertTrue(driver
        .findElement(By.cssSelector(".inventory_details_price")).getText().equals("$29.99"),
        "price is not ok");

Assert.assertTrue(driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
        .isDisplayed(), "button ADD TO CHART is not present");


    }

    @Test

    public void RemovingProductsFromCart() throws InterruptedException {


//        Test #8: Removing Products from Cart
//        Podaci:
//        username: standard_user
//        password: secret_sauce
//        Koraci:
//        Ucitati home stranicu
//        Uneti username i password
//        Klik na login dugme
//        Verifikovati da je url stranice /inventory.html
//        Pronađite proizvod "Sauce Labs Backpack" na početnoj stranici.
//                Klik na Add to cart pored proizvoda.
//        Proverite da li se broj proizvoda u korpi povećao na 1.
//        Kliknuti na korpu iz navigacije
//        Proverite da li se proizvod "Sauce Labs Backpack" ubacio u korpu.
//                Klik na Remove dugme pored proizvoda
//        Proverite da li se proizvod "Sauce Labs Backpack" izbacio iz korpe.

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();




        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"),
                "URl is not correct");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();


        wait
                .withMessage("the number of chart items have  not changed")
                        .until(ExpectedConditions
                                .textToBe(By.className("shopping_cart_badge"), "1"));

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        wait
                .withMessage("Item 'Sauce Labs Backpack' is not removed from the cart")
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[text()='Sauce Labs Backpack']"),0));



    }






@Test

        public void ProductCheckout() {


//            Test #9: Product Checkout
//            Podaci:
//            username: standard_user
//            password: secret_sauce
//            checkout name: Pera
//            checkout last name: Peric
//            checkout zip: 18000
//            Koraci:
//            Ucitati home stranicu
//            Uneti username i password
//            Klik na login dugme
//            Verifikovati da je url stranice /inventory.html
//            Pronađite proizvod "Sauce Labs Backpack" na početnoj stranici.
//                    Klik na Add to cart pored proizvoda.
//            Proverite da li se broj proizvoda u korpi povećao na 1.
//            Kliknuti na korpu iz navigacije
//            Klik na checkout dugme iz korpe
//            Unesite podatke za checkout formu
//            Klik na continue
//                    Proverite da li su podaci na Checkout: Overview stranici ispravni
//            Klik na finish
//            Validirati da se prikazuje poruka za uspesno porucivanje Thank you for your order!

    String username = "standard_user";
    String password = "secret_sauce";

    String checkoutName = "Zika";
    String checkoutLastName = "Peric";
    String checkoutZip = "123456";

    driver.findElement(By.id("user-name")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.id("login-button")).click();

    driver.findElement(By.id("user-name"))
            .sendKeys("standard_user");

    driver.findElement(By.id("password"))
            .sendKeys("secret_sauce");

    driver.findElement(By.id("login-button"))
            .click();


    Assert
            .assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"),
            "URl is not correct");

    driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
            .click();


    wait
            .withMessage("the number of chart items have  not changed")
            .until(ExpectedConditions
                    .textToBe(By.className("shopping_cart_badge"), "1"));

    driver.findElement(By.cssSelector("span.shopping_cart_badge"))
            .click();

    wait
            .withMessage("Cart page did not open")
            .until(ExpectedConditions.presenceOfElementLocated(By.id("checkout"))).click();

    wait
            .withMessage("Checkout form is not present")
            .until(ExpectedConditions.presenceOfElementLocated(By.id("checkout_info_container")));

    driver.findElement(By.id("first-name")).sendKeys(checkoutName);
    driver.findElement(By.id("last-name")).sendKeys(checkoutLastName);
    driver.findElement(By.id("postal-code")).sendKeys(checkoutZip);
    driver.findElement(By.id("continue")).click();

    wait
            .withMessage("Checkout overview is not visible on the page")
            .until(ExpectedConditions.presenceOfElementLocated(By.id("checkout_summary_container")));

    Assert.assertEquals(driver.findElement(By.className("cart_quantity"))
            .getText(),"1", "Quantity is not 1");
    Assert.assertEquals(driver.findElement(By.className("inventory_item_name"))
            .getText(),"Sauce Labs Backpack", "There is no Sauce Labs item");
    Assert.assertEquals(driver.findElement(By.className("inventory_item_price"))
            .getText(), "$29.99", "Price is not 29.99");

    Assert.assertEquals(driver.findElement(By.className("summary_subtotal_label"))
            .getText(), "Item total: $29.99", "Subtotal is not 29.99");

    driver.findElement(By.id("finish")).click();
    wait
            .withMessage("There is no thank you screen")
            .until(ExpectedConditions.presenceOfElementLocated(By.className("complete-header")));

    Assert.assertEquals(driver.findElement(By.className("complete-header"))
            .getText(), "Thank you for your order!", "There is no Thank you message");

}


    @Test
    public void validateSocialLinksInFooter() throws IOException, IOException {
        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"inventory.html", "Should be redirected to inventory page after login");
        WebElement footer = driver.findElement(By.className("footer"));
        new Actions(driver)
                .scrollToElement(footer)
                .perform();

        String twitterUrl = driver.findElement(By.cssSelector(".social_twitter>a")).getAttribute("href");
        String facebookUrl=driver.findElement(By.cssSelector(".social_facebook>a")).getAttribute("href");
        String linkedinUrl = driver.findElement(By.cssSelector(".social_linkedin>a")).getAttribute("href");

        int statusFacebook = Helper.getHTTPResponseStatusCode(facebookUrl);
        int statusLinkedin = Helper.getHTTPResponseStatusCode(linkedinUrl);
        int statusTwitter = Helper.getHTTPResponseStatusCode(twitterUrl);
        System.out.println(statusFacebook);

        Assert.assertEquals(statusFacebook, 200, "Status code for Facebook is not 200");
        Assert.assertEquals(statusTwitter, 200, "Status code for Twitter is not 200");
        Assert.assertEquals(statusLinkedin, 200, "Status code for Linkedin is not 200");
    }

    @Test
    public void testDefaultNameSort() {
        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"inventory.html",
                "Should be redirected to inventory page after login");
        List<WebElement>productNames = driver.findElements(By.className("inventory_item_name"));
        String previous = "";

        for (int i = 0; i < productNames.size(); i++) {
            Assert.assertFalse(productNames.get(i).getText().compareTo(previous)<0,
                    "Products are not in alphabetical order");
            previous = productNames.get(i).getText();
        }
    }

    @Test
    public void testInvertNamedSort(){
        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"inventory.html",
                "Should be redirected to inventory page after login");

        Select sortDropdown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropdown.selectByValue("za");

        List<WebElement>productNames = driver.findElements(By.className("inventory_item_name"));
        String previous=productNames.get(0).getText();
        for (int i = 0; i < productNames.size(); i++) {
            Assert.assertFalse(productNames.get(i).getText().compareTo(previous)>0,
                    "Products are not in reverse alphabetical order");
            previous = productNames.get(i).getText();
        }
    }

    @Test
    public void testSortPriceLowHigh(){

        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"inventory.html",
                "Should be redirected to inventory page after login");
        Select sortDropdown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropdown.selectByValue("lohi");

        List<WebElement>productPrices = driver.findElements(By.className("inventory_item_price"));
        double previous = 0;
        for (int i = 0; i < productPrices.size(); i++) {
            double price = Double.parseDouble(productPrices.get(i).getText().substring(1));
            Assert.assertTrue(price>=previous,"Prices are not low to high");
            previous = price;
        }}









    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}



