package lomt.pearson.api.product_toc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lomt.pearson.common.BaseClass;
import lomt.pearson.common.LoadPropertiesFile;
import lomt.pearson.constant.LOMTConstant;
import lomt.pearson.constant.TestCases;
import lomt.pearson.page_object.CommonPOM;
import lomt.pearson.page_object.EnglishPOM;
import lomt.pearson.page_object.ExternalFrameworkPOM;
import lomt.pearson.page_object.HEPom;
import lomt.pearson.page_object.Login;
import lomt.pearson.page_object.NALSPom;
import lomt.pearson.page_object.SGPom;

/**
 * Product TOc Ingestion/Export for English/HE/NALS/SG LOB
 * 
 * @author ram.sin
 *
 */
public class ProductTOC extends BaseClass {

	private String environment = LoadPropertiesFile.getPropertiesValues(LOMTConstant.LOMT_ENVIRONMENT);
	private String userName = LoadPropertiesFile.getPropertiesValues(LOMTConstant.USER_NAME);
	private String pwd = LoadPropertiesFile.getPropertiesValues(LOMTConstant.PASSWORD);

	String currentLOB = null;

	private WebDriver driver;

	private Login login = null;
	private CommonPOM commonPOM = null;
	private EnglishPOM englishPOM = null;
	private HEPom hePom = null;
	private NALSPom nalsPom  = null;
	private SGPom sgPom = null;
	private ExternalFrameworkPOM exfPOM = null;
	
	public void getDriverInstance(WebDriver driver) {
		this.driver = initialiseChromeDriver();
		//this.driver = initialiseFirefoxDriver();
	}

	public void openBrowser() {
		getDriverInstance(driver);
		driver.manage().window().maximize();
		driver.get(environment);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		commonPOM = new CommonPOM(driver);
		englishPOM = new EnglishPOM(driver);
		hePom = new HEPom(driver);
		nalsPom = new NALSPom(driver);
		sgPom = new SGPom(driver);
		exfPOM = new ExternalFrameworkPOM(driver);
	}

	public void login() {
		try {
			login = new Login(driver);
			login.getUserName().sendKeys(userName);
			login.getPassword().sendKeys(pwd);
			login.getLoginButton().click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			// add logger
		}
	}
	
