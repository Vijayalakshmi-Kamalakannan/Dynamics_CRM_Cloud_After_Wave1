package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import driver.Driver;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

public class ContactsPage extends WebDriverServiceImpl {

	// Click New on contacts page
	public ContactsPage clickNewOnContactsPage() {
		click(getDriver().findElement(
				By.xpath("//*[@data-id='contact|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.contact.NewRecord']")),
				"New");
		return this;
	}

	// type the contact first name and last name
	public ContactsPage typeContactName(String firstName, String lastName) throws InterruptedException {
		Thread.sleep(3000);
		// Type first name
		click(getDriver().findElement(
				By.xpath("//*[@data-id='fullname_compositionLinkControl_firstname.fieldControl-text-box-text']")),
				"First Name");
		Thread.sleep(2000);
		type(((getDriver().findElement(
				By.xpath("//*[@data-id='fullname_compositionLinkControl_firstname.fieldControl-text-box-text']")))),
				firstName, "First Name");

		// Type second name
		click(getDriver().findElement(
				By.xpath("//*[@data-id='fullname_compositionLinkControl_lastname.fieldControl-text-box-text']")),
				"Last Name");
		Thread.sleep(2000);
		type(((getDriver().findElement(
				By.xpath("//*[@data-id='fullname_compositionLinkControl_lastname.fieldControl-text-box-text']")))),
				lastName, "Last Name");

		return this;
	}

