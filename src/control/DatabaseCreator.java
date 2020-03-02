package control;

import model.Release;
import model.Song;

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
        fillPlayableHolder(artistHolder, artistsFile);
        fillPlayableHolder(songHolder, songsFile);
        fillPlayableHolder(releaseHolder, releaseFile);
    }

    private void fillPlayableHolder(PlayableHolder holder, String filename) {
        ArrayList<String[]> playableData = csvReader.loadFile(filename);

        for (String[] data : playableData) {
            holder.add(data);
            String[] relationList = holder.getRelations(data[0]);
            if (relationList != null)
                createRelations(data[0], relationList, filename);
        }
        System.out.println("Added " + playableData.size() + " playable elements to the database from " + filename);
    }

    private void createRelations(String guid, String[] relationList, String holderType) {
        if (artistHolder.containsArtistGUID(relationList[0])){

        }
    }
}