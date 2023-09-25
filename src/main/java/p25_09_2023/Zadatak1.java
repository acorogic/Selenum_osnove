package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

    public static void main(String[] args) throws InterruptedException {

//
//        1.Zadatak
//        Napisati program koji:
//        Maksimizuje prozor
//        Ucitava stranicu https://cms.demo.katalon.com/
//        U delu za pretragu unosi tekst Flying Ninja.
//        Klikce na dugme za pretragu. Dugme sa lupom.
//                Kada trazite element dohvatite element koji je po tagu button a ne span.
//                Ceka 5 sekuni
//        Zatvara pretrazivac

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://cms.demo.katalon.com/");
        driver.manage().window().maximize();
        WebElement searchField= driver.findElement(By.xpath("//input[@placeholder='Type to search']"));
        //input[@name='s'] xpath
        //.search-field
        //input[name='s'] css
        searchField.click();

        searchField.sendKeys("Flying Ninja");
//find by name("s")


        WebElement lupa= driver.findElement(By.xpath("//*[@class=\"search-submit\"]"));
        lupa.click();
        // css .search-submit
        Thread.sleep(5000);
        driver.quit();


    }
}
