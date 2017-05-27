package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import main.java.Plotter;
import main.java.ScatterPlotter;

import org.junit.Before;
import org.junit.Test;

public class ScatterPlotterTest {
  Plotter scatterplotter1;
  Plotter scatterplotter2;
  
  @Before
  public void setUp() throws Exception {
    scatterplotter1 = new ScatterPlotter("3,4");
    scatterplotter2 = new ScatterPlotter("3,4");
  }

  @Test
  public void equalPlotsTest() {
    assertEquals(scatterplotter1.toString(), scatterplotter2.toString());
    scatterplotter2 = new ScatterPlotter("3,4 4,5");
    assertNotEquals(scatterplotter1.toString(), scatterplotter2.toString());
  }
  
  @Test
  public void setHorizontalAxeTest() {
    String previous = scatterplotter2.toString();
    scatterplotter2.setX(true, "12");
    String current = scatterplotter2.toString();
    assertNotEquals(previous, current);
  }
  
  @Test
  public void notSetHorizontalAxeTest() {
    String previous = scatterplotter2.toString();
    scatterplotter2.setX(false, "12");
    String current = scatterplotter2.toString();
    assertEquals(previous, current);
  }
  
  @Test
  public void setVerticalAxeTest() {
    String previous = scatterplotter2.toString();
    scatterplotter2.setY(true, "12");
    String current = scatterplotter2.toString();
    assertNotEquals(previous, current);
  }
  
  @Test
  public void notSetVerticalAxeTest() {
    String previous = scatterplotter2.toString();
    scatterplotter2.setY(false, "12");
    String current = scatterplotter2.toString();
    assertEquals(previous, current);
  }
}
