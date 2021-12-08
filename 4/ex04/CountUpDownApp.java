// Exercise 4: Count Down Application
package ex04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CountUpDownApp extends Application {

    public String gakuban = "19EC043"; // 学籍番号を入力すること
    public String yourname = "蔡晟輝"; // 氏名を入力すること

    Alert alert = new Alert(AlertType.ERROR,"正の整数を入力してください"); // アラートボックス
    Scene scene1, scene2;
    Label label1, label2;
    TextField textField1;
    int counter = 0;

    @Override
    public void start(Stage primaryStage) {
    	// 課題4-1,4-2 のコードで書き換え
    	
    	// ラベルを作成する
        label1 = new Label("カウント値");
        label2 = new Label();
        
        // テキストフィールドを作成する
        textField1 = new TextField("0");
        
        // ボタンを作成する
        Button button = new Button("設定する");
        Button button_1 = new Button("カウントアップ");
        Button button_2 = new Button("カウントダウン");
        
        //ボタンの動作を作成する
        button.setOnAction((ActionEvent event) -> {
            String a = textField1.getText().trim();   
            if (a.matches("[1-9][0-9]*")) {        //整数判定
            	primaryStage.setScene(scene2);
            	counter = Integer.parseInt(a);
            	label2.setText(Integer.toString(counter));
            }
            else
            	alert.showAndWait();
            button_2.setText("カウントダウン");
            button_2.setOnAction((ActionEvent c) -> {
            	
            	countDown();
            	
            	if (counter == 0) {
            		
            		button_2.setText("設定し直す");
            		button_2.setOnAction(d -> primaryStage.setScene(scene1));
            	}

            });
        });
        
        button_1.setOnAction((ActionEvent a) -> {
        	countUp();
        	if (counter == 1) {
        		button_2.setText("カウントダウン");
        		button_2.setOnAction((ActionEvent b) -> {
        			countDown();
                	if (counter == 0) {
                		button_2.setText("設定し直す");
                		button_2.setOnAction(c -> primaryStage.setScene(scene1));
                	}

                });
        	}
        	
        });
        
        button_2.setOnAction((ActionEvent event) -> {
        	countDown();
        	if (counter == 0) {
        		button_2.setText("設定し直す");
        		button_2.setOnAction(b -> primaryStage.setScene(scene1));
        	}

        });

        // ペインを作成し、コントロールを配置する
        HBox pane1 = new HBox(10, label1, textField1, button);
        pane1.setAlignment(Pos.CENTER);
        // シーンを作成
        scene1 = new Scene(pane1, 400, 100);
        
        
        // ペインを作成し、コントロールを配置する
        VBox pane2 = new VBox(10, button_1, label2, button_2);
        pane2.setAlignment(Pos.CENTER);
        // シーンを作成
        scene2 = new Scene(pane2, 200, 200);
        

        // Add the scene to the stage, set the title and show the stage
        primaryStage.setScene(scene1);
        primaryStage.setTitle("CountUpDownApp");
        primaryStage.show();
    }
    void countUp() {
        counter++;
        label2.setText(Integer.toString(counter));
    }
    void countDown() {
        counter--;
        label2.setText(Integer.toString(counter));
    }
    
    
    
    

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--CountUpDownApp");
    }

}
