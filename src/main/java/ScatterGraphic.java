package main.java;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a Scatter Graphic, given a set of tuples added to his info. Implements 
 * a Graphic.
 * @author alejandro
 * @see Graphic
 */
public class ScatterGraphic implements Graphic {
  ArrayList<Pair> pairs = new ArrayList<Pair>();
  private int maxHorizontal = Integer.MIN_VALUE;
  private int maxVertical = Integer.MIN_VALUE;
  private int minHorizontal = Integer.MAX_VALUE;
  private int minVertical = Integer.MAX_VALUE;
  
  @Override
  public void add(Pair pair) {
    pairs.add(pair);
    this.updateAxes(pair);
  }

  @Override
  public void setX(String someX) {
    try {
      this.maxHorizontal = Integer.parseInt(someX);
    } catch (NumberFormatException e) {
      System.out.println("Write a valid number");
    }
    return;
  }

  @Override
  public void setY(String someY) {
    try {
      this.maxVertical = Integer.parseInt(someY);
    } catch (NumberFormatException e) {
      System.out.println("Write a valid number");
    }
    return;
  }
  
  @Override
  public String toString() {
    if (pairs.isEmpty()) {
      return "";
    }
    StringBuilder rep = new StringBuilder();
    for (int j = maxVertical; j >= minVertical; --j) {
      rep.append(this.getHeaderAxeY(String.valueOf(j)));
     
      int delta = String.valueOf(maxHorizontal).length();
      for (int i = minHorizontal * delta; i <= maxHorizontal * delta; i += delta) {
        boolean cond = false;
        for (Pair pair : pairs) {
          int currX = Integer.parseInt(pair.getX());
          int currY = Integer.parseInt(pair.getY());
          if (currX == i / delta && currY == j) {
            rep.append("X");
            cond = true;
            break;
          }
        }
        if (!cond) {
          rep.append(" ");
        }
        for (int r = 0; r < delta; ++r) {
          rep.append(" ");
        }
      }
      rep.append("\n");
    }
    rep.append(this.getFooterAxeX());
    return rep.toString();
  }
  
  private void updateAxes(Pair pair) {
    maxHorizontal = Integer.max(maxHorizontal, Integer.parseInt(pair.getX()));
    maxVertical = Integer.max(maxVertical, Integer.parseInt(pair.getY()));
    minHorizontal = Integer.min(minHorizontal, Integer.parseInt(pair.getX()));
    minVertical = Integer.min(minVertical, Integer.parseInt(pair.getY()));
  }
  
  private String getHeaderAxeY(String index) {
    char[] axeY = String.join("", Collections.nCopies(String.valueOf(maxVertical).length(),
        " ")).toCharArray();
    for (int r = 0; r < index.length(); ++r) {
      axeY[r] = index.charAt(r);
    }
    return (new String(axeY)) + "|";
  }
  
  private String getFooterAxeByIndex(String index) {
    char[] axeX = String.join("", Collections.nCopies(String.valueOf(maxHorizontal).length(),
        " ")).toCharArray();
    for (int r = 0; r < index.length(); ++r) {
      axeX[r] = index.charAt(r);
    }
    return (new String(axeX) + " ");
  }
  
  private String getFooterAxeX() {
    StringBuilder rep = new StringBuilder();
    int delta = String.valueOf(maxHorizontal).length() + 1;
    int lineSize =  delta * (1 + maxHorizontal - minHorizontal) 
        + String.valueOf(maxVertical).length();
    rep.append(String.join("", Collections.nCopies(lineSize, "=")));
    rep.append("\n");
    rep.append(String.join("", Collections.nCopies(String.valueOf(maxVertical).length(),
        " ")) + " ");
    for (int i = minHorizontal; i <= maxHorizontal; ++i) {
      rep.append(this.getFooterAxeByIndex(String.valueOf(i)));
    }
    return rep.toString();
  }
}
