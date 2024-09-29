import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class MyAccountPage {
    WebDriver driver;
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public void addFirstAddress_Click() {
        WebElement addFirstAddress = driver.findElement(By.xpath("//span[contains(text(),'Add my first address')]"));
        addFirstAddress.click();

    }



}
