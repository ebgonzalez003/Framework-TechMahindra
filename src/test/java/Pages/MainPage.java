package Pages;
import Maps.MainPageMap;
import Utils.CommonCommands;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MainPage {
    static CommonCommands commands;
    public static MainPageMap mp = new MainPageMap();
    public MainPage(CommonCommands commands) {
        this.commands = commands;
    }

    public  void seeAndContinue(){
        commands.clickElement(mp.viewButton);
        commands.clickElement(mp.ContinueButton);
    }
    public  void seeAndAddToCart(){
        commands.clickElement(mp.viewButton);
        commands.clickElement(mp.addToCartOnViewPage);
        commands.waitForElementToBeClickable(mp.AddInSee);
    }
    public  void filterByName(String articleName){
        commands.sendKeysToElement(mp.SearchBox, articleName);
        commands.sendKeysToElementActions(mp.SearchBox, Keys.ENTER);
    }

    public void addToCart(String productName){
        commands.clickElement(By.xpath("//h5[contains(b, '"+productName+"')]/../button[@class='btn w-10 rounded']"));
    }
    public void priceRange(){
        commands.sendKeysToElement(mp.minPriceRange, "31500");
        commands.sendKeysToElementActions(mp.maxPriceRange, "40000", Keys.ENTER);

    }
    public void categories(){
        commands.clickElement(mp.fashionCat);
        commands.clickElement(mp.householdCat);
    }
    public void subCatError(){
        commands.clickElement(mp.tshirt);
        commands.scrollToElementAndClick(mp.laptopBtn);

        commands.isElementVisible(mp.errorMessage);
    }
}
