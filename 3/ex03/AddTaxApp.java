// Exercise 3-2: AddTax Application
package ex03;

import java.text.NumberFormat; //価格をカンマで区切るため、インポート
//https://java-reference.com/java_number_format.html
import java.util.function.LongUnaryOperator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddTaxApp extends Application {

    public static String gakuban = "19EC043"; // 学籍番号を入力すること
    public static String yourname = "蔡晟輝"; // 氏名を入力すること

    // 税込み価格を計算するラムダ式
    public static LongUnaryOperator addTax = zeinuki -> {
        // 課題3-1のコードを記述
    	long zeikomi = (long) (zeinuki * 1.1);
    	zeikomi = (long)(zeikomi - (zeikomi%10));
    	return zeikomi;
    };

    @Override
    public void start(Stage primaryStage) {
        // 課題3-2のコードを記述
    	Label label = new Label("税抜き価格");
		TextField TextField_1 = new TextField();
		Button button = new Button("税込み価格に変換する");
		TextField TextField_2 = new TextField();

        button.setOnAction((ActionEvent event) -> {
            String input = TextField_1.getText().trim();
            if (input.matches("-?\\d+")) {        //整数判定
            	long a = Long.parseLong(input);
            	long b = AddTaxApp.addTax.applyAsLong(a);
            	
            	NumberFormat nfNum = NumberFormat.getNumberInstance();
            	TextField_2.setText(nfNum.format(b));
            	
            }
            	
            else
            	TextField_2.setText("0");;
        });

        VBox pane = new VBox(label,TextField_1,button,TextField_2);
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AddTax");
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--AddTaxApp");
    }

}
