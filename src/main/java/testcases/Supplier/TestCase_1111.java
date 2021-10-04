
	package testcases.Supplier;
	import org.testng.annotations.Test;
	import pages.LoginPage;
	import utils.DataInputProvider;

	public class TestCase_1111 {
		
//Create supplier with all available fields		
		@Test()

		public void addSupplierPrimaryContact(int iRowNumber, String sDataSheetName) throws Exception {
			
			new LoginPage()
			.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
			.clickNext()
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
	  	    .clicSignin()
	  	    .clicYesInStaySignedin()
	  	   
	  	    //Select Accounts Entity
			.selectAccountsTab()
			
			//Click on +New ( goes to Accounts Page)
			.clickNewOnAccountsPage()
			
			//Choose 'Supplier Form' Option
			.chooseSupplierForm()
			
			//Default account status
			.defaultAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountStatus", sDataSheetName))

			//Default account type
			.defaultAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "defaultAccountType", sDataSheetName))
			
			//Account name1		
			.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "accountName", sDataSheetName))		
			
			//Account name2
			.typeAccountName2(DataInputProvider.getCellData_ColName(iRowNumber, "accountName2", sDataSheetName))
			
			//Enter premier start date
			.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "premierStartDate", sDataSheetName))		

			//Enter Business classification		
			.selectBusinessClassification(DataInputProvider.getCellData_ColName(iRowNumber, "businessClassification", sDataSheetName))

			//Primary contact
			.addSupplierPrimaryContact(DataInputProvider.getCellData_ColName(iRowNumber, "addSupplierPrimaryContact",sDataSheetName))

			//CAMS flag
			.verifyCAMSFlag(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyCAMSFlag", sDataSheetName))
			
			
			//Member record
			.addMemberRecord(DataInputProvider.getCellData_ColName(iRowNumber, "memberRecord", sDataSheetName))
			
			//HIBCC Subsec
			.verifyHIBCC(DataInputProvider.getCellData_ColName(iRowNumber, "verifyHIBCC", sDataSheetName))
			
			//No new products
			.verifyNoNewProducts(DataInputProvider.getCellData_ColName(iRowNumber, "verifyNoNewProducts", sDataSheetName))
			
			//Ownership
			.selectOwnership(DataInputProvider.getCellData_ColName(iRowNumber, "Ownership", sDataSheetName))
			
			//Stock symbol
			.typeStockSymbol(DataInputProvider.getCellData_ColName(iRowNumber, "stockSymbol", sDataSheetName))
			
			//Exchange 
			.typeExchange(DataInputProvider.getCellData_ColName(iRowNumber, "Exchange", sDataSheetName))
			
			//Store location type
			//.storeLocationTypeWithOutFrame(DataInputProvider.getCellData_ColName(iRowNumber, "storeLocationType", sDataSheetName))	
			
			//Override name
			.typeOverrideName(DataInputProvider.getCellData_ColName(iRowNumber, "overrideName", sDataSheetName))
			
			//Street 1
			.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "street1", sDataSheetName))		

			
			//Street 2
			.typeStreet2(DataInputProvider.getCellData_ColName(iRowNumber, "Street2", sDataSheetName))

			//city
			.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))
			
			//DElivery info
			.typeDeliveryInfo(DataInputProvider.getCellData_ColName(iRowNumber, "deliveryInfo", sDataSheetName))

			//State
			.typeState(DataInputProvider.getCellData_ColName(iRowNumber, "State", sDataSheetName))
			
			//county
			.typeCounty(DataInputProvider.getCellData_ColName(iRowNumber, "County", sDataSheetName))


			//Postal code
			.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "zipCode", sDataSheetName))	

			//country
			.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))
			
			//Phone
			.typeMainPhone(DataInputProvider.getCellData_ColName(iRowNumber, "mainPhone", sDataSheetName))	
			
			//Toll free no
			
			//Fax
			.typeFax(DataInputProvider.getCellData_ColName(iRowNumber, "Fax", sDataSheetName))
			
			//Website
			.typeWebsite(DataInputProvider.getCellData_ColName(iRowNumber, "Website", sDataSheetName))

			//Receive Direct Mail
			.verifyReceiveDirectMail(DataInputProvider.getCellData_ColName(iRowNumber, "receiveDirectMail", sDataSheetName))
	
			//Do not Verify address
			.verifyDoNotVerifyAddress(DataInputProvider.getCellData_ColName(iRowNumber, "doNotVerifyAddress", sDataSheetName))
			
			//Direct Parent
			.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "directParent", sDataSheetName))	
			.verifyDPValue(DataInputProvider.getCellData_ColName(iRowNumber, "verifyDPValue", sDataSheetName))	

			//DPRD
			.selectDPParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "selectDPRelationDate", sDataSheetName))

			
			
			//Is top parent
			 .verifyIsTopParent(DataInputProvider.getCellData_ColName(iRowNumber, "verifyIsTopParent", sDataSheetName))
			
			//Top parent
			.verifyTopParent(DataInputProvider.getCellData_ColName(iRowNumber, "verifyTopParent", sDataSheetName))
			
			
			
			
			//Top parent relation date
			.pickTPRD(DataInputProvider.getCellData_ColName(iRowNumber, "selectTPRelationDate", sDataSheetName))	
				
			//Choose Record Status as Published
			.recordStatusPublished(DataInputProvider.getCellData_ColName(iRowNumber, "recordStatusPublished", sDataSheetName))				
			
			//Click on SAve
			.clickSave()


			//Entity code
			.entityCodeIsDisplayed()

			//CRM number
			.crmNumberIsDisplayed()
			;
		}
}
