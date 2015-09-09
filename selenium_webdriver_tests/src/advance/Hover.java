package advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class Hover {
  public static void main(String args[]) throws InterruptedException{
    WebDriver driver=new FirefoxDriver();
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
    driver.close();
  }
}
