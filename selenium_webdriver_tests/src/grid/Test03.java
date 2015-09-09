package grid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test03 extends Base{

    @Test
    public void testLink()throws Exception{
        getDriver().get("http://www.google.com");
        WebElement textBox = getDriver().findElement(By.name("q"));
        textBox.sendKeys("Test 3:Just a test!");
        Thread.sleep(2000);
    }
}
