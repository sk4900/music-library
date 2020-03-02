package control;

import model.Artist;
import model.Playable;
import model.Song;

import java.util.HashMap;

public class SongHolder implements PlayableHolder{

    private HashMap<String, Song> songs;

    public SongHolder() {
        songs = new HashMap<>();
    }

    public boolean add(String[] songData) {
        if(songs.containsValue(songData[0]))
            return false;
        else {
            Song newSong = new Song(songData[0], songData[1], Integer.valueOf(songData[2]), songData[3]);
            songs.put(songData[0], newSong);
        }
        return true;
    }

    public Playable get(String id) {
        return songs.get(id);
    }
}
