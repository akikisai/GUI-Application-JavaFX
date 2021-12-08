// Listing 4-3: Scene tester1 mouse enter/exit

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SceneTester1 extends Application {

    Scene scene;
    Label label;

    @Override
    public void start(Stage primaryStage) {
        // ラベルを作成する
        label = new Label("マウスを操作してください");
        // ペインを作成し、コントロールを配置する
        StackPane pane = new StackPane(label);
        pane.setBackground(null);
        // シーンを作成する
        scene = new Scene(pane, 300, 100);
        scene.setOnMouseClicked(e -> clicked());
        scene.setOnMouseEntered(e -> entered());
        scene.setOnMouseExited(e -> exited());
        // シーンをステージに追加して表示する
        primaryStage.setScene(scene);
        primaryStage.setTitle("SceneTester1");
        primaryStage.show();
    }

    void clicked() {
        scene.setFill(Color.ORANGE);
        label.setText("マウスがクリックされました");
    }

    void entered() {
        scene.setFill(Color.YELLOW);
        label.setText("マウスが入りました");
    }

    void exited() {
        scene.setFill(Color.WHITE);
        label.setText("マウスが出ました");
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--SceneTester1");
    }

}
