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
        this.library = new DatabaseCreator(csvReader, artistHolder, releaseHolder, songHolder);
    }
    private void CreateLibrary(DatabaseCreator database){
        try {
            File library = new File(filename);
            if(library.createNewFile()){
                System.out.println("Library created");
            }
            else{
                this.collection.put("", database.getPlayable(""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void writeToLibrary(Playable playable){
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(playable.getGUID() + "\n");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void eraseFromLibrary(Playable playable) throws IOException {

        File inputFile = new File(filename);
        File tempFile = new File("TempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String GUID = playable.getGUID();
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(GUID)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }

        writer.close();
        reader.close();
        inputFile.delete();
        boolean successful = tempFile.renameTo(inputFile);

    }

}
