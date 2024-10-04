package Maps;

import org.openqa.selenium.By;

public class MainPageMap {
    public By CartButton = By.xpath("//section[@id='products']/div/div/div/div/div/button[2]/i[1]");
    public By viewButton = By.cssSelector("button[class='btn w-40 rounded']");
    public By ContinueButton = By.cssSelector("a[class='continue']");
    public By AddCartOnViewBtn = By.cssSelector("button[class='btn btn-primary']");
    public By signOutButton = By.cssSelector("i.fa-sign-out");
    public By errorMessage = By.cssSelector("div#toast-container div");
    public By alertMessage = By.cssSelector("div#toast-container");
    public By addMessage = By.cssSelector("div[class='toast-bottom-right toast-container']");
    public By spinner = By.cssSelector(".ng-animating");
    public By shoppingCart = By.cssSelector("button[routerlink='/dashboard/cart']");
    public By addToCartOnViewPage = By.xpath("//div[@class='product-buttons']/button[@class='btn btn-primary']");
    public By SearchBox = By.xpath("//section[@id='sidebar']/form/div//input[@name='search']");
    public By CartButtonOnPrincipal = By.xpath("//app-dashboard[@class='ng-star-inserted']/app-sidebar/nav/ul/li[4]/button[@class='btn btn-custom'][1]");
    public By waitArticlesToAppear = By.cssSelector(".mb-3");
    public By filterResNumber = By.cssSelector("#res");
    public By zaraCoatArticleText = By.xpath("//*[text()='ZARA COAT 3']");
    public By minPriceRange = By.xpath("//*[@id='sidebar']/form/div[2]/div/div[1]/input");
    public By maxPriceRange = By.xpath("//*[@id='sidebar']/form/div[2]/div/div[2]/input");
    public By fashionCat = By.xpath("//*[@id='sidebar']/form/div[3]/div[2]/input");
    public By householdCat = By.xpath("//*[@id='sidebar']/form/div[3]/div[4]/input");
    public By notFound = By.xpath("//div[@class = 'ng-tns-c4-4 toast-title ng-star-inserted']");
    public By tshirt = By.xpath("//*[@id='sidebar']/form/div[4]/div[2]/input");
    public By laptopBtn = By.xpath("//*[@id='sidebar']/form/div[4]/div[6]/input");
    public By AddInSee = By.xpath("//div/div/div[2]/div/div[1]/button");

}
