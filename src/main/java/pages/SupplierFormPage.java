package pages;

import static org.testng.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert; 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driver.Driver;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

public class SupplierFormPage extends WebDriverServiceImpl{

	public SupplierFormPage defaultAccountStatus(String defaultAccountStatus) throws InterruptedException {
	//	driver.navigate().refresh();
		Thread.sleep(5000);
		verifyExactText((getDriver().findElement(By.xpath("(//*[@data-id='form-header']/div[2]/div/div/div/div/div)[2]"))),defaultAccountStatus,"Account Status");
		return this;
	}
	
	public SupplierFormPage typeAccountName(String accountName) {
		click(getDriver().findElement(By.xpath("//*[@data-id='name.fieldControl-text-box-text']")),"Account Name");
		type(((getDriver().findElement(By.xpath("//*[@data-id='name.fieldControl-text-box-text']")))),accountName,"Account Name");
		return this;
	}
	
	public SupplierFormPage defaultAccountType(String defaultAccountType) {
		verifyExactTextWithTitleAttribute((getDriver().findElement(By.xpath("//*[@data-id='customertypecode.fieldControl-option-set-select']"))),defaultAccountType,"Account Type");
		return this;
	}
	public SupplierFormPage pickPremierStartDate(String premierStartDate) throws InterruptedException {
		Thread.sleep(1000);
		type(getDriver().findElement(By.xpath("//*[@data-id='ix_premiermemberstartdate.fieldControl-date-time-input']")),premierStartDate,"Premier Start Date");
		return this;
	}
	
	public SupplierFormPage recordChangeStatus(String recordChangeStatus) {
		verifyExactTextWithTitleAttribute((getDriver().findElement(By.xpath("//*[@data-id='ix_recordchangestatus.fieldControl-option-set-select']"))),recordChangeStatus," Record Change Status");
		return this;
	}

	public SupplierFormPage verifyRecordChangeStatus(String verifyRecordChangeStatus) {
		verifyExactTextWithTitleAttribute((getDriver().findElement(By.xpath("//*[@data-id='ix_recordchangestatus.fieldControl-option-set-select']"))),verifyRecordChangeStatus," Record Change Status");
		return this;
	}
	
