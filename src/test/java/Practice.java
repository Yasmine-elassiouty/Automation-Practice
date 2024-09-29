import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.time.Duration;
import java.util.List;


public class Practice extends TestBase { //


    public void waitForResponseXpath(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void waitForResponseTitle(String title){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(title));
    }

    @BeforeClass
    //Go to Homepage
    public void setUp(){
        driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a")).click();
    }

    @Test()
    public void T2_searchDress(){
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
        searchBar.sendKeys("Dress");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"index\"]/div[2]")));
        List<WebElement> searchResults = driver.findElements(By.xpath("//*[@id=\"index\"]/div[2]/ul"));
        for (WebElement result : searchResults) {
            String resultText = result.getText().toLowerCase();
            Assert.assertTrue(resultText.contains("dress"), "Search result does not contain 'dress': " + resultText);
        }

    }

    @Test()
    public void T3_hoverWomen(){
        WebElement hover1 = driver.findElement(By.xpath("//*  [@id='block_top_menu']/ul/li[1]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hover1).perform();
        WebElement tshirts = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a"));
        tshirts.click();

        String expectedTitle = "T-shirts - My Shop";

        // Wait for the URL to change or for an element on the new page to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Wrong Redirection");
    }



    @Test()
    @Parameters({"mail", "firstName","lastName", "password", "day", "month", "year"})
    public void T4_Register(String mail, String firstName, String lastName, String password, String day, String month, String year){
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);

        WebElement sign_in = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        sign_in.click();

        waitForResponseTitle("Login - My Shop");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        email.sendKeys(mail);
        WebElement create = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]"));
        create.click();

        waitForResponseXpath("//*[@id=\"id_gender2\"]");

        registrationPage.setMrsRadio();
        registrationPage.setFirstNameBox(firstName);
        registrationPage.setLastNameBox(lastName);
        registrationPage.setPasswordBox(password);
        registrationPage.setDayOfBirthDropDown(day);
        registrationPage.setMonthOfBirthDropDown(month);
        registrationPage.setYearOfBirthDropDown(year);
        registrationPage.setSubmitButton();


        WebElement success = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]"));
        waitForResponseXpath("//*[@id=\"center_column\"]/p[1]");
        Assert.assertTrue(success.isDisplayed(), "Registration failed");
    }

    @Test
    @Parameters({"mail","password"})
    public void T5_AddFirstAddress(){
        //make sure the user is logged in first
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        AddAddressPage addAddressPage = PageFactory.initElements(driver, AddAddressPage.class);
        homePage.openAccount();
        waitForResponseTitle("My account - My Shop");
        myAccountPage.addFirstAddress_Click();
        waitForResponseTitle("Address - My Shop");
        addAddressPage.addressBox1("Address");
        addAddressPage.addCity("Gotham City");
        addAddressPage.addState("California");
        addAddressPage.addPostalCode("12345");
        addAddressPage.addMobileNumber1("01234567890");
        String addressTitle = "My First Address";
        addAddressPage.addAddressTitle(addressTitle);
        addAddressPage.clickSave();
        waitForResponseXpath("//p[contains(text(), Your addresses are listed below.)]"); //NOT WORKING

    }
}
