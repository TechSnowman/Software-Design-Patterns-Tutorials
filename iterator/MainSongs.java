package iterator;

import java.util.ArrayList;
import java.util.List;

interface SongIterator {
	boolean hasNext();
	Song next();
}


class PlaylistIterator implements SongIterator {
	private List<Song> songs;
	private int position = 0;
	public PlaylistIterator(List<Song> songs) {
		this.songs = songs;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return position < songs.size();
	}

	@Override
	public Song next() {
		// TODO Auto-generated method stub
		return hasNext() ? songs.get(position++) : null;
	}
}


interface PlaylistCollection {
	SongIterator createIterator();
}

class Playlist implements PlaylistCollection {
	private List<Song> songs = new ArrayList<>();
	
	public void addSongs(Song song) {
		songs.add(song);
	}
	
	@Override
	public SongIterator createIterator() {
		// TODO Auto-generated method stub
		return new PlaylistIterator(songs);
	}

}

class Song {
	private String title;
	public Song(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
}

public class MainSongs {
	public static void main(String[] args) {
		Song song1 = new Song("Shape of You");
		Song song2 = new Song("Blinding Lights");
		Song song3 = new Song("Imagine");

		Playlist playlist = new Playlist();
		playlist.addSongs(song1);
		playlist.addSongs(song2);
		playlist.addSongs(song3);
		
		 SongIterator iterator = playlist.createIterator();

	        System.out.println("Iterating through the playlist:");
	        while (iterator.hasNext()) {
	            System.out.println("Song: " + iterator.next().getTitle());
	        }
		
	}
	
}
