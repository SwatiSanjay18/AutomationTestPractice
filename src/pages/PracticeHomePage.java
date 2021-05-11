package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeHomePage {
	WebDriver driver;
	
	By shop = By.xpath("//a[text()=\"Shop\"]");
	By home = By.xpath("//a[text()=\"Home\"]");
	
	public PracticeHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnShop() {
		driver.findElement(shop).click();
	}
	
	public void clickOnHome() {
		driver.findElement(home).click();
	}

}
