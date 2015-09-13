package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import utils.Actions;
import utils.Utils;


public class Base {
  public WebDriver driver;
  public Utils utils=new Utils();
  Actions action=new Actions(this);

  @Before
  public void setup(){
    utils.createLoggers(this.getClass().getName());
    try {
      createNewBrowser();
    } catch (IOException e) {
    }
  }

  @After
  public void tearDown(){
    String sClassName=this.getClass().getName();
    utils.log.info("###################### Terminating "+sClassName+"##########################");
    utils.closeLoggers();
    driver.quit();
  }

  public void createNewBrowser() throws IOException{
    Properties prop = new Properties();
    String propFileName = "test.properties";
    FileInputStream inputStream = new FileInputStream(propFileName);
    if (inputStream != null) {
      prop.load(inputStream);
    } else {
      utils.log.info("property file '" + propFileName + "' not found in the classpath");
      throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
    }
    Date time = new Date(System.currentTimeMillis());
    String browser = prop.getProperty("Browser");
    if(browser.equals("firefox")){
      FirefoxProfile profile = new FirefoxProfile();
      profile.setPreference("browser.cache.disk.enable", false);
      profile.setPreference("browser.cache.memory.enable", false);
      profile.setPreference("browser.cache.offline.enable", false);
      profile.setPreference("network.http.use-cache", false);
      profile.setPreference("dom.disable_open_during_load", false);
      profile.setPreference("dom.max_chrome_script_run_time", 180000);
      profile.setPreference("dom.max_script_run_time", 180000);
      profile.setPreference("browser.sessionstore.resume_session_once", true);
      profile.setPreference("browser.safebrowsing.enabled", false);
      this.driver = new FirefoxDriver(profile);
      action.driver=driver;
    }
     else if(browser.equals("chrome")){
       driver=new ChromeDriver();
     }
     else{
       utils.log.info("Unknown Driver"+browser);
     }
    }
  }

