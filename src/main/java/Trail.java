// **********************************************************************************
// Title: HikeTracker
// Author: Connor Blythe
// Course Section: CMIS202-ONL1 (Seidel) Fall 2022
// File: Trail.java
// Description: The trail class responsible for the creation of trails.
// **********************************************************************************

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Trail extends QuickSort{

    private String trailName;
    private String trailDistance;
    private String trailAltitude;
    private String trailLocation;
//    private String[][] hikeInfo = new String[100][4];
    private List<String> list;

    // Used to create a list, this specifically helps within the Controller class by allowing
    // the user to create new trails and then add the to this list for the TableView
    public Trail() {
        list = new LinkedList<>();
    }

    // New trails are created here
    public Trail(String trailName, String trailDistance, String trailAltitude, String trailLocation) {

        this.trailName = trailName;
        if(trailName.trim().isEmpty()) {
            this.trailName = "---";
        }
        this.trailDistance = trailDistance;
        if(trailDistance.trim().isEmpty()) {
            this.trailDistance = "---";
        }
        this.trailAltitude = trailAltitude;
        if(trailAltitude.trim().isEmpty()) {
            this.trailAltitude = "---";
        }
        this.trailLocation = trailLocation;
        if(trailLocation.trim().isEmpty()) {
            this.trailLocation = "---";
        }
    }

    // Adds the created hikes to the list, mainly for saving and opening files
    public void addHike(Trail t) {

        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(t.getTrailName());
        tempList.add(t.getTrailDistance());
        tempList.add(t.getTrailAltitude());
        tempList.add(t.getTrailLocation());

        list.addAll(tempList);
    }

    public String getTrailName() {
        return trailName;
    }

    public void setTrailName(String trailName) {
        this.trailName = trailName;
    }

    public String getTrailDistance() {
        return trailDistance;
    }

    public void setTrailDistance(String trailDistance) {
        this.trailDistance = trailDistance;
    }

    public String getTrailAltitude() {
        return trailAltitude;
    }

    public void setTrailAltitude(String trailAltitude) {
        this.trailAltitude = trailAltitude;
    }

    public String getTrailLocation() {
        return trailLocation;
    }

    public void setTrailLocation(String trailLocation) {
        this.trailLocation = trailLocation;
    }

    // Simply returns the contents of the list, this is mainly for testing purposes
    public String toString() {

        return Arrays.toString(list.toArray());
    }
}
