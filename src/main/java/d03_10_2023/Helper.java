package d03_10_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Helper {

    private WebDriver driver;


//    public elementPresent(WebDriver driver) {
//        this.driver = driver;
//    }

    public boolean elementExist(By by) {


        try {driver.findElement(by);
            return true;
        }
        catch (Exception e) {return false;}
    }

}
