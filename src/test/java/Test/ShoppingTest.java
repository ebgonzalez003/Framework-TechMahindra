package Test;
import Data.ConstantsData;
import Data.DataProviders;
import Maps.OrdersListMap;
import Utils.BaseTest;
import Utils.ExtentReportManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {
    @Test(groups = {"regression"}, dataProvider = "excelDataProvider", dataProviderClass = DataProviders.class)
    public void validateLoginCredetianls(String username, String password) {
        loginPage.userLogin(username, password);
        Assert.assertTrue(commands.isElementVisible(mainPageMap.signOutButton));
        if (test == null) {
            System.out.println(ConstantsData.ERROR_MESSAGE);
        } else {
            System.out.println(ConstantsData.SUCCESS_MESSAGE);
        }
    }

    @Test(groups = {"regression"}, dataProvider = "excelDataProvider", dataProviderClass = DataProviders.class)
    public void validateLoginWrongCredentials(String username, String password) {
        loginPage.userLogin(ConstantsData.INVALID_USERNAME, ConstantsData.INVALID_PASSWORD);
        Assert.assertEquals(commands.getTextFromElement(mainPageMap.errorMessage), "Incorrect email or password.");
        test  = ExtentReportManager.createTest("errorLogin");
        test.log(Status.INFO, "Successfully created test: errorLogin");
        if (test == null) {
            System.out.println(ConstantsData.ERROR_MESSAGE);
        } else {
            System.out.println(ConstantsData.SUCCESS_MESSAGE);
        }
    }

    @Test(groups = {"smoke"})
    public void validateAddCart() {
        loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.addToCart("IPHONE 13 PRO");
        commands.isElementVisible(By.cssSelector(".mb-3"));
        commands.isElementVisible(mainPageMap.alertMessage);
        commands.waitForElementToDisappear(mainPageMap.spinner);
        commands.clickElement(mainPageMap.shoppingCart);
    }

    @Test(groups = {"smoke"})
    public void validateViewAndContinue() {
        loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.seeAndContinue();
    }

    @Test(groups = {"smoke"})
    public void validateSeeAndAddToCart() {
        loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.seeAndAddToCart();
    }

    @Test(groups = {"regression"})
    public void validateFilterByName() {
        loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.filterByName(ConstantsData.ARTICLE_IPHONE);
        commands.waitForElementToDisappear(mainPageMap.zaraCoatArticleText);
        Assert.assertEquals(commands.getTextFromElement(mainPageMap.filterResNumber), ConstantsData.RESULT_1);
    }

    @Test(groups = {"regression", "smoke"})
    public void validateBuyZaraCoat3() {
        loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.addToCart(ConstantsData.ARTICLE_ZARA_COAT);
        checkOutPage.buyZaraCoat3();
        Assert.assertEquals(commands.getTextFromElement(checkOutPageMap.ThanksMsg), ConstantsData.THANKS_MESSAGE);
    }

    @Test(groups = {"smoke"})
    public void validatePriceRange() {
        loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.priceRange();
        Assert.assertEquals(commands.getTextFromElement(mainPageMap.filterResNumber), ConstantsData.RESULT_4);
    }

    @Test(groups = {"smoke"})
    public void validateSearchByCategories() {
        loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.categories();
        Assert.assertEquals(commands.getTextFromElement(mainPageMap.filterResNumber), ConstantsData.RESULT_1);
    }

    @Test(groups = {"smoke"})
    public void validateProductDoesntAppear() {
        loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.subCatError();
        Assert.assertEquals(commands.getTextFromElement(mainPageMap.filterResNumber), ConstantsData.RESULT_5);
    }

    @Test(groups = {"regression", "smoke"})
    public void validateTheOrderAfterPurchase() {
        loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.addToCart(ConstantsData.ARTICLE_ZARA_COAT);
        OrdersPage.verifyTheOrder();
        Assert.assertEquals(commands.getTextFromElement(OrdersListMap.thanksMsj), ConstantsData.ORDER_THANKS_MESSAGE);
    }

    @Test(groups = {"smoke"})
    public void validateDeleteTheOrder() {
        loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
        OrdersPage.deleteTheOrder();
    }

    @Test (groups = {"smoke"})
    public void validateRequiredFields(){
        loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.addToCart(ConstantsData.ARTICLE_ZARA_COAT);
        checkOutPage.validateRequiredFields();
        Assert.assertFalse(false);

    }
}
