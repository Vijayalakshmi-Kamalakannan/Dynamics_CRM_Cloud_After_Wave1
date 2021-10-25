package pages;


import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static org.testng.Assert.assertNotNull;

//Test Case 7312:Add and update Primary contact to a Member account
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driver.Driver;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

public class MemberFormPage extends WebDriverServiceImpl {
	
//Enter account name
	public MemberFormPage typeAccountName(String accountName) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='name.fieldControl-text-box-container']")),"Account name");
		Thread.sleep(2000);
		type(((getDriver().findElement(By.xpath("//*[@data-id='name.fieldControl-text-box-text']")))),accountName,"Account name");
		return this;
	}
	
//verify if CRM number is auto generated
	public MemberFormPage verifyCRMNumberIsDisplayed() {
		String sCRMNumber = getAttribute(getDriver().findElement(By.xpath("//*[@data-id='accountnumber.fieldControl-text-box-text']")),"value","CRM Number");
		 try {
				DataInputProvider.setCellData(sCRMNumber.toString(), Driver.iTestCaseRowNumDriver, "CRMNumber",Driver.properties.getProperty("DriverSheetName"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		return this;
	}
	
//Click on Save
	public MemberFormPage clickSave() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='edit-form-save-btn']")),"Save");
		Thread.sleep(10000);
		return this;	
	}
	
//select Account Type
	public MemberFormPage selectAccountType(String accountType) throws InterruptedException{
		click(getDriver().findElement(By.xpath("//*[@data-id='form-sectionHeader-MembershipProviderConfiguration']")),"Accoun Type");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='customertypecode.fieldControl-option-set-select']")))),accountType,"Account type");
		Thread.sleep(2000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='customertypecode.fieldControl-option-set-select']")),accountType,"Account type"); 
		return this;
	}
	
//Select Class of trade
	public MemberFormPage selectClassOfTrade(String classOfTrade) throws InterruptedException, AWTException {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_classoftradedetail.fieldControl-LookupResultsDropdown_ix_classoftradedetail_InputSearch']")),"Class of Trade");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_classoftradedetail.fieldControl-LookupResultsDropdown_ix_classoftradedetail_textInputBox_with_filter_new']")))),classOfTrade,"Class of Trade");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[contains(@id,'ix_classoftradedetail.fieldControl-ix_parent')]")),"Class of Trade");
		return this;
	}
	
//Verify business classification is auto populated
	public MemberFormPage verifyBusinessClassification(String verifyBusinessClassification) throws InterruptedException {
		Thread.sleep(3000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_businessclassification.fieldControl-LookupResultsDropdown_ix_businessclassification_selected_tag_text']")),verifyBusinessClassification,"Business Classification");
		return this;
	}
	
//Verify business classification is auto populated
	public MemberFormPage clearAndSelectBusinessClassification(String businessClassification) throws InterruptedException {
		Actions action = new Actions(getDriver());
		action.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='ix_businessclassification.fieldControl-LookupResultsDropdown_ix_businessclassification_selected_tag_text']"))).perform();
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_businessclassification.fieldControl-LookupResultsDropdown_ix_businessclassification_selected_tag_delete']")),"Delete"); 
		Thread.sleep(3000);
		click(((getDriver().findElement(By.xpath("//*[@data-id='ix_businessclassification.fieldControl-LookupResultsDropdown_ix_businessclassification_textInputBox_with_filter_new']")))),"Business Classification");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_businessclassification.fieldControl-LookupResultsDropdown_ix_businessclassification_textInputBox_with_filter_new']")))),businessClassification,"Business Classification");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[contains(@id,'ix_businessclassification.fieldControl-ix_name0_0_0')]")),"");
		return this;
	}
	
//verify default account status is active
	public MemberFormPage verifyDefaultAccountStatus() {
		verifyExactTextWithTitleAttribute((getDriver().findElement(By.xpath("//*[@data-id='ix_accountstatus.fieldControl-option-set-select']"))),"Active","Account Status");
		return this;
	}
	
//Choose application start date
	public MemberFormPage chooseApplicationDate(String applicationDate) throws InterruptedException {
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_applicationstartdate.fieldControl-date-time-input']")))),applicationDate, "Application Start Date");
		return this;
	}
	
//Change CAMS flag
	public MemberFormPage changeCAMSFlagAsYes() {
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_camsflag.fieldControl-checkbox-select']")),"Yes","CAMS Flag"); 
		return this;
	}
	
	public MemberFormPage changeCAMSFlagAsNo() {
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_camsflag.fieldControl-checkbox-select']")),"No","CAMS Flag"); 
		return this;
	}
	
//Select Participation type
	public MemberFormPage selectParticipationType(String participationType) throws InterruptedException {
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_participationtype.fieldControl-option-set-select']")),participationType,"Participation type");
		Thread.sleep(2000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_participationtype.fieldControl-option-set-select']")),participationType,"Participation type"); 
		return this;
	}
	
//select Direct parent
	public MemberFormPage selectDirectParent(String directParent) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='parentaccountid.fieldControl-LookupResultsDropdown_parentaccountid_textInputBox_with_filter_new']")),"Direct Parent");
		type(((getDriver().findElement(By.xpath("//*[@data-id='parentaccountid.fieldControl-LookupResultsDropdown_parentaccountid_textInputBox_with_filter_new']")))),directParent,"Direct Parent");
		Thread.sleep(4000);
		click(getDriver().findElement(By.xpath("//*[contains(@id,'parentaccountid.fieldControl-ix_premierein')]")),"Direct Parent");
		return this;
	}
	
//Select DPR
	public MemberFormPage selectDirectParentRelationManaged() throws InterruptedException {
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_parentrelationship.fieldControl-option-set-select']")))),"Managed","Direct Parent Relation");
		Thread.sleep(2000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_parentrelationship.fieldControl-option-set-select']")),"Managed","Direct Parent Relation"); 		
		return this;
	}
	
//Select DPRD
	public MemberFormPage selectDirectParentRelationDate(String directParentRelationDate) {
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_directparentrelationdate.fieldControl-date-time-input']")))),directParentRelationDate, "Direct Parent Relation Date");
		return this;
	}
	
//Select TPR
	public MemberFormPage selectTopParentRelation(String topParentRelation) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='form-sectionHeader-SUMMARY_TAB_section_22']")),"Top Parent");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_topparentrelationship.fieldControl-option-set-select']")))),topParentRelation,"Top Parent Relation");
		Thread.sleep(1000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_topparentrelationship.fieldControl-option-set-select']")),topParentRelation,"Top Parent Relation"); 
		return this;
	}
	
//Select TPRD
	public MemberFormPage selectTopParentRelationDate(String topParentRelationDate) {
		//click(getDriver().findElement(By.xpath("//*[@data-id='ix_topparentrelationdate.fieldControl-date-time-input']")),"Top Parent Relation Date");
		type(getDriver().findElement(By.xpath("//*[@data-id='ix_topparentrelationdate.fieldControl-date-time-input']")),topParentRelationDate,"Top Parent Relation Date");
		return this;
	}
	
//Type street1
	public MemberFormPage typeStreet1(String street1) {
		click(((getDriver().findElement(By.xpath("//*[@data-id='address1_line1.fieldControl-text-box-text']")))), "Street1");
		type(((getDriver().findElement(By.xpath("//*[@data-id='address1_line1.fieldControl-text-box-text']")))),street1, "Street1");
		return this;
	}

//Type City
	public MemberFormPage typeCity(String city) {
		click((getDriver().findElement(By.xpath("//*[@data-id='address1_city.fieldControl-text-box-text']"))),"City");
		type((getDriver().findElement(By.xpath("//*[@data-id='address1_city.fieldControl-text-box-text']"))),city,"City");
		return this;
	}
	
//Type country
	public MemberFormPage typeCountry(String country) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_country.fieldControl-text-box-text']")),"Country");
		type((getDriver().findElement(By.xpath("//*[@data-id='address1_country.fieldControl-text-box-text']"))),country,"Country");
		return this;
	}
	
//Type County
	public MemberFormPage typeCounty(String county) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_county.fieldControl-text-box-text']")),"County");
		type((getDriver().findElement(By.xpath("//*[@data-id='address1_county.fieldControl-text-box-text']"))),county,"County");
		return this;
	}
	
//Select record status published
	public MemberFormPage chooseRecordStatusPublished() throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@title='FBO']")),"FBO");//Scroll down to make the record status field visible
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-select']")))),"Published", "Record Status");	
		Thread.sleep(3000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-select']")),"Published","Record Status"); 
		return this;
	}
	
//Select record status published
	public MemberFormPage clickGeneralThenChooseRecordStatusPublished() throws InterruptedException {
		clickGeneralTab();
		chooseRecordStatusPublished();
		return this;
	}
	
	public MemberFormPage clickGeneralTab() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@title='GENERAL']")),"GENERAL");
		return this;
	}
	
