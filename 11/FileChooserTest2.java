// Listing 10-6: FileChooser Test2

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooserTest2 extends Application {

    Label label;

    @Override
    public void start(Stage primaryStage) {
        // Create the Label
        label = new Label("No file is open.");
        label.setPadding(new Insets(10));
        label.setWrapText(true);
        label.setStyle("-fx-font-family: monospace;");

        // Create the Menu
        MenuItem menuOpen = new MenuItem("_Open");
        menuOpen.setOnAction(e -> openFile());
        MenuItem menuExit = new MenuItem("E_xit");
        menuExit.setOnAction(e -> primaryStage.close());
        Menu menuFile = new Menu("_File");
        menuFile.getItems().addAll(menuOpen, menuExit);
        MenuBar menuBar = new MenuBar(menuFile);

        // Create the pane and show the stage
        BorderPane pane = new BorderPane(label);
        pane.setTop(menuBar);
        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("File Chooser test2");
        primaryStage.show();
    }

    public void openFile() {
        // Select the file
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text files", "*.txt"));
        File file = chooser.showOpenDialog(null);

        // Show the file information
        if (file != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String msg = "";
                String line = br.readLine();
                while (line != null) {
                    msg += line + "\n";
                    line = br.readLine();
                }
                label.setText(msg);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--FileChooserTest2");
    }
}
