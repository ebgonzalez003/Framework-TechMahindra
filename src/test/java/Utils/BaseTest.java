package Utils;

import Maps.CheckOutPageMap;
import Maps.LoginPageMap;
import Maps.MainPageMap;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.CheckOutPage;
import Pages.OrdersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    }
    @AfterMethod(groups = {"regression"})
    public void tearDown(){
        //if(driver!= null) driver.quit();
    }
}