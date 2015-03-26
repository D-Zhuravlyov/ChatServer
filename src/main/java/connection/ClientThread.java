package connection;
import model.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;


public class ClientThread implements Runnable {

  //  private static final Logger logger = LogManager.getLogger(ClientThread.class);
    private InputStream inputStream;
    private OutStreamsContainer oosContainer;

    public ClientThread(InputStream inputStream, OutStreamsContainer oosContainer) {
        this.inputStream = inputStream;
        this.oosContainer = oosContainer;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            while (true) {
                Message message = (Message) objectInputStream.readObject();
       //         logger.info("get model from client");
                oosContainer.notifyAllClients(message);
            }
        } catch (IOException | ClassNotFoundException e) {
        //    logger.error("client error");
            e.printStackTrace();
        }
    }
}

