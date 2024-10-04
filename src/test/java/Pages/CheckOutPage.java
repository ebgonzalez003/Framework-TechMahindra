package Pages;
import Data.ConstantsData;
import Maps.CheckOutPageMap;
import Maps.MainPageMap;
import Utils.CommonCommands;

public class CheckOutPage {
    CommonCommands commands;

    public CheckOutPageMap checkOutPageMap = new CheckOutPageMap();
    public MainPageMap mainPageMap = new MainPageMap();
    public CheckOutPage(CommonCommands commands) {
        this.commands = commands;
    }
    public void buyZaraCoat3(){
        commands.isElementVisible(mainPageMap.waitArticlesToAppear);
        commands.isElementVisible(mainPageMap.alertMessage);
        commands.waitForElementToDisappear(mainPageMap.spinner);
        commands.clickElement(mainPageMap.shoppingCart);
        commands.scrollToElementAndClick(checkOutPageMap.CheckoutBtn);
        commands.sendKeysToElement(checkOutPageMap.CvvBox, ConstantsData.CVV_BOX);
        commands.sendKeysToElement(checkOutPageMap.NameOnCard, ConstantsData.NAMECARD);
        commands.sendKeysToElement(checkOutPageMap.Country, ConstantsData.COUNTRY);
        commands.clickElement(checkOutPageMap.CountryBtn);
        commands.scrollToElementAndClick(checkOutPageMap.PlaceOrder);

    }

}

