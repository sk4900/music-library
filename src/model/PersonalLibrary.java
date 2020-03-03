package model;
import control.*;

import java.io.*;
import java.util.HashMap;

public class PersonalLibrary {
    private HashMap<String, Playable> collection;
    private DatabaseCreator library;

    private String filename = "library.txt";

    public PersonalLibrary(){
        CSVReader csvReader = new CSVReader();
        ArtistHolder artistHolder = new ArtistHolder();
        ReleaseHolder releaseHolder = new ReleaseHolder();
        SongHolder songHolder = new SongHolder();
        //this.library = new DatabaseCreator(csvReader, artistHolder, releaseHolder, songHolder);
    }
    private void CreateLibrary(DatabaseCreator database){
        try {
            File library = new File(filename);
            if(library.createNewFile()){
                System.out.println("Library created");
            }
            else{
                BufferedReader reader;
                reader = new BufferedReader(new FileReader(filename));
                String line = reader.readLine();
                while (line != null) {
                    line = reader.readLine();
                    //this.collection.put(line, database.getPlayable(line));
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void writeToLibrary(Playable playable){
        if (!collection.containsKey(playable)) {
            collection.put(playable.getGUID(), playable);
            try {
                FileWriter myWriter = new FileWriter("filename.txt");
                myWriter.write(playable.getGUID() + "\n");
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Song/Release is already in your library.");
        }
    }
    private boolean eraseFromLibrary(Playable playable) throws IOException {
        String GUID = playable.getGUID();
        if (collection.remove(GUID, playable)) {
            File inputFile = new File(filename);
            File tempFile = new File("TempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(GUID)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();
            inputFile.delete();
            return tempFile.renameTo(inputFile);
        }
        else{
            System.out.println("Song/Release is currently not in your library.");
            return false;
        }
    }

}
