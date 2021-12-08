// Listing 6-1: Label test

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class LabelTest extends Application {

    Label label;

    @Override
    public void start(Stage primaryStage) {
        // Create the label
        label = new Label("This is a label.");
        label.setStyle("-fx-background-color: yellow;");
        double prefWidth = label.getPrefWidth();
        double prefHeight = label.getPrefHeight();
      
        // create the buttons
        Button btn1 = new Button("label.setPrefWidth(250)");
        btn1.setOnAction(e -> label.setPrefWidth(250));
        Button btn2 = new Button("label.setPrefHeight(100)");
        btn2.setOnAction(e -> label.setPrefHeight(100));
        Button btn3 = new Button("label.setPadding(new Insets(20))");
        btn3.setOnAction(e -> label.setPadding(new Insets(20)));
        Button btn4 = new Button("label.setAlignment(Pos.CENTER RIGHT)");
        btn4.setOnAction(e -> label.setAlignment(Pos.CENTER_RIGHT));
        Button btn5 = new Button("Reset");
        btn5.setOnAction(e -> {
            label.setPrefWidth(prefWidth);
            label.setPrefHeight(prefHeight);
            label.setPadding(Insets.EMPTY);
            label.setAlignment(Pos.CENTER_LEFT);
        });

        // Show 1st Layout
        VBox vbox = new VBox(label, btn1, btn2, btn3, btn4, btn5);
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Label test");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--LabelTest");
    }

}
