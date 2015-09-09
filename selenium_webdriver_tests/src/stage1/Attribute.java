package stage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * @Aim: Read the attributes of HTML elements
 */
public class Attribute {
    public static void main(String args[]) throws InterruptedException{
      String optionToBeSelected = ".NET";
      WebDriver driver=new FirefoxDriver();
      driver.get("http://localhost:1234/2014/09/06/dropdown.html");
      boolean status=Boolean.parseBoolean(driver.findElement(By.id("MultiSelectLanguage")).getAttribute("disabled"));
      if(status)
        System.out.println("Success:Element is disabled");
      else
        System.out.println("Fail:Element is enabled");
      Select language=new Select(driver.findElement(By.id("Language")));
      language.selectByVisibleText(optionToBeSelected);
      if(driver.findElement(By.id("MultiSelectLanguage")).isEnabled())
        System.out.println("Success:Element is enabled");
      else
        System.out.println("Fail:Element is disabled");
      status=Boolean.parseBoolean(driver.findElement(By.id("Language")).getAttribute("disabled"));
      if(status)
        System.out.println("Success:Language dropdown is disabled");
      else
        System.out.println("Fail:Language dropdown is enabled");

      driver.close();

    }}
