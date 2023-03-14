package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class ubung2 {

    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QdPage qdPage=new QdPage();
        Driver.driver.navigate().refresh();
        qdPage.ilkLoginLinki.click();
        Driver.driver.navigate().refresh();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());
    }
}
