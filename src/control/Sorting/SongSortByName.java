package control.Sorting;

import model.Playable;
import model.Song;
import util.QuickSort;

import java.util.ArrayList;

public class SongSortByName extends SongSorter {

    private final QuickSort quickSort;

    public SongSortByName (QuickSort quickSort){
        this.quickSort = quickSort;
    }

    @Override
    public void sortAscending(ArrayList<Playable> songs) {
        super.sortAscending(songs, this, quickSort);
    }

    @Override
    public void sortDescending(ArrayList<Playable> songs) {
        super.sortDescending(songs, this, quickSort);
    }

    public ArrayList<Playable> find(ArrayList<Playable> songs, String parameter) {
        ArrayList<Playable> matches = new ArrayList<>();

        sortAscending(songs);

        int index = binarySearch(songs, parameter, 0, songs.size()-1);
        String currentName = songs.get(index).getName();

        while (currentName.contains(parameter)){
            Playable currentSong = songs.remove(index);
            matches.add(currentSong);
        }

        sortAscending(matches);
        return matches;
    }

    private int binarySearch(ArrayList<Playable> songs, String parameter, int low, int high) {
        int pivot = (low + high)/2;

        //This case will only occur when the element does not exist in the list
        if (high < low) {
            return -1;
        }

        Song currentSong = (Song)(songs.get(pivot));
        String currentName = currentSong.getName();

        if (parameter.compareTo(currentName) == 0)
            return pivot;
        else if (parameter.compareTo(currentName) < 0 )
            return binarySearch(songs, parameter, low, pivot - 1);
        else
            return binarySearch(songs, parameter, pivot+1, high);
    }

    @Override
    public int compare(Playable p1, Playable p2) {
        Song s1 = (Song) p1;
        Song s2 = (Song) p2;
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}

