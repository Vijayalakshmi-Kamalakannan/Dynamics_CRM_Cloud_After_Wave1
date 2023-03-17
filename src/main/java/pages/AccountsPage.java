package pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import services.WebDriverServiceImpl;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsPage extends WebDriverServiceImpl {

//Click new on accounts page
	public NewAccountPage clickNewOnAccountsPage() throws InterruptedException { 
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@data-id='account|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.account.NewRecord']")),"New");
		Thread.sleep(3000);
		return new NewAccountPage();
	}

	//select All Suppliers view
  	public AccountsPage selectAllSupplierView() throws InterruptedException {
  		Thread.sleep(2000);
  		click(getDriver().findElement(By.xpath("//*[contains(@id,'ViewSelecto')]")),"Select a view");
  		Thread.sleep(5000);
  		click(getDriver().findElement(By.xpath("//*[contains(text(),'All Suppliers')]")),"All Suppliers View");
  		Thread.sleep(10000);
  		return this;
  	}
  	
  //select Active Member view
  	public AccountsPage selectActiveMembers() throws InterruptedException {
  		Thread.sleep(2000);
  		click(getDriver().findElement(By.xpath("//*[contains(@id,'ViewSelecto')]")),"Select a view");
  		Thread.sleep(5000);
  		click(getDriver().findElement(By.xpath("//*[contains(text(),'Active Members')]")),"Active Members View");
  		Thread.sleep(10000);
  		Thread.sleep(11000);
  		return this;
  	} 
