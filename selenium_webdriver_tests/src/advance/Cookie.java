package advance;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cookie {
  public WebDriver driver;

  @Before
  public void setUp(){
    driver=new FirefoxDriver();
  }

  @After
  public void teardown(){
    driver.close();
  }

  @Test
  public void testCookie(){
    driver.get("http://localhost:1234/2014/09/06/Cookie.html");
    driver.findElement(By.className("button")).click();
    readCookies(driver);
    org.openqa.selenium.Cookie cookie = new org.openqa.selenium.Cookie("test", "test");
    driver.manage().addCookie(cookie);
    driver.manage().deleteCookieNamed("username");
    readCookies(driver);
    driver.manage().deleteAllCookies();
    readCookies(driver);
  }

  public void readCookies(WebDriver driver) {
    Set<org.openqa.selenium.Cookie> allCookies = driver.manage().getCookies();
    for (org.openqa.selenium.Cookie loadedCookie : allCookies) {
        System.out.println(String.format("%s -> %s", loadedCookie.getName(), loadedCookie.getValue()));
    }
    System.out.println("=========================");
  }
}
