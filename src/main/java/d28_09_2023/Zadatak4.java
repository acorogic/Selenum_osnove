package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) {

//        4.Zadatak
//        Ucitati stranicu http://seleniumdemo.com/?post_type=product
//        Klik na search dugme u gornjem desnom uglu
//        Cekati da forma za pretragu bude vidljiva
//        Uneti sledeci tekst za pretragu BDD Cucumber i ENTER
//        Dohvatiti prvi rezultat pretrage i proveriti da li u
//        nazivu sadrzi tekst koji je unet za pretragu. Ispisati odgovarajuce poruke u terminalu
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("http://seleniumdemo.com/?post_type=product");
        driver.findElement(By.xpath("//a[@class='search-toggle_btn icn-search czr-overlay-toggle_btn']"))
                .click();

        wait
                .withMessage("Search form is not visible")
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='lsearch-651d55a92ddf6']//span[contains(text(),'Search')]")));


        driver.findElement(By.id("s-651536d633c09")).sendKeys("BDD Cucumber");
        driver.findElement(By.id("s-651536d633c09")).sendKeys(Keys.ENTER);

        wait.withMessage("Search ressult is not equal to entered text").until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("[title='Permalink to BDD Cucumber']"), "BDD Cucumber"));




    }
}
