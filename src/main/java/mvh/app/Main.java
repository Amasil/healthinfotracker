/**
 * A health information tracking program
 * *Members:
 * Fabiha Fairuzz Subha
 * Amasil Rahim Zihad
 */
package mvh.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mvh.util.Reader;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        //Sets up the gui window and launches it
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("This Is A Fitness Tracking Program");
        stage.setScene(scene);
        stage.show();
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
