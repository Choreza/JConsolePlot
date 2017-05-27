package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import main.java.Pair;

import org.junit.Before;
import org.junit.Test;

public class PairTest {
  Pair pair1;
  Pair pair2;

  @Test
  public void horizontalAxeTest() {
    assertEquals(pair1.getX(), "1");
    assertEquals(pair2.getX(), "12");
  }

  @Before
  public void setUp() throws Exception {
    pair1 = new Pair("1,2");
    pair2 = new Pair("12,4");
  }

  @Test
  public void verticalAxeTest() {
    assertEquals(pair1.getY(), "2");
    assertEquals(pair2.getY(), "4");
  }

  @Test
  public void differentPairsTest() {
    assertNotEquals(pair1.getX(), pair2.getX());
    assertNotEquals(pair1.getY(), pair2.getY());
  }
}
