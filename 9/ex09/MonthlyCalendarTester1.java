// Exercise 9-1T: Monthly Calendar Tester
package ex09;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MonthlyCalendarTester1 extends Application {

    MonthlyCalendar app;
    String appName = "MonthlyCalendar";
    int score = 0, scoreMax = 10, s1 = 0, s2 = 0, s3 = 2;

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.printf("%s テスト(1)開始\n", appName);
            app = new MonthlyCalendar();
            app.start(primaryStage);

            GridPane grid = app.grid;
            ObservableList<Node> children = grid.getChildren();
            int labelNo = 0;

            for (Node node : children) {
                // System.out.println(node);
                if (node instanceof Label) {
                    labelNo++;
                    Label label = (Label) node;
                    if (labelNo == 1) {
                        score += s3;
                        System.out.println("--- OK ラベル 正常");
                        if ("SUN".equalsIgnoreCase(label.getText())) {
                            score += s3;
                            System.out.println("--- OK SUN 正常");
                        } else {
                            System.out.println("--- NG " + label.getText() + " 異常");
                        }
                    } else if (labelNo == 7) {
                        if ("SAT".equalsIgnoreCase(label.getText())) {
                            score += s3;
                            System.out.println("--- OK SAT 正常");
                        } else {
                            System.out.println("--- NG " + label.getText() + " 異常");
                        }
                    }
                }
            }
            if (labelNo == 0) {
                System.out.println("--- NG ラベル なし");
            }

            ObservableList<ColumnConstraints> colCons = grid.getColumnConstraints();
            if (!colCons.isEmpty()) {
                score += s3;
                if (colCons.size() >= 7) {
                    score += s3;
                    System.out.println("--- OK 列幅設定 正常");
                } else {
                    System.out.println("--- NG 列幅設定 不足");
                }
            } else {
                System.out.println("--- NG 列幅設定 なし");
            }

            if (score == 10) {
                primaryStage.close();
            }
            System.out.printf("%s テスト(1)終了\n", appName);
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
