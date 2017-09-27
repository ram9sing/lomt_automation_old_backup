package lomt.pearson.api.he;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import lomt.pearson.common.BaseClass;
import lomt.pearson.common.LoadPropertiesFile;
import lomt.pearson.common.ValidationCheck;
import lomt.pearson.constant.HEConstant;
import lomt.pearson.constant.LOMTConstant;
import lomt.pearson.page_object.CommonPOM;
import lomt.pearson.page_object.EnglishPOM;
import lomt.pearson.page_object.HEPom;
import lomt.pearson.page_object.Login;

public class IngestionAndExport extends BaseClass {
	
	private String environment = LoadPropertiesFile.getPropertiesValues(LOMTConstant.LOMT_ENVIRONMENT);
	private String userName = LoadPropertiesFile.getPropertiesValues(LOMTConstant.USER_NAME);
	private String pwd = LoadPropertiesFile.getPropertiesValues(LOMTConstant.PASSWORD);
	
	String currentLOB = null;

	private WebDriver driver;

	private Login login = null;
	private CommonPOM commonPOM = null;
	private EnglishPOM englishPOM = null;
	private HEPom hePom = null;
	private ValidationCheck validationCheck = null;
	
	public void getDriverInstance(WebDriver driver) {
		this.driver = initialiseChromeDriver();
	}
	
