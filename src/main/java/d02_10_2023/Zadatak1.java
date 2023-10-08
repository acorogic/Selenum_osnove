package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
//
//        1.Zadatak
//        Napisati program koji:
//        Podesava:
//        implicitno cekanje za trazenje elemenata od 10s
//        implicitno cekanje za ucitavanje stranice od 10s
//        eksplicitno cekanje podeseno na 10s
//        Podaci:
//        Potrebno je u projektu ukljuciti 4 slike:
//        front.jpg
//        left.jpg
//        right.jpg
//        back.jpg
//        Koraci:
//        Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//        Maksimizuje prozor
//        Klik na edit ikonicu
//        Klik na delete iz iskacuceg dijaloga
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte front.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 1.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte right.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 2.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte back.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 3.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte back.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 3.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Sacekajte da Next dugme bude klikljivo
//        Klik na Next dugme
//        Unesite tekst
//        Klik na Next
//        Klik na Preview
//        Klik na Add to cart
//        Sacekajte 5s
//                Quit



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.navigate().to("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");

driver.findElement(By.cssSelector("img.edit-image"))
                .click();



driver.findElement(By.cssSelector("div#image-option-replace>svg"))
                .click();


        File front= new File("test_data/front.jpg");
        front.getAbsoluteFile();

driver.findElement(By.id("imageUpload"))
                .sendKeys(front.getAbsolutePath());

driver.findElement(By.cssSelector("img#image-option-0"))
                .click();
        WebElement doneButton= driver.findElement(By.cssSelector("button[type=submit]"));
                wait.until(ExpectedConditions.elementToBeClickable(doneButton))
                                .click();

        Thread.sleep(2000);


        driver.findElement(By.cssSelector("img.edit-image"))
                .click();


        File left = new File("test_data/left.jpg");
        front.getAbsoluteFile();

        driver.findElement(By.id("imageUpload"))
                .sendKeys(left.getAbsolutePath());

        driver.findElement(By.cssSelector("img#image-option-0"))
                .click();
        Thread.sleep(2000);
       driver.findElement(By.cssSelector("div#image-crop-done-button"))
                       .click();

        Thread.sleep(2000);

        File right = new File("test_data/right.jpg");
        front.getAbsoluteFile();

        driver.findElement(By.id("imageUpload"))
                .sendKeys(right.getAbsolutePath());

        driver.findElement(By.cssSelector("img#image-option-0"))
                .click();
        driver.findElement(By.cssSelector("div#image-crop-done-button"))
                .click();

        Thread.sleep(2000);


        File back = new File("test_data/back.jpg");
        front.getAbsoluteFile();

        driver.findElement(By.id("imageUpload"))
                .sendKeys(back.getAbsolutePath());

        driver.findElement(By.cssSelector("img#image-option-0"))
                .click();
        driver.findElement(By.cssSelector("div#image-crop-done-button"))
                .click();

        Thread.sleep(2000);

wait
        .withMessage("button next is not present")
        .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#next-button")))
                .click();

driver.findElement(By.cssSelector("textarea#textareaID"))
                .sendKeys("Teenage Mutant Ninja Turtles");

driver.findElement(By.cssSelector("button#next-button"))
                .click();
        driver.findElement(By.cssSelector("button#next-button"))
                .click();
        driver.findElement(By.cssSelector("button#next-button"))
                .click();
        driver.findElement(By.cssSelector("div.scroll-bar>div:nth-child(1)"))
                        .click();
        driver.findElement(By.cssSelector("div.close>svg"))
                        .click();
        driver.findElement(By.cssSelector("button#next-button"))
                        .click();

        Thread.sleep(5000);



        driver.quit();
    }
}
