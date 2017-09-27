package lomt.pearson.test_script.regressoin;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lomt.pearson.api.regression.Regression;
import lomt.pearson.constant.LOMTConstant;

public class RegressionTestScript1 {
	
	ExtentTest logger;
	ExtentReports reports = new ExtentReports(LOMTConstant.REPORT_FILE_PATH, true);

	Regression regression = new Regression();

	@Test(priority = 0)
	public void setup() {
		regression.openBrowser();
		regression.login();
	}
	
	@Test(priority = 1)
	public void gseIngestion() throws Exception {
		logger = reports.startTest("English GSE Ingestion", "LOMT-11, Total 33 TCs");
		
		regression.gseIngestion(logger);
		
		logger.log(LogStatus.INFO, "LOMT-11", "14 TCs has Passed");
		
		reports.endTest(logger);
		reports.flush();
	}
	
	@Test(priority = 2)
	public void gseReingestion() throws Exception {
		logger = reports.startTest("English GSE Ingestion", "LOMT-11, Total 33 TCs");
		
		regression.gseIngestion(logger);
		
		logger.log(LogStatus.INFO, "LOMT-11", "19 TCs has Passed");
		
		reports.endTest(logger);
		reports.flush();
	}
	
	@Test(priority = 3)
	public void gseEducationalGoalFrameworkExport() throws Exception {
		logger = reports.startTest("English GSE Export", "LOMT-253, Total 6 TCs");
		
		regression.gseEducationalGoalFrameworkExport(logger);
		
		logger.log(LogStatus.INFO, "LOMT-253", "6 TCs has Passed");
		
		reports.endTest(logger);
		reports.flush();
	}
	
	@Test(priority = 4)
	public void intermediarIngestionForSchool() throws Exception {
		logger = reports.startTest("School Intermediary ingestion", "LOMT-10");
		
		regression.intermediarIngestionForSchool(logger);
		
		logger.log(LogStatus.INFO, "LOMT-10", "12 TCs has Passed");
		reports.endTest(logger);
		reports.flush();
	}
	
	@Test(priority = 5)
	public void selectCutomExternalFrameworkForSchool() {
		logger = reports.startTest(LOMTConstant.CUSTOME_EXF_SCHOOL,LOMTConstant.LOMT_1389+LOMTConstant.COMMA+LOMTConstant.EMPTY_SPACE+" TC count is 19");
		
		regression.selectCutomExternalFrameworkForSchool(logger);
		
		logger.log(LogStatus.INFO, "LOMT-1389", "19 TCs has Passed");
		reports.endTest(logger);
	}
	
	@Test(priority = 6)
	public void metaData() {
		logger = reports.startTest(LOMTConstant.META_DATA+LOMTConstant.EMPTY_SPACE+LOMTConstant.EXTERNAL_FRAMEWORK_INGESTION, 
				LOMTConstant.LOMT_1358+LOMTConstant.COMMA+LOMTConstant.EMPTY_SPACE+LOMTConstant.TC_COUNT_ENGLISH_EXF);
		regression.metaDataPage(logger);
		
		reports.endTest(logger);
		reports.flush();
	}
	
	//HE External Framework
	@Test(priority = 7)
	public void ingestionExternalFrameworkForHE() {
		logger = reports.startTest(LOMTConstant.HE_LOB+LOMTConstant.EMPTY_SPACE+LOMTConstant.EXTERNAL_FRAMEWORK_INGESTION, 
				LOMTConstant.LOMT_1357+LOMTConstant.COMMA+LOMTConstant.EMPTY_SPACE+LOMTConstant.TC_COUNT_HE_EXF);
		
		regression.ingestionExternalFrameworkForHE(logger);
		
		logger.log(LogStatus.INFO, "LOMT-1357", "30 TCs has Passed");
		reports.endTest(logger);
		reports.flush();
	}
	
	//English External Framework
	@Test(priority = 8)
	public void ingestionExternalFrameworkForEnglish() {
		logger = reports.startTest(LOMTConstant.ENGLISH_LOB+LOMTConstant.EMPTY_SPACE+LOMTConstant.EXTERNAL_FRAMEWORK_INGESTION, 
				LOMTConstant.LOMT_1357+LOMTConstant.COMMA+LOMTConstant.EMPTY_SPACE+LOMTConstant.TC_COUNT_ENGLISH_EXF);
		
		regression.ingestionExternalFrameworkForEnglish(logger);
		
		logger.log(LogStatus.INFO, "LOMT-1357", "31 TCs has Passed");
		reports.endTest(logger);
		reports.flush();
	}
	
	//English External Framework
	@Test(priority = 9)
	public void ingestionExternalFrameworkForSchool() {
		logger = reports.startTest(LOMTConstant.SCHOOL+LOMTConstant.EMPTY_SPACE+LOMTConstant.EXTERNAL_FRAMEWORK_INGESTION, 
				LOMTConstant.LOMT_1357+LOMTConstant.COMMA+LOMTConstant.EMPTY_SPACE+LOMTConstant.TC_COUNT_SCHOOL_EXF);

		regression.ingestionExternalFrameworkForEnglish(logger);

		logger.log(LogStatus.INFO, "LOMT-1357", "29 TCs has Passed");
		reports.endTest(logger);
		reports.flush();
	}
	
	//School Product TOC 
	@Test(priority = 10)
	public void productTOCIngestionSchool() {
		logger = reports.startTest(LOMTConstant.SCHOOL+LOMTConstant.EMPTY_SPACE+LOMTConstant.PRODUCT_TOC_INGESTION, 
				LOMTConstant.LOMT_1039+LOMTConstant.COMMA+LOMTConstant.EMPTY_SPACE+LOMTConstant.TC_COUNT_PRODUCT_TOC);
		
		regression.productTOCIngestionSchool(logger);
		
		logger.log(LogStatus.INFO, LOMTConstant.LOMT_1039, "38 TCs has Passed");
		reports.endTest(logger);
		reports.flush();
	}
	
	//English Product TOC
	@Test(priority = 11)
	public void productTOCIngestionEnglish() {
		logger = reports.startTest(LOMTConstant.ENGLISH_LOB + LOMTConstant.EMPTY_SPACE+ LOMTConstant.PRODUCT_TOC_INGESTION,
				LOMTConstant.LOMT_1040 + LOMTConstant.COMMA+ LOMTConstant.EMPTY_SPACE+ LOMTConstant.ENGLISH_TC_COUNT_PRODUCT_TOC);

		regression.productTOCIngestionEnglish(logger);
		
		logger.log(LogStatus.INFO, LOMTConstant.LOMT_1040, "27 TCs has Passed");
		reports.endTest(logger);
		reports.flush();
	}
	
	// HE Product TOC
	@Test(priority = 12)
	public void productTOCIngestionHigherEducation() {
		logger = reports.startTest(LOMTConstant.HE_LOB + LOMTConstant.EMPTY_SPACE+ LOMTConstant.PRODUCT_TOC_INGESTION,
				LOMTConstant.LOMT_1041 + LOMTConstant.COMMA+ LOMTConstant.EMPTY_SPACE+ LOMTConstant.HE_TC_COUNT_PRODUCT_TOC);

		regression.productTOCIngestionHigherEducation(logger);
		
		logger.log(LogStatus.INFO, LOMTConstant.LOMT_1041, "28 TCs has Passed");
		reports.endTest(logger);
		reports.flush();
	}

	@Test(priority = 13)
	public void tearDown() {
		regression.closeDriverInstance();
	}

}