	// select the primary account
	public ContactsPage selectPrimaryAccount(String primaryAccount) {
		
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_textInputBox_with_filter_new']")),
				"Primary Account");
		
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='department.fieldControl-text-box-text']")),
				"Scrolling to Primary Account field");
		
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_textInputBox_with_filter_new']")),
				"Primary Account");

		try {
			type(((getDriver().findElement(By.xpath(
					"//*[@data-id='parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_textInputBox_with_filter_new']")))),
					primaryAccount, "Primary Account");

			getDriver().findElement(By.xpath(
					"//*[@data-id='parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_textInputBox_with_filter_new']"))
					.sendKeys(Keys.TAB, Keys.TAB,Keys.TAB, Keys.TAB);
			Thread.sleep(5000);
			WebElement activeElement = getDriver().switchTo().activeElement();
			activeElement.sendKeys(Keys.ENTER);
			getDriver().findElement(By.xpath(
					"//*[@data-id='parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_textInputBox_with_filter_new']"))
					.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB);
			Thread.sleep(5000);
			activeElement = getDriver().switchTo().activeElement();
			activeElement.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Click Save button in contact summary page
	public ContactsPage clickSave() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='contact|NoRelationship|Form|Mscrm.Form.contact.Save']")),
				"Save");
		Thread.sleep(5000);
		return this;
	}

	// check if Innovatix contact id is created
	public ContactsPage isInnovatixContactIDDisplayed() throws InterruptedException {
		Thread.sleep(3000);
		String innovatixContactID = getAttribute(
				getDriver().findElement(By.xpath("//*[@data-id='ix_innovatixcontactid.fieldControl-text-box-text']")),
				"value", "Innovatix Contact Id");
		try {
			DataInputProvider.setCellData(innovatixContactID.toString(), Driver.iTestCaseRowNumDriver, "CRMNumber",
					Driver.properties.getProperty("DriverSheetName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// choose record status
	public ContactsPage chooseRecordStatus(String recordStatus) throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-select']")),
				"Record Status");
		selectDropDownUsingVisibleText(
				((getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-select']")))),
				recordStatus, "Record Status");
		Thread.sleep(3000);
		verifyExactTextWithTitleAttribute(
				getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-select']")),
				recordStatus, "Record Status");
		return this;

	}

	// verify contact record status
	public ContactsPage verifyRecordStatus(String recordStatus) throws InterruptedException {
		String recordStatusinUI = getAttribute(
				getDriver().findElement(By.xpath("//*[@data-id='ix_recordstatus.fieldControl-option-set-select']")),
				"title", "Record Status");
		if (recordStatusinUI.equalsIgnoreCase(recordStatus)) {

			setReport().log(Status.PASS, "Record Status " + recordStatusinUI + " is displayed right",
					screenshotCapture());

		} else {
			setReport().log(Status.FAIL, "Record Status " + recordStatusinUI + " is not displayed right",
					screenshotCapture());
			Driver.failCount++;
		}
		return this;
	}

	// Click on deactivate button
	public ContactsPage clickOnContactDeactivate() throws InterruptedException {
		click(getDriver().findElement(
				By.xpath("//*[@data-id='contact|NoRelationship|Form|Mscrm.Form.contact.Deactivate']")), "Deactivate");
		Thread.sleep(10000);
		return this;
	}

	// Confirm deactivate button
	public ContactsPage clickConfirmDeactivation() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='ok_id']")), "Confirm");
		Thread.sleep(10000);
		return this;
	}

	// Click save after terminating CAA
	public ContactsPage clickSaveAfterTerminationCAA() throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='ix_contactaccountassociation|NoRelationship|Form|Mscrm.Form.ix_contactaccountassociation.Save']")),
				"Save");
		Thread.sleep(5000);
		return this;
	}

	// type the contact end date in the summary page
	public ContactsPage typeContactEndDate(String contactEndDate) throws InterruptedException {
		Thread.sleep(500);
		// alternate action for scrolling down to contact end date
		click(getDriver().findElement(
				By.xpath("//*[@data-id='fullname_compositionLinkControl_lastname.fieldControl-text-box-text']")),
				"Last Name");
		click(getDriver().findElement(By.xpath("//*[@data-id='jobtitle.fieldControl-text-box-text']")), "Job Title");
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_employeeflag.fieldControl-checkbox-select']")),
				"Employee flag");

		// click contact end date field twice and then type value to it
		click((getDriver().findElement(By.xpath("//*[@data-id='ix_contactenddate.fieldControl-date-time-input']"))),
				"Contact End Date");
		click((getDriver().findElement(By.xpath("//*[@data-id='ix_contactenddate.fieldControl-date-time-input']"))),
				"Contact End Date");

		type(((getDriver().findElement(By.xpath("//*[@data-id='ix_contactenddate.fieldControl-date-time-input']")))),
				contactEndDate, "Contact End Date");
		return this;
	}

	// Click back arrow across all pages
	public ContactsPage clickGoBack() throws InterruptedException {
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//*[@title='Go back']")), "Go Back");
		return this;
	}

	// Click summary tab
	public ContactsPage clickSummaryTab() throws InterruptedException {
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//*[@data-id='tablist-SUMMARY_TAB']")), "Summary tab");
		return this;
	}

	// perform page refresh
	public ContactsPage pageRefresh() throws InterruptedException {
		getDriver().navigate().refresh();
		Thread.sleep(5000);
		return this;
	}

	// to choose an existing Active contact
	public ContactsPage chooseActiveContact(String CrmNumber1) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@data-id='quickFind_text_1']")), "Find Criteria");
		typeAndEnter(getDriver().findElement(By.xpath("//*[@data-id='quickFind_text_1']")), CrmNumber1,
				"Find Criteria");
		Actions a = new Actions(getDriver());
		a.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-0-3']"))).doubleClick().build().perform();
		Thread.sleep(6000);
		return this;
	}

	// update primary account with a new account details
	public ContactsPage addAnotherPrimaryAccount(String PrimaryAccount1) throws InterruptedException, AWTException {
		
		click(getDriver().findElement(By.xpath("//*[@data-id='cell-0-6']")), "Contact Account");
		
		Thread.sleep(7000);
		
	/*	click(getDriver().findElement(By.xpath(
				"//*[@data-id='parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_SelectedRecordList']")),
				"Primary Account");
		
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='department.fieldControl-text-box-text']")),
				"Scrolling to Primary Account field");
		
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_selected_tag_delete']")),
				"Primary Account");
*/
		  Point coordinates = getDriver().findElement(By.xpath(
					"//*[@data-id='parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_selected_tag']")).getLocation();
		  System.out.println("coordinates are : "+coordinates);
		  System.out.println("get x coordinates  : "+coordinates.getX());
		  System.out.println("get y coordinates  : "+coordinates.getY());
		  
		  
		  Actions builder = new Actions(getDriver());

		  builder.keyDown(Keys.CONTROL)
		     .click(getDriver().findElement(By.xpath("//*[@data-id='parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_selected_tag']")))
		     .moveByOffset( coordinates.getX(), coordinates.getY()+120 )
		     .click(getDriver().findElement(By.xpath(
						"//*[@data-id='parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_selected_tag']")))
		     .keyUp(Keys.CONTROL).build().perform();
		     
		//  Robot robot = new Robot();
		 // robot.mouseMove(coordinates.getX(),coordinates.getY()+120);
		 
		//WebDriver.FindElement(By.Xpath("//button[@data-id='{field}.fieldControl-LookupResultsDropdown_{field}_selected_tag_delete']")).Click
		
		try {			
			type(((getDriver().findElement(By.xpath(
					"//*[@data-id='parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_textInputBox_with_filter_new']")))),
					PrimaryAccount1, "Update Primary Account");

			getDriver().findElement(By.xpath(
					"//*[@data-id='parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_textInputBox_with_filter_new']"))
					.sendKeys(Keys.TAB, Keys.TAB);
			Thread.sleep(1000);
			WebElement activeElement = getDriver().switchTo().activeElement();
			activeElement.sendKeys(Keys.ENTER);
	
			getDriver().findElement(By.xpath(
					"//*[@data-id='parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_textInputBox_with_filter_new']"))
					.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB);
			Thread.sleep(1000);
			activeElement = getDriver().switchTo().activeElement();
			activeElement.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Contact Account Association~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// Click Contact Account Association from Related header field
	public ContactsPage clickCAAFromRelated() throws InterruptedException {
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//*[@title='Related']")), "Related");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[contains(text(),'Contact Account Associations')]")),
				"Contact Account Associations");
		Thread.sleep(2000);
		return this;
	}

	// Click Add Contact Account Association
	public ContactsPage clickAddCAA() throws InterruptedException {
		clickCAAFromRelated();
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='ix_contactaccountassociation|NoRelationship|SubGridAssociated|Mscrm.SubGrid.ix_contactaccountassociation.AddNewStandard']")),
				"Add");
		Thread.sleep(5000);
		return this;
	}

	// type Account in CAA
	public ContactsPage typeAccountInCAA(String account) throws InterruptedException {

		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='ix_account.fieldControl-LookupResultsDropdown_ix_account_textInputBox_with_filter_new']")),
				"Account");
		type(getDriver().findElement(By.xpath(
				"//*[@data-id='ix_account.fieldControl-LookupResultsDropdown_ix_account_textInputBox_with_filter_new']")),
				account, "Account");

		try {
			Thread.sleep(4000);
			getDriver().findElement(By.xpath(
					"//*[@data-id='ix_account.fieldControl-LookupResultsDropdown_ix_account_textInputBox_with_filter_new']"))
					.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB);
			Thread.sleep(2000);
			WebElement activeElement = getDriver().switchTo().activeElement();
			activeElement.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	// click save in CAA
	public ContactsPage clickSaveInCAA() throws InterruptedException {
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='ix_contactaccountassociation|NoRelationship|Form|Mscrm.Form.ix_contactaccountassociation.Save']")),
				"Save");
		Thread.sleep(5000);
		return this;
	}

	// choose contact termination reason
	public ContactsPage chooseContactTerminationReason(String contactTerminationReason) throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[@data-id='ix_terminationreason.fieldControl-option-set-select']")),
				"Termination Reason");
		selectDropDownUsingVisibleText(
				((getDriver()
						.findElement(By.xpath("//*[@data-id='ix_terminationreason.fieldControl-option-set-select']")))),
				contactTerminationReason, "Termination Reason");
		Thread.sleep(3000);
		String terminationReason = getAttribute(
				getDriver()
						.findElement(By.xpath("//*[@data-id='ix_terminationreason.fieldControl-option-set-select']")),
				"title", "Termination Reason");
		Thread.sleep(3000);
		return this;
	}

	// provide contact relationship end date
	public ContactsPage typeContactRelationshipEndDate(String contactRelationshipEndDate) {
		type(((getDriver()
				.findElement(By.xpath("//*[@data-id='ix_relationshipenddate.fieldControl-date-time-input']")))),
				contactRelationshipEndDate, "Relationship End Date");
		return this;
	}

	// Selecting Inactive view under CAA views
	public ContactsPage clickInactiveCAAView() throws InterruptedException {
		Thread.sleep(3000);
		if (getDriver().findElement(By.xpath("//span[contains(text(),'Contact Account Association Associated View')]"))
				.isDisplayed()) {
			click(getDriver()
					.findElement(By.xpath("//span[contains(text(),'Contact Account Association Associated View')]")),
					"Contact Account Association Associated View");
			Thread.sleep(2000);
			click(getDriver().findElement(By.xpath("//*[contains(text(),'Inactive Contact Account Associations')]")),
					"Inactive Contact Account Associations");
			Thread.sleep(3000);
		}
		return this;
	}

	// validate the relationship end date has current date under CAA Inactive view
	public ContactsPage verifyCAARelationEndDateInInactiveView() throws InterruptedException, ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String curDate = formatter.format(date);

		Thread.sleep(3000);

		String endDate = getAttribute(getDriver().findElement(By.xpath("//*[@data-id='cell-0-5']")), "title",
				"Relationship End Date in Contact Account Association Inactive View");
		Date diffdate = formatter.parse(endDate);
		String finalDate = formatter.format(diffdate);

		if (finalDate.equalsIgnoreCase(curDate)) {

			setReport().log(Status.PASS, "Relationship End Date in Contact Account Association Inactive View "
					+ finalDate + " is displayed right", screenshotCapture());

		} else {
			setReport().log(Status.FAIL, "Relationship End Date in Contact Account Association Inactive View "
					+ finalDate + " is not displayed right", screenshotCapture());
			Driver.failCount++;
		}
		return this;
	}

	// double clik on CAA record in CAA Inactive view
	public ContactsPage doubleClickOnCAARecordInactiveView() throws InterruptedException {
		Thread.sleep(3000);
		Actions a = new Actions(getDriver());
		a.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-0-5']"))).doubleClick().build().perform();
		Thread.sleep(3000);
		return this;
	}

	// Select Sub grid view under CAA views
	public ContactsPage clickContactSubGridViewInCAA() throws InterruptedException {
		Thread.sleep(3000);
		if (getDriver().findElement(By.xpath("//span[contains(text(),'Contact Account Association Associated View')]"))
				.isDisplayed()) {
			click(getDriver()
					.findElement(By.xpath("//span[contains(text(),'Contact Account Association Associated View')]")),
					"Contact Account Association Associated View");
			Thread.sleep(2000);
			click(getDriver().findElement(By.xpath("//*[contains(text(),'Contact Subgrid View')]")),
					"Contact Subgrid View");
			Thread.sleep(3000);
		}
		return this;
	}

	// verify CAA termination reason in Subgrid view
	public ContactsPage verifyCAATerminationReasonInSubGridView(String terminationReason) {
		String termReason = getAttribute(getDriver().findElement(By.xpath("//*[@data-id='cell-0-6']")), "title",
				"Termination Reason in Contact Account Association Sub Grid View");
		if (termReason.equalsIgnoreCase(terminationReason)) {

			setReport().log(Status.PASS, "Termination Reason in Contact Account Association Sub Grid View " + termReason
					+ " is displayed right", screenshotCapture());

		} else {
			setReport().log(Status.FAIL, "Termination Reason in Contact Account Association Sub Grid View " + termReason
					+ " is not displayed right", screenshotCapture());
			Driver.failCount++;
		}
		return this;
	}

	// validate CAA relation end date under subgrid view
	public ContactsPage verifyCAARelationEndDateInSubGridView(String relatioshipEndDate) {
		String endDate = getAttribute(getDriver().findElement(By.xpath("//*[@data-id='cell-0-5']")), "title",
				"Relationship End Date in Contact Account Association Sub Grid View");
		if (endDate.equalsIgnoreCase(relatioshipEndDate)) {

			setReport().log(Status.PASS, "Relationship End Date in Contact Account Association Sub Grid View " + endDate
					+ " is displayed right", screenshotCapture());

		} else {
			setReport().log(Status.FAIL, "Relationship End Date in Contact Account Association Sub Grid View " + endDate
					+ " is not displayed right", screenshotCapture());
			Driver.failCount++;
		}
		return this;
	}

	// double click on the entry under CAA subgrid view
	public ContactsPage doubleClickOnCAARecordInSubGridView() throws InterruptedException {
		Actions a = new Actions(getDriver());
		a.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-0-4']"))).doubleClick().build().perform();
		Thread.sleep(3000);
		return this;
	}

	// double click on the CAA record
	public ContactsPage doubleClickOnCAARecord() throws InterruptedException {
		clickCAAFromRelated();
		Actions a = new Actions(getDriver());
		a.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-0-3']"))).doubleClick().build().perform();
		Thread.sleep(3000);
		return this;
	}

	// save the detected duplicate record
	public ContactsPage clickSaveDuplicateDetected() {
		try {
			Thread.sleep(5000);
			String duplicateText = getDriver().findElement(By.xpath("//*[@data-id='manageDuplicatesTitle']")).getText();
			if (duplicateText.equalsIgnoreCase("Duplicate records found")) {
				click(getDriver().findElement(By.xpath("//*[@data-id='ignore_save']")), "Ignore and Save");
				Thread.sleep(10000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		return this;
	}

	// Verify if status of CAA is Active/Inactive under Admininstration tab
	public ContactsPage verifyStatusInCAA(String status) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//li[contains(text(),'Administration')]")), "Administration tab");

		String conRecordStatus = getAttribute(
				getDriver().findElement(By.xpath("//*[@data-id='statecode.fieldControl-option-set-select']")), "title",
				"Status under Admin tab ");
		if (conRecordStatus.equalsIgnoreCase(status)) {

			setReport().log(Status.PASS, "Status under Admin tab " + conRecordStatus + " is displayed right",
					screenshotCapture());

		} else {
			setReport().log(Status.FAIL, "Status under Admin tab " + conRecordStatus + " is not displayed right",
					screenshotCapture());
			Driver.failCount++;
		}

		return this;
	}

	// Verify if error msg is displayed for duplicate CAA
	public ContactsPage verifyErrorMsgForDuplicateCAA(String ErrMsg) throws InterruptedException {
		verifyPartialText(getDriver().findElement(By.xpath("//*[@data-id='errorDialog_subtitle']")), ErrMsg,
				"Error Message");
		Thread.sleep(3000);
		return this;
	}

	// Click ok on the duplicate CAA error msg popup
	public ContactsPage clickOkErrorMsgForDuplicateCAA() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@id='cancelButton']")), "Ok");
		Thread.sleep(3000);
		return this;
	}
	
	// double click on the old CAA record
	public ContactsPage doubleClickOnOldCAARecord(String OldCAA) throws InterruptedException {
		clickCAAFromRelated();
		Actions a = new Actions(getDriver());
		String record1 = getDriver().findElement(By.xpath("//*[@data-id='cell-0-4']")).getText();
		//String record2 = getDriver().findElement(By.xpath("//*[@data-id='cell-1-4']")).getText();
		if (record1.equalsIgnoreCase(OldCAA)) {
			a.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-0-3']"))).doubleClick().build()
					.perform();
			Thread.sleep(3000);
		} else {
			a.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-1-3']"))).doubleClick().build()
					.perform();
			Thread.sleep(3000);
		}
		return this;
	}

	// choose contact termination reason
		public ContactsPage verifyNullinCaaTerminationReason(String contactTerminationReason) throws InterruptedException {
			Thread.sleep(3000);
			String terminationReason = getAttribute(
							getDriver()
									.findElement(By.xpath("//*[@data-id='ix_terminationreason.fieldControl-option-set-select']")),
							"title", "Termination Reason");		
					
			if(terminationReason.equalsIgnoreCase(contactTerminationReason))
			{
			
				setReport().log(Status.PASS, "Termination reason under CAA is blank",
						screenshotCapture());

			} else {
				setReport().log(Status.FAIL, "Termination reason under CAA is not blank",
						screenshotCapture());
				Driver.failCount++;
			}
			Thread.sleep(3000);
			
			return this;
		}

		// provide contact relationship end date
		public ContactsPage verifyNullinCaaRelationshipEndDate(String contactRelationshipEndDate) throws InterruptedException {
			Thread.sleep(3000);
			String relEndDate = getAttribute(
							getDriver()
									.findElement(By.xpath("//*[@data-id='ix_relationshipenddate.fieldControl-date-time-input']")),
							"placeholder", "Relationship End Date");		
					
			if(relEndDate.equalsIgnoreCase(contactRelationshipEndDate))
			{
			
				setReport().log(Status.PASS, "Contact Relationship EndDate under CAA is blank",
						screenshotCapture());

			} else {
				setReport().log(Status.FAIL, "Contact Relationship EndDate under CAA is not blank",
						screenshotCapture());
				Driver.failCount++;
			}
			Thread.sleep(3000);
			return this;
		}
		
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Job Function~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	

	// Click Related and Contact Job Function
	public ContactsPage clickContactJobFunctionFromRelated() throws InterruptedException {
		Thread.sleep(10000);
		click(getDriver().findElement(By.xpath("//*[@title='Related']")), "Related");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[contains(text(),'Contact Job Functions')]")),
				"Contact Job Functions");
		return this;
	}

	// Click Related and Contact Job Function and New Contact Job Function
	public ContactsPage clickAddJobFunction() throws InterruptedException {
		clickContactJobFunctionFromRelated();
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='ix_contactjobfunction|NoRelationship|SubGridAssociated|Mscrm.SubGrid.ix_contactjobfunction.AddNewStandard']")),
				"New Contact Job Function");
		return this;
	}

	// Provide value for Job function as provided in the datasheet
	public ContactsPage typeJobFunction(String jobFunction) throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='ix_jobfunctionnew.fieldControl-LookupResultsDropdown_ix_jobfunctionnew_textInputBox_with_filter_new']")),
				"Job Function");
		type(getDriver().findElement(By.xpath(
				"//*[@data-id='ix_jobfunctionnew.fieldControl-LookupResultsDropdown_ix_jobfunctionnew_textInputBox_with_filter_new']")),
				jobFunction, "Job Function");

		try {
			Thread.sleep(4000);
			getDriver().findElement(By.xpath(
					"//*[@data-id='ix_jobfunctionnew.fieldControl-LookupResultsDropdown_ix_jobfunctionnew_textInputBox_with_filter_new']"))
					.sendKeys(Keys.TAB, Keys.TAB);
			Thread.sleep(2000);
			WebElement activeElement = getDriver().switchTo().activeElement();
			activeElement.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	// Click save button in the job function page
	public ContactsPage clickSaveInJobFunction() throws InterruptedException {
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='ix_contactjobfunction|NoRelationship|Form|Mscrm.Form.ix_contactjobfunction.Save']")),
				"Save");
		Thread.sleep(10000);
		return this;
	}

	// Verify if job function is created by validating the created date with the
	// current date
	public ContactsPage verifyJobFunctionIsCreated(String jobFunction) throws InterruptedException, ParseException {

		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//*[@title='Administration']")), "Administration");
		Thread.sleep(2000);

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String curDate = formatter.format(date);

		Thread.sleep(3000);

		String dateInUI = getAttribute(
				getDriver().findElement(By.xpath("//*[@data-id='createdon.fieldControl-date-time-input']")), "value",
				"Created On");
		Date diffdate = formatter.parse(dateInUI);
		String finalDate = formatter.format(diffdate);

		Thread.sleep(3000);
		if (finalDate.equalsIgnoreCase(curDate)) {
			setReport().log(Status.PASS, "An entry is added with current date " + finalDate, screenshotCapture());

		} else {
			setReport().log(Status.FAIL, "No entry is added with current date " + finalDate, screenshotCapture());
			Driver.failCount++;

		}
		clickGoBack();
		clickGoBack();
		return this;
	}

	// double click the created Job function entry from view
	public ContactsPage doubleClickOnJobFunction() throws InterruptedException {
		Actions a = new Actions(getDriver());
		a.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-0-3']"))).doubleClick().build().perform();
		Thread.sleep(3000);
		return this;
	}

	// verify if user is able to create duplicate job function
	public ContactsPage verifyDuplicateJobFunctionIsCreated(String jobFunction) throws InterruptedException {
		clickGoBack();

		String jobFunc1 = getAttribute(getDriver().findElement(By.xpath("//*[@data-id='cell-0-2']/a")), "title",
				"Job Function");

		String jobFunc2 = getAttribute(getDriver().findElement(By.xpath("//*[@data-id='cell-1-2']/a")), "title",
				"Job Function");

		if (jobFunc1.equalsIgnoreCase(jobFunc2) && jobFunc1.equalsIgnoreCase(jobFunction)) {

			setReport().log(Status.PASS, "Duplicate job function created " + jobFunction, screenshotCapture());
			System.out.println("Duplicate job function created " + jobFunction);

		} else {
			setReport().log(Status.FAIL, "Duplicate job function is not created " + jobFunction, screenshotCapture());
			Driver.failCount++;
			System.out.println("Duplicate job function is not created " + jobFunction);
		}

		return this;
	}

	// Verify if job function is in terminated status
	public ContactsPage verifyJobFunctionTerminationReason(String terminationReason) {
		String jobFunction = getAttribute(
				getDriver()
						.findElement(By.xpath("//*[@data-id='ix_terminationreason.fieldControl-option-set-select']")),
				"title", "Termination Reason");
		if (jobFunction.equalsIgnoreCase(terminationReason)) {
			setReport().log(Status.PASS,
					"Termination reason for the job Function " + jobFunction + " is displayed right",
					screenshotCapture());

		} else {
			setReport().log(Status.FAIL,
					"Termination reason for the job Function " + jobFunction + " is not displayed right",
					screenshotCapture());
			Driver.failCount++;
		}
		return this;
	}

	// verify if correct error msg is displayed when providing balnk value for the
	// job function
	public ContactsPage verifyErrorInJobFunction(String errorInJobFunction) {
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='ix_jobfunctionnew-error-message']")),
				errorInJobFunction, "Error in Job Function");
		return this;
	}

	// Click CAA record from job function page
	public ContactsPage clickCAArecordFromJobFunction() throws InterruptedException {
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='ix_contactaccountassociationid.fieldControl-LookupResultsDropdown_ix_contactaccountassociationid_selected_tag_text']")),
				"CAA record");
		Thread.sleep(6000);
		return this;
	}

	// Selecting Inactive view under Job function
	public ContactsPage clickInactiveJobFunctionView() throws InterruptedException {
		Thread.sleep(3000);
		if (getDriver().findElement(By.xpath("//span[contains(text(),'Contact Job Function Associated View')]"))
				.isDisplayed()) {
			click(getDriver().findElement(By.xpath("//span[contains(text(),'Contact Job Function Associated View')]")),
					"Contact Job Function Associated View");
			Thread.sleep(2000);
			click(getDriver().findElement(By.xpath("//*[contains(text(),'Inactive Contact Job Functions')]")),
					"Inactive Contact Job Functions");
			Thread.sleep(3000);
		}
		return this;
	}

	// verify Job function termination reason in Inactive view
	public ContactsPage verifyJobFunctTerminationReasonInInactiveView(String terminationReason) {
		String termReason = getAttribute(getDriver().findElement(By.xpath("//*[@data-id='cell-0-5']")), "title",
				"Termination Reason in Inactive Contact Job Function View");
		if (termReason.equalsIgnoreCase(terminationReason)) {

			setReport().log(Status.PASS,
					"Termination Reason in Inactive Contact Job Function View " + termReason + " is displayed right",
					screenshotCapture());

		} else {
			setReport().log(Status.FAIL, "Termination Reason in Inactive Contact Job Function View " + termReason
					+ " is not displayed right", screenshotCapture());
			Driver.failCount++;
		}
		return this;
	}

	// verify Job function status in Inactive view
	public ContactsPage verifyJobFunctStatusInInactiveView(String jobStatus) {
		String status = getAttribute(getDriver().findElement(By.xpath("//*[@data-id='cell-0-4']")), "title",
				"Status in Inactive Contact Job Function View");
		if (status.equalsIgnoreCase(jobStatus)) {

			setReport().log(Status.PASS,
					"Status in Inactive Contact Job Function View " + status + " is displayed right",
					screenshotCapture());

		} else {
			setReport().log(Status.FAIL,
					"Status in Inactive Contact Job Function View " + status + " is not displayed right",
					screenshotCapture());
			Driver.failCount++;
		}
		return this;
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Communication/Publication~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	

	// Click Related and Contact Communication
	public ContactsPage clickContactCommunicationFromRelated() throws InterruptedException {
		Thread.sleep(10000);
		click(getDriver().findElement(By.xpath("//*[@title='Related']")), "Related");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//*[contains(text(),'Contact Communications')]")),
				"Contact Communications");
		return this;
	}

	// Click Related and Contact Communication and New Contact Communication
	public ContactsPage clickAddContactCommunication() throws InterruptedException {
		clickContactCommunicationFromRelated();
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='ix_contactcommunication|NoRelationship|SubGridAssociated|Mscrm.SubGrid.ix_contactcommunication.AddNewStandard']")),
				"New Contact Communications");
		return this;
	}

	// Provide value for Contact Communication as provided in the datasheet
	public ContactsPage typeContactCommunication(String contactCommunication) throws InterruptedException {
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='ix_communicationpublication.fieldControl-LookupResultsDropdown_ix_communicationpublication_textInputBox_with_filter_new']")),
				"Contact Communication Publication");
		type(getDriver().findElement(By.xpath(
				"//*[@data-id='ix_communicationpublication.fieldControl-LookupResultsDropdown_ix_communicationpublication_textInputBox_with_filter_new']")),
				contactCommunication, "Contact Communication Publication");

		try {
			Thread.sleep(4000);
			getDriver().findElement(By.xpath(
					"//*[@data-id='ix_communicationpublication.fieldControl-LookupResultsDropdown_ix_communicationpublication_textInputBox_with_filter_new']"))
					.sendKeys(Keys.TAB, Keys.TAB);
			Thread.sleep(2000);
			WebElement activeElement = getDriver().switchTo().activeElement();
			activeElement.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// Click save button in the Contact Communication page
	public ContactsPage clickSaveInContactCommunication() throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath(
				"//*[@data-id='ix_contactcommunication|NoRelationship|Form|Mscrm.Form.ix_contactcommunication.Save']")),
				"Save");
		Thread.sleep(5000);
		return this;
	}

	// Verify if Contact Communication is created by validating the created date
	// with the current date
	public ContactsPage verifyContactCommunicationIsCreated() throws InterruptedException, ParseException {

		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//*[@title='ADMINISTRATION']")), "ADMINISTRATION");
		Thread.sleep(2000);

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String curDate = formatter.format(date);
		Thread.sleep(3000);

		String dateInUI = getAttribute(
				getDriver().findElement(By.xpath("//*[@data-id='createdon.fieldControl-date-time-input']")), "value",
				"Created On");
		Date diffdate = formatter.parse(dateInUI);
		String finalDate = formatter.format(diffdate);

		Thread.sleep(3000);

		if (finalDate.equalsIgnoreCase(curDate)) {
			setReport().log(Status.PASS, "An entry is added with current date " + finalDate, screenshotCapture());
		} else {
			setReport().log(Status.FAIL, "No entry is added with current date " + finalDate, screenshotCapture());
			Driver.failCount++;
		}
		Thread.sleep(2000);
		clickGoBack();
		clickGoBack();
		return this;
	}

	// double click the created Contact Communication entry from view
	public ContactsPage doubleClickOnContactCommunication() throws InterruptedException {
		Actions a = new Actions(getDriver());
		a.moveToElement(getDriver().findElement(By.xpath("//*[@data-id='cell-0-4']"))).doubleClick().build().perform();
		Thread.sleep(3000);
		return this;
	}

	// verify if user is able to create duplicate Contact Communication
	public ContactsPage verifyDuplicateContactCommunicationIsCreated(String communicationPublication)
			throws InterruptedException {
		clickGoBack();
		String commPubli1 = getAttribute(getDriver().findElement(By.xpath("//*[@data-id='cell-0-3']/a")), "title",
				"Communication Publication");

		String commPubli2 = getAttribute(getDriver().findElement(By.xpath("//*[@data-id='cell-1-3']/a")), "title",
				"Communication Publication");

		if (commPubli1.equalsIgnoreCase(commPubli2) && commPubli1.equalsIgnoreCase(communicationPublication)) {

			setReport().log(Status.PASS, "Duplicate communication Publication created " + communicationPublication,
					screenshotCapture());

		} else {
			setReport().log(Status.FAIL,
					"Duplicate communication Publication is not created " + communicationPublication,
					screenshotCapture());
			Driver.failCount++;
		}
		return this;
	}

	// Verify if Contact Communication is in terminated status
	public ContactsPage verifyContactCommunicationTerminationReason(String terminationReason) {
		String contactComm = getAttribute(
				getDriver()
						.findElement(By.xpath("//*[@data-id='ix_terminationreason.fieldControl-option-set-select']")),
				"title", "Termination Reason");
		if (contactComm.equalsIgnoreCase(terminationReason)) {

			setReport().log(Status.PASS,
					"Termination reason for the Contact Communication " + contactComm + " is displayed right",
					screenshotCapture());

		} else {
			setReport().log(Status.FAIL,
					"Termination reason for the Contact Communication " + contactComm + " is not displayed right",
					screenshotCapture());
			Driver.failCount++;
		}
		return this;
	}

	// verify if correct error msg is displayed when providing blank value for the
	// Contact Communication
	public ContactsPage verifyErrorInContactCommunication(String errorInContactCommunication) {
		verifyExactText(getDriver().findElement(By.xpath("//*[@data-id='ix_communicationpublication-error-message']")),
				errorInContactCommunication, "Error in Communication Publication");
		return this;
	}

	// Selecting Inactive view under Contact Communication
	public ContactsPage clickInactiveContactCommunicationView() throws InterruptedException {
		Thread.sleep(3000);
		if (getDriver().findElement(By.xpath("//span[contains(text(),'Contact Communication Associated View')]"))
				.isDisplayed()) {
			click(getDriver().findElement(By.xpath("//span[contains(text(),'Contact Communication Associated View')]")),
					"Contact Communication Associated View");
			Thread.sleep(2000);
			click(getDriver().findElement(By.xpath("//*[contains(text(),'Inactive Contact Communications')]")),
					"Inactive Contact Communications");
			Thread.sleep(3000);
		}
		return this;
	}

	// verify Contact Communication status in Inactive view
	public ContactsPage verifyContactCommunicationStatusInInactiveView(String contactCommStatus) {
		String status = getAttribute(getDriver().findElement(By.xpath("//*[@data-id='cell-0-4']")), "title",
				"Status in Inactive Contact Communication View");
		if (status.equalsIgnoreCase(contactCommStatus)) {

			setReport().log(Status.PASS,
					"Status in Inactive Contact Contact Communication View " + status + " is displayed right",
					screenshotCapture());

		} else {
			setReport().log(Status.FAIL,
					"Status in Inactive Contact Communication View " + status + " is not displayed right",
					screenshotCapture());
			Driver.failCount++;
		}
		return this;
	}

	//clikc signout
	public ContactsPage clickSignout() {
		click(getDriver().findElement(By.id("mectrl_headerPicture")), "Signout Icon");
		click(getDriver().findElement(By.id("mectrl_body_signOut")), "Signout button");
		return this;
	}
		
}
