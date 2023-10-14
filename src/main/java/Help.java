// **********************************************************************************
// Title: HikeTracker
// Author: Connor Blythe
// Course Section: CMIS202-ONL1 (Seidel) Fall 2022
// File: Help.java
// Description: A simple class that just displays a description.
// **********************************************************************************

public class Help {

    public static void about() {

        String description = """
        The following program acts as a trail recorder for those who like to walk, hike,
        run, bike or whatever else one may do on a trail. The user may input a trail name,
        the distance, where it is located, and more. This information is then stored and
        can be sorted or modified which allows the user to quickly find a hike that meets their
        requirements.
        """;
        System.out.println("------------------------------");
        System.out.print("Description:\n" + description);
        System.out.println("------------------------------");
    }
}