package control;

import model.Playable;
import model.Release;
import model.Song;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReleaseHolder implements PlayableHolder {
    private HashMap<String, Release> releases;
    private String[] currentTrackList;

    public ReleaseHolder() {
        releases = new HashMap<>();
        currentTrackList = null;
    }

    public boolean add(String[] releaseData) {
        if(releases.containsKey(releaseData[0]))
            return false;
        else {
            currentTrackList = Arrays.copyOfRange(releaseData, 5, releaseData.length - 1);
            Release newRelease = new Release(releaseData[0], releaseData[1], releaseData[2], releaseData[3],
                    releaseData[4]);
            releases.put(releaseData[0], newRelease);
        }
        return true;
    }

    public void createRelations(String guid, ArrayList<Playable> songList) {
        releases.get(guid).addTrackList(songList);
    }

    public String[] getRelations(String guid) {
        String[] trackList = currentTrackList.clone();
        currentTrackList = null;
        return trackList;
    }

    public Playable get(String id) {
        return releases.get(id);
   }
}
