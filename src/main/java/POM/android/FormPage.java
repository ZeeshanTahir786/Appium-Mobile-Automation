package POM.android;

import POM.android.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends AndroidActions {
    //  Page Object Factory
    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), driver);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleOption;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleOption;

    //            driver.findElement(By.id("android:id/text1")).click();
//        driver.findElement(AppiumBy.androidUIAutomator(("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))")));
//        driver.findElement(By.xpath("//android.widget.TextView[@text='Australia']")).click();
    @AndroidFindBy(id = "android:id/text1")
    private WebElement countrylist;

    public void setNameField(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void setGender(String gender) {
        if (gender.contains("female"))
            femaleOption.click();
        else
            maleOption.click();
    }

    public void setCountrySelection() {

    }
}
