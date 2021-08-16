package verification;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import register.ElemPosition;

import java.util.List;

public class leftItemVerify extends ElemPosition {

    private ConfigFileReader Configfilereader;

    public leftItemVerify(WebDriver driver) {
        super(driver);
    }

    public void getleftItems() throws InterruptedException {
        Configfilereader = new ConfigFileReader();


        String getUiXpath = Configfilereader.getProperty("uiListXpath");

        System.out.println("left side UI " + getUiXpath);
        List<WebElement> menuItemList = getElembyXpath(getUiXpath).findElements(By.tagName("li"));
        for (int i = 0; i < menuItemList.size(); i++) {
            Thread.sleep(3000);
            menuItemList.get(i).click();
            System.out.println("Pass: " + menuItemList.get(i).getText() + "is clicked");
        }
    }
}
