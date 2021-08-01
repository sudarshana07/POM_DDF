package new_one;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class KiteLoginTest {
	KiteLoginPageOne login1;
	KiteLoginPageTwo login2;
	KiteHomePage home;
	
	Sheet sh;
	WebDriver driver;
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("open browser");
		FileInputStream file=new FileInputStream("/home/sud/Desktop/Testing/DDF.xlsx");
		sh=WorkbookFactory.create(file).getSheet("DDF");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://kite.zerodha.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login1=new KiteLoginPageOne(driver);
		login2=new KiteLoginPageTwo(driver);
		home=new KiteHomePage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws InterruptedException
	{
		Reporter.log("");
		login1.inpKiteLogin1PageUsername(sh.getRow(0).getCell(0).getStringCellValue());
		login1.inpKiteLogin1PagePassword(sh.getRow(0).getCell(1).getStringCellValue());
		login1.clickKiteLogin1PageLoginBtn();
		Thread.sleep(2000);
		login2.inpKiteLogin2PagePin(sh.getRow(0).getCell(2).getStringCellValue());
		login2.clickKiteLogin2PageContinue();
		Thread.sleep(2000);
	}
	
	@Test
	public void verifyUserID() throws InterruptedException
	{
		// int TCID= 100;
		Reporter.log("running verifyUserID test script", true);
		//home.verifyKiteHomePageUserID(sh.getRow(0).getCell(3).getStringCellValue());
		Thread.sleep(1000);
		
		String expUserID= sh.getRow(0).getCell(3).getStringCellValue();
		String actUserID= home.getKiteHomePageUserID();
		
		Assert.assertEquals(actUserID, expUserID,"actUserID & expUserID are diffrent");
		
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
