package main.java;

/**
 * Represents a Random Plotter, that receives data as a String and draws a graphic.
 * @author alejandro
 *
 */
public interface Plotter {
  
  /**
   * Set the value of the X coordinate to infoX, if only if hasX is true.
   * @param hasX    Indicates if is required to modify the X axe size.
   * @param infoX   Is the value of the new size of the X axe, is a null
   *                if hasX is false.
   */
  public void setX(boolean hasX, String infoX);

  /**
   * Set the value of the Y coordinate to infoY, if only if hasY is true.
   * @param hasY    Indicates if is required to modify the Y axe size.
   * @param infoY   Is the value of the new size of the Y axe, is a null
   *                if hasY is false.
   */
  public void setY(boolean hasY, String infoY);

  /**
   * Return a string containing the graphics given by the plotter.
   * @return    a string containing the graphic of the information loaded 
   *            in the plotter.
   */
  public String toString();

}
