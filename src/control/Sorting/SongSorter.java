package control.Sorting;

import model.Playable;
import model.Song;
import util.QuickSort;

import java.util.ArrayList;

public abstract class SongSorter implements PlayableSorter {

    public void sortAscending(ArrayList<Playable> songs, PlayableSorter sorter, QuickSort quickSort) {
        quickSort.setComp(sorter);
        quickSort.quickSortAsc(songs);
    }

    public void sortDescending(ArrayList<Playable> songs, PlayableSorter sorter, QuickSort quickSort) {
        quickSort.setComp(sorter);
        quickSort.quickSortAsc(songs);
    }

    public abstract ArrayList<Playable> find(ArrayList<Playable> objects, String parameter);

    public abstract int compare(Playable p1, Playable p2);

}
