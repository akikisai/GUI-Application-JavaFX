// Listing 9-4: GridPane test1

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GridPaneTest1 extends Application {

	@Override
	public void start(Stage primaryStage) {
		String[] number = { "zero", "one", "two", "three", "four",
				"five", "six", "seven", "eight", "nine", "ten", "eleven",
				"twelve", "thirteen", "fourteen" };

		// Create the Buttons
		Button[] btn = new Button[number.length];
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(number[i]);
			btn[i].setOnAction(e -> {
				Button b = (Button) e.getSource();
				b.setDisable(true);
			});
		}

		// Create the GridPane
		GridPane pane = new GridPane();
		for (int i = 0; i < btn.length; i++) {
			pane.add(btn[i], i % 4, 1 + i / 4);
		}
		pane.setHgap(10);
		pane.setVgap(10);

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
		primaryStage.setScene(new Scene(pane, 500, 300));
		primaryStage.setTitle("GridPane Test1");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
		System.out.println("完了--GridPaneTest1");
	}
}
