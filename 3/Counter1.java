// Listing 3-9: Counter implements handler by myself

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;

public class Counter1 extends Application
        implements EventHandler<ActionEvent> {

    Label label;
    int counter = 0;

    @Override
    public void start(Stage primaryStage) {
        // Create the Add button
        Button button = new Button("Click!");
        button.setOnAction(this);

        // Create the Label
        label = new Label("0");

        // Add the buttons and label to an HBox pane
        HBox pane = new HBox(10,label, button);
        pane.setAlignment(Pos.CENTER);
 
        // Add the layout pane to a scene
        Scene scene = new Scene(pane, 200, 100);

        // Add the scene to the stage, set the title and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Counter1");
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent e) {
        counter++;
        label.setText(Integer.toString(counter));
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--Counter1");
    }

}
