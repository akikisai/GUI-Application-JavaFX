
// Listing 7-3: Button test 1

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ButtonTest1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Labels
        Label prompt = new Label("Click any button you like!");
        prompt.setAlignment(Pos.CENTER);
        Label result = new Label();
        result.setAlignment(Pos.CENTER);

        // Create the Buttons
        Button[] btn = new Button[4];
        for (int i = 0; i < btn.length; i++) {
            btn[i] = new Button("Button-" + i);
            btn[i].setOnAction(e -> {
                Button clicked = (Button) e.getSource();
                result.setText(clicked.getText() + " clicked.");
            });
        }

        // Decorate the buttons
        btn[1].setPrefSize(100, 50);
        btn[2].setFont(new Font(18));
        btn[3].setStyle("-fx-base: gold");
        btn[3].setOnMouseEntered(e -> {
            btn[3].setStyle("-fx-base: yellow");
        });
        btn[3].setOnMouseExited(e -> {
            btn[3].setStyle("-fx-base: gold");
        });

        // Create the Scene and Show on the stage
        HBox hbox = new HBox(10, btn);
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(20, prompt, hbox, result);
        vbox.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(vbox, 400, 200));
        primaryStage.setTitle("Button Test 1");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--ButtonTest1");
    }

}
