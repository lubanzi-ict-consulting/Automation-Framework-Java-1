package verification;

import dataProvider.ConfigFileReader;
import dataProvider.getExcelConnect;
import dataProvider.utlit;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
import register.ElemPosition;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static dataProvider.getExcelConnect.writeExcel;

public class LoginPage extends ElemPosition {
    private ConfigFileReader Configfilereader = new ConfigFileReader();
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void shopBackTapProfile() {
        String getProfileId = Configfilereader.getProperty("profileId");
        getElemById(getProfileId).click();
    }

    public void shopBackClickLogin() {
        String getshopBackloginButtonId = Configfilereader.getProperty("shopBackloginButtonId");
        getElemById(getshopBackloginButtonId).click();
    }

    public void shopBackEnterUserData(String emailID, String password) throws IOException, InterruptedException {
        String getemailTextId = Configfilereader.getProperty("emailTextId");
        String getpaswordTextId = Configfilereader.getProperty("paswordTextId");
        getElemById(getemailTextId).sendKeys(emailID);
        getElemById(getpaswordTextId).sendKeys(password);
        takeScrenshot();
        Thread.sleep(800);
    }

    public void shopBackRegister() {
        String getloginRegisteredId = Configfilereader.getProperty("loginRegisteredId");
        getElemById(getloginRegisteredId).click();
    }

    public String shopBackVerifyUserEarnings() {
        String getuserId = Configfilereader.getProperty("userIDandCashBackId");
        //System.out.println(getElemById(getuserId).getAttribute("text"));
        return getElemById(getuserId).getAttribute("text");
    }

    public String shopBackVerifyBlance() throws IOException {
        String getavailableAlance = Configfilereader.getProperty("availableAlance");
        //System.out.println("Available: "+ getElemById(getavailableAlance).getAttribute("text"));
        takeScrenshot();
        return getElemById(getavailableAlance).getAttribute("text");
    }

    public String shopComparedResult(String expectedEarnings, String expectedBalance, String actualEarnings, String actualBalance ) {
        if ((expectedBalance.equals(actualBalance)) && (expectedEarnings.equals(actualEarnings.substring(actualEarnings.indexOf(":")+1).trim()))){
            return "Pass"; }
        else {
            return "Failed";
        }
    }

    public void shopBackSaveVerifedData(String actualEarnings,String actualBalance,String status) throws IOException {
        getExcelConnect.shotBackwriteExcel(utlit.shopBackfilePath, utlit.shopBackfileName, utlit.shopBackDatatab,actualEarnings,actualBalance,status);
    }
    public void shopBackVerifyHyperLinks() {
    }

    public void takeScrenshot() throws IOException {
        String folderName = "shopBackScreenShot";
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //create dir with given folder name
        new File(folderName).mkdir();
        SimpleDateFormat fileFormat = new SimpleDateFormat("dd-MMM-yyyy_hh_mm_ssaa");
        //Setting file name
        String fileName = fileFormat.format(new Date()) + ".png";
        //coppy screenshot file into screenshot folder.
        FileUtils.copyFile(scrFile,new File(folderName + "/" + fileName));
    }
    public void enterusername(String userName, String passWord) {
        String getUserName = Configfilereader.getProperty("usernameName");
        getElembyName(getUserName).sendKeys(userName);
        String getpassword = Configfilereader.getProperty("passwordName");
        getElembyName(getpassword).sendKeys(passWord);
    }

    public void clicklogin() {
        String getLoginbutton = Configfilereader.getProperty("loginName");
        getElembyName(getLoginbutton).click();
    }

    public void verifiedLoginStatus(String expectedText, String userName, int rowid) throws IOException {
        String testStatus = null;
        String actualText = null;
        try {
            Alert alt = driver.switchTo().alert();
            String altualBoxMsg = alt.getText();
            Thread.sleep(4000);
            alt.accept();
            //String getInvalidMessage = Configfilereader.getProperty("invalidMessage");
            if (altualBoxMsg.contentEquals(expectedText)) {
                System.out.println(expectedText);
                testStatus = "Pass";
                actualText = altualBoxMsg;
            } else {
                System.out.println("here is alert message: " + altualBoxMsg);
                testStatus = "Failed";
                actualText = altualBoxMsg;
            }
        } catch (NoAlertPresentException Ex) {
            String getLoginXpath = Configfilereader.getProperty("verifiedLoginXpath");
            String loginID = null;
            loginID = getElembyXpath(getLoginXpath).getText();
            if (loginID.contains(userName) && loginID.substring(loginID.lastIndexOf(' ') + 1).contentEquals(userName)) {
                System.out.println("This is login ID " + loginID.substring(loginID.lastIndexOf(' ') + 1));
                testStatus = "Pass";
                actualText = loginID;
            } else {
                System.out.println("User id is not correct or not found on the page");
                testStatus = "Failed";
                actualText = "No found User ID";
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        writeExcel(utlit.filePath, utlit.fileName, utlit.Datatab, actualText, testStatus, rowid);
    }

    public void getleftItems() {
        // String getLeftXpath = Configfilereader.getProperty("uiListXpath");
        //System.out.println("left side UI " + getLeftXpath);

        String getLeftXpath = Configfilereader.getProperty("uiListXpath");
        System.out.println("left side UI " + getLeftXpath);
        // System.out.println("left side item1 " + getElembyXpath(getLeftXpath));
        //String getItemClassName = properties.getProperty("itemClassName");
        // System.out.println(("items"+driver.findElements(By.tagName("li"))));
        // List<WebElement> menuItemList = driver.findElements(By.tagName("li"));
        //getElementsClassname(getLeftXpath);

        List<WebElement> menuItemList = getElembyXpath(getLeftXpath).findElements(By.tagName("li"));
        System.out.println("hereis menuItemList " + menuItemList);

        for (int i = 0; i < menuItemList.size(); i++) {

            try {

                String getLeftXpath1 = Configfilereader.getProperty("orange");
                System.out.println(driver.findElement(By.className(getLeftXpath1)));
                driver.findElement(By.className(getLeftXpath1)).click();
                Thread.sleep(3000);
                System.out.println("here menuItmelist text4" + menuItemList.get(i).getText());
                menuItemList.get(i).click();
                System.out.println("here menuItmelist text3" + menuItemList.get(i).getText());
                System.out.println("Pass: " + menuItemList.get(i).getText() + "is clicked");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void shopBackClickSearch() {
        String getSearchBox = Configfilereader.getProperty("searchboxId");
        getElemById(getSearchBox).click();

    }

    public void shopBackSearchKeyWords(String searchedkeywords) throws IOException {
        String getInputSearchBox = Configfilereader.getProperty("lookingForTextId");
        getElemById(getInputSearchBox).sendKeys(searchedkeywords);
        takeScrenshot();
    }

    public void shopBackNoFound() {
        String getSearchResult = Configfilereader.getProperty("greetingId");
        System.out.println(getElemById(getSearchResult).getAttribute("text"));
    }

    public void shopBackFoundRecords() {
        String getSearchResult = Configfilereader.getProperty("greetingId");
        System.out.println(getElemById(getSearchResult).getAttribute("text"));
    }
}
