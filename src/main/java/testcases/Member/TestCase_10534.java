package testcases.Member;

import org.openqa.selenium.By;

import org.testng.annotations.Test;
import driver.Driver;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;

//TFS_ID_10534-Verify Limited Member fields that are NOT editable

public class TestCase_10534 {


	@Test
	public void verifyLimitedMemberNonEditablefields(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM as Limited member 
		new LoginPage()
		.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
		.clickNext()
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clicSignin()
		.clicYesInStaySignedin()
	

		//2. Go to Work place >> Take Any Member Account 
		.selectAccountsTab()		
		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "crmNumber", sDataSheetName)) 
		.selectAccountFromSearchResults()

		//3.Verify following Fields are NOT editable in Opened Member Account
		.verifyPremierStartDateIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProviderStartDate", sDataSheetName))
		.verifyPremierEndDateIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "membershipEndDate", sDataSheetName))
		.verifyStoreLocTypeIsNotEditable()	
		.verifyStoreLocNumIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "storeLocNum", sDataSheetName))
		.verifyDirectParentDetailsIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "directParent", sDataSheetName),DataInputProvider.getCellData_ColName(iRowNumber, "crmNumber1", sDataSheetName),DataInputProvider.getCellData_ColName(iRowNumber, "dPReason", sDataSheetName))
		.verifyTopParentDetailsIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "topParent", sDataSheetName),DataInputProvider.getCellData_ColName(iRowNumber, "crmNumber1", sDataSheetName),DataInputProvider.getCellData_ColName(iRowNumber, "tPReason", sDataSheetName))
		.verifyGroupIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "verifyGroup", sDataSheetName))
		.verifyClassOfTradeIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "classOfTrade", sDataSheetName))
		.verifyFacilityTypeIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "verifyFacilityType", sDataSheetName))
		.verifyBusinessClassificationIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "verifyBusinessClassification", sDataSheetName))
		.verifyPremierOwnerIsNotEditable()
		.verifyAccountStatusIsNotEditable()
		.verifyApplicationDateIsNotEditable()
		.verifyCAMSFlagIsNotEditable()
		.verifyExcludeFromRosterIsNotEditable()
		.verifyParticipationTypeIsNotEditable()
		.verifyProviderSelectMDIsNotEditable()
		.verifyBusinessKeyIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "bKActive", sDataSheetName))
		.verifyBKActiveIsNotEditable()
		.verifySiebelIDIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "siebelID", sDataSheetName))
		.verifyRegionIsNotEditable()
		.verifySponsorDetailsIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "sponsor", sDataSheetName))
		.verifySupplierRecordIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "supplierRecord", sDataSheetName))
		.verifyOwnershipIsNotEditable()
		.verifyStockSymbolIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "stockSymbol", sDataSheetName))
		.verifyExchangeIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "exchange", sDataSheetName))
		.verifyCorporateParentDetailsIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "corporateParent", sDataSheetName), DataInputProvider.getCellData_ColName(iRowNumber, "crmNumber1", sDataSheetName))
		.verifyPaymentEntityDetailsIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "paymentEntity", sDataSheetName))
		.verifyCorporateRebateDetailsIsNotEditable()
		.verifyFoodServiceParentDetailsIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "foodServiceParent", sDataSheetName), DataInputProvider.getCellData_ColName(iRowNumber, "crmNumber1", sDataSheetName))
		.verifyRequireManualAGAssignmentIsNotEditable()
		.verifyAffiliateGroupIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "affiliateGroup", sDataSheetName))
		.verifyAffiliateGroupEffectiveDateIsNotEditable()
		.verifyRecordStatusIsNotEditable()
		.verifyAccountTypeIsNotEditable()
		.verifyRecordChangeStatusIsNotEditable()
		.verifyPremierRosterIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "premierRoster", sDataSheetName))
		.verifyCurrentInternalRepIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "currentInternalRep", sDataSheetName))
		.verifyCurrentFieldRepIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "currentFieldRep", sDataSheetName))
		.verifyFBOtDetailsIsNotEditable(DataInputProvider.getCellData_ColName(iRowNumber, "fBO", sDataSheetName))		
		.verifyFeeShareDetailsIsNotEditable();

	}
}
