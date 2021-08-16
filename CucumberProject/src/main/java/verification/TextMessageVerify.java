package verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import register.ElemtLocation;

import java.util.Properties;

public class TextMessageVerify  extends ElemtLocation {

    public TextMessageVerify(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public void verifyQuestion(String askedQuestion) {
        // System.out.println(driver.getPageSource());
        if ((driver.getPageSource().contains(askedQuestion))) {
            System.out.println("Pass: you are on question page");
        }
        else {
            System.out.println("Failed: Question is not showing on the page");
        }
    }

    public void verifyWarning(String waringText) {
        String getSmartLinkXpath = properties.getProperty("WarningXpath");
        if (getElementbyXpath(getSmartLinkXpath).getText().equals(waringText)) {
            System.out.println("Pass: " + waringText);
        } else {
            System.out.println("Failed: " + getElementbyXpath(getSmartLinkXpath).getText());
            System.out.println("Expected: " + waringText);
        }
    }

    public void clickWarningLink(String smartAdvisor) {
        String getSmartAdvisorLink = properties.getProperty("smartAdvisorXpath");
        //System.out.println("clickWarningLink text is showing:sdfasdfdsaf  " + smartAdvisor);
        WebElement getElemLink = driver.findElement(By.xpath(getSmartAdvisorLink));
        getElemLink.click();
    }
}
