package control;

import control.Sorting.SorterHolder;
import model.Playable;
import model.Release;


import java.util.ArrayList;

public class DatabaseCreator {

    private ArtistHolder artistHolder;
    private ReleaseHolder releaseHolder;
    private SongHolder songHolder;
    private CSVReader csvReader;
    private SorterHolder sorterHolder;

    public static final String ARTISTSFILE = "artists.csv";
    public static final String SONGSFILE = "songs.csv";
    public static final String RELEASEFILE = "releases.csv";

    public DatabaseCreator(CSVReader csvReader, ArtistHolder artistHolder, ReleaseHolder releaseHolder,
                           SongHolder songHolder, SorterHolder sHolder) {
        this.artistHolder = artistHolder;
        this.releaseHolder = releaseHolder;
        this.songHolder = songHolder;
        this.csvReader = csvReader;
        this.sorterHolder = sHolder;
    }

    public void loadDatabase() {
        fillPlayableHolder(artistHolder, ARTISTSFILE);
        fillPlayableHolder(songHolder, SONGSFILE);
        fillPlayableHolder(releaseHolder, RELEASEFILE);
    }

    private void fillPlayableHolder(PlayableHolder holder, String filename) {
        ArrayList<String[]> playableData = csvReader.loadFile(filename);

        for (String[] data : playableData) {
            holder.add(data);
            String[] relationList = holder.getRelations(data[0]);
            if (relationList != null)
                createRelations(data[0], relationList);
        }
        System.out.println("Added " + playableData.size() + " playable elements to the database from " + filename);
    }

    private void createRelations(String guid, String[] relationList) {
        if (artistHolder.containsArtistGUID(relationList[0])){
            Playable relatedSong = songHolder.get(guid);
            artistHolder.attachPlayableToArtist(relatedSong, relationList[0]);
        } else {
            ArrayList<Playable> songList = songHolder.getSongList(relationList);
            releaseHolder.createRelations(guid, songList);
            Release currentRelease = (Release)releaseHolder.get(guid);
            artistHolder.attachPlayableToArtist(currentRelease, currentRelease.getAGUID());
        }
    }
}