	public SupplierFormPage verifyDefaultRecordChangeStatus() {
		System.out.println(getDriver().findElement(By.xpath("//*[@data-id='ix_recordchangestatus.fieldControl-option-set-select']")).getAttribute("title"));
		verifyExactTextWithTitleAttribute((getDriver().findElement(By.xpath("//*[@data-id='ix_recordchangestatus.fieldControl-option-set-select']"))),"Approved"," Record Change Status");
		return this;
	}
	
	
	public SupplierFormPage chooseAccountStatus() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@title='ADMINISTRATION']")),"ADMINISTRATION");
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_accountstatus.fieldControl-option-set-select']")),"Inactive","Account Status");
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_accountstatus.fieldControl-option-set-select']")),"Inactive","Account Status");
		Thread.sleep(3000);
		return this;
	}
	
	public SupplierFormPage chooseRecordChangeStatus(String Status) throws InterruptedException {
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_recordchangestatus.fieldControl-option-set-select']")),Status,"Record change Status");
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_recordchangestatus.fieldControl-option-set-select']")),Status,"Account Status");
		Thread.sleep(3000);
		return this;
	}
	//*****Method to verify Business Process Error when Supplier Account Status is made Inactive*****//	
	public SupplierFormPage verifyInactiveAccountStatusError(String expectedAccountStatusErrorText) {
		verifyPartialText((getDriver().findElement(By.xpath("//*[@id='subtitle']"))), expectedAccountStatusErrorText,"In Active Account Status Error");
		click(getDriver().findElement(By.xpath("//*[@id='cancelButton']")),"Ok");
		return this;
	}
	
	
	
	public SupplierFormPage verifyPremierStartDateAsCurrentDate() throws InterruptedException {
		Thread.sleep(4000);
		 DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		 Date date = new Date();
		 String date1= dateFormat.format(date); 
		 verifyExactValue(getDriver().findElement(By.xpath("//*[@data-id='ix_premiermemberstartdate.fieldControl-date-time-input']")),date1,"Premier Start Date");
		return this;
	}
	
	 
	public SupplierFormPage selectBusinessClassification(String businessClassification) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_businessclassification.fieldControl-LookupResultsDropdown_ix_businessclassification_textInputBox_with_filter_new']")),"Business Classification");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_businessclassification.fieldControl-LookupResultsDropdown_ix_businessclassification_textInputBox_with_filter_new']")))),businessClassification,"Business Classification");
		Thread.sleep(4000);
		click(getDriver().findElement(By.xpath("(//span[normalize-space()='"+businessClassification+"'])[2]")),"Business Classification");
		Thread.sleep(4000);
		return this;
	}
	
	public SupplierFormPage pageRefresh() throws InterruptedException {
		getDriver().navigate().refresh();
		Thread.sleep(10000);
		return this;
	}

	public SupplierFormPage addSupplierPrimaryContact(String addSupplierPrimaryContact) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='primarycontactid.fieldControl-LookupResultsDropdown_primarycontactid_textInputBox_with_filter_new']")),"Primary Contact");
		type(((getDriver().findElement(By.xpath("//*[@data-id='primarycontactid.fieldControl-LookupResultsDropdown_primarycontactid_textInputBox_with_filter_new']")))),addSupplierPrimaryContact,"Primary Contact");
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//*[contains(@id,'primarycontactid.fieldControl-firstname0_0_0')]")),addSupplierPrimaryContact);
		return this;
	}
	
	public SupplierFormPage verifyPrimaryContactValue(String verifyPrimaryContactValue) throws InterruptedException {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='primarycontactid.fieldControl-LookupResultsDropdown_primarycontactid_selected_tag_text']")), verifyPrimaryContactValue,"Primary Contact");
		return this;
	}

	public SupplierFormPage clickSave() throws InterruptedException {
		//click(getDriver().findElement(By.xpath("//*[@data-id='edit-form-save-btn']")),"Save");
		click(getDriver().findElement(By.xpath("//*[@data-id='account|NoRelationship|Form|Mscrm.Form.account.Save']")),"Save");
		Thread.sleep(10000);
		Thread.sleep(10000);
		return this;

	}
	
	public SupplierFormPage clickVerticalButton() {
		List<WebElement> count=getDriver().findElements(By.xpath("//span[contains(text(),'Refresh')]"));
		if(count.size()>0)
			click(getDriver().findElement(By.xpath("//span[contains(text(),'Refresh')]")),"Click Refresh");
		else {
		click(getDriver().findElement(By.xpath("//span[contains(@class,'MoreVertical-symbol')]")),"Vertical Button");
		click(getDriver().findElement(By.xpath("//button[contains(text(),'Refresh')]")),"Refresh");
		}
		return this;
	}
	
	public SupplierFormPage crmNumberIsDisplayed() throws InterruptedException {
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//*[@title='NY INFORMATION']")),"My Information Label");
		String sCRMNumber = getAttribute(getDriver().findElement(By.xpath("//*[@data-id='accountnumber.fieldControl-text-box-text']")),"value","CRM Number");
		 try {
				DataInputProvider.setCellData(sCRMNumber.toString(), Driver.iTestCaseRowNumDriver, "CRMNumber",Driver.properties.getProperty("DriverSheetName"));
				assertNotNull(sCRMNumber);
		 } catch (Exception e) {
				e.printStackTrace();
			}
		return this;
	}

	public SupplierFormPage entityCodeIsDisplayed() throws InterruptedException {
		Thread.sleep(6000);
		String entityCode =getTextValue(getDriver().findElement(By.xpath("(//*[@data-id='form-header']/div[2]/div/div/div/div/div)[1]")),"Entity Code");
		assertNotNull(entityCode);
		return this;
	}
	
	public LoginPage clickLogout() {
		
		click(getDriver().findElement(By.xpath("//*[@id='mectrl_headerPicture']")),"User Name button");
		click(getDriver().findElement(By.xpath("//button[contains(text(),'Sign out')]")),"Sign Out button");
		if(getDriver().findElements(By.xpath("//span[contains(text(),'Discard changes')]")).size()>0) {
			click(getDriver().findElement(By.xpath("//span[contains(text(),'Discard changes')]")),"Discard button");
		}
		
		return new LoginPage();
		
		
	}
	
	public SupplierFormPage verifyEntityCode(String verifyEntityCode) throws InterruptedException {
		 verifyExactText(getDriver().findElement(By.xpath("(//*[@data-id='form-header']/div[2]/div/div/div/div/div)[1]")), verifyEntityCode,"Entity code");
		return this;
	}
	//Click on Accounts in My work
		public AccountsPage selectAccountsTab() throws InterruptedException {	
			click(getDriver().findElement(By.xpath("//span[text()='Accounts']")),"Accounts");
			Thread.sleep(2000);
			return new AccountsPage();
		}
	
	public SupplierFormPage clickDiscardChanges() throws InterruptedException {
		Thread.sleep(4000);
		click(getDriver().findElement(By.xpath("//*[@data-id='cancelButton']")),"Discard Changes");
		Thread.sleep(2000);
		return new SupplierFormPage();
	}
		
	public SupplierFormPage verifyMainAccountEntityCode(String verifyEntityCode) throws InterruptedException {
		Assert.assertFalse(getTextValue(getDriver().findElement(By.xpath("(//*[@data-id='form-header']/div[2]/div/div/div/div/div)[1]")),"Entity Code").equals(verifyEntityCode));
		return this;
	}
	public SupplierFormPage verifyAccountName(String verifyAccountName) throws InterruptedException {		
		verifyExactTextWithTitleAttribute(((getDriver().findElement(By.xpath("//*[@data-id='name.fieldControl-text-box-text']")))),verifyAccountName,"Account Name");
		return this;
	}

	public SupplierFormPage clickIsTPYes() throws InterruptedException {
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_istopparent.fieldControl-checkbox-select']")), "Yes","Is Top Parent");
		Thread.sleep(2000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_istopparent.fieldControl-checkbox-container']")), "Yes","Is Top Parent");
		return this;
	}
	
	public SupplierFormPage clickIsTPNo() throws InterruptedException {
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_istopparent.fieldControl-checkbox-select']")), "Yes","Is Top Parent");
		Thread.sleep(2000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_istopparent.fieldControl-checkbox-container']")), "Yes","Is Top Parent");
		return this;
	}

public SupplierFormPage pickTPRDClear() throws InterruptedException {
		getDriver().findElement(By.xpath("//*[@data-id='ix_topparentrelationdate.fieldControl-date-time-input']")).click();
		getDriver().findElement(By.xpath("//*[@data-id='ix_topparentrelationdate.fieldControl-date-time-input']")).clear();
		return this;
	} 
	public SupplierFormPage pickTPRD(String selectTPRelationDate) throws InterruptedException {
		Thread.sleep(2000);
		//click(getDriver().findElement(By.xpath("//*[@data-id='ix_topparentrelationdate.fieldControl-date-time-input']")),"Top Parent Relation Date");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_topparentrelationdate.fieldControl-date-time-input']")))),selectTPRelationDate,"Top Parent Relation Date");
		return this;
	}
	
	
	

	public SupplierFormPage selectDirectParent(String directParent) throws InterruptedException {	
		click(getDriver().findElement(By.xpath("//*[@data-id='parentaccountid.fieldControl-LookupResultsDropdown_parentaccountid_textInputBox_with_filter_new']")),"Direct Parent");
		type(((getDriver().findElement(By.xpath("//*[@data-id='parentaccountid.fieldControl-LookupResultsDropdown_parentaccountid_textInputBox_with_filter_new']")))),directParent,"Direct Parent");
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//*[contains(@id,'parentaccountid.fieldControl-ix_premierein')]")),"Direct Parent");
		return this;		
	}
	
	public SupplierFormPage verifyDPValue(String verifyDPValue) throws InterruptedException {
		verifyExactText(((getDriver().findElement(By.xpath("//*[@data-id='parentaccountid.fieldControl-LookupResultsDropdown_parentaccountid_selected_tag_text']")))),verifyDPValue,"Direct Parent");
		return this;
	}

	public SupplierFormPage selectDPParentRelationDate(String selectDPRelationDate) throws InterruptedException {
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_directparentrelationdate.fieldControl-date-time-input']")))),selectDPRelationDate,"Direct Parent Relation Date");
		return this;
	}

	
	public SupplierFormPage storeLocationType(String storeLocationType) throws InterruptedException {
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_locationtype.fieldControl-option-set-select']")))),storeLocationType,"Store Location Type");
		Thread.sleep(3000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_locationtype.fieldControl-option-set-select']")),storeLocationType,"Location type"); 	
		return this;
	}
	
	public SupplierFormPage storeLocationTypeBlank() {
		selectDropDownUsingIndex(((getDriver().findElement(By.xpath("//*[@data-id='ix_locationtype.fieldControl-option-set-select']")))),0,"Store Location Type");
		return this;
	}
	
	public SupplierFormPage typeStreet1(String street1) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_line1.fieldControl-text-box-text']")),"Street");
		type((getDriver().findElement(By.xpath("//*[@data-id='address1_line1.fieldControl-text-box-text']"))), street1,"Street");
		return this;
	}

	public SupplierFormPage typeZipCode(String zipCode) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_postalcode.fieldControl-text-box-text']")),"Zip Code");
		type((getDriver().findElement(By.xpath("//*[@data-id='address1_postalcode.fieldControl-text-box-text']"))), zipCode,"Zip Code");
		return this;

	}

	public SupplierFormPage updateStreet1(String street1) {
		
		type((getDriver().findElement(By.xpath("//*[@data-id='address1_line1.fieldControl-text-box-text']"))), street1,"Street1");
		return this;
	}
		
	public SupplierFormPage updateZipCode(String zipCode) {
		type((getDriver().findElement(By.xpath("//*[@data-id='address1_postalcode.fieldControl-text-box-text']"))), zipCode,"Zip code");
		return this;
	}
	
	public SupplierFormPage recordStatusPublished(String recordStatusPublished) throws InterruptedException {
		Thread.sleep(3000);
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-select']")))),recordStatusPublished,"Record Status");
		Thread.sleep(3000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-container']")),recordStatusPublished,"Record Status"); 
		Thread.sleep(2000);
		return this;
	}


	public SupplierFormPage verifyRecordStatusPublished() throws InterruptedException {
		Thread.sleep(3000);
		//String rs=getTextValue(getDriver().findElement(By.xpath("//*[@data-id='cancelButton']")),"Record Status");
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-container']")),"Published","Record Status"); 
		return this;
	}
	
	public SupplierFormPage recordStatusDraft() throws InterruptedException {
		Thread.sleep(3000);
		selectDropDownUsingIndex(((getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-select']")))),0,"Record Status");
		Thread.sleep(3000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-container']")),"Draft","Record Status"); 
		Thread.sleep(2000);
		return this;
	}
	
	public SupplierFormPage recordStatusLock() throws InterruptedException {
		Thread.sleep(3000);		
		verifyDisplayed(getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus-locked-icon']")),"Record Status Lock");
		return this;
	}

	public SupplierFormPage recordChangeStatusLock() throws InterruptedException {
		Thread.sleep(3000);		
		verifyDisplayed(getDriver().findElement(By.xpath("//*[@data-id='ix_recordchangestatus-locked-icon']")),"Record Change Status Lock");
		return this;
	}
	
	public SupplierFormPage existingRecordStatusDraftToPublished(String recordStatusPublished) throws InterruptedException {
		Thread.sleep(3000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-container']")),"Draft","Record Status"); 
		Thread.sleep(2000);
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-select']")))),recordStatusPublished,"Record Status");
		Thread.sleep(3000);
		return this;
	}
	
	public SupplierFormPage verifyPremierEndDate(String premierEndDate) {
		verifyExactValue(getDriver().findElement(By.xpath("//*[@data-id='ix_premiermemberenddate.fieldControl-date-time-input']")),premierEndDate,"Premier End Date");
		return this;
	}
	
	public SupplierFormPage verifyPremierEndDateIsNull() {
		verifyNullValue(getDriver().findElement(By.xpath("//*[@data-id='ix_premiermemberenddate.fieldControl-date-time-input']")),"Premier End Date");
		return this;
	}
	
	public SupplierFormPage clickAddNewMembershipProviderSave() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='quickCreateSaveAndCloseBtn']")),"SAve and Close");
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//*[@title='GENERAL']")),"GENERAL");

		Thread.sleep(5000);
		return this;
	}
	
	public SupplierFormPage selectMembershipProviderStartDate(String membershipProviderStartDate) {
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_startdate.fieldControl-date-time-input']")))),membershipProviderStartDate,"Membership Provider Start Date");
		return this;
	}

public SupplierFormPage selectMembershipProviderType(String membershipProviderType) throws InterruptedException{
		Thread.sleep(3000);
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_membershiptype.fieldControl-option-set-select']")))),membershipProviderType,"Membership Provider Type");
		return this;
	}
	public SupplierFormPage typeMembershipProvider(String membershipProvider) {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_membershipprovider.fieldControl-LookupResultsDropdown_ix_membershipprovider_textInputBox_with_filter_new']")),"Membership Provider");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_membershipprovider.fieldControl-LookupResultsDropdown_ix_membershipprovider_textInputBox_with_filter_new']")))),membershipProvider,"Membership Provider");
		click(getDriver().findElement(By.xpath("//span[contains(text(),'"+membershipProvider+"')]")),"Membership Provider");
		return this;	
	}
	
	public SupplierFormPage clickAddNewMembershipProvider() throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_membership|NoRelationship|SubGridAssociated|Mscrm.SubGrid.ix_membership.AddNewStandard']")),"New Membership");
		return this;
	}

public SupplierFormPage selectMembership() throws InterruptedException {
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//*[@title='Related']")),"Related");
		click(getDriver().findElement(By.xpath("(//*[text()='Membership'])[2]")),"Membership");
		Thread.sleep(3000);
		return this;
	}
	public SupplierFormPage doubleClickOnNationalMembership(String membershipStartDate) throws InterruptedException {	
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='cell-0-3']")),"National","Membership Provider");
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='cell-0-4']")),membershipStartDate,"Membership Start Date");
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-0-2']"))).doubleClick().build().perform();
		Thread.sleep(3000);
		return this;
	}
	
	public SupplierFormPage verifyNationalMembership(String membershipStartDate) throws InterruptedException {	
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='cell-0-3']")),"National","Membership Provider");
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='cell-0-4']")),membershipStartDate,"Membership Start Date");
		Thread.sleep(3000);
		return this;
	}
	
