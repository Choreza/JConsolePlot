package main.app;

import main.java.BarPlotter;
import main.java.InfoParser;
import main.java.Plotter;
import main.java.ScatterPlotter;

/**
 * This is the main application of the project, before compiling you should execute this, giving 
 * corresponding arguments to the command line. This contains a Plotter which plot according to the
 * requirements given by the commands written. 
 * @throws ParseException  if there is a missing or wrong command.
 * @throws IncompleteCommandException if there is a missing getter info command (-F or -P). 
 * @author alejandro
 *
 */
public class JConsolePlot {
  
  /**
   * Use the array of Strings "args" to get the corresponding information to plot from the Console. 
   * @param args Arguments received by the Command Line.
   */
  public static void main(String[] args) {
    InfoParser infoParser = new InfoParser(args);
    
    String info = infoParser.toString();
    Plotter plotter = (args[0].equals("ScatterPlot") ? new ScatterPlotter(info) : 
        new BarPlotter(info));
  
    boolean hasX = infoParser.hasOption("horizontal");
    boolean hasY = infoParser.hasOption("vertical");
    
    String infoX = infoParser.getOptionValue("horizontal");
    String infoY = infoParser.getOptionValue("vertical");
    
    plotter.setX(hasX, infoX);
    plotter.setY(hasY, infoY);
   
    System.out.print(plotter.toString());
  }
}
