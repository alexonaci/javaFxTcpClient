import javafx.scene.control.TextArea;

public class IncomingStringObserver implements Observer {
    private TextArea textArea;

    public IncomingStringObserver(TextArea textArea) {
        this.textArea = textArea;
    }

    public void update() {
        textArea.appendText(Main.mainConnection.getIncomingString());
    }
}