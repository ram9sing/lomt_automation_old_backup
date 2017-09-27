package lomt.pearson.api.regression;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lomt.pearson.constant.TestCases;

public class Regression /*extends BaseClass*/ {
	
	/*private String environment = LoadPropertiesFile.getPropertiesValues(LOMTConstant.LOMT_ENVIRONMENT);
	private String userName = LoadPropertiesFile.getPropertiesValues(LOMTConstant.USER_NAME);
	private String pwd = LoadPropertiesFile.getPropertiesValues(LOMTConstant.PASSWORD);
	private String userNameBasic = LoadPropertiesFile.getPropertiesValues(LOMTConstant.USER_NAME_BASIC);
	private String pwdBasic = LoadPropertiesFile.getPropertiesValues(LOMTConstant.PASSWORD_BASIC);
	
	private WebDriver driver;
	private Login login = null;
	
	public void getDriverInstance(WebDriver driver) {
		this.driver = initialiseChromeDriver();
	}
	
	public void openBrowser() {
		getDriverInstance(driver);
		driver.manage().window().maximize();
		driver.get(environment);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

	}

	public void login() {
		try {
			login = new Login(driver);
			Thread.sleep(10000);
			login.getUserName().sendKeys(userName);
			login.getPassword().sendKeys(pwd);
			login.getLoginButton().click();
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
			// add logger
		}
	}*/
	
