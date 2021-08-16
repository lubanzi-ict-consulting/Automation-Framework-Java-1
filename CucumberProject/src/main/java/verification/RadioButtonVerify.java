package verification;

import org.openqa.selenium.WebDriver;
import register.ElemtLocation;

import java.util.Properties;


public class RadioButtonVerify extends ElemtLocation {

    private String getRadioXpath;

    public RadioButtonVerify(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public void toggledRadiobutton(String selectedOption) {

        //System.out.println(selectedOption);
        if (selectedOption.equals("Yes")) {
            getRadioXpath = properties.getProperty("answerYesXpath");

        } else {
            getRadioXpath = properties.getProperty("answerNoXpath");
        }
        try {
            Thread.sleep(8000);
            //System.out.println(getElementbyXpath(getRadioXpath));
            getElementbyXpath(getRadioXpath).click();
        } catch (Exception e) {
            System.out.println("Answer is not selected");
        }
    }

    public void getRadioButtonStatus() {
        getRadioXpath = properties.getProperty("answerYesXpath");
        getElementbyXpath(getRadioXpath).isSelected();
        getElementbyXpath(getRadioXpath).isSelected();
    }
}
