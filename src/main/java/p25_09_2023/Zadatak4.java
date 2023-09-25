package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        WebElement edit= driver.findElement(By.xpath("//span[@id='edit-record-1']//*[name()='svg']"));
        edit.click();

        WebElement firstName= driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.click();
        firstName.sendKeys("Rodja");

        WebElement lastName= driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.click();
        lastName.sendKeys("Raicevic");



        WebElement email= driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.click();
        email.sendKeys("rodja@gmail.com");

        WebElement age= driver.findElement(By.xpath("//input[@id='age']"));
        age.click();
        age.sendKeys("rodja@gmail.com");

        WebElement salary= driver.findElement(By.xpath("//input[@id='salary']"));
        salary.click();
        salary.sendKeys("10000");

        WebElement deparmetnt= driver.findElement(By.xpath("//input[@id='department']"));
        deparmetnt.click();
        deparmetnt.sendKeys("IT");


WebElement submit= driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();

        Thread.sleep(2000);

        driver.quit();









    }
}
