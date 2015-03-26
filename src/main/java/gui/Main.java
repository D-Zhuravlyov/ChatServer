package gui;

import connection.OutStreamsContainer;
import connection.ServerThread;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.OutputStream;
import java.util.LinkedList;

public class Main extends Application {


    @Override
    public void start(final Stage stage) throws Exception {
        FXMLLoader f = new FXMLLoader();
        final Parent fxmlRoot = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        stage.setScene(new Scene(fxmlRoot));
        stage.setTitle("Chat server");
        stage.setResizable(false);
        stage.show();

        //this method to be extended for saving history before exit
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(1);
            }
        });
    }




    public static void main(String[] args) {

        {
            OutStreamsContainer oosContainer = new OutStreamsContainer(new LinkedList<OutputStream>());
            new Thread(new ServerThread(oosContainer)).start();

        }

        Application.launch(Main.class, args);

    }
}
