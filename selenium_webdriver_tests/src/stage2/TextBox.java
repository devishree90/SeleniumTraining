package stage2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBox {

  public static void main(String args[]) throws InterruptedException{
    String FIRST_NAME="Devi";
    String LAST_NAME="Sridharan";
    WebDriver driver=new FirefoxDriver();
    driver.get("http://localhost:1234/2014/09/06/TextBox.html");
    WebElement firstName=driver.findElement(By.id("firstname"));
    WebElement lastName=driver.findElement(By.id("lastname"));
    firstName.sendKeys(FIRST_NAME);
    lastName.sendKeys(LAST_NAME);
    driver.findElement(By.className("button")).click();
    Boolean myDynamicElement = (new WebDriverWait(driver, 10))
        .until(ExpectedConditions.textToBePresentInElementLocated(By.id("fullName"),FIRST_NAME+" "+LAST_NAME));
    System.out.println(driver.findElement(By.id("fullName")).getText());
    driver.close();
  }
}
