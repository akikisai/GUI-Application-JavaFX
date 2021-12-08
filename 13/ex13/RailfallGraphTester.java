// Exercise 13T: Rainfall Graph Tester
package ex13;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class RailfallGraphTester extends Application {

    RailfallGraph app;
    String appName = "RainfallGraph";
    int score = 0, scoreMax = 10, s1 = 1, s2 = 1, s3 = 1;

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.printf("%s テスト開始\n", appName);
            app = new RailfallGraph();
            app.start(primaryStage);

            System.out.print("--- 起動 Scene ... ");
            Scene scene = primaryStage.getScene();
            if (scene != null) {
                System.out.println("成功");
                score += s1;
            } else {
                System.out.println("失敗");
                printScore();
                return;
            }

            System.out.print("--- 確認 円グラフタイトル ... ");
            if (app.pieChart.getTitle() != null) {
                System.out.println("成功");
                score += s2;
            } else {
                System.out.println("失敗");
            }

            System.out.printf("--- 確認 円グラフデータ系列 ...");
            ObservableList<PieChart.Data> pieList = app.pieChart.getData();
            if (pieList.size() == 12) {
                System.out.println("成功");
                score += s3;
            } else {
                System.out.println("失敗");
                printScore();
                return;
            }

            System.out.printf("--- 確認 1月 ...");
            if (pieList.get(0).getName().contains("1")) {
                System.out.println("成功");
                score += s3;
            } else {
                System.out.println("失敗");
                printScore();
                return;
            }

            System.out.printf("--- 確認 データ ...");
            if (pieList.get(0).getPieValue() == 135) {
                System.out.println("成功");
                score += s3;
            } else {
                System.out.println("失敗");
                printScore();
                return;
            }

            System.out.print("--- 確認 棒グラフ縦軸ラベル ... ");
            if (app.yAxis.getLabel() != null) {
                System.out.println("成功");
                score += s2;
            } else {
                System.out.println("失敗");
            }

            System.out.printf("--- 確認 棒グラフデータ系列 ...");
            ObservableList<XYChart.Series<String, Number>> barList = app.barChart.getData();
            if (barList.size() == 1) {
                System.out.println("成功");
                score += s3;
            } else {
                System.out.println("失敗");
                printScore();
                return;
            }

            System.out.printf("--- 確認 系列[0] ...");
            ObservableList<XYChart.Data<String, Number>> series = barList.get(0).getData();
            if (series.size() == 12) {
                System.out.println("成功");
                score += s3;
            } else {
                System.out.println("失敗");
                printScore();
                return;
            }

            System.out.printf("--- 確認 12月 ...");
            if (series.get(11).getXValue().contains("12")) {
                System.out.println("成功");
                score += s3;
            } else {
                System.out.println("失敗");
                printScore();
                return;
            }

            System.out.printf("--- 確認 データ ...");
            if ((double) series.get(11).getYValue() == 13) {
                System.out.println("成功");
                score += s3;
            } else {
                System.out.println("失敗");
                printScore();
                return;
            }

            primaryStage.close();
            System.out.printf("%s テスト終了\n", appName);
            printScore();
        } catch (Exception e) {
            printScore();
            e.printStackTrace();
        }
    }

    void printScore() {
        System.out.println(String.format(
                "\n【実行対象:%s, 学籍番号:%s, 学生氏名:%s, 評点:%d】",
                appName, app.gakuban, app.yourname, score));
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
