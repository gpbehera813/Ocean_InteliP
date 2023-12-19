package stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobjects.HomePage;
import pageobjects.WikiPage;
import resuable.BrowserInvocation;
import resuable.HandleExcel;

import java.io.IOException;
import java.util.*;

public class LearnMoreSteps extends BrowserInvocation {


    public void m1(){

        driver.findElement(By.className("nav-left")).click();
    }

    @Given("user enter username")
    public void m(){

     //   driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 password']")).sendKeys("123");
     //   driver.findElement(By.className("input r4 wide mb16 mt8 username")).sendKeys("123");

        driver.findElement(By.cssSelector(".input.r4.wide.mb16.mt8.password")).sendKeys("123");

        driver.findElement(By.cssSelector("input[id='username']")).click();

          }

    @Given("user handles {string} the mouse action {string}")
    public void userHandlesTheMouseAction(String s,String prod) throws IOException {

        HomePage.enterProductName(HandleExcel.readExcel("Login",0,0));
        HomePage.clickSearchIcon();

        Actions action = new Actions(driver);

        WebElement accountElement = driver.findElement(By.id("nav-link-accountList"));
        action.clickAndHold(accountElement).build().perform();

       String key = Keys.chord(Keys.CONTROL,Keys.ENTER);
        driver.findElement(By.linkText("Baby Wishlist")).sendKeys(key);

       Set<String> handle= driver.getWindowHandles();

       for(String a:handle){
           driver.switchTo().window(a);

       }

       driver.switchTo().defaultContent();



    }

    @Given("user performs drag and drop")
    public void userPerformsDragAndDrop() {

       WebElement frameElement = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frameElement);


        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement des = driver.findElement(By.cssSelector(".ui-widget-header.ui-droppable"));
        a.dragAndDrop(source,des).build().perform();

        driver.switchTo().defaultContent();

    }

    @Given("User handles the wiki table")
    public void userHandlesTheWikiTable() {

//        WebElement eyTable = driver.findElement(By.xpath("//table[@class='infobox vcard']"));
//
//        int a =eyTable.findElements(By.tagName("td")).size();
//
//        for (int i=0; i < a ;i++){
//
//            System.out.println(  eyTable.findElements(By.tagName("td")).get(i).getText());
//
//        }

        List<WebElement> eyTableElement = driver.findElements(By.xpath("//table[@class='infobox vcard']/tbody/tr/th"));
        List <String> col1Values = new ArrayList<String>();
        for (WebElement e:eyTableElement){
            col1Values.add(e.getText());
        }

        List <String> col2Values = new ArrayList<String>();
        for (WebElement e:eyTableElement){
            col2Values.add(e.getText());
        }

       for(String g:col1Values){

           if(g.equals("Revenue")){

               Assert.assertTrue(true);
               break;
           }
       }

       Map<List,List> m = new HashMap<List,List>();
       m.put(col1Values,col2Values);

       Assert.assertEquals("1989", m.get("Founded"));

        System.out.println( WikiPage.getValueFromWikiTable(12,3));

        Assert.assertEquals("10,236",WikiPage.getValueFromWikiTable(4,4));
    }
}
