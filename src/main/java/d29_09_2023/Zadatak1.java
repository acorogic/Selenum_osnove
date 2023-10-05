package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Zadatak1 {
    public static void main(String[] args) {


//    1.	Zadatak
//    Napisati program koji testira infinity scroll.
//            ●	Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//            ●	Selektujte delay od 2000ms, koristeci Select klasu.
//●	Skrol do Show more dugmeta koje se nalazi na dnu stranice
//●	Sacekajte da dugme bude klikljivo
//●	Klik na Show more dugme
//●	Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//●	Sacekajte da dugme vise ne bude klikljivo


     WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");

    Select delay = new Select(driver.findElement(By.id("delay-select")));
        delay.selectByValue("2000");

        new Actions(driver)
                .scrollToElement(driver.findElement(By.xpath("//div[text()='C']")))
            .perform();

       new Actions(driver)
               .scrollToElement(driver.findElement(By.id("infinite-scroll-button")))
            .perform();
}}
