package tests.day12_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class ubung3 extends TestBaseRapor {

    @Test
    public void test01(){

        extentTest=extentReports.createTest("Pozitif login testi","gecerli test");
        // amazon anasayfaya gidip, dogru sayfaya gittigimizi DOGRULAYIN (verify)

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        String expectedicerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert=new SoftAssert();
        Assert.assertTrue(actualUrl.contains(expectedicerik));

        // Nutella icin arama yapip, sonuclarin Nutella icerdigini dogrulayin

        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        expectedicerik="Nutella";
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();
        softAssert.assertTrue(actualSonucYazisi.contains(expectedicerik));

        // ilk urune tiklayip, urun isminde Nutella gectigini dogrulayin

        amazonPage.ilkUrun.click();

        expectedicerik="Nutella";
        String actualilkurun=amazonPage.ilkUrunIsimElementi.getText();
        softAssert.assertTrue(actualilkurun.contains(expectedicerik));
        Driver.closeDriver();
        extentTest.pass("basarili sekilde giris yapildigi test edildi Murat");


    }
}
