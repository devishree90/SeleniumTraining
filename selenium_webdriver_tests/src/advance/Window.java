package advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Window {
  public static void main(String args[]){
    WebDriver driver=new FirefoxDriver();
    driver.navigate().to("http://localhost:1234/2014/09/06/Window.html");
    driver.findElement(By.className("button")).click();
    String currentWindow=driver.getWindowHandle();
    for(String w:driver.getWindowHandles()){
      driver.switchTo().window(w);
    }
    if(driver.getTitle().equals("Google")){
      System.out.println("Success: New title is "+driver.getTitle());
    }
    driver.close();
    driver.switchTo().window(currentWindow);
    if(driver.getTitle().equals("Hands-on Website")){
      System.out.println("Success: switched to window with title"+driver.getTitle());
    }
    driver.close();
  }
}
