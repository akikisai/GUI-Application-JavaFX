// Listing 6-4: Message Box tester

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MessageBoxTester extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Primary Stage");
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(400);

        Label label = new Label("ボタンを押すとメッセージボックスが開きます。");
        Button btnOpen = new Button("Open");
        btnOpen.setOnAction(e -> MessageBox.show
                ("Here is a message.\nメッセージがあります。", "Title"));

        VBox pane = new VBox(20, label, btnOpen);
        pane.setPadding(new Insets(20));
        pane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--MessageBoxTester");
    }
}
