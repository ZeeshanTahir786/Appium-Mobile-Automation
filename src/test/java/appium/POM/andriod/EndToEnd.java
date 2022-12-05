package appium.POM.andriod;

import POM.android.FormPage;
import POM.android.ProductCatalog;
import org.testng.annotations.Test;

public class EndToEnd extends BaseTestEcom {

    @Test
    public void endToEnd() {
        FormPage formPage = new FormPage(driver);
        formPage.setNameField("Hafiz Zeeshan");
        formPage.setGender("female");
        formPage.setCountrySelection("Argentina");
        formPage.clickLetsShopBtn();

        ProductCatalog catalog = new ProductCatalog(driver);
        catalog.addProdToCartByIndex(0);
        catalog.addProdToCartByIndex(0);
        catalog.clickAddToCart();
    }
}