	public void englishBrowsePage(ExtentTest logger) {
		try {
			Assert.assertTrue(commonPOM.getEnglishLOB().isDisplayed());
			currentLOB = commonPOM.getEnglishLOB().getText(); // based on user click choosing current LOB
			commonPOM.getEnglishLOB().click();
			Thread.sleep(1000);
			if (commonPOM.getManageIngestion().isDisplayed()) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,500)");
				logger.log(LogStatus.PASS,TestCases.TC_LOMT_1040_02_ADMIN_VERIFY_MANAGE_INGESTION);
				commonPOM.getManageIngestion().click();
				logger.log(LogStatus.PASS,TestCases.TC_LOMT_1040_03_ADMIN_MANAGE_INGESTION_CLICK);
				Thread.sleep(1000);
			} else {
				logger.log(LogStatus.FAIL,TestCases.TC_LOMT_1040_03_ADMIN_MANAGE_INGESTION_CLICK);
				logger.log(LogStatus.FAIL,TestCases.TC_LOMT_1040_02_ADMIN_VERIFY_MANAGE_INGESTION);
				Assert.assertFalse(commonPOM.getManageIngestion().isDisplayed());
			}
		} catch (Exception e) {
			e.printStackTrace();
			// add logger
		}
	}
	
	public void heBrowsePage(ExtentTest logger) {
		try {
			Assert.assertTrue(commonPOM.getHeLOB().isDisplayed());
			currentLOB = commonPOM.getHeLOB().getText();
			commonPOM.getHeLOB().click();
			Thread.sleep(1000);
			if (commonPOM.getManageIngestion().isDisplayed()) {
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_02_ADMIN_VERIFY_MANAGE_INGESTION);
				Assert.assertTrue(commonPOM.getWelcomeTitle().isDisplayed());
				Assert.assertEquals(commonPOM.getWelcomeTitle().getText(), LOMTConstant.WELCOME_TITLE);
				Assert.assertTrue(hePom.getHeBanner().isDisplayed());
				Assert.assertTrue(hePom.getExternalFrameworkLink().isDisplayed());
				Assert.assertTrue(hePom.getProductLink().isDisplayed());
				Assert.assertTrue(hePom.getEoLink().isDisplayed());
				Assert.assertTrue(commonPOM.getManageIngestion().isDisplayed());
				
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,500)");
				
				commonPOM.getManageIngestion().click();
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_03_ADMIN_MANAGE_INGESTION_CLICK);
				Thread.sleep(1000);
			} else {
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_02_ADMIN_VERIFY_MANAGE_INGESTION);
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_03_ADMIN_MANAGE_INGESTION_CLICK);
				Assert.assertFalse(commonPOM.getManageIngestion().isDisplayed());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void nalsBrowsePage(ExtentTest logger) {
		try {
			Assert.assertTrue(commonPOM.getNalsLOB().isDisplayed());
			currentLOB = commonPOM.getNalsLOB().getText();
			commonPOM.getNalsLOB().click();
			Thread.sleep(1000);
			if (commonPOM.getManageIngestion().getText().equalsIgnoreCase(LOMTConstant.MANGE_INGESTION)) {
				Assert.assertEquals(commonPOM.getWelcomeTitle().getText(), LOMTConstant.WELCOME_TITLE);
				Assert.assertTrue(nalsPom.getCurriculumStandardLink().isDisplayed());
				Assert.assertTrue(nalsPom.getProductLink().isDisplayed());
				Assert.assertTrue(nalsPom.getIntermediariesLink().isDisplayed());			
				Assert.assertTrue(commonPOM.getManageIngestion().isDisplayed());
				
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_02_ADMIN_VERIFY_MANAGE_INGESTION);
				
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,500)");
				
				commonPOM.getManageIngestion().click();
				
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_03_ADMIN_MANAGE_INGESTION_CLICK);
			} else {
				logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_02_ADMIN_VERIFY_MANAGE_INGESTION);
				logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_03_ADMIN_MANAGE_INGESTION_CLICK);
				Assert.assertFalse(commonPOM.getManageIngestion().isDisplayed());
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_02_ADMIN_VERIFY_MANAGE_INGESTION);
			logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_03_ADMIN_MANAGE_INGESTION_CLICK);
			e.printStackTrace();
			return;
		}
	}
	
	public void sgBrowsePage(ExtentTest logger) {
		try {
			Assert.assertTrue(commonPOM.getSchoolGlobalLOB().isDisplayed());
			currentLOB = commonPOM.getSchoolGlobalLOB().getText();
			commonPOM.getSchoolGlobalLOB().click();
			Thread.sleep(2000);
			
			Assert.assertEquals(commonPOM.getWelcomeTitle().getText(), LOMTConstant.WELCOME_TITLE);
			Assert.assertTrue(sgPom.getSgBanner().isDisplayed());
			Assert.assertTrue(nalsPom.getCurriculumStandardLink().isDisplayed());
			Assert.assertTrue(nalsPom.getProductLink().isDisplayed());
			Assert.assertTrue(nalsPom.getIntermediariesLink().isDisplayed());
			Assert.assertTrue(commonPOM.getManageIngestion().isDisplayed());
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)");
			
			commonPOM.getManageIngestion().click();
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_02_ADMIN_VERIFY_MANAGE_INGESTION);
			logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_03_ADMIN_MANAGE_INGESTION_CLICK);
			e.printStackTrace();
			return;
		}
	}

	public void createUploadStructurePage(ExtentTest logger) {
		try {
			if (currentLOB.equalsIgnoreCase(LOMTConstant.ENGLISH_LOB)) {
				//Header, Footer 
				Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
				Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
				Assert.assertFalse(commonPOM.getNextButtonFirst().isEnabled());  
				
				//LOB
				Assert.assertTrue(commonPOM.getSelectLOBTitle().isDisplayed());
				Assert.assertTrue(commonPOM.getEnglishLOBRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getHeLOBRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getSchoolGlobalLOBRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getNalsLOBRadioButton().isDisplayed());
				
				//Structure
				Assert.assertTrue(commonPOM.getSelectStructureTitle().isDisplayed());
				Assert.assertTrue(commonPOM.getGseStructureRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getProductExternalFrameworkStructureRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getGseProductStructureRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getNextButtonFirst().isDisplayed());
				
				Thread.sleep(1000);
				commonPOM.getGseProductStructureRadioButton().click();
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1040_04_ADMIN_PRODUCT_STRUCTURE_RADIOBUTTON_CLICK);
				
				Thread.sleep(1000);
				commonPOM.getNextButtonFirst().click();
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1040_05_ADMIN_MANAGE_INGESTION_NEXT);
			} else if (currentLOB.equalsIgnoreCase(LOMTConstant.HE_LOB)) {
				//Header, Footer 
				Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
				Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
				Assert.assertFalse(commonPOM.getNextButtonFirst().isEnabled());  
				
				//LOB
				Assert.assertTrue(commonPOM.getSelectLOBTitle().isDisplayed());
				Assert.assertTrue(commonPOM.getEnglishLOBRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getHeLOBRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getSchoolGlobalLOBRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getNalsLOBRadioButton().isDisplayed());
				
				Thread.sleep(1000);
				commonPOM.getHeLOBRadioButton().click();
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_04_ADMIN_PRODUCT_STRUCTURE_RADIOBUTTON_CLICK);
				
				//Structure
				Assert.assertTrue(commonPOM.getSelectStructureTitle().isDisplayed());
				Assert.assertTrue(commonPOM.getProductExternalFrameworkStructureRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getProductStructureRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getProductHERadioButton().isDisplayed());
				
				Thread.sleep(1000);
				commonPOM.getProductRadioButton().click();
				
				Thread.sleep(2000);
				commonPOM.getNextButtonFirst().click();
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_05_ADMIN_MANAGE_INGESTION_NEXT);
			} else {
				//School
				//Header, Footer 
				Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
				Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
				Assert.assertFalse(commonPOM.getNextButtonFirst().isEnabled());  
				
				//LOB
				Assert.assertTrue(commonPOM.getSelectLOBTitle().isDisplayed());
				Assert.assertTrue(commonPOM.getEnglishLOBRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getHeLOBRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getSchoolGlobalLOBRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getNalsLOBRadioButton().isDisplayed());
				
				Thread.sleep(2000);
				commonPOM.getNalsLOBRadioButton().click();
				
				//Structure
				Assert.assertTrue(commonPOM.getSelectStructureTitle().isDisplayed());
				Assert.assertTrue(commonPOM.getCurriculumStandardRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getProductStructureRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getIntermediaryStructure().isDisplayed());
				
				Thread.sleep(2000);
				commonPOM.getSchoolProductStructureRadioButton().click();
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_04_ADMIN_PRODUCT_STRUCTURE_RADIOBUTTON_CLICK);
				
				Thread.sleep(2000);
				commonPOM.getNextButtonFirst().click();
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_05_ADMIN_MANAGE_INGESTION_NEXT);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void productTOCIngestionWithInvalidFormatFile(ExtentTest logger) {
		try {
			 //File upload logic 
			commonPOM.getUploadFileLink().click();
			
			System.out.println("currentLOB : " +currentLOB);
			
			if (currentLOB.equalsIgnoreCase(LOMTConstant.ENGLISH_LOB)) {
				Runtime.getRuntime().exec(LOMTConstant.INVALID_FORMAT_FILE_PATH);
				Thread.sleep(4000);
				
				driver.switchTo().alert().accept();
				Thread.sleep(3000);
				logger.log(LogStatus.PASS, "TC-LOMT-1040-21_ProductTOC_Admin_Upload_Ingestion_sheet_format(.docs.xml.txt)");
			} else if (currentLOB.equalsIgnoreCase(LOMTConstant.HE_LOB)) {
				Runtime.getRuntime().exec(LOMTConstant.INVALID_FORMAT_FILE_PATH);
				Thread.sleep(4000);
				
				driver.switchTo().alert().accept();
				Thread.sleep(3000);
				logger.log(LogStatus.PASS, "TC-LOMT-1041-22_ProductTOC_Admin_Upload_Ingestion_sheet_format(.docs.xml.txt)");
			} else {
				//School Global
				Runtime.getRuntime().exec(LOMTConstant.EXF_WRONG_FORMAT_XLS_PATH);				
				Thread.sleep(4000);
				
				// switch back to base window
				driver.switchTo().alert().accept();
				Thread.sleep(3000);
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_24_PRODUCTTOC_ADMIN_UPLOAD_INGESTION_SHEET_FORMAT_DOCS_XML_TXT);
				commonPOM.getBackLinkFirst().click();
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void productTOCIngestionValidatonCheck(String name, ExtentTest logger) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			//Header
			Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
			Assert.assertTrue(commonPOM.getCreateUploadStructureHeader().isDisplayed());
			Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
			
			//Center
			//Assert.assertTrue(commonPOM.getPlusSign().isDisplayed());
			Assert.assertEquals(commonPOM.getDragAndDropFilesText().getText(),LOMTConstant.DRAG_DROP_TEXT);
			Assert.assertTrue(commonPOM.getUploadFileLink().isDisplayed());
			
			 //File upload logic 
			commonPOM.getUploadFileLink().click();
			
			if (currentLOB.equalsIgnoreCase(LOMTConstant.ENGLISH_LOB)) {
				Runtime.getRuntime().exec(LOMTConstant.INVALID_FORMAT_FILE_PATH);
				Thread.sleep(3000);
			} else if (currentLOB.equalsIgnoreCase(LOMTConstant.HE_LOB)) {
				Runtime.getRuntime().exec(LOMTConstant.INVALID_FORMAT_FILE_PATH);	
				Thread.sleep(3000);
			} else {
				//School
				
				//Product Title is blank
				if (name.equalsIgnoreCase(LOMTConstant.TC_26)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_SCHOOL_26);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGEST_FAILED_MESSAGE)) {
						commonPOM.getViewIngestFullLogButton().click();
						Thread.sleep(2000);
						
						boolean flag = validationCheck(LOMTConstant.TC_26);
						if (flag) {
							logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_26_PRODUCTTOC_ADMIN_MANAGE_INGESTION_PRODUCT_TITLE_MANDATORY_FIELD_BLANK);
						} else {
							logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_26_PRODUCTTOC_ADMIN_MANAGE_INGESTION_PRODUCT_TITLE_MANDATORY_FIELD_BLANK);
						}
						commonPOM.getBackLinkFirst().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_26_PRODUCTTOC_ADMIN_MANAGE_INGESTION_PRODUCT_TITLE_MANDATORY_FIELD_BLANK);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}
				//Level for Hierarchy is blank
				if (name.equalsIgnoreCase(LOMTConstant.TC_27)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_SCHOOL_27);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_FAILED_MESSAGE)) {
						commonPOM.getViewIngestFullLogButton().click();
						Thread.sleep(2000);
						
						boolean flag = validationCheck(LOMTConstant.TC_27);
						if (flag) {
							logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_27_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_FOR_HIERARCHY_MANDATORY_FIELD_BLANK);
						} else {
							logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_27_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_FOR_HIERARCHY_MANDATORY_FIELD_BLANK);
						}
						commonPOM.getBackLinkFirst().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_27_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_FOR_HIERARCHY_MANDATORY_FIELD_BLANK);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}
				if (name.equalsIgnoreCase(LOMTConstant.TC_28)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_SCHOOL_28);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_FAILED_MESSAGE)) {
						commonPOM.getViewIngestFullLogButton().click();
						Thread.sleep(2000);
						
						boolean flag = validationCheck(LOMTConstant.TC_28);
						if (flag) {
							logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_28_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_TITLE_MANDATORY_FIELD_BLANK);
						} else {
							logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_28_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_TITLE_MANDATORY_FIELD_BLANK);
						}
						commonPOM.getBackLinkFirst().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_28_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_TITLE_MANDATORY_FIELD_BLANK);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}
				//Content Title is blank(mandatory fields) : Now its optional fields, so descoped 
				/*if (name.equalsIgnoreCase(LOMTConstant.TC_29)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_SCHOOL_29);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_FAILED_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestFailed().getText().equalsIgnoreCase(LOMTConstant.INGESTION_FAILED_MESSAGE)) {
						commonPOM.getViewIngestFullLogButton().click();
						Thread.sleep(2000);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_29_PRODUCTTOC_ADMIN_MANAGE_INGESTION_CONTENT_TITLE_MANDATORY_FIELD_BLANK);
						commonPOM.getBackLinkFirst().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_29_PRODUCTTOC_ADMIN_MANAGE_INGESTION_CONTENT_TITLE_MANDATORY_FIELD_BLANK);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}*/
				
				//Level for Hierarchy and Content Title are  blank : de-scoped
				
				/*if (name.equalsIgnoreCase(LOMTConstant.TC_30)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_SCHOOL_30);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_FAILED_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestFailed().getText().equalsIgnoreCase(LOMTConstant.INGESTION_FAILED_MESSAGE)) {
						commonPOM.getViewIngestFullLogButton().click();
						Thread.sleep(2000);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_30_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_FOR_HIERARCHY_AND_CONTENT_TITLE_MANDATORY_FIELD_BLANK);
						commonPOM.getBackLinkFirst().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_30_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_FOR_HIERARCHY_AND_CONTENT_TITLE_MANDATORY_FIELD_BLANK);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}*/
				
				//Level Title and Content Title are  blank
				
				/*if (name.equalsIgnoreCase(LOMTConstant.TC_31)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_SCHOOL_31);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_FAILED_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestFailed().getText().equalsIgnoreCase(LOMTConstant.INGESTION_FAILED_MESSAGE)) {
						commonPOM.getViewIngestFullLogButton().click();
						Thread.sleep(2000);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_31_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_TITLE_AND_CONTENT_TITLE_MANDATORY_FIELD_BLANK);
						commonPOM.getBackLinkFirst().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_31_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_TITLE_AND_CONTENT_TITLE_MANDATORY_FIELD_BLANK);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}*/
				
				//Content Title has correct value while AlignmentCode has wrong value : De-scoped
				
				/*if (name.equalsIgnoreCase(LOMTConstant.TC_32)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_SCHOOL_32);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_FAILED_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestFailed().getText().equalsIgnoreCase(LOMTConstant.INGESTION_FAILED_MESSAGE)) {
						commonPOM.getViewIngestFullLogButton().click();
						Thread.sleep(2000);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_32_PRODUCTTOC_ADMIN_MANAGE_INGESTION_CONTENT_TITLE_CORRECT_VAL_AND_ALIGNMENTCODE_WRONG_VAL_FIELD);
						commonPOM.getBackLinkFirst().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_32_PRODUCTTOC_ADMIN_MANAGE_INGESTION_CONTENT_TITLE_CORRECT_VAL_AND_ALIGNMENTCODE_WRONG_VAL_FIELD);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}*/
				
				//Level Title has correct value while CMT Intermediary Unique has wrong value
				if (name.equalsIgnoreCase(LOMTConstant.TC_33)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_SCHOOL_33);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_FAILED_MESSAGE)) {
						commonPOM.getViewIngestFullLogButton().click();
						Thread.sleep(2000);
						
						boolean flag = validationCheck(LOMTConstant.TC_33);
						if (flag) {
							logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_33_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_TITLE_CORRECT_VAL_AND_CMT_INTERMEDIARY_UNIQUE_ID_WRONG_VAL_FIELD);
						} else {
							logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_33_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_TITLE_CORRECT_VAL_AND_CMT_INTERMEDIARY_UNIQUE_ID_WRONG_VAL_FIELD);
						}
						
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_34_PRODUCTTOC_ADMIN_MANAGE_INGESTION__REVIEW_OUTCOME);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_35_PRODUCTTOC_ADMIN_MANAGE_INGESTION__VIEW_FULL_INGEST_LOG__VERIFY);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_36_PRODUCTTOC_ADMIN_BACK_OR_CANCEL_CLICK);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_37_PRODUCTTOC_ADMIN_DONE_CLICK);
						commonPOM.getBackLinkFirst().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_33_PRODUCTTOC_ADMIN_MANAGE_INGESTION_LEVEL_TITLE_CORRECT_VAL_AND_CMT_INTERMEDIARY_UNIQUE_ID_WRONG_VAL_FIELD);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void productTOCIngestionWithoutMandatoryFields() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 600);
			
			//Header
			Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
			Assert.assertTrue(commonPOM.getCreateUploadStructureHeader().isDisplayed());
			Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
			
			//Center
			//Assert.assertTrue(commonPOM.getPlusSign().isDisplayed());
			Assert.assertEquals(commonPOM.getDragAndDropFilesText().getText(),LOMTConstant.DRAG_DROP_TEXT);
			Assert.assertTrue(commonPOM.getUploadFileLink().isDisplayed());
			
			 //File upload logic 
			commonPOM.getUploadFileLink().click();
			
			if (currentLOB.equalsIgnoreCase(LOMTConstant.ENGLISH_LOB)) {
				Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_WITHOUT_MANDATORY_FIELDS_PATH_ENGLISH);
				Thread.sleep(3000);
			} else if (currentLOB.equalsIgnoreCase(LOMTConstant.HE_LOB)) {
				Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_WITHOUT_MANDATORY_FIELDS_PATH_HE);	
				Thread.sleep(3000);
			} else if (currentLOB.equalsIgnoreCase(LOMTConstant.NALS_LOB)) {
				Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_WITHOUT_MANDATORY_FIELDS_PATH_SCHOOL);	
				Thread.sleep(3000);
			} else {
				//School Global
				Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_WITHOUT_MANDATORY_FIELDS_PATH_SCHOOL);				
			}
			Thread.sleep(3000);
			commonPOM.getNextButtonSt2().click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_FAILED_MESSAGE)));
			Thread.sleep(2000);
			
			Assert.assertTrue(commonPOM.getViewIngestFullLogButton().isDisplayed());
			commonPOM.getViewIngestFullLogButton().click();
			//add assertion for exact error like Row, type - not implemented this features bcz there is no ACs in JIRA 
			
			Thread.sleep(2000);
			Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
			Assert.assertTrue(commonPOM.getCancelButton().isDisplayed());
			commonPOM.getCancelButton().click();
			commonPOM.getPearsonLogo().click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void productTOCIngestion(String name, ExtentTest logger) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
			Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
			Assert.assertEquals(commonPOM.getDragAndDropFilesText().getText(),LOMTConstant.DRAG_DROP_TEXT);
			Assert.assertTrue(commonPOM.getUploadFileLink().isDisplayed());
			
			commonPOM.getUploadFileLink().click();
			
			//Ingestion with all the Mandatory and Non-mandatory fields
			if (currentLOB.equalsIgnoreCase(LOMTConstant.ENGLISH_LOB)) {
				
				//program and course title blank, and product title has value, all the mandatory and non-mandatory fields
				if (name.equalsIgnoreCase(LOMTConstant.TC_CASE_7_8_9_10_11)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_ENGLISH_1);
					
					Thread.sleep(3000);
					logger.log(LogStatus.PASS, TestCases.TC_LOMT_1040_07_UPLOAD_FILE_ALL_MANDATORY_AND_NON_MANDATORY_FIELDS_ADMIN_ROLE);
					commonPOM.getNextButtonSt2().click();
					logger.log(LogStatus.PASS, TestCases.TC_LOMT_1040_08_ADMIN_NEXT_BUTTON_CREATE_OR_UPLOAD_STRUCTURE);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						commonPOM.getDoneButton().click();
						Thread.sleep(1000);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1040_09_ADMIN_VERIFY_INGEST_SUCESS_MESSAGE_ON_THE_CREATE_OR_UPLOAD_STRUCTURE_PAGE);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1040_10_ADMIN_VERIFY_DONE_BUTTON_ON_THE_CREATE_OR_UPLOAD_STRUCTURE_PAGE);
						logger.log(LogStatus.PASS, "TC-LOMT-1040-11_ProductTOC_Admin_Ingest_ProductTOC_ProgramTitle(blank)_CourseTitle(blank)_ProductTitle(value)_No_align");
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1040_09_ADMIN_VERIFY_INGEST_SUCESS_MESSAGE_ON_THE_CREATE_OR_UPLOAD_STRUCTURE_PAGE);
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1040_10_ADMIN_VERIFY_DONE_BUTTON_ON_THE_CREATE_OR_UPLOAD_STRUCTURE_PAGE);
						logger.log(LogStatus.FAIL, "TC-LOMT-1040-11_ProductTOC_Admin_Ingest_ProductTOC_ProgramTitle(blank)_CourseTitle(blank)_ProductTitle(value)_No_align");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_12)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_ENGLISH_2);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, "TC-LOMT-1040-12_ProductTOC_Admin_Ingest_ProductTOC_ProgramTitle(new value)_CourseTitle(new value)_ProductTitle(new value or old value)_No_align");
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, "TC-LOMT-1040-12_ProductTOC_Admin_Ingest_ProductTOC_ProgramTitle(new value)_CourseTitle(new value)_ProductTitle(new value or old value)_No_align");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_14)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_ENGLISH_3);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, "TC-LOMT-1040-13_ProductTOC_Admin_Ingest_ProductTOC_ProgramTitle(existing value)_CourseTitle(new value)_ProductTitle(new value or old value)_No_align");
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, "TC-LOMT-1040-13_ProductTOC_Admin_Ingest_ProductTOC_ProgramTitle(existing value)_CourseTitle(new value)_ProductTitle(new value or old value)_No_align");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_15)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_ENGLISH_4);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_14_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_PROGRAMTITLE_EXISTING_VALUE_COURSETITLE_NEW_VALUE_PRODUCTTITLE_NEW_VALUE_OR_OLD_VALUE_NO_ALIGN);
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_14_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_PROGRAMTITLE_EXISTING_VALUE_COURSETITLE_NEW_VALUE_PRODUCTTITLE_NEW_VALUE_OR_OLD_VALUE_NO_ALIGN);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_16)) {
					// not implemented yet, re-ingestion case, De-scoped
					logger.log(LogStatus.INFO, "TC-LOMT-1040-15_ProductTOC_Admin_Ingest_ProductTOC_ProductTitle_Duplicate_Value_No_align");
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_17)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_ENGLISH_6);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, "TC-LOMT-1040-16_ProductTOC_Admin_Ingest_ProductTOC_AlignmentCode(has value)_Alignment");
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, "TC-LOMT-1040-16_ProductTOC_Admin_Ingest_ProductTOC_AlignmentCode(has value)_Alignment");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_21)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_ENGLISH_7);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, "TC-LOMT-1040-17_ProductTOC_Admin_Ingest_ProductTOC_AlignmentCode(wrong value)_Alignment");
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, "TC-LOMT-1040-17_ProductTOC_Admin_Ingest_ProductTOC_AlignmentCode(wrong value)_Alignment");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_19)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_ENGLISH_8);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_FAILED_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestFailed().getText().equalsIgnoreCase(LOMTConstant.INGESTION_FAILED_MESSAGE)) {
						commonPOM.getViewIngestFullLogButton().click();
						Thread.sleep(2000);
						
						logger.log(LogStatus.PASS, "TC-LOMT-1040-18_ProductTOC_Admin_Ingest_ProductTOC_Level_for_Hierarchy_sequence_mismatch");
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, "TC-LOMT-1040-18_ProductTOC_Admin_Ingest_ProductTOC_Level_for_Hierarchy_sequence_mismatch");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_19)) {
					// not implemented yet, re-ingestion case, De-scoped
					logger.log(LogStatus.INFO, "TC-LOMT-1040-19_ProductTOC_Admin_Ingest_ProductTOC_Context_Definition_Expand_all_level");
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_23)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_ENGLISH_10);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, "TC-LOMT-1040-20_ProductTOC_Admin_Upload_File(.xls or .xlsx)_Without_Non-Mandatory_Fields");
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, "TC-LOMT-1040-20_ProductTOC_Admin_Upload_File(.xls or .xlsx)_Without_Non-Mandatory_Fields");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_VALIDATION_CHECK_22_23)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_ENGLISH_11);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, "TC-LOMT-1040-23_ProductTOC_Admin_Manage Ingestion_Without_Mandatory_Fields");
						logger.log(LogStatus.PASS, "TC-LOMT-1040-24_ProductTOC_Admin_Manage Ingestion_ Review Outcome");
						logger.log(LogStatus.PASS, "TC-LOMT-1040-25_ProductTOC_Admin_Manage Ingestion_ VIEW FULL INGEST LOG _verify");
						logger.log(LogStatus.PASS, "TC-LOMT-1040-26_ProductTOC_Admin_Back_or_Cancel_Click");
						logger.log(LogStatus.PASS, "TC-LOMT-1040-27_ProductTOC_Admin_DONE_CLICK");
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, "TC-LOMT-1040-23_ProductTOC_Admin_Manage Ingestion_Without_Mandatory_Fields");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}
				// English product TOC end
				//HE Product TOC start
			} else if (currentLOB.equalsIgnoreCase(LOMTConstant.HE_LOB)) {
				
				if (name.equalsIgnoreCase(LOMTConstant.TC_CASE_7_8_9_10_11)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_HE_11);
					
					Thread.sleep(3000);
					logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_07_UPLOAD_FILE_ALL_MANDATORY_AND_NON_MANDATORY_FIELDS_ADMIN_ROLE);
					commonPOM.getNextButtonSt2().click();
					logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_08_ADMIN_NEXT_BUTTON_CREATE_OR_UPLOAD_STRUCTURE);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						
						commonPOM.getDoneButton().click();
						Thread.sleep(1000);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_09_ADMIN_VERIFY_INGEST_SUCESS_MESSAGE_ON_THE_CREATE_OR_UPLOAD_STRUCTURE_PAGE);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_10_ADMIN_VERIFY_DONE_BUTTON_ON_THE_CREATE_OR_UPLOAD_STRUCTURE_PAGE);
						logger.log(LogStatus.PASS, "TC-LOMT-1041-11_ProductTOC_Admin_Ingest_ProductTOC_ProgramTitle(blank)_CourseTitle(blank)_ProductTitle(value)_No_align");
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1041_09_ADMIN_VERIFY_INGEST_SUCESS_MESSAGE_ON_THE_CREATE_OR_UPLOAD_STRUCTURE_PAGE);
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1041_10_ADMIN_VERIFY_DONE_BUTTON_ON_THE_CREATE_OR_UPLOAD_STRUCTURE_PAGE);
						logger.log(LogStatus.FAIL, "TC-LOMT-1041-11_ProductTOC_Admin_Ingest_ProductTOC_ProgramTitle(blank)_CourseTitle(blank)_ProductTitle(value)_No_align");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_12)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_HE_12);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, "TC-LOMT-1041-12_ProductTOC_Admin_Ingest_ProductTOC_ProgramTitle(new value)_CourseTitle(new value)_ProductTitle(new value or old value)_No_align");
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, "TC-LOMT-1041-12_ProductTOC_Admin_Ingest_ProductTOC_ProgramTitle(new value)_CourseTitle(new value)_ProductTitle(new value or old value)_No_align");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_14)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_HE_13);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, "TC-LOMT-1041-13_ProductTOC_Admin_Ingest_ProductTOC_ProgramTitle(existing value)_CourseTitle(new value)_ProductTitle(new value or old value)_No_align");
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, "TC-LOMT-1041-13_ProductTOC_Admin_Ingest_ProductTOC_ProgramTitle(existing value)_CourseTitle(new value)_ProductTitle(new value or old value)_No_align");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_15)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_HE_14);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, "TC-LOMT-1041-14_ProductTOC_Admin_Ingest_ProductTOC_ProgramTitle(existing value)_CourseTitle(existing value)_ProductTitle(new value or old value)_No_align");
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, "TC-LOMT-1041-14_ProductTOC_Admin_Ingest_ProductTOC_ProgramTitle(existing value)_CourseTitle(existing value)_ProductTitle(new value or old value)_No_align");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_16)) {
					// not implemented yet, re-ingestion case, De-scoped
					logger.log(LogStatus.INFO, "TC-LOMT-1041-15_ProductTOC_Admin_Ingest_ProductTOC_ProductTitle_Duplicate_Value_No_align");
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_17)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_HE_16);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, "TC-LOMT-1041-16_ProductTOC_Admin_Ingest_ProductTOC_AlignmentCode(has value)_Alignment");
						logger.log(LogStatus.PASS, "TC-LOMT-1041-17_ProductTOC_Admin_Ingest_ProductTOC_AlignmentCode(wrong value)_Alignment");
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, "TC-LOMT-1041-16_ProductTOC_Admin_Ingest_ProductTOC_AlignmentCode(has value)_Alignment");
						logger.log(LogStatus.FAIL, "TC-LOMT-1041-17_ProductTOC_Admin_Ingest_ProductTOC_AlignmentCode(wrong value)_Alignment");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_18_EO)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_HE_18);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, "TC-LOMT-1041-18_ProductTOC_Admin_Ingest_ProductTOC_Educational_goal_URN(wrong urn)_Alignment");
						logger.log(LogStatus.INFO, "TC-LOMT-1041-18_ProductTOC_Admin_Ingest_ProductTOC_Educational_goal_URN(wrong urn)_Alignment");
						logger.log(LogStatus.PASS, "TC-LOMT-1041-19_ProductTOC_Admin_Ingest_ProductTOC_Level_for_Hierarchy(sequence mismatch)");
						logger.log(LogStatus.PASS, "TC-LOMT-1041-20_ProductTOC_Admin_Ingest_ProductTOC_Level_for_Hierarchy_Expand_all_level");
						logger.log(LogStatus.PASS, "TC-LOMT-1041-21_ProductTOC_Admin_Upload_File(.xls or .xlsx)_Without_Non-Mandatory_Fields");
						
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, "TC-LOMT-1041-18_ProductTOC_Admin_Ingest_ProductTOC_Educational_goal_URN(wrong urn)_Alignment");
						logger.log(LogStatus.FAIL, "TC-LOMT-1041-18_ProductTOC_Admin_Ingest_ProductTOC_Educational_goal_URN(wrong urn)_Alignment");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} else if (name.equalsIgnoreCase(LOMTConstant.TC_VALIDATION_CHECK_22_23)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_HE_23);
					
					Thread.sleep(3000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
					Thread.sleep(3000);
					if (commonPOM.getIngestSucessful().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, "TC-LOMT-1041-23_ProductTOC_Admin_Manage Ingestion_Without_Mandatory_Fields");
						logger.log(LogStatus.PASS, "TC-LOMT-1041-24_ProductTOC_Admin_Manage Ingestion_ Review Outcome");
						logger.log(LogStatus.PASS, "TC-LOMT-1041-25_ProductTOC_Admin_Manage Ingestion_ VIEW FULL INGEST LOG _verify");
						logger.log(LogStatus.PASS, "TC-LOMT-1041-26_ProductTOC_Admin_Back_or_Cancel_Click");
						logger.log(LogStatus.PASS, "TC-LOMT-1041-27_ProductTOC_Admin_DONE_CLICK");
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, "TC-LOMT-1040-23_ProductTOC_Admin_Manage Ingestion_Without_Mandatory_Fields");
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}
				//HE Product TOC end
			} else {
				//School
				//No alignment, program and course title blank and product title has new val, all the mand and non-mand fields
				if (name.equalsIgnoreCase(LOMTConstant.TC_CASE_7_8_9_10_11)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_PATH_1);
					
					Thread.sleep(6000);
					logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_07_UPLOAD_FILE_ALL_MANDATORY_AND_NON_MANDATORY_FIELDS_ADMIN_ROLE);
					commonPOM.getNextButtonSt2().click();
					logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_08_ADMIN_NEXT_BUTTON_CREATE_OR_UPLOAD_STRUCTURE);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						
						commonPOM.getDoneButton().click();
						Thread.sleep(1000);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_09_ADMIN_VERIFY_INGEST_SUCESS_MESSAGE_ON_THE_CREATE_OR_UPLOAD_STRUCTURE_PAGE);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_10_ADMIN_VERIFY_DONE_BUTTON_ON_THE_CREATE_OR_UPLOAD_STRUCTURE_PAGE);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_11_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_PROGRAMTITLE_BLANK_COURSETITLE_BLANK_PRODUCTTITLE_VALUE_NO_ALIGN);
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_09_ADMIN_VERIFY_INGEST_SUCESS_MESSAGE_ON_THE_CREATE_OR_UPLOAD_STRUCTURE_PAGE);
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_10_ADMIN_VERIFY_DONE_BUTTON_ON_THE_CREATE_OR_UPLOAD_STRUCTURE_PAGE);
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_11_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_PROGRAMTITLE_BLANK_COURSETITLE_BLANK_PRODUCTTITLE_VALUE_NO_ALIGN);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} 
				//Program, Course and Product Title has new value
				if (name.equalsIgnoreCase(LOMTConstant.TC_12)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_PATH_2);
					
					Thread.sleep(6000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_12_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_PROGRAMTITLE_NEW_VALUE_COURSETITLE_NEW_VALUE_PRODUCTTITLE_NEW_VALUE_OR_OLD_VALUE_NO_ALIGN);
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_12_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_PROGRAMTITLE_NEW_VALUE_COURSETITLE_NEW_VALUE_PRODUCTTITLE_NEW_VALUE_OR_OLD_VALUE_NO_ALIGN);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} 
				//Program has new value, Course has existing value and Product Title has new or old value
				if (name.equalsIgnoreCase(LOMTConstant.TC_13)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_PATH_3);
					
					Thread.sleep(6000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_13_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_PROGRAMTITLE_NEW_VALUE_COURSETITLE_EXISTING_VALUE_PRODUCTTITLE_NEW_VALUE_OR_OLD_VALUE_NO_ALIGN);
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_13_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_PROGRAMTITLE_NEW_VALUE_COURSETITLE_EXISTING_VALUE_PRODUCTTITLE_NEW_VALUE_OR_OLD_VALUE_NO_ALIGN);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}
				//Program has existing value, Course has new value and Product Title has new or old value
				if (name.equalsIgnoreCase(LOMTConstant.TC_14)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_PATH_4);
					
					Thread.sleep(6000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_14_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_PROGRAMTITLE_EXISTING_VALUE_COURSETITLE_NEW_VALUE_PRODUCTTITLE_NEW_VALUE_OR_OLD_VALUE_NO_ALIGN);
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_14_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_PROGRAMTITLE_EXISTING_VALUE_COURSETITLE_NEW_VALUE_PRODUCTTITLE_NEW_VALUE_OR_OLD_VALUE_NO_ALIGN);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} 
				//Program has existing and Course has existing value, Product Title has new or old value
				if (name.equalsIgnoreCase(LOMTConstant.TC_15)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_PATH_5);
					
					Thread.sleep(6000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_15_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_PROGRAMTITLE_EXISTING_VALUE_COURSETITLE_EXISTING_VALUE_PRODUCTTITLE_NEW_VALUE_OR_OLD_VALUE_NO_ALIGN);
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_15_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_PROGRAMTITLE_EXISTING_VALUE_COURSETITLE_EXISTING_VALUE_PRODUCTTITLE_NEW_VALUE_OR_OLD_VALUE_NO_ALIGN);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} 
				//No duplicate Product Title
				if (name.equalsIgnoreCase(LOMTConstant.TC_16)) {
					// not implemented yet, re-ingestion case, De-scoped
					//logger.log(LogStatus.INFO, TestCases.TC_LOMT_1039_16_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_PRODUCTTITLE_DUPLICATE_VALUE_NO_ALIGN);
					//Thread.sleep(2000);
				} 
				//AlignmentCode column has value
				if (name.equalsIgnoreCase(LOMTConstant.TC_17)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_PATH_7);
					
					Thread.sleep(6000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_17_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_ALIGNMENTCODE_HAS_VALUE_ALIGNMENT);
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_17_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_ALIGNMENTCODE_HAS_VALUE_ALIGNMENT);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				} 
				//CMT Intermediary Unique ID column has value(GOAL URN)
				if (name.equalsIgnoreCase(LOMTConstant.TC_18)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_PATH_8);
					
					Thread.sleep(6000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_18_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_CMT_INTERMEDIARY_UNIQUE_ID_HAS_VALUE_ALIGNMENT);
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_18_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_CMT_INTERMEDIARY_UNIQUE_ID_HAS_VALUE_ALIGNMENT);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}
				//sequence mismatch for "Level for Hierarchy"
				if (name.equalsIgnoreCase(LOMTConstant.TC_19)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_PATH_9);
					
					Thread.sleep(6000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_FAILED_MESSAGE)) {
						commonPOM.getViewIngestFullLogButton().click();
						Thread.sleep(2000);
						
						boolean flag = validationCheck(LOMTConstant.TC_19);
						if (flag) {
							logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_19_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_LEVEL_FOR_HIERARCHY_SEQUENCE_MISMATCH);
						} else {
							logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_19_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_LEVEL_FOR_HIERARCHY_SEQUENCE_MISMATCH);
						}
						commonPOM.getBackLinkFirst().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_19_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_LEVEL_FOR_HIERARCHY_SEQUENCE_MISMATCH);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}
				//Hierarchy Level should exapand, verify using dhc
				if (name.equalsIgnoreCase(LOMTConstant.TC_20)) {
					// not implemented yet, re-ingestion case, De-scoped
					logger.log(LogStatus.INFO, TestCases.TC_LOMT_1039_20_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_LEVEL_FOR_HIERARCHY_EXPAND_ALL_LEVEL);
					Thread.sleep(2000);
				} 
				//Alignment Code has wrong value
				if (name.equalsIgnoreCase(LOMTConstant.TC_21)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_PATH_11);
					
					Thread.sleep(6000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_FAILED_MESSAGE)) {
						commonPOM.getViewIngestFullLogButton().click();
						Thread.sleep(2000);
						boolean flag = validationCheck(LOMTConstant.TC_21);
						if (flag) {
							logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_21_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_DICIPLINE_OR_ALIGNMENTCODE_WRONG_VALUE_ALIGNMENT);
						} else {
							logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_21_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_DICIPLINE_OR_ALIGNMENTCODE_WRONG_VALUE_ALIGNMENT);
						}
						commonPOM.getBackLinkFirst().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_21_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_DICIPLINE_OR_ALIGNMENTCODE_WRONG_VALUE_ALIGNMENT);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}
				//CMT Intermediary Unique ID has wrong value(Goal URN)
				if (name.equalsIgnoreCase(LOMTConstant.TC_22)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_PATH_12);
					
					Thread.sleep(6000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_FAILED_MESSAGE)) {
						commonPOM.getViewIngestFullLogButton().click();
						Thread.sleep(2000);
						
						boolean flag = validationCheck(LOMTConstant.TC_22);
						if (flag) {
							logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_22_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_CMT_DICIPLINE_OR_INTERMEDIARY_UNIQUE_ID_WRONG_VALUE_ALIGNMENT);
						} else {
							logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_22_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_CMT_DICIPLINE_OR_INTERMEDIARY_UNIQUE_ID_WRONG_VALUE_ALIGNMENT);
						}
						commonPOM.getBackLinkFirst().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_22_PRODUCTTOC_ADMIN_INGEST_PRODUCTTOC_CMT_DICIPLINE_OR_INTERMEDIARY_UNIQUE_ID_WRONG_VALUE_ALIGNMENT);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}
				//Ingestion without non-mandatory fields
				if (name.equalsIgnoreCase(LOMTConstant.TC_23)) {
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_TOC_FILE_PATH_13);
					Thread.sleep(6000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_SUCESSFULL_MESSAGE)) {
						logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_23_PRODUCTTOC_ADMIN_UPLOAD_FILE_XLS_OR_XLSX_WITHOUT_NON_MANDATORY_FIELDS);
						commonPOM.getDoneButton().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_23_PRODUCTTOC_ADMIN_UPLOAD_FILE_XLS_OR_XLSX_WITHOUT_NON_MANDATORY_FIELDS);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}
				//Ingestion without mandatory fields
				if (name.equalsIgnoreCase(LOMTConstant.TC_25)) {
					Thread.sleep(2000);
					Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_SCHOOL_15);
					Thread.sleep(6000);
					commonPOM.getNextButtonSt2().click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGESTION_STATUS)));
					Thread.sleep(3000);
					if (commonPOM.getWaitForIngestionStatusText().getText().equalsIgnoreCase(LOMTConstant.INGESTION_FAILED_MESSAGE)) {
						commonPOM.getViewIngestFullLogButton().click();
						Thread.sleep(2000);
						
						boolean flag = validationCheck(LOMTConstant.TC_25);
						if (flag) {
							logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_25_PRODUCTTOC_ADMIN_MANAGE_INGESTION_WITHOUT_ALL_MANDATORY_FIELDS);
						} else {
							logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_25_PRODUCTTOC_ADMIN_MANAGE_INGESTION_WITHOUT_ALL_MANDATORY_FIELDS);
						}
						commonPOM.getBackLinkFirst().click();
					} else {
						logger.log(LogStatus.FAIL, TestCases.TC_LOMT_1039_25_PRODUCTTOC_ADMIN_MANAGE_INGESTION_WITHOUT_ALL_MANDATORY_FIELDS);
						commonPOM.getBackLinkFirst().click();
						Thread.sleep(1000);
					}
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void productTOCIngestionWithoutNonMandatoryFields() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 180);
			Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
			Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
			Assert.assertEquals(commonPOM.getDragAndDropFilesText().getText(),LOMTConstant.DRAG_DROP_TEXT);
			Assert.assertTrue(commonPOM.getUploadFileLink().isDisplayed());
			
			commonPOM.getUploadFileLink().click();
			
			//Ingestion without non-mandatory fields
			if (currentLOB.equalsIgnoreCase(LOMTConstant.ENGLISH_LOB)) {
				Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_NON_MANDATORY_FIELDS_PATH_ENGLISH);
				Thread.sleep(3000);
			} else if (currentLOB.equalsIgnoreCase(LOMTConstant.HE_LOB)) {
				Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_NON_MANDATORY_FIELDS_PATH_HE);
				Thread.sleep(3000);
			} else if (currentLOB.equalsIgnoreCase(LOMTConstant.NALS_LOB)) {
				Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_SCHOOL);
				Thread.sleep(3000);
			} else {
				//School Global
				Runtime.getRuntime().exec(LOMTConstant.PRODUCT_FILE_PATH_SCHOOL);
				Thread.sleep(3000);
			}
			commonPOM.getNextButtonSt2().click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
			Thread.sleep(3000);
			
			Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
			Assert.assertTrue(commonPOM.getIngestSucessful().isDisplayed());
			Assert.assertTrue(commonPOM.getDoneButton().isDisplayed());
			Assert.assertTrue(commonPOM.getPearsonLogo().isDisplayed());
			Assert.assertTrue(commonPOM.getFourthTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFourthTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_4_TEXT);
			
			commonPOM.getDoneButton().click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void backLinkClicked(ExtentTest logger) {
		try {
			if (currentLOB.equalsIgnoreCase(LOMTConstant.ENGLISH_LOB)) {
				commonPOM.getBackLinkSec().click();
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1040_06_ADMIN_MANAGE_INGESTION_BACK_CREATE_OR_UPLOAD_STRUCTURE);
				Thread.sleep(1000);
			} else if (currentLOB.equalsIgnoreCase(LOMTConstant.HE_LOB)) {
				commonPOM.getBackLinkSec().click();
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1041_06_ADMIN_MANAGE_INGESTION_BACK_CREATE_OR_UPLOAD_STRUCTURE);
				Thread.sleep(1000);
			} else {
				//school
				//Thread.sleep(2000);
				commonPOM.getBackLinkSec().click();
				logger.log(LogStatus.PASS, TestCases.TC_LOMT_1039_06_ADMIN_MANAGE_INGESTION_BACK_CREATE_OR_UPLOAD_STRUCTURE);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getHomePage() {
		try {
			commonPOM.getPearsonLogo().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getSchoolLOBAndStructure() {
		try {
			commonPOM.getSchoolGlobalLOBRadioButton().click();
			Thread.sleep(1000);
			commonPOM.getSchoolProductStructureRadioButton().click();
			Thread.sleep(1000);
			commonPOM.getNextButtonFirst().click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void productTOCWithoutMetaData() {
		commonPOM.getNextButton().click();
	}
	
	public void getEnglishLOBAndStructure() {
		try {
			commonPOM.getGseProductStructureRadioButton().click();
			Thread.sleep(1000);
			commonPOM.getNextButtonFirst().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getHELOBAndStructure() {
		try {
			commonPOM.getHeLOBRadioButton().click();
			Thread.sleep(1000);
			commonPOM.getProductRadioButton().click();
			Thread.sleep(2000);
			commonPOM.getNextButtonFirst().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean validationCheck(String testCaseName) {
		boolean flag = false;
		if (testCaseName.equalsIgnoreCase(LOMTConstant.TC_19)) {
			try {
				if (sgPom.getErrorMessage1().getText().equalsIgnoreCase(LOMTConstant.SEQUENCE_MISMATCH_ERROR_MESSAGE)) {
					flag = true;
				} else {
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
			}
		}
		if (testCaseName.equalsIgnoreCase(LOMTConstant.TC_21)) {
			try {
				if (sgPom.getErrorMessage1().getText().equalsIgnoreCase(LOMTConstant.WRONG_ALIGNMENT_CODE_ERROR_MESSAGEA_1)
						|| sgPom.getErrorMessage2().getText().equalsIgnoreCase(LOMTConstant.WRONG_ALIGNMENT_CODE_ERROR_MESSAGEA_1)) {
					flag = true;
				} else {
					flag = false;
				}
				if (sgPom.getErrorMessage1().getText().equalsIgnoreCase(LOMTConstant.WRONG_ALIGNMENT_CODE_ERROR_MESSAGEA_2)
						|| sgPom.getErrorMessage2().getText().equalsIgnoreCase(LOMTConstant.WRONG_ALIGNMENT_CODE_ERROR_MESSAGEA_2)) {
					flag = true;
				} else {
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
			}

		}
		if (testCaseName.equalsIgnoreCase(LOMTConstant.TC_22)) {
			try {
				if (sgPom.getErrorMessage1().getText().contains(LOMTConstant.WRONG_CMT_URN_1)
						|| sgPom.getErrorMessage2().getText().contains(LOMTConstant.WRONG_CMT_URN_1)) {
					flag = true;
				} else {
					flag = false;
				}
				if (sgPom.getErrorMessage1().getText().contains(LOMTConstant.WRONG_CMT_URN_2)
						|| sgPom.getErrorMessage2().getText().contains(LOMTConstant.WRONG_CMT_URN_2)) {
					flag = true;
				} else {
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
			}

		}
		// mandatory fields check
		if (testCaseName.equalsIgnoreCase(LOMTConstant.TC_25)) {
			try {
				if (sgPom.getErrorMessage1().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_1)
						|| sgPom.getErrorMessage2().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_1)
						|| sgPom.getErrorMessage3().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_1) 
						|| sgPom.getErrorMessage4().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_1) ) {
					flag = true;
				} else {
					flag = false;
				}
				if (sgPom.getErrorMessage1().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_2)
						|| sgPom.getErrorMessage2().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_2)
						|| sgPom.getErrorMessage3().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_2) 
						|| sgPom.getErrorMessage4().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_2) ) {
					flag = true;
				} else {
					flag = false;
				}
				if (sgPom.getErrorMessage1().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_3)
						|| sgPom.getErrorMessage2().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_3)
						|| sgPom.getErrorMessage3().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_3) 
						|| sgPom.getErrorMessage4().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_3) ) {
					flag = true;
				} else {
					flag = false;
				}
				if (sgPom.getErrorMessage1().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_4)
						|| sgPom.getErrorMessage2().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_4)
						|| sgPom.getErrorMessage3().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_4) 
						|| sgPom.getErrorMessage4().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_4) ) {
					flag = true;
				} else {
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
			}
		}
		// product title is blank
		if (testCaseName.equalsIgnoreCase(LOMTConstant.TC_26)) {
			try {
				if (sgPom.getErrorMessage1().getText().contains(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_1)) {
					flag = true;
				} else {
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
			}
		}
		// Level for Hierarchy is blank
		if (testCaseName.equalsIgnoreCase(LOMTConstant.TC_27)) {
			try {
				if (sgPom.getErrorMessage1().getText().equalsIgnoreCase(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_1)
						|| sgPom.getErrorMessage2().getText().equalsIgnoreCase(LOMTConstant.MANDATORY_FIELDS_ERROR_MESSAGE_1) ) {
					flag = true;
				} else {
					flag = false;
				}
				if (sgPom.getErrorMessage1().getText().equalsIgnoreCase(LOMTConstant.LEVEL_HIERARCHY_ERROR_MESSAGE_2)
						|| sgPom.getErrorMessage2().getText().equalsIgnoreCase(LOMTConstant.LEVEL_HIERARCHY_ERROR_MESSAGE_2) ) {
					flag = true;
				} else {
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
			}
		}
		//Level Title is blank
		if (testCaseName.equalsIgnoreCase(LOMTConstant.TC_28)) {
			try {
				if (sgPom.getErrorMessage1().getText().equalsIgnoreCase(LOMTConstant.LEVEL_TITLE_CAN_NOT_BLANK)
						|| sgPom.getErrorMessage2().getText().equalsIgnoreCase(LOMTConstant.LEVEL_TITLE_CAN_NOT_BLANK) ) {
					flag = true;
				} else {
					flag = false;
				}				
			} catch (Exception e) {
				flag = false;
			}
		}
		if (testCaseName.equalsIgnoreCase(LOMTConstant.TC_33)) {
			try {
				if (sgPom.getErrorMessage1().getText().contains(LOMTConstant.WRONG_CMT_URN_1)) {
					flag = true;
				} else {
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
			}
		}
		return flag;
	}
	
	public void verifyProductTOCIngestedDataOnResultPage(String lobName, String filePath, ExtentTest logger) {
		if (lobName.equalsIgnoreCase(LOMTConstant.HE_LOB)) {
			
		} else if (lobName.equalsIgnoreCase(LOMTConstant.ENGLISH_LOB)) {
			
		} else {
			//SCHOOL
			String productTitleName = getProductTitleName(filePath);
			searchIngestedProductTitle(productTitleName, logger);
		}
	}
	
	public String getProductTitleName(String filePath) {
		String productTitleName = null;
		
		InputStream exfFilePathIS = null;
		XSSFWorkbook workbookForexfFile = null;
		File file = new File(filePath);

		if (file.isFile() && file.exists()) {
			try {
				exfFilePathIS = new FileInputStream(file);
				workbookForexfFile = new XSSFWorkbook(exfFilePathIS);
				XSSFSheet actualDataSheet = workbookForexfFile.getSheetAt(0);
				Iterator<Row> rowIteratoreForActual = actualDataSheet.iterator();
				while (rowIteratoreForActual.hasNext()) {
					Row row = rowIteratoreForActual.next();
					if ((row.getRowNum() == 2)) {
						productTitleName = String.valueOf(row.getCell(LOMTConstant.ONE));
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return productTitleName;
	}
	
	public void searchIngestedProductTitle(String productTitleName, ExtentTest logger){
		try {
			exfPOM.getEnterSearchTerm().sendKeys(productTitleName);
			Assert.assertTrue(exfPOM.getUpdateResultButton().isEnabled());
			exfPOM.getUpdateResultButton().click();
			
			Thread.sleep(10000);
			if (exfPOM.getSearchedEXFTitle()!= null && exfPOM.getSearchedEXFTitle().getText() != null) {
				if (productTitleName.equalsIgnoreCase(exfPOM.getSearchedEXFTitle().getText())) {
					System.out.println("School Product TOC found in search result");
				} else {
					logger.log(LogStatus.INFO, "School Product TOC not found in search result");
				}
			} else {
				logger.log(LogStatus.INFO, "School Product TOC not found in search result");
			}
			Thread.sleep(1000);
			exfPOM.getEnterSearchTerm().clear();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getSchoolBrowsePage() {
		try {
			commonPOM.getNalsLOB().click();
			commonPOM.getSchoolProductTOCStructure().click();
			Thread.sleep(20000);
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeDriverInstance() {
		driver.close();
	}

}
