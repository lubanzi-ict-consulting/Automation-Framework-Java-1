package register;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElemPosition {

    public WebDriver driver;

    public ElemPosition(WebDriver driver) {
       this.driver = driver;

    }

    public WebElement getElembyXpath(String searchedElementXpath) {
        WebElement getElemPath = driver.findElement(By.xpath(searchedElementXpath));
        if (getElemPath != null) {
            return getElemPath;
        } else {
            return null;
        }
    }

    public WebElement getElemById(String searchElemAccId) {
        WebElement getElemAccId = driver.findElement(By.id(searchElemAccId));
        if (getElemAccId != null) {
            return getElemAccId;

        } else {
            return null;
        }
    }

    public List<WebElement> getElementsClassname(String searchedElementitem) {
        List<WebElement> getElems = driver.findElements(By.className(searchedElementitem));
        if (getElems != null) {
            return getElems;
        } else {
            return null;
        }
    }

    public WebElement getElembyName(String searchedElementName) {
        WebElement getElemName = driver.findElement(By.name(searchedElementName));
        if (getElemName != null) {
            return getElemName;
        } else {
            return null;
        }
    }
}
