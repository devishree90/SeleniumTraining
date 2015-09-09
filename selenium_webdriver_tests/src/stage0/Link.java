package stage0;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * @author dsridharan
 * @Aim Should be able to do basic interaction
 *      Stage 1 - Verify the currentUrl location
 *
 */
public class Link {
  public static void main(String args[]){
    WebDriver driver=new FirefoxDriver();
    driver.navigate().to("http://localhost:1234");
    driver.findElement(By.linkText("Exercises")).click();
    driver.findElement(By.partialLinkText("Ho")).click();
    driver.quit();
  }

}