//Search accounts
  	public  AccountsPage searchAccount(String crmNumberInput) throws InterruptedException {	
  		//click(getDriver().findElement(By.xpath("//*[@title='Select a view']")),"Select a view");
		click(getDriver().findElement(By.xpath("//*[contains(@id,'ViewSelecto')]")),"Select a view");
		click(getDriver().findElement(By.xpath("//*[contains(text(),'All Accounts')]")),"All Accounts");
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebDriverWait wait= new WebDriverWait(getDriver(),10);
		wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.xpath("//*[contains(@id,'quickFind_text')]"))));
		typeAndEnter(getDriver().findElement(By.xpath("//*[contains(@id,'quickFind_text')]")),crmNumberInput,"Find Criteria" );
		Thread.sleep(7000);
		return this;
	}

  //Select member account from search results
  	public  MemberFormPage selectAccountFromSearchResults() throws InterruptedException {	
  		//Actions action = new Actions(getDriver());
  		click(getDriver().findElement(By.xpath("//div[@col-id='name']//a")),"Search Results");
  		//click(getDriver().findElement(By.xpath("//*[@data-id='cell-0-6']/a")),"Search Results");
  		Thread.sleep(6000);
  		return new MemberFormPage();
  	}	
  	
  	
  
  	 //Select All Prospects view
  	public AccountsPage selectAllProspects() throws InterruptedException {
  		Thread.sleep(2000);
  		click(getDriver().findElement(By.xpath("//*[contains(@id,'ViewSelecto')]")),"Select a view");
  		Thread.sleep(5000);
  		click(getDriver().findElement(By.xpath("//*[contains(text(),'All Prospects')]")),"All Prospects View");
  		Thread.sleep(10000);
  		return this;
  	} 	
  	
  //Select an Account from All Prospects view
  	public  MemberFormPage selectAccountFromAllProspectsView() throws InterruptedException {	
		doubleClick(getDriver().findElement(By.xpath("//div[@col-id='name']//a")),"Account from All Prospects View");
		return new MemberFormPage();
	}
  	
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Base Read Only~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //+New Button
    	public AccountsPage verifyNewButtonIsNotPresent() {
    		List<WebElement> newButton= getDriver().findElements(By.xpath("//span[contains(text(),'New')]"));
    		verifyElementisNotDisplayed(newButton.size()," ' + New' Button ");
    		return this;
    	}
    	
    
    	public  AccountsPage searchString(String String) throws InterruptedException {	

    		typeAndEnter(getDriver().findElement(By.xpath("//*[contains(@id,'quickFind_text')]")),String,"Find Criteria" );
    		Thread.sleep(5000);
    		return this;

    	}
    	
    	public  AccountsPage clickclearButton() throws InterruptedException {	
    		click(getDriver().findElement(By.xpath("//span[@id='quickFind_button_icon_1']")),"clear Button");
    		Thread.sleep(10000);
    		Thread.sleep(10000);
    		return this;
    	}
    	
    	//select Draft Members view
    	public AccountsPage verifyAccountisDisplayed() throws InterruptedException {
    		Thread.sleep(2000);
    		verifIsNoTNullWithText(getDriver().findElement(By.xpath("//div[contains(@class,'ag-cell-value') and @col-id='name']")), "Account Number");
    		return this;
    	} 
    	
    	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~End Base Read Only~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    	//Verify DEA and HIN Column
    	public AccountsPage verifyAccountnumberColumns() throws InterruptedException, AWTException {
    	
    		Thread.sleep(5000);
    		click(getDriver().findElement(By.xpath("//span[contains(@class,'ms-Button-label') and contains(text(),'Edit columns')]")),"Edit ColumnsButton");
    		Thread.sleep(3000);
    		verifyDisplayed(getDriver().findElement(By.xpath("(//span[contains(@class,'pa-') and contains(text(),'DEA')])[2]")), "DEA");
    		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(@class,'pa-') and contains(text(),'HIN')]")), "HIN");
    		click(getDriver().findElement(By.xpath("//button[@aria-label='Close']")),"Close Button");
    		
    		return this;
    	}
    	
    	//Signout
      	public AccountsPage clickSignout() throws InterruptedException {
      		click(getDriver().findElement(By.xpath("//div[@class='mectrl_profilepic mectrl_profilepic_initials']")),"User Icon");
      		Thread.sleep(3000);	 
      		click(getDriver().findElement(By.id("mectrl_body_signOut")),"Signout");
      		return new AccountsPage();
      	}
      	public  MemberFormPage selectDirectParentFromSearchResults() throws InterruptedException {	
    		Actions action = new Actions(getDriver());	
    		
    		/*
    		 * action.moveToElement(getDriver().findElement(By.xpath(
    		 * "//*[@data-id='cell-0-4']/a")));
    		 * action.doubleClick(getDriver().findElement(By.xpath(
    		 * "//*[@data-id='cell-0-4']/a"))).build().perform();
    		 */
    		
    		  action.moveToElement(getDriver().findElement(By.xpath(
    		  "//div[@col-id='parentaccountid']//a")));
    		  action.doubleClick(getDriver().findElement(By.xpath(
    		  "//div[@col-id='parentaccountid']//a"))).build().perform();
    		 	return new MemberFormPage();
    	}
	
	//select Draft Members view
  	public AccountsPage selectDraftMembers() throws InterruptedException {
  		Thread.sleep(2000);
  		click(getDriver().findElement(By.xpath("//*[contains(@id,'ViewSelecto')]")),"Select a view");
  		Thread.sleep(5000);
  		click(getDriver().findElement(By.xpath("//*[contains(text(),'Draft Members')]")),"Draft Members View");
  		Thread.sleep(10000);
  		return this;
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
//		action.moveToElement(getDriver().findElement(By.xpath("//span[contains(@class,'RowSelectionCheckMarkSpan')]//i[@data-icon-name='StatusCircleCheckmark']")));
//		action.doubleClick(getDriver().findElement(By.xpath("//span[contains(@class,'RowSelectionCheckMarkSpan')]//i[@data-icon-name='StatusCircleCheckmark']"))).build().perform();
//		action.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-0-6']")));
//		action.doubleClick(getDriver().findElement(By.xpath("//*[@data-id='cell-0-6']"))).build().perform();
		action.moveToElement(getDriver().findElement(By.xpath("//div[@col-id='name']//a")));
		action.doubleClick(getDriver().findElement(By.xpath("//div[@col-id='name']//a"))).build().perform();
		Thread.sleep(10000);
		Thread.sleep(4000);
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

 
  	 //Select an Account from Draft Members view
  	public  MemberFormPage selectAccountFromDraftMembersView() throws InterruptedException {	
		click(getDriver().findElement(By.xpath("//div[@col-id='name']//a")),"Account from Draft Members View");
		return new MemberFormPage();
	}
  	

  	
}