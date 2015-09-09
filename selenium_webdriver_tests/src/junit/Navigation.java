package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Navigation {
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
  public void testNavigation(){
    driver.navigate().to("http://localhost:1234");
    driver.findElement(By.linkText("Exercises")).click();
    Assert.assertTrue(driver.getCurrentUrl().contains("/blog"));
    driver.navigate().refresh();
    Assert.assertTrue(driver.getCurrentUrl().contains("/blog"));
    driver.navigate().back();
    Assert.assertFalse(driver.getCurrentUrl().contains("/blog"));
    driver.navigate().forward();
    Assert.assertTrue(driver.getCurrentUrl().contains("/blog"));
  }
}
