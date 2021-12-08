// Exercise 9-2T: Monthly Calendar Tester
package ex09;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MonthlyCalendarTester2 extends Application {

    MonthlyCalendar app;
    String appName = "MonthlyCalendar";
    int score = 0, scoreMax = 10, s1 = 0, s2 = 0, s3 = 1;

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.printf("%s テスト(2)開始\n", appName);
            app = new MonthlyCalendar();
            app.start(primaryStage);

            ComboBox<Integer> year = app.year;
            ComboBox<Integer> month = app.month;
            Button submit = app.submit;
            GridPane grid = app.grid;

            int[][] test1 = { { 2020, 3, 0 }, { 2022, 7, 5 }, { 2014, 2, 6 }, { 2016, 2, 1 } };

            for (int[] test : test1) {
                year.setValue(test[0]);
                month.setValue(test[1]);
                submit.fire();

                ObservableList<Node> children = grid.getChildren();
                int startRow = 0, row;
                int startCol = 0, col;

                for (Node node : children) {
                    // System.out.println(node);
                    if (node instanceof Label) {
                        Label label = (Label) node;
                        if ("1".equals(label.getText().trim())) {
                            startRow = GridPane.getRowIndex(node);
                            startCol = GridPane.getColumnIndex(node);
                            if (startCol == test[2]) {
                                score += s3;
                                System.out.printf("--- OK %d/%d/1 正常\n", test[0], test[1]);
                            } else {
                                System.out.printf("--- NG %d/%d/1 異常\n", test[0], test[1]);
                            }
                        }
                        if ("15".equals(label.getText().trim())) {
                            row = GridPane.getRowIndex(node);
                            col = GridPane.getColumnIndex(node);
                            if (row == startRow + 2 && col == startCol) {
                                score += s3;
                                System.out.printf("--- OK %d/%d/15 正常\n", test[0], test[1]);
                            } else {
                                System.out.printf("--- NG %d/%d/15 異常\n", test[0], test[1]);
                            }
                        }
                        if (test[1] != 2 && "31".equals(label.getText().trim())) {
                            row = GridPane.getRowIndex(node);
                            col = GridPane.getColumnIndex(node);
                            if (row == startRow + 4 + (startCol + 2) / 7 && col == (startCol + 2) % 7) {
                                score += s3;
                                System.out.printf("--- OK %d/%d/31 正常\n", test[0], test[1]);
                            } else {
                                System.out.printf("--- NG %d/%d/31 異常\n", test[0], test[1]);
                            }
                        }
                        if (test[1] == 2 && "30".equals(label.getText().trim())) {
                            if (label.isVisible() && !label.isDisable()) {
                                score -= s3;
                                System.out.printf("--- NG %d/%d/30 異常\n", test[0], test[1]);
                            }
                        }
                    }
                }
            }

            if (score == 10) {
                primaryStage.close();
            } else {
                System.out.println("--- NG 表示内容不足 異常");
            }
            System.out.printf("%s テスト(2)終了\n", appName);
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
