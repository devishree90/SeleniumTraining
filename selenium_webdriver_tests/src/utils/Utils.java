package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Utils {
  public Logger log;
  public FileHandler logFileHandler;
  public JsonArray locators;

  public Utils(){
    getLocators();
  }

  public Logger createLoggers(String logFileName) {
    try {
      log =  Logger.getLogger("log");
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd HH-mm-ss");
      Date date = new Date();
      String time = dateFormat.format(date).toString();

      logFileHandler = new FileHandler("logs//"+ logFileName + "-"+ time + ".log");
      logFileHandler.setFormatter(new SimpleFormatter());
      log.addHandler(logFileHandler);
      log.info("Executing Test:"+logFileName);
    } catch (IOException e) {
      System.out.println("Unable to create log File for "+logFileName);
    }
    return log;
  }

  public void closeLoggers() {
    log.removeHandler(logFileHandler);
    logFileHandler.flush();
    logFileHandler.close();
  }

  public void getLocators(){
    JsonParser parser=new JsonParser();
    JsonObject obj;
    try {
      obj = (JsonObject)parser.parse(new FileReader("src/locator.txt"));
      locators=(JsonArray) obj.get("locators");
    } catch (JsonIOException e) {
      // TODO Auto-generated catch block
    } catch (JsonSyntaxException e) {
      // TODO Auto-generated catch block
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
    }
  }


  public By getLocator(String name){
    By locator = null;
      Iterator<JsonElement> iterator=locators.iterator();
      while(iterator.hasNext()){
        JsonElement element=iterator.next();
        JsonObject locator_array=element.getAsJsonObject();
        if(locator_array.get("id").getAsString().equals(name)){
          if(locator_array.get("type").getAsString().equals("id")){
            locator=By.id(locator_array.get("locator").getAsString());
            break;
          }
        }
      }
      return locator;

  }
}
