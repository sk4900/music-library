package control;

import control.Sorting.SongSorter;
import model.Playable;
import model.Song;
import java.util.ArrayList;
import java.util.HashMap;

public class SongHolder implements PlayableHolder{

    private HashMap<String, Song> songs;

    private SongSorter sorter;

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
        String[] artistID = new String[] {songs.get(guid).getAGUID()};
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

    public void setSorter(SongSorter sorter) {
        this.sorter = sorter;
    }

    public ArrayList<Playable> sortAscending() {
        ArrayList<Playable> songList = new ArrayList<>(songs.values());
        sorter.sortAscending(songList);
        return songList;
    }

    public ArrayList<Playable> sortDescending() {
        ArrayList<Playable> songList = new ArrayList<>(songs.values());
        sorter.sortDescending(songList);
        return songList;
    }

    public ArrayList<Playable> findMatches(String matchingField) {
        ArrayList<Playable> songList = new ArrayList<>(songs.values());
        return sorter.find(songList, matchingField);
    }

    public ArrayList<String> searchByName(String[] query){

        ArrayList<String> results = new ArrayList<String>();

        for (Song song : songs.values()){
            String[] songName = song.getName().split(" ");

            for (String keyword : query){
                if (keyword.equals(songName[0])){
                    results.add(song.getName());
                }
            }
        }
        return results;
    }
}
