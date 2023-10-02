package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;
import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

//        Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://demoqa.com/automation-practice-form
//        Popunjava formu sta stranice. Korisnik unosi podatke sa tastature za popunu forme.
//        (za vezbanje) Probajte da unese i datum. Sa datumom se radi isto kao i sa obicnim inputom sa sendKeys.
//        Klik na submit


        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/automation-practice-form");

        Scanner s = new Scanner(System.in);
        System.out.print("unesite ime ");
        String name = s.next();
        driver.findElement(By.id("firstName")).sendKeys(name);
        System.out.print("unesite  prezime ");
        String surname = s.next();
        driver.findElement(By.id("lastName"))
                .sendKeys(surname);
        System.out.print("unesite mail ");
        driver.findElement(By.id("userEmail"))
                .sendKeys(s.next());
        System.out.print("Unesite pol ");
        String pol = s.next();


        if (pol.equals("muski")){driver.findElement(By.id("gender-radio-1"))
                .click();}
        else { driver.findElement(By.id("gender-radio-2"))
                .click();}

        System.out.print("Enter phone number (10 digits): ");
        driver.findElement(By.id("userNumber")).sendKeys(s.next());

        System.out.print("unesite subjekt ");
        String subject = s.next();
        driver.findElement(By.id("subjectsInput")).sendKeys(subject);

        System.out.println("Unesite adresu");
        String address = s.next();
        driver.findElement(By.id("currentAddress")).sendKeys(address);



        Thread.sleep(2000);
        driver.findElement(By.id("submit")).click();




    }

}
