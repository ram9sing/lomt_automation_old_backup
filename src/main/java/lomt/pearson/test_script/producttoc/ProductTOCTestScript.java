package lomt.pearson.test_script.producttoc;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lomt.pearson.api.product_toc.ProductTOC;
import lomt.pearson.constant.LOMTConstant;
import lomt.pearson.constant.TestCases;

public class ProductTOCTestScript {

	ExtentTest logger;
	ExtentReports reports = new ExtentReports(LOMTConstant.REPORT_PRODUCT_TOC_FILE_PATH, true);

	ProductTOC product = new ProductTOC();

	@Test(priority = 0)
	public void setup() {
		product.openBrowser();
		product.login();
	}

	@Test(priority = 1)
	public void productTOCIngestionSchool() {
		logger = reports.startTest(LOMTConstant.SCHOOL+LOMTConstant.EMPTY_SPACE+LOMTConstant.PRODUCT_TOC_INGESTION, 
				LOMTConstant.LOMT_1039+LOMTConstant.COMMA+LOMTConstant.EMPTY_SPACE+LOMTConstant.PRODUCT_TOC_SCHOOL_TC_COUNT);
		
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_01_PRODUCTTOC_SME_OR_COORDINATOR_OR_BASIC_BROWSER_CANNOT_INGEST);
		
		/*product.nalsBrowsePage(logger); 		
		product.createUploadStructurePage(logger);			
		product.backLinkClicked(logger);
		product.getSchoolLOBAndStructure();
		product.productTOCWithoutMetaData();
		
		//program and course title blank, and product title has value, all the mandatory and non-mandatory fields
		product.productTOCIngestion(LOMTConstant.TC_CASE_7_8_9_10_11, logger);
		
		//Program, Course and Product Title has new value
		product.getHomePage();
		product.sgBrowsePage(logger);
		product.getSchoolLOBAndStructure();
		product.productTOCWithoutMetaData();
		product.productTOCIngestion(LOMTConstant.TC_12, logger);
		
		//Program has new value, Course has existing value and Product Title has new or old value
		product.getSchoolLOBAndStructure();	
		product.productTOCWithoutMetaData();
		product.productTOCIngestion(LOMTConstant.TC_13, logger);
		
		//Program has existing value, Course has new value and Product Title has new or old value
		product.getSchoolLOBAndStructure();	
		product.productTOCWithoutMetaData();
		product.productTOCIngestion(LOMTConstant.TC_14, logger);
		
		//Program has existing and Course has existing value, Product Title has new or old value
		product.getSchoolLOBAndStructure();	
		product.productTOCWithoutMetaData();
		product.productTOCIngestion(LOMTConstant.TC_15, logger);  
		
		// re-ingestion, not implemented yet, so De-scoped for now
		product.getSchoolLOBAndStructure();		
		product.productTOCIngestion(LOMTConstant.TC_16, logger); 
		
		logger.log(LogStatus.INFO, TestCases.TC_LOMT_1039_16_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_PRODUCTTITLE_DUPLICATE_VALUE_NO_ALIGN);
		logger.log(LogStatus.INFO, "Descoped: above use case comes under re-ingestion, implementation is in progress");
		
		//AlignmentCode column has value
		product.getSchoolLOBAndStructure();	
		product.productTOCWithoutMetaData();
		product.productTOCIngestion(LOMTConstant.TC_17, logger);
		
		//Goal URN/CMT Intermediary Unique ID column has value()
		product.getSchoolLOBAndStructure();	
		product.productTOCWithoutMetaData();
		product.productTOCIngestion(LOMTConstant.TC_18, logger);
		
		// sequence mismatch for "Level for Hierarchy"
		product.getSchoolLOBAndStructure();	
		product.productTOCWithoutMetaData();
		product.productTOCIngestion(LOMTConstant.TC_19, logger); 
		
		logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_20_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_LEVEL_FOR_HIERARCHY_EXPAND_ALL_LEVEL);
		logger.log(LogStatus.PASS, "Hierarchy expand is verify using DHC");
		
		product.getSchoolLOBAndStructure();		
		product.productTOCIngestion(LOMTConstant.TC_20, logger);
		
		//Alignment Code has wrong value
		product.getSchoolLOBAndStructure();	
		product.productTOCWithoutMetaData();
		product.productTOCIngestion(LOMTConstant.TC_21, logger);
		
		//CMT Intermediary Unique ID has wrong value(Goal URN)
		product.getSchoolLOBAndStructure();	
		product.productTOCWithoutMetaData();
		product.productTOCIngestion(LOMTConstant.TC_22, logger);
		
		//Ingestion without non-mandatory fields
		product.getSchoolLOBAndStructure();	
		product.productTOCWithoutMetaData();
		product.productTOCIngestion(LOMTConstant.TC_23, logger);
		
		//Wrong format file
		product.getSchoolLOBAndStructure();
		product.productTOCWithoutMetaData();
		product.productTOCIngestionWithInvalidFormatFile(logger);	
		
		//mandatory fields check
		product.getSchoolLOBAndStructure();
		product.productTOCWithoutMetaData();
		product.productTOCIngestion(LOMTConstant.TC_25, logger);
		
		//Product Title is blank
		product.getSchoolLOBAndStructure();
		product.productTOCWithoutMetaData();
		product.productTOCIngestionValidatonCheck(LOMTConstant.TC_26, logger); 
		
		//Level for Hierarchy is blank
		product.getSchoolLOBAndStructure();
		product.productTOCWithoutMetaData();
		product.productTOCIngestionValidatonCheck(LOMTConstant.TC_27, logger); 
		
		//Level Title is blank
		product.getSchoolLOBAndStructure();
		product.productTOCWithoutMetaData();
		product.productTOCIngestionValidatonCheck(LOMTConstant.TC_28, logger); 
		
		//Content Title is blank(mandatory fields) : Now its optional fields, so descoped 
		
		logger.log(LogStatus.SKIP, TestCases.TC_LOMT_1039_29_PRODUCTTOC_ADMIN_MANAGE_INGESTION_CONTENT_TITLE_MANDATORY_FIELD_BLANK);
		logger.log(LogStatus.INFO, "Content Title is option fields now so above TC is de-scoped");
		product.getSchoolLOBAndStructure();
		product.productTOCIngestionValidatonCheck(LOMTConstant.TC_29, logger); 
		
		//Level for Hierarchy and Content Title are  blank, Content Title is optional so descoped
		product.getSchoolLOBAndStructure();
		product.productTOCIngestionValidatonCheck(LOMTConstant.TC_30, logger); 
		
		logger.log(LogStatus.SKIP, TestCases.TC_LOMT_1039_30_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_FOR_HIERARCHY_AND_CONTENT_TITLE_MANDATORY_FIELD_BLANK);
		logger.log(LogStatus.INFO, "Content Title is optional fields now so above TC is de-scoped");
		
		//Level Title and Content Title are blank: De-scoped
		product.getSchoolLOBAndStructure();
		product.productTOCIngestionValidatonCheck(LOMTConstant.TC_31, logger); 
		
		logger.log(LogStatus.SKIP, TestCases.TC_LOMT_1039_31_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_TITLE_AND_CONTENT_TITLE_MANDATORY_FIELD_BLANK);
		logger.log(LogStatus.INFO, "Content Title is optional fields now so above TC is de-scoped");
		
		//Content Title has correct value while AlignmentCode has wrong value
		product.getSchoolLOBAndStructure();
		product.productTOCIngestionValidatonCheck(LOMTConstant.TC_32, logger); 
		
		logger.log(LogStatus.SKIP, TestCases.TC_LOMT_1039_32_PRODUCTTOC_ADMIN_MANAGE_INGESTION_CONTENT_TITLE_CORRECT_VAL_AND_ALIGNMENTCODE_WRONG_VAL_FIELD);
		logger.log(LogStatus.INFO, "Content Title is optional fields now so above TC is de-scoped");
		
		//Level Title has correct value while CMT Intermediary Unique has wrong value
		product.getSchoolLOBAndStructure();
		product.productTOCWithoutMetaData();
		product.productTOCIngestionValidatonCheck(LOMTConstant.TC_33, logger);*/  
		
