package ex09;

import java.util.Calendar;		//新しく追加

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MonthlyCalendar extends Application {

	public static String gakuban = "19EC043"; // 学籍番号を入力すること
	public static String yourname = "蔡晟輝"; // 氏名を入力すること

	String[] header = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
	GridPane grid = new GridPane();
	ComboBox<Integer> year = new ComboBox<>();
	ComboBox<Integer> month = new ComboBox<>();
	Button submit = new Button();

	@Override
	public void start(Stage primaryStage) {
		// Create the Top layout
		Label yLabel = new Label("年");
		for (int y = 2022; y >= 2001; y--)
			year.getItems().add(y);
		Label mLabel = new Label("月");
		for (int m = 12; m >= 1; m--)
			month.getItems().add(m);
		submit.setText("表示");
		submit.setOnAction(e -> {
			if (year.getValue() != null && month.getValue() != null) {
				reset();
				showHeader();
				showBody();
			}
		});
		HBox hb = new HBox(10, year, yLabel, month, mLabel, submit);
		hb.setPadding(new Insets(10, 20, 0, 20));
		hb.setAlignment(Pos.CENTER);

		// Create the Center layout（課題9-1の確認用）
		grid.setGridLinesVisible(true);
		showHeader();

		// Create the BorderPane
		BorderPane bp = new BorderPane();
		bp.setTop(hb);
		bp.setCenter(grid);

		// Create the scene and Show on the stage
		primaryStage.setScene(new Scene(bp, 400, 280));
		primaryStage.setTitle("GridPane Test1");
		primaryStage.show();
	}

	// Reset the Calendar
	public void reset() {
		grid.getChildren().clear();
		grid.getColumnConstraints().clear();
	}

	// Show the Calendar header
	public void showHeader() {
		// 課題9-1のコードを記述
		grid.setPadding(new Insets(10));

		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(14);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(14);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(14);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setPercentWidth(14);
		ColumnConstraints col4 = new ColumnConstraints();
		col4.setPercentWidth(14);
		ColumnConstraints col5 = new ColumnConstraints();
		col5.setPercentWidth(14);
		ColumnConstraints col6 = new ColumnConstraints();
		col6.setPercentWidth(14);
		grid.getColumnConstraints().addAll(col0, col1, col2, col3,col4,col5,col6);


		Label [] week = new Label[header.length];
		for (int i = 0; i < week.length; i++) {
			week[i] = new Label(header[i]);
			grid.add(week[i], 0+i, 0);
			GridPane.setHalignment(week[i], HPos.CENTER);
		}


	}

	// Show the Calendar body
	public void showBody() {
		// 課題9-2のコードを記述
		Label [] day = new Label[31];
		Calendar cal = Calendar.getInstance();

		//選択された年月、また1日に設定
		cal.set(year.getValue(), month.getValue()-1, 1);

		//その月の日数
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(days);


		for (int i = 0; i < day.length; i++) {
			day[i] = new Label(Integer.toString(i+1));
		}

		for (int i = 0; i < days; i++) {

			GridPane.setHalignment(day[i], HPos.CENTER);

			switch (cal.get(Calendar.DAY_OF_WEEK)) { 
			case Calendar.SUNDAY:
				//日曜日
				grid.add(day[i], i % 7, 1 + i / 7);
				break;
			case Calendar.MONDAY:
				//月曜日
				grid.add(day[i], (i+1) % 7, 1 + (i+1) / 7);
				break;
			case Calendar.TUESDAY:
				//火曜日
				grid.add(day[i], (i+2) % 7, 1 + (i+2) / 7);
				break;
			case Calendar.WEDNESDAY:
				//水曜日
				grid.add(day[i], (i+3) % 7, 1 + (i+3) / 7);
				break;
			case Calendar.THURSDAY:
				//木曜日
				grid.add(day[i], (i+4) % 7, 1 + (i+4) / 7);
				break;
			case Calendar.FRIDAY:
				//金曜日
				grid.add(day[i], (i+5) % 7, 1 + (i+5) / 7);
				break;
			case Calendar.SATURDAY:
				//土曜日
				grid.add(day[i], (i+6) % 7, 1 + (i+6) / 7);
				break;
			}
		}

	}

	public static void main(String[] args) {
		Application.launch(args);
		System.out.println("完了--MonthlyCalendar");
	}
}