	public void openBrowser() {
		getDriverInstance(driver);
		driver.manage().window().maximize();
		driver.get(environment);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		commonPOM = new CommonPOM(driver);
		englishPOM = new EnglishPOM(driver);
		hePom = new HEPom(driver);
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
	
	public void higherEducationLOBBrowsePage() {
		try {
			Assert.assertTrue(commonPOM.getHeLOB().isDisplayed());
			currentLOB = commonPOM.getHeLOB().getText();
			commonPOM.getHeLOB().click();

			Assert.assertEquals(commonPOM.getWelcomeTitle().getText(), LOMTConstant.WELCOME_TITLE);
			//Assert.assertFalse(hePom.getExternalFrameworkLink().isEnabled());
			//Assert.assertFalse(hePom.getProductLink().isEnabled());
			Assert.assertTrue(hePom.getEoLink().isEnabled());
			Assert.assertTrue(commonPOM.getManageIngestion().isDisplayed());

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)");

			commonPOM.getManageIngestion().click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createUploadStructureFirstPage() {
		try {
			if (currentLOB.equalsIgnoreCase(LOMTConstant.HE_LOB)) {
				//Header, Footer 
				Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
				Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
				Assert.assertFalse(commonPOM.getNextButtonFirst().isEnabled());  
				
				//LOB
				Assert.assertEquals(commonPOM.getSelectLOBTitle().getText(), LOMTConstant.SELECT_LOB);
				
				Assert.assertTrue(commonPOM.getEnglishLOBRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getHeLOBRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getSchoolGlobalLOBRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getNalsLOBRadioButton().isDisplayed());
				
				//Structure 
				Assert.assertEquals(commonPOM.getSelectStructureTitle().getText(), LOMTConstant.SELECT_STRUCTURE_TYPE);
				
				Assert.assertTrue(commonPOM.getGseStructureRadioButton().isEnabled());
				Assert.assertTrue(commonPOM.getProductExternalFrameworkStructureRadioButton().isEnabled());
				Assert.assertTrue(commonPOM.getGseProductStructureRadioButton().isEnabled());
				
				//right side message validation before Structure select
				Assert.assertTrue(commonPOM.getFirstTextImage().isDisplayed());
				Assert.assertEquals(commonPOM.getFirstTextMessage().getText(), LOMTConstant.CHOOSE_STRUCTURE_TYPE);
				Assert.assertTrue(englishPOM.getSecondTextImage().isDisplayed());
				Assert.assertEquals(englishPOM.getSecondTextEnglish().getText(), LOMTConstant.PROVIDE_ENGLISH_METADASTA);
				Assert.assertTrue(commonPOM.getThirdTextImage().isDisplayed());
				Assert.assertEquals(commonPOM.getThirdTextMessage().getText(), LOMTConstant.UPLOAD_YOUR_FILE);
				Assert.assertTrue(commonPOM.getFourthTextImage().isDisplayed());
				Assert.assertEquals(commonPOM.getFourthTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_4_TEXT);
				
				//Selecting HE LOB and EO Structure
				commonPOM.getHeLOBRadioButton().click();
				
				//Assert.assertTrue(commonPOM.getProductExternalFrameworkStructureRadioButton().isEnabled());
				Assert.assertTrue(commonPOM.getProductStructureRadioButton().isDisplayed());
				Assert.assertTrue(commonPOM.getProductHERadioButton().isDisplayed());
				
				commonPOM.getEducationalObjRadioButton().click();
				
				Thread.sleep(1000);
				Assert.assertTrue(commonPOM.getNextButtonFirst().isEnabled());  
				
				//right side message validation before Structure select
				Assert.assertTrue(commonPOM.getFirstTextImage().isDisplayed());
				Assert.assertEquals(commonPOM.getFirstTextMessage().getText(), LOMTConstant.CHOOSE_STRUCTURE_TYPE);
				Assert.assertTrue(hePom.getSecondTextImage().isDisplayed());
				Assert.assertEquals(hePom.getSecondTextHE().getText(), LOMTConstant.PROVIDE_METADATA_HE_EO);
				Assert.assertTrue(commonPOM.getThirdTextImage().isDisplayed());
				Assert.assertEquals(commonPOM.getThirdTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_3_TEXT);
				Assert.assertTrue(commonPOM.getFourthTextImage().isDisplayed());
				Assert.assertEquals(commonPOM.getFourthTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_4_TEXT);
				
				commonPOM.getNextButtonFirst().click();
				Thread.sleep(2000);
			} else if (currentLOB.equalsIgnoreCase(LOMTConstant.ENGLISH_LOB)) {

			} else if (currentLOB.equalsIgnoreCase(LOMTConstant.NALS_LOB)) {

			} else {
				// School Global
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void backSelect() {
		try {
			commonPOM.getBackLinkFirst().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createUploadStructureMetaDataPage() {
		try {
			Assert.assertTrue(hePom.getBackButton().isDisplayed());
			Assert.assertTrue(hePom.getNextButton().isDisplayed());
			
			Assert.assertEquals(hePom.getLearningTitleName().getText(), LOMTConstant.LEARNING_TITLE_NAME);
			Assert.assertEquals(hePom.getDomainName().getText(), LOMTConstant.DOMAIN);
			Assert.assertEquals(hePom.getStatusName().getText(), LOMTConstant.STATUS);
			Assert.assertEquals(hePom.getObjectiveHierarchySetName().getText(), LOMTConstant.OBJECT_HIERARCHY_SET);
			
			hePom.getLearningTitleInputText().sendKeys(LOMTConstant.HE_INGESTION_FILE_NAME_1);
			Thread.sleep(1000);
			
			//DOMAIN SELECTION
			hePom.getDomainNameDropDown().click();
			Thread.sleep(4000);
			List<WebElement> domainList = hePom.getDomainList();
			int domainLength = domainList.size();
			if (domainLength > 0) {
				for (int i = 0; i <= domainLength; i++) {
					WebElement element = domainList.get(i);
					// TODO : apply assertion for all the fields
					if (element.getText().equalsIgnoreCase(HEConstant.BUSINESS_STATISTICES)) {
						element.click();
						break;
					}
				}
			} else {
				Assert.assertFalse((domainLength == 0), "HE Domain dropdown size is zero");
				return;
			}
			//STATUS SELECTION
			hePom.getStatusDropDown().click();
			Thread.sleep(4000);
			List<WebElement> statusList = hePom.getStatusDropDownList();
			int statusLength = statusList.size();
			if (statusLength > 0) {
				for (int i = 0; i < statusLength; i++) {
					WebElement element = domainList.get(i);
					System.out.println("Status value : " + element.getText());
					if (element.getText().equalsIgnoreCase(HEConstant.DRAFT)) {
						element.click();
						break;
					}
				}
			} else {
				Assert.assertFalse((domainLength == 0), "HE Status dropdown size is zero");
				return;
			}
			//Objective Hierarchy Set SELECTION-NON MANDATORY FIELDS
			//TODO
			hePom.getNextButton().click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void educationalObjectiveIngestion(String fileType) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 180);
			//Header
			Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
			Assert.assertTrue(commonPOM.getCreateUploadStructureHeader().isDisplayed());
			Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
			
			//Center
			Assert.assertTrue(commonPOM.getPlusSign().isDisplayed());
			Assert.assertEquals(commonPOM.getDragAndDropFilesText().getText(),LOMTConstant.DRAG_DROP_TEXT);
			Assert.assertTrue(commonPOM.getUploadFileLink().isDisplayed());
			
			 //File upload logic 
			commonPOM.getUploadFileLink().click();
			
			if (fileType.equalsIgnoreCase(LOMTConstant.INVALID_FORMAT_FILE)) {
				Runtime.getRuntime().exec(LOMTConstant.INVALID_FORMAT_FILE_PATH);
				Thread.sleep(4000);
				driver.switchTo().alert().accept();
				Thread.sleep(1000);
			} else if (fileType.equalsIgnoreCase(LOMTConstant.VALIDATION_MISSED)) {
				Runtime.getRuntime().exec(LOMTConstant.HE_INGESTION_VALIDATION_MISSED_FILE_PATH);
				Thread.sleep(4000);
				
				hePom.getNextButton().click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_FAILED_MESSAGE)));
				Thread.sleep(2000);
				Assert.assertTrue(commonPOM.getViewIngestFullLogButton().isDisplayed());
				commonPOM.getViewIngestFullLogButton().click();
				Thread.sleep(2000);
				// validation check
				validationCheck = new ValidationCheck();
				if(validationCheck.heValidationErrorMessageAssertions(hePom))
				  commonPOM.getDoneButton().click();
			} else if (fileType.equalsIgnoreCase(LOMTConstant.INGEST)) {
				Runtime.getRuntime().exec(LOMTConstant.HE_INGESTION_FILE_PATH);
				Thread.sleep(4000);
				
				hePom.getNextButton().click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
				Thread.sleep(2000);
				
				Assert.assertTrue(commonPOM.getIngestSucessful().isDisplayed());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void closeDriverInstance() {
		driver.close();
	}

}
