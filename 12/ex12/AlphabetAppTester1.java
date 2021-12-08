// Exercise 12T-1: AlphabetApp Tester1
package ex12;

import javafx.application.Application;
import javafx.stage.Stage;

public class AlphabetAppTester1 extends Application {

	AlphabetApp app;
	String appName = "AlphabetApp";
	int score = 0, scoreMax = 10, s1 = 1, s2 = 1, s3 = 1;
	String[] kw = { "radius", "bold", "serif", "gold" };

	@Override
	public void start(Stage primaryStage) {
		try {
			System.out.printf("%s 前半テスト開始\n", appName);
			app = new AlphabetApp();
			app.start(primaryStage);
			app.startGame();
			String style = app.buttons[0].getStyle();
			System.out.print("--- 確認 Button ... ");
			if (style != null && !style.isEmpty()) {
				System.out.println("成功");
				score += s1 * 2;
				for (String k : kw) {
					System.out.printf("--- 確認 %s ... ", k);
					if (style.contains(k)) {
						System.out.println("成功");
						score += s1 * 2;
					} else
						System.out.println("失敗");
				}
			} else
				System.out.println("失敗");
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
				appName, app.gakuban, app.yourname, score));
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
