// Listing 4-2: Stage tester2 creates a new stage

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StageTester2 extends Application {

    Label label1;
    Button button1;

    @Override
    public void start(Stage primaryStage) {
        // ラベルを作成する
        label1 = new Label("名前：未入力");
        // ボタンを作成する
        button1 = new Button("名前を入力する");
        // ボタンのアクションを登録する
        button1.setOnAction(e -> openStage());
        // ペインを作成し、コントロールを配置する
        VBox pane1 = new VBox(10, label1, button1);
        pane1.setAlignment(Pos.CENTER);
        // シーンを作成し、ステージに追加して表示する
        Scene scene1 = new Scene(pane1, 300, 150);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("PrimaryStage");
        primaryStage.show();
    }

    void openStage() {
        // ステージを作成する
        Stage stage2 = new Stage();
        // ラベルを作成する
        Label label2 = new Label("名前");
        // テキストフィールドを作成する
        TextField tf2 = new TextField("");
        // ボタンを作成する
        Button button2 = new Button("登録");
        // ボタンのアクションを登録する
        button2.setOnAction(e -> {
            String name = tf2.getText().trim();
            if (name.length() > 0) {
                label1.setText("名前：" + name);
                stage2.close();
            }
        });
        // ペインを作成し、コントロールを配置する
        HBox pane2 = new HBox(10, label2, tf2, button2);
        pane2.setAlignment(Pos.CENTER);
        // シーンを作成し、ステージに追加して表示する
        Scene scene2 = new Scene(pane2, 350, 100);
        stage2.setScene(scene2);
        stage2.setTitle("SecondStage");
        stage2.show();
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--StageTester2");
    }

}
