// Exercise 8-2T: Ticket Machine Tester
package ex08;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.stage.Stage;

public class TicketMachineTester1 extends Application {

    TicketMachine app;
    String appName = "TicketMachine";
    int score = 0, scoreMax = 10, s1 = 0, s2 = 0, s3 = 2;

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.printf("%s テスト1開始\n", appName);
            app = new TicketMachine();
            app.start(primaryStage);

            if (contains(app.bp.getTop(), app.lblTop)) {
                score += s3;
                System.out.println("--- OK 初期状態 Top 正常");
            } else {
                System.out.println("--- NG 初期状態 Top 異常");
                printScore();
                return;
            }

            if (contains(app.bp.getLeft(), app.lblLeft) &&
                    contains(app.bp.getLeft(), app.cbox)) {
                score += s3;
                System.out.println("--- OK 初期状態 Left 正常");
            } else {
                System.out.println("--- NG 初期状態 Left 異常");
                printScore();
                return;
            }

            if (contains(app.bp.getCenter(), app.tbtn[0]) &&
                    contains(app.bp.getCenter(), app.tbtn[4])) {
                score += s3;
                System.out.println("--- OK 初期状態 Center 正常");
            } else {
                System.out.println("--- NG 初期状態 Center 異常");
                printScore();
                return;
            }

            if (app.bp.getRight() == null) {
                score += s3;
                System.out.println("--- OK 初期状態 Right 正常");
            } else {
                System.out.println("--- NG 初期状態 Right 異常");
                printScore();
                return;
            }

            if (contains(app.bp.getBottom(), app.tf) &&
                    contains(app.bp.getBottom(), app.rbtn)) {
                score += s3;
                System.out.println("--- OK 初期状態 Bottom 正常");
            } else {
                System.out.println("--- NG 初期状態 Bottom 異常");
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

    boolean contains(Node parent, Node child) {
        if (parent == null || child == null)
            return false;
        Node node = child.getParent();
        while (node != null) {
            if (parent == node)
                return true;
            node = node.getParent();
        }
        return false;
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
