package resuable;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowserInvocation {

   public static WebDriver driver;
   public static Properties prob;
    public static void invokeBrowser() throws IOException {

        FileInputStream fis = new FileInputStream(new File("src/main/resources/utility/config.properties"));

        prob = new Properties();
        prob.load(fis);

        switch (prob.getProperty("browser").toLowerCase()) {
            case "edge" -> driver = new EdgeDriver();
            case "chrome" -> driver = new ChromeDriver();
            case "safari" -> driver = new SafariDriver();
            default -> throw new InvalidArgumentException("Enter valid browsername");
        }

//        if(prob.getProperty("browser").equalsIgnoreCase("chrome")){
//            driver = new ChromeDriver();
//        }
//        else if (prob.getProperty("browser").equalsIgnoreCase("edge")){
//
//            driver = new EdgeDriver();
//        }
//        else if(prob.getProperty("browser").equalsIgnoreCase("safari")){
//            driver = new SafariDriver();
//        }
//        else{
//
//            throw new InvalidArgumentException("Enter valid browsername");
//        }


        driver.navigate().to( prob.getProperty("testenvironemnt"));
        driver.navigate().refresh();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        
    }


}
