package d22_09_2023.Zadatak1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

//    Napisati program koji:
//    ima niz od 5 stringova. Svaki element u nizu je url stranice:
//    https://www.google.com/
//    https://www.facebook.com/
//    https://www.youtube.com/
//    https://www.ebay.com/
//    https://www.katalon.com/
//    kreira testnu infrastukturu
//    zatim koristeci for petlju otvara svaku stranicu iz niza u pretrazivacu i
//    pritom pravi pauzu od 2 sekunde izmedju svaka dva ucitanja stranice
//    Na kraju program ponisava testnu ifrastukturu

    public static void main(String[] args) throws InterruptedException {


        Adresa adresa1=new Adresa("https://www.google.com/");
        Adresa adresa2=new Adresa("https://www.facebook.com/");
        Adresa adresa3=new Adresa("https://www.youtube.com/");
        Adresa adresa4=new Adresa("https://www.katalon.com/");
        Adresa adresa5=new Adresa("https://www.ebay.com/");

        Bookmark bookmark1=new Bookmark();
        bookmark1.dodajAdresu(adresa1);
        bookmark1.dodajAdresu(adresa2);
        bookmark1.dodajAdresu(adresa3);
        bookmark1.dodajAdresu(adresa4);
        bookmark1.dodajAdresu(adresa5);



        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        for (int i = 0; i < bookmark1.getAdrese().size(); i++) {

            driver.get(bookmark1.getAdrese().get(i).getAdresa());
            Thread.sleep(2000);


        }

        driver.quit();

        }



}
