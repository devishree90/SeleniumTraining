package advance;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
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
  public void testWait() throws InterruptedException{
//    Implicit Wait
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    PageLoad timings
    driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
//    Script TimeOut
    driver.manage().timeouts().setScriptTimeout(100,TimeUnit.SECONDS);

    driver.get("http://localhost:1234");
    try {
      WebElement myDynamicElement = driver.findElement(By.id("link"));
    } catch (Exception e) {
      System.out.println("Waited for 10 seconds");
    }
    driver.findElement(By.linkText("Exercises")).click();
//    ExplicitWait
    (new WebDriverWait(driver, 5)).until(ExpectedConditions.urlContains("/blog"));
    driver.navigate().back();
  }
}
