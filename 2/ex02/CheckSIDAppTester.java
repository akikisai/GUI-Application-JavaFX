// Exercise 2-2T: CheckSID Application Tester
package ex02;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckSIDAppTester extends Application {

    CheckSIDApp app;
    String appName = "CheckSIDApp";
    int score = 0, scoreMax = 10, s1 = 1, s2 = 1, s3 = 1;

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.printf("%s テスト開始\n", appName);
            app = new CheckSIDApp();
            app.start(primaryStage);

            Scene scene = findScene(primaryStage);
            if (scene != null) {
                score += s1;
            } else {
                printScore();
                return;
            }

            VBox pane = (VBox) findPane(scene, "VBox");
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
            Label lb2 = (Label) findNode(pane, "Label", 3);
            if (lb2 != null) {
                score += s2;
            }
            if (tf1 == null || bt1 == null || lb2 == null) {
                printScore();
                return;
            }

            String[][] tcs = {
                    { "19EC34", "NG" }, { "19EC456", "OK" }, { "19EC5678", "NG" }, { "", "NG" }, };
            Boolean test = true;
            for (String[] tc : tcs) {
                test = actTest(tf1, bt1, lb2, tc[0], tc[1]);
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

    public static boolean actTest(TextField tf, Button bt, Label lb,
            String in, String out) {
        System.out.printf("--- 入力 \"%s\" ... ", in);
        tf.setText(in);
        bt.fire();
        String res = lb.getText();
        if (res.contains(out)) {
            System.out.println("成功");
            return true;
        }
        System.out.printf("失敗 出力 %s ?\n", res);
        return false;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
