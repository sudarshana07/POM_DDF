package new_one;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {
	// step1: declaration
		@FindBy(xpath="//span[@class='user-id']") private WebElement UserID;
		
		//step2: initialization
		public KiteHomePage(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		
		public String getKiteHomePageUserID() 
		{
			String actText = UserID.getText();
			return actText;
		}

}
