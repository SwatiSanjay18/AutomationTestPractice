package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeHomePage {
	WebDriver driver;
	By shop = By.xpath("//a[text() = 'Shop']");
	By home = By.xpath("//a[text() = 'Home']");
	By sliders = By.xpath("//div[@class='n2-ss-slider-3']/div/div/img");
	By arrivals = By.xpath("//ul[@class='products']");
	
	public PracticeHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> getSliders() {
		return(driver.findElements(sliders));
	}
	
	public List<WebElement> getArrivals() {
		return(driver.findElements(sliders));
	}
	  
	public void clickOnShop() {
		driver.findElement(shop).click();
	}
	
	public void clickOnHome() {
		driver.findElement(home).click();
	}
}
