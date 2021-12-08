// Listing 3-12: Counter implements handler by lambda expression

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

public class Counter4 extends Application {

    int counter = 0;

    @Override
    public void start(Stage primaryStage) {
        // Create the Add button
        Button button = new Button("Click!");

        // Create the Label
        Label label = new Label("0");

        // Set the Event handler
        button.setOnAction(event -> label.setText(Integer.toString(++counter)));

        // Add the buttons and label to an HBox pane
        HBox pane = new HBox(10,label, button);
        pane.setAlignment(Pos.CENTER);

        // Add the layout pane to a scene
        Scene scene = new Scene(pane, 200, 100);

        // Add the scene to the stage, set the title and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Counter4");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--Counter4");
    }

}
