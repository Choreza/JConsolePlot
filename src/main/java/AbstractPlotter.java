package main.java;

/**
 * Implements a plotter, given a string representing a set of tuples.
 * @author alejandro
 * @see Plotter
 */
public abstract class AbstractPlotter implements Plotter {
  protected Graphic graphic;
  
  /**
   * Creates an AbstractPlotter given a string of tuples, where the builder
   * parse the tuples of data and add it one by one to his own Graphic.
   * @param info    Tuples of data.
   */
  public AbstractPlotter(String info) {
    this.init();
    String[] tuples = info.split(" ");
    for (String tuple : tuples) {
      graphic.add(new Pair(tuple));
    }
  }
  
  @Override
  public void setX(boolean hasX, String infoX) {
    if (hasX) {
      graphic.setX(infoX);
    }

  }

  @Override
  public void setY(boolean hasY, String infoY) {
    if (hasY) {
      graphic.setY(infoY);
    }
  }

  @Override
  public String toString() {
    return graphic.toString();
  }
  
  protected void init() {
    return;
  }
}
