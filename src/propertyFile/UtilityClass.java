package propertyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {
	public static String getTestData(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file =new FileInputStream("/home/sud/Desktop/Testing/DDF.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();		
		return value;
	}
	
	public static void captureScreenshot(WebDriver driver,int TCID) throws IOException  
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest =new File("/home/sud/Desktop/Testing/"+TCID+".jpg");		
		FileHandler.copy(src, dest);
	}
	
	public static String readPropertyFileData(String key) throws IOException 
	{
		Properties obj=new Properties();
		FileInputStream file= new FileInputStream("/home/sud/eclipse-workspace/POM_DDF_NG/src/propertyFile/property.properties");
		obj.load(file);
	
		String value = obj.getProperty(key);
		
		return value;
	}

}
