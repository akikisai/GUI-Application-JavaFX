// Listing 4-6: Alert tester2 shows alert boxes

import java.util.Optional;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertTester2 extends Application {

    Stage stage;

    @Override
    public void start(Stage primaryStage) {
        // プライマリステージをメソッド間で共有する
        stage = primaryStage;

        // ボタンを作成する
        Button button = new Button("終了");
        button.setOnAction(e -> finish());

        // ペインを作成し、コントロールを配置する
        StackPane pane = new StackPane(button);

        // シーンを作成し、ステージに追加する
        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AlertTester2");

        // ウィンドウクローズボタンの確認を設定する
        primaryStage.setOnCloseRequest(e -> {
            // イベントを消費済みにして、終了確認を行う
            e.consume();
            finish();
        });

        // ウィンドウを表示する
        primaryStage.show();
    }

    // 終了確認を行う
    void finish() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "本当に終了しますか？");
        Optional opt = alert.showAndWait();
        if (opt.isPresent() && opt.get().equals(ButtonType.OK)) {
            stage.close();
        }
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--AlertTester2");
    }

}
