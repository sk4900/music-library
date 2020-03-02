package model;

public class Song implements Playable{
    private String guid, artistguid, title;
    private int duration;

    public Song (String guid, String aguid, int duration, String title) {
        this.guid = guid;
        artistguid = aguid;
        duration = duration;
        this.title = title;
    }

    public String getGUID() {return guid;}
}
