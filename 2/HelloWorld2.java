// Listing 2-2: HelloWorld2 Application

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class HelloWorld2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // ラベルを作成する
        Label label = new Label("お名前は");
        // ボタンを作成する
        Button button = new Button("送信");
        // テキストフィールドを作成する
        TextField textField = new TextField();
        // ボタンのアクションを登録する
        button.setOnAction((ActionEvent event) -> {
            String name = textField.getText().trim();
            if (name.length() > 0) {
                System.out.print(name + "さん、");
            }
            System.out.println("JavaFXの世界にようこそ");
        });
        // ペインを作成し、コントロールを配置する
        VBox pane = new VBox(label, textField, button);
        // シーンを作成し、ペインに入れる
        Scene scene = new Scene(pane, 200, 100);
        // ステージにペインを入れて、タイトルを設定する
        primaryStage.setScene(scene);
        primaryStage.setTitle("HelloWorld2 Application");
        // ステージを表示する
        primaryStage.show();
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--HelloWorld2");
    }

}
