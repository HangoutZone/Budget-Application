package application;

import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;

import java.awt.Color;
import java.awt.Font;

public class CustomPieChart implements ExampleChart<org.knowm.xchart.PieChart> {
    public CustomPieChart(){

    }

    @Override
    public org.knowm.xchart.PieChart getChart() {
        // Create Chart
        org.knowm.xchart.PieChart chart = new PieChartBuilder().height(600).width(800).title("Budget Breakdown").theme(Styler.ChartTheme.XChart).build();

        // Customize Chart
        Color[] sliceColors = new Color[]{new Color(224, 68, 14), new Color(38, 23, 167), new Color(6, 222, 184), new Color(0x6CEC05), new Color(0x07A2F6), new Color(0xFCC508)};
        chart.getStyler().setSeriesColors(sliceColors);
        chart.getStyler().setLabelsFont(new Font("Arial", Font.PLAIN, 12));
        chart.getStyler().setLegendVisible(true);
        chart.getStyler().setPlotBorderColor(Color.BLACK);

        return chart;
    }

    @Override
    public String getExampleChartName() {
        return null;
    }
}