package test;

import org.testng.annotations.Test;

import pages.PracticeHomePage;
import pages.PracticeProductPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeTestHomePage {
	WebDriver driver;
	PracticeHomePage objHomePage;
	PracticeProductPage objProductPage;
	
  @BeforeClass
  public void launchBrowser() {
	  System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://practice.automationtesting.in/");
	  driver.manage().window().maximize();
	  objHomePage = new PracticeHomePage(driver);
	  objProductPage = new PracticeProductPage(driver);
  }

  @BeforeMethod
  public void goToHomePage() {
	  objHomePage.clickOnShop();
	  objHomePage.clickOnHome();
  }
	
  @Test
  public void testThreeSliders(){	  
	  int countSliders = objHomePage.getSlidersCount();
	  Assert.assertEquals(countSliders, 3);
  }
  
  @Test
  public void testThreeArrivals() {
	  int countArrivals = objHomePage.getArrivalsCount();
	  Assert.assertEquals(countArrivals, 3);
  }  
  
  @Test(dependsOnMethods = {"testThreeArrivals"})
  public void testArrImgNavigate() {
	  int count = objHomePage.getArrivalsCount();
	  String strHomeURL = driver.getCurrentUrl();	  
	  for(int i = 0; i < count; i++) {
		  objHomePage.getImageAt(i).click();	  
		  objProductPage.verifyNavNextPage(strHomeURL);
		  objProductPage.verifyAddToBasket();		  
		  driver.navigate().back();
	  }	 
  }  

  @Test(dependsOnMethods = {"testArrImgNavigate"})
  public void testArrBookDesc() {
	  int count = objHomePage.getArrivalsCount();
	  for(int i = 0; i < count; i++) {
		  objHomePage.getImageAt(i).click();
		  objProductPage.verifyProductDesc();
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
