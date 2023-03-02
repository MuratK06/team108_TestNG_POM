package tests.day10_TestNGFramework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utulities.Driver;
import utulities.ReusableMethodsE;

public class C04_FacebookLogin {

    @Test
    public void facebookTesti(){
        FacebookPage facebookPage= new FacebookPage();
        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");

        // cookies kabul edin
        facebookPage.cookiesKabulButonu.click();
        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker = new Faker();

        facebookPage.emailKutusu.sendKeys(("abc"+faker.internet().emailAddress()));
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());
        ReusableMethodsE.bekle(3);
        facebookPage.loginButonu.click();

        //4- Basarili giris yapilamadigini test edin

        Assert.assertTrue(facebookPage.girisYapilamadiYaziElementi.isDisplayed());

        ReusableMethodsE.bekle(3);

        Driver.closeDriver();
    }
}
