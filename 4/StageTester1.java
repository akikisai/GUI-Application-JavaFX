// Listing 4-1: Stage tester1 changes Resizable property

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class StageTester1 extends Application {
    
    Stage stage;
    
    @Override
    public void start(Stage primaryStage) {
        // プライマリステージをメソッド間で共有する
        stage = primaryStage;
        // ボタンを作成する
        Button button = new Button("Resizable ON/OFF");
        // ボタンのアクションを登録する
        button.setOnAction(e -> clicked());
        // ペインを作成し、コントロールを配置する
        StackPane pane = new StackPane(button);
        // シーンを作成し、ステージに追加して表示する
        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Resizable, Now");
        primaryStage.show();
    }
    
    void clicked() {
        if (stage.isResizable()) {
            stage.setResizable(false);
            stage.setTitle("NOT Resizable, Now");
        } else {
            stage.setResizable(true);
            stage.setTitle("Resizable, Now");            
        }
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--StageTester1");
    }

}
