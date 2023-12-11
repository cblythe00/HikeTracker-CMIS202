import javafx.application.Platform;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HikeServer {

    public void server() {

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);

                Socket socket = serverSocket.accept();

                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    String fullHike = inputFromClient.readUTF();

                    outputToClient.writeChars("Received");

                    Platform.runLater(() -> {

                    });
                }
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
}
