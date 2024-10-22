package Pages;
import Data.ConstantsData;
import Maps.CheckOutPageMap;
import Maps.MainPageMap;
import Maps.OrdersListMap;
import Utils.CommonCommands;

public class OrdersPage {
    CommonCommands commands;
    public OrdersListMap ordersMap = new OrdersListMap();
    public CheckOutPageMap checkOutPageMap = new CheckOutPageMap();
    public MainPageMap mainPageMap = new MainPageMap();
    public OrdersPage(CommonCommands commands) {
        this.commands = commands;
    }
    public void verifyTheOrder(){
        commands.isElementVisible(mainPageMap.waitArticlesToAppear);
        commands.isElementVisible(mainPageMap.alertMessage);
        commands.waitForElementToDisappear(mainPageMap.spinner);
        commands.clickElement(mainPageMap.shoppingCart);
        commands.scrollToElementAndClick(checkOutPageMap.CheckoutBtn);
        commands.sendKeysToElement(checkOutPageMap.CvvBox, ConstantsData.CVV_CODE);
        commands.sendKeysToElement(checkOutPageMap.NameOnCard, ConstantsData.NAME_ON_CARD);
        commands.sendKeysToElement(checkOutPageMap.Country, ConstantsData.COUNTRY);
        commands.clickElement(checkOutPageMap.CountryBtn);
        commands.scrollToElementAndClick(checkOutPageMap.PlaceOrder);
        commands.scrollToElementAndClick(checkOutPageMap.HomeBtn);
        commands.clickElement(ordersMap.ordersBtn);
        commands.clickElement(ordersMap.viewBtnOrders);
    }
    public void deleteTheOrder(){
        commands.clickElement(OrdersListMap.ordersBtn);
        commands.clickElement(OrdersListMap.deleteBtn);
    }

}
