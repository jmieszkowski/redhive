package app.backend;

import java.io.IOException;
import java.net.Socket;

public class ClientStreamer {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 12345);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
