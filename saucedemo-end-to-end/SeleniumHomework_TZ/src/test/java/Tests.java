import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class Tests {

    @BeforeClass
    public void beforeClass() {
        SeleniumSetup.setup();
    }

    @Test (priority = 10)
    public void testForVerifyingUserLandingOnHomePage(){
        SeleniumSetup.navigateTo("https://www.saucedemo.com/");
    }

    @Test (priority = 20)
    public void testForVerifyingUserIsLoggedInSuccessfully() {
        Assert.assertEquals(SeleniumSetup.logMeIn(),"Products");
    }

    @Test (priority = 30)
    public void testForAddingProductToTheCart() {
        Assert.assertEquals(SeleniumSetup.addProductsToCart(),"Swag Labs");
    }

    @Test (priority = 40)
    public void testForVerifyingCheckoutInfoIsSuccessfullyFilled() {
        Assert.assertEquals(SeleniumSetup.checkoutInformation(),"Checkout: Your Information");
    }

    @Test (priority = 50)
    public void testForValidatingConfirmationMessage() {
        Assert.assertEquals(SeleniumSetup.assertConfirmationMessage(), "Thank you for your order!");
    }

    @AfterClass
    public void afterClass() {
        SeleniumSetup.end();
    }
}
