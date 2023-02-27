package techproed.tests.homework;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class US100402_Negative_Login {
    //Name:
    //US100402_Negative_Login
    //Description:
    //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapılamamalı
    //Acceptance Criteria:
    //Kullanici dogru email ve yanlis sifre girildiginde, hata mesajini alınmalı
    //Hata Mesaji:
    //Bad credentials
    //Test Data:
    //Customer email: jack@gmail.com
    //Customer password: fakepass
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    @Test
    public void blueRentalNegativeLogin() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage=new BlueRentalHomePage();
        blueRentalLoginPage=new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("admin_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("fake_pass"));
        blueRentalLoginPage.loginButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(blueRentalLoginPage.error_message_1.getText(),"Bad credentials");
        Driver.closeDriver();
    }
}
