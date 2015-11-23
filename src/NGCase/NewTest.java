package NGCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void abd() {
	  System.out.println("Test");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("before method");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test");
  }

}
