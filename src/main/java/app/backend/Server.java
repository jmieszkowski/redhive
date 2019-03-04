package app.backend;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends Copier{
    int receivingAudioFilePort;
    int sendingAudioFilePort;

    public Server(int receivingAudioFilePort, int sendingAudioFilePort) {
        this.receivingAudioFilePort = receivingAudioFilePort;
        this.sendingAudioFilePort = sendingAudioFilePort;
    }

    void audioFileReceive(ServerSocket serverSocket) throws IOException {

        Socket socket = serverSocket.accept();
        System.out.println("[Server] Connection with streamer established");


        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = new FileOutputStream(
                "/Users/macbookair/IdeaProjects/redhive/src/main/java/app/backend/serverFolder/wildest_dreams.wav");
        copyInputStreamToOutputStream(inputStream, outputStream);
        outputStream.close();
        inputStream.close();
    }

    void audioFileSend(ServerSocket serverSocket) throws IOException {
        Socket socket = serverSocket.accept();
        System.out.println("[Server] Connection established with receiver");
        InputStream in = new FileInputStream(
                "/Users/macbookair/IdeaProjects/redhive/src/main/java/app/backend/serverFolder/wildest_dreams.wav");
        OutputStream out = socket.getOutputStream();
        copyInputStreamToOutputStream(in, out);
        out.close();
        in.close();
    }

     private ServerSocket openSocketForStreamer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(receivingAudioFilePort);
        return serverSocket;
    }

     private ServerSocket openSocketForReceiver() throws IOException {
        ServerSocket serverSocket = new ServerSocket(sendingAudioFilePort);
        return serverSocket;
    }

    public static void main(String[] args) {
        Server server = new Server(12346,12345);

        try {
            ServerSocket serverSocket = server.openSocketForStreamer();
            server.audioFileReceive(serverSocket);
            ServerSocket serverSocket1 = server.openSocketForReceiver();
            server.audioFileSend(serverSocket1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


