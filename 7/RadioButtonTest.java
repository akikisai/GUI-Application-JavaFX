// Listing 7-6: RadioButton test

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Labels
        Label prompt = new Label("行きたい街を選択してください");
        prompt.setAlignment(Pos.CENTER);
        Label label = new Label();
        label.setAlignment(Pos.CENTER);

        // Create the CheckBoxes
        RadioButton radio1 = new RadioButton("浅草");
        RadioButton radio2 = new RadioButton("銀座");
        RadioButton radio3 = new RadioButton("渋谷");

        // Create the ToggleGroup
        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(radio1, radio2, radio3);

        // Create the Button
        Button button = new Button("OK");
        button.setOnAction(e -> {
            RadioButton radio = (RadioButton) group.getSelectedToggle();
            if (radio != null) {
                label.setText("選択した街は " + radio.getText());
            } else {
                label.setText("選択した街はありません");
            }
        });

        // Create the Scene and Show on the stage
        HBox hbox = new HBox(10, radio1, radio2, radio3, button);
        HBox.setMargin(button, new Insets(0, 0, 0, 20));
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(20, prompt, hbox, label);
        vbox.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(vbox, 300, 200));
        primaryStage.setTitle("RadioButton Test");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--RadioButtonTest");
    }

}
