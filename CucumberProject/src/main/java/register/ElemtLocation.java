package register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;


public class ElemtLocation {
    public final WebDriver driver;
    public final Properties properties;
    private List<WebElement> getElems;


    public ElemtLocation(WebDriver driver, Properties properties) {
        this.driver = driver;
        this.properties = properties;

    }


    public WebElement getElementbyID(String searchedElementid) {
        WebElement getElemID = driver.findElement(By.id(searchedElementid));
        if (getElemID != null) {
            return getElemID;
        } else {
            return null;
        }
    }

    public List<WebElement> getElementsClassname(String searchedElementitem) {
        getElems = driver.findElements(By.className(searchedElementitem));
        if (getElems != null) {
            return getElems;
        } else {
            return null;
        }
    }

    public WebElement getElementbyName(String searchedElementName) {
        WebElement getElemName = driver.findElement(By.name(searchedElementName));
        if (getElemName != null) {
            return getElemName;
        } else {
            return null;
        }
    }

    public WebElement getElementbyXpath(String searchedElementXpath) {
        WebElement getElemPath = driver.findElement(By.xpath(searchedElementXpath));
        if (getElemPath != null) {
            return getElemPath;
        } else {
            return null;
        }
    }

    public void logoutBGP() {
        String getlogoutBGP = properties.getProperty("logoutbuttonId");
        getElementbyID(getlogoutBGP).click();
        driver.quit();
    }

    public void LoginGrantPortal(String currentloginUser) {
        String getLoginbutton = properties.getProperty("loginButtonId");
        String getLoginUserName = properties.getProperty("loginUserName");
        String getLoginButtonPath = properties.getProperty("loginButtonXpath");

        getElementbyID(getLoginbutton).click();
        getElementbyName(getLoginUserName).clear();
        getElementbyName(getLoginUserName).sendKeys(currentloginUser);
        getElementbyXpath(getLoginButtonPath).click();
    }

    public void gettingNewGrantClick() {
        String getNewGrantXpath = properties.getProperty("GetNewGrantXpath");
        getElementbyXpath(getNewGrantXpath).click();
    }

    public void buildingAndConstr() {
        String getBuildingAndConstructionXpath = properties.getProperty("BuildingAndConstructionXpath");
        getElementbyXpath(getBuildingAndConstructionXpath).click();
    }

    public void subBuildingAndConstr() {
        String getSubBuildingAndConstructionXpath = properties.getProperty("SubBuildingAndConstructionXpath");
        getElementbyXpath(getSubBuildingAndConstructionXpath).click();
    }

    public void itemSelect() {
        String getItemXpath = properties.getProperty("itemSelectXpath");
        getElementbyXpath(getItemXpath).click();
    }

    public void nextItemSelect() {
        String getNextItemXpath = properties.getProperty("nextItemSelectXpath");
        getElementbyXpath(getNextItemXpath).click();
    }

    public void applyButton() {
        String getApplyButtonId = properties.getProperty("applybuttonId");
        getElementbyID(getApplyButtonId).click();
    }

    public void proceedButton() {
        String getproceedButtonId = properties.getProperty("proceedButtonId");
        getElementbyID(getproceedButtonId).click();
    }

/*    public void verifyQuestion(String askedQuestion) {
        if ((driver.getPageSource().contains(askedQuestion))) {
            System.out.println("you are in question page");
        }
    }*/

 /*   private void toggledRadiobutton(String selectedOption) {
        String getRadioXpath;
        if (selectedOption.equals("Yes")) {
            getRadioXpath = properties.getProperty("answerYesXpath");
        } else {
            getRadioXpath = properties.getProperty("answerNoXpath");
        }
        System.out.println(getElementbyXpath(getRadioXpath));
        getElementbyXpath(getRadioXpath).click();
    }*/

   /* public void verifyItemsOnQuestionPage(String selectedOption) {

        switch (selectedOption) {

            case "Yes":
                toggledRadiobutton(selectedOption);

                System.out.println(getRadioStatus(0));
                System.out.println(getRadioStatus(1));
                break;
            case "No":
                toggledRadiobutton(selectedOption);

                System.out.println(getRadioStatus(0));
                System.out.println(getRadioStatus(1));
                break;
            case "Unselected":
                System.out.println(getRadioStatus(0));
                System.out.println(getRadioStatus(1));
                //Assert.assertEquals(getRadioStatus(0), expectedRadioStatus);
                //Assert.assertEquals(getRadioStatus(1), expectedRadioStatus);
                break;
        }
    }
*/
  /*  public void getNextbuttonStatus() {
        String getnextButtonId = properties.getProperty("nextButtonId");

        getElementbyID(getnextButtonId);
        System.out.println("NextButton ewtrwterwr ertwter " + getElementbyID(getnextButtonId));
        if (getnextButtonId != null) {
            System.out.println("herer is next button= " + getElementbyID(getnextButtonId).isEnabled());

            if (getElementbyID(getnextButtonId).isEnabled()) {
                System.out.println("NextButton is allowed to click");
            } else {
                System.out.println("NextButton is not to click");
            }
        } else {
            System.out.println("NextButton is not seen on the page");
        }

    }*/