//Entity code is generated
	public MemberFormPage entityCodeIsDisplayed() throws InterruptedException {
		Thread.sleep(6000);
		String entityCode =getTextValue(getDriver().findElement(By.xpath("(//*[@data-id='form-header']/div[2]/div/div/div/div/div)[1]")),"Entity Code");
		//assertNotNull(entityCode);
		return this;
	}
	
//Verify entity code
	public MemberFormPage verifyEntityCodeIsNotDPEntityCode(String verifyEntityCode) throws InterruptedException {
		Assert.assertFalse((getTextValue(getDriver().findElement(By.xpath("(//*[@data-id='form-header']/div[2]/div/div/div/div/div)[1]")),"Entity Code").toString()).equals(verifyEntityCode));
		return this;
	}
	
//Verify entity code
	public MemberFormPage verifyEntityCode(String verifyEntityCode) throws InterruptedException {
		Assert.assertTrue((getTextValue(getDriver().findElement(By.xpath("(//*[@data-id='form-header']/div[2]/div/div/div/div/div)[1]")),"Entity Code").toString()).equals(verifyEntityCode));
		return this;
	}
	
//Verify Premier Start Date is Auto Populated
	public MemberFormPage verifyPremierStartDateIsAutoPopulated()  {
		getTextValueAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_premiermemberstartdate.fieldControl-date-time-input']")),"Premier Start Date");
		return this;
	}
	
//Verify AG is not null
	public MemberFormPage verifyAffiliateGroupIsNotNull() {
		click(getDriver().findElement(By.xpath("//*[@data-id='form-sectionHeader-SUMMARY_TAB_section_9']")),"FBO");
		getTextValue(getDriver().findElement(By.xpath("//*[@data-id='ix_affiliategroup.fieldControl-LookupResultsDropdown_ix_affiliategroup_selected_tag_text']")),"Affiliate Group");
		return this;
	}
	
//Verify Ag effective is not null
	public MemberFormPage verifyAgEffectiveDateIsNotNull() {
		getTextValueAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_affiliategroupeffectivedate.fieldControl-date-time-input']")),"Affiliate Group Effective Date");
		return this;
	}
	
//Ag Effective date is null
	public MemberFormPage verifyAgEffectiveDateIsNull() {
		verifyNullValue(getDriver().findElement(By.xpath("//*[@data-id='ix_affiliategroupeffectivedate.fieldControl-date-time-input']")),"AG Effective Date"); 
		return this;
	}

//Verify Affiliate Group is Null
	public MemberFormPage verifyAffiliateGroupIsNull() {
		verifyNullValue(getDriver().findElement(By.xpath("//*[@data-id='ix_affiliategroup.fieldControl-LookupResultsDropdown_ix_affiliategroup_textInputBox_with_filter_new']")),"Affiliate Group"); 
		return this;
	}
	
//Verify is corporate parent account
	public MemberFormPage verifyIsCorporateAccount(String verifyIsCorporateAccount) {
		click(getDriver().findElement(By.xpath("//*[@data-id='form-sectionHeader-SUMMARY_TAB_section_18']")),"Corporate Account");
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_iscorporateaccount.fieldControl-checkbox-container']")),verifyIsCorporateAccount,"Is Corporate Account"); 
		return this;
	}
	
//Verify Corporate Parent Name is null
	public MemberFormPage verifyCorporateParentNameIsNull() {
		verifyNullValue(getDriver().findElement(By.xpath("//*[@data-id='ix_corporateparentname.fieldControl-LookupResultsDropdown_ix_corporateparentname_textInputBox_with_filter_new']")),"Corporate Parent Name"); 
		return this;
	}
	
//Verify Corporate Parent Name
	public MemberFormPage verifyCorporateParentName(String verifyCorporateParentName) {
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='ix_corporateparentname.fieldControl-LookupResultsDropdown_ix_corporateparentname_selected_tag_text']")),verifyCorporateParentName,"Corporate Parent Name"); 
		return this;
	}	

//Verify Is Food Service Parent
	public MemberFormPage verifyIsFoodServiceParent(String verifyIsFoodServiceParent) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_isfoodserviceparent.fieldControl-checkbox-container']")),verifyIsFoodServiceParent,"Is Food Service Parent"); 
		return this;
	}
	
//Verify Food Service Parent Name
	public MemberFormPage verifyFoodServiceParentName(String verifyFoodServiceParentName) {
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='ix_foodserviceparentname.fieldControl-LookupResultsDropdown_ix_foodserviceparentname_selected_tag_text']")),verifyFoodServiceParentName,"Food Service Parent Name"); 
		return this;
	}
	
//Verify Food Service Parent Name
	public MemberFormPage verifyFoodServiceParentNameIsNull() {
		verifyNullValue(getDriver().findElement(By.xpath("//*[@data-id='ix_foodserviceparentname.fieldControl-LookupResultsDropdown_ix_foodserviceparentname_textInputBox_with_filter_new']")),"Food Service Parent Name"); 
		return this;
	}
	
//Verify Food service Start Date
	public MemberFormPage verifyFoodServiceStartDate(String verifyFoodServiceStartDate) {
		verifyExactValue(getDriver().findElement(By.xpath("//*[@data-id='ix_foodserviceparentstartdate.fieldControl-date-time-input']")),verifyFoodServiceStartDate,"Food Service Parent Start Date"); 
		return this;
	}
	
//Verify FSP Override
	public MemberFormPage verifyFSPOverride(String verifyFSPOverride) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_foodserviceparentoverride.fieldControl-checkbox-container']")),verifyFSPOverride,"Food Service Parent Override"); 
		return this;
	}
	
//Verify Corp Parent Start Date
	public MemberFormPage verifyCorpParenttartDate(String verifyCorpParenttartDate) {
		verifyExactValue(getDriver().findElement(By.xpath("//*[@data-id='ix_corporateparentstartdate.fieldControl-date-time-input']")),verifyCorpParenttartDate,"Corporate Parent Start Date"); 
		return this;
	}
	
//Verify FBO
	public MemberFormPage verifyFBO(String verifyFBO) {
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='ix_fbo.fieldControl-LookupResultsDropdown_ix_fbo_selected_tag_text']")),verifyFBO,"FBO"); 
		return this;
	}
	
//Verify FBORD
	public MemberFormPage verifyFBORD(String verifyFBORD) {
		verifyExactValue(getDriver().findElement(By.xpath("//*[@data-id='ix_fborelationdate.fieldControl-date-time-input']")),verifyFBORD,"FBO Relation Date"); 
		return this;
	}
	
//Verify Is FBO
	public MemberFormPage verifyIsFBO(String verifyIsFBO) { 
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_isfbo.fieldControl-checkbox-container']")),verifyIsFBO, "Is FBO"); 
			return this;
	}
	
//Verify Sponsor
	public MemberFormPage verifySponsor(String verifySponsor) {
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='ix_sponsor.fieldControl-LookupResultsDropdown_ix_sponsor_selected_tag_text']")),verifySponsor,"Sponsor"); 
		return this;
	}
	
//Verify if sponsor filed is blank
	public MemberFormPage verifySponsorIsNull() {
		verifyNullValue(getDriver().findElement(By.xpath("//*[@data-id='ix_sponsor.fieldControl-LookupResultsDropdown_ix_sponsor_textInputBox_with_filter_new']")),"Sponsor"); 
		return this;
	}
	
//Verify Is sponsor
	public MemberFormPage verifyIsSponsor(String verifyIsSponsor) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_issponsor.fieldControl-checkbox-container']")),verifyIsSponsor,"Is Sponsor"); 
		return this;
	}
	
	
	
//Click Related and line of business
	public MemberFormPage clickLineOfBusiness() throws InterruptedException   {
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//*[@title='Related']")),"Related");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[contains(text(),'Line of Businesses')]")),"Line Of Businessess");
		Thread.sleep(2000);
		return this;
	}
	
