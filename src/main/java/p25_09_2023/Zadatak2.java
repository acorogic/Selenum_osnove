package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        WebElement username= driver.findElement(By.xpath("//input[@placeholder=\"UserName\"]"));
        username.click();
        username.sendKeys("itbootcamp");

        WebElement password= driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
        password.sendKeys("ITBootcamp2021!");

        WebElement login= driver.findElement(By.xpath("//form/div[4]/div/button"));
        login.click();
        Thread.sleep(5000);

        WebElement logOut= driver.findElement(By.xpath("//button[text()='Log out']"));
        logOut.click();
        Thread.sleep(5000);
        driver.quit();
    }
}
