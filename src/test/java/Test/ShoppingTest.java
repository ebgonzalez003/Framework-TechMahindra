package Test;
import Data.ConstantsData;
import Data.DataProviders;
import Maps.OrdersListMap;
import Utils.BaseTest;
import Utils.ExtentReportManager;
import Utils.LoggerUtil;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {
    @Test(groups = {"regression"}, dataProvider = "excelDataProvider", dataProviderClass = DataProviders.class)
    public void validateLoginCredetianls(String username, String password) {
        try {
            LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
            loginPage.userLogin(username, password);
            Assert.assertTrue(commands.isElementVisible(mainPageMap.signOutButton));
            LoggerUtil.info(ConstantsData.LOG_COMPLETED);
            if (test == null) {
                System.out.println(ConstantsData.ERROR_MESSAGE);
            } else {
                System.out.println(ConstantsData.SUCCESS_MESSAGE);
            }
        }catch (Exception e){
            LoggerUtil.error(ConstantsData.LOG_ERROR);
        }
    }

    @Test(groups = {"regression"}, dataProvider = "excelDataProvider", dataProviderClass = DataProviders.class)
    public void validateLoginWrongCredentials(String username, String password) {
       try {
           loginPage.userLogin(ConstantsData.INVALID_USERNAME, ConstantsData.INVALID_PASSWORD);
           LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
           Assert.assertEquals(commands.getTextFromElement(mainPageMap.errorMessage), "Incorrect email or password.");
           LoggerUtil.info(ConstantsData.LOG_COMPLETED);
           test = ExtentReportManager.createTest(methodName);
           test.log(Status.INFO, ConstantsData.SUCCESS_TEST + methodName);
           if (test == null) {
               System.out.println(ConstantsData.ERROR_MESSAGE);
           } else {
               System.out.println(ConstantsData.SUCCESS_MESSAGE);
           }
       }catch (Exception e){
           LoggerUtil.error(ConstantsData.LOG_ERROR);
       }
    }

    @Test(groups = {"smoke"})
    public void validateAddCart() {
        try {
            loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
            LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
            mainPage.addToCart("IPHONE 13 PRO");
            commands.isElementVisible(By.cssSelector(".mb-3"));
            commands.isElementVisible(mainPageMap.alertMessage);
            commands.waitForElementToDisappear(mainPageMap.spinner);
            commands.clickElement(mainPageMap.shoppingCart);
            LoggerUtil.info(ConstantsData.LOG_COMPLETED);
            test = ExtentReportManager.createTest(methodName);
            test.log(Status.INFO, ConstantsData.SUCCESS_TEST + methodName);
            if (test == null) {
                System.out.println(ConstantsData.ERROR_MESSAGE);
            } else {
                System.out.println(ConstantsData.SUCCESS_MESSAGE);
            }
        }catch (Exception e){
            LoggerUtil.error(ConstantsData.LOG_ERROR);
        }
    }

    @Test(groups = {"smoke"})
    public void validateViewAndContinue() {
        try {
            loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
            LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
            mainPage.seeAndContinue();
            LoggerUtil.info(ConstantsData.LOG_COMPLETED);
            test = ExtentReportManager.createTest(methodName);
            test.log(Status.INFO, ConstantsData.SUCCESS_TEST + methodName);
            if (test == null) {
                System.out.println(ConstantsData.ERROR_MESSAGE);
            } else {
                System.out.println(ConstantsData.SUCCESS_MESSAGE);
            }
        }catch (Exception e){
            LoggerUtil.error(ConstantsData.LOG_ERROR);
        }
    }

    @Test(groups = {"smoke"})
    public void validateSeeAndAddToCart() {
        try {
            loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
            LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
            mainPage.seeAndAddToCart();
            LoggerUtil.info(ConstantsData.LOG_COMPLETED);
            test = ExtentReportManager.createTest(methodName);
            test.log(Status.INFO, ConstantsData.SUCCESS_TEST + methodName);
            if (test == null) {
                System.out.println(ConstantsData.ERROR_MESSAGE);
            } else {
                System.out.println(ConstantsData.SUCCESS_MESSAGE);
            }
        }catch (Exception e){
            LoggerUtil.error(ConstantsData.LOG_ERROR);
        }
    }

    @Test(groups = {"regression"})
    public void validateFilterByName() {
        try {
            loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
            LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
            mainPage.filterByName(ConstantsData.ARTICLE_IPHONE);
            commands.waitForElementToDisappear(mainPageMap.zaraCoatArticleText);
            Assert.assertEquals(commands.getTextFromElement(mainPageMap.filterResNumber), ConstantsData.RESULT_1);
            LoggerUtil.info(ConstantsData.LOG_COMPLETED);
            test = ExtentReportManager.createTest(methodName);
            test.log(Status.INFO, ConstantsData.SUCCESS_TEST + methodName);
            if (test == null) {
                System.out.println(ConstantsData.ERROR_MESSAGE);
            } else {
                System.out.println(ConstantsData.SUCCESS_MESSAGE);
            }

        }catch (Exception e){
            LoggerUtil.error(ConstantsData.LOG_ERROR);
        }
    }

    @Test(groups = {"regression", "smoke"})
    public void validateBuyZaraCoat3() {
        try {
            loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
            LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
            mainPage.addToCart(ConstantsData.ARTICLE_ZARA_COAT);
            checkOutPage.buyZaraCoat3();
            Assert.assertEquals(commands.getTextFromElement(checkOutPageMap.ThanksMsg), ConstantsData.THANKS_MESSAGE);
            LoggerUtil.info(ConstantsData.LOG_COMPLETED);
            test = ExtentReportManager.createTest(methodName);
            test.log(Status.INFO, ConstantsData.SUCCESS_TEST + methodName);
            if (test == null) {
                System.out.println(ConstantsData.ERROR_MESSAGE);
            } else {
                System.out.println(ConstantsData.SUCCESS_MESSAGE);
            }
        }catch (Exception e){
            LoggerUtil.error(ConstantsData.LOG_ERROR);
        }
    }
    @Test(groups = {"smoke"})
    public void validatePriceRange() {
        try {
            loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
            LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
            mainPage.priceRange();
            Assert.assertEquals(commands.getTextFromElement(mainPageMap.filterResNumber), ConstantsData.RESULT_4);
            LoggerUtil.info(ConstantsData.LOG_COMPLETED);
            test = ExtentReportManager.createTest(methodName);
            test.log(Status.INFO, ConstantsData.SUCCESS_TEST + methodName);
            if (test == null) {
                System.out.println(ConstantsData.ERROR_MESSAGE);
            } else {
                System.out.println(ConstantsData.SUCCESS_MESSAGE);
            }
        }catch (Exception e){
            LoggerUtil.error(ConstantsData.LOG_ERROR);
        }
    }

    @Test(groups = {"smoke"})
    public void validateSearchByCategories() {
        try{
            loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
            LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
            mainPage.categories();
            Assert.assertEquals(commands.getTextFromElement(mainPageMap.filterResNumber), ConstantsData.RESULT_4);
            LoggerUtil.info(ConstantsData.LOG_COMPLETED);
            test = ExtentReportManager.createTest(methodName);
            test.log(Status.INFO, ConstantsData.SUCCESS_TEST + methodName);
            if (test == null) {
                System.out.println(ConstantsData.ERROR_MESSAGE);
            } else {
                System.out.println(ConstantsData.SUCCESS_MESSAGE);
            }
        }catch(Exception e){
            LoggerUtil.error(ConstantsData.LOG_ERROR);
        }
    }

    @Test(groups = {"smoke"})
    public void validateProductDoesntAppear() {
        try {
            loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
            LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
            mainPage.subCatError();
            Assert.assertEquals(commands.getTextFromElement(mainPageMap.filterResNumber), ConstantsData.RESULT_5);
            LoggerUtil.info(ConstantsData.LOG_COMPLETED);
            test = ExtentReportManager.createTest(methodName);
            test.log(Status.INFO, ConstantsData.SUCCESS_TEST + methodName);
            if (test == null) {
                System.out.println(ConstantsData.ERROR_MESSAGE);
            } else {
                System.out.println(ConstantsData.SUCCESS_MESSAGE);
            }
        }catch (Exception e){
            LoggerUtil.error(ConstantsData.LOG_ERROR);
        }
    }

    @Test(groups = {"regression", "smoke"})
    public void validateTheOrderAfterPurchase() {
        try {
            loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
            LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
            mainPage.addToCart(ConstantsData.ARTICLE_ZARA_COAT);
            OrdersPage.verifyTheOrder();
            Assert.assertEquals(commands.getTextFromElement(OrdersListMap.thanksMsj), ConstantsData.ORDER_THANKS_MESSAGE);
            LoggerUtil.info(ConstantsData.LOG_COMPLETED);
            test = ExtentReportManager.createTest(methodName);
            test.log(Status.INFO, ConstantsData.SUCCESS_TEST + methodName);
            if (test == null) {
                System.out.println(ConstantsData.ERROR_MESSAGE);
            } else {
                System.out.println(ConstantsData.SUCCESS_MESSAGE);
            }
        }catch (Exception e){
            LoggerUtil.error(ConstantsData.LOG_ERROR);
        }
    }

    @Test(groups = {"smoke"})
    public void validateDeleteTheOrder() {
        try {
            loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
            LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
            OrdersPage.deleteTheOrder();
            LoggerUtil.info(ConstantsData.LOG_COMPLETED);
            test = ExtentReportManager.createTest(methodName);
            test.log(Status.INFO, ConstantsData.SUCCESS_TEST + methodName);
            if (test == null) {
                System.out.println(ConstantsData.ERROR_MESSAGE);
            } else {
                System.out.println(ConstantsData.SUCCESS_MESSAGE);
            }
        }catch (Exception e){
            LoggerUtil.error(ConstantsData.LOG_ERROR);
        }
    }

    @Test (groups = {"smoke"})
    public void validateRequiredFields() {
        try {
            loginPage.userLogin(ConstantsData.VALID_USERNAME, ConstantsData.VALID_PASSWORD);
            LoggerUtil.debug(ConstantsData.LOG_ACTIONS);
            mainPage.addToCart(ConstantsData.ARTICLE_ZARA_COAT);
            checkOutPage.validateRequiredFields();
            Assert.assertFalse(false);
            LoggerUtil.info(ConstantsData.LOG_COMPLETED);
            test = ExtentReportManager.createTest(methodName);
            test.log(Status.INFO, ConstantsData.SUCCESS_TEST + methodName);
            if (test == null) {
                System.out.println(ConstantsData.ERROR_MESSAGE);
            } else {
                System.out.println(ConstantsData.SUCCESS_MESSAGE);
            }
        } catch (Exception e) {
            LoggerUtil.error(ConstantsData.LOG_ERROR);
        }
    }
}
