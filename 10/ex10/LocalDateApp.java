// Exercise 10: Local Date App
package ex10;

import java.time.LocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LocalDateApp extends Application {

	public static String gakuban = "19EC043"; // 学籍番号を入力すること
	public static String yourname = "蔡晟輝"; // 氏名を入力すること

	LocalDate date = LocalDate.now();
	MenuBar menuBar = new MenuBar();
	ContextMenu menuContext = new ContextMenu();
	Label label = new Label();
	Stage stage;
	boolean isWareki;


	// 西暦または和暦で日付を表示する
	public void showDate() {
		DateTimeFormatter df;
		if (isWareki)
			df = DateTimeFormatter.ofPattern("Gy年M月d日(E)").withChronology(JapaneseChronology.INSTANCE);
		else
			df = DateTimeFormatter.ofPattern("Gy年M月d日(E)");
		label.setText(df.format(date));
	}

	// メニューバーを作成する
	public void createMenuBar() {
		// 課題10-1のコードを記述
		isWareki = false;
		Menu menuFile = new Menu("ファイル");
		MenuItem itemToday = new MenuItem("今日");
		itemToday.setOnAction((ActionEvent event) -> {
			date = LocalDate.now();
    		showDate();
		});
		MenuItem itemExit = new MenuItem("終了");
		itemExit.setOnAction(e -> stage.close());
		menuFile.getItems().addAll(itemToday, itemExit);


		Menu menuKako = new Menu("過去");
		MenuItem itemLastyear = new MenuItem("前年");
		itemLastyear.setOnAction((ActionEvent event) -> {
			date = date.plusYears(-1);
    		showDate();
		});
		MenuItem itemLastmonth = new MenuItem("前月");
		itemLastmonth.setOnAction((ActionEvent event) -> {
			date = date.plusMonths(-1);
    		showDate();
		});
		MenuItem itemLastday = new MenuItem("前日");
		itemLastday.setOnAction((ActionEvent event) -> {
			date = date.plusDays(-1);
    		showDate();
		});
		menuKako.getItems().addAll(itemLastyear, itemLastmonth, itemLastday);


		Menu menuMirai = new Menu("未来");
		MenuItem itemNextyear = new MenuItem("翌年");
		itemNextyear.setOnAction((ActionEvent event) -> {
			date = date.plusYears(1);
    		showDate();
		});
		MenuItem itemNextmonth = new MenuItem("翌月");
		itemNextmonth.setOnAction((ActionEvent event) -> {
			date = date.plusMonths(1);
    		showDate();
		});
		MenuItem itemNextday = new MenuItem("翌日");
		itemNextday.setOnAction((ActionEvent event) -> {
			date = date.plusDays(1);
    		showDate();
		});
		menuMirai.getItems().addAll(itemNextyear, itemNextmonth, itemNextday);

		// Create the MenuBar
		menuBar.getMenus().addAll(menuFile,  menuKako, menuMirai);

	}

	// コンテキストメニューを作成する
	public void createContextMenu() {
		// 課題10-2のコードを記述
		// Create the Context menu

		MenuItem itemSeireki = new MenuItem("西暦");
		itemSeireki.setOnAction((ActionEvent event) -> {
			isWareki = false;
			showDate();

		});
		MenuItem itemWareki = new MenuItem("和暦");
		itemWareki.setOnAction((ActionEvent event) -> {
			isWareki = true;
			showDate();
		});
		menuContext.getItems().addAll(itemSeireki, itemWareki);
		label.setContextMenu(menuContext);

	}

	@Override
	public void start(Stage primaryStage) {

		stage = primaryStage;   // プライマリステージの参照
		createMenuBar();        // メニューバーの作成
		createContextMenu();    // コンテキストメニューの作成

		// Set everything and show on the stage
		label.setFont(new Font(24));
		BorderPane pane = new BorderPane();
		pane.setTop(menuBar);
		pane.setCenter(label);
		showDate();
		primaryStage.setScene(new Scene(pane, 400, 100));
		primaryStage.setTitle("Local Date App");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
		System.out.println("完了--LocalDateApp");
	}
}