//Click on add new lob
	public MemberFormPage clickAddNewLineOfBusiness() throws InterruptedException   {
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_portfoliocategory|NoRelationship|SubGridAssociated|Mscrm.SubGrid.ix_portfoliocategory.AddNewStandard']")),"Add New LOB");
		Thread.sleep(2000);
		try
		{
			if ( getDriver().findElement(By.xpath("//*[@data-id='confirmButton']")).isDisplayed())
			{
				click(getDriver().findElement(By.xpath("//*[@data-id='confirmButton']")),"Save and continue");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		Thread.sleep(6000);
		return this;
	}
		
//Select Line of business
	public MemberFormPage selectLineOfBusiness(String lineOfBusiness) throws InterruptedException   {
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_portfolio.fieldControl-option-set-select']")),lineOfBusiness,"LOB");
		Thread.sleep(2000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_portfolio.fieldControl-option-set-select']")),lineOfBusiness,"LOB");
		click(getDriver().findElement(By.xpath("//*[@data-id='errorOkButton']")),"ERROR-SCRIPT ERROR");

		return this;
	}
	
//Select LOB Classification type
	public MemberFormPage selectLOBfClassificationType(String lineOfClassification) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_classificationtypenew.fieldControl-LookupResultsDropdown_ix_classificationtypenew_textInputBox_with_filter_new']")),"Line of classification");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_classificationtypenew.fieldControl-LookupResultsDropdown_ix_classificationtypenew_textInputBox_with_filter_new']")))),lineOfClassification,"Line of classification");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("(//*[normalize-space()='"+lineOfClassification+"'])[2]")),lineOfClassification);

		
		return this;
	}
	
	//Click on deactivate in membership provider window
		public MemberFormPage clickDeleteMembershipProvider() throws InterruptedException {
			click(getDriver().findElement(By.xpath("//*[@data-id='ix_membership|NoRelationship|Form|Mscrm.Form.ix_membership.Delete']")),"Delete");
			Thread.sleep(3000);
			click(getDriver().findElement(By.xpath("//*[@data-id='confirmButton']")),"Confirm Delete");
			Thread.sleep(3000);
		//	click(getDriver().findElement(By.xpath("//*[@aria-label='OK']")),"Ok");
			//Thread.sleep(3000);
			return this;	
		}
		
//Click on deactivate in membership provider window
	public MemberFormPage clickDeactivateMembershipProvider() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_membership|NoRelationship|Form|Mscrm.Form.ix_membership.Deactivate']")),"Deactivate");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@data-id='ok_id']")),"Confirm Deactivate");
		Thread.sleep(3000);
		return this;	
	}	
	
//Type Line Of Business Start Date
	public MemberFormPage typeLineOfBusinessStartDate(String lineOfBusinessStartDate) {
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_startdate.fieldControl-date-time-input']")))),lineOfBusinessStartDate,"Line of Bussiness Start Date");
		return this;
	}
	
//Click on LOB SAve and close
	public MemberFormPage clickLOBSaveAndClose() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_portfoliocategory|NoRelationship|Form|Mscrm.Form.ix_portfoliocategory.SaveAndClose']")),"Save and Close");
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//*[@title='GENERAL']")),"GENERAL");
		Thread.sleep(5000);
		return this;	
	}	

//Click on add new membership
	public MemberFormPage clickAddNewMembership() throws InterruptedException   {
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//*[@title='Related']")),"Related");
		click(getDriver().findElement(By.xpath("(//*[text()='Membership'])[2]")),"Membership");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_membership|NoRelationship|SubGridAssociated|Mscrm.SubGrid.ix_membership.AddNewStandard']")),"New Membership");
		Thread.sleep(3000);
		return this;
	}
	
//Click on add new membership
	public MemberFormPage clickMembershipAndAddNewMembership() throws InterruptedException   {
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//*[@title='Related']")),"Related");
		click(getDriver().findElement(By.xpath("(//*[text()='Membership'])[2]")),"Membership");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_membership|NoRelationship|SubGridAssociated|Mscrm.SubGrid.ix_membership.AddNewStandard']")),"New Membership");
		Thread.sleep(3000);
		return this;
	}
	
	
//Select Membership provider type of business
	public MemberFormPage selectMembershipType(String membershipProviderType) throws InterruptedException   {
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_membershiptype.fieldControl-option-set-select']")),membershipProviderType,"Membership Provider Type");
		Thread.sleep(3000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_membershiptype.fieldControl-option-set-select']")),membershipProviderType,"Membership Provider Type");
		return this;
	}

//Select Membership provider
	public MemberFormPage selectMembershipProvider(String membershipProvider) throws InterruptedException   {	
		//click(getDriver().findElement(By.xpath("//*[@data-id='ix_membershipprovider.fieldControl-LookupResultsDropdown_ix_membershipprovider_textInputBox_with_filter_new']")),"Membership Provider");
		type(getDriver().findElement(By.xpath("//*[@data-id='ix_membershipprovider.fieldControl-LookupResultsDropdown_ix_membershipprovider_textInputBox_with_filter_new']")),membershipProvider,"Membership Provider");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//span[contains(text(),'"+membershipProvider+"')]")),"Membership Provider");
		return this;
	}
	
//Type Membership Start Date
	public MemberFormPage typeMembershipStartDate(String membershipStartDate) {
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_startdate.fieldControl-date-time-input']")))),membershipStartDate,"Membership Start Date");
		return this;
	}
	
//Click on Membership SAve and close //Quick create
	public MemberFormPage clickQuickCreateMembershipSaveAndClose() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='quickCreateSaveAndCloseBtn']")),"Save and Close");
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//*[@title='GENERAL']")),"GENERAL");
		Thread.sleep(5000);
		return this;	
	}
	//Click on Membership SAve and close 
		public MemberFormPage clickMembershipSaveAndClose() throws InterruptedException {
			click(getDriver().findElement(By.xpath("//*[@data-id='ix_membership|NoRelationship|Form|Mscrm.Form.ix_membership.SaveAndClose']")),"Save and Close");
			Thread.sleep(5000);
			click(getDriver().findElement(By.xpath("//*[@title='GENERAL']")),"GENERAL");
			Thread.sleep(5000);
			return this;	
		}		

	
//select Membership Entity
	public MemberFormPage goToMembershipPage(String membershipProvider) throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("(//span[text()='"+membershipProvider+"'])")),membershipProvider);
		Thread.sleep(3000);
		return this;
	}
	
//Double Click On National Membership
	public MemberFormPage doubleClickOnNationalMembership() throws InterruptedException {	
		//verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='MscrmControls.Grid.ReadOnlyGrid|entity_control|account|7117ccdc-6223-4fd1-8e17-e210d527f53e|ix_membership|ix_account_ix_membership_AccountName|cc-grid|cc-grid-cell|cell-1-3']")),"National","Membership Provider");
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-1-2']"))).doubleClick().build().perform();
		Thread.sleep(3000);
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='ix_membershipprovider.fieldControl-LookupResultsDropdown_ix_membershipprovider_selected_tag_text']")),"National","Membership Entity");
		return this;
	}
	
//Select TP Audit History
	public MemberFormPage selectMembershipAuditHistory() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@title='Related']")),"Related");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[contains(text(),'Audit History')]")),"Audit History");
		Thread.sleep(2000);
		return this;
	}
	
//Verify Time Stamp in Top Parent Membership Audit History
	public MemberFormPage verifyTimeStampInTPMembershipAuditHistory() { 
		getTextValue(getDriver().findElement(By.xpath("//*[@id='gridBodyTable']/tbody/tr[1]/td[2]/div")),"Time in Top Parent Membersihp Audit History"); 
		return this;
	}

//Verify Is Member Add Mail Sent
	public MemberFormPage verifyIsMemberAddMailSent() {
		switchToFrame(getDriver().findElement(By.xpath("//*[@id='audit_iframe']")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='gridBodyTable']/tbody/tr[1]/td[5]/nobr")),"Is Member Add mail sent","Audit History"); 
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='gridBodyTable']/tbody/tr[1]/td[7]/nobr")),"Yes","Is add mail sent"); 
		return this;
	}
	
//Choose Location Type
	public MemberFormPage chooseLocationType(String locationType) throws InterruptedException   {	
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_locationtype.fieldControl-option-set-select']")),locationType,"Location Type");
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_locationtype.fieldControl-option-set-select']")),locationType,"Location type"); 
		return new MemberFormPage();
	}
	
//Location type null
	public MemberFormPage chooseLocationTypeNull() throws InterruptedException   {	
		Thread.sleep(1000);
		selectDropDownUsingIndex(getDriver().findElement(By.xpath("//*[@data-id='ix_locationtype.fieldControl-option-set-select']")),0,"Location Type");
		return new MemberFormPage();
	}	

