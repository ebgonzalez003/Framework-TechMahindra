package Pages;
import Maps.LoginPageMap;
import Utils.CommonCommands;

public class LoginPage {
    CommonCommands commands;
    LoginPageMap lg = new LoginPageMap();
    public LoginPage(CommonCommands commands) {
        this.commands = commands;
    }

    public void userLogin(String userName, String password){
        commands.sendKeysToElement(lg.LoginPageUserName,userName);
        commands.sendKeysToElement(lg.LoginPagePassword, password);
        commands.clickElement(lg.LoginPageLoginBtn);
    }
}
