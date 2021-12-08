// Listing 9-2: TilePane test

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TilePaneTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        String[] number = { "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen" };
        double tileSize = 80;

        // Create the Buttons
        Button[] btn = new Button[number.length];
        for (int i = 0; i < btn.length; i++) {
            btn[i] = new Button(number[i]);
            btn[i].setMinWidth(tileSize);
            btn[i].setMaxWidth(tileSize);
            btn[i].setMinHeight(tileSize);
            btn[i].setMaxHeight(tileSize);
            btn[i].setOnAction(e -> {
                Button b = (Button) e.getSource();
                b.setDisable(true);
            });
        }

        // Create the TilePane
        TilePane tilePane = new TilePane(10, 10);
        tilePane.getChildren().addAll(btn);
        tilePane.setPadding(new Insets(10));
        tilePane.setPrefWidth(400);
        tilePane.setOrientation(Orientation.HORIZONTAL);
        // tilePane.setOrientation(Orientation.VERTICAL);

        // Create the Labels
        Label message = new Label("Click any button you like!");
        message.setAlignment(Pos.CENTER);

        // Create the Scene and show on the stage
        BorderPane pane = new BorderPane(tilePane);
        pane.setTop(message);
        pane.setPadding(new Insets(10));
        primaryStage.setScene(new Scene(pane, 400, 500));
        primaryStage.setTitle("TilePane Test");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--TilePaneTest");
    }
}
