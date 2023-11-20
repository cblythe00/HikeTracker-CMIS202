// **********************************************************************************
// Title: HikeTracker
// Author: Connor Blythe
// Course Section: CMIS202-ONL1 (Seidel) Fall 2022
// File: Trail.java
// Description: The trail class responsible for the creation of trails.
// **********************************************************************************

import java.util.*;

public class Trail extends QuickSort{

    private String trailName;
    private String trailDistance;
    private String trailAltitude;
    private String trailLocation;
    private List<String> list;
    private PriorityQueue<String> recents;

    // Used to create a list, this specifically helps within the Controller class by allowing
    // the user to create new trails and then add the to this list for the TableView
    public Trail() {
        list = new LinkedList<>();
        recents = new PriorityQueue<>();
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

    // Adds the created hikes to the list, mainly for saving and opening files, takes an instance of
    // Trail because thats what the table needs.
    public void addHike(Trail t) {

        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(t.getTrailName());
        tempList.add(t.getTrailDistance());
        tempList.add(t.getTrailAltitude());
        tempList.add(t.getTrailLocation());

        list.addAll(tempList);
        addRecents(t);
    }
    // Also adds hikes to the list
    public void addHike(String trailName, String trailDistance, String trailAltitude, String trailLocation) {

        list.add(trailName);
        list.add(trailDistance);
        list.add(trailAltitude);
        list.add(trailLocation);

        addRecents(new Trail(trailName, trailDistance, trailAltitude, trailLocation));
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

    // The addRecents method is used in the Controller to add the names of hikes to the priorityQueue
    // these are then used to display the recently added hikes.
    public void addRecents(Trail t) {

        if(t.trailName.contains("$")) {
            recents.offer(t.trailName.replaceAll("\\$", " "));
        }
        else {
            recents.offer(t.trailName);
        }
    }

    // The showRecents method is used to display the most recently added hike
    public String showRecents() {

        return recents.poll();
    }
}
