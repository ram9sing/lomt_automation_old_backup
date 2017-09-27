package lomt.pearson.api.gse;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import lomt.pearson.common.BaseClass;
import lomt.pearson.common.LoadPropertiesFile;
import lomt.pearson.constant.LOMTConstant;
import lomt.pearson.page_object.CommonPOM;
import lomt.pearson.page_object.EnglishPOM;
import lomt.pearson.page_object.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EnglishGSE extends BaseClass {

	private WebDriver driver;
	
	private Login login = null;
	private CommonPOM commonPOM = null;
	private EnglishPOM englishPOM = null;
	
	private String environment = LoadPropertiesFile.getPropertiesValues(LOMTConstant.LOMT_ENVIRONMENT);
	String userName = LoadPropertiesFile.getPropertiesValues(LOMTConstant.USER_NAME);
	String pwd = LoadPropertiesFile.getPropertiesValues(LOMTConstant.PASSWORD);
	String userNameBasic = LoadPropertiesFile.getPropertiesValues(LOMTConstant.USER_NAME_BASIC);
	String pwdBasic = LoadPropertiesFile.getPropertiesValues(LOMTConstant.PASSWORD_BASIC);
	
	public void getDriverInstance(WebDriver driver) {
		this.driver = initiliseDriver();
	}

	public void openBrowser() {
		getDriverInstance(driver);
		driver.manage().window().maximize();
		driver.get(environment);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		commonPOM = new CommonPOM(driver);
		englishPOM = new EnglishPOM(driver);
	}
	
	public void login() {
		try {
			login = new Login(driver);
			login.getUserName().sendKeys(userName);
			login.getPassword().sendKeys(pwd);
			login.getLoginButton().click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		} catch (Exception e) {
			e.printStackTrace();
			// add logger
		}
	}
	
	public void loginNonAdminRole() {
		try {
			login = new Login(driver);
			login.getUserName().sendKeys(userNameBasic);
			login.getPassword().sendKeys(pwdBasic);
			login.getLoginButton().click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		} catch (Exception e) {
			e.printStackTrace();
			// add logger
		}
	}
	
	public void englishBrowsePage() {
		try {
			Assert.assertTrue(commonPOM.getEnglishLOB().isDisplayed());
			commonPOM.getEnglishLOB().click();
			
			Assert.assertEquals(commonPOM.getWelcomeTitle().getText(), LOMTConstant.WELCOME_TITLE);
			Assert.assertTrue(englishPOM.getEnglishBanner().isDisplayed());
			Assert.assertTrue(englishPOM.getGseLink().isDisplayed());
			Assert.assertTrue(englishPOM.getExternalFrameworkLink().isDisplayed());
			Assert.assertTrue(englishPOM.getProductLink().isDisplayed());
			Assert.assertTrue(commonPOM.getManageIngestion().isDisplayed());
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)");
			
			commonPOM.getManageIngestion().click();
			
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			// add logger
		}
	}
	
	public void logout() {
		try {
			commonPOM.getLogoutOption().click();
			Thread.sleep(2000);
			commonPOM.getLogout().click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void englishGSEBrowsePageForNonAdminUser() throws InterruptedException {
		Assert.assertTrue(commonPOM.getEnglishLOB().isDisplayed());
		commonPOM.getEnglishLOB().click();
		Thread.sleep(2000);
		commonPOM.getPearsonLogo().click();
		Thread.sleep(1000);
	}
	
	public void createUploadStructurePage() throws Exception {
		try {
			//Header, Footer 
			Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
			Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
			Assert.assertFalse(commonPOM.getNextButtonFirst().isEnabled());  
			// Next button is disabled
			
			//LOB
			Assert.assertEquals(commonPOM.getSelectLOBTitle().getText(), LOMTConstant.SELECT_LOB);
			Assert.assertTrue(commonPOM.getEnglishLOBRadioButton().isDisplayed());
			Assert.assertTrue(commonPOM.getHeLOBRadioButton().isDisplayed());
			Assert.assertTrue(commonPOM.getSchoolGlobalLOBRadioButton().isDisplayed());
			Assert.assertTrue(commonPOM.getNalsLOBRadioButton().isDisplayed());
			
			//Structure
			Assert.assertEquals(commonPOM.getSelectStructureTitle().getText(), LOMTConstant.SELECT_STRUCTURE_TYPE);
			Assert.assertTrue(commonPOM.getGseStructureRadioButton().isEnabled());
			Assert.assertTrue(commonPOM.getProductExternalFrameworkStructureRadioButton().isDisplayed());
			//Assert.assertTrue(commonPOM.getGseProductStructureRadioButton().isEnabled()); - not available in PPE
			Assert.assertFalse(commonPOM.getGseProductStructureRadioButton().isEnabled());
			
			commonPOM.getGseStructureRadioButton().click();
			Thread.sleep(2000);
			
			//Right options
			Assert.assertTrue(commonPOM.getFirstTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFirstTextMessage().getText(), LOMTConstant.CHOOSE_STRUCTURE_TYPE);			
			Assert.assertTrue(englishPOM.getSecondTextImage().isDisplayed());
			Assert.assertEquals(englishPOM.getSecondTextEnglish().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_2_TEXT);			
			Assert.assertTrue(commonPOM.getThirdTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getThirdTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_3_TEXT);			
			Assert.assertTrue(commonPOM.getFourthTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFourthTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_4_TEXT);
			
			Assert.assertTrue(commonPOM.getNextButtonFirst().isEnabled()); // Next button is enabled
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createUploadStructurePageWithBackOperation() {
		try {
			commonPOM.getBackLinkFirst().click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createUploadStructurePageWithNextOperation() {
		try {
			commonPOM.getNextButtonFirst().click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createUploadStructurePageWithIncorrectGSEFile() {
		try {
			//Header, Footer
			Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
			Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
			Assert.assertTrue(commonPOM.getNextButtonFirst().isDisplayed());  // Next button is disabled
			Assert.assertTrue(commonPOM.getBackButtonSt2().isEnabled());
			
			//Right options
			Assert.assertTrue(commonPOM.getFirstTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFirstTextMessage().getText(), LOMTConstant.CHOOSE_STRUCTURE_TYPE);			
			Assert.assertTrue(englishPOM.getSecondTextImage().isDisplayed());
			Assert.assertEquals(englishPOM.getSecondTextEnglish().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_2_TEXT);			
			Assert.assertTrue(commonPOM.getThirdTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getThirdTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_3_TEXT);			
			Assert.assertTrue(commonPOM.getFourthTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFourthTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_4_TEXT);
			
			//Center
			Assert.assertTrue(commonPOM.getPlusSign().isDisplayed());
			Assert.assertEquals(commonPOM.getDragAndDropFilesText().getText(),LOMTConstant.DRAG_DROP_TEXT);
			Assert.assertTrue(commonPOM.getUploadFileLink().isDisplayed());
			
			 //File upload logic 
			commonPOM.getUploadFileLink().click();
			
			Runtime.getRuntime().exec(LOMTConstant.ENGLISH_GSE_SHEET_WITHOUT_MANDATORY_FIELDS_FILE_PATH);
			
			Thread.sleep(3000);
			commonPOM.getNextButtonSt2().click();				
			WebDriverWait wait = new WebDriverWait(driver, 600);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_FAILED_MESSAGE)));
			
			Thread.sleep(2000);
			//Header
			Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
			Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
			
			//Right options
			Assert.assertTrue(commonPOM.getFirstTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFirstTextMessage().getText(), LOMTConstant.CHOOSE_STRUCTURE_TYPE);			
			Assert.assertTrue(englishPOM.getSecondTextImage().isDisplayed());
			Assert.assertEquals(englishPOM.getSecondTextEnglish().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_2_TEXT);			
			Assert.assertTrue(commonPOM.getThirdTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getThirdTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_3_TEXT);			
			Assert.assertTrue(commonPOM.getFourthTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFourthTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_4_TEXT);
			
			//Center
			Assert.assertEquals(commonPOM.getIngestFailed().getText(), LOMTConstant.INGESTION_FAILED_MESSAGE);
			Assert.assertTrue(commonPOM.getViewIngestFullLogButton().isDisplayed());
			
			commonPOM.getViewIngestFullLogButton().click();
			Thread.sleep(2000);
					
			Assert.assertEquals(commonPOM.getRowNo().getText(), LOMTConstant.ROW_NO);
			Assert.assertEquals(commonPOM.getType().getText(), LOMTConstant.TYPE);
			Assert.assertEquals(commonPOM.getMessage().getText() ,LOMTConstant.MESSAGE);
			Assert.assertTrue(commonPOM.getCancelButton().isEnabled());
			
			commonPOM.getCancelButton().click();
			commonPOM.getViewIngestFullLogButton().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectBackButtonAndUploadCorrectGSESheet(String value) throws IOException, InterruptedException {
		try {
			//commonPOM.getBackLinkFirst().click();
			//Thread.sleep(2000);
			//Header, Footer 
			Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
			Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
			Assert.assertTrue(commonPOM.getNextButtonFirst().isDisplayed());  // Next button is disabled
			
			//LOB
			Assert.assertEquals(commonPOM.getSelectLOBTitle().getText(), LOMTConstant.SELECT_LOB);
			Assert.assertTrue(commonPOM.getEnglishLOBRadioButton().isDisplayed());
			Assert.assertTrue(commonPOM.getHeLOBRadioButton().isDisplayed());
			Assert.assertTrue(commonPOM.getSchoolGlobalLOBRadioButton().isDisplayed());
			Assert.assertTrue(commonPOM.getNalsLOBRadioButton().isDisplayed());
			
			//Structure
			Assert.assertEquals(commonPOM.getSelectStructureTitle().getText(), LOMTConstant.SELECT_STRUCTURE_TYPE);
			Assert.assertTrue(commonPOM.getGseStructureRadioButton().isEnabled());
			Assert.assertTrue(commonPOM.getProductExternalFrameworkStructureRadioButton().isDisplayed());
			//Assert.assertTrue(commonPOM.getGseProductStructureRadioButton().isEnabled()); - not available in PPE
			Assert.assertFalse(commonPOM.getGseProductStructureRadioButton().isEnabled());
			
			commonPOM.getGseStructureRadioButton().click();
			Thread.sleep(1000);
			
			//Right options
			Assert.assertTrue(commonPOM.getFirstTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFirstTextMessage().getText(), LOMTConstant.CHOOSE_STRUCTURE_TYPE);			
			Assert.assertTrue(englishPOM.getSecondTextImage().isDisplayed());
			Assert.assertEquals(englishPOM.getSecondTextEnglish().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_2_TEXT);			
			Assert.assertTrue(commonPOM.getThirdTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getThirdTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_3_TEXT);			
			Assert.assertTrue(commonPOM.getFourthTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFourthTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_4_TEXT);
			
			Assert.assertTrue(commonPOM.getNextButtonFirst().isEnabled()); // Next button is enabled
			
			Thread.sleep(2000);
			commonPOM.getNextButtonFirst().click();
			
			 //File upload logic 
			commonPOM.getUploadFileLink().click();
			
			if (value.equalsIgnoreCase(LOMTConstant.FRESH_INGESTION)) {
				Runtime.getRuntime().exec(LOMTConstant.ENGLISH_GSE_FILE_PATH);
			}
			if (value.equalsIgnoreCase(LOMTConstant.RE_INGESTION_WITHOUT_URN)) {
				Runtime.getRuntime().exec(LOMTConstant.ENGLISH_GSE_REINGESTION_FILE_PATH);
			}
			if (value.equalsIgnoreCase(LOMTConstant.RE_INGESTION_URN)) {
				Runtime.getRuntime().exec(LOMTConstant.ENGLISH_GSE_REINGESTION_FILE_PATH);
			}
			
			Thread.sleep(3000);
			commonPOM.getNextButtonSt2().click();				
			WebDriverWait wait = new WebDriverWait(driver, 600);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE) ));
			
			Thread.sleep(2000);
			//Header
			Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
			Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
			
			//Right options
			Assert.assertTrue(commonPOM.getFirstTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFirstTextMessage().getText(), LOMTConstant.CHOOSE_STRUCTURE_TYPE);			
			Assert.assertTrue(englishPOM.getSecondTextImage().isDisplayed());
			Assert.assertEquals(englishPOM.getSecondTextEnglish().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_2_TEXT);			
			Assert.assertTrue(commonPOM.getThirdTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getThirdTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_3_TEXT);			
			Assert.assertTrue(commonPOM.getFourthTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFourthTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_4_TEXT);

			Assert.assertTrue(commonPOM.getDoneButton().isEnabled()); 
			commonPOM.getDoneButton().click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void gseReingestion() {
		try {
			//Header, Footer 
			Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
			Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
			Assert.assertTrue(commonPOM.getNextButtonFirst().isDisplayed());  // Next button is disabled
			
			//LOB
			Assert.assertEquals(commonPOM.getSelectLOBTitle().getText(), LOMTConstant.SELECT_LOB);
			Assert.assertTrue(commonPOM.getEnglishLOBRadioButton().isDisplayed());
			Assert.assertTrue(commonPOM.getHeLOBRadioButton().isDisplayed());
			Assert.assertTrue(commonPOM.getSchoolGlobalLOBRadioButton().isDisplayed());
			Assert.assertTrue(commonPOM.getNalsLOBRadioButton().isDisplayed());
			
			//Structure
			Assert.assertEquals(commonPOM.getSelectStructureTitle().getText(), LOMTConstant.SELECT_STRUCTURE_TYPE);
			Assert.assertTrue(commonPOM.getGseStructureRadioButton().isEnabled());
			Assert.assertTrue(commonPOM.getProductExternalFrameworkStructureRadioButton().isDisplayed());
			Assert.assertTrue(commonPOM.getGseProductStructureRadioButton().isEnabled());
			
			commonPOM.getGseStructureRadioButton().click();
			Thread.sleep(1000);
			
			//Right options
			Assert.assertTrue(commonPOM.getFirstTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFirstTextMessage().getText(), LOMTConstant.CHOOSE_STRUCTURE_TYPE);			
			Assert.assertTrue(englishPOM.getSecondTextImage().isDisplayed());
			Assert.assertEquals(englishPOM.getSecondTextEnglish().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_2_TEXT);			
			Assert.assertTrue(commonPOM.getThirdTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getThirdTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_3_TEXT);			
			Assert.assertTrue(commonPOM.getFourthTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFourthTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_4_TEXT);
			
			Assert.assertTrue(commonPOM.getNextButtonFirst().isEnabled()); // Next button is enabled
			
			Thread.sleep(2000);
			commonPOM.getNextButtonFirst().click();
			
			 //File upload logic 
			commonPOM.getUploadFileLink().click();
			
			Runtime.getRuntime().exec(LOMTConstant.ENGLISH_GSE_FILE_PATH);
			
			Thread.sleep(3000);
			commonPOM.getNextButtonSt2().click();				
			WebDriverWait wait = new WebDriverWait(driver, 600);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOMTConstant.INGEST_SUCESS_MESSAGE)));
			
			Thread.sleep(2000);
			//Header
			Assert.assertTrue(commonPOM.getBackLinkFirst().isDisplayed());
			Assert.assertEquals(commonPOM.getCreateUploadStructureHeader().getText(), LOMTConstant.CREATE_STRUCTURE_TILE);
			
			//Right options
			Assert.assertTrue(commonPOM.getFirstTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFirstTextMessage().getText(), LOMTConstant.CHOOSE_STRUCTURE_TYPE);			
			Assert.assertTrue(englishPOM.getSecondTextImage().isDisplayed());
			Assert.assertEquals(englishPOM.getSecondTextEnglish().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_2_TEXT);			
			Assert.assertTrue(commonPOM.getThirdTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getThirdTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_3_TEXT);			
			Assert.assertTrue(commonPOM.getFourthTextImage().isDisplayed());
			Assert.assertEquals(commonPOM.getFourthTextMessage().getText(), LOMTConstant.STRUCTURE_PAGE_IMAGE_4_TEXT);

			Assert.assertTrue(commonPOM.getDoneButton().isEnabled()); 
			commonPOM.getDoneButton().click();
			Thread.sleep(2000);
			
			commonPOM.getPearsonLogo().click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeDriverInstance() {
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		driver.close();
	}	

}
