package propertyFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPageOne {
	@FindBy(xpath="//input[@id='userid']") private WebElement UN;
	@FindBy(xpath="//input[@id='password']") private WebElement pwd;
	@FindBy(xpath="//button[@class='button-orange wide']") private WebElement loginBtn;

	public KiteLoginPageOne(WebDriver dr)
	{
		PageFactory.initElements(dr, this);
	}
	
	public void inpKiteLogin1PageUsername(String username)
	{
		UN.sendKeys(username);
	}

	public void inpKiteLogin1PagePassword(String passwords) {
		pwd.sendKeys(passwords);
	}

	public void clickKiteLogin1PageLoginBtn() {
		loginBtn.click();
	}

}
