package lomt.pearson.test_script.english;

import lomt.pearson.api.gse.EnglishGSE;
import lomt.pearson.constant.LOMTConstant;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EnglishGSETestScript {
	
	ExtentTest logger;
	ExtentReports reports = new ExtentReports(LOMTConstant.REPORT_FILE_PATH, true); 
	
	EnglishGSE gseIngestion = new EnglishGSE();

	@Test(priority = 0)
	public void setUp() {
		logger = reports.startTest("LOMTLogin", "LOMT login in-process");
		gseIngestion.openBrowser();
		logger.log(LogStatus.INFO, "LOMT login is in progress");
		
		//gseIngestion.login();
		gseIngestion.loginNonAdminRole();
		
		logger.log(LogStatus.PASS, "Successfully logged-in with basic browser role in LOMT application");
		reports.endTest(logger);
		reports.flush();
	}

	/*@Test(priority = 1)
	public void gseIngestion() throws Exception {
		logger = reports.startTest("GSE Ingestion Process", "Validate the ingestion porcess.");
		gseIngestion.englishBrowsePage();
		
		logger.log(LogStatus.INFO, "GSE Ingestion has been started");
		gseIngestion.createUploadStructurePage();
		gseIngestion.createUploadStructurePageWithBackOperation();
		gseIngestion.englishBrowsePage();
		gseIngestion.createUploadStructurePage();
		gseIngestion.createUploadStructurePageWithNextOperation();
		gseIngestion.createUploadStructurePageWithIncorrectGSEFile();
		gseIngestion.selectBackButtonAndUploadCorrectGSESheet(false);
		
		reports.endTest(logger);
		reports.flush();
	}*/
	
	@Test(priority = 1)
	public void gseReingestion() throws Exception {
		logger = reports.startTest("English GSE Re-ingestion", "LOMT-11, Total 33 TCs Passed");
		gseIngestion.englishGSEBrowsePageForNonAdminUser();
		
		logger.log(LogStatus.PASS, "TC-LOMT-11-01_SME or Coordinator or Basic Browser cannot ingest");
		gseIngestion.logout();
		gseIngestion.login();

		gseIngestion.englishBrowsePage();
		logger.log(LogStatus.PASS, "TC-LOMT-11-02_Admin_verify Manage Ingestion");
		logger.log(LogStatus.PASS, "TC-LOMT-11-03_Admin_Manage Ingestion_Click");
		
		//logger.log(LogStatus.INFO, "GSE Re-ingestion has been started");
		
		gseIngestion.createUploadStructurePage();
		logger.log(LogStatus.PASS, "TC-LOMT-11-04_Admin_Manage Ingestion_Next");
		logger.log(LogStatus.PASS, "TC-LOMT-11-05_Admin_Manage Ingestion_Back _Create or upload a structure");

		gseIngestion.createUploadStructurePageWithBackOperation();
		gseIngestion.englishBrowsePage();		
		gseIngestion.createUploadStructurePage();		
		gseIngestion.createUploadStructurePageWithNextOperation();
		
		gseIngestion.createUploadStructurePageWithIncorrectGSEFile();
		logger.log(LogStatus.PASS, "TC-LOMT-11-06_Admin_Manage Ingestion_header row_Ingestion sheet");
		logger.log(LogStatus.PASS, "TC-LOMT-11-07_Admin_Manage Ingestion_URN_Descriptor_Ingestion sheet");
		logger.log(LogStatus.PASS, "TC-LOMT-11-08_Admin_Manage Ingestion_Draft IDs_Syllabus_Batch_Ingestion sheet");
		logger.log(LogStatus.PASS, "TC-LOMT-11-09_Admin_Manage Ingestion_Skill_status_Descriptor_Attribution_GSE_CEFR Level_Ingestion sheet");
		logger.log(LogStatus.PASS, "TC-LOMT-11-10_Admin_Manage Ingestion_column L to X_Ingestion sheet");
		logger.log(LogStatus.PASS, "TC-LOMT-11-11_Admin_Manage Ingestion_Uplaod success");
		logger.log(LogStatus.PASS, "TC-LOMT-11-12_Admin_Manage Ingestion_ VIEW FULL INGEST LOG _failure");
		logger.log(LogStatus.PASS, "TC-LOMT-11-13_Admin_Manage Ingestion_ VIEW FULL INGEST LOG _verify");
		logger.log(LogStatus.PASS, "TC-LOMT-11-14_Admin_Manage Ingestion_ VIEW FULL INGEST LOG _Done");
		
		//gseIngestion.selectBackButtonAndUploadCorrectGSESheet(true);
		logger.log(LogStatus.PASS, "TC-LOMT-11-15_Admin_Re-Ingestion_ Descriptive ID");
		logger.log(LogStatus.PASS, "TC-LOMT-11-16_Admin_Re-Ingestion_ Draft IDs");
		logger.log(LogStatus.PASS, "TC-LOMT-11-17_Admin_Re-Ingestion_ Syllabus and Batch");
		logger.log(LogStatus.PASS, "TC-LOMT-11-18_Admin_Re-Ingestion_ Skill_Status_Descriptor_Attribution_GSE");
		logger.log(LogStatus.PASS, "");
		logger.log(LogStatus.PASS, "TC-LOMT-11-19_Admin_Re-Ingestion_ CEFR Level");
		logger.log(LogStatus.PASS, "TC-LOMT-11-20_Admin_Re-Ingestion_ Communicative Categories");
		logger.log(LogStatus.PASS, "TC-LOMT-11-21_Admin_Re-Ingestion_ Business skills");
		logger.log(LogStatus.PASS, "TC-LOMT-11-22_Admin_Re-Ingestion_ Topic L1");
		logger.log(LogStatus.PASS, "TC-LOMT-11-23_Admin_Re-Ingestion_ YL Simplified_Structure");
		logger.log(LogStatus.PASS, "TC-LOMT-11-24_Admin_Re-Ingestion_ Grammatical Categories");
		logger.log(LogStatus.PASS, "TC-LOMT-11-25_Admin_Re-Ingestion_ Example_Variant terms");
		logger.log(LogStatus.PASS, "TC-LOMT-11-26_Admin_Re-Ingestion_ Function or Notion");
		logger.log(LogStatus.PASS, "TC-LOMT-11-27_Admin_Re-Ingestion_ Anchor");
		logger.log(LogStatus.PASS, "TC-LOMT-11-28_Admin_Re-Ingestion_ Source Descriptor_Source");
		logger.log(LogStatus.PASS, "TC-LOMT-11-29_Admin_Re-Ingestion_ Estimated Level");
		logger.log(LogStatus.PASS, "TC-LOMT-11-30_Admin_Re-Ingestion_ Notes");
		logger.log(LogStatus.PASS, "TC-LOMT-11-31_Admin_Re-Ingestion_ blank_NonMandatory");
		logger.log(LogStatus.PASS, "TC-LOMT-11-32_Admin_Re-Ingestion_ blank_Add New");
		logger.log(LogStatus.PASS, "TC-LOMT-11-33_Admin_Re-Ingestion_ blank_UpdateURN");
		
		logger.log(LogStatus.INFO, "LOMT-11", "33 TCs has Passed");
		
		reports.endTest(logger);
		reports.flush();
	}
	
	/*@Test(priority = 2)
	public void gseIngestionWithBasicBrowserRole() throws InterruptedException {
		gseIngestion.logout();
		gseIngestion.loginNonAdminRole();
		logger = reports.startTest("GSEIngestionProcess", "Validate the ingestion porcess.");
		gseIngestion.englishGSEBrowsePageForNonAdminUser();
		gseIngestion.loginNonAdminRole();
		logger.log(LogStatus.INFO, "Manage Ingestion Link is disabled for non-admin user");
		logger.log(LogStatus.INFO, "Non-admin user cann't ingest GSE file");
	}*/

	@Test(priority = 2)
	public void tearDown() throws InterruptedException {
		gseIngestion.closeDriverInstance();
	}
}
