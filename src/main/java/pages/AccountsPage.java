package pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import services.WebDriverServiceImpl;

import org.openqa.selenium.interactions.Actions;

public class AccountsPage extends WebDriverServiceImpl {

//Click new on accounts page
	public NewAccountPage clickNewOnAccountsPage() throws InterruptedException { 
		click(getDriver().findElement(By.xpath("//*[@data-id='account|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.account.NewRecord']")),"New");
		Thread.sleep(3000);
		return new NewAccountPage();
	}

//Search accounts
  	public  AccountsPage searchMemberAccount(String crmNumberInput) throws InterruptedException {	
  		click(getDriver().findElement(By.xpath("//*[@title='Select a view']")),"Select a view");
		click(getDriver().findElement(By.xpath("//*[contains(text(),'All Parent & Independent Accounts')]")),"All Parent & Independent Accounts");
		Thread.sleep(3000);
		typeAndEnter(getDriver().findElement(By.xpath("//*[@placeholder='Quick find']")),crmNumberInput,"Find Criteria" );
		Thread.sleep(3000);
		return this;
	}

//Select account from search results
  	public  MemberFormPage selectAccountFromSearchResults() throws InterruptedException {	
		Actions action = new Actions(getDriver());	
		action.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-0-5']/a")));
		action.doubleClick(getDriver().findElement(By.xpath("//*[@data-id='cell-0-5']/a"))).build().perform();	
		return new MemberFormPage();
	}	
  	
 //Select supplier account from search result
  	public  SupplierFormPage selectSupplierAccountFromSearchResults() throws InterruptedException {	
		Actions action = new Actions(getDriver());	
		action.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-0-2']")));
		action.doubleClick(getDriver().findElement(By.xpath("//*[@data-id='cell-0-2']"))).build().perform();
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