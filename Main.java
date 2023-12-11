// **********************************************************************************
// Title: HikeTracker
// Author: Connor Blythe
// Course Section: CMIS202-ONL1 (Seidel) Fall 2022
// File: Main.java
// Description: The main class used to run the program.
// **********************************************************************************

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);

        Help help = new Help();
        help.about();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Model model = new Model();
        Controller ctrl = new Controller(model);
        View view = new View(ctrl, model);

        Scene scene = new Scene(view,10, 10);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hike Tracker");
        primaryStage.setResizable(true);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
