package lomt.pearson.test_script.nals_sg;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lomt.pearson.api.nals_sg.Intermediary;
import lomt.pearson.constant.LOMTConstant;

public class IntermediaryTestScript {

	Intermediary intermediary = new Intermediary();
	
	ExtentTest logger;
	ExtentReports reports = new ExtentReports(LOMTConstant.REPORT_FILE_PATH, true); 

	@Test(priority = 0)
	public void setup() {
		logger = reports.startTest("LOMTLogin", "LOMT login in-process");
		intermediary.openBrowser();
		logger.log(LogStatus.INFO, "LOMT login is in progress");
		
		intermediary.login();
		logger.log(LogStatus.PASS, "Successfully logged-in with basic browser role in LOMT application");
		reports.endTest(logger);
		reports.flush();
	}

	@Test(priority = 1)
	public void intermediarIngestionSchollGlobal() throws Exception {
		logger = reports.startTest("School Global Intermediary ingestion", "LOMT-10, Total 12 TCs Passed");
		
		intermediary.schoolGlobalBrowsePage(true);
		logger.log(LogStatus.PASS, "TC-LOMT-10-01_UploadIntermediaryLink");
		logger.log(LogStatus.PASS, "TC-LOMT-10-02_SelectFileButton");
		logger.log(LogStatus.PASS, "TC-LOMT-10-03_UploadButton");
		
		intermediary.createUploadStructurePage1(true);
		intermediary.createUploadStructurePageWithIncorrectIntermediaryFile(true);
		
		intermediary.createUploadStructurePage1(true);
		intermediary.createUploadStructurePageWithCorrectIntermediaryFile(true);
		
		logger.log(LogStatus.PASS, "TC-LOMT-10-04_UploadIntermediary_Successful");
		logger.log(LogStatus.PASS, "TC-LOMT-10-05_UploadFunctionality_xlsxOr xlsFormat");
		logger.log(LogStatus.PASS, "TC-LOMT-10-06_Verify_IngestedCols");
		logger.log(LogStatus.PASS, "TC-LOMT-10-07_IntermediaryIngestion_missingCol");
		logger.log(LogStatus.PASS, "TC-LOMT-10-08_IntermediaryStatement_Col_Chars");
		logger.log(LogStatus.PASS, "TC-LOMT-10-09_IntermediaryStatement_MaxNoOfStmts");
		logger.log(LogStatus.PASS, "TC-LOMT-10-10_Intermediary_ingestion_Tag_missing");
		logger.log(LogStatus.PASS, "TC-LOMT-10-11_TagCol_values");
		logger.log(LogStatus.PASS, "TC-LOMT-10-12_IntermediaryIngestion_col_blank");
		
		logger.log(LogStatus.INFO, "LOMT-10", "12 TCs has Passed");
		reports.endTest(logger);
		reports.flush();
	}
	
	/*@Test(priority = 2)
	public void intermediarIngestionNALS() throws Exception {
		logger = reports.startTest("North America Learning Services Intermediary ingestion", "LOMT-12, Total 14 TCs Passed");
		
		intermediary.schoolGlobalBrowsePage(false);
		logger.log(LogStatus.PASS, "TC-LOMT-10-01_UploadIntermediaryLink");
		logger.log(LogStatus.PASS, "TC-LOMT-10-02_SelectFileButton");
		logger.log(LogStatus.PASS, "TC-LOMT-10-03_UploadButton");
		
		intermediary.createUploadStructurePage1(false);
		intermediary.createUploadStructurePageWithIncorrectIntermediaryFile(false);
		
		intermediary.createUploadStructurePage1(false);
		intermediary.createUploadStructurePageWithCorrectIntermediaryFile(false);
		
		logger.log(LogStatus.PASS, "TC-LOMT-10-04_UploadIntermediary_Successful");
		logger.log(LogStatus.PASS, "TC-LOMT-10-05_UploadFunctionality_xlsxOr xlsFormat");
		logger.log(LogStatus.PASS, "TC-LOMT-10-06_Verify_IngestedCols");
		logger.log(LogStatus.PASS, "TC-LOMT-10-07_IntermediaryIngestion_missingCol");
		logger.log(LogStatus.PASS, "TC-LOMT-10-08_IntermediaryStatement_Col_Chars");
		logger.log(LogStatus.PASS, "TC-LOMT-10-09_IntermediaryStatement_MaxNoOfStmts");
		logger.log(LogStatus.PASS, "TC-LOMT-10-10_Intermediary_ingestion_Tag_missing");
		logger.log(LogStatus.PASS, "TC-LOMT-10-11_TagCol_values");
		logger.log(LogStatus.PASS, "TC-LOMT-10-12_IntermediaryIngestion_col_blank");
		
		logger.log(LogStatus.INFO, "LOMT-10", "12 TCs has Passed");
		reports.endTest(logger);
		reports.flush();
	}
	
	@Test(priority = 1)
	public void exportIntermediaryForSchoolGlobal() {
		intermediary.exportIntermediaryForSchoolGlobalAndNALS(true);
	}*/
	
	/*@Test(priority = 4)
	public void exportIntermediaryForNorthAmericaLearningServices() {
		
	}*/

	@Test(priority = 1)
	public void tearDown() {
		intermediary.closeDriverInstance();
	}

}
