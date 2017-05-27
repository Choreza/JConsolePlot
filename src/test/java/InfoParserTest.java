package test.java;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.text.ParseException;

import main.java.InfoParser;

import org.junit.Before;
import org.junit.Test;

public class InfoParserTest {
  InfoParser ip;
  InfoParser ip2;
  String[] args;
  String[] badArgs;
  String[] fileArgs;
  String[] badFileArgs;
  
  /**
   * Initializes the InfoParser given a array of strings.
   * @throws Exception  Some Exception.
   */
  @Before
  public void setUp() throws Exception {
    args = new String[]{"ScatterPlotter", "-P", "1,3 4,5", "-x", "12", "-y", "7"};
    badArgs = new String[]{"ScatterPlotter", "-R", "1,3 4,5", "-x", "12", "-y", "7"};
    fileArgs = new String[]{"ScatterPlotter", "-F",
        "/home/alejandro/workspace/Tarea2/src/test/data/scatterExample.txt", "-x", "12", "-y", "7"};
    badFileArgs = new String[]{"ScatterPlotter", "-F", "1,3 4,5", "-x", "12", "-y", "7"};
    ip = new InfoParser(args);
    ip2 = new InfoParser(fileArgs);
  }

  @Test (expected = FileNotFoundException.class)
  public void badFileArgsTest() {
    ip2 = new InfoParser(badFileArgs);
  }
  
  @Test (expected = ParseException.class)
  public void badLineArgsTest() {
    ip = new InfoParser(badArgs);
  }
  
  @Test
  public void hasOptionTest() {
    assertEquals(ip.hasOption("horizontal"), true);
    assertEquals(ip.hasOption("vertical"), true);
  }
  
  @Test
  public void getOptionValueTest() {
    String horizontal = ip.getOptionValue("horizontal");
    assertEquals(horizontal, "12");
    assertEquals(ip.getOptionValue("horizontal"), "12");
  }
  
  @Test
  public void toStringByLineTest() {
    assertEquals("1,3 4,5", ip.toString());
  }
  
  @Test
  public void toStringByFile() {
    assertEquals("3,2 12,4 12,6 6,6 5,8 3,3 10,4 8,3", ip2.toString());
  }
}
