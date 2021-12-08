// Listing 5-4: Dynamic Spacer

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DynamicSpacer extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the buttons
        Button btn1 = new Button("Button 1");
        Button btn3 = new Button("Button 3");
        Button btn4 = new Button("Button 4");
        Button btn6 = new Button("Button 6");
        Button btn8 = new Button("Button 8");
        
        // Create the spacers
        Pane sp2 = new Pane();
        Pane sp5 = new Pane();
        Pane sp7 = new Pane();
        
        // Create the hboxes
        HBox hbox1 = new HBox(10, btn1, sp2, btn3);
        HBox hbox2 = new HBox(10, btn4, sp5, btn6, sp7, btn8);
        HBox.setHgrow(sp2, Priority.ALWAYS);
        HBox.setHgrow(sp5, Priority.ALWAYS);
        HBox.setHgrow(sp7, Priority.ALWAYS);
        
        // Show the layout
        VBox vbox = new VBox(20, hbox1, hbox2);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dynamic Spacer");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
