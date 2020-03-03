package control;

import control.Sorting.SongSortByName;
import control.Sorting.SongSorter;
import model.Artist;
import model.Playable;
import util.QuickSort;

import java.lang.reflect.Array;
import java.util.*;

public class ArtistHolder implements PlayableHolder {
    private HashMap<String, Artist> artists;

    public ArtistHolder() {
        artists = new HashMap<>();
    }

    public boolean add(String[] artistData) {
        if(artists.containsKey(artistData[0]))
            return false;
        else {
            Artist newArtist;
            if (artistData.length == 3)
                newArtist = new Artist(artistData[0], artistData[1], artistData[2]);
            else
                newArtist = new Artist(artistData[0], artistData[1], null);
            artists.put(artistData[0], newArtist);
        }
        return true;
    }

    public void attachPlayableToArtist(Playable playableItem, String guid) {
        Artist currentArtist = artists.get(guid);
        currentArtist.createRelations(playableItem);
    }


    public boolean containsArtistGUID(String guid) {
        return artists.containsKey(guid);
    }

    public String[] getRelations(String guid){
        return null;
    }

    public Playable get(String id) {
        return artists.get(id);
    }

    public ArrayList<String> searchArtists(String[] name){

        ArrayList<String> results = new ArrayList<String>();

        for (Artist artist : artists.values()){
            String[] artistName = artist.getName().split(" ");
            for (String keyword : name){
                if (keyword.equals(artistName[0])){
                    results.add(artist.getName());
                }
            }
        }

        return results;
    }

    public String NameToID(String[] name){

        String testName = name[0];

        if (name.length == 1) {
            for (Artist person : artists.values()) {
                if (person.getName().equals(name[0])) {
                    return person.getGUID();
                }
            }
        }

        else {
            for (Artist person : artists.values()){
                if (Arrays.equals(person.getName().split(" "), name)){
                    System.out.println("YAHOO");
                    return person.getGUID();
                }
            }
        }

        return null;
    }

}
