package app.backend;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;


public class ClientReciver {
    String filePath;
    private final int ID;

    public ClientReciver(String filePath, int ID) {
        this.filePath = filePath;
        this.ID = ID;
    }

    void playAudio(){
    File audioFile = new File(filePath);

    if (audioFile.exists()){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            JOptionPane.showMessageDialog(null,"Close");

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }else{
        System.out.println("file does not exist");
    }

    }

}

