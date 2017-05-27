package main.java;

import java.util.StringTokenizer;

/**
 * Represent a pair of strings, the second element must be an integer. The first could be anything.
 * @author alejandro
 *
 */
public class Pair {
  private String coordinateX;
  private String coordinateY;
  
  /**
   * Create an object of the class Pair, which represents a tuple (coordinateX, coordinateY)
   * @param pair    represents a string "x,y".
   */
  public Pair(String pair) {
    StringTokenizer st = new StringTokenizer(pair, ",");
    coordinateX = st.nextToken();
    coordinateY = st.nextToken();
  }
  
  /**
   * Getter of the horizontal coordinate
   * @return    coordinateX, the string of the horizontal coordinate.
   */
  public String getX() {
    return coordinateX;
  }
  
  /**
   * Getter of the vertical coordinate
   * @return coordinateY, the string of the vertical coordinate.
   */
  public String getY() {
    return coordinateY;
  }
}
