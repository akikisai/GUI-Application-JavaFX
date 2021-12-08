// Listing 6-2:TextField Test

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.ActionEvent;

public class TextFieldTest extends Application {

    TextField tf;

    @Override
    public void start(Stage primaryStage) {
        // Create the Textfield
        tf = new TextField();
        tf.setAlignment(Pos.BASELINE_RIGHT);
        tf.setEditable(false);

        // Create Number Buttons
        Button[] btnN = new Button[10];
        for (int i = 0; i < btnN.length; i++) {
            btnN[i] = new Button(Integer.toString(i));
            btnN[i].setOnAction(e -> btnN_Click(e));
        }

        Button btnCE = new Button("CE");
        btnCE.setOnAction(e -> btnCE_Click());
        Button btnAC = new Button("AC");
        btnAC.setOnAction(e -> btnAC_Click());

        // Create the Layout
        HBox hbox1 = new HBox(5, tf, btnCE, btnAC);
        hbox1.setAlignment(Pos.CENTER);
        HBox hbox2 = new HBox(5, btnN);
        VBox vbox = new VBox(20, hbox1, hbox2);
        vbox.setPadding(new Insets(20));

        // Set the stage
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TextField Test");
        primaryStage.show();
    }

    public void btnN_Click(ActionEvent e) {
        Button b = (Button) e.getSource();
        tf.appendText(b.getText());
    }

    public void btnCE_Click() {
        int len = tf.getLength();
        if (len > 0) {
            tf.deleteText(len - 1, len);
        }
    }

    public void btnAC_Click() {
        tf.clear();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--TextFieldTest");
    }

}
