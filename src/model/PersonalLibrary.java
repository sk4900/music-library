package model;
import control.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PersonalLibrary {
    private HashMap<String, Playable> collection;
    private HashMap<String, Integer> ratings;
    private ArtistHolder artists;
    private SongHolder songs;
    private ReleaseHolder releases;
    private String filename = "library.txt";

    public PersonalLibrary(ArtistHolder artists, SongHolder songs, ReleaseHolder releases) {
        this.artists = artists;
        this.songs = songs;
        this.releases = releases;
        ratings = new HashMap<>();
        collection = new HashMap<>();
        try {
            File library = new File(filename);
            if (library.createNewFile()) {
                System.out.println("Library created");
            } else {
                BufferedReader reader;
                reader = new BufferedReader(new FileReader(filename));
                String line = reader.readLine();
                while (line != null) {
                    line = reader.readLine();
                    this.collection.put(line, searchGUID(line));
                }
                reader.close();
                this.collection.forEach((k, v) -> this.ratings.put(k, 0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Playable playable) {
        if (!collection.containsKey(playable)) {
            collection.put(playable.getGUID(), playable);
            ratings.put(playable.getGUID(), 0);
            try {
                FileWriter myWriter = new FileWriter(filename);
                myWriter.write(playable.getGUID() + "\n");
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Song/Release is already in your library.");
        }
    }

    public boolean remove(Playable playable) throws IOException {
        String GUID = playable.getGUID();
        if (collection.remove(GUID, playable)) {
            ratings.remove(GUID);
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
        } else {
            System.out.println("Song/Release is currently not in your library.");
            return false;
        }
    }

    public Playable searchGUID(String GUID) {
        Playable searchResult;
        if (songs.get(GUID) != null) {
            searchResult = songs.get(GUID);
        } else {
            searchResult = releases.get(GUID);
        }
        return searchResult;
    }
    public void rateSong(int rating, Playable playable) {
        ratings.put(playable.getGUID(), rating);
        try {

            File inputFile = new File(filename);
            File tempFile = new File("TempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(playable.getGUID())) {
                    currentLine = currentLine.concat(", " + rating);
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
            System.out.println(playable.getName() + " has been rated " + rating);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void rateRelease(Playable playable){
        Release release = (Release) collection.get(playable.getGUID());
        ArrayList<Playable> songs = release.getTrackList();
        int numberSongs = songs.size();
        int totalRatings = 0;
        for (Playable song: songs) {
            String sguid = song.getGUID();
            totalRatings += ratings.get(sguid);
        }
        int avRating = totalRatings = totalRatings / numberSongs;
        ratings.put(playable.getGUID(), avRating);
    }
}
