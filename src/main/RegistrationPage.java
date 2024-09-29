

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {

        this.driver = driver;

    }

    //WebElement MrRadio = driver.findElement(By.xpath("//*[@id=\"id_gender1\"]"));

    // Using FindBy for locating elements
//    @FindBy(how = How.XPATH, using = "//*[@id=\"id_gender1\"]")
//    WebElement MrRadio;

//    @FindBy(how = How.XPATH, using = "//*[@id=\"id_gender2\"]")
//    WebElement MrsRadio;

//    @FindBy(how = How.XPATH, using = "//*[@id=\"customer_firstname\"]")
//    WebElement firstNameBox;

//    @FindBy(how = How.XPATH, using = "//*[@id=\"customer_lastname\"]")
//    WebElement lastNameBox;

//    @FindBy(how = How.XPATH, using = "//*[@id=\"passwd\"]")
//    WebElement passwordBox;

//    @FindBy(how = How.XPATH, using = "//*[@id=\"days\"]")
//    WebElement dayOfBirthDropDown;

//    @FindBy(how = How.XPATH, using = "//*[@id=\"months\"]")
//    WebElement monthOfBirthDropDown;

//    @FindBy(how = How.XPATH, using = "//*[@id=\"years\"]")
//    WebElement yearOfBirthDropDown;

//    @FindBy(how = How.XPATH, using = "//*[@id=\"submitAccount\"]")
//    WebElement submitButton;

    public void setDayOfBirthDropDown(String value) {
        WebElement dayOfBirthDropDown = driver.findElement(By.xpath("//*[@id=\"days\"]"));
        Select dropDown = new Select(dayOfBirthDropDown);
        dropDown.selectByValue(value);
    }
    public void setMonthOfBirthDropDown(String value) {
        WebElement monthOfBirthDropDown = driver.findElement(By.xpath("//*[@id=\"months\"]"));
        Select dropDown = new Select(monthOfBirthDropDown);
        dropDown.selectByValue(value);
    }
    public void setYearOfBirthDropDown(String value) {
        WebElement yearOfBirthDropDown = driver.findElement(By.xpath("//*[@id=\"years\"]"));
        Select dropDown = new Select(yearOfBirthDropDown);
        dropDown.selectByValue(value);
    }
    public void setMrRadio() {
        WebElement MrRadio = driver.findElement(By.xpath("//*[@id=\"id_gender1\"]"));
        MrRadio.click();
    }
    public void setMrsRadio() {
        WebElement MrsRadio = driver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
        MrsRadio.click();
    }
    public void setFirstNameBox(String firstName) {
        WebElement firstNameBox = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        firstNameBox.sendKeys(firstName);
    }
    public void setLastNameBox(String lastName) {
        WebElement lastNameBox = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        lastNameBox.sendKeys(lastName);

    }
    public void setPasswordBox(String password) {
        WebElement passwordBox = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        passwordBox.sendKeys(password);
    }
    public void setSubmitButton() {
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]"));
        submitButton.click();
    }


}
