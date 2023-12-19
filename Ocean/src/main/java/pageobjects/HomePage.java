package pageobjects;

import org.openqa.selenium.By;
import resuable.BrowserInvocation;

public class HomePage extends BrowserInvocation {

    public static void enterProductName(String name){

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(name);
    }

    public static void clickSearchIcon(){

        driver.findElement(By.id("nav-search-submit-button")).click();
    }
}
