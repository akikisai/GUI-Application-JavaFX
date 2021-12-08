// Listing 13-3: LineChartSample2.java

package linechartsample;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LineChartSample2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // データを準備
        ArrayList<DairyData> list = new ArrayList<>();
        list.add(new DairyData(1, 27.5, 17.3));
        list.add(new DairyData(2, 27.2, 16.9));
        list.add(new DairyData(3, 28.6, 17.3));
        list.add(new DairyData(4, 29.1, 18.5));
        list.add(new DairyData(5, 28.3, 18.2));
        list.add(new DairyData(6, 22.8, 18.3));
        list.add(new DairyData(7, 27.3, 18.2));
        list.add(new DairyData(8, 27.5, 19.3));
        list.add(new DairyData(9, 32.0, 21.2));
        list.add(new DairyData(10, 22.0, 18.6));

        // 最高気温データを作成
        XYChart.Series<String, Number> maxTempar = new XYChart.Series<>();
        maxTempar.setName("最高気温");
        for (DairyData d : list) {
            maxTempar.getData().add(new XYChart.Data<>(
                    d.getDayString(), d.maxTempar));
        }

        // 最低気温データを作成
        XYChart.Series<String, Number> minTempar = new XYChart.Series<>();
        minTempar.setName("最低気温");
        for (DairyData d : list) {
            minTempar.getData().add(new XYChart.Data<>(
                    d.getDayString(), d.minTempar));
        }

        // XY軸を作成
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("日");
        yAxis.setLabel("気温（°C）");

        // 折れ線グラフを作成
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.getData().addAll(maxTempar, minTempar);
        lineChart.setTitle("東京 2018年6月上旬");
        lineChart.setLegendSide(Side.TOP);

        // 折れ線グラフを表示
        StackPane stackPane = new StackPane(lineChart);
        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Line Chart Sample2");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--LineChartSample2");
    }
}

class DairyData {

    public int day;
    public double maxTempar;
    public double minTempar;

    public DairyData(int day, double maxTempar, double minTempar) {
        this.day = day;
        this.maxTempar = maxTempar;
        this.minTempar = minTempar;
    }

    public String getDayString() {
        return Integer.toString(day);
    }

    @Override
    public String toString() {
        return String.format("(%d, %f, %f)", day, maxTempar, minTempar);
    }
}
