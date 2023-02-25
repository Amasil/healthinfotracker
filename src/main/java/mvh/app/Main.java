/**
 * A health information tracking program
 * Amasil Rahim Zihad
 * Code heavily adapted from my university project done with Fabiha Fairuzz Subha.
 */
package mvh.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mvh.util.Reader;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("Hello?");
        primaryStage.setScene(new Scene(root, 550, 550));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        //Checking if any argument is passed or not
        if (args.length != 0) {
            File fileInput = new File(args[0]);
            if (fileInput.exists() && fileInput.canRead()) {
                try {
                    Reader.reader(fileInput);
                    System.out.println("Program Started With File Loaded");
                    //Exception handled
                } catch (IOException e) {
                    System.err.println("Not a valid Input file");
                }
            }
        } else {
            System.err.println("Program Started Without File Loaded");
        }
        launch(args);
    }
}