import javafx.beans.property.BooleanProperty;

public class Main {

    public static NetworkConnection mainConnection = new NetworkConnection("127.0.0.1", 9000);
    public static BooleanObservable incomingStringFlag = new BooleanObservable(false);

    public static void main(String[] args) {

        Thread t1 = new Thread(new OutcomingThread(), "User input thread");
        Thread t2 = new Thread(new IncomingThread(), "Server response thread");

        t1.start();
        t2.start();

        ClientUI.launch(ClientUI.class);
    }
}
