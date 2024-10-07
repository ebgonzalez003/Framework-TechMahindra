package Maps;

import org.openqa.selenium.By;

public class OrdersListMap {
    public static By ordersBtn = By.xpath("//app-sidebar/nav/ul/li[3]/button");
    public static By viewBtnOrders = By.xpath("//app-myorders/div[1]/table/tbody/tr[1]/td[5]/button");
    public static By thanksMsj = By.xpath("//app-order-details/div/div/div/div/div[1]/p");
    public static By deleteBtn = By.xpath("//app-myorders/div[1]/table/tbody/tr[1]/td[6]/button");
}
