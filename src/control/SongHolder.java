package control;

import model.Playable;
import model.Song;

import java.util.ArrayList;
import java.util.HashMap;

public class SongHolder implements PlayableHolder{

    private HashMap<String, Song> songs;

    public SongHolder() {
        songs = new HashMap<>();
    }

    public boolean add(String[] songData) {
        if(songs.containsKey(songData[0]))
            return false;
        else {
            Song newSong = new Song(songData[0], songData[1], Integer.valueOf(songData[2]), songData[3]);
            songs.put(songData[0], newSong);
        }
        return true;
    }

    public String[] getRelations(String guid) {
        String[] artistID = new String[] {songs.get(guid).getArtistGUID()};
        return artistID;
    }

    public ArrayList<Playable> getSongList (String[] trackList) {
        ArrayList<Playable> songList = new ArrayList<>();

        for (String currentTrack : trackList) {
            songList.add(songs.get(currentTrack));
        }
        return songList;
    }

    public Playable get(String id) {
        return songs.get(id);
    }
}
