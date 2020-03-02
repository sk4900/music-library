package control;

import model.Playable;
import model.Release;
import model.Song;

import java.util.HashMap;

public class ReleaseHolder implements PlayableHolder {
    private HashMap<String, Release> releases;

    public ReleaseHolder() {
        releases = new HashMap<>();
    }

    public boolean add(String[] releaseData) {
       // if(releases.containsValue(releaseData[0]))
            //return false;
        //else {
            //Release newRelease = new Release()
       // }
        //return true;
    }

   // private String[] trackListCreator(String[])

    //public Playable get(String id) {
        //return releases.get(id);
   // }
}
