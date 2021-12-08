// Exercise 2: CheckSID Application
package ex02;

import javafx.application.Application;
//必要な import文 を記述
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckSIDApp extends Application {

    public static String gakuban = "19EC043"; // 学籍番号を入力すること
    public static String yourname = "蔡晟輝"; // 氏名を入力すること

    // 学籍番号が正しい形式かどうかを判定するメソッド
    public static boolean checkSID(String sid) {
        // 課題2-1のコードを記述
    	return sid.matches("(1[4-9]|2[0-1])[Ee][Cc](\\d{3})");
    }

    @Override
    public void start(Stage primaryStage) {
        // 課題2-2のコードを記述
    	Label label_1 = new Label("学籍番号");
		TextField textField0 = new TextField();
		Button button = new Button("確認");
		Label label_2 = new Label ("");

        button.setOnAction((ActionEvent event) -> {
            String gakuban = textField0.getText().trim();
            if (checkSID(gakuban))
            	label_2.setText("OK") ;
            else
            	label_2.setText("NG");
        });

        VBox pane = new VBox(label_1,textField0,button,label_2);
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CheckSIDApp");
        primaryStage.show();
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--CheckSIDApp");
    }
}
