// Listing 5-2: Change Spacing

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChangeSpacing extends Application {
    
    Stage stage;
    HBox hbox;
    Button btn1, btn2, btn3, btn4;
    double space, pad, margin;
    
    @Override
    public void start(Stage primaryStage) {
        // Set the stage
        stage = primaryStage;

        // Create the buttons
        btn1 = new Button("Spacing +10");
        btn1.setOnAction(e -> setSpacing(10));
        btn2 = new Button("Padding +10");
        btn2.setOnAction(e -> setPadding(10));
        btn3 = new Button("Margin +10");
        btn3.setOnAction(e -> setMargin(10));
        btn4 = new Button("Reset");
        btn4.setOnAction(e -> reset());

        // Show 1st Layout
        hbox = new HBox(btn1, btn2, btn3, btn4);
        Scene scene = new Scene(hbox, 600, 120);
        reset();
        stage.setScene(scene);
        stage.show();
    }
    
    public void setSpacing(double param) {
        space += param;
        hbox.setSpacing(space);
        stage.setTitle("Spacing changed");
    }
    
    public void setPadding(double param) {
        pad += param;
        hbox.setPadding(new Insets(pad));
        stage.setTitle("Padding changed");
    }
    
    public void setMargin(double param) {
        margin += param;
        hbox.setMargin(btn3, new Insets(margin));
        stage.setTitle("Margin changed");
    }
    
    public void reset() {
        space = pad = margin = 0.;
        hbox.setSpacing(0);
        hbox.setPadding(new Insets(0));
        hbox.setMargin(btn3, new Insets(0));
        stage.setTitle("Default");
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
