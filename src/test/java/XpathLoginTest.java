import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class XpathLoginTest {
    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\saina\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://practice.expandtesting.com/login");

        WebElement username=driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div/div/div/form/div/div[1]/input"));
        username.sendKeys("practice");
        System.out.println("Username entered");

        WebElement password=driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div/div/div/form/div/div[2]/input"));
        password.sendKeys("SuperSecretPassword!");
        System.out.println("Password entered");

        WebElement login=driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div/div/div/form/button"));
        login.click();

        String expectedUrl="https://practice.expandtesting.com/secure";


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        // Get the current URL after login
        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.equals(expectedUrl)){
            System.out.println("Logged successful!");
        }else{
            System.out.println("Navigation to home page failed!");

        }
    }
}

