package NGCase;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class AnotherTest {
 
@Test
  public void test() {
	  System.out.println("Test");
	  throw new SkipException("skipping");
  }
}
