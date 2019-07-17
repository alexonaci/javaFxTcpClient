public class IncomingThread implements Runnable {


    public void run()
    {
        try {

            while(true)
            {
                System.out.println(Main.mainConnection.getIncomingString());
                Main.incomingStringFlag.set(true);

                if(Main.incomingStringFlag.get() == true)
                {
                    System.out.println("DEBUG flag was set to true");
                    Main.incomingStringFlag.notifyObservers();
                }
            }

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }
}