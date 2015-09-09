package stage0;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton {
  public static void main(String args[]){
    WebDriver driver=new FirefoxDriver();
    driver.get("http://localhost:1234/2014/09/06/RadioButton.html");
    System.out.println(driver.findElement(By.id("profile1")).isSelected());
    driver.findElement(By.id("profile1")).click();
  }
}
