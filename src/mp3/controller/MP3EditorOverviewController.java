package mp3.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class MP3EditorOverviewController {

    private MP3EditorAppController mp3EditorAppController;

    @FXML
    private Group root;

    @FXML
    private Text headerText;

    @FXML
    private TextField savePathTextField;

    @FXML
    private CheckBox saveAsNewFileCheckBox;

    @FXML
    private CheckBox saveToTheSameDirectoryCheckBox;

    @FXML
    private TextField pathOfFileToCutTextField;

    @FXML
    private Button chooseDirectoryToSaveButton;


    public void setAppController(MP3EditorAppController mp3EditorAppController) {
        this.mp3EditorAppController = mp3EditorAppController;
    }

    @FXML
    private void handleSaveAsNewFileCheckBoxAction(ActionEvent event){
        if (saveAsNewFileCheckBox.isSelected()) {
            saveToTheSameDirectoryCheckBox.setDisable(false);
        }
        else {
            saveToTheSameDirectoryCheckBox.setSelected(true);
            saveToTheSameDirectoryCheckBox.setDisable(true);
            savePathTextField.setDisable(true);
            savePathTextField.clear();
            chooseDirectoryToSaveButton.setDisable(true);
        }
    }

    @FXML
    private void handleSaveToTheSameDirectoryCheckBoxAction(ActionEvent event){
        if (saveToTheSameDirectoryCheckBox.isSelected()) {
            savePathTextField.setDisable(true);
            savePathTextField.clear();
            chooseDirectoryToSaveButton.setDisable(true);
        }
        else {
            savePathTextField.setDisable(false);
            chooseDirectoryToSaveButton.setDisable(false);
        }
    }

    @FXML
    private void handleChooseAction(ActionEvent event){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedFile = directoryChooser.showDialog(null);
        if (selectedFile != null) {
            savePathTextField.setText(selectedFile.getAbsolutePath());
        }
    }
}
