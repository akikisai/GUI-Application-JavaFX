// Listing 7-4: Button test 2

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonTest2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Labels
        Label prompt = new Label("Click a button or Type Esc or Enter key!");
        prompt.setAlignment(Pos.CENTER);
        Label label = new Label();
        label.setAlignment(Pos.CENTER);

        // Create the Buttons
        Button btnOn = new Button("On");
        Button btnOff = new Button("Off");
        btnOn.setOnAction(e -> {
            btnOff.setDisable(false);
            btnOn.setDisable(true);
            label.setText("On button clicked.");
        });
        btnOff.setOnAction(e -> {
            btnOn.setDisable(false);
            btnOff.setDisable(true);
            label.setText("Off button clicked.");
        });

        Button btnCancel = new Button("Cancel");
        btnCancel.setCancelButton(true);
        btnCancel.setOnAction(e -> {
            label.setText("Cancel button clicked.");
        });

        Button btnDefault = new Button("Normal");
        btnDefault.setDefaultButton(true);
        btnDefault.setOnAction(e -> {
            label.setText("Normal button clicked.");
        });

        // Create the Scene and Show on the stage
        HBox hbox = new HBox(10, btnOn, btnOff, btnCancel, btnDefault);
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(20, prompt, hbox, label);
        vbox.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(vbox, 400, 200));
        primaryStage.setTitle("Button Test 2");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--ButtonTest2");
    }

}
