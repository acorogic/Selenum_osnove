package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        Scanner s = new Scanner(System.in);

        System.out.println("uneti broj osoba");
        int brojOsoba= s.nextInt();
        int brojac=0;
        boolean terminate= false;

        while (!terminate) {




            brojac++;
            System.out.println("full name: " );
            String name= s.next();
            WebElement fullName= driver.findElement(By.xpath("//input[@id='userName']"));
            fullName.click();
            fullName.sendKeys(name);

            System.out.println("email:");
            String email= s.next();

            WebElement emailAdress= driver.findElement(By.xpath("//input[@id='userEmail']"));
            emailAdress.click();
            emailAdress.sendKeys(email);


            System.out.println("current address: ");
            String adresa=s.next();

            WebElement adress= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
            adress.click();
            adress.sendKeys(adresa);
Thread.sleep(2000);
driver.navigate().refresh();
Thread.sleep(1000);



            if (brojac>=brojOsoba) {terminate=true;}


        }

        driver.quit();
    }
}
