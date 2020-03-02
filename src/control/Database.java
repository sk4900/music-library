package control;

import model.Release;

import java.util.ArrayList;

public class Database {
    private SongHolder songHolder;
    private ArtistHolder artistHolder;
    private ReleaseHolder releaseHolder;

    public Database(SongHolder songBank, ArtistHolder artistBank, ReleaseHolder releaseBank) {
        songHolder = songBank;
        artistHolder = artistBank;
        releaseHolder = releaseBank;
    }

    private void initRelations() {
       // ArrayList<Release> releases = releaseHolder.getReleases();

      // for (Release album : releases) {

       // }
    }

    private void initReleaseRelations() {

    }
}
