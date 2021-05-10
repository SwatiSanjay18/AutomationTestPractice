package user_journies;

import org.testng.annotations.Test;
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
  @Test
  public void testThreeSliders(){
	  WebElement weShop = driver.findElement(By.xpath("//a[text()=\"Shop\"]"));
	  weShop.click();
	  WebElement weHome = driver.findElement(By.xpath("//a[text()=\"Home\"]"));
	  weHome.click();
	  int countSliders = driver.findElements(By.xpath("//div[@class='n2-ss-slider-3']/div/div/img")).size();
	  Assert.assertEquals(countSliders, 3);
	  driver.close();
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver.get("http://practice.automationtesting.in/");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
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
