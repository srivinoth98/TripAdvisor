package tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import testbase.DriverSetUp;

public class HomeTest extends DriverSetUp {
    public HomePage homePage;

    HomeTest() {
        super();
    }

    @BeforeMethod
    public void webLogin() {
        initialization();
        homePage = new HomePage();

    }

    @Test(priority = 1)
    public void verifyDropDown() {
        SoftAssert softAssert = new SoftAssert();
        homePage.dropDownMore(prop.getProperty("value"));
        softAssert.assertEquals("", "", "more btn is clicked");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifySelectRadioBtn() {
        SoftAssert softAssert = new SoftAssert();
        homePage.dropDownMore(prop.getProperty("value"));
        homePage.clickRating();
        softAssert.assertEquals("", "", "more btn is clicked");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifySelectCheckBox() {
        SoftAssert softAssert = new SoftAssert();
        homePage.dropDownMore(prop.getProperty("value"));
        homePage.checkBoxClick();
        softAssert.assertEquals("", "", "more btn is clicked");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void getWindowContactUs() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        homePage.handleWindow();
        homePage.contactUsClick();
        softAssert.assertEquals("", "", "more btn is clicked");
        softAssert.assertAll();
        Thread.sleep(3000);
    }

    @AfterMethod()
    public void closeBrowser() {
        driver.quit();
    }
}
