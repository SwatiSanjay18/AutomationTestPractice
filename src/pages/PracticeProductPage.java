package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PracticeProductPage {
	WebDriver driver;
	By btnAddToBasket = By.xpath("//button[text()='Add to basket']");
	By tabBookDesc = By.xpath("//a[text()='Description']");
	By paraBookDesc = By.xpath("//div[@id='tab-description']//p");

	public PracticeProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getBtnAddToBasket() {
		return(driver.findElement(btnAddToBasket));
	}	
	
	public void clickOnTabBookDesc() {
		driver.findElement(tabBookDesc).click();;
	}
	
	public String getTextBookDesc() {
		return(driver.findElement(paraBookDesc).getText());
	}
	
	public void verifyNavNextPage(String strHomeURL) {
		String strProductURL = driver.getCurrentUrl();	
		Assert.assertNotSame(strHomeURL, strProductURL);
	}
	
	public void verifyAddToBasket() {
		WebElement weButton = getBtnAddToBasket();
		Assert.assertNotNull(weButton);
	}
	
	public void verifyProductDesc() {
		clickOnTabBookDesc();
		String strProductDesc = getTextBookDesc();
		Assert.assertTrue(strProductDesc != "");
	}	
}
