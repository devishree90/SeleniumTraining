package advance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScript {
  public static void main(String args[]){
    WebDriver driver=new FirefoxDriver();
    driver.get("http://localhost:1234/2014/09/06/TextBox.html");
    List<WebElement> labels = driver.findElements(By.tagName("label"));
    List<WebElement> inputs = (List<WebElement>) ((JavascriptExecutor)driver).executeScript(
        "var labels = arguments[0], inputs = []; for (var i=0; i < labels.length; i++){" +
        "inputs.push(document.getElementById(labels[i].getAttribute('for'))); } return inputs;", labels);
    for(WebElement input:inputs){
      System.out.println(input.getAttribute("id"));
    }
    driver.close();
  }
}
