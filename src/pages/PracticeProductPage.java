package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class PracticeProductPage {
	WebDriver driver;
	By btnAddToBasket = By.xpath("//button[text()='Add to basket']");
	By tabBookDesc = By.xpath("//a[text()='Description']");
	By paraBookDesc = By.xpath("//div[@id='tab-description']//p");
	By tabBookReview = By.xpath("//a[@href='#tab-reviews']");
	By paraBookReview = By.xpath("//div[@id='tab-reviews']//div[@id='reviews']//p");
	By menuCartItem = By.xpath("//ul[@id='main-nav']//li[@id='wpmenucartli']//span[@class='cartcontents']");
	By menuCartItemPrice = By.xpath("//ul[@id='main-nav']//li[@id='wpmenucartli']//span[@class='amount']");
	By inputNoOfBooks = By.xpath("//div[@class='quantity']/input[@name='quantity']");
	By errorMsg = By.xpath("//ul[@class='woocommerce-error']/li");
	Actions act;
	
	public PracticeProductPage(WebDriver driver) {
		this.driver = driver;
		act = new Actions(this.driver);
	}
	
	public WebElement getBtnAddToBasket() {
		return(driver.findElement(btnAddToBasket));
	}
		
	public void clickOnTabBookDesc() {
		driver.findElement(tabBookDesc).click();;
	}
	
	public void clickOnTabBookReview() {
		driver.findElement(tabBookReview).click();;
	}
	
	public String getTextBookDesc() {
		return(driver.findElement(paraBookDesc).getText());
	}
	
	public String getTextBookReview() {
		return(driver.findElement(paraBookReview).getText());
	}
	
	public String getErrorMsg() {
		return(driver.findElement(errorMsg).getText());
	}
	
	public WebElement getInputNoOfBooks() {
		return(driver.findElement(inputNoOfBooks));
		
	}
	
	public void verifyNavNextPage(String strHomeURL) {
		String strProductURL = driver.getCurrentUrl();	
		Assert.assertNotSame(strHomeURL, strProductURL);
	}
	
	public void verifyAddToBasket() {
		WebElement weButton = getBtnAddToBasket();
		Assert.assertNotNull(weButton);
	}
	
	public void verifyBookDesc() {
		clickOnTabBookDesc();
		String strBookDesc = getTextBookDesc();
		Assert.assertTrue(strBookDesc != "");
	}	
	
	public void verifyBookReview() {
		clickOnTabBookReview();
		String strBookReview = getTextBookReview();
		Assert.assertTrue(strBookReview != "");
	}	
	
	public void verifyBookInCartInMenu() {
		getBtnAddToBasket().click();
		String strItem = driver.findElement(menuCartItem).getText();
		String strPrice = driver.findElement(menuCartItemPrice).getText();
		Assert.assertTrue((strItem != "") && (strPrice != ""));
	}
	
	public void verifyDisplayErrorPrompt() {		
		WebElement weInputBooks = getInputNoOfBooks();
		weInputBooks.sendKeys(Keys.DELETE);
		weInputBooks.sendKeys("9870");
		getBtnAddToBasket().click();
		String errMsg = getErrorMsg();
		Assert.assertTrue(errMsg.contains("You cannot add that amount to the cart"));
	}
}
