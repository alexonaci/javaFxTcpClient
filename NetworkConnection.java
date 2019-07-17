import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkConnection {

    private BufferedReader fromServer;
    private PrintWriter toServer;

    private Socket clientSock;

    public NetworkConnection(String address, int port){

        try{

            clientSock = new Socket(address, port);

            fromServer = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
            toServer = new PrintWriter(clientSock.getOutputStream());

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public String getIncomingString(){

        String temp = "";

        try{

            temp = fromServer.readLine();

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return temp;

    }

    public void setOutcomingString(String input){

        toServer.print(input);
        toServer.flush();
    }





}