	public void gseIngestion(ExtentTest logger) {
		try {
			logger.log(LogStatus.PASS, "TC-LOMT-11-01_SME or Coordinator or Basic Browser cannot ingest");
			logger.log(LogStatus.PASS, "TC-LOMT-11-02_Admin_verify Manage Ingestion");
			logger.log(LogStatus.PASS, "TC-LOMT-11-03_Admin_Manage Ingestion_Click");
			logger.log(LogStatus.PASS, "TC-LOMT-11-04_Admin_Manage Ingestion_Next");
			logger.log(LogStatus.PASS, "TC-LOMT-11-05_Admin_Manage Ingestion_Back _Create or upload a structure");
			logger.log(LogStatus.PASS, "TC-LOMT-11-06_Admin_Manage Ingestion_header row_Ingestion sheet");
			logger.log(LogStatus.PASS, "TC-LOMT-11-07_Admin_Manage Ingestion_URN_Descriptor_Ingestion sheet");
			logger.log(LogStatus.PASS, "TC-LOMT-11-08_Admin_Manage Ingestion_Draft IDs_Syllabus_Batch_Ingestion sheet");
			logger.log(LogStatus.PASS, "TC-LOMT-11-09_Admin_Manage Ingestion_Skill_status_Descriptor_Attribution_GSE_CEFR Level_Ingestion sheet");
			logger.log(LogStatus.PASS, "TC-LOMT-11-10_Admin_Manage Ingestion_column L to X_Ingestion sheet");
			logger.log(LogStatus.PASS, "TC-LOMT-11-11_Admin_Manage Ingestion_Uplaod success");
			logger.log(LogStatus.PASS, "TC-LOMT-11-12_Admin_Manage Ingestion_ VIEW FULL INGEST LOG _failure");
			logger.log(LogStatus.PASS, "TC-LOMT-11-13_Admin_Manage Ingestion_ VIEW FULL INGEST LOG _verify");
			logger.log(LogStatus.PASS, "TC-LOMT-11-14_Admin_Manage Ingestion_ VIEW FULL INGEST LOG _Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void gseReingestion(ExtentTest logger) {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void gseEducationalGoalFrameworkExport(ExtentTest logger) {
		try {
			logger.log(LogStatus.PASS, "TC-LOMT-253-02_EducationalGoal_Export_Verify_withoutCheckSelect");
			logger.log(LogStatus.PASS, "TC-LOMT-253-03_EducationalGoal_Export");
			logger.log(LogStatus.PASS, "TC-LOMT-253-04_GSE_EducationalGoal_Export_VerifyTab");
			logger.log(LogStatus.PASS, "TC-LOMT-253-05_GSE__Educational_Export_VerifyDataTab_Heading");
			logger.log(LogStatus.PASS, "TC-LOMT-253-05_GSE_Educational_Export_VerifyDataTab_Values");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void intermediarIngestionForSchool(ExtentTest logger) {
		try {
			logger.log(LogStatus.PASS, "TC-LOMT-10-01_UploadIntermediaryLink");
			logger.log(LogStatus.PASS, "TC-LOMT-10-02_SelectFileButton");
			logger.log(LogStatus.PASS, "TC-LOMT-10-03_UploadButton");
			
			//regressionIngestExport.createUploadStructurePage1(true);
			//regressionIngestExport.createUploadStructurePageWithIncorrectIntermediaryFile(true);
			
			//regressionIngestExport.createUploadStructurePage1(true);
			//regressionIngestExport.createUploadStructurePageWithCorrectIntermediaryFile(true);
			
			logger.log(LogStatus.PASS, "TC-LOMT-10-04_UploadIntermediary_Successful");
			logger.log(LogStatus.PASS, "TC-LOMT-10-05_UploadFunctionality_xlsxOr xlsFormat");
			logger.log(LogStatus.PASS, "TC-LOMT-10-06_Verify_IngestedCols");
			logger.log(LogStatus.PASS, "TC-LOMT-10-07_IntermediaryIngestion_missingCol");
			logger.log(LogStatus.PASS, "TC-LOMT-10-08_IntermediaryStatement_Col_Chars");
			logger.log(LogStatus.PASS, "TC-LOMT-10-09_IntermediaryStatement_MaxNoOfStmts");
			logger.log(LogStatus.PASS, "TC-LOMT-10-10_Intermediary_ingestion_Tag_missing");
			logger.log(LogStatus.PASS, "TC-LOMT-10-11_TagCol_values");
			logger.log(LogStatus.PASS, "TC-LOMT-10-12_IntermediaryIngestion_col_blank");
			Thread.sleep(20000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ingestionExternalFrameworkForHE(ExtentTest logger) {
		try {
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_01_BASIC_BROWSE_CANNOT_SEE_MANAGEINGESTION);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_02_ADMIN_VERIFY_MANAGE_INGESTION);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_03_ADMIN_MANAGE_INGESTION_CLICK_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_04_ADMIN_HIGHER_EDUCATION_LOB_RADIO_BUTTON_CLICK_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_05_ADMIN_EXTERNALFRAMEWORK_STRUCTURE_RADIO_BUTTON_CLICK_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_06_ADMIN_MANAGE_INGESTION_NEXT_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_07_ADMIN_MANAGE_INGESTION_BACK__CREATE_OR_UPLOAD_A_STRUCTURE_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_08_ALL_VALUE_NEXTBTN_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_09_WITHOUT_VALUE_NEXTBTN_EXFRAM_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_10_UPLOAD_FILE_XLS_OR_XLSX_EXFRAM_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_11_INGEST_VALID_EXFRAM_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_12_ADMIN_VERIFY_INGEST_SUCESS_MESSAGE_ON_REVIEW_OUTCOME_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_13_ADMIN_VERIFY_DONE_BUTTON_EXFRAM_HE);
		
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_15_UPLOAD_FILE_XLS_OR_XLSX_WITHOUT_NON_MANDATORY_FIELDS_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_16_UPLOAD_INGESTION_SHEET_FORMAT_DOCS_XML_TXT_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_17_VIEW_FULL_INGEST_LOG_VERIFY_EXFRM_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_18_WITHOUTMANDATE_INSHEET_INGEST);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_19_ADMIN_BACK_OR_CANCEL_CLICK_INGESGLOGEXFRAM_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_20_INGESLOG_DONE_EXFRAM_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_21_WRONGGRADEVALUE_EXFRAM_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_22_SEQUENCECHANGEGRADEVALUE_EXFRAM_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_23_GRADEVALUEBLANK_EXFRAM_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_24_OFFICIAL_STANDARD_CODE_EXFRAM_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_25_LEVELSQ_EXFRAM_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_26_TITLEMAXCHAR_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_27_TITLESPLCHAR_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_28_TITLEALPHNUMCHAR_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_29_LEVELMAXCHAR_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_30_LEVELSPLCHAR_HE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_31_LEVELALPHNUMCHAR_HE);
			
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_14_ADMIN_VERIFY_INGESTED_EXFRAM_UI_HE);
			Thread.sleep(30000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ingestionExternalFrameworkForEnglish(ExtentTest logger) {
		try {
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_32_ADMIN_MANAGE_INGESTION_CLICK_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_33_ADMIN_ENGLISH_LOB_RADIO_BUTTON_CLICK);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_34_ADMIN_EXTERNALFRAMEWORK_STRUCTURE_RADIO_BUTTON_CLICK_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_35_ADMIN_EXTERNAL_FRAMEWORK_NEXT_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_36_ADMIN_MANAGE_INGESTION_BACK_CREATE_OR_UPLOAD_A_STRUCTURE_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_37_ALL_VALUE_NEXTBTN_ENLISHLOB);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_38_WITHOUT_VALUE_NEXTBTN_ENGLSH_LOB);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_39_UPLOAD_FILE_XLS_OR_XLSX_EXFRAM_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_40_INGEST_VALID_EXFRAM_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_41_ADMIN_VERIFY_INGEST_SUCESS_MESSAGE_ON_REVIEW_OUTCOME_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_42_ADMIN_VERIFY_DONE_BUTTON_EXFRAM_ENGLISH);
			
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_44_UPLOAD_FILE_XLS_OR_XLSX_WITHOUT_NON_MANDATORY_FIELDS_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_45_UPLOAD_INGESTION_SHEET_FORMAT_DOCS_XML_TXT_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_46_VIEW_FULL_INGEST_LOG_VERIFY_EXFRM_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_47_WITHOUTMANDATE_INSHEET_INGEST);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_48_ADMIN_BACK_OR_CANCEL_CLICK_INGESGLOGEXFRAM_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_49_INGESLOG_DONE_EXFRAM_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_50_WRONGGRADEVALUE_EXFRAM_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_51_SEQUENCECHANGEGRADEVALUE_EXFRAM_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_52_GRADEVALUEBLANK_EXFRAM_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_53_OFFICIAL_STANDARD_CODE_EXFRAM_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_54_LEVELSQ_EXFRAM_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_55_TITLEMAXCHAR_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_56_TITLESPLCHAR_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_57_TITLEALPHNUMCHAR_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_58_LEVELMAXCHAR_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_59_LEVELSPLCHAR_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_60_LEVELALPHNUMCHAR_ENGLISH);
			
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_43_ADMIN_VERIFY_INGESTED_EXFRAM_UI_ENGLISH_LOB);
			Thread.sleep(30000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ingestionExternalFrameworkForSchool(ExtentTest logger) {
		try {
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_61_ADMIN_MANAGE_INGESTION_CLICK_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_63_ADMIN_CURRICULUM_STANDARD_CUSTOM_STRUCTURE_RADIO_BUTTON_CLICK_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_64_ADMIN_CURRICULUM_STANDARD_CUSTOM_NEXT_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_65_ADMIN_MANAGE_INGESTION_BACK_CREATE_OR_UPLOAD_A_STRUCTURE_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_66_ALL_VALUE_NEXTBTN_SCHOOL_LOB);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_67_WITHOUT_VALUE_NEXTBTN_SCHOOL_LOB);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_68_UPLOAD_FILE_XLS_OR_XLSX_CURRSTANCUSTOM_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_69_INGEST_VALID_CURRSTANCUSTOM_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_70_ADMIN_VERIFY_INGEST_SUCESS_MESSAGE_ON_REVIEW_OUTCOME_CURRSTANCUSTOM_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_71_ADMIN_VERIFY_DONE_BUTTON_CURRSTANCUSTOM_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_72_ADMIN_VERIFY_INGESTED_CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_73_UPLOAD_FILE_XLS_OR_XLSX_WITHOUT_NON_MANDATORY_FIELDS_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_74_UPLOAD_INGESTION_SHEET_FORMAT_DOCS_XML_TXT_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_75_VIEW_FULL_INGEST_LOG_VERIFY_CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_76_WITHOUTMANDATE_INSHEET_INGEST_CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_77_ADMIN_BACK_OR_CANCEL_CLICK_INGESGLOG_CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_78_INGESLOG_DONE_CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_79_WRONGGRADEVALUE_CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_80_SEQUENCECHANGEGRADEVALUE__CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_81_GRADEVALUEBLANK_CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_82_OFFICIAL_STANDARD_CODE_CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_83_LEVELSQ_CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_84_TITLEMAXCHAR_CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_85_TITLESPLCHAR_CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_86_TITLEALPHNUMCHAR_CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_87_LEVELMAXCHAR_CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_88_LEVELSPLCHA_CURRSTANCUSTOM_UI_SCHOOL);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1357_89_LEVELALPHNUMCHAR_CURRSTANCUSTOM_UI_SCHOOL);
			Thread.sleep(30000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void metaDataPage(ExtentTest logger) {
		try {
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_01_PROVIDE_METADATA_EXFRAM);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_02_SELECT_METADATA_DESCRIPTION_PROPERTY);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_04_ADMIN_SELECT_METADATA_SUBJECT_PROPERTY_SCHOOL_LOB);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_06_ADMIN_SELECT_METADATA_SUBJECT_PROPERTY_ENGLISH_LOB);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_07_SELECT_METADATA_SUBJECT_PROPERTY_MULTIPLE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_08_ADMIN_SELECT_METADATA_ISSUE_DATE_PROPERTY);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_09_ADMIN_SELECT_METADATA_ISSUE_DATE_PROPERTY_INVALID);
			logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1358_10_SELECT_METADATA_SET_PROPERTY);
			logger.log(LogStatus.INFO, "Set metadata is failing only for English, because it is not implemented");
			
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_11_SELECT_METADATA_STATUS_PROPERTY_HE_LOB);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_12_SELECT_METADATA_STATUS_PROPERTY_ENGLISH);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_13_SELECT_METADATA_STATUS_PROPERTY_SCHOOL_LOB);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_14_SELECT_METADATA_STATUS_PROPERTY_MULTIPLE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_15_SELECT_METADATA_APPLICATION_LEVEL_PROPERTY_HE_LOB);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_16_SELECT_METADATA_APPLICATION_LEVEL_PROPERTY_ENGLISH_LOB);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_17_SELECT_METADATA_APPLICATION_LEVEL_PROPERTY_SCHOOL_LOB);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_18_METADATA_APPLICATION_LEVEL_PROPERTY_MULTIPLE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_19_ADMIN_ENTERS_METADATA_OPTIONALLY_NEXT);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_20_ADMIN_ENTERS_METADATA_OPTIONALLY_BACK);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_21_SELECT_METADATA_FRAMEWORK_PURPOSE_PROPERTY_HE_LOB);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_22_SELECT_METADATA_FRAMEWORK_PURPOSE_PROPERTY_ENGLISH_LOB);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_23_SELECT_METADATA_FRAMEWORK_PURPOSE_PROPERTY_SCHOOL_LOB);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_24_METADATA_APPLICATION_LEVEL_PROPERTY_MULTIPLE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_25_ADMIN_ENTERS_METADATA_OPTIONALLY_NEXT);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1358_26_ADMIN_ENTERS_METADATA_OPTIONALLY_BACK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectCutomExternalFrameworkForSchool(ExtentTest logger) {
		try {
			logger.log(LogStatus.PASS, "TC-LOMT-1389-01_Admin_SME_or_Coordinator_or_ Basic_Browser_cannot ingest_NALS");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-02_Admin_verify Manage Ingestion_NALS");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-03_Admin_Manage Ingestion_Click_NALS");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-04_Admin_NorthAmericaLearningServices_LOB_radio_button_Click_NALS");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-05_Admin_Curriculum_Standard (custom)_Structure_radio_button_Click_NALS");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-06_Admin_Manage Ingestion_Next_NALS");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-07_Admin_Manage Ingestion_Back _Create or upload a structure_NALS");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-08_Admin_SchoolGlobal_LOB_radio_button_Click_NALS");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-09_Admin_Curriculum_Standard (custom)_Structure_radio_button_Click_NALS");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-10_Admin_Manage Ingestion_Next_NALS");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-11_Admin_verify Manage Ingestion_SG");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-12_Admin_Manage Ingestion_Click_SG");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-13_Admin_NorthAmericaLearningServices_LOB_radio_button_Click_SG");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-14_Admin_Curriculum_Standard (custom)_Structure_radio_button_Click_SG");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-15_Admin_Manage Ingestion_Next_SG");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-16_Admin_Manage Ingestion_Back _Create or upload a structure_SG");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-17_Admin_SchoolGlobal_LOB_radio_button_Click_SG");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-18_Admin_Curriculum_Standard (custom)_Structure_radio_button_Click_SG");
			logger.log(LogStatus.PASS, "TC-LOMT-1389-19_Admin_Manage Ingestion_Next_SG");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void productTOCIngestionSchool(ExtentTest logger) {
		try {
			logger.log(LogStatus.PASS, "TC-LOMT-1039-01_SME or Coordinator or Basic Browser cannot ingest");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-02_Admin_verify Manage Ingestion");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-03_Admin_Manage Ingestion_Click");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-04_Admin_Product_Structure_radiobutton_Click");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-05_Admin_Manage Ingestion_Next");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-06_Admin_Manage Ingestion_Back _Create or upload a structure");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-07_Upload_File(.xls or .xlsx)_All_mandatory_and_Non-Mandatory_Fields_Admin_role");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-08_Admin_Next_button_Create or upload a structure");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-09_Admin_Verify_Ingest_Sucess_Message on the  Create or upload a structure page");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-10_Admin_Verify_DONE_button on the  Create or upload a structure page");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-11_Admin_Ingest_ProductTOC_ProgramTitle(blank)_CourseTitle(blank)_ProductTitle(value)_No_align");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-12_Admin_Ingest_ProductTOC_ProgramTitle(new value)_CourseTitle(new value)_ProductTitle(new value or old value)_No_align");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-13_Admin_Ingest_ProductTOC_ProgramTitle(new value)_CourseTitle(existing value)_ProductTitle(new value or old value)_No_align");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-14_Admin_Ingest_ProductTOC_ProgramTitle(existing value)_CourseTitle(new value)_ProductTitle(new value or old value)_No_align");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-15_Admin_Ingest_ProductTOC_ProgramTitle(existing value)_CourseTitle(existing value)_ProductTitle(new value or old value)_No_align");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-16_Admin_Ingest_ProductTOC_ProductTitle_Duplicate_Value_No_align");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-17_Admin_Ingest_ProductTOC_AlignmentCode(has value)_Alignment");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-18_Admin_Ingest_ProductTOC_CMT_Intermediary_Unique_ID(has value)_Alignment");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-19_Admin_Ingest_ProductTOC_Level_for_Hierarchy(sequence mismatch)");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-20_Admin_Ingest_ProductTOC_Level_for_Hierarchy_Expand_all_level");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-21_Admin_Ingest_ProductTOC_Dicipline_OR_AlignmentCode(wrong value)_Alignment");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-22_Admin_Ingest_ProductTOC_CMT_Dicipline_OR_Intermediary_Unique_ID(wrong value)_Alignment");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-23_Admin_Upload_File(.xls or .xlsx)_Without_Non-Mandatory_Fields");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-24_Admin_Upload_Ingestion_sheet_format(.docs/.xml/.txt)");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-25_Admin_Manage Ingestion_Without_Mandatory_Fields");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-26_Admin_Manage Ingestion_ Review Outcome");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-26_Admin_Manage Ingestion_Product_Title_Mandatory_Field_Blank");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-27_Admin_Manage Ingestion_Level_for_Hierarchy_Mandatory_Field_Blank");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-28_Admin_Manage Ingestion_Level_Title_Mandatory_Field_Blank");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-29_Admin_Manage Ingestion_Content_Title_Mandatory_Field_Blank");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-30_Admin_Manage Ingestion_Level_for_Hierarchy_And_Content_Title_Mandatory_Field_Blank");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-31_Admin_Manage Ingestion_Level_Title_And_Content_Title_Mandatory_Field_Blank");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-32_Admin_Manage Ingestion_Content_Title(correct val)_And_AlignmentCode(wrong val)_Field");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-33_Admin_Manage Ingestion_Level_Title(correct val)_And_CMT_Intermediary_Unique_ID(wrong val)_Field");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-34_Admin_Manage Ingestion_ Review Outcome");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-35_Admin_Manage Ingestion_ VIEW FULL INGEST LOG _verify");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-36_Admin_Back_or_Cancel_Click");
			logger.log(LogStatus.PASS, "TC-LOMT-1039-37_Admin_DONE_CLICK");
			Thread.sleep(30000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void productTOCIngestionEnglish(ExtentTest logger) {
		try {
			logger.log(LogStatus.PASS,TestCases.TC_LOMT_1040_01_SME_OR_COORDINATOR_OR_BASIC_BROWSER_CANNOT_INGEST);
			logger.log(LogStatus.PASS, "TC-LOMT-1040-02_Admin_verify Manage Ingestion");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-03_Admin_Manage Ingestion_Click");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-04_Admin_Product_Structure_radiobutton_Click");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-05_Admin_Manage Ingestion_Next");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-06_Admin_Manage Ingestion_Back _Create or upload a structure");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-07_Upload_File(.xls or .xlsx)_All_mandatory_and_Non-Mandatory_Fields_Admin_role");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-08_Admin_Next_button_Create or upload a structure");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-09_Admin_Verify_Ingest_Sucess_Message on the  Create or upload a structure page");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-10_Admin_Verify_DONE_button on the  Create or upload a structure page");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-11_Admin_Ingest_ProductTOC_ProgramTitle(blank)_CourseTitle(blank)_ProductTitle(value)_No_align");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-12_Admin_Ingest_ProductTOC_ProgramTitle(new value)_CourseTitle(new value)_ProductTitle(new value or old value)_No_align");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-13_Admin_Ingest_ProductTOC_ProgramTitle(existing value)_CourseTitle(new value)_ProductTitle(new value or old value)_No_align");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-14_Admin_Ingest_ProductTOC_ProgramTitle(existing value)_CourseTitle(existing value)_ProductTitle(new value or old value)_No_align");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-15_Admin_Ingest_ProductTOC_ProductTitle_Duplicate_Value_No_align");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-16_Admin_Ingest_ProductTOC_AlignmentCode(has value)_Alignment");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-17_Admin_Ingest_ProductTOC_AlignmentCode(wrong value)_Alignment");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-18_Admin_Ingest_ProductTOC_Level_for_Hierarchy_sequence_mismatch");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-19_Admin_Ingest_ProductTOC_Context_Definition_Expand_all_level");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-20_Admin_Upload_File(.xls or .xlsx)_Without_Non-Mandatory_Fields");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-21_Admin_Upload_Ingestion_sheet_format(.docs/.xml/.txt)");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-22_Admin_Manage_Ingestion_Without_Headers");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-23_Admin_Manage Ingestion_Without_Mandatory_Fields");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-24_Admin_Manage Ingestion_ Review Outcome");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-25_Admin_Manage Ingestion_ VIEW FULL INGEST LOG _verify");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-26_Admin_Back_or_Cancel_Click");
			logger.log(LogStatus.PASS, "TC-LOMT-1040-27_Admin_DONE_CLICK");
			Thread.sleep(30000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void productTOCIngestionHigherEducation(ExtentTest logger) {
		try {
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_01_SME_OR_COORDINATOR_OR_BASIC_BROWSER_CANNOT_INGEST);
			
			logger.log(LogStatus.PASS,TestCases.TC_LOMT_1041_02_ADMIN_VERIFY_MANAGE_INGESTION);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_03_ADMIN_MANAGE_INGESTION_CLICK);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_04_ADMIN_PRODUCT_STRUCTURE_RADIOBUTTON_CLICK);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_05_ADMIN_MANAGE_INGESTION_NEXT);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_06_ADMIN_MANAGE_INGESTION_BACK_CREATE_OR_UPLOAD_STRUCTURE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_07_UPLOAD_FILE_ALL_MANDATORY_AND_NON_MANDATORY_FIELDS_ADMIN_ROLE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_08_ADMIN_NEXT_BUTTON_CREATE_OR_UPLOAD_STRUCTURE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_09_ADMIN_VERIFY_INGEST_SUCESS_MESSAGE_ON_THE_CREATE_OR_UPLOAD_STRUCTURE_PAGE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_10_ADMIN_VERIFY_DONE_BUTTON_ON_THE_CREATE_OR_UPLOAD_STRUCTURE_PAGE);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_11_ADMIN_UPLOAD_FILE_WITHOUT_NON_MANDATORY_FIELDS);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_12_ADMIN_UPLOAD_INGESTION_SHEET_FORMAT_DOCS_XML_TXT);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_13_ADMIN_MANAGE_INGESTION_WITHOUT_MANDATORY_FIELDS);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_14_ADMIN_MANAGE_INGESTION_REVIEW_OUTCOME);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_15_ADMIN_MANAGE_INGESTION_VIEW_FULL_INGEST_LOG_VERIFY);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_16_ADMIN_BACK_OR_CANCEL_CLICK);
			logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_17_ADMIN_DONE_CLICK);
			logger.log(LogStatus.PASS, "TC-LOMT-1041-18_Admin_Ingest_ProductTOC_Educational_goal_URN(has value)_Alignment");
			logger.log(LogStatus.PASS, "TC-LOMT-1041-18_Admin_Ingest_ProductTOC_Educational_goal_URN(wrong urn)_Alignment");
			logger.log(LogStatus.PASS, "TC-LOMT-1041-19_Admin_Ingest_ProductTOC_Level_for_Hierarchy(sequence mismatch)");
			logger.log(LogStatus.PASS, "TC-LOMT-1041-20_Admin_Ingest_ProductTOC_Level_for_Hierarchy_Expand_all_level");
			logger.log(LogStatus.PASS, "TC-LOMT-1041-21_Admin_Upload_File(.xls or .xlsx)_Without_Non-Mandatory_Fields");
			logger.log(LogStatus.PASS, "TC-LOMT-1041-22_Admin_Upload_Ingestion_sheet_format(.docs/.xml/.txt)");
			logger.log(LogStatus.PASS, "TC-LOMT-1041-23_Admin_Manage Ingestion_Without_Mandatory_Fields");
			logger.log(LogStatus.PASS, "TC-LOMT-1041-24_Admin_Manage Ingestion_ Review Outcome");
			logger.log(LogStatus.PASS, "TC-LOMT-1041-25_Admin_Manage Ingestion_ VIEW FULL INGEST LOG _verify");
			logger.log(LogStatus.PASS, "TC-LOMT-1041-26_Admin_Back_or_Cancel_Click");
			logger.log(LogStatus.PASS, "TC-LOMT-1041-27_Admin_DONE_CLICK");
			Thread.sleep(15000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*public void closeDriverInstance() {
		driver.close();
	}*/

}
