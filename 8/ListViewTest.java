// Listing 8-6 ListView Test

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ListViewTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Label
        Label question = new Label("お好きな駅はどれですか？");
        Label answer = new Label();

        // Create the ListView
        String[] stations = {"東京", "神田", "秋葉原", "御徒町", "上野", "鶯谷",
            "日暮里", "西日暮里", "田端", "上中里", "王子", "東十条", "赤羽"};
        ListView<String> list = new ListView<>();
        list.getItems().addAll(stations);
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Craete the Button
        Button button = new Button("OK");
        button.setOnAction(e -> {
            answer.setText("選択したのは "
                    + list.getSelectionModel().getSelectedItems().toString());
        });

        // Create the Scene and Show on the stage
        HBox hbox = new HBox(10, list, button);
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(20, question, hbox, answer);
        vbox.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(vbox, 300, 300));
        primaryStage.setTitle("ListView Test");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--ListViewTest");
    }

}
