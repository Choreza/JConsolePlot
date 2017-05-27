package main.java;

/**
 * Represents a Random Graphic and has the standard method to graph data. It includes a method
 * to add data, and methods to set the axes of the graphic. And a method tu return the graphic.
 * @author alejandro
 *
 */
public interface Graphic {
  /**
   * Add a pair to the list of pairs contained in the graphic.
   * @param pair    Represents a pair of strings, the element to be added.
   */
  public void add(Pair pair);
  
  /**
   * Set the maximum value of the X axe of the Graphic.
   * @param someX   The value to be set.
   */
  public void setX(String someX);
  
  /**
   * Set the maximum value of the Y axe of the Graphic.
   * @param someY The value to be set.
   */
  public void setY(String someY);
  
  /**
   * Return a string representative of the Graphic, use the data added
   * previously. If no info has been added, returns a empty string.
   * @return    A graphic representative of the tuples added.
   */
  public String toString();
}