//Change Top parent
	public MemberFormPage changeTopParentAsYes() throws InterruptedException {
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_istopparent.fieldControl-checkbox-select']")),"Yes","Is Top Parent"); 
		Thread.sleep(2000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_istopparent.fieldControl-checkbox-container']")),"Yes","Is Top Parent"); 
		return this;
	}
	
//Verify direct parent relation
	public MemberFormPage verifyDirectParentRelation(String verifyDirectParentRelation) { 
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_parentrelationship.fieldControl-option-set-select']")),verifyDirectParentRelation,"Direct Parent Relation"); 		
		return this;
	}
	
//Select Region
	public MemberFormPage selectRegion(String Region) throws InterruptedException {
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_regionnew.fieldControl-option-set-select']")))),Region,"Region");
		Thread.sleep(2000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_regionnew.fieldControl-option-set-select']")),Region,"Region"); 
		return this;
	}
			
//Select Top PArent Classification
	public MemberFormPage selectTopParentClassification(String topParentClassification) throws InterruptedException {
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_topparentclassification.fieldControl-option-set-select']")))),topParentClassification,"Top Parent Classification");
		Thread.sleep(2000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_topparentclassification.fieldControl-option-set-container']")),topParentClassification,"Top Parent Classification"); 
		return this;
	}
	
//Select Fee share eligible as yes
	public MemberFormPage changeFeeShareEligibleToYes() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@title='MEMBERSHIP PROVIDER CONFIGURATION']")),"MEMBERSHIP PROVIDER CONFIGURATION"); //To make fee share field visible
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_feeshareeligible.fieldControl-checkbox-select']")),"Yes","Fee Share Eligible"); 
		Thread.sleep(2000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_feeshareeligible.fieldControl-checkbox-container']")),"Yes","Fee Share Eligible"); 
		return this;
	}

//Fee share eligible start date
	public MemberFormPage selectFeeShareEligibleDate(String feeShareEligibleDate) throws InterruptedException {
		Thread.sleep(3000);
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_feeshareeligibledate.fieldControl-date-time-input']")))),feeShareEligibleDate,"Fee Share Eligible Start Date");
		return this;
	}
	
//Select FBO Type
	public MemberFormPage selectFBOGPOType(String FBOType) {
		selectDropDownUsingVisibleText((getDriver().findElement(By.xpath("//*[@data-id='ix_fbotype.fieldControl-option-set-select']"))),FBOType,"FBO GPO Type");
//	verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='ix_fbotype.fieldControl-option-set-select']")),FBOType,"FBO GPO Type"); 
		return this;
	}
	
//Select FBO Effective date
	public MemberFormPage selectFBOEffectiveDate(String FBOEffectiveDate) {
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_fbotypeeffectivedate.fieldControl-date-time-input']")))),FBOEffectiveDate,"FBO Effective Date");
		return this;
	}
	
//Verify top parent is null in header
	public MemberFormPage verifyTopParentIsEmpty() {
		verifyNullValueWithGetText(getDriver().findElement(By.xpath("(//*[@data-id='form-header']/div[2]/div/div/div/div/div)[4]")),"Top Parent in header"); 
		return this;
	}
	
//Verify Direct parent is null in header
	public MemberFormPage verifyDirectParentIsEmpty() {
		verifyNullValueWithGetText(getDriver().findElement(By.xpath("(//*[@data-id='form-header']/div[2]/div/div/div/div/div)[3]")),"Direct Parent in header"); 
		return this;
	}
	
	
//Verify Is Corporate Account is Locked	
	public MemberFormPage verifyIsCorporateAccountLocked() {
		verifyDisplayed(getDriver().findElement(By.xpath("//*[@data-id='ix_iscorporateaccount-locked-icon']")),"Is Corporate Account Lock");
		return this;
	}
	
//Verify Is Food Service Parent is Locked
	public MemberFormPage verifyIsFoodServiceParentLocked() {
		verifyDisplayed(getDriver().findElement(By.xpath("//*[@data-id='ix_isfoodserviceparent-locked-icon']")),"Food Service Parent Lock");
		return this;
	}
	
	
//Verify Is FBO is Locked	
	public MemberFormPage verifyIsFBOLocked() {
		verifyDisplayed(getDriver().findElement(By.xpath("//*[@data-id='ix_isfbo-locked-icon']")), "FBO lock");
		return this;
	}
	
//Verify Sponsor is Locked
	public MemberFormPage verifySponsorLocked() {
		verifyDisplayed(getDriver().findElement(By.xpath("//*[@data-id='ix_sponsor-locked-icon']")),"Sponsor lock");
		return this;
	}
	
//Choose record status as Draft
	public MemberFormPage chooseRecordStatusDraft() throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@data-id='form-sectionHeader-MembershipProviderConfiguration']")),"Record Status");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-select']")))),"Draft", "Record Status");	
		Thread.sleep(3000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-select']")),"Draft","Record Status"); 
		Thread.sleep(3000);
		return this;	
	}
	
//Select sub accounts from Related
	public MemberFormPage selectSubaccount() throws InterruptedException {	
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@title='Related']")),"Related");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[contains(text(),'Sub-Accounts')]")),"Sub Accounts");
		return this;
	}
	
//click new account in sub account
	public MemberFormPage clickNewAccountInSubAccount() throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@data-id='account|NoRelationship|SubGridAssociated|Mscrm.SubGrid.account.AddNewStandard']")),"New");
		return this;
	}
	
//Verify direct parent
	public MemberFormPage verifyDirectParent(String verifyDirectParent) {
		verifyExactText((getDriver().findElement(By.xpath("//*[@data-id='parentaccountid.fieldControl-LookupResultsDropdown_parentaccountid_selected_tag_text']"))),verifyDirectParent,"Direct Parent");
		return this;
	}

//Verify Top Parent
	public MemberFormPage verifyTopParent(String verifyTopParent ) {
		verifyExactText((getDriver().findElement(By.xpath("//*[@data-id='ix_topparent.fieldControl-LookupResultsDropdown_ix_topparent_selected_tag']"))),verifyTopParent,"Top Parent");
		return this;
	}
	
//Type Direct parent Reason
	public MemberFormPage typeDPReason(String DPReason) {
		click(((getDriver().findElement(By.xpath("//*[@data-id='ix_dpexceptionreason.fieldControl-text-box-text']")))),"DP Reason");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_dpexceptionreason.fieldControl-text-box-text']")))),DPReason,"DP Reason");
		return this;
	}
	
//Type Zip code	
	public MemberFormPage typeZipCode(String zipCode) {
		click((getDriver().findElement(By.xpath("//*[@data-id='address1_postalcode.fieldControl-text-box-text']"))),"Zip Code");
		type((getDriver().findElement(By.xpath("//*[@data-id='address1_postalcode.fieldControl-text-box-text']"))),zipCode, "Zip Code");
		return this;
	}

//Type top parent reason
	public MemberFormPage typeTPReason(String TPReason) {
		click(((getDriver().findElement(By.xpath("//*[@data-id='ix_tpexceptionreason.fieldControl-text-box-text']")))),"TP Reason");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_tpexceptionreason.fieldControl-text-box-text']")))),TPReason,"TP Reason");
		return this;
	}	
	
//Choose member entry form
	public MemberFormPage chooseMemberEntryForm() throws InterruptedException {
		click(getDriver().findElement(By.xpath("(//*[@data-id='form-selector'])[1]")),"Form Selector");
		click(getDriver().findElement(By.xpath("//*[@title='Member Entry Form']")),"Member Entry Form");
		click(getDriver().findElement(By.xpath("//*[@data-id='cancelButton']")),"Discard Changes");
		Thread.sleep(2000);
		return new MemberFormPage();
	}
	
//Verify default account status in header
	public MemberFormPage defaultAccountStatusHeader() {
		try {
			Thread.sleep(3000);
			verifyExactText((getDriver().findElement(By.xpath("(//*[@data-id='form-header']/div[2]/div/div/div/div/div)[2]"))),"Active","Account Status in Header");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

//Add primary contact
	public MemberFormPage addMemberPrimaryContact(String addMemberPrimaryContact) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='primarycontactid.fieldControl-LookupResultsDropdown_primarycontactid_textInputBox_with_filter_new']")),"Primary Contact");
		type(getDriver().findElement(By.xpath("//*[@data-id='primarycontactid.fieldControl-LookupResultsDropdown_primarycontactid_textInputBox_with_filter_new']")),addMemberPrimaryContact,"Primary Contact");
		Thread.sleep(4000);
		click(getDriver().findElement(By.xpath("//span[contains(@id,'primarycontactid.fieldControl-firstname0_0_0')]")),"Primary Contact search");
		return this;
		}

//Update primary contact
	public MemberFormPage updateMemberPrimaryContact(String updateMemberPrimaryContact) throws InterruptedException {
		Actions action = new Actions(getDriver());
		action.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='ix_businessclassification.fieldControl-LookupResultsDropdown_ix_businessclassification_selected_tag_text']"))).perform();
		click(getDriver().findElement(By.xpath("//span[contains(@id,'primarycontactid.fieldControl-LookupResultsDropdown_primarycontactid_1_microsoftIcon_cancelButton')]")),"Clear Icon"); 
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@data-id='primarycontactid.fieldControl-LookupResultsDropdown_primarycontactid_textInputBox_with_filter_new']")),"Primary Contact");
		type(getDriver().findElement(By.xpath("//*[@data-id='primarycontactid.fieldControl-LookupResultsDropdown_primarycontactid_textInputBox_with_filter_new']")),updateMemberPrimaryContact,"Primary Contact");
		Thread.sleep(4000);
		click(getDriver().findElement(By.xpath("//span[contains(@id,'primarycontactid.fieldControl-firstname0_0_0')]")),"Primary Contact search");
		return this;	
		}

	
//Verify Primary contact name
	public MemberFormPage verifyPrimaryContactValue(String verifyPrimaryContactValue) throws InterruptedException {
		verifyExactText((getDriver().findElement(By.xpath("//*[@data-id='primarycontactid.fieldControl-LookupResultsDropdown_primarycontactid_textInputBox_with_filter_new']"))), verifyPrimaryContactValue,"Primary Contact");
		return this;
	}


//Verify default membership provider
	public MemberFormPage verifyDefaultMembershipProvider() {
		click(getDriver().findElement(By.xpath("//*[@data-id='form-sectionHeader-MembershipProviderConfiguration']")),"Membership Provider");
		verifyExactTextWithTitleAttribute((getDriver().findElement(By.xpath("//*[@data-id='ix_membershipprovider.fieldControl-checkbox-container']"))),"No","Membership Provider");
		return this;
	}
	
