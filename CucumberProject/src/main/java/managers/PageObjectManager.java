package managers;

import org.openqa.selenium.WebDriver;
import verification.LoginPage;
import verification.leftItemVerify;

public class PageObjectManager {
    private WebDriver driver;
    private LoginPage loginPage;
    private leftItemVerify leftSideMenu;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public leftItemVerify getLeftSideMenu(){
        return (leftSideMenu==null) ? leftSideMenu = new leftItemVerify(driver):leftSideMenu;
    }
}
