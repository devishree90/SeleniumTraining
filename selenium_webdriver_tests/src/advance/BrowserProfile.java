package advance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserProfile {
  public WebDriver driver;

  @Before
  public void setUp(){
    driver=new FirefoxDriver();
  }

  @After
  public void teardown(){
    driver.close();
  }

  @Test
  public void testBrowserProfile(String args[]){
    FirefoxProfile profile = new FirefoxProfile();
    profile.setPreference("browser.startup.homepage","http://localhost:1234");
    driver = new FirefoxDriver(profile);

    WebElement element = driver.findElement(By.linkText("Exercises"));
    element.click();
  }
}
