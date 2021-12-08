// Listing 5-1: Change Layout

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChangeLayout extends Application {

    Stage stage;
    Scene scene;
    Button btn1, btn2, btn3, btn4, btn5;
    int n = 1;

    @Override
    public void start(Stage primaryStage) {
        // Set the stage
        stage = primaryStage;

        // Create the buttons
        btn1 = new Button("Show Next");
        btn1.setOnAction(e -> showLayout());
        btn2 = new Button("Button two");
        btn3 = new Button("Button three");
        btn4 = new Button("Button four");
        btn5 = new Button("Button five");

        // Show 1st Layout
        showLayout();
        stage.show();
    }

    public void showLayout() {
        switch (n++) {
            case 1: // HBox Layout
                HBox pane1 = new HBox(10, btn1, btn2, btn3, btn4, btn5);
                scene = new Scene(pane1, 600, 100);
                stage.setTitle("HBox");
                break;
            case 2: // VBox Layout
                VBox pane2 = new VBox(10, btn1, btn2, btn3, btn4, btn5);
                scene = new Scene(pane2, 300, 300);
                stage.setTitle("VBox");
                break;
            case 3: // FlowPane Layout
                FlowPane pane3 = new FlowPane(10, 10, btn1, btn2, btn3, btn4, btn5);
                scene = new Scene(pane3, 300, 300);
                stage.setTitle("FlowPane");
                break;
            default: // BorderPane layout
                BorderPane pane4 = new BorderPane(btn1, btn2, btn3, btn4, btn5);
                scene = new Scene(pane4, 400, 200);
                stage.setTitle("BorderPane");
                n = 1;
                break;
        }
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
