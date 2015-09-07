import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirstTest {
  public static void main(String args[]) throws InterruptedException{
    WebDriver driver=new FirefoxDriver();
    driver.get("http://www.google.com");
    WebElement textBox=driver.findElement(By.name("q"));
    textBox.sendKeys("cheese!");
    driver.findElement(By.name("btnG")).click();
    Thread.sleep(5000);
    System.out.println(driver.getTitle());
    driver.close();
  }
}
