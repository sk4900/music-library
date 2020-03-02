package control.Sorting;

import model.Playable;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class SongSorter implements PlayableSorter, Comparator<Playable> {

    public abstract void sortAscending(ArrayList<Playable> songs);

    public abstract void sortDescending(ArrayList<Playable> songs);

    public abstract ArrayList<Playable> find(ArrayList<Playable> objects, String parameter);

    public abstract int compare(Playable p1, Playable p2);

}
