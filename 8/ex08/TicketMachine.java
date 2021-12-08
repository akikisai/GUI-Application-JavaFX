// Exercise 08: Ticket Machine
package ex08;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicketMachine extends Application {

	public static String gakuban = "19EC043"; // 学籍番号を入力すること
	public static String yourname = "蔡晟輝"; // 氏名を入力すること

	int[] fares = { 170, 200, 250, 290, 320 }; // 料金表
	Label lblTop = new Label("券売機");
	Label lblLeft = new Label("枚数");
	Label lblBottom = new Label("金額");
	Button rbtn = new Button("リセット");
	ComboBox<Integer> cbox = new ComboBox<>(); // 枚数選択用
	ToggleButton[] tbtn = new ToggleButton[fares.length]; // 料金選択用
	TextField tf = new TextField(); // 金額表示用
	ToggleGroup group = new ToggleGroup();
	BorderPane bp = new BorderPane();

	@Override
	public void start(Stage primaryStage) {
		// Set the Top Label
		lblTop.setFont(new Font(24));
		lblLeft.setFont(new Font(16));
		lblBottom.setFont(new Font(16));

		// Set the ComboBox
		cbox.getItems().addAll(1, 2, 3, 4, 5);
		cbox.setOnAction(e -> comboSelected());

		// Set the Toggle Buttons
		for (int i = 0; i < fares.length; i++) {
			tbtn[i] = new ToggleButton(Integer.toString(fares[i]));
			tbtn[i].setPrefHeight(40);
			tbtn[i].setPrefWidth(70);
			tbtn[i].setFont(new Font(18));
			tbtn[i].setOnAction(e -> buttonSelected());
			group.getToggles().add(tbtn[i]);
		}

		// Set the Text Field
		tf.setEditable(false);
		tf.setFont(new Font(18));
		tf.setPrefColumnCount(6);
		tf.setAlignment(Pos.BASELINE_RIGHT);

		// Set the Reset Button
		rbtn.setFont(new Font(16));
		rbtn.setOnAction(e -> reset());

		// Create the Layout
		makeLayout();

		// Create and show the Scene
		Scene scene = new Scene(bp, 450, 270);
		File css = new File("src/ex08/styleEx08.css");
		scene.getStylesheets().add(css.toURI().toString());
		cbox.requestFocus();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ticket Machine");
		primaryStage.show();
	}

	public void makeLayout() {
		// 課題8-1のコードを記述
		HBox hboxTop = new HBox(lblTop);
		lblTop.setAlignment(Pos.CENTER);
		lblTop.setPadding(new Insets(10));

		VBox vboxLeft = new VBox(5, lblLeft, cbox);
		vboxLeft.setAlignment(Pos.CENTER);
		vboxLeft.setPadding(new Insets(10));

		HBox hboxCenter = new HBox(10, tbtn);
		hboxCenter.setAlignment(Pos.CENTER);
		hboxCenter.setPadding(new Insets(10));

		HBox hboxBottom = new HBox(10, lblBottom, tf, rbtn);
		hboxBottom.setAlignment(Pos.CENTER);
		hboxBottom.setPadding(new Insets(10));

		bp.setTop(hboxTop);
		bp.setLeft(vboxLeft);
		bp.setCenter(hboxCenter);
		bp.setBottom(hboxBottom);

	}

	public void comboSelected() {
		// 課題8-2のコードを記述

		for (int i = 0; i < fares.length; i++) {
			int nedan = fares[i];
			if (tbtn[i].isSelected()) {
				try {
					int sum = nedan * cbox.getValue();
					tf.setText(String.valueOf(sum));
					}catch (Exception e) {
					}
			}
		}
	}

	public void buttonSelected() {
		// 課題8-2のコードを記述
		if(cbox.getValue()==null) {
			tf.setText(null);
		}else {
			int a = 0;
			for (int i = 0; i < fares.length; i++) {
				int nedan = fares[i];
				if (tbtn[i].isSelected()) {
					int sum = nedan * cbox.getValue();
					tf.setText(String.valueOf(sum));
					break;
				}
			}
			for (int i = 0; i < fares.length; i++) {
				if (!tbtn[i].isSelected()) {
					a++;
				}
			}
			if (a == 5) tf.setText(null);
		}
	}

	public void reset() {
		// 課題8-2のコードを記述
		cbox.setValue(null);
		tf.setText(null);
		for (int i = 0; i < fares.length; i++) {
			tbtn[i].setSelected(false);
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
		System.out.println("完了--TicketMachine");
	}

}
