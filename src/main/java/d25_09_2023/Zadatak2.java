package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        Zadatak
//        Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//        Visit Paris
//        Visit Prague
//        Visit London
//        Visit New York
//        Visit Belgrade
//        Maksimizirati prozor
//        Ucitati stranicu https://example.cypress.io/todo
//        Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//        Nakon svakog unosa todo-a, unosi se enter. Koristan link
//        Nakon svih unosa proci petljom kroz svaki todo koji je na stranici i za svaki cekirati da je completed.
//                Cekanje od 5s
//        Zatvorite pretrazivac


        ArrayList<String>visitCities= new ArrayList<>();
        visitCities.add("Visit Paris");
        visitCities.add("Visit Prague");
        visitCities.add("Visit London");
        visitCities.add("Visit New York");
        visitCities.add("Visit Belgrade");

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://example.cypress.io/todo");

        for (int i = 0; i < visitCities.size(); i++) {

            driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']"))
                    .sendKeys(visitCities.get(i));

            driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']"))
                    .sendKeys(Keys.ENTER);

        }

        List<WebElement> toDo= driver.findElements(By.cssSelector(".todo-list input[type='checkbox']"));
        for (int i = 0; i < toDo.size(); i++) {

            toDo.get(i).click();

        }
        Thread.sleep(5000);
        driver.quit();

    }

}
