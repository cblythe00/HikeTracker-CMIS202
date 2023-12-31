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
    private Label hikeNameLabel, hikeDistanceLabel, hikeElevationLabel, hikeLocationLabel, viewOutcomeLabel,
            saveDescription, saveOutcome, openDescription, openOutcome, deleteDescription, deleteOutcome,
            recentlyAddedLabel, viewHikeLabel,
            editName, editDistance, editElevation, editLocation,
            searchLabel, searchLabel2, sendLabel, sendLabel2,
            removeHikeLabel, removeHikeLabel2;
    private Button addHikeButton, addHikeButton2, editHikeButton, editHikeButton2, viewButton, removeHikeButton, removeHikeButton2,
            openFileButton, openFileButton2, saveFileButton, saveFileButton2, deleteFileButton, deleteFileButton2,
            searchButton, searchButton2, sendButton, sendButton2;
    private TextField hikeNameField, hikeDistanceField, hikeElevationField, hikeLocationField,
            saveFileField, openFileField, deleteFileField,
            editNameField, editDistanceField, editElevationField, editLocationField, descriptionField,
            searchField;
    private ComboBox<String> editHikeComboBox, removeHikeComboBox;
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

        hikeElevationLabel = new Label("Enter a numerical altitude:");
        ctrl.setHikeElevationLabel(hikeElevationLabel);

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

        viewHikeLabel = new Label("Select a hike to view:");
        ctrl.setEditHikeLabel(viewHikeLabel);

        viewOutcomeLabel = new Label("");
        ctrl.setViewOutcomeLabel(viewOutcomeLabel);

        editName = new Label("Hike name:");
        ctrl.setEditNameLabel(editName);

        editDistance = new Label("Hike distance:");
        ctrl.setEditDistanceLabel(editDistance);

        editElevation = new Label("Hike elevation:");
        ctrl.setEditElevationLabel(editElevation);

        editLocation = new Label("Hike location:");
        ctrl.setEditLocationLabel(editLocation);

        searchLabel = new Label("Enter a distance:");
        ctrl.setSearchLabel(searchLabel);

        searchLabel2 = new Label();
        ctrl.setSearchLabel2(searchLabel2);

        sendLabel = new Label("Pick a hike to send:");
        ctrl.setSendLabel(sendLabel);

        sendLabel2 = new Label();
        ctrl.setSendLabel2(sendLabel2);

        removeHikeLabel = new Label("Select a hike to remove: ");
        ctrl.setRemoveHikeLabel(removeHikeLabel);

        removeHikeLabel2 = new Label();
        ctrl.setRemoveHikeLabel2(removeHikeLabel2);
    }
    private void createTextFields() {

        hikeNameField = new TextField("");
        ctrl.setHikeNameField(hikeNameField);

        hikeDistanceField = new TextField("");
        ctrl.setHikeDistanceField(hikeDistanceField);

        hikeElevationField = new TextField("");
        ctrl.setHikeElevationField(hikeElevationField);

        hikeLocationField = new TextField("");
        ctrl.setHikeLocationField(hikeLocationField);

        saveFileField = new TextField("");
        ctrl.setSaveFileField(saveFileField);

        openFileField = new TextField("");
        ctrl.setOpenFileField(openFileField);

        deleteFileField = new TextField("");
        ctrl.setDeleteFileField(deleteFileField);

        editNameField = new TextField("");
        ctrl.setEditNameField(editNameField);

        editDistanceField = new TextField("");
        ctrl.setEditDistanceField(editDistanceField);

        editElevationField = new TextField("");
        ctrl.setEditElevationField(editElevationField);

        editLocationField = new TextField("");
        ctrl.setEditLocationField(editLocationField);

        descriptionField = new TextField("");
        ctrl.setDescriptionField(descriptionField);

        searchField = new TextField("");
        ctrl.setSearchField(searchField);
    }
    private void createComboBoxes() {
        removeHikeComboBox = new ComboBox<>();
        ctrl.setRemoveHikeComboBox(removeHikeComboBox);

        editHikeComboBox = new ComboBox<>();
        ctrl.setEditHikeComboBox(editHikeComboBox);
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

        viewButton = new Button("Edit/View");
        ctrl.setViewHikeButton(viewButton);

        removeHikeButton = new Button("Remove");
        ctrl.setRemoveHikeButton(removeHikeButton);

        removeHikeButton2 = new Button("Remove");
        ctrl.setRemoveHikeButton2(removeHikeButton2);

        editHikeButton2 = new Button("Edit");
        ctrl.setEditHikeButton2(editHikeButton2);

        searchButton = new Button("Search");
        ctrl.setSearchButton(searchButton);

        searchButton2 = new Button("Search");
        ctrl.setSearchButton2(searchButton2);

        sendButton = new Button("Send Hike");
        ctrl.setSendButton(sendButton);

        sendButton2 = new Button("Send Hike");
        ctrl.setSendButton2(sendButton2);
    }

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
        vBox.getChildren().addAll(addHikeButton, editHikeButton, removeHikeButton, searchButton);
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
