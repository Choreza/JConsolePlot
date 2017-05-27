package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import main.java.BarPlotter;
import main.java.Plotter;

import org.junit.Before;
import org.junit.Test;

public class BarPlotterTest {
  Plotter barplotter1;
  Plotter barplotter2;
  
  @Before
  public void setUp() throws Exception {
    barplotter1 = new BarPlotter("3,4");
    barplotter2 = new BarPlotter("3,4");
  }

  @Test
  public void equalPlotsTest() {
    assertEquals(barplotter1.toString(), barplotter2.toString());
    barplotter2 = new BarPlotter("3,4 4,5");
    assertNotEquals(barplotter1.toString(), barplotter2.toString());
  }
  
  @Test
  public void setHorizontalAxeTest() {
    String previous = barplotter2.toString();
    barplotter2.setX(true, "12");
    String current = barplotter2.toString();
    assertEquals(previous, current);
  }
  
  @Test
  public void notSetHorizontalAxeTest() {
    String previous = barplotter2.toString();
    barplotter2.setX(false, "12");
    String current = barplotter2.toString();
    assertEquals(previous, current);
  }
  
  @Test
  public void setVerticalAxeTest() {
    String previous = barplotter2.toString();
    barplotter2.setY(true, "12");
    String current = barplotter2.toString();
    assertNotEquals(previous, current);
  }
  
  @Test
  public void notSetVerticalAxeTest() {
    String previous = barplotter2.toString();
    barplotter2.setY(false, "12");
    String current = barplotter2.toString();
    assertEquals(previous, current);
  }
}
