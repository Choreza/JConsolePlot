package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import main.java.Graphic;
import main.java.Pair;
import main.java.ScatterGraphic;

import org.junit.Before;
import org.junit.Test;

public class ScatterGraphicTest {
  Graphic scatter1;
  Graphic scatter2;
  
  /**
   * Setups the scatter graphics for the tests.
   * @throws Exception  Some exception.
   */
  @Before
  public void setUp() throws Exception {
    scatter1 = new ScatterGraphic();
    scatter2 = new ScatterGraphic();
    scatter2.add(new Pair("3,4"));
  }

  @Test
  public void voidToStringTest() {
    assertEquals(scatter1.toString(), "");
  }
  
  @Test
  public void setHorizontalAxeTest() {
    String previous = scatter2.toString();
    scatter2.setX("12");
    String current = scatter2.toString();
    assertNotEquals(previous, current);
  }

  @Test
  public void setVerticalAxeTest() {
    String previous = scatter2.toString();
    scatter2.setY("12");
    String current = scatter2.toString();
    assertNotEquals(previous, current);
  }

  @Test(expected = NumberFormatException.class)
  public void wrontSetHorizontalAxeTest() {
    scatter2.setX("hola"); 
  }

  @Test(expected = NumberFormatException.class)
  public void wrontSetVerticalAxeTest() {
    scatter2.setY("hola");
  }
}