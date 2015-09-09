package advance;

import java.util.List;

import org.apache.http.util.Asserts;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
 * findElements
 */
public class AjaxTextbox {
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
  public void testAjaxBox(){
    driver=new FirefoxDriver();
    driver.get("http://localhost:1234/2014/09/06/Ajax.html");
    WebElement element=driver.findElement(By.id("TextBox1"));
    element.sendKeys("a");
    WebElement name=(new WebDriverWait(driver, 10))
        .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-autocomplete .ui-menu-item a")));
    List<WebElement> names=driver.findElements(By.cssSelector(".ui-autocomplete .ui-menu-item"));
    for(WebElement elem:names){
      System.out.println(elem.findElement(By.tagName("a")).getText());
    }
    name.click();
    Assert.assertNotEquals("", "Name is empty", "Ashish");
  }
}
