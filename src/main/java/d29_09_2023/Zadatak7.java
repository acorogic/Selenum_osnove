package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak7 {
    public static void main(String[] args) throws InterruptedException {


//        7. Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://tus.io/demo.html
//        Hvata sve linkove sa stranice
//        Skrola do svakog h3 elementa
//        Od svakog h3 elementa cita text
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://tus.io/demo.html");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        List<WebElement> h3s = driver.findElements(By.tagName("h3"));

        for (int i = 0; i < h3s.size(); i++) {


            System.out.println(h3s.get(i).getText());
            Thread.sleep(2000);

        }
}}
