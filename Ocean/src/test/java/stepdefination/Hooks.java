package stepdefination;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.sk.Tak;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import resuable.BrowserInvocation;

import java.io.IOException;

public class Hooks extends BrowserInvocation {
    //before start of each and every scenario
    @Before()
    public void startup() throws IOException {

        System.out.println("start");
        BrowserInvocation.invokeBrowser();
    }

    @Before("@Action")
    public void m1(){

    }

    // executeafter the test steps
    @After()
    public void teardown(){

       driver.quit();
    }

    @AfterStep()
    public void takeScreen(Scenario s){

      byte[] b=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

        s.attach(b,"image/png","test");

    }
}
