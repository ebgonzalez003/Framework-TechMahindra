package Maps;

import org.openqa.selenium.By;

public class LoginPageMap {
    public By LoginPageUserName = By.cssSelector("input[id='userEmail']");
    public By LoginPagePassword = By.cssSelector("input[id=userPassword]");
    public By LoginPageLoginBtn = By.cssSelector("input[id='login']");
}
