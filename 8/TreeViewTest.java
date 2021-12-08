// Listing 8-7 TreeView Test

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.collections.*;
import java.util.*;

public class TreeViewTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Label
        Label question = new Label("お好きな駅はどれですか？");
        Label answer = new Label();

        // Create the TreeView
        String[] stationY = {"東京", "神田", "秋葉原", "御徒町", "上野", "鶯谷"};
        TreeItem<String> treeY = new TreeItem<>("山手線");
        for (String s : stationY) {
            treeY.getChildren().add(new TreeItem<>(s));
        }
        String[] stationJ = {"上野", "日暮里", "三河島", "南千住", "北千住"};
        TreeItem<String> treeJ = new TreeItem<>("常磐線");
        for (String s : stationJ) {
            treeJ.getChildren().add(new TreeItem<>(s));
        }
        TreeItem<String> root = new TreeItem<>("JR線");
        root.getChildren().add(treeY);
        root.getChildren().add(treeJ);

        TreeView<String> treeView = new TreeView<>(root);
        treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        treeView.setShowRoot(false);

        // Craete the Button
        Button button = new Button("OK");
        button.setOnAction(e -> {
            ObservableList<TreeItem<String>> ol
                    = treeView.getSelectionModel().getSelectedItems();
            ArrayList<String> al = new ArrayList<>();
            for (TreeItem<String> item : ol) {
                if (item.isLeaf()) {
                    al.add(item.getParent().getValue() + ":" + item.getValue());
                }
            }
            answer.setText("選択したのは " + al);
        });

        // Create the Scene and Show on the stage
        HBox hbox = new HBox(10, treeView, button);
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(20, question, hbox, answer);
        vbox.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(vbox, 300, 300));
        primaryStage.setTitle("TreeView Test");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--TreeViewTest");
    }

}
