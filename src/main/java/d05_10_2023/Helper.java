package d05_10_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Helper {
    private WebDriver driver;




    public boolean elementExist(By by) {


        try {driver.findElement(by);
            return true;
        }
        catch (Exception e) {return false;}
    }

    public static int getHTTPResponseStatusCode(String u) throws IOException, IOException {
        URL url = new URL(u);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return http.getResponseCode();}
}


