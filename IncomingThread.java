public class IncomingThread implements Runnable {


    public void run()
    {
        try {

            while(true)
            {
                System.out.println(Main.mainConnection.getIncomingString());
                Main.incomingStringFlag.setValue(true);

                if(Main.incomingStringFlag.getValue() == true)
                {
                    System.out.println("DEBUG flag was set to true");
                }
            }

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }
}