//Double click on national membership whis does not have end date
	public SupplierFormPage doubleClickOnNewNationalMembership() throws InterruptedException {	
		Thread.sleep(6000);
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[contains(@id,'-5') and @title='---']"))).doubleClick().build().perform();
		Thread.sleep(3000);
		return this;
	}
	
	
	public SupplierFormPage selectMembershipEndReason(String EndReason) {
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_endreason.fieldControl-option-set-select']")))),EndReason,"End Reason");
		return this;
	}
	public SupplierFormPage clickMembershipSaveAndClose() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_membership|NoRelationship|Form|Mscrm.Form.ix_membership.SaveAndClose']")),"Save and Close");
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//*[@title='GENERAL']")),"GENERAL");
		Thread.sleep(5000);
		return this;
	}
	
	public SupplierFormPage clickMembershipSave() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_membership|NoRelationship|Form|Mscrm.Form.ix_membership.Save']")),"Save");
		Thread.sleep(5000);
		return this;
	}

//End reason can not be blank error validation
	public SupplierFormPage verifyEndReasonCanNotBeBlankError(String expectedAccountStatusErrorText) {
	//	verifyExactText((getDriver().findElement(By.xpath("//*[@id='subtitle']"))), expectedAccountStatusErrorText,"End Reason can not be blank Error");
		verifyPartialText((getDriver().findElement(By.xpath("//*[@id='subtitle']"))), expectedAccountStatusErrorText,"End Reason can not be blank Error");
		click(getDriver().findElement(By.xpath("//*[@id='cancelButton']")),"Ok");

		return this;
	}
	
