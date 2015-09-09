package stage2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * @Aim:Should be able to work easily with DropDown
 * @Stage2:Select the value with visible text
 *        Select the value with value
 *        Select the value with index
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
    multipleLanguage.deselectByVisibleText(optionToBeSelected);
//    Retrieve selected option
    getSelectedOptions(multipleLanguage);
    multipleLanguage.deselectAll();
    getSelectedOptions(multipleLanguage);
    driver.close();
  }

  private static void getSelectedOptions(Select multipleLanguage) {
    List<WebElement> selectedOptions=multipleLanguage.getAllSelectedOptions();
    for(WebElement element:selectedOptions){
      System.out.println(element.getText());
    }
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
