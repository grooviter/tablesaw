/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tech.tablesaw.examples;

import org.apache.commons.math3.distribution.NormalDistribution;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.QQPlot;

/** Illustrates how to create a quantile plot for visualizing a distribution */
public class QQPlotExample {

  public static void main(String[] args) throws Exception {
    Table baseball = Table.read().csv("../../data/baseball.csv");
    Plot.show(QQPlot.create("batting averages and On-base percent", baseball, "BA", "SLG"));

    // example with different sized arrays;
    double[] first = new NormalDistribution().sample(100);
    double[] second = new NormalDistribution().sample(200);
    Plot.show(
        QQPlot.create(
            "Test of different sized arrays", "short array", first, "long array", second));

    // example with different sized arrays;
    first = new NormalDistribution().sample(20000);
    second = new NormalDistribution().sample(19990);
    Plot.show(
        QQPlot.create(
            "Test of different sized arrays", "long array", first, "short array", second));
  }
}
