// Listing 4-5: Alert tester1 shows alert boxes

import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertTester1 extends Application {

    Label label;

    @Override
    public void start(Stage primaryStage) {
        // ラベルを作成する
        label = new Label("ボタンを押してください");

        // ボタンを作成する
        Button button1 = new Button("Information");
        button1.setOnAction(e -> inform());
        Button button2 = new Button("Error");
        button2.setOnAction(e -> error());
        Button button3 = new Button("Confirmation");
        button3.setOnAction(e -> confirm());

        // ペインを作成し、コントロールを配置する
        VBox pane = new VBox(10, label, button1, button2, button3);
        pane.setAlignment(Pos.CENTER);

        // シーンを作成し、ステージに追加して表示する
        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AlertTester1");
        primaryStage.show();
    }

    void inform() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Information ボタンです");
        alert.showAndWait();
        label.setText("押されたのは、Information ボタン");
    }

    void error() {
        Alert alert = new Alert(Alert.AlertType.ERROR,
                "Error ボタンです");
        alert.showAndWait();
        label.setText("押されたのは、Error ボタン");
    }

    void confirm() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, 
                "Confirmation ボタンです");
        Optional opt = alert.showAndWait();
        if (opt.isPresent() && opt.get().equals(ButtonType.OK)) {
            label.setText("押されたのは、Confirmation + OK ボタン");
        } else {
            label.setText("押されたのは、Confirmation + Cancel ボタン");
        }
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--AlertTester1");
    }

}
