package stepdefination;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import resuable.BrowserInvocation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginSteps extends BrowserInvocation {

  LoginPage f ;
  HomePage g;

  LoginSteps(){
    f = new LoginPage();
    g = new HomePage();
  }

  @And("user clicks on login button")
  public void clickLogin(){

    driver.findElement(By.xpath("//button[text()='Login']")).click();
  }

  @Given("user navigates to learnmore login page")
    public void navigateURL(){

    driver.navigate().to("https://learnmoreplayground.blogspot.com/p/loginpage.html");
    driver.navigate().refresh();

  }


  @Given("user navigate to leanmore login page")
    public void login(){



  }

  @When("user enter username {string} and password {string}")
    public void enterUserName(String username, String password) throws InterruptedException {

    driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#password")));
    driver.findElement(By.cssSelector("#password")).sendKeys(password);


  }


  @Then("user validate the error message")
  public void validateErrorMessage() {

    String acutalErrorMessage =  driver.findElement(By.id("errorMessage")).getText();

    System.out.println(acutalErrorMessage);

    String expectedErrorMessage = "Invalid Credentials.Please Check Once" ;

    Assert.assertEquals(expectedErrorMessage,acutalErrorMessage);

    if(acutalErrorMessage.equals(expectedErrorMessage)){

      Assert.assertTrue(true);

    }
    else{
      Assert.assertTrue(false);
    }
  }

  @Then("user validates the title of homepage")
  public void validateTitle() {

  }

  @Then("user validates whether navigates to event home page")
  public void validateEvent() {
  }


  @Given("user navigate to spicejet")
  public void userNavigateToSpicejet() {
    driver.navigate().to("https://book.spicejet.com/");
  }

  @When("user selects the value from currency dropdown")
  public void selectCurrencyValue() {

    WebElement currencyElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency"));

    Select currencyDrop = new Select(currencyElement);
   // currencyDrop.selectByIndex(2);
   // currencyDrop.selectByVisibleText("KWD");
    currencyDrop.selectByValue("MYR");

  List<String> currencyValues = new ArrayList<String>();
   int currencySize = currencyElement.findElements(By.tagName("option")).size();

    for(int i=0 ; i < currencySize ; i++ ){

      currencyValues.add(currencyElement.findElements(By.tagName("option")).get(i).getText());
    }

    System.out.println(currencyValues);

    Assert.assertEquals("CAD",currencyValues.get(2));

    for(String k:currencyValues){

      if(k.equals("CAD")){

        Assert.assertTrue(true);
        break;
      }


    }

  }

  @Given("user selects the dropdown value in From & To dropdowns")
  public void selectDrop() {

    driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")).click();

    driver.findElement(By.xpath("//a[@Value='MAA']")).click();

//    WebElement toElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR"));
//    toElement.findElement(By.xpath("//a[@Value='CJB']")).click();

    driver.findElement(By.xpath("//div[@id='glsControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR']//a[@Value='CJB']")).click();



  }

  @Given("Enable disbale")
  public void enableDisbale() {

   boolean g= driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_OneWay")).isSelected();

    Assert.assertTrue(g);

    driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_LabelMarketStation1")).isDisplayed();

    boolean e = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_LabelMarketStation2")).isEnabled(); //false

    Assert.assertFalse(e);

    driver.switchTo().alert().getText();

    driver.switchTo().alert().dismiss();

    driver.switchTo().alert().sendKeys("Aravinth");
    driver.switchTo().alert().accept();


  }
}
