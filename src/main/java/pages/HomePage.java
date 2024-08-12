package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

// new, you have to manually write it to get access of common actions
// this is possible when they are static in nature, * means all
// This is called static import
import static common.CommonActions.*;

public class HomePage {
	WebDriver driver;
	JavascriptExecutor js;

	// parameterized constructor initialized when class in instantiated [object created]
	public HomePage(WebDriver driver) {
		this.driver = driver;
		// PageFactory class help to instantiate WebElements
		// Important interview question
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)driver;
	}
	
	@FindBy(xpath = "//img//parent::a//parent::nav")
	WebElement logo;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginFromToolbar;
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(css = "input.btn.btn-lg.px-5")
	WebElement loginButton;
	
	
	
	public void clickLogo() {
		logo.click();
		pause(4000);
	}
	
	// We used throws to handle exception in this method
	public void clickLoginButton() {
		elementDisplayed(loginFromToolbar);
		//clickElement(loginFromToolbar);
		js.executeScript("arguments[0].click()", loginFromToolbar);
		pause(4000);
		elementDisplayed(email);
		inputText(email, "shhnzaktr@gmail.com");
		elementDisplayed(password);
		inputText(password, "Allah@12");
		elementEnabled(loginButton);
		//verifyTextOfTheWebElement(loginButton, "Log In");
		clickElement(loginButton);
		pause(4000);
		
		
	}
	
	
	
	
	

	
	

}
