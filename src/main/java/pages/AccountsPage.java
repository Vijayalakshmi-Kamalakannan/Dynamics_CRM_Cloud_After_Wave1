package pages;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import services.WebDriverServiceImpl;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsPage extends WebDriverServiceImpl {

//Click new on accounts page
	public NewAccountPage clickNewOnAccountsPage() throws InterruptedException { 
		click(getDriver().findElement(By.xpath("//*[@data-id='account|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.account.NewRecord']")),"New");
		Thread.sleep(3000);
		return new NewAccountPage();
	}

//Search accounts
  	public  AccountsPage searchAccount(String crmNumberInput) throws InterruptedException {	
  		//click(getDriver().findElement(By.xpath("//*[@title='Select a view']")),"Select a view");
		click(getDriver().findElement(By.xpath("//*[contains(@id,'ViewSelecto')]")),"Select a view");
		click(getDriver().findElement(By.xpath("//*[contains(text(),'All Accounts')]")),"All Accounts");
		Thread.sleep(15000);
		Thread.sleep(15000);
		WebDriverWait wait= new WebDriverWait(getDriver(),20);
		wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.xpath("//*[contains(@id,'quickFind_text')]"))));
		typeAndEnter(getDriver().findElement(By.xpath("//*[contains(@id,'quickFind_text')]")),crmNumberInput,"Find Criteria" );
		Thread.sleep(5000);
		return this;
	}

//Select member account from search results
  	public  MemberFormPage selectAccountFromSearchResults() throws InterruptedException {	
		//Actions action = new Actions(getDriver());
		click(getDriver().findElement(By.xpath("//*[@data-id='cell-0-6']/a")),"Search Results");
		Thread.sleep(4000);
		return new MemberFormPage();
	}	
  	
	public  MemberFormPage selectDirectParentFromSearchResults() throws InterruptedException {	
		Actions action = new Actions(getDriver());	
		action.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-0-4']/a")));
		action.doubleClick(getDriver().findElement(By.xpath("//*[@data-id='cell-0-4']/a"))).build().perform();	
		return new MemberFormPage();
	}	
	

	public  MemberFormPage selectParentAccountFromSearchResults() throws InterruptedException {	
		Actions action = new Actions(getDriver());	
		action.moveToElement(getDriver().findElement(By.xpath("//div[@aria-label='Data']/div[3]/a")));
		action.doubleClick(getDriver().findElement(By.xpath("//div[@aria-label='Data']/div[3]/a"))).build().perform();	
		return new MemberFormPage();
	}
  	
 //Select supplier account from search result
  	public  SupplierFormPage selectSupplierAccountFromSearchResults() throws InterruptedException {	
		Actions action = new Actions(getDriver());	
		action.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-0-6']")));
		action.doubleClick(getDriver().findElement(By.xpath("//*[@data-id='cell-0-6']"))).build().perform();
		Thread.sleep(10000);
		return new SupplierFormPage();
	}
  	
  	
  //Click on Discard changes
  	public AccountsPage clickOnDiscardChanges() throws InterruptedException {
  		click(getDriver().findElement(By.xpath("//*[@data-id='cancelButton']")),"Discard Changes");
  		Thread.sleep(3000);
  		return new AccountsPage();
  	}
	
  	public MemberFormPage chooseActiveMember(String CrmNumber) throws InterruptedException   {
  		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		click(getDriver().findElement(By.id("crmGrid_findCriteria")),"Search creteria text box");
		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),CrmNumber,"Find Criteria");
		click(getDriver().findElement(By.xpath("//table//a[@href='javascript:;']")),"Find Creteria Search");
		Thread.sleep(6000);
		return new MemberFormPage();		
	}

 

  	

  	
}