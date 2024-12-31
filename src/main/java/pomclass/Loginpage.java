package pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	@FindBy(xpath = "//*[@name='UserName']")
	private WebElement Username;
	
	@FindBy(xpath="//*[@name='Password']")
	private WebElement Password;
	
	@FindBy(xpath="//*[@id=\"login-form\"]/fieldset/section[2]/footer/button")
	private WebElement Loginbutton;
	
	public Loginpage(WebDriver driver) {
	PageFactory.initElements(driver, this);}
	
	public void Login() throws InterruptedException{
		
		Username.sendKeys("System admin");
		
		Password.sendKeys("123456");
		Loginbutton.click();
		Thread.sleep(2000);
	}
	
	public void EnterUsername(String username) {
		Username.sendKeys(username);
	
	}
	
	public void EnterPassword(String password) {
   Password.sendKeys(password);
	}
	
	public void EnterLoginButton() {
		Loginbutton.click();
	}
	
	
	}

