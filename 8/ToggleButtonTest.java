// Listing 8-1: ToggleButton test

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToggleButtonTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the Labels
        Label prompt = new Label("行きたい駅を選択してください");
        prompt.setAlignment(Pos.CENTER);
        Label label = new Label();
        label.setAlignment(Pos.CENTER);

        // Create the ToggleButtons
        ToggleButton button1 = new ToggleButton("浅草");
        ToggleButton button2 = new ToggleButton("銀座");
        ToggleButton button3 = new ToggleButton("渋谷");

        // Create the ToggleGroup
        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(button1, button2, button3);

        // Create the Button
        Button button = new Button("OK");
        button.setOnAction(e -> {
            ToggleButton toggle = (ToggleButton) group.getSelectedToggle();
            if (toggle != null) {
                label.setText("選択した駅は " + toggle.getText());
            } else {
                label.setText("選択した駅はありません");
            }
        });

        // Create the Scene and Show on the stage
        HBox hbox = new HBox(10, button1, button2, button3, button);
        HBox.setMargin(button, new Insets(0, 0, 0, 20));
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(20, prompt, hbox, label);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox, 300, 200);
        File css = new File("src/styleC8.css");
        scene.getStylesheets().add(css.toURI().toString());
        primaryStage.setScene(scene);
        primaryStage.setTitle("ToggleButton Test");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--RadioButtonTest");
    }

}
