// **********************************************************************************
// Title: HikeTracker
// Author: Connor Blythe
// Course Section: CMIS202-ONL1 (Seidel) Fall 2022
// File: Controller.java
// Description: The controller to the model and view classes, it controls the actions of buttons and outcomes.
// **********************************************************************************

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Controller {

    private Model model;
    private Button addHikeButton, addHikeButton2, editHikeButton, editHikeButton2, viewHikeButton, removeHikeButton, removeHikeButton2,
            openFileButton, openFileButton2, saveFileButton, saveFileButton2, deleteFileButton, deleteFileButton2,
            searchButton, searchButton2, sendButton, sendButton2;
    private TextField hikeNameField, hikeDistanceField, hikeElevationField, hikeLocationField,
            saveFileField, openFileField, deleteFileField,
            editNameField, editDistanceField, editElevationField, editLocationField, descriptionField,
            searchField;
    private Label hikeNameLabel, hikeDistanceLabel, hikeElevationLabel, hikeLocationLabel, viewOutcomeLabel,
            saveDescriptionLabel, saveOutcomeLabel, openDescriptionLabel, openOutcomeLabel, deleteDescriptionLabel, deleteOutcomeLabel,
            recentlyAddedLabel, editHikeLabel,
            editNameLabel, editDistanceLabel, editElevationLabel, editLocationLabel,
            searchLabel, searchLabel2, sendLabel, sendLabel2,
            removeHikeLabel, removeHikeLabel2;
    private ComboBox<String> editHikeComboBox, removeHikeComboBox;
    private TableView<Trail> table;
    private Trail mainTrail;
    private Descriptions descriptions;
    private BinarySearchTree bst;
    private HikeClient hikeClient;

    public Controller(Model model) {
        this.model = model;
    }

    // Where all the buttons are initialized
    public void initialize() throws IOException {

        mainTrail = new Trail();
        descriptions = new Descriptions();
        bst = new BinarySearchTree();
        hikeClient = new HikeClient();

        addHikeButton.setOnAction(this::onAddHikeButtonClicked);
        addHikeButton2.setOnAction(this::onAddHikeButton2Clicked);
        addHikeButton2.setDisable(true);

        editHikeButton.setOnAction(this::onEditHikeButtonClicked);
        viewHikeButton.setOnAction(this::onViewHikeButtonClicked);
        editHikeButton2.setOnAction(this::onEditButton2Clicked);

        removeHikeButton.setOnAction(this::onRemoveHikeButtonClicked);
        removeHikeButton2.setOnAction(this::onRemoveHikeButton2Clicked);

        searchButton.setOnAction(this::onSearchButtonClicked);
        searchButton2.setOnAction(this::onSearchButton2Clicked);

        sendButton.setOnAction(this::onSendButtonClicked);
        sendButton2.setOnAction(this::onSendButton2Clicked);

        openFileButton.setOnAction(this::onOpenFileButtonClicked);

        saveFileButton.setOnAction(this::onSaveFileButtonClicked);
//        saveFileButton2.setOnAction(this::onSaveFileButton2Clicked);
        saveFileButton2.setOnAction(e -> {
            try {
                onSaveFileButton2Clicked(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        openFileButton.setOnAction(this::onOpenFileButtonClicked);
        openFileButton2.setOnAction(e -> {
            try {
                onOpenFileButton2Clicked(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        deleteFileButton.setOnAction(this::onDeleteFileButtonClicked);
        deleteFileButton2.setOnAction(this::onDeleteFileButton2Clicked);

        hikeNameField.textProperty().addListener((obs, oldval, newval) -> onTextChanged());
        hikeDistanceField.textProperty().addListener((obs, oldval, newval) -> onTextChanged());
        hikeElevationField.textProperty().addListener((obs, oldval, newval) -> onTextChanged());
        hikeLocationField.textProperty().addListener((obs, oldval, newval) -> onTextChanged());
    }

    public void setOpenFileButton(Button openFile) {
        this.openFileButton = openFile;
    }

    public void setOpenFileButton2(Button openFile) {
        this.openFileButton2 = openFile;
    }

    public void setSaveFileButton(Button saveFile) {
        this.saveFileButton = saveFile;
    }

    public void setSaveFileButton2(Button saveFileButton2) {
        this.saveFileButton2 = saveFileButton2;
    }

    public void setDeleteFileButton(Button deleteFile) {
        this.deleteFileButton = deleteFile;
    }

    public void setDeleteFileButton2(Button deleteFileButton2) {
        this.deleteFileButton2 = deleteFileButton2;
    }

    public void setAddHikeButton(Button addHike) {
        this.addHikeButton = addHike;
    }

    public void setAddHikeButton2(Button addHike2) {
        this.addHikeButton2 = addHike2;
    }

    public void setEditHikeButton(Button editHike) {
        this.editHikeButton = editHike;
    }
    public void setViewHikeButton(Button button) {
        this.viewHikeButton = button;
    }
    public void setEditHikeLabel(Label label) {
        this.editHikeLabel = label;
    }
    public void setViewOutcomeLabel(Label label) {
        this.viewOutcomeLabel = label;
    }
    public void setEditNameLabel(Label label) {
        this.editNameLabel = label;
    }
    public void setEditDistanceLabel(Label label) {
        this.editDistanceLabel = label;
    }
    public void setEditElevationLabel(Label label) {
        this.editElevationLabel = label;
    }
    public void setEditLocationLabel(Label label) {
        this.editLocationLabel = label;
    }
    public void setEditNameField(TextField tf) {
        this.editNameField = tf;
    }
    public void setEditDistanceField(TextField tf) {
        this.editDistanceField = tf;
    }
    public void setEditElevationField(TextField tf) {
        this.editElevationField = tf;
    }
    public void setEditLocationField(TextField tf) {
        this.editLocationField = tf;
    }
    public void setEditHikeButton2(Button button) {
        this.editHikeButton2 = button;
    }
    public void setDescriptionField(TextField tf) {
        this.descriptionField = tf;
    }
    public void setRemoveHikeButton(Button removeHike) {
        this.removeHikeButton = removeHike;
    }
    public void setRemoveHikeButton2(Button button) {
        this.removeHikeButton2 = button;
    }
    public void setRemoveHikeLabel(Label label) {
        this.removeHikeLabel = label;
    }
    public void setRemoveHikeLabel2(Label label) {
        this.removeHikeLabel2 = label;
    }
    public void setHikeNameLabel(Label hikeNameLabel) {
        this.hikeNameLabel = hikeNameLabel;
    }

    public void setHikeDistanceLabel(Label hikeDistanceLabel) {
        this.hikeDistanceLabel = hikeDistanceLabel;
    }

    public void setHikeElevationLabel(Label hikeAltitudeLabel) {
        this.hikeElevationLabel = hikeAltitudeLabel;
    }

    public void setHikeLocationLabel(Label hikeLocationLabel) {
        this.hikeLocationLabel = hikeLocationLabel;
    }

    public void setSaveDescriptionLabel(Label saveDescriptionLabel) {
        this.saveDescriptionLabel = saveDescriptionLabel;
    }

    public void setSaveOutcomeLabel(Label saveOutcomeLabel) {
        this.saveOutcomeLabel = saveOutcomeLabel;
    }

    public void setOpenDescriptionLabel(Label openDescriptionLabel) {
        this.openDescriptionLabel = openDescriptionLabel;
    }

    public void setOpenOutcomeLabel(Label openOutcomeLabel) {
        this.openOutcomeLabel = openOutcomeLabel;
    }

    public void setDeleteDescriptionLabel(Label deleteDescriptionLabel) {
        this.deleteDescriptionLabel = deleteDescriptionLabel;
    }

    public void setDeleteOutcomeLabel(Label deleteOutcomeLabel) {
        this.deleteOutcomeLabel = deleteOutcomeLabel;
    }
    public void setRecentlyAddedLabel(Label recentlyAddedLabel) {
        this.recentlyAddedLabel = recentlyAddedLabel;
    }

    public void setHikeNameField(TextField hikeNameField) {
        this.hikeNameField = hikeNameField;
    }

    public void setHikeDistanceField(TextField hikeDistanceField) {
        this.hikeDistanceField = hikeDistanceField;
    }

    public void setHikeElevationField(TextField hikeElevationField) {
        this.hikeElevationField = hikeElevationField;
    }

    public void setHikeLocationField(TextField hikeLocationField) {
        this.hikeLocationField = hikeLocationField;
    }

    public void setSaveFileField(TextField saveFileField) {
        this.saveFileField = saveFileField;
    }

    public void setOpenFileField(TextField openFileField) {
        this.openFileField = openFileField;
    }

    public void setDeleteFileField(TextField deleteFileField) {
        this.deleteFileField = deleteFileField;
    }

    public void setTableView(TableView<Trail> table) {
        this.table = table;
    }
    public void setRemoveHikeComboBox(ComboBox<String> comboBox) {
        this.removeHikeComboBox = comboBox;
    }
    public void setEditHikeComboBox(ComboBox<String> comboBox) {
        this.editHikeComboBox = comboBox;
    }
    public void setSearchButton(Button button) {
        this.searchButton = button;
    }
    public void setSearchButton2(Button button) {
        this.searchButton2 = button;
    }
    public void setSearchLabel(Label label) {
        this.searchLabel = label;
    }
    public void setSearchLabel2(Label label) {
        this.searchLabel2 = label;
    }
    public void setSearchField(TextField tf) {
        this.searchField = tf;
    }

    public void setSendButton(Button b) {
        this.sendButton = b;
    }

    public void setSendButton2(Button b) {
        this.sendButton2 = b;
    }

    public void setSendLabel(Label label) {
        this.sendLabel = label;
    }

    public void setSendLabel2(Label label) {
        this.sendLabel2 = label;
    }

    public void onOpenFileButtonClicked(ActionEvent e) {
        // When the first open button is pressed, a new window is created with these guidelines
        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(openDescriptionLabel, openFileField);
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10, 10, 10, 10));
        bPane.setTop(vBox);
        bPane.setCenter(openFileButton2);
        bPane.setBottom(openOutcomeLabel);

        Stage stage = new Stage();
        Scene scene = new Scene(bPane, 300, 120);
        stage.setScene(scene);
        stage.show();
    }

    public void onOpenFileButton2Clicked(ActionEvent e) throws FileNotFoundException {

        // This processes the information from the open window, taking the text given by the user and
        // turning it into a file
        ArrayList<String> list = new ArrayList<>();
        String s = openFileField.getText() + ".txt";
        File fileName = new File(s);

        // if the file does not exist, nothing happens, and it says it could not find the file
        if (!fileName.exists()) {
            openOutcomeLabel.setText("File not found.");

            // if the file does exist, it is read and added trails are remade from the information
        } else {

            table.getItems().clear();
            model.getTrailList().clear(); // clears previous combo boxes

            Scanner scan = new Scanner(fileName);

            while (scan.hasNext()) {

                list.add(scan.next().trim().replace(",", ""));
            }
            String s2 = Arrays.toString(list.toArray());
            String s3 = s2.replaceAll("\\[", "").replaceAll("\\]", "");
//            System.out.println(s3 + "s3");
            String[] s4 = s3.split(",");

            for (int i = 0; i < s4.length; i++) {

                // in this loop, it reads the values in the array in their specific order to put them back into
                // the table and mainTrail list

                table.getItems().add(new Trail(s4[i].replaceAll("\\$", " ").trim(), s4[i + 1].replaceAll("\\$", " ").trim(),
                        s4[i + 2].replaceAll("\\$", " ").trim(), s4[i + 3].replaceAll("\\$", " ").trim()));
                mainTrail.addHike(new Trail(s4[i].trim(), s4[i + 1].trim(), s4[i + 2].trim(), s4[i + 3].trim()));

                model.addTrail(new Trail(s4[i], s4[i + 1], s4[i + 2], s4[i + 3])); // adds trail names to the combo box list

                bst.insert(new Node(parseDouble(s4[i + 1]))); // adds the distance to the binary search tree

                i += 3;
            }
            openOutcomeLabel.setText("Successfully opened");

            recentlyAddedLabel.setText("                                                                                " +
                    "                                                           Recently added: " + mainTrail.showRecents());

            editHikeComboBox.setItems(model.getTrailList()); // sets combo boxes to the file trails
        }
    }


    // The first save button that opens up another window to allow user input and to save the file
    public void onSaveFileButtonClicked(ActionEvent event) {

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(saveDescriptionLabel, saveFileField);
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10, 10, 10, 10));
        bPane.setTop(vBox);
        bPane.setCenter(saveFileButton2);
        bPane.setBottom(saveOutcomeLabel);

        Stage stage = new Stage();
        Scene scene = new Scene(bPane, 300, 120);
        stage.setScene(scene);
        stage.show();
    }

    // The second save button within the other window that actually saves the file
    public void onSaveFileButton2Clicked(ActionEvent event) throws FileNotFoundException {

        // saveFileField is the textfield that takes in a user input, if empty or null
        // it changes the bottom label, telling the user to enter something valid
        if (saveFileField == null || saveFileField.toString().trim().isEmpty()) {

            saveOutcomeLabel.setText("Please enter a valid name.");

        } else {

            String fileName = saveFileField.getText() + ".txt";
            File outFileObj = new File(fileName);
            PrintWriter outFile = new PrintWriter(outFileObj);

            String s = mainTrail.toString();
            s = s.replaceAll("\\[", "").replaceAll("\\]", "");

            outFile.print(s);
            outFile.close();
            saveOutcomeLabel.setText("Successfully saved.");

//            System.out.println(s);
        }
    }

    public void onDeleteFileButtonClicked(ActionEvent e) {

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(deleteDescriptionLabel, deleteFileField);
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10, 10, 10, 10));
        bPane.setTop(vBox);
        bPane.setCenter(deleteFileButton2);
        bPane.setBottom(deleteOutcomeLabel);

        Stage stage = new Stage();
        Scene scene = new Scene(bPane, 300, 120);
        stage.setScene(scene);
        stage.show();
    }
    public void onDeleteFileButton2Clicked(ActionEvent e) {

        if (deleteFileField == null || deleteFileField.toString().trim().isEmpty()) {

            saveOutcomeLabel.setText("Please enter a valid name.");

        } else {

            String s = deleteFileField.getText() + ".txt";

            File file1 = new File(s);
            if(!file1.exists()) {
                deleteOutcomeLabel.setText("Could not find or delete file.");
            }
            else {
                file1.delete();
                deleteOutcomeLabel.setText("File has been deleted");
                table.getItems().clear();
            }
        }
    }

    public void onAddHikeButtonClicked(ActionEvent event) {

        HBox labelHBox = new HBox();
        labelHBox.setAlignment(Pos.CENTER_LEFT);
        labelHBox.setSpacing(75);
        labelHBox.getChildren().addAll(hikeNameLabel, hikeDistanceLabel, hikeElevationLabel, hikeLocationLabel);

        HBox tFieldHBox = new HBox();
        tFieldHBox.setAlignment(Pos.CENTER_LEFT);
        tFieldHBox.setSpacing(75);
        tFieldHBox.getChildren().addAll(hikeNameField, hikeDistanceField, hikeElevationField, hikeLocationField);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(labelHBox, tFieldHBox);

        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10, 10, 10, 10));
        bPane.setTop(vBox);
        bPane.setCenter(addHikeButton2);
//        bPane.setBottom();

        Stage stage = new Stage();
        Scene scene = new Scene(bPane, 750, 240);
        stage.setScene(scene);
        stage.show();
    }

    public void onAddHikeButton2Clicked(ActionEvent event) {

        Runnable task = () -> {
            try {
                Thread.sleep(1);
                Platform.runLater(() -> hikeNameField.clear());
                Platform.runLater(() -> hikeDistanceField.clear());
                Platform.runLater(() -> hikeElevationField.clear());
                Platform.runLater(() -> hikeLocationField.clear());
            } catch (InterruptedException iex) {
                System.out.println(iex.getMessage());
            }
        };
        new Thread(task).start();

        Trail tempTrail = new Trail(hikeNameField.getText(), hikeDistanceField.getText(),
                hikeElevationField.getText(), hikeLocationField.getText());

        if(hikeNameField.getText().trim().isEmpty() && hikeDistanceField.getText().trim().isEmpty() &&
                hikeElevationField.getText().trim().isEmpty() && hikeLocationField.getText().trim().isEmpty()) {

            System.out.println("At least one field must be filled.");
        }
        else {
            table.getItems().add(tempTrail);
            mainTrail.addHike(hikeNameField.getText().replaceAll(" ", "\\$"), hikeDistanceField.getText().replaceAll(" ", "\\$"),
                    hikeElevationField.getText().replaceAll(" ", "\\$"), hikeLocationField.getText().replaceAll(" ", "\\$"));

            recentlyAddedLabel.setText("                                                                                " +
                    "                                                           Recently added: " + mainTrail.showRecents());
            model.addTrail(tempTrail); // Adds the trail name to the list of names in the model class to be used in comboboxes
            editHikeComboBox.setItems(model.getTrailList());
            bst.insert(new Node(parseDouble(hikeDistanceField.getText())));
        }
    }
    public void onEditHikeButtonClicked(ActionEvent event) {

        editHikeComboBox.setItems(model.getTrailList());
        editHikeComboBox.setMinSize(200, 10);
        descriptionField.setMinSize(175, 150);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(30);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(editHikeLabel, editHikeComboBox, viewHikeButton, viewOutcomeLabel);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(editNameLabel, editDistanceLabel, editElevationLabel, editLocationLabel);
        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER_LEFT);

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(editNameField, editDistanceField, editElevationField, editLocationField);
        vBox2.setSpacing(30);
        vBox2.setAlignment(Pos.CENTER_RIGHT);

        VBox vBox3 = new VBox();
        vBox3.getChildren().addAll(descriptionField, editHikeButton2);
        vBox3.setSpacing(30);
        vBox3.setAlignment(Pos.CENTER);

        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10, 10, 10, 10));
        bPane.setTop(hBox);
        bPane.setLeft(vBox);
        bPane.setRight(vBox2);
        bPane.setBottom(vBox3);

        Stage stage = new Stage();
        Scene scene = new Scene(bPane, 750, 500);
        stage.setScene(scene);
        stage.show();
    }

    public void onViewHikeButtonClicked(ActionEvent event) {

        LinkedList<String> list = new LinkedList<>(mainTrail.getList());

        if(editHikeComboBox.getValue() == null || editHikeComboBox.getValue().isEmpty()) {
            viewOutcomeLabel.setText("Please choose a hike.");
        }
        else {

            for(String s : list) {

                int i = list.indexOf(s);

                s = s.trim().replaceAll("\\$", " "); // all data is stored with spaces replaced by $

                if(s.equals(editHikeComboBox.getValue().trim())) {
                    editNameField.setText(s);
                    editDistanceField.setText(list.get(i + 1).replaceAll("\\$", " "));
                    editElevationField.setText(list.get(i + 2).replaceAll("\\$", " "));
                    editLocationField.setText(list.get(i + 3).replaceAll("\\$", " "));

                    descriptionField.setText(descriptions.getDescription(s.replaceAll(" ", "")));
                    break;
                }
            }
        }
    }

    public void onEditButton2Clicked(ActionEvent event) {

        if(editHikeComboBox.getValue() == null || editHikeComboBox.getValue().isEmpty()) {
            descriptionField.setText("Choose a hike.");
        }
        else if (!editNameField.getText().isEmpty() && !editDistanceField.getText().isEmpty() &&
                !editElevationField.getText().isEmpty() && !editLocationField.getText().isEmpty()) {

            String trailName = editHikeComboBox.getValue();
            //removes previous data for editing
            for(int i = 0; i < table.getItems().size(); i++) {
                if(table.getItems().get(i).getTrailName().equals(trailName)) {
                    table.getItems().remove(i);
                    break;
                }
            }
            model.removeTrail(trailName);
            mainTrail.removeHike(trailName);
//            bst.remove();

            // adds or updates the description
            if(descriptionField.getText() == null || descriptionField.getText().isEmpty()) {
                descriptionField.setText("");
            }
            else {
                descriptions.addDescription(editNameField.getText().trim().replaceAll(" ", ""), descriptionField.getText());
            }
            // adds data back
            Trail tempTrail = new Trail(editNameField.getText(), editDistanceField.getText(),editElevationField.getText(), editLocationField.getText());

            table.getItems().add(tempTrail); // Adds trail back to table
            mainTrail.addHike(tempTrail); // Adds trail to main list
            model.addTrail(tempTrail); // Adds the trail name to the list of names in the model class to be used in comboboxes
//            bst.insert(new Node(parseDouble(hikeDistanceField.getText())));
        }
        else {
            descriptionField.setText("Choose a hike.");
        }
    }

    public void onRemoveHikeButtonClicked(ActionEvent event) {

        HBox hBox = new HBox();
        hBox.getChildren().addAll(removeHikeLabel, editHikeComboBox, removeHikeButton2);
        hBox.setSpacing(30);
        hBox.setAlignment(Pos.CENTER_LEFT);

        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10, 10, 10, 10));
        bPane.setTop(hBox);
        bPane.setBottom(removeHikeLabel2);

        Stage stage = new Stage();
        Scene scene = new Scene(bPane, 500, 200);
        stage.setScene(scene);
        stage.show();
    }

    public void onRemoveHikeButton2Clicked(ActionEvent event) {

        if(editHikeComboBox.getValue().isEmpty() || editHikeComboBox.getValue() == null) {
            removeHikeLabel2.setText("Invalid.");
        }
        else {
            for(int i = 0; i < table.getItems().size(); i++) {
                if(table.getItems().get(i).getTrailName().equals(editHikeComboBox.getValue())) {
                    table.getItems().remove(i);
                    break;
                }
            }
            model.removeTrail(editHikeComboBox.getValue());
            removeHikeLabel2.setText(mainTrail.removeHike(editHikeComboBox.getValue()));
        }
    }

    public void onSearchButtonClicked(ActionEvent event) {

        searchLabel2.setText("");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(searchLabel, searchField, searchButton2);
        hBox.setSpacing(30);
        hBox.setAlignment(Pos.CENTER_LEFT);

        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10, 10, 10, 10));
        bPane.setTop(hBox);
        bPane.setBottom(searchLabel2);

        Stage stage = new Stage();
        Scene scene = new Scene(bPane, 500, 200);
        stage.setScene(scene);
        stage.show();
    }

    public void onSearchButton2Clicked(ActionEvent event) {

        LinkedList<String> list = new LinkedList<>(mainTrail.getList());
        StringBuilder hikes = new StringBuilder();

        if(searchField.getText().trim().isEmpty()) {
            searchLabel2.setText("Please enter a number.");
        }
        else if(!bst.search(parseDouble(searchField.getText()))) {
            searchLabel2.setText("No hike found.");
        }
        else {
            for(int i = 1; i < list.size(); i+=4) {

                if(list.get(i).trim().equals(searchField.getText())) {
                    hikes.append(list.get(i - 1).replaceAll("\\$", " "));
                    hikes.append("\n");
                    searchLabel2.setText(String.valueOf(hikes));
                }
            }
        }
    }

    public void onSendButtonClicked(ActionEvent event) {

        sendLabel2.setText("");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(sendLabel, editHikeComboBox, sendButton2);
        hBox.setSpacing(30);
        hBox.setAlignment(Pos.CENTER_LEFT);

        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10, 10, 10, 10));
        bPane.setTop(hBox);
        bPane.setBottom(sendLabel2);

        Stage stage = new Stage();
        Scene scene = new Scene(bPane, 500, 200);
        stage.setScene(scene);
        stage.show();
    }

    public void onSendButton2Clicked(ActionEvent event) {

        if(editHikeComboBox.getValue() == null || editHikeComboBox.getValue().isEmpty()) {
            sendLabel2.setText("Please choose a hike.");
        }
        else {

            hikeClient.client(editHikeComboBox, mainTrail);
        }
    }
    private void onTextChanged() {

        String nameText = hikeNameField.getText();
        String distanceText = hikeDistanceField.getText();
        String altitudeText = hikeElevationField.getText();
        String locationText = hikeLocationField.getText();

        if(!nameText.isEmpty() && !distanceText.isEmpty() && !altitudeText.isEmpty() && !locationText.isEmpty()) {
            addHikeButton2.setDisable(false);
        }
        if(nameText.isEmpty() && distanceText.isEmpty() && altitudeText.isEmpty() && locationText.isEmpty()) {
            addHikeButton2.setDisable(true);
        }
    }
}
