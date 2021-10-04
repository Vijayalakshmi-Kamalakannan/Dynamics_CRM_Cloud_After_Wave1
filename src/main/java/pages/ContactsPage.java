package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;

import driver.Driver;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

public class ContactsPage extends WebDriverServiceImpl{
	
	public ContactsPage clickNewOnContactsPage() {
		click(getDriver().findElement(By.xpath("//span[@command='contact|NoRelationship|HomePageGrid|Mscrm.NewRecordFromGrid']")),"New");
		return this;
	}

	public ContactsPage typeContactName(String firstName,String lastName) {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		
		//Click on Full name
		click(getDriver().findElement(By.id("fullname")),"Full Name");
		
		//Type first name
		click(getDriver().findElement(By.id("fullname_compositionLinkControl_firstname")),"First Name");
		type(((getDriver().findElement(By.id("fullname_compositionLinkControl_firstname_i")))),firstName, "First Name");
	
		//Type second name
		click(getDriver().findElement(By.id("fullname_compositionLinkControl_lastname")),"Last Name");
		type(((getDriver().findElement(By.id("fullname_compositionLinkControl_lastname_i")))),lastName, "Last Name");
	
		//Click on done
		click(getDriver().findElement(By.id("fullname_compositionLinkControl_flyoutLoadingArea-confirm")),"Done");
		return this;
	}

	public ContactsPage selectPrimaryAccount(String primaryAccount) {
		click(getDriver().findElement(By.id("parentcustomerid")),"Primary Account");
		typeAndChoose(getDriver().findElement(By.id("parentcustomerid_ledit")), primaryAccount,"Primary Account");
		return this;
	}
	
