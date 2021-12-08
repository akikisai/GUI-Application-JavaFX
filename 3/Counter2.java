// Listing 3-10: Counter implements handler by inner class

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;

public class Counter2 extends Application {

    Label label;
    int counter = 0;

    private class ClickHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            counter++;
            label.setText(Integer.toString(counter));
        }
    }

    @Override
    public void start(Stage primaryStage) {
        // Create an Instance of ClickHandler
        ClickHandler ch = new ClickHandler();

        // Create the Add button
        Button button = new Button("Click!");
        button.setOnAction(ch);

        // Create the Label
        label = new Label("0");

        // Add the buttons and label to an HBox pane
        HBox pane = new HBox(10,label, button);
        pane.setAlignment(Pos.CENTER);

        // Add the layout pane to a scene
        Scene scene = new Scene(pane, 200, 100);

        // Add the scene to the stage, set the title and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Counter2");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println("完了--Counter2");
    }

}