// Verify if membership provider is yes
	public MemberFormPage verifyMembershipProviderYes() {
		verifyExactTextWithTitleAttribute((getDriver().findElement(By.xpath("//*[@data-id='ix_membershipprovider.fieldControl-checkbox-container']"))),"Yes","Membership Provider");
		return this;
	}
	
//Verify membership provider type options
	public MemberFormPage verifyMembershipProviderTypeOptions(String MembershipProviderType) {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_membershipprovidertype.fieldControl-option-set-select']")),"Membership Provider Type");
		 String[] MPList =MembershipProviderType.split(",");
		 int size=MPList.length;
		 for (int i = 0; i < size; i++)
		 {	 
			verifyPartialText((getDriver().findElement(By.xpath("//*[@data-id='ix_membershipprovidertype.fieldControl-option-set-select']"))),MPList[i],"Membership Provider Type");
		 }
		return this;
	}

//Select membership provider type
	public MemberFormPage selectMembershipProviderType(String membershipProviderType) throws InterruptedException {
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_membershipprovidertype.fieldControl-option-set-select']")),membershipProviderType,"Membership Provider Type");
		Thread.sleep(2000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_membershipprovidertype.fieldControl-option-set-select']")),membershipProviderType,"Membership Provider Type");
		return this;
	}
	
//Select account in home page
	public AccountsPage selectAccountss() throws InterruptedException {	
		click(getDriver().findElement(By.xpath("//span[text()='Accounts']")),"Accounts");
		Thread.sleep(2000);
		return new AccountsPage();
	}
	
//Type Membership provider name in account name field
	public MemberFormPage typeMPAccountName(String accountName) throws InterruptedException {
		Thread.sleep(3000);
		Random rand = new Random();
	    int upperbound = 999;
	    int int_random = rand.nextInt(upperbound);
		click(getDriver().findElement(By.xpath("//*[@data-id='name.fieldControl-text-box-container']")),"Account name");
		type(((getDriver().findElement(By.xpath("//*[@data-id='name.fieldControl-text-box-text']")))),accountName+int_random,"Account name");
		return this;
	}
	
//Type Membership provider name in account name field
	public MemberFormPage typeMPAccountNameWithoutRandomName(String accountName) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='name.fieldControl-text-box-container']")),"Account name");
		type(((getDriver().findElement(By.xpath("//*[@data-id='name.fieldControl-text-box-text']")))),accountName,"Account name");
		return this;
	}
	
//Change Account Status
	public MemberFormPage selectAccountStatus(String acountStatus) throws InterruptedException {
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_accountstatus.fieldControl-option-set-select']")))),acountStatus,"Account Status");
		verifyExactTextWithTitleAttribute((getDriver().findElement(By.xpath("//*[@data-id='ix_accountstatus.fieldControl-option-set-select']"))),acountStatus,"Account Status");
		return this;
	}
	
//Verify no records found error message in add membership provider
	public MemberFormPage verifyNoRecordsFoundMsgInAddMP() throws InterruptedException {
		Thread.sleep(3000);
		verifyPartialAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_membershipprovider.fieldControl-LookupResultsDropdown_ix_membershipprovider_Error_Text']")),"title","No records found.","Membership Provider Lookup"); 
		return this;
	}
	
	public MemberFormPage verifySupplierFormIsDisplayed() {
		verifyExactText((getDriver().findElement(By.xpath("//*[@data-id='form-selector']"))),"Account : Supplier Form","Form");
		return this;
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~Member Entry Form~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage selectAccountTypeMEF(String accountType) throws InterruptedException{
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='customertypecode.fieldControl-option-set-select']")))),accountType,"Account type");
		Thread.sleep(2000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='customertypecode.fieldControl-option-set-select']")),accountType,"Account type"); 
		return this;
	}
	
	
	public MemberFormPage selectTopParentRelationMEF(String topParentRelation) throws InterruptedException {
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_topparentrelationship.fieldControl-option-set-select']")))),topParentRelation,"Top Parent Relation");
		Thread.sleep(1000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_topparentrelationship.fieldControl-option-set-select']")),topParentRelation,"Top Parent Relation"); 
		return this;
	}
	
	public MemberFormPage clickMembershipSaveAndCloseMEF() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='quickCreateSaveAndCloseBtn']")),"Save and Close");
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//*[@title='ADDITIONAL CRITERIA']")),"ADDITIONAL CRITERIA");
		Thread.sleep(5000);
		return this;	
	}	
	
	public MemberFormPage verifyIsFBOMEF(String verifyIsFBO) throws InterruptedException { 
		click(getDriver().findElement(By.xpath("//*[@title='MISCELLANEOUS']")),"MISCELLANEOUS");
		Thread.sleep(5000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_isfbo.fieldControl-checkbox-container']")),verifyIsFBO, "Is FBO"); 
		return this;
	}
	
	//Select record status published
	public MemberFormPage chooseRecordStatusPublishedMEF() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@title='ADDITIONAL CRITERIA']")),"ADDITIONAL CRITERIA");
		Thread.sleep(3000);
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-select']")))),"Published", "Record Status");	
		Thread.sleep(3000);
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-select']")),"Published","Record Status"); 
		return this;
	}
	
	public MemberFormPage verifyIsCorporateAccountMEF(String verifyIsCorporateAccount) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_iscorporateaccount.fieldControl-checkbox-container']")),verifyIsCorporateAccount,"Is Corporate Account"); 
		return this;
	}
	
	
	public MemberFormPage verifyAffiliateGroupIsNotNullMEF() {
		getTextValue(getDriver().findElement(By.xpath("//*[@data-id='ix_affiliategroup.fieldControl-LookupResultsDropdown_ix_affiliategroup_selected_tag_text']")),"Affiliate Group");
		return this;
	}
	
	//Choose application start date
	public MemberFormPage chooseApplicationDateMEF(String applicationDate) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@title='ADDITIONAL CRITERIA']")),"ADDITIONAL CRITERIA");
		Thread.sleep(5000);
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_applicationstartdate.fieldControl-date-time-input']")))),applicationDate, "Application Start Date");
		return this;
	}
	
	//Click on LOB SAve and close
		public MemberFormPage clickLOBSaveAndCloseMEF() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_portfoliocategory|NoRelationship|Form|Mscrm.Form.ix_portfoliocategory.SaveAndClose']")),"Save and Close");
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//*[@title='GENERAL DEMOGRAPHIC']")),"GENERAL DEMOGRAPHIC");
		Thread.sleep(5000);
		return this;	
		}	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//Verify Account Status
	public MemberFormPage verifyAccountStatus(String verifyAcountStatus) {
		Assert.assertTrue((getTextValue(getDriver().findElement(By.xpath("(//*[@data-id='form-header']/div[2]/div/div/div/div/div)[2]")),"Account Status")).equals(verifyAcountStatus));
		return this;
	}
	
//Verify premier start date
	public MemberFormPage verifyPremierStartDate(String premierStartDate) {
		Assert.assertTrue(getTextValueAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_premiermemberstartdate.fieldControl-date-time-input']")),"Premier Start Date").equals(premierStartDate));
		return this;
	}

//Verify premier start date is null
	public MemberFormPage verifyPremierStartDateIsNull() {
		verifyNullValue(getDriver().findElement(By.xpath("//*[@data-id='ix_premiermemberstartdate.fieldControl-date-time-input']")),"Premier Start Date");
		return this;
	}
	
//Select membership end date
 	public MemberFormPage selectMembershipEndReason(String EndReason) {
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@data-id='ix_endreason.fieldControl-option-set-select']")))),EndReason,"End Reason");
		return this;
	}
 	
 //Tupe membership end date
	public MemberFormPage typeMembershipEndDate(String EndDate) {
		//click(getDriver().findElement(By.xpath("//*[@data-id='ix_applicationstartdate.fieldControl-date-time-input']")),"End Date");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_enddate.fieldControl-date-time-input']")))),EndDate,"End Date");
		return this;
	}
	
	public MemberFormPage verifyPremierEndDateIsNull() {
		verifyNullValue(getDriver().findElement(By.xpath("//*[@data-id='ix_premiermemberenddate.fieldControl-date-time-input']")),"Premier End Date"); 
		return this;
	}

