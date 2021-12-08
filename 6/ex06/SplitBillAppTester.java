// Exercise 6-2T: Split Bill Application Tester
package ex06;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SplitBillAppTester extends Application {

    SplitBillApp app;
    String appName = "SpriltBillApp";
    int score = 0, scoreMax = 20, s1 = 1, s2 = 1, s3 = 1;

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.printf("%s テスト開始\n", appName);
            app = new SplitBillApp();
            app.start(primaryStage);

            Scene scene = findScene(primaryStage);
            if (scene != null) {
                score += s1;
            } else {
                printScore();
                return;
            }

            VBox vbox = (VBox) findPane(scene, "VBox");
            if (vbox != null) {
                score += s2;
            } else {
                printScore();
                return;
            }

            System.out.print("--- 確認 tf4 ... ");
            if (!app.tf4.isEditable()) {
                System.out.println("成功");
                score += s2;
            } else {
                System.out.println("失敗");
                printScore();
                return;
            }

            System.out.print("--- 確認 tf5 ... ");
            if (!app.tf5.isEditable()) {
                System.out.println("成功");
                score += s2;
            } else {
                System.out.println("失敗");
                printScore();
                return;
            }

            String[][] tcs = {
                    { "0", "4000", "2", "2000", "0" }, { "200", "5000", "3", "1600", "0" },
                    { "0", "5550", "4", "1400", "50" }, { "400", "6000", "6", "1000", "400" },
                    { "", "8000", "5", "1600", "0" }, { "", "7980", "5", "1600", "20" },
                    { "", "10000", "11", "1000", "1000" }, { "100", "10000", "111", "100", "1200" },
                    { "", "0", "1", "0", "0" }, { "900", "0", "2", "0", "900" },
                    { "9", "1", "3", "0", "8" }, { "900", "900", "4", "0", "0" },
                    { "0", "-1000", "2", "E", "E" }, { "-500", "5000", "3", "E", "E" },
                    { "", "1", "0", "E", "E" }, { "", "5000", "abc", "E", "E" },
            };
            Boolean test;
            for (String[] tc : tcs) {
                test = actTest(tc[0], tc[1], tc[2], tc[3], tc[4]);
                if (test) {
                    score += s3;
                } else {
                    printScore();
                    return;
                }
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
                "\n【実行対象:%s, 学籍番号:%s, 学生氏名:%s, 評点:%d/%d】",
                appName, app.gakuban, app.yourname, score, scoreMax));
    }

    public Scene findScene(Stage stage) {
        System.out.print("--- 起動 Scene ... ");
        Scene scene = stage.getScene();
        if (scene != null) {
            System.out.println("成功");
            return scene;
        } else {
            System.out.println("失敗");
            return null;
        }
    }

    public Pane findPane(Scene scene, String type) {
        System.out.printf("--- 確認 %s ... ", type);
        Parent root = scene.getRoot();
        String nodeType = null;
        if (root != null) {
            nodeType = root.getClass().getSimpleName();
            if (type.equals(nodeType)) {
                System.out.println("成功");
                return (Pane) root;
            }
        }
        System.out.printf("失敗 原因 %s ?\n", nodeType);
        return null;
    }

    public boolean actTest(String s1, String s2, String s3, String s4, String s5) {
        System.out.printf("--- 入力 %s, %s, %s ... ", s1, s2, s3);
        app.tf1.setText(s1);
        app.tf2.setText(s2);
        app.tf3.setText(s3);
        app.btn.fire();
        if (!s4.equals("E")) {
            if (s4.equals(app.tf4.getText().trim()) &&
                    s5.equals(app.tf5.getText().trim())) {
                System.out.println("成功");
                return true;
            }
            System.out.printf("失敗 %s, %s ?\n", app.tf4.getText(), app.tf5.getText());
            return false;
        } else {
            if (app.alert != null) {
                System.out.println("成功");
                app.alert.close();
                return true;
            }
            System.out.printf("失敗 %s, %s ?\n", app.tf4.getText(), app.tf5.getText());
            return false;
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
