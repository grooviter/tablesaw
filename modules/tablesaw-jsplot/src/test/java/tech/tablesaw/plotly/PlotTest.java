package tech.tablesaw.plotly;

import java.io.File;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class PlotTest {

  @Test
  void show() {
    String html = "<html><body><h1>Hello World<h1></body></html>";
    File file = new File("build/testoutput/myfile.html");
    Plot.show(html, file);
  }
}
