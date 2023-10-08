package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak4 {
    public static void main(String[] args) throws IOException {
//        4. Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://itbootcamp.rs/
//        Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
//        Cita sve linkove slika iz slajdera
//        Proverava url svake slike, i za sve slike koje imaju status veci i jednak
//    od 200 a manji od 300, skida i smesta u folder itbootcamp_slider u okviru projekta
//        Azurirajte gitignore da ignorise itbootcamp_slider folder

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.navigate().to("https://itbootcamp.rs/");

        new Actions(driver)
                .scrollToElement(driver.findElement(By.cssSelector("div.tcowl-wrap ")));

List<WebElement> images= driver.findElements(By.cssSelector("div.carousel-item>img"));
        System.out.println(images.size());
        for (int i = 0; i < images.size(); i++) {


                String imgSource = images.get(i).getAttribute("src");
                int statusCode = Helper.getHTTPResponseStatusCode(imgSource);
                if(statusCode>=200 && statusCode<300){
                    Helper.downloadUsingStream(imgSource, "itbootcamp_slider/img-"+i+".png");
                }

        }
    }
}
