package pages;

import org.openqa.selenium.By;
import services.WebDriverServiceImpl;

public class BulkImportPage extends WebDriverServiceImpl{


	public BulkImportPage clickNewButton() throws InterruptedException {
		
		click(getDriver().findElement(By.xpath("//button[@aria-label='New']")),"New Button");
		verifyDisplayed(getDriver().findElement(By.xpath("//div[contains(@id,'defaultDialogChromeTitle')]")), "Dialogbox");
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.xpath("//*[@id='FullPageWebResource']")));
		verifyDisplayed(getDriver().findElement(By.xpath("//h4[contains(text(),'Bulk Import')]")),"Bulk Import Header");
		return this;
	}
	
	
	
	
	public BulkImportPage bulkImportFile(String fileType, String fileName) throws InterruptedException {
		
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//select[@name='templatetype']")), fileType, "bulkImport File type");
		
		Upload(getDriver().findElement(By.xpath("//input[@id='file']")),
				System.getProperty("user.dir")+"/data/"+fileName+".xlsx","import file");
		
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//input[@id='btn_submit']")),"Import Button");
		Thread.sleep(3000);
		acceptAlert();
		switchToDefaultContent();
		Thread.sleep(1000);
		return this;
	}
		
	public BulkImportPage verifyImportingList(String fileName) {
		
		verifyDisplayed(getDriver().findElement(By.xpath("//a[contains(@title,'"+fileName+"')]")), "FileName");
		return this;
		
	}
}
