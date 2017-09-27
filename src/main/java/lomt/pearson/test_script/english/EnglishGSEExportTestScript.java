package lomt.pearson.test_script.english;

import lomt.pearson.api.gse.EnglishGSEExport;
import lomt.pearson.constant.LOMTConstant;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EnglishGSEExportTestScript {
	
	ExtentTest logger;
	ExtentReports reports = new ExtentReports(LOMTConstant.REPORT_FILE_PATH, true); 
	
	EnglishGSEExport gseExport = new EnglishGSEExport();

	@Test(priority = 0)
	public void PreTest_Setup() {
		logger = reports.startTest("LOMTLogin", "LOMT login in-process");
		gseExport.openBrowser();
		logger.log(LogStatus.INFO, "LOMT login is in progress");
		
		gseExport.login();
		
		logger.log(LogStatus.PASS, "Successfully logged-in in LOMT application");
		reports.endTest(logger);
		reports.flush();
	}

	/*@Test
	@Ignore
	public void gseGoalFrameworkExport() throws Exception {
		gseExport.gseGoalFrameworkExport();
		System.out.println("GSE Export is done :  ");
	}*/
	
	@Test(priority = 1)
	public void gseEducationalGoalFrameworkExport() throws Exception {
		gseExport.gseEducationalGoalFrameworkExport();
		System.out.println("GSE Export is done :  ");
	}

	@Test(priority = 2)
	public void tearDown() throws InterruptedException {
		gseExport.closeDriverInstance();
	}
}
