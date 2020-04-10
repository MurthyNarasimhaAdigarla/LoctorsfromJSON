import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Slenium extends Base {

    static Object UserName;
    static Object password;
    static Object LoginBtn;
    public static JSONObject jsonObject;
    static Object obj;
    static String JsonResponseinString;
    static String currentUsersDir = System.getProperty("user.dir");


    static {
        try {
            parsingTheJson();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        gettinglocatorData();


    }

    public static void main(String args[]) throws IOException, ParseException {
        openingFB();
        parsingTheJson();
    }


    public static void openingFB() throws FileNotFoundException {
        System.setProperty("webdriver.gecko.driver", currentUsersDir
                + "\\src\\test\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
       Base.sendKeyss((String) UserName, "99662");
        //driver.findElement(By.xpath((String) UserName)).sendKeys("9966236635");

        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        driver.findElement(By.xpath((String) password)).sendKeys("Qwerty@321");
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        driver.findElement(By.xpath((String) LoginBtn)).click();


    }


    public static void parsingTheJson() throws IOException, ParseException {
        //FileReader jsonfile = new FileReader("src/test/resources/cucumber.json");
        org.json.simple.parser.JSONParser parser = new JSONParser();
        obj = parser.parse(new FileReader("src/test/Json/Locators.json"));
        jsonObject = (JSONObject) obj;
        JsonResponseinString = jsonObject.toString();
        System.out.println("JSON Response :: " + JsonResponseinString);


    }


    public static void gettinglocatorData() {

        UserName = jsonObject.get("UserName");
        System.out.println("UserName is " + UserName);

        password = jsonObject.get("password");
        System.out.println("password is " + password);

        LoginBtn = jsonObject.get("loginBtn");
        System.out.println("LoginBtn is " + LoginBtn);


    }



}