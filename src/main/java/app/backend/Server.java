package app.backend;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            Socket s = serverSocket.accept();
            System.out.println("Client connected");



        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    
}
