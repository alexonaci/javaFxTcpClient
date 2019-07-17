import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OutcomingThread implements Runnable {

    BufferedReader clientInput = new BufferedReader(new InputStreamReader((System.in)));

    public void run(){
        try{
            while (true) {

                Main.mainConnection.setOutcomingString(clientInput.readLine());
            }
        }catch(Exception Ex)
        {
            Ex.printStackTrace();
        }
    }

}