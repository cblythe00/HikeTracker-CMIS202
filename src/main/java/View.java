// **********************************************************************************
// Title: HikeTracker
// Author: Connor Blythe
// Course Section: CMIS202-ONL1 (Seidel) Fall 2022
// File: View.java
// Description: The view to the controller and model classes, it creates the gui layout.
// **********************************************************************************

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class View extends BorderPane {

    private Controller ctrl;
    private Model model;
    private Label hikeNameLabel, hikeDistanceLabel, hikeAltitudeLabel, hikeLocationLabel,
            saveDescription, saveOutcome, openDescription, openOutcome, deleteDescription, deleteOutcome,
            recentlyAddedLabel;
    private Button addHikeButton, addHikeButton2, editHikeButton, removeHikeButton,
            openFileButton, openFileButton2, saveFileButton, saveFileButton2, deleteFileButton, deleteFileButton2;
    private TextField hikeNameField, hikeDistanceField, hikeAltitudeField, hikeLocationField,
            saveFileField, openFileField, deleteFileField;
    private ComboBox<String> removeHikeComboBox;
    private GridPane gridPane;
    private TableView<Trail> table;
    private HBox bottomHBox, topHBox;
    private VBox vBox;

    public View(Controller ctrl, Model model) throws IOException {

        this.ctrl = ctrl;
        this.model = model;
        createLayout();
    }
    private void createLabels() {

        hikeNameLabel = new Label("Enter hike name:");
        ctrl.setHikeNameLabel(hikeNameLabel);

        hikeDistanceLabel = new Label("Enter a numerical distance:");
        ctrl.setHikeDistanceLabel(hikeDistanceLabel);

        hikeAltitudeLabel = new Label("Enter a numerical altitude:");
        ctrl.setHikeAltitudeLabel(hikeAltitudeLabel);

        hikeLocationLabel = new Label("Enter a location:");
        ctrl.setHikeLocationLabel(hikeLocationLabel);

        saveDescription = new Label("Enter a name for your file:");
        ctrl.setSaveDescriptionLabel(saveDescription);

        saveOutcome = new Label("");
        ctrl.setSaveOutcomeLabel(saveOutcome);

        openDescription = new Label("Enter the file name you would like to open:");
        ctrl.setOpenDescriptionLabel(openDescription);

        openOutcome = new Label("");
        ctrl.setOpenOutcomeLabel(openOutcome);

        deleteDescription = new Label("Enter the file name you would like to delete:");
        ctrl.setDeleteDescriptionLabel(deleteDescription);

        deleteOutcome = new Label("");
        ctrl.setDeleteOutcomeLabel(deleteOutcome);

        recentlyAddedLabel = new Label("                                                                                " +
                "                                                           Recently added: ");
        ctrl.setRecentlyAddedLabel(recentlyAddedLabel);
    }
    private void createTextFields() {

        hikeNameField = new TextField("");
        ctrl.setHikeNameField(hikeNameField);

        hikeDistanceField = new TextField("");
        ctrl.setHikeDistanceField(hikeDistanceField);

        hikeAltitudeField = new TextField("");
        ctrl.setHikeAltitudeField(hikeAltitudeField);

        hikeLocationField = new TextField("");
        ctrl.setHikeLocationField(hikeLocationField);

        saveFileField = new TextField("");
        ctrl.setSaveFileField(saveFileField);

        openFileField = new TextField("");
        ctrl.setOpenFileField(openFileField);

        deleteFileField = new TextField("");
        ctrl.setDeleteFileField(deleteFileField);
    }
    private void createComboBoxes() {
        removeHikeComboBox = new ComboBox<>();
        ctrl.setRemoveHikeComboBox(removeHikeComboBox);
    }
    private void createButtons() {

        openFileButton = new Button("Open");
        ctrl.setOpenFileButton(openFileButton);

        openFileButton2 = new Button("Open");
        ctrl.setOpenFileButton2(openFileButton2);

        saveFileButton = new Button("Save");
        ctrl.setSaveFileButton(saveFileButton);

        saveFileButton2 = new Button("Save");
        ctrl.setSaveFileButton2(saveFileButton2);

        deleteFileButton = new Button("Delete");
        ctrl.setDeleteFileButton(deleteFileButton);

        deleteFileButton2 = new Button("Delete");
        ctrl.setDeleteFileButton2(deleteFileButton2);

        addHikeButton = new Button("Add");
        ctrl.setAddHikeButton(addHikeButton);

        addHikeButton2 = new Button("Add");
        ctrl.setAddHikeButton2(addHikeButton2);

        editHikeButton = new Button("Edit");
        ctrl.setEditHikeButton(editHikeButton);

        removeHikeButton = new Button("Remove");
        ctrl.setRemoveHikeButton(removeHikeButton);
    }
//    private void createGridPane() {
//        gridPane = new GridPane();
//        gridPane.setAlignment(Pos.TOP_CENTER);
//        gridPane.setHgap(5.0);
//        gridPane.setVgap(5.0);
//    }
    // Creates the main table with columns like name, distance, altitude, and location
    private void createTableView() {
        table = new TableView<>();
        table.setPrefHeight(500);
        table.setPrefWidth(1200);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Trail, String> trailNameColumn = new TableColumn<Trail, String>("Trail Name");
        trailNameColumn.setCellValueFactory(new PropertyValueFactory<Trail, String>("trailName"));

        TableColumn<Trail, String> trailDistanceColumn = new TableColumn<Trail, String>("Trail Distance");
        trailDistanceColumn.setCellValueFactory(new PropertyValueFactory<Trail, String>("trailDistance"));

        TableColumn<Trail, String> trailAltitudeColumn = new TableColumn<Trail, String>("Trail Altitude");
        trailAltitudeColumn.setCellValueFactory(new PropertyValueFactory<Trail, String>("trailAltitude"));

        TableColumn<Trail, String> trailLocationColumn = new TableColumn<Trail, String>("Trail Location");
        trailLocationColumn.setCellValueFactory(new PropertyValueFactory<Trail, String>("trailLocation"));

        table.getColumns().addAll(trailNameColumn, trailDistanceColumn, trailAltitudeColumn, trailLocationColumn);

        ctrl.setTableView(table);
    }

    // Bottom used to hold the table and the vbox, top used for the file buttons.
    private void createHBox() {

        bottomHBox = new HBox();
        topHBox = new HBox();
    }

    // Used to hold the addHike, editHike, and removeHike buttons. Is then put in the hBox. Buttons
    // must be created before vBox because they are added into it within the createVBox method.
    private void createVBox() {
        vBox = new VBox();
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(30);
        vBox.getChildren().addAll(addHikeButton, editHikeButton, removeHikeButton);
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.setSpacing(100);
    }
    // Creation of the whole layout
    private void createLayout() throws IOException {

        setPadding(new Insets(30));
        createTextFields();
        createLabels();
        createButtons();
        createTableView();
        createComboBoxes();
        createVBox();
        createHBox();

        topHBox.getChildren().addAll(openFileButton, saveFileButton, deleteFileButton, recentlyAddedLabel);
        topHBox.setAlignment(Pos.TOP_LEFT);
        topHBox.setSpacing(50);
        setTop(topHBox);
        setAlignment(topHBox, Pos.TOP_LEFT);

        bottomHBox.getChildren().addAll(table, vBox);
        bottomHBox.setAlignment(Pos.CENTER_LEFT);
        bottomHBox.setSpacing(50);
        setBottom(bottomHBox);
        setAlignment(bottomHBox, Pos.TOP_CENTER);

        ctrl.initialize();
    }
}
