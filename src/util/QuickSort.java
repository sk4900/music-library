package util;

import control.Sorting.PlayableSorter;
import model.Playable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuickSort {

    private PlayableSorter comp;

    public void setComp(PlayableSorter playSorter) {
        comp = playSorter;
    }

    public void quickSortAsc(ArrayList<Playable> list) {
        doQuickSort(list, 0, list.size()-1);
        comp = null;
    }

    public void doQuickSort(ArrayList<Playable> list, int p, int r)
    {
        if(p<r)
        {
            int q = partition(list,p,r);
            doQuickSort(list,p,q);
            doQuickSort(list,q+1,r);
        }
    }

    private int partition(ArrayList<Playable> list, int p, int r) {

        Playable pivot = list.get(p);
        int i = p-1 ;
        int j = r+1 ;

        while (true) {
            i++;
            int iDiff = comp.compare(list.get(i), pivot);
            while ( i < r && iDiff < 0) {
                i++;
                iDiff = comp.compare(list.get(i), pivot);
            }
            j--;
            int jDiff = comp.compare(list.get(j), pivot);
            while (j>p && jDiff > 0) {
                j--;
                jDiff = comp.compare(list.get(j), pivot);
            }

            if (i < j)
                Collections.swap(list, i, j);
            else
                return j;
        }
    }

    public void quickSortDesc(ArrayList<Playable> list) {
        doQuickSortDesc(list, 0, list.size()-1);
        comp = null;
    }

    public void doQuickSortDesc(ArrayList<Playable> list, int left, int right) {
        final Playable pivot = list.get((left+right)/2);        // <== Fix pivot value.
        int l = left;
        int r = right;
        int lDiff;
        int rDiff;
        while (l <= r) {
            lDiff = comp.compare(list.get(l), pivot);
            while (lDiff > 0) {
                l++;
                lDiff = comp.compare(list.get(l), pivot);
            }
            rDiff = comp.compare(list.get(r), pivot);
            while (rDiff < 0) {
                r--;
                rDiff = comp.compare(list.get(r), pivot);
            }
            if (l <= r) {
                Collections.swap(list, l, r);
                l++;
                r--;
            }
        }
        if (left < r) {
            doQuickSortDesc(list, left, r);
        }
        if (l < right) {
            doQuickSortDesc(list, l, right);
        }
    }

}
