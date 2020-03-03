package model;

public class Song implements Playable{
    private String guid, aguid, title;
    private int duration;

    public Song (String guid, String aguid, int duration, String title) {
        this.guid = guid;
        this.aguid = aguid;
        this.duration = duration;
        this.title = title;
    }

    public String getGUID() {return guid;}

    public String getName() {return title;}

    public String getAGUID() {return aguid;}

    public String toString() {
        return title + ", " + guid + ", " + aguid;
    }

    public void explore() {
        System.out.println(this.toString());
    }
}
