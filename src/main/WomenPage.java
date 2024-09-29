import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class WomenPage {
    WebDriver driver;
    public WomenPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getWomenProducts() {
        //List of Products
        List <WebElement> ulElement = driver.findElements(By.xpath("//*[@class='product_list grid row']//*[@class='product-container']"));
        return ulElement;
    }

    public void chooseFirstInStockProduct(List<WebElement> products){
        //Loop on the list of products and find the first In Stock product
        for (int i=0 ; i<products.size() ; i++){
            List<WebElement> inStockSpans = (products.get(i)).findElements(By.className("available-dif"));
            if (!inStockSpans.isEmpty()) {
                //Hover to show buttons
                Actions actions = new Actions(driver);
                actions.moveToElement(products.get(i)).perform();
                //Click on More
                WebElement moreButton = driver.findElement(By.xpath("//*[@id='center_column']/ul/li["+(i+1)+"]/div/div[2]/div[2]/a"));
                Actions actions1 = new Actions(driver);
                actions1.moveToElement(moreButton).click().perform();
                break;
            }

        }

    }


}
