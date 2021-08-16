package dataProvider;

import org.openqa.selenium.remote.DesiredCapabilities;

public class utlit {

    public static final String filePath = "D:\\Assignment\\CucumberProject\\src\\test\\resources\\testDataResources\\"; // File Path
    public static final String fileName = "dataLogin.xlsx"; // File name
    public static final String Datatab = "LoginData"; // Name of data table
    public static final String shopBackfilePath = "D:\\CucumberProject\\src\\test\\resources\\testDataResources\\"; // File Path
    public static final String shopBackfileName = "shopBackVerified.xlsx"; // File name
    public static final String shopBackDatatab = "userProfile"; // Name of data table

    public static void SetUp() {
        // File appDir = new File(System.getProperty("/Users/nishant/Development/AppiumDemo/app");
        //  File app = new File(appDir, "TestApp.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "OPPO R11s");
        capabilities.setCapability("appPackage", "com.shopback.app");
        capabilities.setCapability("appActivity", "com.shopback.app.ui.main.MainActivity");
    }


//    public static void setUP(){
//            driver = new FirefoxDriver();
//            driver.manage().window().maximize();
//            Configfilereader = new ConfigFileReader();
//            driver.get(Configfilereader.getDemoUrl());
//            PageObjectManager pageObjectManager = new PageObjectManager(driver);
//    }

//    public void screenshot(String path_screenshot) throws IOException{
//        File srcFile=driver.getScreenshotAs(OutputType.FILE);
//        String filename=UUID.randomUUID().toString();
//        File targetFile=new File(path_screenshot + filename +".jpg");
//        FileUtils.copyFile(srcFile,targetFile);
//    }


}
