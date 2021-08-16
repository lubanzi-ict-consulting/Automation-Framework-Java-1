package verification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import register.ElemtLocation;

import java.util.List;
import java.util.Properties;

public class ItemSelect extends ElemtLocation {
    public ItemSelect(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public void itemSelected(String currentSelectItem) {
        String getItemClassName = properties.getProperty("itemClassName");
        List<WebElement> classNameList = getElementsClassname(getItemClassName);
        //.getAttribute("class");
        for (WebElement item : classNameList) {
           //System.out.println(item);
            try {
                if (item.getText().contains(currentSelectItem)) {
                    item.click();
                    break;
                }
            } catch (Exception e) {
                System.out.println("Failed: No such item on the page");
            }
        }
    }
}
