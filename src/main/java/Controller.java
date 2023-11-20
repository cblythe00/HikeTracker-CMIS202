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
import java.util.Scanner;

public class Controller {

    private Model model;
    private Button addHikeButton, addHikeButton2, editHikeButton, removeHikeButton,
            openFileButton, openFileButton2, saveFileButton, saveFileButton2, deleteFileButton, deleteFileButton2;
    private TextField hikeNameField, hikeDistanceField, hikeAltitudeField, hikeLocationField,
            saveFileField, openFileField, deleteFileField;
    private Label hikeNameLabel, hikeDistanceLabel, hikeAltitudeLabel, hikeLocationLabel,
            saveDescriptionLabel, saveOutcomeLabel, openDescriptionLabel, openOutcomeLabel, deleteDescriptionLabel, deleteOutcomeLabel,
            recentlyAddedLabel;
    private ComboBox<String> removeHikeComboBox;
    private TableView<Trail> table;
    private Trail mainTrail;
//    private final File file = new File("projectText.txt");

    public Controller(Model model) {
        this.model = model;
    }

    // Where all the buttons are initialized
    public void initialize() throws IOException {

        mainTrail = new Trail();

        openFileButton.setOnAction(this::onOpenFileButtonClicked);
        addHikeButton.setOnAction(this::onAddHikeButtonClicked);
        addHikeButton2.setOnAction(this::onAddHikeButton2Clicked);
        addHikeButton2.setDisable(true);

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
        hikeAltitudeField.textProperty().addListener((obs, oldval, newval) -> onTextChanged());
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

    public void setRemoveHikeButton(Button removeHike) {
        this.removeHikeButton = removeHike;
    }

    public void setHikeNameLabel(Label hikeNameLabel) {
        this.hikeNameLabel = hikeNameLabel;
    }

    public void setHikeDistanceLabel(Label hikeDistanceLabel) {
        this.hikeDistanceLabel = hikeDistanceLabel;
    }

    public void setHikeAltitudeLabel(Label hikeAltitudeLabel) {
        this.hikeAltitudeLabel = hikeAltitudeLabel;
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

    public void setHikeAltitudeField(TextField hikeAltitudeField) {
        this.hikeAltitudeField = hikeAltitudeField;
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

                table.getItems().add(new Trail(s4[i].replaceAll("\\$", " "), s4[i + 1].replaceAll("\\$", " "),
                        s4[i + 2].replaceAll("\\$", " "), s4[i + 3].replaceAll("\\$", " ")));
                mainTrail.addHike(new Trail(s4[i], s4[i + 1], s4[i + 2], s4[i + 3]));
                i += 3;
            }
            openOutcomeLabel.setText("Successfully opened");

            recentlyAddedLabel.setText("                                                                                " +
                    "                                                           Recently added: " + mainTrail.showRecents());
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
        labelHBox.getChildren().addAll(hikeNameLabel, hikeDistanceLabel, hikeAltitudeLabel, hikeLocationLabel);

        HBox tFieldHBox = new HBox();
        tFieldHBox.setAlignment(Pos.CENTER_LEFT);
        tFieldHBox.setSpacing(75);
        tFieldHBox.getChildren().addAll(hikeNameField, hikeDistanceField, hikeAltitudeField, hikeLocationField);

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
                Platform.runLater(() -> hikeAltitudeField.clear());
                Platform.runLater(() -> hikeLocationField.clear());
            } catch (InterruptedException iex) {
                System.out.println(iex.getMessage());
            }
        };
        new Thread(task).start();

        Trail tempTrail = new Trail(hikeNameField.getText(), hikeDistanceField.getText(),
                hikeAltitudeField.getText(), hikeLocationField.getText());

//        Trail tempTrail2 = new Trail(hikeNameField.getText().replaceAll(" ", "\\$"), hikeDistanceField.getText().replaceAll(" ", "\\$"),
//                hikeAltitudeField.getText().replaceAll(" ", "\\$"), hikeLocationField.getText().replaceAll(" ", "\\$"));

        if(hikeNameField.getText().trim().isEmpty() && hikeDistanceField.getText().trim().isEmpty() &&
                hikeAltitudeField.getText().trim().isEmpty() && hikeLocationField.getText().trim().isEmpty()) {

            System.out.println("At least one field must be filled.");
        }
        else {
            table.getItems().add(tempTrail);
            mainTrail.addHike(hikeNameField.getText().replaceAll(" ", "\\$"), hikeDistanceField.getText().replaceAll(" ", "\\$"),
                    hikeAltitudeField.getText().replaceAll(" ", "\\$"), hikeLocationField.getText().replaceAll(" ", "\\$"));

//            mainTrail.addRecents(tempTrail);
            recentlyAddedLabel.setText("                                                                                " +
                    "                                                           Recently added: " + mainTrail.showRecents());

        }

    }
    public void onEditHikeButtonClicked(ActionEvent event) {

    }
    public void onRemoveHikeButtonClicked(ActionEvent event) {
        
    }

    private void onTextChanged() {

        String nameText = hikeNameField.getText();
        String distanceText = hikeDistanceField.getText();
        String altitudeText = hikeAltitudeField.getText();
        String locationText = hikeLocationField.getText();

        if(!nameText.isEmpty() && !distanceText.isEmpty() && !altitudeText.isEmpty() && !locationText.isEmpty()) {
            addHikeButton2.setDisable(false);
        }
        if(nameText.isEmpty() && distanceText.isEmpty() && altitudeText.isEmpty() && locationText.isEmpty()) {
            addHikeButton2.setDisable(true);
        }
    }
}
