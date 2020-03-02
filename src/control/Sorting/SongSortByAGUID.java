package control.Sorting;

import model.Playable;
import model.Song;
import util.QuickSort;

import java.util.ArrayList;

public class SongSortByAGUID extends SongSorter {

    private final QuickSort quickSort;

    public SongSortByAGUID (QuickSort quickSort){
        this.quickSort = quickSort;
    }

    @Override
    public void sortAscending(ArrayList<Playable> songs) {
        quickSort.quickSortAsc(songs,this);
    }

    @Override
    public void sortDescending(ArrayList<Playable> songs) {
        quickSort.quickSortDesc(songs,this);
    }

    public ArrayList<Playable> find(ArrayList<Playable> songs, String parameter) {
        ArrayList<Playable> matches = new ArrayList<>();

        sortAscending(songs);

        int index = binarySearch(songs, parameter, 0, songs.size()-1);
        String currentGUID = songs.get(index).getGUID();

        while (currentGUID.equals(parameter)){
            Playable currentSong = songs.remove(index);
            matches.add(currentSong);
        }

        return matches;
    }

    private int binarySearch(ArrayList<Playable> songs, String parameter, int low, int high) {
        int pivot = (low + high)/2;

        //This case will only occur when the element does not exist in the list
        if (high < low) {
            return -1;
        }

        Song currentSong = (Song)(songs.get(pivot));
        String currentGUID = currentSong.getAGUID();

        if (parameter.compareTo(currentGUID) == 0)
            return pivot;
        else if (parameter.compareTo(currentGUID) < 0 )
            return binarySearch(songs, parameter, low, pivot - 1);
        else
            return binarySearch(songs, parameter, pivot+1, high);
    }

    @Override
    public int compare(Playable p1, Playable p2) {
        Song s1 = (Song)p1;
        Song s2 = (Song)p2;
        return s1.getAGUID().compareTo(s2.getAGUID());
    }
}
