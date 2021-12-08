// Exercise 8-2T: Ticket Machine Tester
package ex08;

import javafx.application.Application;
import javafx.stage.Stage;

public class TicketMachineTester2 extends Application {

    TicketMachine app;
    String appName = "TicketMachine";
    int score = 0, scoreMax = 10, s1 = 0, s2 = 0, s3 = 1;

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.printf("%s テスト2開始\n", appName);
            app = new TicketMachine();
            app.start(primaryStage);

            if (app.bp.getCenter() != null) {
                score++;
                System.out.println("--- OK 初期状態 BorderPane 正常");
            } else {
                System.out.println("--- NG 初期状態 BorderPane 異常");
                printScore();
                return;
            }

            app.cbox.setValue(1);
            if (app.tf.getText() == null || app.tf.getText().isEmpty()) {
                score++;
                System.out.println("--- OK 枚数1選択 TextField 空");
            } else {
                System.out.println("--- NG 枚数1選択 TextField 異常:" + app.tf.getText());
                printScore();
                return;
            }

            app.tbtn[0].fire();
            if ("170".equals(app.tf.getText())) {
                score++;
                System.out.println("--- OK 料金170選択 TextField 170");
            } else {
                System.out.println("--- NG 料金170選択 TextField 異常:" + app.tf.getText());
                printScore();
                return;
            }

            app.tbtn[4].fire();
            if ("320".equals(app.tf.getText())) {
                score++;
                System.out.println("--- OK 料金320選択 TextField 320");
            } else {
                System.out.println("--- NG 料金320選択 TextField 異常:" + app.tf.getText());
                printScore();
                return;
            }

            app.cbox.setValue(4);
            if ("1280".equals(app.tf.getText())) {
                score++;
                System.out.println("--- OK 枚数4選択 TextField 1280");
            } else {
                System.out.println("--- NG 枚数4選択 TextField 異常:" + app.tf.getText());
                printScore();
                return;
            }

            app.tbtn[4].fire();
            if (app.tf.getText() == null || app.tf.getText().isEmpty()) {
                score++;
                System.out.println("--- OK 料金320解除 TextField 空");
            } else {
                System.out.println("--- NG 料金320解除 TextField 異常:" + app.tf.getText());
                printScore();
                return;
            }

            app.tbtn[3].fire();
            if ("1160".equals(app.tf.getText())) {
                score++;
                System.out.println("--- OK 料金290選択 TextField 1160");
            } else {
                System.out.println("--- NG 料金290選択 TextField 異常:" + app.tf.getText());
                printScore();
                return;
            }

            app.rbtn.fire();
            if (app.tf.getText() == null &&
                    app.cbox.getValue() == null && app.group.getSelectedToggle() == null) {
                score++;
                System.out.println("--- OK リセット 枚数・料金 解除");
            } else {
                System.out.println("--- NG リセット 枚数・料金 解除失敗");
                printScore();
                return;
            }

            app.tbtn[1].fire();
            if (app.tf.getText() == null) {
                score++;
                System.out.println("--- OK 料金200選択 TextField 空");
            } else {
                System.out.println("--- NG 料金200選択 TextField 異常:" + app.tf.getText());
                printScore();
                return;
            }

            app.cbox.setValue(2);
            if ("400".equals(app.tf.getText())) {
                score++;
                System.out.println("--- OK 枚数2選択 TextField 400");
            } else {
                System.out.println("--- NG 枚数2選択 TextField 異常:" + app.tf.getText());
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
