// Listing 8-3 ComboBox Test1

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ComboBoxTest1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Label
        Label question = new Label("どこまで行きますか？");
        Label answer = new Label();

        // Create the ComboBox
        String[] stations = {"東京", "神田", "秋葉原", "御徒町", "上野", "鶯谷",
            "日暮里", "西日暮里", "田端", "上中里", "王子", "東十条", "赤羽"};
        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll(stations);

        // Craete the Button
        Button button = new Button("OK");
        button.setOnAction(e -> {
            answer.setText(combo.getValue() + " まで、了解しました。");
        });

        // Create the Scene and Show on the stage
        HBox hbox = new HBox(10, combo, button);
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(20, question, hbox, answer);
        vbox.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(vbox, 300, 200));
        primaryStage.setTitle("ComboBox Test1");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--ComboBoxTest1");
    }

}
