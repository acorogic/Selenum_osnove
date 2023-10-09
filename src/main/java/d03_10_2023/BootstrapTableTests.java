package d03_10_2023;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BootstrapTableTests {
    private WebDriver driver;
    private WebDriverWait wait;

    private String baseUrl="https://s.bootsnipp.com/iframe/K5yrx";


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforMethod() {
        driver.manage().deleteAllCookies();
        driver.navigate().to(baseUrl);}

    @Test

    public void editRow() throws InterruptedException {
        // Test #1: Edit Row
//    Podaci:
//    First Name: ime polaznika
//    Last Name: prezime polaznika
//    Middle Name: srednje ime polanzika
//    Koraci:
//    Ucitati stranu /iframe/K5yrx
//    Verifikovati naslov stranice Table with Edit and
//    Update Data - Bootsnipp.com
//    Klik na Edit dugme prvog reda
//    Sacekati da dijalog za Editovanje bude vidljiv
//    Popuniti formu podacima.
//    Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji,
//    za to se koristi metoda clear. Koristan link
//    Klik na Update dugme
//    Sacekati da dijalog za Editovanje postane nevidljiv
//    Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//    Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//    Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//    Za sve validacije ispisati odgovarajuce poruke u slucaju greske


       // new Helper(driver).elementExist()
        String firstName = "Aleksandar";
        String lastName = "Rogic";
        String middleName = "Aco";
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com", "tittle doesn't match");
driver.findElement(By.cssSelector("tr#d1>td:nth-child(5)>button"))
        .click();

wait.withMessage("edit dialog is not visible")
        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Update Data']")));

//        List<WebElement> inputDataTable=driver.findElements(By.cssSelector("div#edit div.modal-body"));
//        inputDataTable.clear().
//        Thread.sleep(3000);

        WebElement firstNameInput = driver.findElement(By.id("fn"));

        WebElement lastNameInput = driver.findElement(By.id("ln"));

        WebElement middleNameInput = driver.findElement(By.id("mn"));


        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        middleNameInput.clear();
        middleNameInput.sendKeys(middleName);

        driver.findElement(By.xpath("//button[text()='Update']")).click();

        wait
                .withMessage("Edit modal is visible even though it shouldn't be ")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#edit  .modal-dialog")));

        Assert.assertEquals(driver.findElement(By.id("f1")).getText(), firstName, "First name is not correct ");
        Assert.assertEquals(driver.findElement(By.id("l1")).getText(), lastName, "Last name is not correct ");
        Assert.assertEquals(driver.findElement(By.id("m1")).getText(), middleName, "Middle name is not correct ");

    }

    @Test
    public  void deleteRow (){
//        Test #2: Delete Row
//        Podaci:
//        First Name: ime polaznika
//        Last Name: prezime polaznika
//        Middle Name: srednje ime polanzika
//        Koraci:
//        Ucitati stranu /iframe/K5yrx
//        Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//        Klik na Delete dugme prvog reda
//        Sacekati da dijalog za brisanje bude vidljiv
//        Klik na Delete dugme iz dijaloga
//        Sacekati da dijalog za Editovanje postane nevidljiv
//        Verifikovati da je broj redova u tabeli za jedan manji
//        Za sve validacije ispisati odgovarajuce poruke u slucaju greske


        int numberOfCells= driver.findElements(By.cssSelector(".table>tbody>tr>td")).size();

        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com", "tittle doesn't match");

driver.findElement(By.cssSelector("tr#d1 button.delete"))
        .click();







wait.withMessage("Delete data dialog is not visible")
        .until(ExpectedConditions.visibilityOfElementLocated(By
        .xpath("//strong[normalize-space()='Are you sure you want to delete this data?']")));

        driver.findElement(By.cssSelector("button#del"))
                .click();
        wait.withMessage("Delete data dialog is  visible")
                .until(ExpectedConditions.invisibilityOfElementLocated(By
                        .xpath("//strong[normalize-space()='Are you sure you want to delete this data?']")));

Assert.assertEquals(driver.findElements(By.cssSelector(".table>tbody>tr>td")).size(),
        numberOfCells, "Deletion is not done correctly");
    }

@Test
public void takeAscrennshot () throws IOException {

//    Test #3: Take a Screenshot
//    Koraci:
//    Ucitati stranu  /iframe/K5yrx
//    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//    Kreirati screenshot stranice.
//            Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png

    Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com", "tittle doesn't match");


    File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    Files.copy(f,new File("screenshots/slike.png"));

}



    @AfterClass
        public void afterClass() {
            driver.quit();
        }
    }

