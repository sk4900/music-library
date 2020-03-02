package control;

import java.util.ArrayList;

public class DatabaseCreator {

    private ArtistHolder artistHolder;
    private ReleaseHolder releaseHolder;
    private SongHolder songHolder;
    private CSVReader csvReader;

    private final String artistsFile = "artists.csv";
    private final String songsFile = "songs.csv";
    private final String releaseFile = "releases.csv";

    public DatabaseCreator(CSVReader csvReader, ArtistHolder artistHolder, ReleaseHolder releaseHolder,
                           SongHolder songHolder) {
        this.artistHolder = artistHolder;
        this.releaseHolder = releaseHolder;
        this.songHolder = songHolder;
        this.csvReader = csvReader;
    }

    public void loadDatabase() {
        fillArtistHolder();
        fillSongHolder();
    }

    private void fillArtistHolder() {
        ArrayList<String[]> artistData = csvReader.loadFile(artistsFile);

        for (String[] data : artistData) {
            artistHolder.add(data);
        }
        System.out.println("Added " + artistData.size() + " artists to the database.");
    }

    private void fillSongHolder() {
        ArrayList<String[]> songData = csvReader.loadFile(songsFile);

        for (String[] data : songData) {
            songHolder.add(data);
        }
        System.out.println("Added " + songData.size() + " song to the database.");
    }

    private void fillReleaseHolder() {
        ArrayList<String[]> releaseData = csvReader.loadFile(releaseFile);

        for (String[] data : releaseData) {
            releaseHolder.add(data);
        }
        //System.out.println("Added " + artistData.size() + " artists to the database.");
    }
}
