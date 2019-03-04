package app.backend;


import java.io.*;
import java.net.Socket;

public class ClientStreamer extends Copier {

    void sendAudioFile() {
        Socket socket = null;
        try {
            socket = connectToServer();
            InputStream in = new FileInputStream(
                    "/Users/macbookair/IdeaProjects/redhive/src/main/java/app/backend/clientStreamerFolder/wildest_dreams.wav");
            OutputStream out = socket.getOutputStream();

            copyInputStreamToOutputStream(in, out);
            System.out.println("[ClientStreamer] Sending file to server has finished");

            out.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    static Socket connectToServer() throws IOException {
        Socket socket = new Socket("127.0.0.1", 12346);
        return socket;
    }

    public static void main(String[] args) {
        ClientStreamer clientStreamer = new ClientStreamer();
        clientStreamer.sendAudioFile();
    }


}
