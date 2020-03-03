import control.*;
import control.Sorting.PlayableSorter;
import control.Sorting.SongSortByAGUID;
import control.Sorting.SongSorter;
import control.Sorting.SorterHolder;
import model.Artist;
import model.Playable;
import model.Song;

import java.util.ArrayList;
import java.util.Arrays;
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
        initDatabase();

        SongSorter nameSort =  (SongSorter)Application.sorterHolder.getSorter("song", "name");
        SongSorter guidSort = (SongSorter)Application.sorterHolder.getSorter("song", "guid");
        SongSorter aguidSort = (SongSorter)Application.sorterHolder.getSorter("song", "aguid");

        Artist imogen = (Artist)artistHolder.get("7746d775-9550-4360-b8d5-c37bd448ce01");
        songHolder.setSorter(nameSort);
        ArrayList<Playable> songs = songHolder.findMatches("The");

        imogen.explore();

        System.out.println("Welcome to the Muze Musical System. Please enter your commands.");
        System.out.println("Enter help for a list of commands.");
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        while(true){
            String command = scanner.nextLine();
            String[] array = command.split(" ");

            if (array[0].equals("help")){
                System.out.println("exit: exits the program");

                System.out.println();
                System.out.println("search_artists *:");
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

                System.out.println();
                System.out.println("rate *song *stars:");
                System.out.println("Rate a song by specifying its name followed by a number from 1-5.");

                System.out.println();
                System.out.println("browse:");
                System.out.println("Browse your personal library. Lists all the artists in your library alphabetically, " +
                        "then all of their songs in your library.");

                System.out.println();
                System.out.println("explore *(artist/release name):");
                System.out.println("Only accessible while browsing your library. Allows you to first explore all songs and releases" +
                        "by a single artist, then all songs in one of their releases.");

                System.out.println();
                System.out.println("back:");
                System.out.println("Only accessible while exploring an artist's release. Returns you to the artist's page.");

                System.out.println();
            }

            if (array[0].equals("exit")){break;}

            if (array[0].equals("search_artists")){

                int end = array.length;

                String[] slice = Arrays.copyOfRange(array, 1, end);

                ArrayList<String> result = artistHolder.searchArtists(slice);

                if (result.size() == 0) {
                    System.out.println("Sorry, no artists matched your query.");
                    System.out.println();
                }

                else {
                    System.out.println("Search Results: ");

                    for (String name : result) {
                        System.out.println(name);
                    }
                    System.out.println();
                }
            }

            if (array[0].equals("search_songs")){

                int len = array.length;
                String[] slice = Arrays.copyOfRange(array, 2, len);

                if(array[1].equals("artist")){

                }

                else if(array[1].equals("title")) {

                    System.out.println(slice[0]);
                    ArrayList<String> result = songHolder.searchByName(slice);

                    songHolder.setSorter(nameSort);
                    ArrayList<Playable> results = songHolder.findMatches(slice[0]);

                    for (Playable item : results){
                        System.out.println(item.getName());
                    }

                    /*
                    if (result.size() == 0) {
                        System.out.println("Sorry, no songs matched your query.");
                        System.out.println();
                    }

                    else {
                        System.out.println("Search Results: ");

                        for (String name : result) {
                            System.out.println(name);
                        }
                        System.out.println();
                    }
*/

                }

                else if(array[1].equals("longer")){

                }

                else if(array[1].equals("shorter")){

                }
            }

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
