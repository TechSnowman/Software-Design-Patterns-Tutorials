package adapter;

import java.util.*;

// The old media player that only supports MP3
interface MediaPlayer {
    void play(String fileType, String fileName);
}

// Concrete class implementing old media player
class MP3Player implements MediaPlayer {
    @Override
    public void play(String fileType, String fileName) {
        if (fileType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else {
            System.out.println("Invalid file format for MP3Player: " + fileName);
        }
    }
}

// New advanced media player that supports MP4 and VLC
interface AdvancedMediaPlayer {
    void playMP4(String fileName);
    void playVLC(String fileName);
}

// Concrete class for MP4 player
class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void playMP4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }

    @Override
    public void playVLC(String fileName) {
        // Do nothing
    }
}

// Concrete class for VLC player
class VLCPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMP4(String fileName) {
        // Do nothing
    }

    @Override
    public void playVLC(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
}

// Adapter that allows the old MediaPlayer to work with AdvancedMediaPlayer
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String fileType) {
        if (fileType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new MP4Player();
        } else if (fileType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VLCPlayer();
        }
    }

    @Override
    public void play(String fileType, String fileName) {
        if (advancedMediaPlayer == null) {
            System.out.println("Invalid file format: " + fileName);
            return;
        }
        if (fileType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMP4(fileName);
        } else if (fileType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVLC(fileName);
        }
    }
}

// Modify the MP3 Player to Use the Adapter
class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String fileType, String fileName) {
        if (fileType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else if (fileType.equalsIgnoreCase("mp4") || fileType.equalsIgnoreCase("vlc")) {
            mediaAdapter = new MediaAdapter(fileType);
            mediaAdapter.play(fileType, fileName);
        } else {
            System.out.println("Invalid file format: " + fileName);
        }
    }
}

// Main class to test the adapter pattern
public class MainMedia {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");  // Old MP3 player
        player.play("mp4", "movie.mp4"); // Uses adapter for MP4
        player.play("vlc", "video.vlc"); // Uses adapter for VLC
        player.play("pdf", "document.pdf"); // Invalid format
    }
}
