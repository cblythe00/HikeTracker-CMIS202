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
import java.util.List;

// Used to create lists within the GUI
public class Model {

    // The list holding all the sort options for future use
    private ObservableList<String> trailList;

    public Model() {

        List<String> lst = new ArrayList<>();

        trailList = FXCollections.observableList(lst);
    }

//    public void addTrail(Trail t) {
//
//    }

    public ObservableList<String> getTrailList() {
        return trailList;
    }
}