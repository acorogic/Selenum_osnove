package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {



//    2.	Zadatak
//    Napisati program koji:
//            ●	Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//            ●	Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice
//    i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//    ●	POMOC: Brisite elemente odozdo.
//    ●	(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo
////

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");
        Thread.sleep(1000);
        List<WebElement> buttons = driver.findElements(By.xpath("//button[@type=\"button\"]"));




        while (!buttons.isEmpty()){
            driver.findElement(By.xpath("//div[@class='col-md-12']/div[last()]/button")).click();
            int broj = buttons.size();
            buttons = driver.findElements(By.xpath("//div[@class='col-md-12']/div"));
            if (broj - 1 == buttons.size()){
                System.out.println("Deleted!");
            }
            Thread.sleep(1000);
        }
        Thread.sleep(2000);
        driver.quit();

    }
        



}
