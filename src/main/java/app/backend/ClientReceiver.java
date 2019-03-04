package app.backend;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;
import java.net.Socket;


public class ClientReceiver extends Copier {


    void getAudioFile() throws IOException {
        String filePath = "/Users/macbookair/IdeaProjects/redhive/src/main/java/app/backend/clientReceiverFolder/wildest_dreams.wav";
        Socket socket = new Socket("127.0.0.1", 12345);
        InputStream in = socket.getInputStream();

        System.out.println("[ClientReceiver] Starting file copying");
        OutputStream out = new FileOutputStream(filePath);
        copyInputStreamToOutputStream(in, out);
        out.close();
        in.close();


        playAudio(filePath);


    }

    static void playAudio(String filePath) {
        File audioFile = new File(filePath);

        if (audioFile.exists()) {
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);

                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);

                JOptionPane.showMessageDialog(null, "Close");

            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("file does not exist");
        }

    }

    public static void main(String[] args) {

        ClientReceiver clientReceiver = new ClientReceiver();

        try {
            clientReceiver.getAudioFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

