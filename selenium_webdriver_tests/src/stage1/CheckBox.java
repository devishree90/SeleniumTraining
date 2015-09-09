package stage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * @Aim:Should achieve the fluent control over CheckBox interaction
 *      :All API
 *      :Read selected attribute
 */
public class CheckBox {
  public static void main(String args[]){
    WebDriver driver=new FirefoxDriver();
    driver.get("http://localhost:1234/2014/09/06/RadioButton.html");
    System.out.println(driver.findElement(By.id("exp-1")).isSelected());
    driver.findElement(By.id("exp-2")).click();
    driver.close();
  }
}
