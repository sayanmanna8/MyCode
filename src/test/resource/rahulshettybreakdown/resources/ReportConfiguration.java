package rahulshettybreakdown.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportConfiguration {
	
	//Setting configuration of extends reports

	public static ExtentReports ConfigTestReport() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Test Report");
		reporter.config().setDocumentTitle("Test Report");

		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Name", "Sayan Manna");
		return report;
	}

}
