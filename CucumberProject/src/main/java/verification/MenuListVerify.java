package verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import register.ElemtLocation;

import java.util.List;
import java.util.Properties;


public class MenuListVerify extends ElemtLocation {

    public MenuListVerify(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public void getVisableItemStatus(String menuItem) {
        if (menuItem.equals("Eligibility")) {
            String getnEligibilityXpath = properties.getProperty("menuEligibilityXpath");
            //boolean currentEligibilityStatus = getElementbyXpath(getnEligibilityXpath).isSelected();
            //System.out.println("Eligibility= " +  getElementbyXpath(getnEligibilityXpath).isSelected());
            // System.out.println("Eligibility= " +  getElementbyXpath(getnEligibilityXpath).isEnabled());
            // System.out.println("Eligibility= " +  getElementbyXpath(getnEligibilityXpath).isDisplayed());
            try {
                getElementbyXpath(getnEligibilityXpath).click();
                System.out.println("Pass: " + menuItem + " has been selected");
            } catch (Exception e) {
                System.out.println("Failed: " + menuItem + " not able to selected");
            }
        }
    }

    public void OthersMenuList(String enabled) {

        String getUiXpath = properties.getProperty("uiXpathforMenu");
        List<WebElement> menuItemList = getElementbyXpath(getUiXpath).findElements(By.tagName("li"));

        if (enabled.equals("enabled")) {
            System.out.println("Here are all items enabled");
            for (int i = 1; i < menuItemList.size(); i++)
                try {
                    Thread.sleep(3000);
                    menuItemList.get(i).click();
                    System.out.println("Pass: " + menuItemList.get(i).getText() + "is clicked");
                } catch (Exception e) {
                    System.out.println("Failed:" + menuItemList.get(i).getText() + "is not abled clicked");
                }
        } else {
            System.out.println("Here are all items disabled");
            for (int i = 1; i < menuItemList.size(); i++)
                if (enabled.equals("disabled")) {
                    try {
                        Thread.sleep(3000);
                        menuItemList.get(i).click();
                        System.out.println("Failed:" + menuItemList.get(i).getText() + "is clicked");
                    } catch (Exception e) {
                        System.out.println("Pass:" + menuItemList.get(i).getText() + "is not able clicked");
                    }

                }
        }
    }

}