		//product.getHomePage();
		product.getSchoolBrowsePage();
		// verify ingested data
		product.verifyProductTOCIngestedDataOnResultPage(LOMTConstant.SCHOOL, LOMTConstant.PRODUCT_TOC_XLS_FILE_PATH_1, logger);
		product.verifyProductTOCIngestedDataOnResultPage(LOMTConstant.SCHOOL, LOMTConstant.PRODUCT_TOC_XLS_FILE_PATH_2, logger);
		product.verifyProductTOCIngestedDataOnResultPage(LOMTConstant.SCHOOL, LOMTConstant.PRODUCT_TOC_XLS_FILE_PATH_3, logger);
		product.verifyProductTOCIngestedDataOnResultPage(LOMTConstant.SCHOOL, LOMTConstant.PRODUCT_TOC_XLS_FILE_PATH_4, logger);
		product.verifyProductTOCIngestedDataOnResultPage(LOMTConstant.SCHOOL, LOMTConstant.PRODUCT_TOC_XLS_FILE_PATH_5, logger);
		
		product.getHomePage();
		
		logger.log(LogStatus.INFO, LOMTConstant.LOMT_1039+LOMTConstant.COMMA+LOMTConstant.EMPTY_SPACE
				+LOMTConstant.PRODUCT_TOC_SCHOOL_TC_COUNT+LOMTConstant.HAS_PASSED);
		
