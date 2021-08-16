package register;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class shopBackDefinition {

    private PageObjectManager PageObjectManager;
    private WebDriver driver;
    private String earnAmont;
    private String blanace;
    private String status;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("VERSION", "7.1.1");
        capabilities.setCapability("deviceName", "OPPO R11s");
        capabilities.setCapability("appPackage", "com.shopback.app");
        capabilities.setCapability("appActivity", "com.shopback.app.ui.main.MainActivity");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        // Driver= new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        //driver = androidDriver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^User is on main page$")
    public void user_is_on_main_page() throws Throwable {
        PageObjectManager = new PageObjectManager(driver);
        PageObjectManager.getLoginPage().shopBackTapProfile();
    }

    @When("^User taps on Profile icon$")
    public void user_taps_on_Profile_icon() throws Throwable {
        PageObjectManager.getLoginPage().shopBackTapProfile();
    }

    @When("^User clicks on Log In$")
    public void user_clicks_on_Log_In() throws Throwable {
        PageObjectManager.getLoginPage().shopBackClickLogin();
    }

    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_EmailId_and_Password(String userEmail, String passWord) throws Throwable {
       PageObjectManager.getLoginPage().shopBackEnterUserData(userEmail, passWord);
    }

    @When("^User clicks on LogIn$")
    public void user_clicks_on_LogIn() throws Throwable {
      Thread.sleep(800);
      PageObjectManager.getLoginPage().shopBackRegister();
    }

    @Then("^User Earning is showing$")
    public void email_id_is_showing() throws Throwable {
        Thread.sleep(800);
        earnAmont = PageObjectManager.getLoginPage().shopBackVerifyUserEarnings();
    }

    @Then("^Available Balance is seen$")
    public void available_Balance_is_seen() throws Throwable {
        blanace = PageObjectManager.getLoginPage().shopBackVerifyBlance();
    }

    @Then("^Compared \"(.*)\" and \"(.*)\"")
    public void Compared_earning_balance(String userEarning,String AvailableBalance) throws Throwable {
        status = PageObjectManager.getLoginPage().shopComparedResult(userEarning,AvailableBalance,earnAmont,blanace);
    }

    @Then("^Save tested userid and Earning and Balance into excel$")
    public void save_data_into_Excel() throws Throwable {
       PageObjectManager.getLoginPage().shopBackSaveVerifedData(earnAmont,blanace,status);
    }

    @When("^User taps on Search icon$")
    public void taps_Search_icon() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PageObjectManager.getLoginPage().shopBackClickSearch();
    }

    @When("^User enters searched keywords (.*?)$")
    public void searched_keywords(String searchedkeywords) throws Throwable {
        Thread.sleep(800);
        PageObjectManager.getLoginPage().shopBackSearchKeyWords(searchedkeywords);
    }

    @Then("^Captured searched result page$")
    public void shown_no_found() throws Throwable {
        PageObjectManager.getLoginPage().shopBackNoFound();
        driver.navigate().back();
    }

    @Then("^Fectch founded recoreds if not empty$")
    public void fectch_founded_recoreds() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PageObjectManager.getLoginPage().shopBackFoundRecords();
    }

}
