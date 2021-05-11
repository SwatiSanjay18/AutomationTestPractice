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

public class TestHomeSliders {
	WebDriver driver;
	PracticeHomePage objHomePage;
	
  @Test
  public void testThreeSliders(){
	  objHomePage.clickOnShop();
	  objHomePage.clickOnHome();
	  int countSliders = driver.findElements(By.xpath("//div[@class='n2-ss-slider-3']/div/div/img")).size();
	  Assert.assertEquals(countSliders, 3);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver.get("http://practice.automationtesting.in/");
	  driver.manage().window().maximize();
	  objHomePage = new PracticeHomePage(driver);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
  }

}
