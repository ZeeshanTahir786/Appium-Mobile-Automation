package appium.POM.andriod;

import POM.android.CartPage;
import POM.android.FormPage;
import POM.android.ProductCatalog;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEnd extends BaseTestEcom {

    @Test
    public void endToEnd() {
        FormPage formPage = new FormPage(driver);
        formPage.setNameField("Hafiz Zeeshan");
        formPage.setGender("female");
        formPage.setCountrySelection("Argentina");
        ProductCatalog catalog = formPage.clickLetsShopBtn();
        catalog.addProdToCartByIndex(0);
        catalog.addProdToCartByIndex(0);
        CartPage cartPage = catalog.clickAddToCart();
        double totalSum = cartPage.getproductsSum();
        double displayFormattedSum = cartPage.getTotalAmountDisplayed();
        Assert.assertEquals(totalSum, displayFormattedSum);
        cartPage.acceptTermsConsitions();
        cartPage.submitOrder();
    }
}
