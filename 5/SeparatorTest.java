// Listing 5-5: Separator Test

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeparatorTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the buttons
        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");
        Button btn4 = new Button("Button 4");
        Button btn5 = new Button("Button 5");

        // Create the separators
        Separator sepH = new Separator();
        Separator sepV = new Separator(Orientation.VERTICAL);

        // Create the hboxes
        HBox hbox1 = new HBox(10, btn1, sepV, btn2, btn3);
        HBox hbox2 = new HBox(10, btn4);
        HBox hbox3 = new HBox(10, btn5);

        // Show the layout
        VBox vbox = new VBox(20, hbox1, hbox2, sepH, hbox3);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Separator Test");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
