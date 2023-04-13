package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.DriverSetUp;
import utils.GenericUtils;

import java.util.List;

public class HomePage extends DriverSetUp {
    @FindBy(xpath = "//span[text()='More']")
    WebElement clickMore;

    @FindBy(xpath = "(//input[@id='Traveller Rating_5']//following::label)[1]")
    WebElement ratingRadioBtn;

    @FindBy(xpath = "//a[@id='menu-item-0']//following::div/span")
    List<WebElement> dropdownElements;

    @FindBy(xpath = "(//input[@id='Alliance_1']//following::label)[1]")
    WebElement checkBoxBtn;

    @FindBy(xpath = "//span[contains(text(),'Contact us')]")
    WebElement contactUsBtn;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void dropDownMore(String value) {
        clickMore.click();
        GenericUtils.iterateElement(dropdownElements, value);
    }

    public void clickRating() {
        ratingRadioBtn.click();
    }

    public void checkBoxClick() {
        GenericUtils.waitUntilElementToBeClick(checkBoxBtn);
    }

    public void handleWindow() {
        GenericUtils.getWindowHandle();
    }

    public void contactUsClick() {
        GenericUtils.scrollDownByPixel();
        GenericUtils.waitUntilElementToBeClick(contactUsBtn);
    }
}















