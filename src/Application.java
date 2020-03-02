import control.*;
import control.Sorting.PlayableSorter;
import control.Sorting.SongSortByAGUID;
import control.Sorting.SongSorter;
import control.Sorting.SorterHolder;
import model.Playable;
import model.Song;

import java.util.ArrayList;

/**
 * Entry point to the Muze Music Library System (MMLS)
 */
public final class Application {

    private static SongHolder songHolder;
    private static SorterHolder sorterHolder;

    private static void initDatabase() {
        CSVReader csvReader = new CSVReader();
        ArtistHolder artistHolder = new ArtistHolder();
        ReleaseHolder releaseHolder = new ReleaseHolder();
        Application.songHolder = new SongHolder();
        Application.sorterHolder = new SorterHolder();
        DatabaseCreator databaseCreator = new DatabaseCreator(csvReader, artistHolder, releaseHolder, songHolder, sorterHolder);
        databaseCreator.loadDatabase();
    }

    /**
     * The entry point to the Muze Music Library System.
     * Connects all the components of the application together.
     * @param args expects and parses commands from the user.
     */
    public static void main(String[] args){
        initDatabase();
        SongSorter nameSort =  (SongSorter)Application.sorterHolder.getSorter("song", "name");
        SongSorter guidSort = (SongSorter)Application.sorterHolder.getSorter("song", "guid");
        SongSorter aguidSort = (SongSorter)Application.sorterHolder.getSorter("song", "aguid");

        songHolder.setSorter(nameSort);
        ArrayList<Playable> songs = songHolder.findMatches("A");

        for (Playable song : songs) {
            System.out.println(song);
        }

        /*if (args.length == 0){
            System.out.println("Commands expected. Refer to help file for list of commands.");
            System.exit(0);
        }*/

        //System.out.println("You have entered command " + args[0]);
        System.exit(0);

    }
}
