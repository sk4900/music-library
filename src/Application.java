import control.*;
import control.Sorting.PlayableSorter;
import control.Sorting.SongSortByAGUID;
import control.Sorting.SongSorter;
import control.Sorting.SorterHolder;
import model.Artist;
import model.Playable;
import model.Song;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Entry point to the Muze Music Library System (MMLS)
 */
public final class Application {

    private static SongHolder songHolder;
    private static SorterHolder sorterHolder;
    private static ArtistHolder artistHolder;

    private static void initDatabase() {
        CSVReader csvReader = new CSVReader();
        artistHolder = new ArtistHolder();
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
        /*initDatabase();
        SongSorter nameSort =  (SongSorter)Application.sorterHolder.getSorter("song", "name");
        SongSorter guidSort = (SongSorter)Application.sorterHolder.getSorter("song", "guid");
        SongSorter aguidSort = (SongSorter)Application.sorterHolder.getSorter("song", "aguid");

        Artist imogen = (Artist)artistHolder.get("328d146c-79f1-4eb6-9e40-8ee5710c14e5");
        imogen.explore();*/

        System.out.println("Welcome to the Muze Musical System. Please enter your commands.");
        System.out.println("Enter help for a list of commands.");
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        while(true){
            String command = scanner.nextLine();

            if (command.equals("help")){
                System.out.println("exit: exits the program");
                System.out.println();
                System.out.println("search_artist *:");
                System.out.println("search for an artist by their *name (one or more words).");
                System.out.println();
                System.out.println("search_songs *(title, artist, longer, shorter) **:");
                System.out.println("search for a song by its artist, title, or duration.");
                System.out.println();
                System.out.println("search_releases *(title, artist, track, release_range) **:");
                System.out.println("search for a release by its name, the name of its artist, " +
                        "the name of a track in the release, or the date range of the release's release.");

                System.out.println();
                System.out.println("add *song/release *name *date");
                System.out.println("Add a song or release to your personal library by specifying its name. Date of acquisition is optional.");

                System.out.println();
                System.out.println("remove *song/release *name:");
                System.out.println("Remove a song or release from your persona library by specifying its name.");
            }

            if (command.equals("exit")){break;}
        }

        /*songHolder.setSorter(nameSort);
        ArrayList<Playable> songs = songHolder.findMatches("A");

        for (Playable song : songs) {
            System.out.println(song);
        }*/



        /*if (args.length == 0){
            System.out.println("Commands expected. Refer to help file for list of commands.");
            System.exit(0);
        }*/

        //System.out.println("You have entered command " + args[0]);
        System.exit(0);

    }
}
