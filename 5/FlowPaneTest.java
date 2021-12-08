// Listing 5-6: FlowPane Test

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;

public class FlowPaneTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the buttons
        Button btn1 = new Button("1: Show Horizontal");
        Button btn2 = new Button("2: Show Vertical");
        Button btn3 = new Button("3: Align Top-Left");
        Button btn4 = new Button("4: Align Bottom-Right");
        Button btn5 = new Button("5: Button five");
        FlowPane pane = new FlowPane(10, 10, btn1, btn2, btn3, btn4, btn5);
        pane.setPadding(new Insets(10));

        // Change Orientation and Alignment
        btn1.setOnAction(e -> {
            pane.setOrientation(Orientation.HORIZONTAL);
        });
        btn2.setOnAction(e -> {
            pane.setOrientation(Orientation.VERTICAL);
        });
        btn3.setOnAction(e -> {
            pane.setAlignment(Pos.TOP_LEFT);
        });
        btn4.setOnAction(e -> {
            pane.setAlignment(Pos.BOTTOM_RIGHT);
        });

        // Show FlowPane Layout
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FlowPane Test");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
