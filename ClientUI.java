import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ClientUI extends Application {

    Scene mainScene;
    TextArea textArea;
    TextArea textInput;
    Button sendButton;
    HBox inputBox;
    VBox mainBox;
    IncomingStringObserver iso;

    public void start(Stage mainStage) {

        textArea = new TextArea();
        textInput = new TextArea();
        sendButton = new Button();
        iso = new IncomingStringObserver(textArea);

        sendButton.setText("Send");

        textArea.setDisable(true);
        textArea.setMaxSize(400, 400);

        textInput.setMaxSize(400, 50);

        inputBox = new HBox(5);
        inputBox.getChildren().addAll(textInput, sendButton);
        inputBox.setAlignment(Pos.TOP_LEFT);

        mainBox = new VBox( 5);
        mainBox.setSpacing(20);
        mainBox.setPadding(new Insets(10, 10, 10, 10));
        mainBox.setAlignment(Pos.TOP_LEFT);
        mainBox.getChildren().addAll(textArea, inputBox);

        Main.incomingStringFlag.addObserver(iso);
        /*Main.incomingStringFlag.addObserver(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                textArea.appendText(Main.mainConnection.getIncomingString());
                System.out.println("DEBUG LISTENER");
                Main.incomingStringFlag.set(false);
            }
        });*/

        sendButton.setOnAction(e -> {
            Main.mainConnection.setOutcomingString(textInput.getText());
            textInput.clear();
        });


        textInput.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                Main.mainConnection.setOutcomingString(textInput.getText());
                textInput.clear();

                //textArea.appendText("DEBUG\n");
            }
        });

        mainScene = new Scene(mainBox, 500, 300);
        mainStage.setScene(mainScene);
        mainStage.setTitle("Chat Client");
        mainStage.show();
    }

}
