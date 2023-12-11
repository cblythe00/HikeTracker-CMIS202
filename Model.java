// **********************************************************************************
// Title: HikeTracker
// Author: Connor Blythe
// Course Section: CMIS202-ONL1 (Seidel) Fall 2022
// File: Model.java
// Description: The model to the controller and view classes, it will contain all the data.
// **********************************************************************************

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Used to create lists within the GUI
public class Model {

    // The list holding all the sort options for future use
    private ObservableList<String> trailList;
    private QuickSort qs;

    public Model() {

        qs = new QuickSort();

        List<String> lst = new ArrayList<>();
        trailList = FXCollections.observableList(lst);
    }

    public void addTrail(Trail t) {

        if(t.getTrailName().contains("$")) {
            trailList.add(t.getTrailName().replaceAll("\\$", " ").trim());
        }
        else {
            trailList.add(t.getTrailName().trim()); // add the names to the current list
        }

            String[] array = new String[trailList.size()]; // create a new array for use in quicksort
            qs.quickSort(trailList.toArray(array)); // sort the array
            trailList.clear(); // clear list before adding everything back in order

            trailList.addAll(Arrays.asList(array)); // add all names back
    }

    public void removeTrail(String s) {
        trailList.remove(s);
    }

    public ObservableList<String> getTrailList() {
        return trailList;
    }
}