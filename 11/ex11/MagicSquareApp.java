// レポート第2回: Magic Square Application

package ex11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MagicSquareApp extends Application {

	public static String gakuban = "19EC043"; // 学籍番号を入力すること
	public static String yourname = "蔡晟輝"; // 氏名を入力すること

	// 問題の定義
	String[] tasks = {
			"81635-492", "-7215-8-4", "-3-9-1-7-", "2------1-",
	};

	@Override
	public void start(Stage primaryStage) {
		// プログラムを作成
		Label lbl = new Label("問題選択");
		ComboBox<String> cbox = new ComboBox<>();
		cbox.getItems().addAll(tasks);

		//魔法陣のボタン宣言及び見た目
		Button[] btn = new Button[9];
		for (int i = 0; i < 9; i++) {
			btn[i] = new Button("");
			btn[i].setPrefHeight(40);
			btn[i].setPrefWidth(40);
			btn[i].setFont( new Font(20));
		}

		//cboxが選択されたら
		cbox.setOnAction(e -> {
			for (int i = 0; i < 9; i++) {
				btn[i].setTextFill(Color.BLACK);
				String k = cbox.getValue().substring(i,i+1);
				if (k.equals("-")) {
					btn[i].setText("");
					btn[i].setTextFill(Color.BLUE);
				}
				else if(k.matches("[0-9]")) {
					btn[i].setText(k);
				}
			}
			for (int i = 0; i < 9; i++) {
				//変更可能なボタンを見つけ、ボタンに動作を与える
				if("".equals(btn[i].getText())) {
					int r = i;
					btn[i].setOnAction(a -> {
						int t = r;
						if("".equals(btn[t].getText())) {
							btn[t].setText("0");
						}else {
							int w = seisu(btn[t].getText());
							w++;
							if (w == 10) w = 0;
							btn[t].setText(moji(w));
						}
					});
				}
			}
		});

		//checkボタン
		Button btn_c = new Button("Check");
		btn_c.setOnAction(e -> {
			int j = 0, k = 0;
			int[] a = new int[9];
			int[] b = new int[8];
			//9個ボタンが全部数字が入っていればKは不変
			for (int i = 0; i < 9; i++) {
				if ("".equals(btn[i].getText())) k++;
			}
			if (k == 0) {
				for (int i = 0; i < 9; i++) {
					a[i] = seisu(btn[i].getText());
				}
				b[0] = a[0] + a[1] + a[2];
				b[1] = a[3] + a[4] + a[5];
				b[2] = a[6] + a[7] + a[8];
				b[3] = a[0] + a[3] + a[6];
				b[4] = a[1] + a[4] + a[7];
				b[5] = a[2] + a[5] + a[8];
				b[6] = a[0] + a[4] + a[8];
				b[7] = a[2] + a[4] + a[6];
				//和が全部同じならjは7になる。
				for (int i = 1; i < 8; i++) {
					if (b[0]==b[i]) j++;
				}
				if (j == 7) inform();
				else error();
			}
			else if (k>0) error();
		});

		//resetボタン
		Button btn_r = new Button("Reset");
		btn_r.setOnAction(e -> {
			for (int i = 0; i < 9; i++) {
				btn[i].setTextFill(Color.BLACK);
				String k = cbox.getValue().substring(i,i+1);
				if (k.equals("-")) {
					btn[i].setText("");
					btn[i].setTextFill(Color.BLUE);
				}
				else if(k.matches("[0-9]")) {
					btn[i].setText(k);
				}
			}
		});

		//レイアウト
		HBox hbox1 = new HBox(20, lbl, cbox );
		HBox hbox2 = new HBox(15, btn[0], btn[1], btn[2] );
		HBox hbox3 = new HBox(15, btn[3], btn[4], btn[5] );
		HBox hbox4 = new HBox(15, btn[6], btn[7], btn[8] );
		VBox vbox1 = new VBox(20, btn_c, btn_r);
		VBox vbox2 = new VBox(10, hbox2, hbox3, hbox4);
		hbox1.setPadding(new Insets(10));
		vbox1.setPadding(new Insets(15));
		vbox2.setPadding(new Insets(20));
		primaryStage.setResizable(false);
		//borderpane
		BorderPane bp = new BorderPane();
		bp.setTop(hbox1);
		bp.setCenter(vbox2);
		bp.setRight(vbox1);

		primaryStage.setScene(new Scene(bp, 280, 250));
		primaryStage.setTitle("3×3魔法陣");
		primaryStage.show();
	}
	//アラート
	void inform() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION,
				"正解です。");
		alert.showAndWait();
	}
	void error() {
		Alert alert = new Alert(Alert.AlertType.ERROR,
				"間違いです。");
		alert.showAndWait();
	}
	//文字列を数値に変換するメソッド
	public static int seisu(String s){
		return Integer.parseInt(s);
	}
	//数値を文字列に変換するメソッド
	public static String moji(int n){
		return String.valueOf(n);
	}

	public static void main(String[] args) {
		// アプリケーションを起動する
		Application.launch(args);
		System.out.println("完了--MagicSquareApp");
	}
}

/* 考察 -- 調査したこと、考慮したこと、工夫したことを記述
調査したこととして、comboboxの使い方やアラートの使い方及び数値⇔文字列の変換です。
考慮したことは、この条件でしっかりプログラムが動くか、if文、for文の構成はあっているか、また再利用できるように、
新しい問題を追加するとすぐ表示できるかです。また同じような操作でメソッド作るか、見た目は簡潔であるかです。
以上をふまえて、工夫したことは、ボタン宣言など複数同じような操作はfor文でまとめ、またコメントも付け、見やすくした。
また問題の文字列を読みとり、一つ一つ判定して、問題を示しているので、新しい問題を追加しやすいのと、
数値⇔文字列の変換はコードが長くめんどくさいのでメソッドを作って利用することと、フォントや文字のサイズを大きくし、
自分が入力した数字は色が青にするのが工夫したところです。



 */
