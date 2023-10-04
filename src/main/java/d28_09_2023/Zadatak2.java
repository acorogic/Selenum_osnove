package d28_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        Thread.sleep(1000);

        driver.findElement(By.id("basic-primary-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-secondary-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-success-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-danger-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-warning-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-info-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-light-trigger")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("basic-dark-trigger")).click();

        driver.quit();
    }
}

