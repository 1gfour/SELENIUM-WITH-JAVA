import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SeleniumTest {
    public static WebDriver myBrowser;
    @BeforeTest
    public void init(){
        WebDriverManager.chromedriver().setup(); // download driver of chrome
        myBrowser = new ChromeDriver(); //
        myBrowser.manage().window().maximize();
        myBrowser.get("http://localhost:8080/SWT_PRESENTATION_SELENIUM/"); // nav -> url want to demo
    }
    @Test
    public  void TestLogin(){
        WebElement userID = myBrowser.findElement(By.name("userId"));
        userID.sendKeys("admin");
        WebElement password = myBrowser.findElement(By.name("password"));
        password.sendKeys("1");
        WebElement action = myBrowser.findElement(By.name("action"));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        action.click();
        WebElement h1 = myBrowser.findElement(By.tagName("h1"));
        String h2 = "Toi la admin";
        Assert.assertEquals( h1.getText(), h2);

    }

    @Test
    public static void testDateCorrect() {


        WebElement userID = myBrowser.findElement(By.name("userId"));
        userID.sendKeys("admin");
        WebElement password = myBrowser.findElement(By.name("password"));
        password.sendKeys("1");
        WebElement action = myBrowser.findElement(By.name("action"));

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        action.click();

        WebElement year = myBrowser.findElement(By.name("year"));
        year.sendKeys("2020");
        WebElement month = myBrowser.findElement(By.name("month"));
        month.sendKeys("2");
        WebElement day = myBrowser.findElement(By.name("day"));
        day.sendKeys("29");
        WebElement check = myBrowser.findElement(By.xpath("/html/body/form[1]/input[4]"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        check.click();
        Assert.assertEquals(valid(2020,2,29), true);

    }

    //Test Date is incorrect: 2000 0 0
    @Test
    public static void testDateIncorrect() {

        WebElement userID = myBrowser.findElement(By.name("userId"));
        userID.sendKeys("admin");
        WebElement password = myBrowser.findElement(By.name("password"));
        password.sendKeys("1");
        WebElement action = myBrowser.findElement(By.name("action"));

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        action.click();

        WebElement year = myBrowser.findElement(By.name("year"));
        year.sendKeys("2000");
        WebElement month = myBrowser.findElement(By.name("month"));
        month.sendKeys("0");
        WebElement day = myBrowser.findElement(By.name("day"));
        day.sendKeys("0");
        WebElement check = myBrowser.findElement(By.xpath("/html/body/form[1]/input[4]"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        check.click();
        Assert.assertEquals(valid(2000,0,0), false);
    }


    public static boolean isLeap(int y) {
        boolean result = false;
        if ((y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))) {
            result = true;
        }
        return result;
    }

    public static boolean valid(int y, int m, int d) {
        if (y < 1 || m < 1 || m > 12 || d < 1 || d > 31) {
            return false;
        }
        int maxD = 31;
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            maxD = 30;
        } else if (m == 2) {
            if (isLeap(y)) {
                maxD = 29;
            } else {
                maxD = 28;
            }
        }
        return d <= maxD;
    }
    @AfterTest
    public void tearDown(){
        myBrowser.quit();
    }
}
