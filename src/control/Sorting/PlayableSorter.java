package control.Sorting;

import model.Playable;
import java.util.ArrayList;

public interface PlayableSorter {

    void sortDescending(ArrayList<Playable> objects);
    void sortAscending(ArrayList<Playable> objects);
    ArrayList<Playable> find(ArrayList<Playable> objects, String parameter);
    int compare(Playable p1, Playable p2);
}
