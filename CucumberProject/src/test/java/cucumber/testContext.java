package cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testContext {

    private final WebDriver driver;

    public testContext(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
}
