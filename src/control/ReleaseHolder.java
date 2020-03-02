package control;

import model.Playable;
import model.Release;
import model.Song;

import java.util.Arrays;
import java.util.HashMap;

public class ReleaseHolder implements PlayableHolder {
    private HashMap<String, Release> releases;

    public ReleaseHolder() {
        releases = new HashMap<>();
    }

    public boolean add(String[] releaseData) {
        if(releases.containsKey(releaseData[0]))
            return false;
        else {
            String[] trackList = Arrays.copyOfRange(releaseData, 5, releaseData.length - 1);
            Release newRelease = new Release(releaseData[0], releaseData[1], releaseData[2], releaseData[3],
                    releaseData[4], trackList);
            releases.put(releaseData[0], newRelease);
        }
        return true;
    }

    public Playable get(String id) {
        return releases.get(id);
   }
}
