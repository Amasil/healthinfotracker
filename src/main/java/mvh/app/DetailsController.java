/**
 * A health information tracking program
 * Amasil Rahim Zihad
 * Code heavily adapted from my university project done with Fabiha Fairuzz Subha.
 */
package mvh.app;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class DetailsController {
    @FXML
    public TextArea viewDetails;
    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    private void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
