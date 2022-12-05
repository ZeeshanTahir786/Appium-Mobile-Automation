package POM.android;

import POM.android.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductCatalog extends AndroidActions {
    AndroidDriver driver;

    public ProductCatalog(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }
//
//      driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
//      driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
//      driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

    private By product = By.xpath("//android.widget.TextView[@text='ADD TO CART']");
    private By addToCartBtn = By.id("com.androidsample.generalstore:id/appbar_btn_cart");

    public void addProdToCartByIndex(int index) {
        driver.findElements(product).get(index).click();
    }

    public void clickAddToCart() {
        driver.findElement(addToCartBtn).click();
    }

}
