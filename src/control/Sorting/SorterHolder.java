package control.Sorting;

import util.QuickSort;

import java.util.HashMap;

public class SorterHolder {
    private HashMap<String, PlayableSorter> songSorters;

    public SorterHolder(){
        QuickSort quickSort = new QuickSort();
        songSorters = new HashMap<>();
        songSorters.put("aguid", new SongSortByAGUID(quickSort));
        songSorters.put("name", new SongSortByName(quickSort));
        songSorters.put("guid", new SongSortByGUID(quickSort));
    }

    public PlayableSorter getSorter(String playableType, String sortField) {
        PlayableSorter sorter;
        if (playableType.equals("song"))
            sorter = songSorters.get(sortField);
        else if (playableType.equals("release"))
            sorter = null;
        else
            sorter = null;

        return sorter;
    }



}
