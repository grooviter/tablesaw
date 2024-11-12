package tech.tablesaw.components;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.net.URL;
import org.junit.jupiter.api.Test;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Page;
import tech.tablesaw.plotly.components.Page.PageBuilder;
import tech.tablesaw.plotly.components.TemplateUtils;
import tech.tablesaw.plotly.traces.ScatterTrace;
import tech.tablesaw.plotly.traces.Trace;

public class TemplateUtilsTest {

  private double[] x = {1, 2, 3, 4, 5};
  private double[] y = {1, 4, 9, 16, 25};

  private String customTemplateString = "<!-- Custom page_template.html -->";

  @Test
  public void testDefaultTemplateLocation() {
    TemplateUtils.setTemplateLocations();
    String html = createPageHtml();
    assertTrue(html.indexOf(customTemplateString) < 0);
  }

  @Test
  public void testCustomTemplateLocation() {
    URL templateURL = this.getClass().getResource("page_template.html");
    File templateFile = new File(templateURL.getFile());
    assertNotNull(templateURL, "Couldn't locate class (as resource), where template is also found");
    assertTrue(templateFile.exists(), templateFile + " doesn't exist");
    TemplateUtils.setTemplateLocations(templateFile.getParent());
    String html = createPageHtml();
    assertTrue(html.contains(customTemplateString));
  }

  private String createPageHtml() {
    Trace trace = ScatterTrace.builder(x, y).build();
    Figure figure = new Figure(trace);
    Page page = new PageBuilder(figure, "plot").build();
    String html = page.asJavascript();
    return html;
  }
}
