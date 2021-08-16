package verification;

import org.openqa.selenium.WebDriver;
import register.ElemtLocation;

import java.util.Properties;
import java.util.Set;

public class OpenedLinkVerify extends ElemtLocation {

    public OpenedLinkVerify(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public void verifyOpenedHyperLink(String smartAdvisorUrl) throws InterruptedException {
        String currentWindow = driver.getWindowHandle();
        //System.out.println("Original window:" +driver.getCurrentUrl());
        Set<String> allWindowCount = driver.getWindowHandles();
        // System.out.println("listed all window & tabs: " + allWindowCount);
        //System.out.println(allWindowCount.size());

        for (String child : allWindowCount) {
            if (!currentWindow.equalsIgnoreCase(child)) {
                driver.switchTo().window(child);
                Thread.sleep(3000);
                String getCurrentChildUrl = driver.getCurrentUrl();

                if (getCurrentChildUrl.equals(smartAdvisorUrl)) {
                    System.out.println("Pass : Expected Url " + driver.getCurrentUrl());
                } else {
                    System.out.println("Failed : Unexpected Url: " + driver.getCurrentUrl());
                }
            }
        }
        driver.switchTo().window(currentWindow);
        //System.out.println("Swithto initial window and Url "+ driver.getCurrentUrl());
       // driver.close();

    }
}
