package main.java;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a Bar Graphic, given a set of points added to his info. Implements a
 * Graphic.
 * @author alejandro
 * @see Graphic
 */
public class BarGraphic implements Graphic {
  private ArrayList<Pair> pairs = new ArrayList<Pair>();
  private int maxVertical = Integer.MIN_VALUE;
  
  @Override
  public void add(Pair pair) {
    pairs.add(pair);
    this.updateAxes(pair);
  }

  private String getFooterAxeX() {
    StringBuilder rep = new StringBuilder();
    rep.append(String.join("", Collections.nCopies(1 + 2 * pairs.size(), "==")));
    rep.append("\n" + String.join("", 
        Collections.nCopies(String.valueOf(maxVertical).length(), " ")));
    rep.append("  ");
    for (int i = 0; i < pairs.size(); ++i) {
      char[] space = "    ".toCharArray();
      String  currX = pairs.get(i).getX();
      currX = currX.substring(0, Math.min(currX.length(), 4));
      for (int r = 0; r < currX.length(); ++r) {
        space[r] = currX.charAt(r);
      }
      if (space[3] != ' ') {
        space[3] = '.';
      }
      rep.append(new String(space));
    }
    rep.append("\n");
    return rep.toString();
  }

  private String getHeaderAxeY(String index) {
    char[] axeY = String.join("", Collections.nCopies(String.valueOf(maxVertical).length(),
        " ")).toCharArray();
    for (int r = 0; r < index.length(); ++r) {
      axeY[r] = index.charAt(r);
    }
    return (new String(axeY)) + "| ";
  }

  @Override
  public void setX(String someX) {
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
    for (int j = maxVertical; j >= 0; --j) {
      rep.append(this.getHeaderAxeY(String.valueOf(j)));
      for (int i = 0; i < pairs.size(); ++i) {
        Pair pair = pairs.get(i);
        if (Integer.parseInt(pair.getY()) >= j) {
          rep.append("XX  ");
        } else {
          rep.append("    ");
        }
      }
      rep.append("\n");
    }
    rep.append(this.getFooterAxeX());
    return rep.toString();
  }
  
  private void updateAxes(Pair pair) {
    maxVertical = Integer.max(maxVertical, Integer.parseInt(pair.getY()));
  }
}
