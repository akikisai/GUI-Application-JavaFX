// Exercise 12T-2: AlphabetApp Tester2
package ex12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AlphabetAppTester2 extends Application {

	AlphabetApp app;
	String appName = "AlphabetApp";
	int score = 0, scoreMax = 10, s1 = 1, s2 = 1, s3 = 1;

	@Override
	public void start(Stage primaryStage) {
		try {
			System.out.printf("%s 後半テスト開始\n", appName);
			app = new AlphabetApp();
			app.start(primaryStage);

			Scene scene = findScene(primaryStage);
			if (scene != null) {
				score += s1;
			} else {
				printScore();
				return;
			}

			app.startGame();

			for (int i = 1; i < 3; i++) {
				String next = app.alphabets.get(0);
				for (Button btn : app.buttons) {
					if (!btn.isDisable() && btn.getText() != null
							&& btn.getText() == next) {
						System.out.printf("--- クリック %s ... ", next);
						btn.fire();
						if (btn.isDisable()) {
							System.out.println("成功");
							score += s3;
						} else {
							System.out.printf("失敗\n");
							printScore();
							return;
						}

						System.out.printf("--- 確認 ArrayList ... ");
						if (app.alphabets.size() == 16 - i) {
							System.out.println("成功");
							score += s3;
						} else {
							System.out.printf("失敗\n");
							printScore();
							return;
						}

						System.out.printf("--- 確認 残り個数 ... ");
						if (Integer.toString(16 - i).equals(app.labelRemain.getText())) {
							System.out.println("成功");
							score += s3;
						} else {
							System.out.printf("失敗\n");
							printScore();
							return;
						}
						break;
					}
				}
			}

			for (int i = 1; i < 2; i++) {
				String next = app.alphabets.get(0);
				for (Button btn : app.buttons) {
					if (!btn.isDisable() && btn.getText() != null
							&& btn.getText() != next) {
						System.out.printf("--- クリック %s ... ", btn.getText());
						btn.fire();
						if (!btn.isDisable()) {
							System.out.println("成功");
							score += s3;
						} else {
							System.out.printf("失敗\n");
							printScore();
							return;
						}

						System.out.printf("--- 確認 ArrayList ... ");
						if (app.alphabets.size() == 14) {
							System.out.println("成功");
							score += s3;
						} else {
							System.out.printf("失敗\n");
							printScore();
							return;
						}

						System.out.printf("--- 確認 お手付き ... ");
						if (Integer.toString(i).equals(app.labelMistake.getText())) {
							System.out.println("成功");
							score += s3;
						} else {
							System.out.printf("失敗\n");
							printScore();
							return;
						}
						break;
					}
				}
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
				appName, app.gakuban, app.yourname, score));
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

	public static void main(String[] args) {
		Application.launch(args);
	}

}
