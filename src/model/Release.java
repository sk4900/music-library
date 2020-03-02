package model;

public class Release implements Playable {
    private String guid, aguid, title, medium, date;
    private String[] tracks;

    public Release(String uniqueID, String artistID, String releaseTitle, String releaseMedium, String datePublished,
                   String[] tracklistIDs) {
        guid = uniqueID;
        aguid = artistID;
        title = releaseTitle;
        medium = releaseMedium;
        date = datePublished;
        tracks = tracklistIDs;
    }

    public String getGUID() {return guid;}
}
