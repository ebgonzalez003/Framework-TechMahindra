package Maps;
import org.openqa.selenium.By;
public class CheckOutPageMap {
    public By OrdersBtn = By.xpath("//app-sidebar/nav/ul/li[3]/button");
    public By CheckoutBtn = By.xpath("//div[@class='subtotal cf ng-star-inserted']/ul/li[3]/button");
    public By CvvBox = By.xpath("//form//div[2]/input");
    public By NameOnCard = By.xpath("//form/div/div[3]/div/input");
    public By Country = By.xpath("//input[@placeholder='Select Country']");
    public By PlaceOrder = By.xpath("//a[@class='btnn action__submit ng-star-inserted']");
    public By CountryBtn = By.xpath("//span[@class='ng-star-inserted']");
    public By ThanksMsg = By.xpath("//h1");
    public By HomeBtn = By.xpath("//app-thanksorder/app-sidebar/nav/ul/li[1]/button");
}
