package rahulshettybreakdown.hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettybreakdown.pagemethods.CartPageMethods;
import rahulshettybreakdown.pagemethods.LoginPageMethods;
import rahulshettybreakdown.resources.ReportConfiguration;

//sayan manna

//main class of the framework 
public class Hooks {

	public static WebDriver driver;
	public LoginPageMethods loginpage;

	// initializing the browser
	public WebDriver InitializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fils = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\resource\\config\\GlobalData.properties");
		prop.load(fils);

		String BrowserName = prop.getProperty("browser");
//		String BrowserName = System.getProperty("browser") != null ? System.getProperty("browser")
//				: prop.getProperty("browser");

		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (BrowserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver;
	}

	// launch browser
	@BeforeMethod(alwaysRun = true)
	public LoginPageMethods LaunchApplication() throws IOException {
		driver = InitializeDriver();
		loginpage = new LoginPageMethods(driver);
		loginpage.getUrl();
		return loginpage;

	}

	// Close browser
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	
	
	@AfterMethod
	public void teardown () {
		ExtentReports reports = ReportConfiguration.ConfigTestReport();
		@SuppressWarnings("unused")
		ExtentTest test =reports.createTest("Sayan");
		reports.flush();
	}
	}

	// take screenshots


