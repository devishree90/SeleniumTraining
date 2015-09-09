package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/*
 * @Aim: Read the attributes of HTML elements
 */
public class Attribute {
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
  public  void testAttribute(){
    String optionToBeSelected = ".NET";
    driver.get("http://localhost:1234/2014/09/06/dropdown.html");
    boolean status=Boolean.parseBoolean(driver.findElement(By.id("MultiSelectLanguage")).getAttribute("disabled"));
    Assert.assertTrue(status,"Fail:Element is enabled");
    Select language=new Select(driver.findElement(By.id("Language")));
    language.selectByVisibleText(optionToBeSelected);
    Assert.assertTrue(driver.findElement(By.id("MultiSelectLanguage")).isEnabled(),"Fail:Element is disabled");
    Assert.assertTrue(Boolean.parseBoolean(driver.findElement(By.id("Language")).getAttribute("disabled")),"Fail:Language dropdown is enabled");
  }
}
