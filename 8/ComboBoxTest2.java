// Listing 8-5 ComboBox Test2

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.collections.FXCollections;

public class ComboBoxTest2 extends Application {

    Label answer;
    ComboBox<Pokemon> combo;

    @Override
    public void start(Stage primaryStage) {
        // Create the Label
        answer = new Label();

        // Create the ComboBox
        PokemonCenter center = new PokemonCenter();
        combo = new ComboBox<>();
        combo.getItems().addAll(FXCollections.observableArrayList(
                center.getPokemons()));
        combo.setPromptText("ポケモンを選んでね");
        combo.setOnAction(e -> showSelected());

        // Create the Scene and Show on the stage
        HBox hbox = new HBox(combo);
        hbox.setAlignment(Pos.CENTER);
        BorderPane pane = new BorderPane();
        pane.setTop(hbox);
        pane.setCenter(answer);
        primaryStage.setScene(new Scene(pane, 500, 200));
        primaryStage.setTitle("ComboBox Test2");
        primaryStage.show();
    }

    public void showSelected() {
        Pokemon pokemon = combo.getValue();
        if (pokemon != null) {
            String data = "番号: " + pokemon.getNo();
            data += "\n名前: " + pokemon.getName();
            data += "\n説明: " + pokemon.getDescription();
            data += "\n進化前: " + pokemon.getBefore();
            data += "\n進化後: " + pokemon.getAfter();
            answer.setText(data);
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--ComboBoxTest2");
    }

}
