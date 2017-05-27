package main.java;

/**
 * Represents a plotter that draws a bar graphic, using a BarGraphic.
 * @author alejandro
 *
 */
public class BarPlotter extends AbstractPlotter {
  /**
   * Creates a BarPlotter given a string of tuples, where the builder
   * parse the tuples of data and add it one by one to his own Graphic.
   * @param info    Tuples of data.
   */
  public BarPlotter(String info) {
    super(info);
  }

  @Override
  protected void init() {
    this.graphic = new BarGraphic();
  }
}
