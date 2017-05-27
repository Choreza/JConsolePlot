package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Parse the info required to draw a Graphic using a Plotter.
 * @author alejandro
 *
 */
public class InfoParser {
  private CommandLine cmd;
  
  /**
   * Builder of an InfoParser, given a line of arguments this builder check for the possible options
   * required to plot. If is given a wrong option throw an exception. Check for possibles options in
   * the set {F, P, x, y}.
   * @param args command line arguments
   */
  public InfoParser(String[] args) {
    Options options = new Options();
    
    Option fileCommand = new Option("F", "file", true, "Set a file path");
    fileCommand.setRequired(false);
    options.addOption(fileCommand);
    
    Option listCommand = new Option("P", "list", false, "List plotter info");
    fileCommand.setRequired(false);
    options.addOption(listCommand);
    
    Option horizontalAxe = new Option("x", "horizontal", true, "Set a horizontal axe");
    horizontalAxe.setRequired(false);
    options.addOption(horizontalAxe);

    Option verticalAxe = new Option("y", "vertical", true, "Set a horizontal axe");
    verticalAxe.setRequired(false);
    options.addOption(verticalAxe);

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    
    try {
      cmd = parser.parse(options, args);
      
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      formatter.printHelp("utility-name", options);
    }
  }
  
  /**
   * Search the tuples of data, considering if the order is to search in a file (F) or if the order
   * is to search in the line of arguments, and return the tuples separated by a whitespace.
   */
  public String toString() {
    if (cmd.hasOption("list")) {
      return this.searchLine();
    }
    return this.searchFile();
  }
  
  /**
   * Given a possible option this method returns true if the option was written in the command line,
   * false if not.
   * @param option string written in the command line, necessary in {P, F, x, y}.
   * @return true if the option was written, false else.
   */
  public boolean hasOption(String option) {
    return cmd.hasOption(option);
  }
  
  /**
   * Given an possible option this method returns the string that follows the option, if only if the
   * option was written in the command line. Else return null. This method just get info for options
   *  in {x, y}, if is necessary to get the info in {P, F} use toString method.
   * @param option string written in the command line, necessary in {x, y}
   * @return a string which represents the option value, null if there wasn't written the option.
   */
  public String getOptionValue(String option) {
    return cmd.getOptionValue(option);
  }
  
  private String searchFile() {
    StringBuilder rep = new StringBuilder();
    try {
      BufferedReader bf = new BufferedReader(new FileReader(cmd.getOptionValue("file")));
      String line = bf.readLine().trim();
      while (line != null) {
        rep.append(line + " ");
        line = bf.readLine();
      }
      bf.close();
    } catch (IOException e) {
      System.out.println("Unable to read the file: " + cmd.getOptionValue("file"));
      e.printStackTrace();
    }
    return rep.toString().trim();
  }

  private String searchLine() {
    StringBuilder sb = new StringBuilder();
    for (String arg : cmd.getArgs()) {
      if (arg.contains(",")) {
        sb.append(arg + " ");
      }
    }
    return sb.toString().trim();
  }
  
}
