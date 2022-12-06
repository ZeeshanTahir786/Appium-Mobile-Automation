package appium.POM.ios;

import POM.ios.AlertViews;
import POM.ios.HomePage;
import org.testng.annotations.Test;

public class IOSTest extends IOSBaseTest {
    @Test
    public void test() {
        HomePage homePage = new HomePage(driver);
        AlertViews alertViews = homePage.selectAlertViews();
        alertViews.enterName("Hafiz Zeeshan");
        alertViews.clickOk();
    }
}
