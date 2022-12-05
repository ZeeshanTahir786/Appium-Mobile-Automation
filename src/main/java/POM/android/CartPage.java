package POM.android;

import POM.android.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends AndroidActions {
    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By productPrice = By.id("com.androidsample.generalstore:id/productPrice");
    private By mobileAmount = By.id("com.androidsample.generalstore:id/totalAmountLbl");

    private By termsBtn = By.id("com.androidsample.generalstore:id/termsButton");
    private By acceptBtn = By.id("android:id/button1");
    private By checkBox = By.xpath("//android.widget.CheckBox");
    private By proceed = By.id("com.androidsample.generalstore:id/btnProceed");


    public Double getproductsSum() {
        List<WebElement> list = driver.findElements(productPrice);
        int count = list.size();
        Double totalsum = 0.00;
        for (int i = 0; i < count; i++) {
            String price = list.get(i).getText();
//            it will give $160.90
            Double formatedPrice = getFormattedPrice(price);
//            we are making it 160.90 by making substring starting from 1 index.
            totalsum = totalsum + formatedPrice;
        }
        return totalsum;
    }

    public Double getTotalAmountDisplayed() {
        return getFormattedPrice(driver.findElement(mobileAmount).getText());
    }

    public void acceptTermsConsitions() {
        longPressAction(driver.findElement(termsBtn));
        driver.findElement(acceptBtn).click();
    }

    public void submitOrder() {
        driver.findElement(checkBox).click();
        driver.findElement(proceed).click();
    }
}
