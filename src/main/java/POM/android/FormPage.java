package POM.android;

import POM.android.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class FormPage extends AndroidActions {
    //  Page Object Factory
    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private By nameField = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    private By femaleOption = AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
    private By maleOption = AppiumBy.id("com.androidsample.generalstore:id/radioMale");
    private By countrylist = AppiumBy.id("android:id/text1");
    private By letsShopBtn = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");
//    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
//    public WebElement nameField;
//    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
//    public WebElement femaleOption;
//    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
//    public WebElement maleOption;
//
//    @AndroidFindBy(id = "android:id/text1")
//    public WebElement countrylist;
//
//    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
//    public WebElement letsShopBtn;


    public void setNameField(String names) {
        driver.findElement(nameField).sendKeys(names);
        driver.hideKeyboard();
    }

    public void setGender(String gender) {
        if (gender.contains("female"))
            driver.findElement(femaleOption).click();
        else
            driver.findElement(maleOption).click();
    }

    public void setCountrySelection(String countryname) {

        driver.findElement(countrylist).click();
        scrollToText(countryname);
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + countryname + "']")).click();
    }

    public void clickLetsShopBtn() {
        driver.findElement(letsShopBtn).click();
    }
}