	public ContactsPage AddMemberPrimaryContactFromLookUp(String PrimaryContactLookUp) throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		Actions action = new Actions(getDriver());
		Thread.sleep(3000);
		action.moveToElement(getDriver().findElement(By.id("parentcustomerid"))).perform();
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//img[@id='parentcustomerid_i']")),"Primary Contact");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//span[contains(text(),'Look Up More Records')]")),"Look Up More Records");
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		click(getDriver().findElement(By.xpath("//*[@id='crmGrid_clearCriteriaImg']")),"Clear");
		type(getDriver().findElement(By.id("crmGrid_findCriteria")),PrimaryContactLookUp,"Primary Contact in LookUp");	
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@id='crmGrid_findCriteriaImg']")),"Find Criteria");
		click(getDriver().findElement(By.id("butBegin")),"Add");
		Thread.sleep(5000);
		return this;
	}
	

	public ContactsPage clickOnContactDeactivate() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@id='contact|NoRelationship|Form|Mscrm.Form.contact.Deactivate']/span/a/span")),"Deactivate");
		Thread.sleep(10000);
		return this;
	}
	
	
	public ContactsPage clickConfirmDeactivation() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		click(getDriver().findElement(By.id("ok_id")),"Confirm");
		Thread.sleep(10000);
		return this;
	}
	
	public ContactsPage clickSave() throws InterruptedException {
		click(getDriver().findElement(By.id("savefooter_statuscontrol")),"Save");
		Thread.sleep(5000);
		return this;
	}
	
	public ContactsPage isInnovatixContactIDDisplayed() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		String sCRMNumber = getTextValue(getDriver().findElement(By.id("ix_innovatixcontactid")), "Innovatix Contact ID");;
		js.executeScript("return document.getElementById('ix_innovatixcontactid').innerHTML").toString();
		 try {
				DataInputProvider.setCellData(sCRMNumber.toString(), Driver.iTestCaseRowNumDriver, "CRMNumber",Driver.properties.getProperty("DriverSheetName"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		return this;
	}
	
	public ContactsPage chooseRecordStatus(String recordStatus) throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("ix_recordstatus")),"Record Status");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),recordStatus,"Record Status");
		getDriver().findElement(By.id("ix_recordstatus")).sendKeys(Keys.TAB);
		verifyExactText(getDriver().findElement(By.id("ix_recordstatus")),recordStatus,"Record Status"); 
		return this;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~AccountAssocoation~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public ContactsPage clicAddContatAccountAssociation() throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		click(getDriver().findElement(By.id("ContactAccountAssociation_addImageButtonImage")),"Add");
		Thread.sleep(5000);
		return this;
	}
	
	public ContactsPage typeAccountInCAA(String account) throws InterruptedException {
		Thread.sleep(2000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		click(getDriver().findElement(By.id("ix_account")),"Account");
		typeAndChoose(getDriver().findElement(By.id("ix_account_ledit")), account,"Account");
		return this;
	}
	
	public ContactsPage clickSaveInContactAccountAssociation() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("globalquickcreate_save_button_NavBarGloablQuickCreate")),"Save");
		Thread.sleep(5000);
		return this;
	}
	
	public ContactsPage clickGridViewInContactAccountAssociation() throws InterruptedException {
		scrollDown(((getDriver().findElement(By.id("ContactAccountAssociation_openAssociatedGridViewImageButtonImage")))));
		//click(getDriver().findElement(By.xpath("//*[@id='ContactAccountAssociation_openAssociatedGridViewImageButtonImage']")),"Open Associated Grid View");
		Thread.sleep(5000);
		return this;
	}
	public ContactsPage clickCAAAssociatedViewAndSelectContactInactiveView() throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("area_ix_contact_ix_contactaccountassociation_ContactFrame")));
		click(getDriver().findElement(By.id("crmGrid_ix_contact_ix_contactaccountassociation_Contact_SavedNewQuerySelector")),"Contact Account Association");
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//*[@id='Dialog_0']/div/ul/li[5]")),"Contact Inactive View");
		Thread.sleep(5000);
		return this;
	}
	public ContactsPage clickCAAAssociatedViewAndSelectContactSubGridView() throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("area_ix_contact_ix_contactaccountassociation_ContactFrame")));
		click(getDriver().findElement(By.id("crmGrid_ix_contact_ix_contactaccountassociation_Contact_SavedNewQuerySelector")),"Contact Account Association");
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//*[@id='Dialog_0']/div/ul/li[4]")),"Sub Grid View");
		Thread.sleep(5000);
		return this;
	}
	
	public ContactsPage verifyContactAccAssoTerminationReasonInSubGridView(String terminationReason) {
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='crmGrid_ix_contact_ix_contactaccountassociation_Contact_divDataArea']/div/table/tbody/tr/td[6]/nobr")),terminationReason,"Termination Reason in Contact Account Association Sub Grid View"); 
		return this;
	}
			
	public ContactsPage verifyContactAccAssoRelatioEndDateInSubGridView(String relatioshipEndDate) {
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='crmGrid_ix_contact_ix_contactaccountassociation_Contact_divDataArea']/div/table/tbody/tr/td[5]/div")),relatioshipEndDate,"Relationship End Date in Contact Account Association Sub Grid View"); 
		return this;
	}
	
	public ContactsPage verifyContactAccAssoRelatioEndDateInSubGridViewCurrentDate() throws InterruptedException {
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy ");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 Thread.sleep(3000);
		 
		 verifyExactText(getDriver().findElement(By.xpath("//*[@id='crmGrid_ix_contact_ix_contactaccountassociation_Contact_divDataArea']/div/table/tbody/tr/td[5]/div")),date1,"Relationship End Date in Contact Account Association Sub Grid View"); 
		return this;
	}
	
	public ContactsPage doubleClickOnContactAccountAssociationRecordInSubGridView() throws InterruptedException {
		Thread.sleep(3000);
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@id='crmGrid_ix_contact_ix_contactaccountassociation_Contact_divDataArea']/div/table/tbody/tr/td[6]/nobr"))).
	      doubleClick().
	      build().perform();
		Thread.sleep(3000);
		return this;
	}
	public ContactsPage doubleClickOnContactAccountAssociationRecordInactiveView() throws InterruptedException {
		Thread.sleep(3000);
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@id='crmGrid_ix_contact_ix_contactaccountassociation_Contact_divDataArea']/div/table/tbody/tr/td[5]/div"))).
	      doubleClick().
	      build().perform();
		Thread.sleep(3000);
		return this;
	}
	
	public ContactsPage chooseContactTerminationReason(String contactTerminationReason) throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("ix_terminationreason")),"Termination Reason");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_terminationreason_i")))),contactTerminationReason,"Termination Reason");
		getDriver().findElement(By.id("ix_terminationreason")).sendKeys(Keys.TAB);
		verifyExactText(getDriver().findElement(By.id("ix_terminationreason")),contactTerminationReason,"Termination Reason"); 
		Thread.sleep(3000);
		return this;
	}
	
	
	public ContactsPage typeContactRelationshipEndDate(String contactRelationshipEndDate) {
		click((getDriver().findElement(By.id("ix_relationshipenddate"))),"Contact Relationship End Date");
		type(((getDriver().findElement(By.id("ix_relationshipenddate_iDateInput")))),contactRelationshipEndDate, "Relationship End Date");
		return this;
	}
	
	public ContactsPage verifyContactRecordStatus(String contactRecordStatus) throws InterruptedException {	
		Thread.sleep(5000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		//scrollDown(((getDriver().findElement(By.id("tab_2_header_image_div")))));
		scrollDown(getDriver().findElement(By.xpath("//*[@id='Status_label']")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='Status_label']")),contactRecordStatus,"Contact Record Status"); 
		return this;
	}
	
	
	public ContactsPage doubleClickOnContactAccountAssociationRecord() throws InterruptedException {
		Thread.sleep(5000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr/td[4]/div"))).
	      doubleClick().
	      build().perform();
		Thread.sleep(3000);
		return this;
	}
	
	public ContactsPage doubleClickOnContactAccountAssociationRecordWithFrame1() throws InterruptedException {
		Thread.sleep(5000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr/td[4]/div"))).
	      doubleClick().
	      build().perform();
		Thread.sleep(3000);
		return this;
		}
	  
			
			
	public ContactsPage typeContactEndDate(String contactEndDate) {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		click((getDriver().findElement(By.id("ix_contactenddate"))),"Contact End Date");
		type(((getDriver().findElement(By.id("ix_contactenddate_iDateInput")))),contactEndDate, "Contact End Date");
		return this;
	}
	
	
	public ContactsPage clickSaveDuplicateDetected() {
		try {
			Thread.sleep(5000);
			switchToDefaultContent();
			if (getDriver().findElement(By.id("InlineDialog_Iframe")).isEnabled())
			{
				switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
				click(getDriver().findElement(By.id("butBegin")),"Ok");
				Thread.sleep(10000);
				switchToDefaultContent();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}catch (WebDriverException e) {
			e.printStackTrace();
		}
		return this;
	}

	public ContactsPage verifyContactRecordStatusInCAA(String contactRecordStatus) throws InterruptedException {	
		Thread.sleep(5000);
		switchToDefaultContent();
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		scrollDown(((getDriver().findElement(By.id("tab_2_header_image_div")))));
		scrollDown(((getDriver().findElement(By.id("Status_label")))));
		verifyExactText(getDriver().findElement(By.id("Status_label")),contactRecordStatus,"Contact Record Status"); 
		return this;
	}
	
	public ContactsPage verifyContactAccAssoIsCreated(String account) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactAccountAssociation_divDataArea']/div/table/tbody/tr/td[3]/nobr")),account,"Contact Account Association Grid"); 
		return this;
	}
	
	public ContactsPage verifyContactAccAssoRelationshipEndDate(String account) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactAccountAssociation_divDataArea']/div/table/tbody/tr/td[5]/div")),account,"Contact Account Association Grid"); 
		return this;
	}

	public ContactsPage verifyErrorMsgForDuplicateCAA(String ErrMsg) throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		verifyPartialText(getDriver().findElement(By.id("ErrorMessage")),ErrMsg,"Error Message"); 
		Thread.sleep(3000);
		return this;
	}
	
	public ContactsPage clickOkErrorMsgForDuplicateCAA() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		click(getDriver().findElement(By.id("butBegin")),"Ok");
		Thread.sleep(3000);
		return this;
	}
	
	public ContactsPage clickCloseInCAA() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("closeButton")),"Close");
		Thread.sleep(3000);
		return this;
	}
	
	

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Job Function~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public ContactsPage clicAddJobFunction() throws InterruptedException {
		click(getDriver().findElement(By.id("ContactJobFunctionSubgrid_addImageButtonImage")),"Add");
		Thread.sleep(10000);
		return this;
	}
	
	public ContactsPage typeJobFunction(String jobFunction) throws InterruptedException {
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		click(getDriver().findElement(By.id("ix_jobfunctionnew")),"Job Function");
		typeAndChoose(getDriver().findElement(By.id("ix_jobfunctionnew_ledit")), jobFunction,"Job Function");
		return this;
	}
	
	public ContactsPage verifyJobFunctionIsCreated(String jobFunction) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactJobFunctionSubgrid_divDataArea']/div/table/tbody/tr/td[3]/nobr")),jobFunction,"Job Function Grid"); 
		return this;
	}
	
	public ContactsPage verifyDuplicateJobFunctionIsCreated(String jobFunction) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactJobFunctionSubgrid_divDataArea']/div/table/tbody/tr[2]/td[3]/nobr")),jobFunction,"Job Function Grid"); 
		return this;
	}
	
	public ContactsPage clickSaveInJobFunction() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("globalquickcreate_save_button_NavBarGloablQuickCreate")),"Save");
		Thread.sleep(10000);
		return this;
	}
	public ContactsPage verifyJobFunctionTerminationStatus(String terminationStatus) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactJobFunctionSubgrid_divDataArea']/div/table/tbody/tr/td[4]")),terminationStatus,"Termination Status in Job Function Grid"); 
		return this;
	}
	
	public ContactsPage verifyJobFunctionHasNoRecords(String noRecordAlert) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactJobFunctionSubgrid_divDataArea']/table/tbody/tr/td/div[2]")),noRecordAlert,"Job Function Grid"); 
		return this;
	}
	//
	public ContactsPage verifyErrorInJobFunction() {	
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		verifyDisplayed(getDriver().findElement(By.xpath("//*[@id='ix_jobfunctionnew_warnSpan']")),"Error in Job Function");
		return this;
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Communication/Publication~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/*public ContactsPage clicAddCommunicationPublication() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		click(getDriver().findElement(By.xpath("//*[@id='ContactCommunicationSubgrid_addImageButtonImage']")),"Add");
		Thread.sleep(10000);
		return this;
	}*/
	
	public ContactsPage clicAddCommunicationPublication() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@id='ContactCommunicationSubgrid_addImageButtonImage']")),"Add");
		Thread.sleep(5000);
		return this;
	}
	
	public ContactsPage typeCommunicationPublication(String communicationPublication) throws InterruptedException {
		Thread.sleep(5000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		click(getDriver().findElement(By.id("ix_communicationpublication")),"Communication/Publication Type");
		typeAndChoose(getDriver().findElement(By.id("ix_communicationpublication_ledit")), communicationPublication,"Communication Publication");
		return this;
	}
	
	public ContactsPage clickSaveInCommunicationPublication() throws InterruptedException {
		Thread.sleep(3000);
		switchToDefaultContent();
		click(getDriver().findElement(By.id("globalquickcreate_save_button_NavBarGloablQuickCreate")),"Save");
		Thread.sleep(5000);
		return this;
	}
	
	public ContactsPage pageRefresh() throws InterruptedException {
		getDriver().navigate().refresh();
		Thread.sleep(5000);		
		return this;
	}
	public ContactsPage chooseActiveContact(String CrmNumber1) throws InterruptedException   {
	    switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));	
		click(getDriver().findElement(By.id("crmGrid_findCriteria")),"Find Criteria");		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),CrmNumber1,"Find Criteria");
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@id='gridBodyTable']/tbody/tr/td[4]/nobr"))).
	      doubleClick().
	      build().perform();	      
		Thread.sleep(6000);
		return this;
	}
	public ContactsPage verifyCommPublicationsIsCreated(String communicationPublication) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactCommunicationSubgrid_divDataArea']/div/table/tbody/tr/td[3]/nobr")),communicationPublication,"Communication Publications Grid"); 
		return this;
	}	
	
	public ContactsPage verifyDuplicateCommPublicationsIsCreated(String communicationPublication) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactCommunicationSubgrid_divDataArea']/div/table/tbody/tr[2]/td[3]/nobr")),communicationPublication,"Communication Publications Grid"); 
		return this;
	}
	
	public ContactsPage verifyCommunicationPublicationsTerminationStatus(String terminationStatus) {	
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactCommunicationSubgrid_divDataArea']/div/table/tbody/tr/td[4]")),terminationStatus,"Termination Status in Communication Publications Grid"); 
	return this;
	}
	
	public ContactsPage verifyErrorInCommPublivationn() {	
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		verifyDisplayed(getDriver().findElement(By.xpath("//*[@id='ix_communicationpublication_warnSpan']")),"Error in Job Function");
	//	verifyExactText(getDriver().findElement(By.xpath("//*[@id='ix_communicationpublication_warnSpan']")),"Test","Termination Status in Communication Publications Grid"); 
		return this;
	}

	public ContactsPage verifyCommunicationPublicationsHasNoRecord(String noRecordAlert) {	
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactCommunicationSubgrid_divDataArea']/table/tbody/tr/td/div[2]")),noRecordAlert,"Communication Publications Grid"); 
	return this;
	}
}
	
	
	
	
	
	
	