import control.*;

/**
 * Entry point to the Muze Music Library System (MMLS)
 */
public final class Application {

    private static void init() {
        CSVReader csvReader = new CSVReader();
        ArtistHolder artistHolder = new ArtistHolder();
        ReleaseHolder releaseHolder = new ReleaseHolder();
        SongHolder songHolder = new SongHolder();
        DatabaseCreator databaseCreator = new DatabaseCreator(csvReader, artistHolder, releaseHolder, songHolder);
        databaseCreator.loadDatabase();
    }

    /**
     * The entry point to the Muze Music Library System.
     * Connects all the components of the application together.
     * @param args expects and parses commands from the user.
     */
    public static void main(String[] args){
        CSVReader csvReader = new CSVReader();
        ArtistHolder artistHolder = new ArtistHolder();
        ReleaseHolder releaseHolder = new ReleaseHolder();
        SongHolder songHolder = new SongHolder();
        DatabaseCreator databaseCreator = new DatabaseCreator(csvReader, artistHolder, releaseHolder, songHolder);
        databaseCreator.loadDatabase();




        if (args.length == 0){
            System.out.println("Commands expected. Refer to help file for list of commands.");
            System.exit(0);
        }

        System.out.println("You have entered command " + args[0]);
        System.exit(0);

    }
}
