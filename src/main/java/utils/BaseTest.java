package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeTest
    public void startReport(){
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ File.separator+ "reports"+File.separator + "AutomationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Report");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Avneet Singh");
    }

    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void setupMethod(String browserName, Method testMethod){
        logger = extent.createTest(testMethod.getName());
        setupDriver(browserName);
        driver.get(Constants.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        dismissSavingsPopUp();
    }
    @AfterMethod
    public void tearDown(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL,m);
        }
        else if(result.getStatus() == ITestResult.SUCCESS){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS,m);
        }
        else {
            logger.log(Status.SKIP, result.getTestName());
        }
        //driver.quit();
    }
    @AfterTest
    public void teardownReport(){
        extent.flush();
    }

    public void setupDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            //WebDriverManager.chromedriver().setup();
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            //WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
           // WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }
    public void dismissSavingsPopUp(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bx-form-2131232-step-1")));
            driver.findElement(By.id("bx-close-inside-2131232")).click();
            driver.navigate().refresh();
        }
        catch (Exception e){
            logger.skip("Savings pop up did not appear.");
        }
    }
}
