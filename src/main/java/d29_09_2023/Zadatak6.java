package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak6 {
    public static void main(String[] args) {

//        6.Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//        Vrsi klik na Primary dugme, Secondary, Sucess, Danger
//        Ceka da broj toasts-a bude 4
//        Ispisuje poruku, toasts su prikazani
//        Ceka da broj toasts-a bude 0
//        Ispisuje poruku, toasts su se izgubili

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();





        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");


        driver.findElement(By.id("basic-primary-trigger"))
                .click();

        driver.findElement(By.id("basic-secondary-trigger"))
                .click();

        driver.findElement(By.id("basic-success-trigger"))
                .click();
        driver.findElement(By.id("basic-danger-trigger"))
                .click();

        wait
                .withMessage("# of toasts doesn't match")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.toast-fixed.show"),4));
        System.out.println("4 toasts displayed");
        wait
                .withMessage("more than zero toast displayed")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.toast-fixed.show"),0));
        System.out.println("zero toast displayed");
    }
}
