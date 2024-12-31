package pomclass;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class Usermanagement {

		@FindBy(xpath = "//*[@name='UserName']")
		private WebElement Username;
		
		@FindBy(xpath="//*[@name='Password']")
		private WebElement Password;
		
		@FindBy(xpath="//*[@id=\"login-form\"]/fieldset/section[2]/footer/button")
		private WebElement Loginbutton;
		
		public Usermanagement(WebDriver driver) {
		PageFactory.initElements(driver, this);}
	

}
