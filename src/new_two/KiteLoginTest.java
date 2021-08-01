package new_two;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import new_one.KiteHomePage;
import new_one.KiteLoginPageOne;
import new_one.KiteLoginPageTwo;

public class KiteLoginTest extends BaseClass{
	KiteLoginPageOne login1;
	KiteLoginPageTwo login2;
	KiteHomePage home;
	
	//Sheet sh;
	//WebDriver driver;
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("open browser");
		//FileInputStream file=new FileInputStream("/home/sud/Desktop/Testing/DDF.xlsx");
		//sh=WorkbookFactory.create(file).getSheet("DDF");
		//ChromeOptions option=new ChromeOptions();
		//option.addArguments("--disable-notifications");
		//driver=new ChromeDriver();
		//driver.manage().window().maximize();
		initalizeBrowser();
		Thread.sleep(2000);
		//driver.get("https://kite.zerodha.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login1=new KiteLoginPageOne(driver);
		login2=new KiteLoginPageTwo(driver);
		home=new KiteHomePage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("");
		login1.inpKiteLogin1PageUsername(UtilityClass.getTestData(0, 0));
		login1.inpKiteLogin1PagePassword(UtilityClass.getTestData(0, 1));
		login1.clickKiteLogin1PageLoginBtn();
		//Thread.sleep(2000);
		login2.inpKiteLogin2PagePin(UtilityClass.getTestData(0, 2));
		login2.clickKiteLogin2PageContinue();
		Thread.sleep(2000);
	}
	
	@Test
	public void verifyUserID() throws InterruptedException, EncryptedDocumentException, IOException
	{
		int TCID= 100;
		Reporter.log("running verifyUserID test script", true);
		//home.verifyKiteHomePageUserID(sh.getRow(0).getCell(3).getStringCellValue());
		Thread.sleep(1000);
		
		String expUserID= UtilityClass.getTestData(0, 3);
		String actUserID= home.getKiteHomePageUserID();
		
		Assert.assertEquals(actUserID, expUserID,"actUserID & expUserID are diffrent");
		UtilityClass.captureScreenshot(driver, TCID);
		
	}
	
	@AfterMethod
	public void logoutFromApplication()
	{
		Reporter.log("----logout From Application----");
		
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Reporter.log("----close browser----");
		Thread.sleep(5000);
		driver.close();
	}

}
