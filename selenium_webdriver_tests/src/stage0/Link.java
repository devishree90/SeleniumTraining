package stage0;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Link {
  public static void main(String args[]){
    WebDriver driver=new FirefoxDriver();
    driver.navigate().to("http://localhost:1234");
    driver.findElement(By.linkText("Exercises")).click();
    if(driver.getCurrentUrl().contains("/blog")){
      System.out.println("Pass");
    }else{
      System.out.println("Fail");
    }
    driver.findElement(By.partialLinkText("Ho")).click();
    if(driver.getCurrentUrl().contains("/index")){
      System.out.println("Pass");
    }else{
      System.out.println("Fail");
    }
    driver.quit();
  }

}
