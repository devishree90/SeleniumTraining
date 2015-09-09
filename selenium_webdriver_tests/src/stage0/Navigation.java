package stage0;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 *  Use Navigate API's
 *  Verify the current location
 */
public class Navigation {
  public static void main(String args[]){
    WebDriver driver=new FirefoxDriver();
    driver.navigate().to("http://localhost:1234");
    driver.navigate().refresh();
    driver.quit();
  }
}
