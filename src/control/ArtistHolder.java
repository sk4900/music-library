package control;

import model.Artist;
import model.Playable;

import java.util.HashMap;

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

    public Playable get(String id) {
        return artists.get(id);
    }

}