   /* public void getEligibilityStatus(String menuItem) {
        if (menuItem.equals("Eligibility")) {
            String getnEligibilityXpath = properties.getProperty("menuEligibilityXpath");
            boolean currentEligibilityStatus = getElementbyXpath(getnEligibilityXpath).isSelected();
            if (currentEligibilityStatus) {
                System.out.println(menuItem + " is selected");
            } else {
                System.out.println(menuItem + " is not selected");
            }
        } else {
            String getContactDetail = properties.getProperty("menuContactDetailXpath");
            boolean currentContactDetailStatus = getElementbyXpath(getContactDetail).isSelected();

            String getUiXpath = properties.getProperty("uiXpathforMenu");
            List<WebElement> menuItemList = getElementbyXpath(getUiXpath).findElements(By.tagName("li"));
            for (int i = 0; i < menuItemList.size(); i++) {

                String menuItemText = menuItemList.get(i).getText();


                if (menuItemList.get(i).isEnabled()) {
                    System.out.println(menuItemText + " is not allowed to click");
                } else
                    System.out.println(menuItemText + " is allowed to click");
            }
        }
    }
*/
   /* public String getRadioStatus(int verifiedRadio) {
        //0, No radio
        //1, Yes radio
        String currentRadioStatus;
        if (0 == verifiedRadio) {

            String getNoRadioXpath = properties.getProperty("answerNoXpath");
            currentRadioStatus = String.valueOf(checkRadioStatus(getNoRadioXpath));

        } else {
            String getYesRadioXpath = properties.getProperty("answerYesXpath");
            currentRadioStatus = String.valueOf(checkRadioStatus(getYesRadioXpath));

        }
        return currentRadioStatus;
    }*/

 /*   private boolean checkRadioStatus(String getRadioXpath) {
        boolean radioStatus;
        radioStatus = getElementbyXpath(getRadioXpath).isSelected();
        if (getElementbyXpath(getRadioXpath).isSelected()) {
            System.out.println(getRadioXpath + "is selected");
        } else {
            System.out.println(getRadioXpath + "is not selected");
        }
        return radioStatus;
    }*/

  /*  public void verifyWarning(String waringText) {
        //Actions pressDown = new Actions(driver);
        //pressDown.sendKeys(Keys.PAGE_DOWN).perform();

        String getSmartLinkXpath = properties.getProperty("WarningXpath");
        if (getElementbyXpath(getSmartLinkXpath).getText().equals(waringText)) {
            System.out.println("Expected text is showing:" + waringText);
        } else {
            System.out.println("Shown text is showing:" + getElementbyXpath(getSmartLinkXpath).getText());
            System.out.println("Expected text is showing:" + waringText);
        }
    }
*/
   /* public void clickWarningLink(String smartAdvisor) {

        String getSmartAdvisorLink = properties.getProperty("smartAdvisorXpath");
        System.out.println("clickWarningLink text is showing:sdfasdfdsaf  " + smartAdvisor);
        WebElement getElemLink1 = driver.findElement(By.xpath(getSmartAdvisorLink));
        getElemLink1.click();
    }
*/
   /* public void verifyOpenedHyperLink(String smartAdvisorUrl) throws InterruptedException {

        String currentWindow = driver.getWindowHandle();
        System.out.println("this is original window:" + driver.getCurrentUrl());
        Set<String> allWindowCount = driver.getWindowHandles();
        System.out.println("here are listed all window & tabs: " + allWindowCount);
        System.out.println(allWindowCount.size());

        for (String child : allWindowCount)
            if (!currentWindow.equalsIgnoreCase(child)) {
                driver.switchTo().window(child);
                Thread.sleep(2000);
                String getCurrentCildUrl = driver.getCurrentUrl();

                if (getCurrentCildUrl.equals(smartAdvisorUrl)) {
                    System.out.println("This is expected Url: " + driver.getCurrentUrl());
                } else {
                    System.out.println("This is not expected Url: " + driver.getCurrentUrl());
                }

            }
    }*/
}
