package connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class ServerThread implements Runnable {

    private OutStreamsContainer outStreamsContainer;
   // private static final Logger logger = LogManager.getLogger(ServerThread.class);

    public ServerThread(OutStreamsContainer outStreamsContainer) {
        this.outStreamsContainer = outStreamsContainer;
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9091);
      //      logger.debug("start server");
            while (true){
                Socket socket = ss.accept();
                System.out.println(socket.getInetAddress().getCanonicalHostName());
                outStreamsContainer.addOutputStream(socket.getOutputStream());
                //thread for read model
       //         logger.info("new client : " + socket.getInetAddress().getHostAddress());
                new Thread(new ClientThread(socket.getInputStream(), outStreamsContainer)).start();
            }
        } catch (IOException e) {
     //       logger.error("IO ex", e);
            e.printStackTrace();
        }

    }
}