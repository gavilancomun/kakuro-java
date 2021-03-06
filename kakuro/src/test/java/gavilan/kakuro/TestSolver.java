package gavilan.kakuro;

import gavilan.kakuro.Interpreter;
import gavilan.kakuro.GridController;
import java.io.StringReader;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

public class TestSolver {

@Test
public void testAPI() {
  String expected = "     3         9    \n";
  GridController grid = new GridController();
  grid.createRow().addEmpty().addDown(4).addDown(22).addEmpty().addDown(16).addDown(3);
  grid.createRow().addAcross(3).addValue(2).addDownAcross(16, 6).addValue(2);
  grid.createRow().addAcross(18).addValue(5);
  grid.createRow().addEmpty().addDownAcross(17, 23).addValue(3).addDown(14);
  grid.createRow().addAcross(9).addValue(2).addAcross(6).addValue(2);
  grid.createRow().addAcross(15).addValue(2).addAcross(12).addValue(2);
  String result = grid.solve();
  assertEquals(expected, result.substring(result.length() - expected.length()));
}

@Ignore
@Test
public void testParse() {
  String expected = "     3         9    \n";
  String k = "XXXXX  4\\-   22\\-  XXXXX  16\\-  3\\-\n"
          + "-\\3   .      .      16\\6  .      .\n"
          + "-\\18  .      .      .      .      .\n"
          + "XXXXX  17\\23 .      .      .      14\\-\n"
          + "-\\ 9  .      .      -\\6   .      .\n"
          + "-\\15  .      .      -\\12  .      .\n";
  GridController gc = Interpreter.interpret(new StringReader(k));
  String result = gc.solve();
  assertEquals(expected, result.substring(result.length() - expected.length()));
}

@Test
public void testWikipediaExample() {
  String expected = "     2         1    \n";
  String k = "XXXXXX 23\\- 30\\-  XXXXXX XXXXXX 27\\- 12\\- 16\\- \n"
          + "-\\16  .     .      XXXXXX 17\\24 .     .     .     \n"
          + "-\\17  .     .      15\\29 .      .     .     .     \n"
          + "-\\35  .     .      .      .      .     12\\- XXXXXX\n"
          + "XXXXXX -\\7  .      .      7\\8   .     .     7\\-  \n"
          + "XXXXXX 11\\- 10\\16 .      .      .     .     .     \n"
          + "-\\21  .     .      .      .      -\\5  .     .     \n"
          + "-\\6   .     .      .      XXXXXX -\\3  .     .     \n";
  GridController gc = Interpreter.interpret(new StringReader(k));
  String result = gc.solve();
  assertEquals(expected, result.substring(result.length() - expected.length()));
}
}