//Date validation error in premier memvalidationError
	public SupplierFormPage verifyDateValidationError(String expectedAccountStatusErrorText) {
		verifyPartialText((getDriver().findElement(By.xpath("//*[@id='subtitle']"))), expectedAccountStatusErrorText,"Date Validation Error");
		click(getDriver().findElement(By.xpath("//*[@id='cancelButton']")),"Ok");
		return this;
	}
	
//Account can not be terminated error in premier memvalidationError
	public SupplierFormPage verifyAccountCanNotBeTerminatedError(String expectedAccountStatusErrorText) {
		verifyPartialText((getDriver().findElement(By.xpath("//*[@id='subtitle']"))), expectedAccountStatusErrorText,"Account Can not be terminated Error");
		click(getDriver().findElement(By.xpath("//*[@id='cancelButton']")),"Ok");
		return this;
	}
	
// Existing Bug :  Not Defaulting  to Supplier .Hence Choose Manually.
	public SupplierFormPage selectAccountType() {
		click(getDriver().findElement(By.xpath("//*[@data-id='statecode.fieldControl-option-set-select']")),"Account Type");
		selectDropDownUsingValue((((getDriver().findElement(By.xpath("//*[@data-id='cancelButton']"))))),"Account Type");
		return this;
	}

//Verify Premier start date
	public SupplierFormPage verifyPremierStartDate(String premierStartDate) {
		 verifyExactValue(getDriver().findElement(By.xpath("//*[@data-id='ix_premiermemberstartdate.fieldControl-date-time-input']")),premierStartDate,"Premier Start Date");
		return this;
	}
		
	//Account name 2
	public SupplierFormPage typeAccountName2(String AccountName2) {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_hiscirostername.fieldControl-text-box-text']")),"AccountName2");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_hiscirostername.fieldControl-text-box-text']")))),AccountName2,"Account name2");
		return this;
	}
	
	public SupplierFormPage verifyCAMSFlag(String VerifyCAMSFlag) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_camsflag.fieldControl-checkbox-container']")),VerifyCAMSFlag,"CAMS Flag"); 
		return this;
	}
	
	public SupplierFormPage selectOwnership(String Ownership) throws InterruptedException{
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_ownership.fieldControl-option-set-select']")))),Ownership,"Ownership");
		Thread.sleep(2000);
		
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_ownership.fieldControl-option-set-container']")),Ownership,"Ownership"); 
		return this;
	}
	
	public SupplierFormPage typeStockSymbol(String StockSymbol) {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_stocksymbol.fieldControl-text-box-text']")),"Stock Symbol");
		type(getDriver().findElement(By.xpath("//*[@data-id='ix_stocksymbol.fieldControl-text-box-text']")),StockSymbol, "Stock Symbol");
		return this;
	}
	
	public SupplierFormPage typeExchange(String Exchange) {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_exchange.fieldControl-text-box-text']")),Exchange);
		type(getDriver().findElement(By.xpath("//*[@data-id='ix_exchange.fieldControl-text-box-text']")),Exchange, "Exchange");
		return this;
	}
	
	public SupplierFormPage typeOverrideName(String OverrideName) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_name.fieldControl-text-box-text']")),"OverrideName");
		type(getDriver().findElement(By.xpath("//*[@data-id='address1_name.fieldControl-text-box-text']")),OverrideName, "OverrideName");
		return this;
	}

	public SupplierFormPage typeStreet2(String Street2) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_line2.fieldControl-text-box-text']")),"Street2");
		type(getDriver().findElement(By.xpath("//*[@data-id='address1_line2.fieldControl-text-box-text']")),Street2, "Street2");
		return this;
	}
	
	public SupplierFormPage typeDeliveryInfo(String DeliveryInfo) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_line3.fieldControl-text-box-text']")),"Delivery Info");
		type(getDriver().findElement(By.xpath("//*[@data-id='address1_line3.fieldControl-text-box-text']")),DeliveryInfo, "Delivery Info");
		return this;
	}
	public SupplierFormPage typeState(String State) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_stateorprovince.fieldControl-text-box-text']")),"State");
		type(getDriver().findElement(By.xpath("//*[@data-id='address1_stateorprovince.fieldControl-text-box-text']")),State, "State");
		return this;
	}

	
	public SupplierFormPage typeMainPhone(String MainPhone) {
		click(getDriver().findElement(By.xpath("//*[@data-id='telephone1.fieldControl-phone-text-input']")),"Teephone");
		type(getDriver().findElement(By.xpath("//*[@data-id='telephone1.fieldControl-phone-text-input']")),MainPhone, "Main Phone");
		return this;
	}
	
	public SupplierFormPage typeCity(String City) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_city.fieldControl-text-box-text']")),"City");
		type(getDriver().findElement(By.xpath("//*[@data-id='address1_city.fieldControl-text-box-text']")),City,"City");
		return this;
	}
	
	public SupplierFormPage typeCounty(String County) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_county.fieldControl-text-box-text']")),"Country");
		type(getDriver().findElement(By.xpath("//*[@data-id='address1_county.fieldControl-text-box-text']")),County,"County");
		return this;
	}
	
	public SupplierFormPage typeCountry(String Country) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_country.fieldControl-text-box-text']")),"County");
		type((getDriver().findElement(By.xpath("//*[@data-id='address1_country.fieldControl-text-box-text']"))),Country,"Country");
		return this;
	}
	
	public SupplierFormPage typeFax(String Fax) {
		click(getDriver().findElement(By.xpath("//*[@data-id='fax.fieldControl-text-box-text']")),"Fax");
		type(getDriver().findElement(By.xpath("//*[@data-id='fax.fieldControl-text-box-text']")),Fax, "Fax");
		return this;
	}
	public SupplierFormPage typeWebsite(String Website) {
		click(getDriver().findElement(By.xpath("//*[@data-id='websiteurl.fieldControl-url-text-input']")),"Website");
		type(((getDriver().findElement(By.xpath("//*[@data-id='websiteurl.fieldControl-url-text-input']")))),Website, "Website");
		return this;
	}
	public SupplierFormPage verifyReceiveDirectMail(String ReceiveDirectMail) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_receivedirectmail.fieldControl-checkbox-container']")),ReceiveDirectMail,"Receive Direct Mail"); 
		return this;
	}
	
	public SupplierFormPage verifyDoNotVerifyAddress(String DoNotVerifyAddress) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_donotverifyaddress.fieldControl-checkbox-container']")),DoNotVerifyAddress,"Do Not Verify Address"); 
		return this;
	}
	public SupplierFormPage verifyIsTopParent(String IsTopParent) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_istopparent.fieldControl-checkbox-container']")),IsTopParent,"Is Top Parent"); 
		return this;
	}
	public SupplierFormPage verifyTopParent(String TopParent) {
		verifyExactText((getDriver().findElement(By.xpath("//*[@data-id='ix_topparent.fieldControl-LookupResultsDropdown_ix_topparent_selected_tag']"))),TopParent,"Top Parent");
		return this;
	}

	public SupplierFormPage addMemberRecord(String memberRecord) throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_memberrecordid.fieldControl-LookupResultsDropdown_ix_memberrecordid_textInputBox_with_filter_new']")),"Member Record");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_memberrecordid.fieldControl-LookupResultsDropdown_ix_memberrecordid_textInputBox_with_filter_new']")))),memberRecord,"Member Record");
		Thread.sleep(4000);
		click(getDriver().findElement(By.xpath("//span[contains(text(),'"+memberRecord+"')]")),"Business Classification");
		return this;	
	}
	
	public SupplierFormPage verifyHIBCC(String VerifyHIBCC) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_hibccsubsc.fieldControl-checkbox-container']")),VerifyHIBCC,"HIBCC Subsec"); 
		return this;
	}

	public SupplierFormPage verifyNoNewProducts(String VerifyNoNewProducts) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_nonewproducts.fieldControl-checkbox-container']")),VerifyNoNewProducts,"No New Products"); 
		return this;
	}
	
	public SupplierFormPage typeMembershipEndDate(String membershipEndDate) throws InterruptedException {
		
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_enddate.fieldControl-date-time-input']")))),membershipEndDate,"End Date");
		return this;
	}
}





