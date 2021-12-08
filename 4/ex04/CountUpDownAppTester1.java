// Exercise 4-1T: CountUpDown Application Tester Part1
package ex04;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CountUpDownAppTester1 extends Application {

    CountUpDownApp app;
    String appName = "CountUpDownApp";
    int score = 0, scoreMax = 10, s1 = 1, s2 = 1, s3 = 1;

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.printf("%s 前半テスト開始\n", appName);
            app = new CountUpDownApp();
            app.start(primaryStage);

            Scene scene = findScene(primaryStage);
            if (scene != null) {
                score += s1;
            } else {
                printScore();
                return;
            }

            HBox pane = (HBox) findPane(scene, "HBox");
            if (pane != null) {
                score += s2;
            } else {
                printScore();
                return;
            }

            Label lb1 = (Label) findNode(pane, "Label", 0);
            if (lb1 != null) {
                score += s2;
            }
            TextField tf1 = (TextField) findNode(pane, "TextField", 1);
            if (tf1 != null) {
                score += s2;
            }
            Button bt1 = (Button) findNode(pane, "Button", 2);
            if (bt1 != null) {
                score += s2;
            }
            if (lb1 == null || tf1 == null || bt1 == null) {
                printScore();
                return;
            }

            String[][] tcs = {
                {"0", "ERROR"}, {"-1", "ERROR"}, {"ABC", "ERROR"}, {"", "ERROR"},};
            Boolean test = true;
            for (String[] tc : tcs) {
                tf1.setText(tc[0]);
                bt1.fire();
                if (app.alert != null) {
                    if (checkAlertType(app.alert, tc[1])) {
                        score += s3;
                        app.alert.close();
                        continue;
                    }
                }
                printScore();
                return;
            }

            System.out.printf("--- 確認 counter == 10 ... ");
            tf1.setText("10");
            bt1.fire();
            if (app.counter == 10) {
                System.out.println("成功");
                score += s3;
            } else {
                System.out.printf("失敗 原因 %s ?\n", app.counter);
                printScore();
                return;
            }

            primaryStage.close();
            System.out.printf("%s 前半テスト終了\n", appName);
            printScore();
        } catch (Exception e) {
            printScore();
            e.printStackTrace();
        }
    }

    void printScore() {
        System.out.println(String.format(
                "\n【実行対象:%s, 学籍番号:%s, 学生氏名:%s, 評点:%d】",
                appName, app.gakuban, app.yourname, 10 * score / scoreMax));
    }

    public static Scene findScene(Stage stage) {
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

    public static Pane findPane(Scene scene, String type) {
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

    public static Node findNode(Pane pane, String type, int n) {
        System.out.printf("--- 確認 %s ... ", type);
        ObservableList<Node> ol = pane.getChildren();
        Node node;
        String nodeType = null;
        if (ol != null && n < ol.size()) {
            node = ol.get(n);
            nodeType = node.getClass().getSimpleName();
            if (type.equals(nodeType)) {
                System.out.println("成功");
                return node;
            }
        }
        System.out.printf("失敗 原因 %s ?\n", nodeType);
        return null;
    }

    public static boolean checkAlertType(Alert alert, String out) {
        System.out.printf("--- 確認 AlertType.%s ... ", out);
        String result = alert.getAlertType().toString();
        if (result.contains(out)) {
            System.out.println("成功");
            return true;
        }
        System.out.printf("失敗 原因 %s ?\n", result);
        return false;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
