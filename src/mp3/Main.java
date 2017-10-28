package mp3;

import mp3.controller.MP3EditorAppController;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    private Stage primaryStage;

    private MP3EditorAppController appController;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        this.primaryStage.getIcons().add(new Image(new File("icon.ico").toURI().toString()));
        this.primaryStage.setTitle("MP3Editor");
        this.primaryStage.setResizable( false);
        this.primaryStage.show();

        this.appController = new MP3EditorAppController(primaryStage);
        this.appController.initRootLayout();

    }

    public static void main(String[] args) {
        launch(args);
    }


}