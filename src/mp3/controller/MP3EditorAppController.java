package mp3.controller;

import mp3.Main;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MP3EditorAppController {
    private Stage primaryStage;
    public MP3EditorAppController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void initRootLayout() {
        try {
            this.primaryStage.setTitle("MP3Editor - 2.0");
            this.primaryStage.getIcons().add(new Image(new File("icon.ico").toURI().toString()));
            this.primaryStage.setResizable( false);

            // load layout from FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class
                    .getResource("view/MainWindowPane.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();

            // set initial data into javafx.controller
            MP3EditorOverviewController controller = loader.getController();
            controller.setAppController(this);

            //javafx.controller.setCommandRegistry(commandRegistry);

            // add layout to a scene and show them all
            Scene scene = new Scene(rootLayout);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();

        } catch (IOException e) {
            // don't do this in common apps
            e.printStackTrace();
        }
    }
}