//Verify premier end date
	public MemberFormPage verifyPremierEndDate(String verifyPremierEndDate) {
		Assert.assertTrue((getTextValueAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_premiermemberenddate.fieldControl-date-time-input']")),"Premier End Date")).equals(verifyPremierEndDate));
		return this;
	}

//Verify direct parent relation  date is updated correctly
	public MemberFormPage verifyDirectParentRelationDate(String verifyDirectParentRelationDate) {
		verifyExactValue(((getDriver().findElement(By.xpath("//*[@data-id='ix_directparentrelationdate.fieldControl-date-time-input']")))),verifyDirectParentRelationDate, "Direct Parent Relation Date");
		return this;
	}

//Verify top parent relation  date is updated correctly
	public MemberFormPage verifyTopParentRelationDate(String verifyTopParentRelationDate) {
		click(getDriver().findElement(By.xpath("//*[@data-id='form-sectionHeader-SUMMARY_TAB_section_9']")),"FBO");
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='ix_topparentrelationdate.fieldControl-date-time-input']")),verifyTopParentRelationDate,"Top Parent Relation Date");
		return this;
	}


//verify affiliate group
	public MemberFormPage verifyAffiliateGroup(String verifyAffiliateGroup) {
		click(getDriver().findElement(By.xpath("//*[@data-id='form-sectionHeader-SUMMARY_TAB_section_9']")),"FBO");
		Assert.assertTrue((getTextValue(getDriver().findElement(By.xpath("//*[@data-id='ix_affiliategroup.fieldControl-LookupResultsDropdown_ix_affiliategroup_selected_tag_text']")),"Affiliate Group")).equals(verifyAffiliateGroup));
		return this;
	}
	
//Verify AG effective date
	public MemberFormPage verifyAgEffectiveDate(String verifyAgEffectiveDate) {
		Assert.assertTrue((getTextValueAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_affiliategroupeffectivedate.fieldControl-date-time-input']")),"Affiliate Group Effective Date")).equals(verifyAgEffectiveDate));
		return this;
	}
	
	public MemberFormPage verifyAgEffectiveDateAsCurrentDate() {
		 DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		 Date date = new Date();
		 String date1= dateFormat.format(date); 
		Assert.assertTrue((getTextValueAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_affiliategroupeffectivedate.fieldControl-date-time-input']")),"Affiliate Group Effective Date")).equals(date1));
		return this;
	}

//Account name 2
	public MemberFormPage typeAccountName2(String AccountName2) {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_hiscirostername.fieldControl-text-box-text']")),"Account name");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_hiscirostername.fieldControl-text-box-text']")))),AccountName2,"Account name2");
		return this;
	}
	
//Verify Group field is populated
	public MemberFormPage verifyGroup(String verifyGroup) {
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='ix_group.fieldControl-LookupResultsDropdown_ix_group_selected_tag_text']")),verifyGroup,"Group"); 
		return this;
	}
	
//Verify Facility type
	public MemberFormPage verifyFacilityType(String verifyFacilityType) throws InterruptedException {
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='ix_facilitytype.fieldControl-LookupResultsDropdown_ix_facilitytype_selected_tag_text']")),verifyFacilityType,"Facility Type"); 
		return this;
	}
	
	public MemberFormPage verifyPremierOwner(String verifyPremierOwner) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_premierowner.fieldControl-checkbox-container']")),verifyPremierOwner,"Premier Owner"); 
		return this;
	}
	
//Verify CAMS flag
	public MemberFormPage verifyCAMSFlag(String verifyCAMSFlag) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_camsflag.fieldControl-checkbox-container']")),verifyCAMSFlag,"CAMS Flag"); 
		return this;
	}
	
//Verify exclude from roaster
	public MemberFormPage verifyExcludeFromRoaster(String ExcludeFromRoaster) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_donotroster.fieldControl-checkbox-container']")),ExcludeFromRoaster,"Exclude From Roaster"); 
		return this;
	}
	
//Verify BK active
	public MemberFormPage verifyBKActive(String verifyBKActive) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_bkactive.fieldControl-checkbox-container']")),verifyBKActive,"BKActive"); 
		return this;
	}
	
//select BK Active  as yes
	public MemberFormPage selectBKActiveYes() throws InterruptedException {
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//*[@title='Sponsor']")),"Sponsor"); //This is for scroll down the page to make the BK active field visible
		Thread.sleep(2000);
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_bkactive.fieldControl-checkbox-select']")),"Yes","BK Active");
		return this; 
	}
	
//select BK Active  as No
	public MemberFormPage selectBKActiveNo() throws InterruptedException {
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//*[@title='Sponsor']")),"Sponsor"); //This is for scroll down the page to make the BK active field visible
		Thread.sleep(2000);
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_bkactive.fieldControl-checkbox-select']")),"No","BK Active");		
		return this; 
	}
	
//input supplier record
	public MemberFormPage typeSupplierRecord(String supplierRecord) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_supplierrecordid.fieldControl-LookupResultsDropdown_ix_supplierrecordid_textInputBox_with_filter_new']")),"Supplier Record");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_supplierrecordid.fieldControl-LookupResultsDropdown_ix_supplierrecordid_textInputBox_with_filter_new']")))),supplierRecord,"Supplier Record");
Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[contains(@id,'ix_supplierrecordid.fieldControl-ix_istopparent')]")),"Business Classification");

		return this;
	}
	
//Type stock symbol
	public MemberFormPage typeStockSymbol(String stockSymbol) {
	click(getDriver().findElement(By.xpath("//*[@data-id='ix_stocksymbol.fieldControl-text-box-text']")),"Stock Symbol");
	type(((getDriver().findElement(By.xpath("//*[@data-id='ix_stocksymbol.fieldControl-text-box-text']")))),stockSymbol, "Stock Symbol");
	return this;
	}	


//Select ownership
	public MemberFormPage selectOwnership(String ownership){
			selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_ownership.fieldControl-option-set-select']")),ownership,"Ownership");
			verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_ownership.fieldControl-option-set-container']")),ownership,"Ownership"); 
		return this;
	}
	
//Type Exchange
	public MemberFormPage typeExchange(String exchange) {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_exchange.fieldControl-text-box-text']")),"Exchange");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_exchange.fieldControl-text-box-text']")))),exchange, "Exchange");
		return this;
	}

//Is payment entity
	public MemberFormPage verifyIsPaymentEntity(String isPaymentEntity) {
		//selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_ispaymententity.fieldControl-checkbox-select")),isPaymentEntity,"Is Payment Entity"); 
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_ispaymententity.fieldControl-checkbox-container']")),isPaymentEntity,"Is Payment Entity"); 
		return this;
	}
	
//Add Payment entity
	public MemberFormPage addPaymentEntity(String addPaymentEntity) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_paymententityid.fieldControl-LookupResultsDropdown_ix_paymententityid_textInputBox_with_filter_new']")),"Payment Entity");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_paymententityid.fieldControl-LookupResultsDropdown_ix_paymententityid_textInputBox_with_filter_new']")))),addPaymentEntity,"Payment Entity");
		try {
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//*[@data-id='ix_paymententityid.fieldControl-LookupResultsDropdown_ix_paymententityid_textInputBox_with_filter_new']")).sendKeys(Keys.TAB, Keys.TAB,Keys.TAB);
			WebElement activeElement=getDriver().switchTo().activeElement();
			activeElement.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;	
		}
	
//Select corporate rebate
	public MemberFormPage selectCorporateRebate(String corporateRebate) {
		//click(getDriver().findElement(By.id("ix_corporaterebatefeedate_cl")),"Corporate Rebate");
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_corporaterebate.fieldControl-option-set-select']")),corporateRebate,"Corporate Rebate");
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_corporaterebate.fieldControl-option-set-select']")),corporateRebate,"Corporate Rebate"); 
		return this;
	}

//Select corporate Rebate Fee date
	public MemberFormPage selectCorporateRebateFeeDate(String corporateRebateFeeDate) {
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_corporaterebatefeedate.fieldControl-date-time-input']")))),corporateRebateFeeDate,"Corporate Rebate Fee Date");
		return this;
	}
	
//Type street 2
	public MemberFormPage typeStreet2(String street2) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_line2.fieldControl-text-box-text']")),"Street2");
		type(((getDriver().findElement(By.xpath("//*[@data-id='address1_line2.fieldControl-text-box-text']")))),street2, "Street2");
		return this;
	}
	
//Type delivery information
	public MemberFormPage typeDeliveryInfo(String deliveryInfo) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_line3.fieldControl-text-box-text']")),"Delivery Info");
		type(getDriver().findElement(By.xpath("//*[@data-id='address1_line3.fieldControl-text-box-text']")),deliveryInfo, "Delivery Info");
		return this;
	}
	
//State
	public MemberFormPage typeState(String state) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_stateorprovince.fieldControl-text-box-text']")),"State");
		type(((getDriver().findElement(By.xpath("//*[@data-id='address1_stateorprovince.fieldControl-text-box-text']")))),state, "State");
		return this;
	}
	
//Type Mail phone
	public MemberFormPage typeMainPhone(String mainPhone) {
		click(getDriver().findElement(By.xpath("//*[@data-id='telephone1.fieldControl-phone-text-input']")),"Main Phone");
		type(((getDriver().findElement(By.xpath("//*[@data-id='telephone1.fieldControl-phone-text-input']")))),mainPhone, "Main Phone");
		return this;
	}
	
//type other phone
	public MemberFormPage typeOtherPhone(String otherPhone) {
		click(getDriver().findElement(By.xpath("//*[@data-id='telephone2.fieldControl-phone-text-input']")),"Other Phone");
		type(((getDriver().findElement(By.xpath("//*[@data-id='telephone2.fieldControl-phone-text-input']")))),otherPhone, "Other Phone");
		return this;
	}
	
