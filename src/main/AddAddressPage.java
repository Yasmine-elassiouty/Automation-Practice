import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddAddressPage {
    WebDriver driver;

    public AddAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addressBox1 (String address){
        driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys(address);
    }

    public void addCity (String city){
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(city);
    }

    public void addState(String state){
        WebElement stateDropDown = driver.findElement(By.xpath("//*[@id=\"id_state\"]"));
        Select dropDown = new Select(stateDropDown);
        dropDown.selectByVisibleText(state);
    }

    public void addMobileNumber1(String mobNum){
        driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys(mobNum);
    }

    public void addAddressTitle (String title){
        WebElement titleBox = driver.findElement(By.xpath("//*[@id=\"alias\"]"));
        titleBox.clear();
        titleBox.sendKeys(title);
    }

    public void clickSave(){
        driver.findElement(By.xpath("//*[@id=\"submitAddress\"] ")).click();
    }

    public void addPostalCode (String code){
        driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys(code);
    }



}
