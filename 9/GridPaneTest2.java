// Listing 9-5: GridPane test2

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GridPaneTest2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Create the GridPane
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(10));

		// Set the Column Constranits
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(40);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(20);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(20);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setPercentWidth(20);
		pane.getColumnConstraints().addAll(col0, col1, col2, col3);

		// Set the Row Constranits
		RowConstraints row0 = new RowConstraints();
		row0.setPercentHeight(25);
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(25);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(25);
		RowConstraints row3 = new RowConstraints();
		row3.setPercentHeight(25);
		pane.getRowConstraints().addAll(row0, row1, row2, row3);

		// Create the Buttons
		Button btnVT = new Button("VPos.TOP");
		pane.add(btnVT, 0, 1);
		GridPane.setValignment(btnVT, VPos.TOP);
		Button btnVC = new Button("VPos.CENTER");
		pane.add(btnVC, 0, 2);
		GridPane.setValignment(btnVC, VPos.CENTER);
		Button btnVB = new Button("VPos.BOTTOM");
		pane.add(btnVB, 0, 3);
		GridPane.setValignment(btnVB, VPos.BOTTOM);

		Button btnHL = new Button("HPos.LEFT");
		pane.add(btnHL, 1, 0);
		GridPane.setHalignment(btnHL, HPos.LEFT);
		Button btnHC = new Button("HPos.CENTER");
		pane.add(btnHC, 2, 0);
		GridPane.setHalignment(btnHC, HPos.CENTER);
		Button btnHR = new Button("HPos.RIGHT");
		pane.add(btnHR, 3, 0);
		GridPane.setHalignment(btnHR, HPos.RIGHT);

		Button btnVTHL = new Button("VPos.TOP\nHPos.LEFT");
		pane.add(btnVTHL, 1, 1);
		GridPane.setValignment(btnVTHL, VPos.TOP);
		GridPane.setHalignment(btnVTHL, HPos.LEFT);
		Button btnVCHC = new Button("VPos.CENTER\nHPos.CENTER");
		pane.add(btnVCHC, 2, 2);
		GridPane.setValignment(btnVCHC, VPos.CENTER);
		GridPane.setHalignment(btnVCHC, HPos.CENTER);
		Button btnVBHR = new Button("VPos.BOTTOM\nHPos.RIGHT");
		pane.add(btnVBHR, 3, 3);
		GridPane.setValignment(btnVBHR, VPos.BOTTOM);
		GridPane.setHalignment(btnVBHR, HPos.RIGHT);

		// Create the RadioButtons
		ToggleGroup toggle = new ToggleGroup();
		RadioButton rb1 = new RadioButton("Visible grid line");
		rb1.setToggleGroup(toggle);
		rb1.setOnAction(e -> pane.setGridLinesVisible(true));
		RadioButton rb2 = new RadioButton("Invisible grid line");
		rb2.setToggleGroup(toggle);
		rb2.setOnAction(e -> pane.setGridLinesVisible(false));
		VBox vbox = new VBox(10, rb1, rb2);
		vbox.setPadding(new Insets(10));
		pane.add(vbox, 0, 0);
		rb2.fire();

		// Create the Scene and show on the stage
		primaryStage.setScene(new Scene(pane, 600, 300));
		primaryStage.setTitle("GridPane Test2");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
		System.out.println("完了--GridPaneTest2");
	}
}
