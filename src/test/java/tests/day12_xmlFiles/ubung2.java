package tests.day12_xmlFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.TestBaseRapor.extentReports;

public class ubung2 extends TestBaseRapor {

    @Test
    public void wiseTesti() throws InterruptedException {
        extentTest=extentReports.createTest("Pozitif login testi","gecerli test");
        // wisequarter ana sayfaya gidip, wisequarter'a gittigimizi test edelim
        Driver.getDriver().get("https://www.wisequarter.com");
        Thread.sleep(2000);
        Driver.getDriver().navigate().refresh();

        // url wisequarter iceriyor mu test edelim
        String expectedIcerik = "wisequarter";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();
        extentTest.pass("basarili sekilde giris yapildigi test edildi");

    }


}
