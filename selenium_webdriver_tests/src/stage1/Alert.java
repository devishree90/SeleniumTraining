package stage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alert {
  public static void main(String args[]){
    WebDriver driver=new FirefoxDriver();
    driver.get("http://localhost:1234/2014/09/06/Alert.html");
    driver.findElement(By.className("button")).click();
    driver.switchTo().alert().accept();
  }
}
