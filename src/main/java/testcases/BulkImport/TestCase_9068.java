
	package testcases.BulkImport;
	import org.testng.annotations.Test;
	import pages.LoginPage;
	import utils.DataInputProvider;

	public class TestCase_9068 {
		
//Create supplier with all available fields		
		@Test()

		public void importCreateSupplier(int iRowNumber, String sDataSheetName) throws Exception {
			
			new LoginPage()
			.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
			.clickNext()
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
	  	    .clicSignin()
	  	    .clicYesInStaySignedin()
	  	    .selectDataImports()
	  	    .clickNewButton()
	  	    .bulkImportFile(DataInputProvider.getCellData_ColName(iRowNumber, "FileType", sDataSheetName), DataInputProvider.getCellData_ColName(iRowNumber, "FileName", sDataSheetName))
	  	    
	  	    ;
		}
}
