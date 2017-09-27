package lomt.pearson.test_script.higherEducation;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lomt.pearson.api.he.IngestionAndExport;
import lomt.pearson.constant.LOMTConstant;
import lomt.pearson.constant.TestCases;

public class HigherEducationTestScript {
	
	ExtentTest logger;
	ExtentReports reports = new ExtentReports(LOMTConstant.REPORT_FILE_PATH, true);
	
	IngestionAndExport ingestionAndExport = new IngestionAndExport();
	
	@Test(priority = 0)
	public void setup() {
		ingestionAndExport.openBrowser();
		ingestionAndExport.login();
	}
	
	//LOMT-457
	@Test(priority = 1)
	public void ingestionHigherEducation() {
		logger = reports.startTest(LOMTConstant.HE_LOB+LOMTConstant.EMPTY_SPACE+LOMTConstant.EO_INGESTION, LOMTConstant.LOMT_457+LOMTConstant.COMMA+LOMTConstant.EMPTY_SPACE+LOMTConstant.TC_COUNT_HE_457);
		
		ingestionAndExport.higherEducationLOBBrowsePage();
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_01_ADMIN_ACCESS_HE_INGESTION_PAGE);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_02_NON_ADMIN_ACCESS_HE_INGESTION_PAGE);
		logger.log(LogStatus.SKIP, LOMTConstant.DE_SCOPED, TestCases.TC_LOMT_457_03_ADMIN_USER_NOT_ACCESS_HE_INGESTION_PAGE);
		logger.log(LogStatus.SKIP, LOMTConstant.DE_SCOPED, TestCases.TC_LOMT_457_04_NON_ADMIN_USER_ACCESS_HE_INGESTION_PAGE);
		
		ingestionAndExport.createUploadStructureFirstPage();
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_05_LOB_HIGHER_EDUCATION_RADIO_BUTTON);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_06_LOB_EDUCATIONAL_OBJECTIVE_RADIO_BUTTON);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_07_LOB_EDUCATIONAL_OBJECTIVE_RADIO_BUTTON_NEGATIVE);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_08_LOB_EDUCATIONAL_OBJECTIVE_FIRST_PAGE_UPLOAD_PROCESS);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_09_NEXT_BUTTON_LOB_HIGHER_EDUCATION);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_09_NEXT_BUTTON_LOB_HIGHER_EDUCATION);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_11_LOB_EDUCATIONAL_OBJECTIVE_SECOND_PAGE_UPLOAD_PROCESS);
		
		//ingestionAndExport.backSelect(); // back link clicked
		//ingestionAndExport.createUploadStructureFirstPage();
		ingestionAndExport.createUploadStructureMetaDataPage();
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_12_METADATA_FIELDS);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_13_LEARNING_EXPERIENCE_NAME_TITLE_METADATA_FIELDS_VALUE);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_14_LEARNING_EXPERIENCE_NAME_TITLE_METADATA_MAX_VALUE);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_15_LEARNING_EXPERIENCE_NAME_TITLE_METADATA_SPECIAL_CHARACTER_VALUE);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_16_LEARNING_EXPERIENCE_NAME_TITLE_METADATA_ALPHA_NUMERIC_VALUE);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_17_SELECT_ALL_METADATA_VALUES);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_18_NEXT_BUTTON_METADATA_PAGE);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_19_NEXT_BUTTON_SOME_METADATA_DROPDOWN_NOT_SELECTED);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_20_NEXT_BUTTON_LEARNING_EXPERIENCE_TEXT_MISSING);
		
		ingestionAndExport.educationalObjectiveIngestion(LOMTConstant.INVALID_FORMAT_FILE); //other than excel file
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_21_UPLOAD_FILE_PAGE);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_22_VERIFY_UPLOAD_PROCESS_ON_THIRD_PAGE);
		logger.log(LogStatus.SKIP, LOMTConstant.DE_SCOPED, TestCases.TC_LOMT_457_23_DRAG_AND_DROP_FILE);
		logger.log(LogStatus.SKIP, LOMTConstant.DE_SCOPED, TestCases.TC_LOMT_457_24_DRAG_AND_DROP_FILE_ERROR_WHEN_WRONG_FILE);
		logger.log(LogStatus.SKIP, LOMTConstant.DE_SCOPED, TestCases.TC_LOMT_457_25_DRAG_AND_DROP_FILE_ERROR_WHEN_WRONG_FORMAT_FILE);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_26_SELECT_FILE_LINK);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_27_SELECT_FILE_LINK_ERROR_WITH_WRONG_FILE_SELECT);
		
		//Wrong format, like fields level validation, headers missing and so on.
		ingestionAndExport.educationalObjectiveIngestion(LOMTConstant.VALIDATION_MISSED); 
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_28_SELECT_FILE_LINK_ERROR_WITH_WRONG_FILE_FORMAT_SELECT);
		
		//Ingest correct file
		ingestionAndExport.createUploadStructureMetaDataPage();
		ingestionAndExport.educationalObjectiveIngestion(LOMTConstant.INGEST); 
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_29_NEXT_BUTTON_UPLAOD_FILE_LINK);
		logger.log(LogStatus.SKIP, TestCases.TC_LOMT_457_29_NEXT_BUTTON_DRAG_AND_DROP_FILE);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_30_UPLOAD_PROCESS_CHECK_AFTER_INGESTION);
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_457_31_DONE_BUTTON_ON_REVIEW_OUTCOME);
		
		logger.log(LogStatus.INFO, LOMTConstant.LOMT_457+LOMTConstant.COMMA+LOMTConstant.EMPTY_SPACE+"Total 26 TCs"+LOMTConstant.HAS_PASSED);
		
		reports.endTest(logger);
		reports.flush();
	}
	
	@Test(priority = 2)
	public void tearDown() {
		ingestionAndExport.closeDriverInstance();
	}
	
}
