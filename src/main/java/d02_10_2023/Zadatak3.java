package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak3 {

    public static void main(String[] args) throws IOException {

//        3. Napisati program koji:
//        Ucitava stranicu https://demoqa.com/broken
//        Hvata oba linka sa stranice i
//        Za svaki link proverava status da je veci ili jednak od 200 i manji od 400
//        Koristan link za citanje status koda nekog url-a
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://demoqa.com/broken");

        List<WebElement> links= driver.findElements(By.xpath("//div[contains(@class, 'col-12 mt-4 col-md-6')]/div[2]/a"));

        for (int i = 0; i < links.size(); i++) {
            int responseCode= Helper.getHTTPResponseStatusCode(links.get(i).getAttribute("href"));

        }

    }
}
