// Listing 5-3: Change Alignment

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChangeAlignment extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create VBox
        VBox vbox = new VBox();

        // Create the buttons
        Button btn1 = new Button("Top Left");
        btn1.setOnAction(e -> vbox.setAlignment(Pos.TOP_LEFT));
        Button btn2 = new Button("Top Center");
        btn2.setOnAction(e -> vbox.setAlignment(Pos.TOP_CENTER));
        Button btn3 = new Button("Top Right");
        btn3.setOnAction(e -> vbox.setAlignment(Pos.TOP_RIGHT));
        Button btn4 = new Button("Center");
        btn4.setOnAction(e -> vbox.setAlignment(Pos.CENTER));
        Button btn5 = new Button("Baseline Center");
        btn5.setOnAction(e -> vbox.setAlignment(Pos.BASELINE_CENTER));
        Button btn6 = new Button("Bottom Center");
        btn6.setOnAction(e -> vbox.setAlignment(Pos.BOTTOM_CENTER));

        // Show the layout
        vbox.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6);
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Change Alignment");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
