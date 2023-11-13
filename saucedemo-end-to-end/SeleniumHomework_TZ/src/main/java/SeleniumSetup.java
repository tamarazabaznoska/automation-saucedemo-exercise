import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumSetup {


    private static WebDriver driver;

    private static WebDriverWait wait;


    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver, 60);
    }

    public static String navigateTo(String url) {
        driver.get(url);
        return driver.getCurrentUrl();
    }

    public static void typeIn(String elementXpath, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).sendKeys(text);
    }

    public static void clickOn(String elementXpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).click();
    }

    public static String getText(String elementXpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).getText();
    }


    public static String logMeIn() {
        typeIn ("//*[@id=\"user-name\"]", "standard_user");

        typeIn("//*[@id=\"password\"]", "secret_sauce");

        clickOn("//*[@id=\"login-button\"]");

        return getText("//*[@id=\"header_container\"]/div[2]/span");
    }

    public static String addProductsToCart() {
        clickOn("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");

        clickOn("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");

        clickOn("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");

        clickOn("//*[@id=\"shopping_cart_container\"]/a");

        return getText("//*[@id=\"header_container\"]/div[1]/div[2]/div");
    }

    public static String checkoutInformation() {
        clickOn("//*[@id=\"checkout\"]");

        typeIn ("//*[@id=\"first-name\"]","Tamara");

        typeIn ("//*[@id=\"last-name\"]","Zabaznoska");

        typeIn ("//*[@id=\"postal-code\"]","1000");

        return getText("//*[@id=\"header_container\"]/div[2]/span");
    }

    public static String assertConfirmationMessage() {
        clickOn ("//*[@id=\"continue\"]");

        clickOn ("//*[@id=\"finish\"]");

        return getText("//*[@id=\"checkout_complete_container\"]/h2");
    }

    public static void end() {
        driver.quit();
    }
}




