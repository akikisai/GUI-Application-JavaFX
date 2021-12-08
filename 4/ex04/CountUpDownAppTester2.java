// Exercise 4-2T: CountUpDown Application Tester Part2
package ex04;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CountUpDownAppTester2 extends Application {

    CountUpDownApp app;
    String appName = "CountUpDownApp";
    int score = 0, scoreMax = 20, s1 = 1, s2 = 1, s3 = 1;

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.printf("%s 後半テスト開始\n", appName);
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

            System.out.printf("--- 確認 counter == 2 ... ");
            tf1.setText("2");
            bt1.fire();
            if (app.counter == 2) {
                System.out.println("成功");
                score += s3;
            } else {
                System.out.printf("失敗 原因 %s ?\n", app.counter);
                printScore();
                return;
            }

            Scene scene2 = findScene(primaryStage);
            if (scene != null) {
                score += s1;
            } else {
                printScore();
                return;
            }

            VBox pane2 = (VBox) findPane(scene2, "VBox");
            if (pane2 != null) {
                score += s2;
            } else {
                printScore();
                return;
            }

            Button bt21 = (Button) findNode(pane2, "Button", 0);
            if (bt21 != null) {
                score += s2;
            }
            Label lb2 = (Label) findNode(pane2, "Label", 1);
            if (lb2 != null) {
                score += s2;
            }
            Button bt22 = (Button) findNode(pane2, "Button", 2);
            if (bt22 != null) {
                score += s2;
            }
            if (bt21 == null || lb2 == null || bt22 == null) {
                printScore();
                return;
            }
            String bt22Text = bt22.getText();

            System.out.printf("--- 確認 counter == 2 ... ");
            if ("2".equals(lb2.getText())) {
                System.out.println("成功");
                score += s3;
            } else {
                System.out.printf("失敗 原因 %s ?\n", app.counter);
                printScore();
                return;
            }

            String[][] tcs1 = {{"Up", "3"}, {"Up", "4"},};
            for (String tc[]: tcs1) {
                if (actTest(bt21, lb2, tc[0], tc[1])) {
                    score += s3;
                } else {
                    printScore();
                return;
                }
            }

            String[][] tcs2 = {
                {"Down", "3"}, {"Down", "2"}, {"Down", "1"}, {"Down", "0"},};
            for (String tc[]: tcs2) {
                if (actTest(bt22, lb2, tc[0], tc[1])) {
                    score += s3;
                } else {
                    printScore();
                return;
                }
            }

            System.out.printf("--- 確認 ボタン切替 ... ");
            if (!bt22Text.equals(bt22.getText())) {
                System.out.println("成功");
                score += s2;
            } else {
                System.out.println("失敗");
                printScore();
                return;
            }

            System.out.printf("--- 確認 シーン切替 ... ");
            bt22.fire();
            if (scene == primaryStage.getScene()) {
                System.out.println("成功");
                score += s2;
            } else {
                System.out.println("失敗");
                printScore();
                return;
            }

            primaryStage.close();
            System.out.printf("%s 後半テスト終了\n", appName);
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

    public static boolean actTest(Button bt, Label lb, String in, String out) {
        System.out.printf("--- クリック \"%s\" ... ", in);
        bt.fire();
        String res = lb.getText();
        if (res.equals(out)) {
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
