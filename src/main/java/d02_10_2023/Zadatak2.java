package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        2. Zadatak
//        Napisati program koji:
//        Ucitava stranu https://itbootcamp.rs/
//        Misem prelazi preko Vesti iz navigacionog menija
//        Ceka da se prikaze padajuci meni za Vesti
//        Misem prelazi preko Kursevi iz navigacionog menija
//        Ceka da se prikaze padajuci meni za Kursevi
//        Misem prelazi preko Prijava i pravilnik iz navigacionog menija
//        Ceka da se prikaze padajuci meni za Prijava i pravilnik
//        Koristan link. Mouse over preko seleniuma https://www.selenium.dev/
//        // documentation/webdriver/actions_api/mouse/#move-to-element
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.navigate().to("https://itbootcamp.rs/");

        WebElement vesti = driver.findElement(By.cssSelector("li#menu-item-6408>a.dropdown-toggle "));
        new Actions(driver)
                .moveToElement(vesti)
                .perform();

        wait
                .withMessage("dropdown meny is not visible")
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .cssSelector(" li#menu-item-6408>ul.dropdown-menu")));



        WebElement kursevi = driver.findElement(By.cssSelector("li#menu-item-5362>a.dropdown-toggle "));
        new Actions(driver)
                .moveToElement(vesti)
                .perform();

        wait
                .withMessage("dropdown meny is not visible")
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .cssSelector(" li#menu-item-5713>ul.dropdown-menu")));
        Thread.sleep(3000);


        WebElement prijavaIpravilnik = driver.findElement(By.cssSelector("li#menu-item-5453>a.dropdown-toggle "));
        new Actions(driver)
                .moveToElement(prijavaIpravilnik)
                .perform();

        wait
                .withMessage("dropdown meny is not visible")
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .cssSelector(" li#menu-item-9232>ul.dropdown-menu")));
        Thread.sleep(3000);



        driver.quit();
    }
}
