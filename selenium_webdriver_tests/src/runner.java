import junit.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
  DropDown.class,
  TextBox.class,
  Alert.class,
  Attribute.class,
  Link.class,
  Navigation.class
})
public class runner {

}
