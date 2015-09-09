package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alert {
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
  public void testAlert(){
    driver.get("http://localhost:1234/2014/09/06/Alert.html");
    driver.findElement(By.className("button")).click();
    driver.switchTo().alert().accept();
    driver.findElement(By.className("button")).click();
    System.out.println(driver.switchTo().alert().getText());
    driver.switchTo().alert().dismiss();
  }
}
