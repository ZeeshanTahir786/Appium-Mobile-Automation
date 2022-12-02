package appium.POM.andriod;

import POM.android.FormPage;
import org.testng.annotations.Test;

public class EndToEnd extends BaseTestEcom {

    @Test
    public void endToEnd() {
        FormPage formPage = new FormPage(driver);
        formPage.setNameField("Hafiz Zeeshan");
        formPage.setGender("female");
    }
}
