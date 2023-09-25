package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak5 {


//    https://www.kupujemprodajem.com/
//    Program petljom prolazi kroz niz stranica i svaku stranicu ucitava
//    preko get ili navigate i od svake stranice na ekranu ispisuje naslov stranice.
//    Kako od stranice procitati naslov imate na ovom linku
//    U prevodu u konzoli treba da se ispisu:
//    Google
//            YouTube
//    Electronics, Cars, Fashion, Collectibles & More | eBay
//            KupujemProdajem
//    Zatvara pretrazivac

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        List<String> linkovi= new ArrayList<>();
        linkovi.add("https://google.com/");
        linkovi.add("https://youtube.com/");
        linkovi.add("https://www.ebay.com/");
        linkovi.add("https://www.kupujemprodajem.com/");

        for (int i = 0; i < linkovi.size(); i++) {
            driver.get(linkovi.get(i));
            System.out.println(driver.getTitle());

        }
driver.quit();

    }
}
