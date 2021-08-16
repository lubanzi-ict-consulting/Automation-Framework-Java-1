package verification;

import org.openqa.selenium.WebDriver;
import register.ElemtLocation;

import java.util.Properties;


public class NextButtonVerify extends ElemtLocation {

    public NextButtonVerify(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public void nextButtonStatus() throws InterruptedException {
        Thread.sleep(3000);
        String getnextButtonId = properties.getProperty("nextButtonId");
        getElementbyID(getnextButtonId);
        //System.out.println("Next Button " + getElementbyID(getnextButtonId));
        if (getElementbyID(getnextButtonId) != null) {
           // System.out.println("herer is next button isEnabled = " + getElementbyID(getnextButtonId).isEnabled());
           // System.out.println("herer is next button isDisplayed= " + getElementbyID(getnextButtonId).isDisplayed());
           // System.out.println("herer is next button isSelected = " + getElementbyID(getnextButtonId).isSelected());
            if (getElementbyID(getnextButtonId).isEnabled()) {
                System.out.println("Next Button is allowed to click");
            } else {
                System.out.println("Next Button is not to click");
            }
        } else {
            System.out.println("Next Button is not seen on the page");
        }

    }
}
