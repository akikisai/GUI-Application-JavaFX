// Exercise 12: AlphabetApp

package ex12;

import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class AlphabetApp extends Application {

	public static String gakuban = "19EC043"; // 学籍番号を入力すること
	public static String yourname = "蔡晟輝"; // 氏名を入力すること

	final int N = 16;
	Button[] buttons = new Button[N];
	ArrayList<String> alphabets = new ArrayList<>(N);
	Label labelRemain, labelMistake, labelTime;
	TilePane tilePane;
	HBox hbox;
	int mistake;
	Instant startTime;

	String[] buttonStyle = {
			/* 以下に課題12-1のコードを記述 */
			"-fx-background-radius: 50;",
			"-fx-font-family: serif;",
			"-fx-text-fill: gold;",
			"-fx-font-size: 28pt;",
			"-fx-font-weight: bold;"


	};

	public void clicked(ActionEvent e) {
		labelTime.setText(Long.toString((Instant.now().toEpochMilli()
				- startTime.toEpochMilli()) / 1000));

		/* 以下に課題12-2のコードを記述 */
		Button b = (Button)e.getSource();
		if(alphabets.get(0).equals(b.getText())) {
			b.setDisable(true);
			alphabets.remove(0);
			labelRemain.setText(Integer.toString(alphabets.size()));
		}else {
			mistake++;
			labelMistake.setText(Integer.toString(mistake));
		}

	}

	@Override
	public void start(Stage primaryStage) {
		// Check the Stylesheet
		File cssFile = new File("src/ex12/AlphabetStyle.css");
		System.out.println(cssFile.toString());
		if (!cssFile.exists()) {
			System.err.println("ERROR! Style sheet cannont be found!");
			return;
		}

		// Create the Board (TilePane)
		tilePane = new TilePane(10, 10);
		tilePane.setPadding(new Insets(10));
		tilePane.setPrefWidth(400);
		tilePane.setVisible(false);

		// Create the Tile (Button)
		final double tileSize = 90;
		String style = String.join(";", buttonStyle);
		for (int i = 0; i < N; i++) {
			buttons[i] = new Button();
			buttons[i].setPrefWidth(tileSize);
			buttons[i].setPrefHeight(tileSize);
			buttons[i].setOnAction(e -> clicked(e));
			buttons[i].setStyle(style);
			tilePane.getChildren().add(buttons[i]);
		}

		// Create the MenuBar
		MenuItem menuStart = new MenuItem("開始(_S)");
		menuStart.setOnAction(e -> startGame());
		MenuItem menuExit = new MenuItem("終了(_X)");
		menuExit.setOnAction(e -> primaryStage.close());
		Menu menuFile = new Menu("ファイル(_F)");
		menuFile.getItems().addAll(menuStart, menuExit);
		MenuBar menuBar = new MenuBar(menuFile);

		// Create the StatusBar
		Label label1 = new Label("残り個数: ");
		labelRemain = new Label("16");
		Label label2 = new Label("お手付き: ");
		labelMistake = new Label("0");
		Label label3 = new Label("経過秒数: ");
		labelTime = new Label("0");
		hbox = new HBox(20, new HBox(label1, labelRemain),
				new HBox(label2, labelMistake), new HBox(label3, labelTime));
		hbox.setAlignment(Pos.CENTER);
		hbox.setVisible(false);

		// Create the BorderPane and Scene
		BorderPane pane = new BorderPane(tilePane);
		pane.setTop(menuBar);
		pane.setBottom(hbox);
		pane.setPadding(new Insets(10));

		// Set the Style and show on the Stage
		Scene scene = new Scene(pane, 450, 500);
		scene.getStylesheets().add(cssFile.toURI().toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("AlphabetApp");
		primaryStage.show();
	}

	public void startGame() {
		// Set the random numbers
		Random random = new Random();
		alphabets.clear();
		for (int i = 0; i < N; i++) {
			String a = String.valueOf((char) (random.nextInt(26) + 65));
			alphabets.add(a);
			buttons[i].setText(a);
			buttons[i].setDisable(false);
		}
		Collections.sort(alphabets);
		mistake = 0;
		startTime = Instant.now();
		labelRemain.setText(Integer.toString(alphabets.size()));
		labelMistake.setText("0");
		labelTime.setText("0");
		tilePane.setVisible(true);
		hbox.setVisible(true);
	}

	public static void main(String[] args) {
		Application.launch(args);
		System.out.println("完了--AlphabetApp");
	}

}
