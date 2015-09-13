package framework;

import org.junit.Test;
import org.openqa.selenium.By;

public class test extends Base{
  
  @Test
  public void testOne() throws InterruptedException{
    driver.get("http://localhost:1234/");
    action.click(By.partialLinkText("Ex"));
    action.click(By.linkText("TextBox"));
    Thread.sleep(5000);
    action.setValue(utils.getLocator("first"),"Devi");
    System.out.println(action.getValue(By.id("firstname")));
    try {
      utils.getLocators();
    } catch (Exception e) {
      // TODO Auto-generated catch block
    }
  }
  

}
