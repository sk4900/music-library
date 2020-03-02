package model;

import java.util.ArrayList;

public class Release implements Playable {

    private ArrayList<Playable> songs;
    private String guid, aguid, title, medium, date;

    public Release(String uniqueID, String artistID, String releaseTitle, String releaseMedium, String datePublished) {
        guid = uniqueID;
        aguid = artistID;
        title = releaseTitle;
        medium = releaseMedium;
        date = datePublished;
    }

    public void addTrackList(ArrayList<Playable> songs) {
        this.songs = songs;
    }

    public String getGUID() {return guid;}

    public String getName() {return title;}
}
