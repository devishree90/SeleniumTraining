package junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Link {
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
  public void testLink(){
    driver.navigate().to("http://localhost:1234");
    driver.findElement(By.linkText("Exercises")).click();
    Assert.assertTrue(driver.getCurrentUrl().contains("/blog"));
    driver.findElement(By.partialLinkText("Ho")).click();
    Assert.assertTrue(driver.getCurrentUrl().contains("/index"));
  }
}
