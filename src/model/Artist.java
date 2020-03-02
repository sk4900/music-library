package model;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;

public class Artist implements Playable{
    private String guid, name, disamb;
    private ArrayList<Playable> playableCreations;

    public Artist(String id, String artistName, @Nullable String desc) {
        guid = id;
        name = artistName;
        disamb = desc;
        playableCreations = new ArrayList<>();
    }

    public void createRelations(Playable playableItem) {
        playableCreations.add(playableItem);
    }

    public String getGUID() {return guid;}

    public String getName() {return name;}

    public String toString() {
        return name + ", " + guid;
    }


}
