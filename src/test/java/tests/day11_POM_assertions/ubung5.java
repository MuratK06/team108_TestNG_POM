package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Amazon14promax;
import utilities.ConfigReader;
import utilities.Driver;

public class ubung5 {

    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        String expectedicerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert=new SoftAssert();
        Assert.assertTrue(actualUrl.contains(expectedicerik));

        Amazon14promax amazon14promax=new Amazon14promax();
        amazon14promax.aramaKutusu.sendKeys("iphone 14 pro max"+ Keys.ENTER);

        expectedicerik="iphone 14 pro max";
        String actualicerik=amazon14promax.ilkUrunIsimElementi.getText();

        softAssert.assertTrue(actualicerik.contains(expectedicerik));

        amazon14promax.ilkurun.click();

    }
}
