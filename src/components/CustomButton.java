package components;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CustomButton {
    public static Button backButton(Stage primaryStage, Scene scene) {
        return backButton(primaryStage, scene, "Back", "file:src/assets/back.png", 20, 20);
    }

    public static Button backButton(Stage primaryStage, Scene scene, String buttonText, String imagePath,
            double imageWidth, double imageHeight) {
        Button backButton = new Button(buttonText);
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(imageWidth);
        imageView.setFitHeight(imageHeight);
        backButton.setGraphic(imageView);
        backButton.setOnAction(event -> {
            primaryStage.setScene(scene);
        });
        return backButton;
    }

    public static Button newButton(String title, String imagePath) {
        Button button = new Button(title);
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);
        button.setGraphic(imageView);
        return button;
    }
}
