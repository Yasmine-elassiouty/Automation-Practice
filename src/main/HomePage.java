import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void openAccount() {
        WebElement myAccountButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a\n"));
        myAccountButton.click();
    }
    public void clickLogin() {
        WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        loginButton.click();
    }
    public void hoverToWomen() {
        WebElement hover1 = driver.findElement(By.xpath("//*  [@id='block_top_menu']/ul/li[1]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hover1).perform();
    }
    public void click_women_Tshirt() {
        WebElement tshirts = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a"));
        tshirts.click();
    }

    public void click_women(){
        WebElement women = driver.findElement(By.xpath("//*  [@id='block_top_menu']/ul/li[1]/a"));
        women.click();
    }










}
