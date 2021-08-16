package modules;
import helpers.Log;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import pageobjects.AutomationHomePage;
import pageobjects.QlityGigsLoginPage;

public class SignInAction {
	public static void Execute(WebDriver driver,List<HashMap<String,String>> map) throws Exception{
		AutomationHomePage.sign_in.click();
		Log.info("Click action is perfromed on My Account link" );
		QlityGigsLoginPage.email.sendKeys(map.get(0).get("username"));
		Log.info(" is entered in UserName text box" );
		QlityGigsLoginPage.password.sendKeys(map.get(0).get("password"));
		Log.info(" is entered in Password text box" );
		QlityGigsLoginPage.signin_button.click();
		Log.info("Click action is performed on Submit button");
		Reporter.log("SignIn Action is successfully perfomred");
	}
}
