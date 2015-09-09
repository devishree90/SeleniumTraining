package stage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * @Aim:Should be able to work easily with DropDown
 * @Stage1:Select the value with visible text
 *        Select the multiple options with visible text
 *        deselect a value
 *
 *        refresh,back
 *
 */
public class DropDown {
  public static void main(String args[]) throws InterruptedException{
    String optionToBeSelected = ".NET";
    String multiSelect = ".NET,CPP,C";
    WebDriver driver=new FirefoxDriver();
    driver.get("http://localhost:1234/2014/09/06/dropdown.html");
    selectLanguage(optionToBeSelected, driver);
    selectMultipleLanguages(multiSelect, driver);
//    Deselect the selected option
    Select multipleLanguage=new Select(driver.findElement(By.id("MultiSelectLanguage")));
    multipleLanguage.deselectByValue(optionToBeSelected);
    Thread.sleep(2000);
    multipleLanguage.deselectAll();
    driver.close();
  }

  private static void selectLanguage(String optionToBeSelected, WebDriver driver) throws InterruptedException {
    Select language=new Select(driver.findElement(By.id("Language")));
    language.selectByVisibleText(optionToBeSelected);
    Thread.sleep(5000);
    String result=driver.findElement(By.id("selectedLanguage")).getText();
    if(result.equals(optionToBeSelected)){
      System.out.println("SUCCESS:"+result+" matches "+optionToBeSelected);
    }else{
      System.out.println("FAILURE:"+result+" DOESN'T match "+optionToBeSelected);
    }
  }

  private static void selectMultipleLanguages(String optionToBeSelected, WebDriver driver) throws InterruptedException {
    Select language=new Select(driver.findElement(By.id("MultiSelectLanguage")));
    String[] options=optionToBeSelected.split(",");
    for(String option:options){
      language.selectByVisibleText(option);
    }
    driver.findElement(By.className("button")).click();
    Thread.sleep(5000);
    String result=driver.findElement(By.id("selectedLanguage")).getText();
    if(result.contains(optionToBeSelected)){
      System.out.println("SUCCESS:"+result+" matches "+optionToBeSelected);
    }else{
      System.out.println("FAILURE:"+result+" DOESN'T match "+optionToBeSelected);
    }
  }

}
