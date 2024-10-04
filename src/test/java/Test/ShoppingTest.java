package Test;
import Data.ConstantsData;
import Maps.OrdersListMap;
import Utils.BaseTest;
import Utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {

    @Test(groups = {"regression"})
    public void validateLoginCredetianls() {
        loginPage.userLogin(ConstantsData.VALIDUSERNAME, ConstantsData.VALID_PASSWORD);
        Assert.assertTrue(commands.isElementVisible(mainPageMap.signOutButton));
        test  = ExtentReportManager.createTest("testLogin");
        test.log(Status.INFO, "Successfully created test: testLogin");
        if (test == null) {
            System.out.println("Error: Could not create test in Extent Reports.");
        } else {
            System.out.println("Test created correctly in Extent Reports.");
        }
    }

    @Test(groups = {"regression"})
    public void validateLoginWrongCredentials() {
        loginPage.userLogin(ConstantsData.INVALIDUSERNAME, ConstantsData.INVALID_PASSWORD);
        Assert.assertEquals(commands.getTextFromElement(mainPageMap.errorMessage), "Incorrect email or password.");
    }

    @Test(groups = {"smoke"})
    public void validateAddCart() {
        loginPage.userLogin(ConstantsData.VALIDUSERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.addToCart("IPHONE 13 PRO");
        commands.isElementVisible(By.cssSelector(".mb-3"));
        commands.isElementVisible(mainPageMap.alertMessage);
        commands.waitForElementToDisappear(mainPageMap.spinner);
        commands.clickElement(mainPageMap.shoppingCart);

    }

    @Test(groups = {"smoke"})
    public void validateViewAndContinue() {
        loginPage.userLogin(ConstantsData.VALIDUSERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.seeAndContinue();
    }

    @Test(groups = {"smoke"})
    public void validateSeeAndAddToCart() {
        loginPage.userLogin(ConstantsData.VALIDUSERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.seeAndAddToCart();
    }

    @Test(groups = {"regression"})
    public void validateFilterByName() {
        loginPage.userLogin(ConstantsData.VALIDUSERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.filterByName(ConstantsData.ARTICLEIPHONE);
        commands.waitForElementToDisappear(mainPageMap.zaraCoatArticleText);
        Assert.assertEquals(commands.getTextFromElement(mainPageMap.filterResNumber), ConstantsData.RESULT2);
    }

    @Test(groups = {"regression", "smoke"})
    public void validateBuyZaraCoat3() {
        loginPage.userLogin(ConstantsData.VALIDUSERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.addToCart(ConstantsData.ARTICLEZARACOAT);
        checkOutPage.buyZaraCoat3();
        Assert.assertEquals(commands.getTextFromElement(checkOutPageMap.ThanksMsg), ConstantsData.THANKSMESSAGE);
    }

    @Test(groups = {"smoke"})
    public void validatePriceRange() {
        loginPage.userLogin(ConstantsData.VALIDUSERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.priceRange();
        Assert.assertEquals(commands.getTextFromElement(mainPageMap.filterResNumber), ConstantsData.RESULT4);
    }

    @Test(groups = {"smoke"})
    public void validateSearchByCategories() {
        loginPage.userLogin(ConstantsData.VALIDUSERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.categories();
        Assert.assertEquals(commands.getTextFromElement(mainPageMap.filterResNumber), ConstantsData.RESULT1);
    }

    @Test(groups = {"smoke"})
    public void validateProductDoesntAppear() {
        loginPage.userLogin(ConstantsData.VALIDUSERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.subCatError();
        Assert.assertEquals(commands.getTextFromElement(mainPageMap.filterResNumber), ConstantsData.RESULT5);
    }

    // @Test(groups = {"regression", "smoke"})
    // public void validateBuyMoreProducts() {
    //     ArrayList<String> products = new ArrayList<>();
    //     products.add(ConstantsData.ARTICLEIPHONE);
    //     products.add(ConstantsData.ARTICLEZARACOAT);
    //     loginPage.userLogin(ConstantsData.VALIDUSERNAME, ConstantsData.VALID_PASSWORD);
    //     products.forEach(product -> {
    //         mainPage.addToCart(product);
    //     });
    //     checkOutPage.buyMoreProducts();
    //     Assert.assertEquals(commands.getTextFromElement(checkOutPageMap.ThanksMsg), ConstantsData.THANKSMESSAGE, "El mensaje de agradecimiento no es correcto.");
    // }
    @Test(groups = {"regression", "smoke"})
    public void validateTheOrderAfterPurchase() {
        loginPage.userLogin(ConstantsData.VALIDUSERNAME, ConstantsData.VALID_PASSWORD);
        mainPage.addToCart(ConstantsData.ARTICLEZARACOAT);
        OrdersPage.verifyTheOrder();
        Assert.assertEquals(commands.getTextFromElement(OrdersListMap.thanksMsj), ConstantsData.ORDERTHANKSMSJ);
    }

    @Test(groups = {"smoke"})
    public void validateDeleteTheOrder() {
        loginPage.userLogin(ConstantsData.VALIDUSERNAME, ConstantsData.VALID_PASSWORD);
        OrdersPage.deleteTheOrder();
    }
}
