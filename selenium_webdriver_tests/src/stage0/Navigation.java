package stage0;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigation {
  public static void main(String args[]){
    WebDriver driver=new FirefoxDriver();
    driver.navigate().to("http://localhost:1234");
    driver.findElement(By.linkText("Exercises")).click();
    if(driver.getCurrentUrl().contains("/blog")){
      System.out.println("Pass:"+driver.getCurrentUrl());
    }else{
      System.out.println("Fail:"+driver.getCurrentUrl());
    }
    driver.navigate().refresh();

    if(driver.getCurrentUrl().contains("/blog")){
      System.out.println("Pass:"+driver.getCurrentUrl());
    }else{
      System.out.println("Fail:"+driver.getCurrentUrl());
    }

    driver.navigate().back();
    if(driver.getCurrentUrl().contains("/blog")){
      System.out.println("Fail:"+driver.getCurrentUrl());
    }else{
      System.out.println("Pass:"+driver.getCurrentUrl());
    }

    driver.navigate().forward();
    if(driver.getCurrentUrl().contains("/blog")){
      System.out.println("Fail:"+driver.getCurrentUrl());
    }else{
      System.out.println("Pass:"+driver.getCurrentUrl());
    }
    driver.quit();
  }
}
