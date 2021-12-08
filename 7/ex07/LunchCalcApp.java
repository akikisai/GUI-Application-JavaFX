// Exercise 7: Lunch Calc Application
package ex07;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LunchCalcApp extends Application {

	public static String gakuban = "19EC043"; // 学籍番号を入力すること
	public static String yourname = "蔡晟輝"; // 氏名を入力すること

	Scene scene;
	TextField tfCalc;
	Button btnCalc;
	RadioButton rbLunchA, rbLunchB, rbLunchC; // A定食, B定食, C定食
	RadioButton rbSizeS, rbSizeM, rbSizeL; // 小盛, 普通, 大盛
	CheckBox cbOptYogurt, cbOptFruit; // ヨーグルト、フルーツ

	public void createScene() {
		// Create the Header
		Label lblHeader = new Label("ランチ計算機");
		lblHeader.setFont(new Font(20));
		lblHeader.setUnderline(true);
		HBox hbHeader = new HBox(lblHeader);
		hbHeader.setPadding(new Insets(10));
		hbHeader.setAlignment(Pos.CENTER);

		// Create the Lunch selecter
		rbLunchA = new RadioButton("A定食 (480)");
		rbLunchB = new RadioButton("B定食 (450)");
		rbLunchC = new RadioButton("C定食 (420)");
		HBox hbLunch = new HBox(10, rbLunchA, rbLunchB, rbLunchC);
		hbLunch.setAlignment(Pos.CENTER);

		// Create the Size selecter
		rbSizeS = new RadioButton("ライス小 (-30)");
		rbSizeM = new RadioButton("ライス並 (+0)");
		rbSizeL = new RadioButton("ライス大 (+50)");
		HBox hbSize = new HBox(10, rbSizeS, rbSizeM, rbSizeL);
		hbSize.setAlignment(Pos.CENTER);

		// Create the Option selector
		cbOptYogurt = new CheckBox("ヨーグルト (+60)");
		cbOptFruit = new CheckBox("フルーツ (+80)");
		HBox hbOption = new HBox(10, cbOptYogurt, cbOptFruit);
		hbOption.setAlignment(Pos.CENTER);

		// Create the Calculator
		Label lblCalc = new Label("金額");
		lblCalc.setMinWidth(60);
		lblCalc.setAlignment(Pos.BASELINE_RIGHT);
		tfCalc = new TextField("0");
		tfCalc.setPrefColumnCount(4);
		tfCalc.setAlignment(Pos.CENTER_RIGHT);
		tfCalc.setEditable(false);
		btnCalc = new Button("再計算する");
		btnCalc.setOnAction(e -> calculation());
		HBox hbCalc = new HBox(10, lblCalc, tfCalc, btnCalc);
		hbCalc.setAlignment(Pos.CENTER);

		// Create the Layout
		VBox vbox = new VBox(30, hbHeader, hbLunch, hbSize, hbOption, hbCalc);
		vbox.setPadding(new Insets(10));
		scene = new Scene(vbox, 450, 350);
	}

	public void setRadioButtons() {
		// 課題7-1のコードを記述
		ToggleGroup group1 = new ToggleGroup();
		group1.getToggles().addAll(rbLunchA, rbLunchB, rbLunchC);

		ToggleGroup group2 = new ToggleGroup();
		group2.getToggles().addAll(rbSizeS, rbSizeM, rbSizeL);

		rbLunchA.setSelected(true);
		rbSizeM.setSelected(true);
		tfCalc.setText("480");



	}

	public void calculation() {
		// 課題7-2のコードを記述
		btnCalc.setOnAction(e -> {
			int a = 0;
			if (rbLunchA.isSelected()) {
				a += 480;
			} 
			else if (rbLunchB.isSelected()){
				a += 450;
			}else if (rbLunchC.isSelected()){
				a += 420;
			}

			if (rbSizeS.isSelected()) {
				a -= 30;
			} 
			else if (rbSizeM.isSelected()){
				a += 0;
			}else if (rbSizeL.isSelected()){
				a += 50;
			}
			if (cbOptYogurt.isSelected()) {
				a += 60;
			}
			if (cbOptFruit.isSelected()) {
				a += 80;
			}
			String str = String.valueOf(a);
			tfCalc.setText(str);


		});

	}
	@Override
	public void start(Stage primaryStage) {
		// Create the Scene
		createScene();

		// Set the RadioButtons
		setRadioButtons(); // 課題7-1でこのメソッドを実装

		// Set the Caluculate Button
		calculation(); // 課題7-2でこのメソッドを実装

		// Show the Scene
		primaryStage.setScene(scene);
		primaryStage.setTitle("Lunch Calc App");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
		System.out.println("完了--LunchCalcApp");
	}

}
