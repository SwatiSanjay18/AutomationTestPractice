package test;

import org.testng.annotations.Test;

import pages.PracticeHomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	
  @Test(priority = 0)
  public void testThreeSliders(){	  
	  int countSliders = driver.findElements(By.xpath("//div[@class='n2-ss-slider-3']/div/div/img")).size();
	  Assert.assertEquals(countSliders, 3);
  }
  
  @Test(priority = 1)
  public void testThreeArrivals() {
	  int countArrivals = driver.findElements(By.xpath("//ul[@class='products']")).size();
	  Assert.assertEquals(countArrivals, 3);
  }  

  @AfterMethod
  public void afterMethod() {	
  }
  
  @AfterClass
  public void terminateBrowser() {
	  driver.close();
  }

}