		reports.endTest(logger);
		reports.flush();
	}
	
	/*//English Product TOC
	@Test(priority = 2)
	public void productTOCIngestionEnglish() {
		logger = reports.startTest(LOMTConstant.ENGLISH_LOB + LOMTConstant.EMPTY_SPACE+ LOMTConstant.PRODUCT_TOC_INGESTION,
				LOMTConstant.LOMT_1040 + LOMTConstant.COMMA+ LOMTConstant.EMPTY_SPACE+ LOMTConstant.ENGLISH_TC_COUNT_PRODUCT_TOC);

		logger.log(LogStatus.PASS,TestCases.TC_LOMT_1040_01_SME_OR_COORDINATOR_OR_BASIC_BROWSER_CANNOT_INGEST);

		product.englishBrowsePage(logger);
		product.createUploadStructurePage(logger);
		product.backLinkClicked(logger);
		product.getEnglishLOBAndStructure();
		
		product.productTOCIngestion(LOMTConstant.TC_CASE_7_8_9_10_11, logger);
		
		product.getEnglishLOBAndStructure();
		product.productTOCIngestion(LOMTConstant.TC_12, logger);
		
		product.getEnglishLOBAndStructure();
		product.productTOCIngestion(LOMTConstant.TC_14, logger);

		product.getEnglishLOBAndStructure();
		product.productTOCIngestion(LOMTConstant.TC_15, logger);
		
		product.getEnglishLOBAndStructure();
		product.productTOCIngestion(LOMTConstant.TC_16, logger);
		
		product.getEnglishLOBAndStructure();
		product.productTOCIngestion(LOMTConstant.TC_17, logger);
		
		product.getEnglishLOBAndStructure();
		product.productTOCIngestion(LOMTConstant.TC_21, logger);
		
		product.getEnglishLOBAndStructure();
		product.productTOCIngestion(LOMTConstant.TC_19, logger); 
		
		product.getEnglishLOBAndStructure();
		product.productTOCIngestion(LOMTConstant.TC_23, logger); 
		
		product.getEnglishLOBAndStructure();
		product.productTOCIngestionWithInvalidFormatFile(logger);
		
		product.productTOCIngestion(LOMTConstant.TC_VALIDATION_CHECK_22_23, logger); 
		
		product.getHomePage();

		logger.log(LogStatus.INFO, LOMTConstant.LOMT_1040 + LOMTConstant.COMMA+ LOMTConstant.EMPTY_SPACE + "Total 26 TCs"
				+ LOMTConstant.HAS_PASSED);

		reports.endTest(logger);
		reports.flush();
	}
	
	// HE Product TOC
	@Test(priority = 3)
	public void productTOCIngestionHigherEducation() {
		logger = reports.startTest(LOMTConstant.HE_LOB + LOMTConstant.EMPTY_SPACE + LOMTConstant.PRODUCT_TOC_INGESTION,
				LOMTConstant.LOMT_1041 + LOMTConstant.COMMA + LOMTConstant.EMPTY_SPACE
						+ LOMTConstant.HE_TC_COUNT_PRODUCT_TOC);

		logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_01_SME_OR_COORDINATOR_OR_BASIC_BROWSER_CANNOT_INGEST);

		product.heBrowsePage(logger);
		product.createUploadStructurePage(logger);
		product.backLinkClicked(logger);
		product.getHELOBAndStructure();
		
		product.productTOCIngestion(LOMTConstant.TC_CASE_7_8_9_10_11, logger);
		
		product.getHELOBAndStructure();
		product.productTOCIngestion(LOMTConstant.TC_12, logger);	
		
		product.getHELOBAndStructure();
		product.productTOCIngestion(LOMTConstant.TC_14, logger);
		
		product.getHELOBAndStructure();
		product.productTOCIngestion(LOMTConstant.TC_16, logger); // duplicate value
		
		product.getHELOBAndStructure();
		product.productTOCIngestion(LOMTConstant.TC_17, logger); // alignment code
		
		product.getHELOBAndStructure();
		product.productTOCIngestion(LOMTConstant.TC_18_EO, logger); // alignment code
		
		product.getHELOBAndStructure();
		product.productTOCIngestionWithInvalidFormatFile(logger);
		
		product.productTOCIngestion(LOMTConstant.TC_VALIDATION_CHECK_22_23, logger); 
		
		product.getHomePage();

		logger.log(LogStatus.INFO, LOMTConstant.LOMT_1041 + LOMTConstant.COMMA + LOMTConstant.EMPTY_SPACE
				+ "Total 27 TCs" + LOMTConstant.HAS_PASSED);

		reports.endTest(logger);
		reports.flush();
	}*/

	@Test(priority = 2)
	public void tearDown() {
		product.closeDriverInstance();
	}

}
