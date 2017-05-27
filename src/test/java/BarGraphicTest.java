package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import main.java.BarGraphic;
import main.java.Graphic;
import main.java.Pair;

import org.junit.Before;
import org.junit.Test;



public class BarGraphicTest {
  Graphic graphic1;
  Graphic graphic2;
  
  /**
   * Setups the graphics for the tests.
   * @throws Exception  Some exception.
   */
  @Before
  public void setUp() throws Exception {
    graphic1 = new BarGraphic();
    graphic2 = new BarGraphic();
    graphic2.add(new Pair("3,4"));
  }

  @Test
  public void voidToStringTest() {
    assertEquals(graphic1.toString(), "");
    assertNotEquals(graphic1.toString(), graphic2.toString());
  }
  
  @Test
  public void setHorizontalAxeTest() {
    String previous = graphic2.toString();
    graphic2.setX("13");
    String current = graphic2.toString();
    assertEquals(previous, current);
  }
  
  @Test
  public void setVerticalAxeTest() {
    String previous = graphic2.toString();
    graphic2.setY("13");
    String current = graphic2.toString();
    assertNotEquals(previous, current);
  }
  
  @Test(expected = NumberFormatException.class)
  public void wrontSetVerticalAxeTest() {
    graphic2.setY("hola");
  }
  
  @Test
  public void columnWithLongNameTest() {
    graphic2.add(new Pair("hola,4"));
    System.out.println(graphic2.toString());
  }
  
 

}
