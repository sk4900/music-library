

/**
 * Entry point to the Muze Music Library System (MMLS)
 */
public final class Application {

    /**
     * The entry point to the Muze Music Library System.
     * Connects all the components of the application together.
     * @param args expects and parses commands from the user.
     */
    public static void main(String[] args){

        if (args.length == 0){
            System.out.println("Commands expected. Refer to help file for list of commands.");
            System.exit(0);
        }

        System.out.println("You have entered command " + args[0]);
        System.exit(0);

    }
}
