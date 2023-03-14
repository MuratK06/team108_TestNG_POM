package tests.day12_xmlFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBaseRapor;

public class ubung extends TestBaseRapor {
    @Test
    public void amazonTesti(){
        extentTest=extentReports.createTest("Pozitif login testi","gecerli test");
        Driver.getDriver().get("https://www.amazon.com");

        String expectedIcerik="amazon";
        String actualurl=Driver.getDriver().getCurrentUrl();
        extentTest.info("login butonuna basildu");

        Assert.assertTrue(actualurl.contains(expectedIcerik));
        extentTest.pass("basarili sekilde giris yapildigi test edildi");
    }

}
