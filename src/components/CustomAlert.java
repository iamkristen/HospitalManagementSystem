package components;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;

public class CustomAlert {
    public static boolean confirmBox(String title, String message) {
        return confirmBox(title, message, AlertType.CONFIRMATION);
    }

    public static boolean confirmBox(String title, String message, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initStyle(StageStyle.UTILITY);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    // this method returns the custom alert box with the message, title, AlertType
    // and image
    public static void alertBox(String title, String message, String imgPath, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        // Get the stage associated with the alert
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

        // Setting the custom icon for the stage
        Image icon = new Image(imgPath);
        stage.getIcons().add(icon);

        alert.showAndWait();
    }
}