//Override name
	public MemberFormPage typeOverrideName(String overrideName) {
		click(getDriver().findElement(By.xpath("//*[@data-id='address1_name.fieldControl-text-box-text']")),"OverrideName");
		type(((getDriver().findElement(By.xpath("//*[@data-id='address1_name.fieldControl-text-box-text']")))),overrideName, "OverrideName");
		return this;
	}
	
//Type fax
	public MemberFormPage typeFax(String fax) {
		click(getDriver().findElement(By.xpath("//*[@data-id='fax.fieldControl-text-box-text']")),"Fax");
		type(((getDriver().findElement(By.xpath("//*[@data-id='fax.fieldControl-text-box-text']")))),fax, "Fax");
		return this;
	}
	
//Type website
	public MemberFormPage typeWebsite(String website) {
		click(getDriver().findElement(By.xpath("//*[@data-id='websiteurl.fieldControl-url-text-input']")),"Website");
		type(((getDriver().findElement(By.xpath("//*[@data-id='websiteurl.fieldControl-url-text-input']")))),website, "Website");
		return this;
	}

//Receive direct mail
	public MemberFormPage verifyReceiveDirectMail(String receiveDirectMail) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_receivedirectmail.fieldControl-checkbox-container']")),receiveDirectMail,"Receive Direct Mail"); 
		return this;
	}

//FSRPT flag
	public MemberFormPage verifyFSRPTFlag(String FSRPTFlag) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_fsrptflag.fieldControl-checkbox-container']")),FSRPTFlag,"FSRPT Flag"); 
		return this;
	}
	
//verify do not verify address
	public MemberFormPage verifyDoNotVerifyAddress(String doNotVerifyAddress) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_donotverifyaddress.fieldControl-checkbox-container']")),doNotVerifyAddress,"Do Not Verify Address"); 
		return this;
	}
	
//Verify external address
	public MemberFormPage verifyExternalAddessID(String externalAddessID) {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_externaladdressid.fieldControl-text-box-text']")),"External Addess ID"); 
		type(getDriver().findElement(By.xpath("//*[@data-id='ix_externaladdressid.fieldControl-text-box-text']")),externalAddessID,"External Addess ID"); 
		return this;
	}

//Verify istop parent
	public MemberFormPage verifyIsTopParent(String IsTopParent) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_istopparent.fieldControl-checkbox-container']")),IsTopParent,"Is Top Parent"); 
		return this;
	}

// Verify corporate parent override
	public MemberFormPage verifyCorpParentOverride(String corpParentOverride) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_corporateparentoverride.fieldControl-checkbox-container']")),corpParentOverride,"Corporate Parent Override"); 
		return this;
	}
	
//Verify FBO Manual Override
	public MemberFormPage VerifyFBOManualOverride(String FBOManualOverride) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_fbomanualoverride.fieldControl-checkbox-container']")),FBOManualOverride,"FBO Manual Override"); 
		return this;
	}
	
//Verify FBO GPO
	public MemberFormPage VerifyFBOGPO(String FBOGPO) {
		verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_fbogpo.fieldControl-checkbox-container']")),FBOGPO,"FBO GPO"); 
		return this;
	}
	
	public MemberFormPage pageRefresh() {
		getDriver().navigate().refresh();
		return this;
	}
	
//Click on related and select account numbers
	public MemberFormPage clickAddNewAccountNumberInAccountNumbers() throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_accountnumber|NoRelationship|SubGridAssociated|Mscrm.SubGrid.ix_accountnumber.AddNewStandard']")),"Add");
		try
		{
			if ( getDriver().findElement(By.xpath("//*[@data-id='confirmButton']")).isDisplayed())
			{
				click(getDriver().findElement(By.xpath("//*[@data-id='confirmButton']")),"Save and continue");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		Thread.sleep(6000);
		return this;
	}
	
//Select Account number type in account numbers window
	public MemberFormPage chooseAccountNumberTypeHIN() {
		try {
			Thread.sleep(2000);
			selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_accountnumbertype.fieldControl-option-set-select']")),"HIN","Account Number Type");
			Thread.sleep(2000);
			verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_accountnumbertype.fieldControl-option-set-select']")),"HIN","Account Numbers Type"); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

//Type Hin account number
	public MemberFormPage typeAccountNumberHIN() {
		int min=111111111;
		int max=999999999;
		//Random randomGenerator = new Random();
		int randomInt = (int)(Math.random() * (max - min + 1) + min);
		System.out.println(randomInt);
		String AccNumHIN=String.valueOf(randomInt);
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_number.fieldControl-text-box-text']")),"Number");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_number.fieldControl-text-box-text']")))),AccNumHIN,"HIN Account Number");
		try {
			DataInputProvider.setCellData(AccNumHIN.toString(), Driver.iTestCaseRowNum, "HIN",Driver.sCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	
	public MemberFormPage clickSaveAndClosInAccountNumbers() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_accountnumber|NoRelationship|Form|Mscrm.Form.ix_accountnumber.SaveAndClose']")),"Save and Close");
		Thread.sleep(5000);
	//	click(getDriver().findElement(By.xpath("//*[@title='GENERAL']")),"GENERAL");
		//Thread.sleep(5000);
		return this;	
	}	
	
//Select Account type as DEA
	public MemberFormPage chooseAccountNumberTypeDEA() {
		try {
			Thread.sleep(2000);
			selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@data-id='ix_accountnumbertype.fieldControl-option-set-select']")),"DEA","Account Number Type");
			Thread.sleep(2000);
			verifyExactTextWithTitleAttribute(getDriver().findElement(By.xpath("//*[@data-id='ix_accountnumbertype.fieldControl-option-set-select']")),"DEA","Account Numbers Type"); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
//Enter DEA account number
	public MemberFormPage typeAccountNumberDEA() {
		int min=1111111;
		int max=9999999;
		String chars = "abcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		char c = chars.charAt(rnd.nextInt(chars.length()));	
		int randomInt = (int)(Math.random() * (max - min + 1) + min);
		int num=0;
		String strSum=Integer.toString(randomInt);
		strSum=c+"f"+strSum;
		for (int i=2;i<strSum.length()-1;i+=2)
		{
			char ch=strSum.charAt(i);
			int n=Integer.parseInt(Character.toString(ch));
			num+=n;
		}
		int num1=0;
		for (int i1=3;i1<strSum.length()-1;i1+=2)
		{
			char ch1=strSum.charAt(i1);
			int n1=Integer.parseInt(Character.toString(ch1));
			num1+=n1;
		}
		int num3=num1*2;
		int num2=num+num3;
		String strDEAChaneck=Integer.toString(num2);
		char ch2=strDEAChaneck.charAt(1);
		String DEA="";
		for (int i2=0;i2<strSum.length()-1;i2++)
		{
			DEA+=strSum.charAt(i2);
		}
		String DEANum=DEA+ch2;
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_number.fieldControl-text-box-text']")),"Number");
		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_number.fieldControl-text-box-text']")))),DEANum,"DEA Account Number");
		 try {
				DataInputProvider.setCellData(DEANum.toString(), Driver.iTestCaseRowNum, "DEANumber",Driver.sCategory);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return this;
	}
//Verify DEA account number
	public MemberFormPage verifyDEA(String DEA) throws InterruptedException {
		verifyExactValue((getDriver().findElement(By.xpath("//*[@data-id='ix_dea.fieldControl-text-box-text']"))),DEA,"DEA");
		return this;
	}

//Verify HIN Account number
	public MemberFormPage verifyHIN(String HIN) {
		verifyExactValue((getDriver().findElement(By.xpath("//*[@data-id='ix_hin.fieldControl-text-box-text']"))),HIN,"HIN");
		return this;
	}
	
//Select related and account numbers
	public MemberFormPage selectAccountNumbers() throws InterruptedException {	
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//*[@title='Related']")),"Related");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("(//*[contains(text(),'Account Numbers')])[2]")),"Account Numbers");
		Thread.sleep(2000);
		return this;
	}
	
//Verify account does not have one active premier membership error
	public MemberFormPage verifyAccountDoesNotHavePMError(String errMsg) throws InterruptedException {
		Thread.sleep(3000);
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='errorDialog_subtitle']")),errMsg,"Business Process Error");
		click(getDriver().findElement(By.xpath("//*[@data-id='errorOkButton']")),"Ok");
		Thread.sleep(2000);
		return this;
	}
	

//Verify Can not have duplicate membership provider error message
	public MemberFormPage verifyAccountCanNotCreateDuplicatePMError(String errMsg) throws InterruptedException {
		Thread.sleep(3000);
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='errorDialog_subtitle']")),errMsg,"Business Process Error");
		click(getDriver().findElement(By.xpath("//*[@data-id='errorOkButton']")),"Ok");
		Thread.sleep(2000);
		return this;
	}
	
//Verify error message while changing BK active //
	public MemberFormPage verifyErrorMsgBKField(String ErrMsg) throws InterruptedException {
		Thread.sleep(3000);
		verifyPartialText(getDriver().findElement(By.xpath("//*[@data-id='errorDialog_subtitle']")),ErrMsg,"Error Message"); 
		return this;
	}
	
//Click ok on error message //Error window properties are same for all kind of errors. 
	public MemberFormPage clickOkInErrorMsgBKField() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='errorOkButton']")),"Ok");
		Thread.sleep(3000);
		return this;
	}
	
//Click on Discard changes
	public MemberFormPage clickOnDiscardChanges() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='cancelButton']")),"Discard Changes");
		Thread.sleep(3000);
		return this;
	}
	
