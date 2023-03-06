package tests.day11_POM_assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utulities.ConfigReader;
import utulities.Driver;

import java.util.List;

public class ubung6 {

    @Test
    public void test01(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));
        // 2. Sign in butonuna basin
        ZeroPage zeroPage=new ZeroPage();
        zeroPage.signInButonu.click();
        // 3. Login kutusuna “username” yazin
        zeroPage.usernameKutusu.sendKeys("username");
        // 4. Password kutusuna “password” yazin
        zeroPage.passwordKutusu.sendKeys("password");
        // 5. Sign in tusuna basin
        zeroPage.signInSubmitButonu.click();
        Driver.getDriver().navigate().back();
        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        zeroPage.onlineBanking.click();
        zeroPage.payBillLinki.click();
        // 7. “Purchase Foreign Currency” tusuna basin
        zeroPage.purchaseFCButonu.click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        Select select=new Select(zeroPage.currencyDropdown);
        utilities.ReusableMethods.bekle(2);
        select.selectByVisibleText("Eurozone (euro)");
        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();

        String expectedSecim="Eurozone (euro)";
        String actualSecim=select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualSecim,expectedSecim,"dropdownda eurozone secili degil");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)",
        // "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
        // (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden
        // (krona)","Singapore (dollar)","Thailand (baht)"

        Driver.closeDriver();
    }
}