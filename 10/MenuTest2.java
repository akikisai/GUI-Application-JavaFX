// Listing 10-2: Menu test2

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class MenuTest2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Labels
        Label message = new Label("No menu is selected.");

        // Create the File menu
        MenuItem itemOpen = new MenuItem("開く(_O)");
        MenuItem itemClose = new MenuItem("閉じる(_C)");
        itemOpen.setOnAction(e -> {
            message.setText("ファイル(_F) / 開く(_O) is selected.");
            itemOpen.setDisable(true);
            itemClose.setDisable(false);
        });
        itemClose.setOnAction(e -> {
            message.setText("ファイル(_F) / 閉じる(_C) is selected.");
            itemClose.setDisable(true);
            itemOpen.setDisable(false);
        });
        itemClose.setDisable(true);

        MenuItem itemExit = new MenuItem("終了(_X)");
        itemExit.setOnAction(e -> primaryStage.close());
        MenuItem itemPrint = new MenuItem("印刷(_P)");
        itemPrint.setOnAction(e
                -> message.setText("ファイル(_F) / 印刷(_P) is selected."));
        SeparatorMenuItem separator1 = new SeparatorMenuItem();
        SeparatorMenuItem separator2 = new SeparatorMenuItem();
        Menu menuFile = new Menu("ファイル(_F)");
        menuFile.getItems().addAll(itemOpen, itemClose, separator1,
                itemPrint, separator2, itemExit);

        // Create the other menus
        Menu menuEdit = new Menu("編集(_E)");
        Menu menuView = new Menu("表示(_V)");
        Menu menuHelp = new Menu("ヘルプ(_H)");

        // Create the MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView, menuHelp);

        // Create the Scene and show on the stage
        BorderPane pane = new BorderPane(message);
        pane.setTop(menuBar);
        primaryStage.setScene(new Scene(pane, 400, 300));
        primaryStage.setTitle("Menu test2");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--MenuTest2");
    }

}
