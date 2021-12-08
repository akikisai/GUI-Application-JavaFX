// Listing 6-3: Message Box

import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

public class MessageBox {

    public static void show(String message, String title) {
        Stage stage = new Stage();
        // stage.initModality(Modality.NONE);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(300);
        stage.setMinHeight(250);

        Label lbl = new Label(message);
        Button btnOK = new Button("OK");
        btnOK.setOnAction(e -> stage.close());

        VBox pane = new VBox(20, lbl, btnOK);
        pane.setPadding(new Insets(20));
        pane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
