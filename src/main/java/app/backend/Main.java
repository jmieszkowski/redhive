package app.backend;



public class Main {
    public static void main(String[] args) {
        ClientReciver clientReciver = new ClientReciver(
                "/Users/macbookair/Desktop/snare.wav", 1);
        clientReciver.playAudio();
    }
}
