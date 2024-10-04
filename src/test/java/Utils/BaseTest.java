package Utils;
import Maps.CheckOutPageMap;
import Maps.MainPageMap;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.CheckOutPage;
import Pages.OrdersPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    public CommonCommands commands;
    public MainPageMap mainPageMap = new MainPageMap();
    public MainPage mainPage;
    public CheckOutPageMap checkOutPageMap = new CheckOutPageMap();
    public LoginPage loginPage ;
    public CheckOutPage checkOutPage ;
    public OrdersPage OrdersPage;
    public ExtentTest test;
    ExtentReports extent;

    @BeforeMethod(groups = {"regression","smoke"})
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/client");
        commands = new CommonCommands(driver);
        loginPage = new LoginPage(commands);
        mainPage = new MainPage(commands);
        checkOutPage= new CheckOutPage(commands);
        OrdersPage = new OrdersPage(commands);
        extent = ExtentReportManager.getInstance();
    }
    @AfterMethod(groups = {"regression"})
    public void tearDown(){
        //if(driver!= null) driver.quit();
    }
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());
                test.fail("Test Failed " + result.getThrowable().getMessage())
                        .addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ExtentReportManager.closeReport();
    }
}