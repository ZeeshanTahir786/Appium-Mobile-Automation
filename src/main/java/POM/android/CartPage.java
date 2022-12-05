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

    //    WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
//    longPressAction(ele);
    private By termsBtn = By.id("com.androidsample.generalstore:id/termsButton");

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

}
