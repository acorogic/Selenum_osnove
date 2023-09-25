package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class UvodUListe {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://cms.demo.katalon.com/");
        driver.manage().window().maximize();
        List<WebElement> links = driver.findElements(By.cssSelector("li.page_item"));
        //lista se kreira prema broju dostupnih elemenata, moze da bude i prazna
        System.out.println(links.size());
     }
}
