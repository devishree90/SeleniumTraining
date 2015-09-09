package advance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class Hover {
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
  public void testHover() throws InterruptedException{
    driver.get("http://localhost:1234");
    Actions builder=new Actions(driver);
    Action action= builder.moveToElement(driver.findElement(By.cssSelector("#nav .opener a")))
        .click()
        .moveToElement(driver.findElement(By.cssSelector("#nav .opener ul li:nth-of-type(3)")))
        .build();

    action.perform();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("#nav .opener ul li a")).click();
//    Actions newbuilder=new Actions(driver);
//    Action newAction=newbuilder.moveToElement(driver.findElement(By.cssSelector("#nav .opener ul li:nth-of-type(3)")))
//            .click()
//            .build();
//    newAction.perform();
//    driver.findElement(By.cssSelector("#nav .opener ul li.opener ul li")).click();
  }
}
