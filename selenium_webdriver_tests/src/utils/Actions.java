package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import framework.Base;

public class Actions {
  Utils utils;
  public WebDriver driver;

  public Actions(Base base){
    this.driver=base.driver;
    this.utils=base.utils;
  }

  public void setValue(By by,String value){
    WebElement element=driver.findElement(by);
    String type=element.getAttribute("type");
    if(!(type.equals(""))&&!(type==null)){
      if(type.equals("text"))
        element.sendKeys(value);
      else if(type.equals("radio")){
        if(!element.isSelected()){
          element.click();
        }
      }
      else if(type.equals("checkbox")){
        if(!element.isSelected()){
          element.click();
        }
      }
     }
    else{
      String tag=element.getTagName();
      if(tag.equals("textarea"))
        element.sendKeys(value);
      else if(tag.equals("select"))
        new Select(element).selectByVisibleText(value);
    }
    utils.log.info("Set the value for Locator "+element.getTagName()+" : "+by.toString()+"=>"+value);
  }

  public String getValue(By by){
    String result="";
    WebElement element=driver.findElement(by);
    String type=element.getAttribute("type");
    if(!(type.equals(""))&&!(type==null)){
      if(type.equals("text"))
        result=element.getAttribute("value");
      else if(type.equals("radio")){
        result=element.isSelected()? "true" : "false";
      }
      else if(type.equals("checkbox")){
        result=element.isSelected()? "true" : "false";
      }
     }
    else{
      String tag=element.getTagName();
      if(tag.equals("textarea"))
        result=element.getAttribute("value");
      else if(tag.equals("select"))
        result=new Select(element).getFirstSelectedOption().getText();
    }
    utils.log.info("Retrieved the value for Locator "+element.getTagName()+" : "+by.toString()+"=>"+result);
    return result;
  }

  public void click(By by){
    try{
      WebElement element=driver.findElement(by);
      element.click();
    }catch(Exception e){
      e.printStackTrace();
    }
  }



}
