// Exercise 7-2T: Lunch Order Application Tester2
package ex07;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LunchCalcAppTesterLite extends Application {

    LunchCalcApp app;
    String appName = "LunchCalcApp";
    int score = 0, scoreMax = 20, s1 = 0, s2 = 2, s3 = 2;

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.printf("%s テスト開始\n", appName);
            System.out.print("--- 起動 ... ");
            app = new LunchCalcApp();
            app.start(primaryStage);
            System.out.println("成功");
            score += 2;
            
            System.out.print("--- 初期 選択状態 ... ");
            if (app.rbLunchA.isSelected() && !app.rbLunchB.isSelected()) {
                System.out.println("成功");
                score += s2 * 2;
            } else {
                System.out.println("失敗");
                printScore();
                return;
            }
            System.out.print("--- 初期 ライス選択状態 ... ");
            if (app.rbSizeM.isSelected() && !app.rbSizeL.isSelected()) {
                System.out.println("成功");
                score += s2 * 2;
            } else {
                System.out.println("失敗");
                printScore();
                return;
            }

            int[][] testCases = {
                {1, 0, 0, 1, 0, 0, 0, 0, 450},
                {1, 0, 0, 0, 1, 0, 0, 1, 560},
                {0, 1, 0, 1, 0, 0, 0, 0, 420},
                {0, 0, 1, 0, 0, 1, 1, 1, 610},
                {1, 0, 0, 0, 0, 1, 1, 1, 670},
            };

            for (int[] tc : testCases) {
                String setting = "";

                if (tc[0] == 1) {
                    app.rbLunchA.setSelected(true);
                    setting = getItem(app.rbLunchA.getText());
                } else if (tc[1] == 1) {
                    app.rbLunchB.setSelected(true);
                    setting = getItem(app.rbLunchB.getText());
                } else {
                    app.rbLunchC.setSelected(true);
                    setting = getItem(app.rbLunchC.getText());
                }

                if (tc[3] == 1) {
                    app.rbSizeS.setSelected(true);
                    setting += getItem(app.rbSizeS.getText());
                } else if (tc[4] == 1) {
                    app.rbSizeM.setSelected(true);
                    setting += getItem(app.rbSizeM.getText());
                } else {
                    app.rbSizeL.setSelected(true);
                    setting += getItem(app.rbSizeL.getText());
                }

                if (tc[6] == 1) {
                    app.cbOptYogurt.setSelected(true);
                    setting += getItem(app.cbOptYogurt.getText());
                } else {
                    app.cbOptYogurt.setSelected(false);
                }

                if (tc[7] == 1) {
                    app.cbOptFruit.setSelected(true);
                    setting += getItem(app.cbOptFruit.getText());
                } else {
                    app.cbOptFruit.setSelected(false);
                }

                if (actTest(app.btnCalc, app.tfCalc, setting,
                        Integer.toString(tc[8]))) {
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

    public String getItem(String menu) {
        int n = menu.indexOf("(");
        if (n > 0) {
            return menu.substring(0, n);
        }
        return "";
    }

    public static boolean actTest(RadioButton rb, boolean b) {
        System.out.printf("--- 確認 \"%s\" ... ", rb.getText());
        boolean res = rb.isSelected();
        if (res == b) {
            System.out.println("成功");
            return true;
        }
        System.out.printf("失敗 出力 %s ?\n", res);
        return false;
    }

    void printScore() {
        System.out.println(String.format(
                "\n【実行対象:%s, 学籍番号:%s, 学生氏名:%s, 評点:%d】",
                appName, app.gakuban, app.yourname, score));
    }

    public static boolean actTest(Button bt, TextField tf,
            String in, String out) {
        System.out.printf("--- 入力 \"%s\" ... ", in);
        bt.fire();
        String res = tf.getText();
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
