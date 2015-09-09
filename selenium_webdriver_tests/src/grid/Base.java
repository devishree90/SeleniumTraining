package grid;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
  protected ThreadLocal<RemoteWebDriver> threadDriver = null;
  String browsers[]={"firefox"};
  @BeforeMethod
  public void setUp() throws MalformedURLException {
      threadDriver = new ThreadLocal<RemoteWebDriver>();
      DesiredCapabilities dc = new DesiredCapabilities();
      for(String browser:browsers){
         dc.setBrowserName(browser);
         threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc));
      }
  }

  public WebDriver getDriver() {
      return threadDriver.get();
  }

  @AfterMethod
  public void closeBrowser() {
      getDriver().quit();
  }
}

