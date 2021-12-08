// Exercise 10T: LocalDate App Tester1
package ex10;

import java.time.LocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class LocalDateAppTester extends Application {

    LocalDateApp app;
    String appName = "LocalDateApp";
    int score = 0, scoreMax = 30, s1 = 2, s2 = 1, s3 = 1;

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.printf("%s テスト開始\n", appName);
            app = new LocalDateApp();
            app.start(primaryStage);

            Scene scene = findScene(primaryStage);
            if (scene != null) {
                score += s1;
            } else {
                printScore();
                return;
            }

            String[] expect1 = { "ファイル", "過去", "未来" };
            String[][] expect2 = {
                    { "今日", "終了" }, { "前年", "前月", "前日" }, { "翌年", "翌月", "翌日" } };
            String[] expect3 = { "西暦", "和暦" };
            MenuItem[][] item = new MenuItem[3][3];
            MenuItem[] item3 = new MenuItem[2];

            ObservableList<Menu> menuList = app.menuBar.getMenus();
            for (int i = 0; i < expect1.length && i < menuList.size(); i++) {
                System.out.printf("--- 確認 %s ... ", expect1[i]);
                String text1 = menuList.get(i).getText();
                if (text1.contains(expect1[i])) {
                    System.out.println("成功");
                    score += s2;
                    ObservableList<MenuItem> itemList = menuList.get(i).getItems();
                    for (int j = 0; j < expect2[i].length && j < itemList.size(); j++) {
                        System.out.printf("--- 確認 %s ... ", expect2[i][j]);
                        item[i][j] = itemList.get(j);
                        String text2 = item[i][j].getText();
                        if (text2.contains(expect2[i][j])) {
                            System.out.println("成功");
                            score += s2;
                        } else {
                            System.out.printf("失敗 原因 %s ?\n", text2);
                        }
                    }
                } else {
                    System.out.printf("失敗 原因 %s ?\n", text1);
                }
            }

            System.out.printf("--- 確認 %s ... ", "コンテキスト");
            if (app.label.getContextMenu() == app.menuContext) {
                System.out.println("成功");
                score += s2;
            } else {
                System.out.printf("失敗 原因 %s ?\n", app.label.getContextMenu());
            }

            ObservableList<MenuItem> contextList = app.menuContext.getItems();
            for (int j = 0; j < expect3.length && j < contextList.size(); j++) {
                System.out.printf("--- 確認 %s ... ", expect3[j]);
                item3[j] = contextList.get(j);
                String text3 = item3[j].getText();
                if (text3.contains(expect3[j])) {
                    System.out.println("成功");
                    score += s2;
                } else {
                    System.out.printf("失敗 原因 %s ?\n", text3);
                }
            }

            LocalDate today = LocalDate.now();
            if (validateLabel("初期状態", app.label, dateToString(today))) {
                score += s1;
            } else {
                printScore();
                return;
            }

            if (item[2][2] != null) {
                LocalDate[][] ld = { {},
                        { today.minusYears(1), today.minusYears(1).minusMonths(1),
                                today.minusYears(1).minusMonths(1).minusDays(1) },
                        { today.minusMonths(1).minusDays(1), today.minusDays(1), today } };
                for (int i = 1; i < 3; i++) {
                    for (int j = 0; j < ld[i].length; j++) {
                        item[i][j].fire();
                        if (validateLabel(expect2[i][j], app.label, dateToString(ld[i][j]))) {
                            score += s3;
                        }
                    }
                }

                item[2][2].fire();
                if (validateLabel(expect2[2][2], app.label, dateToString(today.plusDays(1)))) {
                    score += s3;
                }

                item[0][0].fire();
                if (validateLabel(expect2[0][0], app.label, dateToString(today))) {
                    score += s3;
                }
            } else {
                System.out.println("--- メニューの確認不能");
            }

            if (item3[1] != null) {
                item3[1].fire();
                if (validateLabel(expect3[1], app.label, dateToWarekiString(today))) {
                    score += s3;
                }

                item3[0].fire();
                if (validateLabel(expect3[0], app.label, dateToString(today))) {
                    score += s3;
                }

                System.out.printf("--- 動作 %s ... ", expect2[0][1]);
                item[0][1].fire();
                if (!primaryStage.isShowing()) {
                    System.out.println("成功");
                    score += s1;
                } else {
                    System.out.println("失敗");
                    return;
                }
            } else {
                System.out.println("--- コンテキストメニューの確認不能");
            }
            primaryStage.close();
            System.out.printf("%s テスト終了\n", appName);
            printScore();
        } catch (Exception e) {
            printScore();
            e.printStackTrace();
        }
    }

    String dateToString(LocalDate date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("Gy年M月d日(E)");
        return df.format(date);
    }

    String dateToWarekiString(LocalDate date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("Gy年M月d日(E)").withChronology(JapaneseChronology.INSTANCE);
        return df.format(date);
    }

    void printScore() {
        System.out.println(String.format(
                "\n【実行対象:%s, 学籍番号:%s, 学生氏名:%s, 評点:%d】",
                appName, app.gakuban, app.yourname, score * 20 / scoreMax));
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

    public static boolean validateLabel(String action, Label lbl, String str) {
        System.out.printf("--- 動作 %s ... ", action);
        String text = lbl.getText();
        if (text.equals(str)) {
            System.out.println("成功");
            return true;
        } else {
            System.out.printf("失敗 原因 %s ?\n", text);
            return false;
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
