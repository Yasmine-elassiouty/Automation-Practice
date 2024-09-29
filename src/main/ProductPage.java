import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ProductPage {
    private WebDriver driver;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ChooseColor(int index){
        List<WebElement> colors = driver.findElements(By.xpath("//*[@id=\"color_to_pick_list\"]"));
        colors.get(index).click();
    }
    public boolean isAvailable(){
        WebElement status = driver.findElement(By.xpath("//*[@id=\"availability_statut\"]"));
        WebElement span = status.findElement(By.tagName("span"));
        String spanText = span.getText();
        return !spanText.contains("no longer");
    }

    public void addToCart(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button"));
        button.click();
    }

    public void proceedToCheckout(){
        WebElement button = driver.findElement(By.xpath("//a[@title='Proceed to checkout']\n"));
        button.click();
    }




}
