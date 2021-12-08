// Listing 5-7: North South East West Application

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class NSEW extends Application {

    FlowPane flow;

    @Override
    public void start(Stage primaryStage) {
        // Create the buttons
        Button btnN = new Button("北");
        btnN.setOnAction(e -> putButton("北"));
        Button btnS = new Button("南");
        btnS.setOnAction(e -> putButton("南"));
        Button btnE = new Button("東");
        btnE.setOnAction(e -> putButton("東"));
        Button btnW = new Button("西");
        btnW.setOnAction(e -> putButton("西"));
        Button reset = new Button("リセット");
        reset.setOnAction(e -> flow.getChildren().clear());
        Button close = new Button("終了");
        close.setOnAction(e -> primaryStage.close());

        // Create the HBox
        Pane sp1 = new Pane();
        Pane sp2 = new Pane();
        HBox hbox = new HBox(10, reset, sp1, btnS, sp2, close);
        HBox.setHgrow(sp1, Priority.ALWAYS);
        HBox.setHgrow(sp2, Priority.ALWAYS);

        // Create the FlowPane
         flow = new FlowPane(8, 15);
         flow.setPadding(new Insets(10));
         flow.setStyle("-fx-border-color: green;");

        // Create the BorderPane
        BorderPane pane = new BorderPane(flow, btnN, btnE, hbox, btnW);
        pane.setAlignment(btnN, Pos.CENTER);
        pane.setAlignment(btnE, Pos.CENTER);
        pane.setAlignment(btnW, Pos.CENTER);

        // Show the layout
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("NSEW App");
        primaryStage.show();
    }

    public void putButton(String s) {
        flow.getChildren().add(new Button(s));
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
