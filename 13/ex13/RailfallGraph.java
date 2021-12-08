// Exercise 13: Rainfall Graph
package ex13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RailfallGraph extends Application {

    public PieChart pieChart = new PieChart();
    public CategoryAxis xAxis = new CategoryAxis();
    public NumberAxis yAxis = new NumberAxis();
    public BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
    public static double[] data = { // 2020年1月～12月
            135, 15, 131, 296.5, 118, 212.5, 270.5, 61.5, 117.5, 205, 14.5, 13 };

    public static String gakuban = "19EC043"; // 学籍番号を入力すること
    public static String yourname = "蔡 晟輝"; // 氏名を入力すること

    @Override
    public void start(Stage primaryStage) {
        makePieChart(); // 課題13-1
        makeBarChart(); // 課題13-2

        // Showing the Charts
        HBox hbox = new HBox(10, pieChart, barChart);
        Scene scene = new Scene(hbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Railfall Graph");
        primaryStage.show();
    }

    void makePieChart() {
        // 課題 13-1 のコード
    	String month[] = { 
    			"1月", "2月", "3月", "4月", 
    			"5月", "6月", "7月", "8月", 
    			"9月", "10月", "11月", "12月" 
    	};
    	//データ準備
    	PieChart.Data[] pieChartData = new PieChart.Data[12];
    	for(int i = 0; i < 12; i++) {
    		pieChartData[i] = new PieChart.Data(month[i], data[i]);
    	}
    	
    	//円グラフを作成
        pieChart.getData().addAll(pieChartData);
        pieChart.setTitle("2020年東京");
        pieChart.setStartAngle(90);
    	
    }

    void makeBarChart() {
        // 課題 13-2 のコード
    	String month[] = { 
    			"1月", "2月", "3月", "4月", 
    			"5月", "6月", "7月", "8月", 
    			"9月", "10月", "11月", "12月" 
    	};
    	XYChart.Series<String, Number> series1 = new XYChart.Series<>();
    	series1.setName("2020年東京");
    	for(int i = 0; i < 12; i++) {
    		series1.getData().add(new XYChart.Data<>(month[i], data[i]));
    	}
        yAxis.setLabel("降水量(mm)");
        barChart.getData().add(series1);
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--RailfallGraph");
    }
}