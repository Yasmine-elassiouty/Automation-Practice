import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class Scenario extends TestBase {
    public void waitForResponseXpath(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    public void waitForResponseTitle(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(title));
    }
    @BeforeClass
    public void beforeClass(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickLogin();
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        emailField.sendKeys("yasmine@test.com");
        passwordField.sendKeys("Password123");
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]"));
        signInButton.click();
        //go to homepage
        driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a")).click();

    }

//    @Test(enabled = false)
//    public void addFirstAddress(){
//        AddAddressPage addAddressPage = PageFactory.initElements(driver, AddAddressPage.class);
//        addAddressPage.addressBox1("Address");
//        addAddressPage.addCity("Gotham City");
//        addAddressPage.addState("California");
//        addAddressPage.addMobileNumber1("01234567890");
//        String addressTitle = "My First Address";
//        addAddressPage.addAddressTitle(addressTitle);
//        addAddressPage.clickSave();
//        waitForResponseXpath("//tagname[contains(text(), addressTitle)]"); //change
//    }

    @Test
    public void T01_Get_Women_Products_Page(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.click_women();
        waitForResponseTitle("Women - My Shop");
    }

    @Test
    public void T02_Choose_A_Product(){
        WomenPage womenPage = PageFactory.initElements(driver, WomenPage.class);
        List<WebElement> products = womenPage.getWomenProducts();
        womenPage.chooseFirstInStockProduct(products); //listItem li
        waitForResponseXpath("//h3[contains(text(),'Data sheet')]");
    }

    @Test
    public void T03_Add_Available_Color_To_Cart(){
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        List<WebElement> colors = driver.findElements(By.xpath("//*[@id=\"color_to_pick_list\"]/li"));
        for (WebElement color : colors) {
            color.click();
            waitForResponseXpath("//*[@id=\"availability_statut\"]"); //it is available
            if (productPage.isAvailable()) {
                productPage.addToCart();
                break;
            }
        }
        waitForResponseXpath("//h2[contains(.,'Product successfully added to your shopping cart')]");
    }

    @Test
    public void T04_Checkout(){
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        productPage.proceedToCheckout();
        waitForResponseTitle("Order - My Shop");
    }

    @Test
    public void T05_Checkout_From_ShoppingCart(){
        //Shopping Cart Page
        WebElement checkout = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"));
        checkout.click();
        waitForResponseXpath("//h1[contains(text(),'Addresses')]");
    }

    @Test
    public void T06_Checkout_From_Addresses(){
        //ADDRESSES
        WebElement proceed = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button"));
        proceed.click();
        waitForResponseXpath("//h1[contains(text(), 'Shipping')]");
    }

    @Test
    public void T07_Checkout_From_Shipping(){
        //SHIPPING
        driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
        WebElement ship = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button"));
        ship.click();
        waitForResponseXpath("//h1[contains(text(), 'Please choose your payment method')]");
    }

    @Test
    public void T08_Checkout_From_Payment(){
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")).click();
        waitForResponseXpath("//h1[contains(text(), 'Order summary')]");
    }

    @Test
    public void T09_Checkout_From_Summary(){
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
        waitForResponseTitle("Order confirmation - My Shop");
    }

    @Test
    public void T10_Confirmation(){
        String response = "Your order on My Shop is complete.";
        WebElement p = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]"));
        String actualResponse = p.getText();
        Assert.assertEquals(actualResponse, response);
    }





}
