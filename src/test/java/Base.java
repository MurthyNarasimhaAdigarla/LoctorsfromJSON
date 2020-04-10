import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileReader;

public class Base {

    static WebDriver driver;



    public static void sendKeyss(String locator, String valueToEnter){
         driver.findElement(By.xpath(locator)).sendKeys(valueToEnter);




    }
}
