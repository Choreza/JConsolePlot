package main.java;

/**
 * Represents a Plotter, that draws a Scatter Graphic, using a ScatterGraphic.
 * @author alejandro
 *
 */
public class ScatterPlotter extends AbstractPlotter {
  /**
   * Creates a ScatterPlotter given a string of tuples, where the builder
   * parse the tuples of data and add it one by one to his own Graphic.
   * @param info    Tuples of data.
   */
  public ScatterPlotter(String info) {
    super(info);
  }
  
  @Override
  protected void init() {
    this.graphic = new ScatterGraphic();
  }
}
