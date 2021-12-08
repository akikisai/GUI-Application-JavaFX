// Listing 6-5: Bank Transfer Application

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class BankTransferApp extends Application {

    TextField tfName, tfAccount, tfAmount;

    @Override
    public void start(Stage primaryStage) {
        // Create the Labels
        Label lblName = new Label("口座名義:");
        Label lblAccount = new Label("口座番号:");
        Label lblAmount = new Label("送金金額:");

        // Create the TextFields
        tfName = new TextField();
        tfName.setMinWidth(200);
        tfAccount = new TextField();
        tfAccount.setMinWidth(200);
        tfAccount.setPromptText("半角7桁の数字");
        tfAmount = new TextField();
        tfAmount.setMinWidth(200);
        tfAmount.setPromptText("カンマなしの数字");
        tfAmount.setAlignment(Pos.BASELINE_RIGHT);

        // Create the Buttons
        Button btnOK = new Button("送金する");
        btnOK.setOnAction(e -> btnOK_Click());
        Button btnReset = new Button("取り消す");
        btnReset.setOnAction(e -> btnReset_Click());

        // Create the Layout
        HBox hbName = new HBox(10, lblName, tfName);
        HBox hbAccount = new HBox(10, lblAccount, tfAccount);
        HBox hbAmount = new HBox(10, lblAmount, tfAmount);
        HBox hbButton = new HBox(10, btnOK, btnReset);
        hbButton.setAlignment(Pos.BASELINE_RIGHT);
        VBox vbox = new VBox(20, hbName, hbAccount, hbAmount, hbButton);
        vbox.setPadding(new Insets(20));

        // Set the stage
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bank Transfer App");
        primaryStage.show();
    }

    public void btnOK_Click() {
        String errMsg = "";
        if (tfName.getText().length() == 0) {
            errMsg += "口座名義が未入力です\n";
        }
        if (tfAccount.getText().length() == 0) {
            errMsg += "口座番号が未入力です\n";
        } else if (!tfAccount.getText().matches("[0-9]{7}")) {
            errMsg += "口座番号に誤りがあります\n";
        }

        int amount = 0;
        if (tfAmount.getText().length() == 0) {
            errMsg += "送金金額が未入力です\n";
        } else {
            try {
                amount = Integer.parseInt(tfAmount.getText());
            } catch (Exception e) {
            }
            if (amount <= 0) {
                errMsg += "送金金額に誤りがあります\n";
            }
        }

        if (errMsg.length() == 0) {
            String okMsg = "以下の口座に送金しました"
                    + "\n口座名義: " + tfName.getText()
                    + "\n口座番号: " + tfAccount.getText()
                    + "\n送金金額: " + String.format("%,d", amount);
            MessageBox.show(okMsg, "OK");
        } else {
            MessageBox.show(errMsg, "NG");
        }
    }

    public void btnReset_Click() {
        tfAmount.clear();
        tfAccount.clear();
        tfName.clear();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--BankTransferApp");
    }

}
