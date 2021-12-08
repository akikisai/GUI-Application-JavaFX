// Listing 7-2: ObservableList test

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ObservableListTest extends Application {

    HBox hbox;

    @Override
    public void start(Stage primaryStage) {
        // Create the controls
        Label label = new Label("This is a label.");
        TextField tf = new TextField("This is a text-field.");
        Button button = new Button("Click me!");
        button.setOnAction(e -> showInfo());

        // Create the Scene and Show on the stage
        hbox = new HBox();
        hbox.getChildren().addAll(label, tf, button);
        primaryStage.setScene(new Scene(hbox, 400, 100));
        primaryStage.setTitle("ObservableList test");
        primaryStage.show();
    }

    public void showInfo() {
        ObservableList<Node> list = hbox.getChildren();
        String msg = "\n-- Size of the ObservableList: " + list.size();
        for (Node node : list) {
            if (node instanceof Button) {
                msg += "\nButton class";
                msg += "\n  getText(): " + ((Button) node).getText();
                msg += "\n  getWidth(): " + ((Button) node).getWidth();
            } else if (node instanceof Label) {
                msg += "\nLabel class";
                msg += "\n  getText(): " + ((Label) node).getText();
                msg += "\n  getWidth(): " + ((Label) node).getWidth();
            } else if (node instanceof TextField) {
                msg += "\nTextField class";
                msg += "\n  getText(): " + ((TextField) node).getText();
                msg += "\n  getWidth(): " + ((TextField) node).getWidth();
            } else {
                msg += "\n" + node.getClass().getSimpleName() + " class";
            }
        }
        System.out.println(msg);
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--ObservableListTest");
    }

}
