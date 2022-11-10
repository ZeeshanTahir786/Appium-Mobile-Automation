package appium.eCommerceApp;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase2 extends BaseTestEcom {
    @Test
    public void tc02() {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Zeeshan");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator(("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Australia']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        List<WebElement> list = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = list.size();
        Double totalsum = 0.00;
        for (int i = 0; i < count; i++) {
            String price = list.get(i).getText();
//            it will give $160.90
            Double formatedPrice = getFormattedPrice(price);
//            we are making it 160.90 by making substring starting from 1 index.
            totalsum = totalsum + formatedPrice;
        }

        String mobileAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedAmount = getFormattedPrice(mobileAmount);
        Assert.assertEquals(displayFormattedAmount, totalsum);
    }
}
