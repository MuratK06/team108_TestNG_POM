package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Amazon14promax {

    public Amazon14promax(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath = "(//img[@class='s-image'])[3]")
    public WebElement ilkurun;



    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement ilkUrunIsimElementi;
}
