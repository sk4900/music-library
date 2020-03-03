package model;

import java.util.ArrayList;

public class Artist implements Playable{
    private String guid, name, disamb;
    private ArrayList<Playable> playableCreations;

    public Artist(String id, String artistName, String desc) {
        guid = id;
        name = artistName;
        if (desc != null)
            disamb = desc;
        else
            disamb = "";
        playableCreations = new ArrayList<>();
    }

    private void removeOverlaps(ArrayList<Playable> songList) {
        for (Playable song : songList) {
            playableCreations.remove(song);
        }
    }

    public void createRelations(Playable playableItem) {
        playableCreations.add(playableItem);
        if (playableItem instanceof Release) {
            removeOverlaps(((Release) playableItem).getTrackList());
        }

    }

    public int getDuration() {
        int total = 0;
        for (Playable creat : playableCreations) {
           total += creat.getDuration();
        }
        return total;
    }

    public String getGUID() {return guid;}

    public String getName() {return name;}

    public String toString() {

        return name + ", " + guid + ", " + disamb;
    }

    public void explore () {
        System.out.println(this.toString());
        for (Playable creat : playableCreations) {
            creat.explore();
        }
    }


}
