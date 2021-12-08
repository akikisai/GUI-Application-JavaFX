// レポート第1回: Golden Button Application
package ex05;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class GoldenButtonApp extends Application {

    public static String gakuban = "19EC043"; // 学籍番号を入力すること
    public static String yourname = "蔡晟輝"; // 氏名を入力すること
    
    Stage stage;												//ステージ宣言
    Scene scene1, scene2, scene3, scene4, scene5, scene6;		//シーン宣言
    Label label1, label_kin, label_gin, label_dou, label2;		//ラベル宣言
    Button btn_kin, btn_gin, btn_dou, 							//ボタン宣言
    		btn_yes1, btn_no1,
    		btn_yes2, btn_no2,
    		btn_yes3, btn_no3,
    		btn_back, btn_finish; 
    
    //a:拾った斧の種類設定   (金=1,銀=2,銅=3)
    //b:判定用 		3つの質問で、1回正解につきb+1で、bが3なら嘘ついてない
    int a = 0, b = 0;	 
    

    @Override
    public void start(Stage primaryStage) {
        // プログラムを作成
    	// プライマリステージをメソッド間で共有する
        stage = primaryStage;
    	
    	// ラベルを作成する
        label1 = new Label("ボタンをどれか押してください");
        label_kin = new Label("あなたが押したのは金のボタンですか?");
        label_gin = new Label("あなたが押したのは銀のボタンですか?");
        label_dou = new Label("あなたが押したのは銅のボタンですか?");
        label2 = new Label();
        
        
        // ボタンを作成する
        btn_kin = new Button("金");
        btn_gin = new Button("銀");
        btn_dou = new Button("銅");
		btn_yes1 = new Button("はい");
		btn_no1 = new Button("いいえ");
		btn_yes2 = new Button("はい");
		btn_no2 = new Button("いいえ");
		btn_yes3 = new Button("はい");
		btn_no3 = new Button("いいえ");
        btn_back = new Button("最初に戻る");
        btn_finish = new Button("終了");
        
        //ボタンの動作を作成する
        btn_kin.setOnAction((ActionEvent event) -> {
            a = 1;
            stage.setScene(scene2);
        });
        btn_gin.setOnAction((ActionEvent event) -> {
            a = 2;
            stage.setScene(scene2);
        });
        btn_dou.setOnAction((ActionEvent event) -> {
            a = 3;
            stage.setScene(scene2);
        });
        btn_yes1.setOnAction((ActionEvent event) -> {
            if (a == 1) b += 1;
            stage.setScene(scene3);
        });
        btn_no1.setOnAction((ActionEvent event) -> {
            if (a == 2 || a == 3) b += 1;
            stage.setScene(scene3);
        });
        btn_yes2.setOnAction((ActionEvent event) -> {
        	if (a == 2) b += 1;
            stage.setScene(scene4);
        });
        btn_no2.setOnAction((ActionEvent event) -> {
        	if (a == 1 || a == 3) b += 1;
            stage.setScene(scene4);
        });
        btn_yes3.setOnAction((ActionEvent event) -> {
        	if (a == 3) b += 1;
        	if (b != 3) {
        		label2.setText("あなたは嘘をつきました");
        	}else label2.setText("あなたは正直である");
        	stage.setScene(scene5);
        });
        btn_no3.setOnAction((ActionEvent event) -> {
        	if (a == 1 || a == 2) b += 1;
        	if (b != 3) {
        		label2.setText("あなたは嘘をつきました");
        	}else label2.setText("あなたは正直である");
        	stage.setScene(scene5);
        });
        btn_back.setOnAction((ActionEvent event) -> {
        	stage.setScene(scene1);
        	a = b = 0;
        });
        btn_finish.setOnAction((ActionEvent event) -> {
        	stage.close();
        });
        
        // Create the hboxes
        HBox hbox1 = new HBox(15, btn_kin, btn_gin, btn_dou );		//ボタンを横に並ぶ
        HBox hbox2 = new HBox(20, btn_yes1, btn_no1 );
        HBox hbox3 = new HBox(20, btn_yes2, btn_no2);
        HBox hbox4 = new HBox(20, btn_yes3, btn_no3);
        HBox hbox5 = new HBox(20, btn_back, btn_finish );
        
        
        //hboxの中央ぞろえ
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        hbox3.setAlignment(Pos.CENTER);
        hbox4.setAlignment(Pos.CENTER);
        hbox5.setAlignment(Pos.CENTER);
        
        
        // ペインを作成し、コントロールを配置する、及びシーン作成
        VBox pane1 = new VBox(20, label1, hbox1);
        pane1.setAlignment(Pos.CENTER);
        scene1 = new Scene(pane1, 300, 200);
        
        VBox pane2 = new VBox(20, label_kin, hbox2);
        pane2.setAlignment(Pos.CENTER);
        scene2 = new Scene(pane2, 300, 200);
        
        VBox pane3 = new VBox(20, label_gin, hbox3);
        pane3.setAlignment(Pos.CENTER);
        scene3 = new Scene(pane3, 300, 200);
        
        VBox pane4 = new VBox(20, label_dou, hbox4);
        pane4.setAlignment(Pos.CENTER);
        scene4 = new Scene(pane4, 300, 200);
        
        VBox pane5 = new VBox(20, label2, hbox5);
        pane5.setAlignment(Pos.CENTER);
        scene5 = new Scene(pane5, 300, 200);
        
        
        //ほかの設定
        stage.setResizable(false);					//ウィンドウ固定
        stage.initStyle(StageStyle.TRANSPARENT);	//タイトルバーをなくす
        
        
        //primaryStage設定
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--GoldenButtonApp");
    }

}

/* 考察 -- 調査したこと、考慮したこと、工夫したことを記述
調査したことは、レイアウトにおいてどうやって中央ぞろえするか、VBox及びHBoxを使った配置、及び見た目に関するコードの書き方。
工夫したこととしてまず宣言などはまとめて書いて、コメントをしっかり付けることでプログラムを読みやすくし、若干コード長くなるが、
一つ一つしっかり条件設定することでエラーを防止する。見た目において間隔も設定し中央ぞろえして見やすくした。出来栄えとして、
シンプルに表示でき、正常に動作することができたのでいいと思うが、背景色を変えようと思って調べたが、出来なかったところは残念です。
あとコードをもう少しシンプルにできるような気がします。全体としてまだまだ知識を増やし改善すべきだと思う。
*/
