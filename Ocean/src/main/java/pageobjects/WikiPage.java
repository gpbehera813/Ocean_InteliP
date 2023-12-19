package pageobjects;

import org.openqa.selenium.By;
import resuable.BrowserInvocation;

public class WikiPage extends BrowserInvocation {


    public static String getValueFromWikiTable(int rowIndex, int columnIndex){

      String value=  driver.findElement(By.xpath("//table[@class='wikitable']/tbody/tr["+rowIndex+"]/td["+columnIndex+"]")).getText();

      return value;

    }

    public static String getValueFromWikiTable(String name){

      return  driver.findElement(By.xpath("//table[@class='wikitable']/tbody/tr/td[normalize-space(text())='"+name+"']/following-sibling::td")).getText();
    }

    public static String getValueFromWikiTable(int columnIndex){

       return driver.findElement(By.xpath("//table[@class='wikitable']/tbody/tr/td["+columnIndex+"]")).getText();
    }


}
