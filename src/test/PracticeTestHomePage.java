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
	
  //launching browser with practice automation url
  @BeforeClass
  public void launchBrowser() {
	  System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://practice.automationtesting.in/");	  
	  objHomePage = new PracticeHomePage(driver);
	  objProductPage = new PracticeProductPage(driver);
  }
  
  //click on shop and then home for the home page
  @BeforeMethod
  public void goToHomePage() {
	  objHomePage.clickOnShop();
	  objHomePage.clickOnHome();
  }
  
  //test for the slider count to be 3
  @Test
  public void testThreeSliders(){	  
	  int countSliders = objHomePage.getSlidersCount();
	  Assert.assertEquals(countSliders, 3);
  }
  
  //test for the arrival book count to be 3
  @Test
  public void testThreeArrivals() {
	  int countArrivals = objHomePage.getArrivalsCount();
	  Assert.assertEquals(countArrivals, 3);
  }  
  
  //click on each book image and check if 
  //it navigates to new page and add to basket available
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
  
  //test each book has description
  @Test(dependsOnMethods = {"testThreeArrivals"})
  public void testArrBookDesc() {
	  int count = objHomePage.getArrivalsCount();
	  String strHomeURL = driver.getCurrentUrl();
	  for(int i = 0; i < count; i++) {
		  objHomePage.getImageAt(i).click();
		  objProductPage.verifyNavNextPage(strHomeURL);
		  objProductPage.verifyBookDesc();
		  driver.navigate().back();
	  }	 
  }
  
  //test each book has review
  @Test(dependsOnMethods = {"testThreeArrivals"})
  public void testArrBookReview() {
	  int count = objHomePage.getArrivalsCount();
	  String strHomeURL = driver.getCurrentUrl();
	  for(int i = 0; i < count; i++) {
		  objHomePage.getImageAt(i).click();
		  objProductPage.verifyNavNextPage(strHomeURL);
		  objProductPage.verifyBookReview();
		  driver.navigate().back();
	  }	 
  }
  
  //test menu has item with price when book added 
  @Test(dependsOnMethods = {"testThreeArrivals"})
  public void testBookAddToBasket() {
	  String strHomeURL = driver.getCurrentUrl();
	  objHomePage.getImageAt(0).click();
	  objProductPage.verifyNavNextPage(strHomeURL);
	  objProductPage.verifyBookInCartInMenu();
  }

  @AfterMethod
  public void afterMethod() {	
  }
  
  @AfterClass
  public void terminateBrowser() {
	  driver.close();
  }

}
