package advance;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keyboard {
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
  public void testKeyboard() throws InterruptedException{
    driver.get("http://localhost:1234/2014/09/06/TextBox.html");
    Actions builder=new Actions(driver);
    WebElement html = driver.findElement(By.tagName("html"));
    html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
    html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
    html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
    html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
    Thread.sleep(5000);
  }

}
