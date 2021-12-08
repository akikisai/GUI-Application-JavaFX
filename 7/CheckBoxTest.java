// Listing 7-5: CheckBox test

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Labels
        Label prompt = new Label("好きな街を選択してください");
        prompt.setAlignment(Pos.CENTER);
        Label label = new Label();
        label.setAlignment(Pos.CENTER);

        // Create the CheckBoxes
        CheckBox check1 = new CheckBox("浅草");
        CheckBox check2 = new CheckBox("銀座");
        CheckBox check3 = new CheckBox("渋谷");

        // Create the Button
        Button button = new Button("OK");
        button.setOnAction(e -> {
            ArrayList<String> list = new ArrayList<>();
            if (check1.isSelected()) {
                list.add(check1.getText());
            }
            if (check2.isSelected()) {
                list.add(check2.getText());
            }
            if (check3.isSelected()) {
                list.add(check3.getText());
            }
            if (!list.isEmpty()) {
                label.setText("選択した街は " + list);
            } else {
                label.setText("選択した街はありません");
            }

        });

        // Create the Scene and Show on the stage
        HBox hbox = new HBox(10, check1, check2, check3, button);
        HBox.setMargin(button, new Insets(0, 0, 0, 20));
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(20, prompt, hbox, label);
        vbox.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(vbox, 300, 200));
        primaryStage.setTitle("CheckBox Test");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--CheckBoxTest");
    }

}
