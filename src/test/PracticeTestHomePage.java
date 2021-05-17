package test;

import org.testng.annotations.Test;

import pages.PracticeHomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class PracticeTestHomePage {
	WebDriver driver;
	PracticeHomePage objHomePage;
	
  @BeforeClass
  public void launchBrowser() {
	  System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://practice.automationtesting.in/");
	  driver.manage().window().maximize();
	  objHomePage = new PracticeHomePage(driver);
	  
  }

  @BeforeMethod
  public void goToHomePage() {
	  objHomePage.clickOnShop();
	  objHomePage.clickOnHome();
  }
	
  @Test
  public void testThreeSliders(){	  
	  int countSliders = objHomePage.getSliders().size();
	  Assert.assertEquals(countSliders, 3);
  }
  
  @Test
  public void testThreeArrivals() {
	  int countArrivals = objHomePage.getArrivals().size();
	  Assert.assertEquals(countArrivals, 3);
  }  
  
  @Test(dependsOnMethods = { "testThreeArrivals" })
  public void testArrImgNavigate() throws Exception {
	  int count = objHomePage.getArrivals().size();
	  for(int i = 0; i < count; i++) {
		  objHomePage.getArrivals().get(i).click();
		  WebElement weButton = objHomePage.getBtnAddToBasket();
		  Assert.assertNotNull(weButton);
		  driver.navigate().back();
	  }	 
  }  

  @AfterMethod
  public void afterMethod() {	
  }
  
  @AfterClass
  public void terminateBrowser() {
	  driver.close();
  }

}
