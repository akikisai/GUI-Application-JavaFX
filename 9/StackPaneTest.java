// Listing 9-1: StackPane test

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StackPaneTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Buttons and VBox
        Button[] btn1 = new Button[3];
        for (int i = 0; i < 3; i++) {
            btn1[i] = new Button("Button " + (i + 1));
            btn1[i].setPrefSize(150 - 30 * i, 100 - 20 * i);
            ;
            btn1[i].setOnAction(e -> {
                Button b = (Button) e.getSource();
                b.setVisible(false);
            });
        }

        VBox vb = new VBox();
        vb.getChildren().addAll(btn1);
        vb.setPrefSize(200, 250);
        vb.setStyle("-fx-border-color: black");

        // Create the Buttons and StackPane
        Button[] btn2 = new Button[3];
        for (int i = 0; i < 3; i++) {
            btn2[i] = new Button("Button " + (i + 1));
            btn2[i].setPrefSize(150 - 30 * i, 100 - 20 * i);
            ;
            btn2[i].setOnAction(e -> {
                Button b = (Button) e.getSource();
                b.setVisible(false);
            });
        }

        StackPane sp = new StackPane();
        sp.getChildren().addAll(btn2);
        sp.setPrefSize(200, 250);
        sp.setStyle("-fx-border-color: red");

        // Create the HBox and show them on the stage
        HBox hb = new HBox(5, vb, sp);
        primaryStage.setScene(new Scene(hb));
        primaryStage.setTitle("StackPane Test");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--StackPaneTest");
    }
}
