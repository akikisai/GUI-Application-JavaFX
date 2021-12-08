// Exercise 6: Split Bill Application
package ex06;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SplitBillApp extends Application {

	public static String gakuban = "19EC043"; // 学籍番号を入力すること
	public static String yourname = "蔡晟輝"; // 氏名を入力すること

	Label lb1, lb2, lb3, lb4, lb5;
	TextField tf1, tf2, tf3, tf4, tf5;
	Button btn;
	VBox vb;
	Alert alert;

	@Override
	public void start(Stage primaryStage) {
		// 入力領域
		lb1 = new Label("前回からの繰越額");
		lb1.setPrefWidth(100);
		lb1.setAlignment(Pos.BASELINE_RIGHT);
		tf1 = new TextField("");
		lb2 = new Label("全体の支払い額");
		lb2.setPrefWidth(100);
		lb2.setAlignment(Pos.BASELINE_RIGHT);
		tf2 = new TextField("0");
		lb3 = new Label("人数");
		lb3.setPrefWidth(100);
		lb3.setAlignment(Pos.BASELINE_RIGHT);
		tf3 = new TextField("1");

		// ボタン領域
		btn = new Button("計算");
		btn.setOnAction(ae -> btnClicked()); // 課題6-2でこのメソッドを実装
		btn.setPrefWidth(150);

		// 出力領域
		lb4 = new Label("各人の支払い額");
		lb4.setPrefWidth(100);
		lb4.setAlignment(Pos.BASELINE_RIGHT);
		tf4 = new TextField();
		lb5 = new Label("次回への繰越額");
		lb5.setPrefWidth(100);
		lb5.setAlignment(Pos.BASELINE_RIGHT);
		tf5 = new TextField();

		// レイアウト
		makeLayout(); // 課題6-1でこのメソッドを実装

		// レイアウト表示
		Scene scene = new Scene(vb);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Split Bill Application");
		primaryStage.show();
	}

	// レイアウトの作成
	public void makeLayout() {
		// 課題6-1のコードを記述
		HBox hb1 = new HBox(10, lb1, tf1);
		HBox hb2 = new HBox(10, lb2, tf2);
		HBox hb3 = new HBox(10, lb3, tf3);
		HBox hb_btn = new HBox(10, btn);
		HBox hb4 = new HBox(10, lb4, tf4);
		HBox hb5 = new HBox(10, lb5, tf5);
		hb_btn.setAlignment(Pos.CENTER);

		vb = new VBox(); // 不要ならばこの行を削除
		vb = new VBox(20, hb1, hb2, hb3, hb_btn, hb4, hb5);
		vb.setPadding(new Insets(20));

		tf4.setEditable(false);
		tf5.setEditable(false);
	}

	// 計算ボタンのアクション
	public void btnClicked() {
		// 課題6-2のコードを記述
		alert = new Alert(Alert.AlertType.ERROR,"正確な値を入力してください。");
		
		int before = 0, total = 0, n = 0, each = 0, after = 0;
		String before_s, total_s, n_s, each_s, after_s;

		before_s = tf1.getText();
		total_s = tf2.getText();
		n_s = tf3.getText();

		if(
				(!before_s.matches("^([1-9][0-9]*|0)$") && before_s.length() != 0) ||
				(!total_s.matches("^([1-9][0-9]*|0)$")) ||
				(!n_s.matches("^([1-9][0-9]*)$"))
				) {
			alert.showAndWait();
			tf4.setText("E");
			tf5.setText("E");

		}else {

			if(before_s.matches("^([1-9][0-9]*)$")){
				before = Integer.parseInt(before_s);
				total = Integer.parseInt(total_s);
				n = Integer.parseInt(n_s);

				int i=0, t=total-before;


				if(t%(n*100)==0) {
					each = t / n;
					after = 0;

				}
				else if(t%(n*100)!=0) {
					while(t>0) {
						t -= n*100;
						i++;
					}
					each = i*100;
					after = each * n - (total-before);
				}
			}else if(before_s.length() == 0 || Integer.parseInt(before_s)==0) {

				total = Integer.parseInt(total_s);
				n = Integer.parseInt(n_s);
				int i = 0,t = total;


				while(t>0) {
					t -= n*100;
					i++;
				}
				each = i*100;
				after = each * n - total;

			}
		}
		each_s = Integer.valueOf(each).toString();
		after_s = Integer.valueOf(after).toString();

		tf4.setText(each_s);
		tf5.setText(after_s);	
	}

	public static void main(String[] args) {
		// アプリケーションを起動する
		Application.launch(args);
		System.out.println("完了--SplitBillApp");
	}

}
