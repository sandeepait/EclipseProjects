package softAssert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LearnSoftAssert {
	
  @Test
  public void doLearnSoftAssert() {
	  SoftAssert sa = new SoftAssert();
	  sa.assertTrue(1>2);
	  sa.assertTrue(2>1);
	  sa.assertAll();
  }
}