//Verify Premier start date is Locked	
	public MemberFormPage verifyPremierStartDateIsLocked() {
		verifyDisplayed(getDriver().findElement(By.xpath("//*[@data-id='ix_premiermemberstartdate-locked-icon']")),"Premier Start Date Lock");
		return this;
	}
	
//Verify Record Change Satus
	public MemberFormPage verifyRecordChangeStatus(String verifyRecordChangeStatus) throws InterruptedException {
		Thread.sleep(10000);
		verifyExactTextWithTitleAttribute((getDriver().findElement(By.xpath("//*[@data-id='ix_recordchangestatus.fieldControl-option-set-container']"))),verifyRecordChangeStatus,"Record Change Status");
		return this;
	}
	
	
	//Enter account name
		public MemberFormPage verifyAccountNameIsEnabled() throws InterruptedException {
			verifyIsEnabled(getDriver().findElement(By.xpath("//*[@data-id='name.fieldControl-text-box-container']")),"Account name");
			Thread.sleep(2000);
			return this;
		}

	//Account name 2
		public MemberFormPage verifyAccountName2IsEnabled() {
			verifyIsEnabled(getDriver().findElement(By.xpath("//*[@data-id='ix_hiscirostername.fieldControl-text-box-text']")),"Account name");
			return this;
		}

	//Select Class of trade
		public MemberFormPage verifyClassOfTradeIsEnabled() throws InterruptedException, AWTException {
			verifyIsEnabled(getDriver().findElement(By.xpath("//*[@data-id='ix_classoftradedetail.fieldControl-LookupResultsDropdown_ix_classoftradedetail_InputSearch']")),"Class of Trade");
			return this;
		}

	//Type street1
		public MemberFormPage verifyStreet1IsEnabled( ) {
			verifyIsEnabled(((getDriver().findElement(By.xpath("//*[@data-id='address1_line1.fieldControl-text-box-text']")))), "Street1");
			return this;
		}

	//Type street 2
		public MemberFormPage verifyStreet2IsEnabled( ) {
			verifyIsEnabled(getDriver().findElement(By.xpath("//*[@data-id='address1_line2.fieldControl-text-box-text']")),"Street2");
			return this;
		}

	//Type delivery information
		public MemberFormPage verifyDeliveryInfoIsEnabled( ) {
			verifyIsEnabled(getDriver().findElement(By.xpath("//*[@data-id='address1_line3.fieldControl-text-box-text']")),"Delivery Info");
			return this;
		}

	//Type City
		public MemberFormPage verifyCityIsEnabled( ) {
			verifyIsEnabled((getDriver().findElement(By.xpath("//*[@data-id='address1_city.fieldControl-text-box-text']"))),"City");
			return this;
		}

	//State
		public MemberFormPage verifyStateIsEnabled( ) {
			verifyIsEnabled(getDriver().findElement(By.xpath("//*[@data-id='address1_stateorprovince.fieldControl-text-box-text']")),"State");
			return this;
		}

	//Type County
		public MemberFormPage verifyCountyIsEnabled( ) {
			verifyIsEnabled(getDriver().findElement(By.xpath("//*[@data-id='address1_county.fieldControl-text-box-text']")),"County");
			return this;
		}

	//Type country
		public MemberFormPage verifyCountryIsEnabled( ) {
			verifyIsEnabled(getDriver().findElement(By.xpath("//*[@data-id='address1_country.fieldControl-text-box-text']")),"Country");
			return this;
		}

	//Type Zip code	
		public MemberFormPage verifyZipIsEnabled( ) {
			verifyIsEnabled((getDriver().findElement(By.xpath("//*[@data-id='address1_postalcode.fieldControl-text-box-text']"))),"Zip Code");
			return this;
		}

	//Type Mail phone
		public MemberFormPage verifyMainPhoneIsEnabled( ) {
			verifyIsEnabled(getDriver().findElement(By.xpath("//*[@data-id='telephone1.fieldControl-phone-text-input']")),"Main Phone");
			return this;
		}
	
	
	
	
	
	
	
		public MemberFormPage typeAccountNameEdit(String AccountName) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='OverflowButton']")),"Account name");
		type(((getDriver().findElement(By.xpath("//*[@data-id='OverflowButton']")))),AccountName,"Account name");
		return this;
	}

	

	public MemberFormPage clickSaveInAccountNumbers() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("savefooter_statuscontrol")),"Save");
		Thread.sleep(5000);	
		return this;
	}
	
	public MemberFormPage clickSaveAndClose() throws InterruptedException {
		click(getDriver().findElement(By.id("savefooter_statuscontrol")),"Save and Close");
		Thread.sleep(5000);
		return this;
	}
		
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage changeRecordStatus(String ChangeRecordStatus){
		click(getDriver().findElement(By.id("ix_recordchangestatus")),"Change Record Status");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordchangestatus_d")))),ChangeRecordStatus,"Change Record Status");
		verifyExactText(getDriver().findElement(By.id("ix_recordchangestatus")),ChangeRecordStatus,"Change Record Status"); 
		return this;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	


	public MemberFormPage validateXMLFieldValues() {
	try{
		String filePath = "C:\\Users\\blogg\\Desktop\\input.xml";
		File file = new File(filePath);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbf.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		doc.getDocumentElement().normalize();
		System.out.println(doc.getDocumentElement().getNodeName());
		NodeList nodeList = doc.getElementsByTagName("account");
		int tLength = nodeList.getLength();
		
	
	for(int i=0; i<tLength; i++){
			Node node = nodeList.item(i);
			
			if(node.getNodeType()==Node.ELEMENT_NODE){
				Element element = (Element)node;
				System.out.println("Account No: "+element.getAttribute("acn"));
				System.out.println("First Name: "+element.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println("Last Name: "+element.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println("Balance: "+element.getElementsByTagName("balance").item(0).getTextContent());
			}
			
		}
	}catch (Exception e){
		e.printStackTrace();
	}
	return null;
	}
	
	public MemberFormPage chooseRoasterType() throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("ix_donotroster_d")),"Roster Type");
		return this;
	}
	
	
	public MemberFormPage verifyMainAccountEntityCode(String verifyEntityCode) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		Assert.assertFalse(getTextValue(getDriver().findElement(By.id("Entity Code_label")),"Entity Code").equals(verifyEntityCode));
		return this;
	}
	
	public MemberFormPage doubleClickOnTopParentInMembershipWithFrame0() throws InterruptedException {	
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("area_ix_account_ix_membership_AccountNameFrame")));
		Thread.sleep(3000);
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr[5]/td[2]/nobr"))).
	      doubleClick().
	      build().perform();
		Thread.sleep(3000);
		return this;
	}
	
	public MemberFormPage doubleClickOnTopParentInMembershipLocationType() throws InterruptedException {	
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		switchToFrame(getDriver().findElement(By.id("area_ix_account_ix_membership_AccountNameFrame")));
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr/td[3]/nobr"))).
	      doubleClick().
	      build().perform();
		Thread.sleep(3000);
		return this;
	}
	
	public MemberFormPage verifytopParentMembershipEntity(String TopParent) {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		verifyExactText(getDriver().findElement(By.id("FormTitle")),TopParent,"Top Parent");
		return this;
	}
	
	public MemberFormPage verifyDirectParentRelation() { 
		getTextValue(getDriver().findElement(By.id("ix_parentrelationship")),"Direct Parent Relation"); 
		return this;
	}
	
	public MemberFormPage changeRequireManualAG() {
		click(getDriver().findElement(By.id("ix_requiremanualagassignment")),"Require Manual AG"); 
		return this;
	}
	
	public MemberFormPage selectAffiliateGroupEffectiveDate(String AffiliateGroupEffectiveDate) {
		click(getDriver().findElement(By.id("ix_affiliategroupeffectivedate")),"Affiliate Group Effective Date");
		type(getDriver().findElement(By.id("ix_affiliategroupeffectivedate_iDateInput")),AffiliateGroupEffectiveDate,"Affiliate Group Effective Date");
		return this;
	}
	
	public MemberFormPage selectAffiliateGroup(String AffiliateGroup) throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("ix_affiliategroup_ledit")),"Affiliate Group");
		typeAndChoose(getDriver().findElement(By.id("ix_affiliategroup_ledit")),AffiliateGroup,"Affiliate Group");
		return this;
	}
	
	
	
	

}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
