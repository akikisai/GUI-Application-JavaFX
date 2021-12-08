// Listing 4-4: Scene tester2 change scenes

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

public class SceneTester2 extends Application {

    Scene scene1, scene2;
    Label label1, label2;
    int counter = 0;

    @Override
    public void start(Stage primaryStage) {
        // Create Scene1
        label1 = new Label("0");
        Button button11 = new Button("Click!");
        button11.setOnAction(e -> clicked());
        Button button12 = new Button("Change to Japanese");
        button12.setOnAction(e -> primaryStage.setScene(scene2));
        HBox pane1 = new HBox(10, label1, button11, button12);
        pane1.setAlignment(Pos.CENTER);
        scene1 = new Scene(pane1, 300, 100);

        // Create Scene2
        label2 = new Label();
        Button button21 = new Button("クリック！");
        button21.setOnAction(e -> clicked());
        Button button22 = new Button("英語に変更");
        button22.setOnAction(e -> primaryStage.setScene(scene1));
        VBox pane2 = new VBox(10, label2, button21, button22);
        pane2.setAlignment(Pos.CENTER);
        scene2 = new Scene(pane2, 250, 150);

        // Add the scene to the stage, set the title and show the stage
        primaryStage.setScene(scene1);
        primaryStage.setTitle("SceneTester2");
        primaryStage.show();
    }

    void clicked() {
        counter++;
        label1.setText(Integer.toString(counter));
        label2.setText(Integer.toString(counter));
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--SceneTester2");
    }

}
