package pageobjects;

import org.openqa.selenium.By;
import resuable.BrowserInvocation;

public class LoginPage extends BrowserInvocation {

    public void enterEmail(String mail){

        driver.findElement(By.id("ap_email")).sendKeys(mail);
    }

    public void clickContinueButton(){

        driver.findElement(By.id("continue")).click();
    }

    public void enterPassword(String password){

        driver.findElement(By.id("ap_password")).sendKeys(password);

    }

    public void clickSignInButton(){

        driver.findElement(By.id("signInSubmit")).click();

    }
}
