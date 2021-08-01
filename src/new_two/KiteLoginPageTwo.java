package new_two;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPageTwo {
	@FindBy(xpath = "//input[@id='pin']")
	private WebElement pin;
	
	@FindBy(xpath = "//button[@class='button-orange wide']")
	private WebElement continueBtn;
	
	public KiteLoginPageTwo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpKiteLogin2PagePin(String pin)
	{
		this.pin.sendKeys(pin);
	}
	
	public void clickKiteLogin2PageContinue()
	{
		this.continueBtn.click();
	}

}
