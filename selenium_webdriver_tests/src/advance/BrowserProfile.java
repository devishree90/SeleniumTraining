package advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserProfile {
  public static void main(String args[]){
    FirefoxProfile profile = new FirefoxProfile();
    profile.setPreference("browser.startup.homepage","http://localhost:1234");
    WebDriver driver = new FirefoxDriver(profile);

    WebElement element = driver.findElement(By.linkText("Exercises"));
    element.click();
  }
}
