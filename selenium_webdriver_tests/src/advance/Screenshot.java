package advance;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;

public class Screenshot {
  public static void main(String args[]){
    WebDriver driver=new FirefoxDriver();
    driver.get("http://localhost:1234");
    WebDriver Augmenter=new Augmenter().augment(driver);
    File screenShot=((TakesScreenshot)Augmenter).getScreenshotAs(OutputType.FILE);
    System.out.println(screenShot.getPath());
  }

}
