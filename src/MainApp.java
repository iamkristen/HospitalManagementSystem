import CLI.AppointmentInterface;
import CLI.DiagnosisInterface;
import CLI.DoctorInterface;
import CLI.PatientInterface;
import CLI.TreatmentInterface;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import screens.HomeScreen;

public class MainApp extends Application {

    public static void main(String[] args) {
        // Calling LoadData method to load data from the files
        loadData();

        // Launching the JavaFX application
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // loadData();
        primaryStage.setTitle("Hospital Management System");
        primaryStage.setScene(HomeScreen.getScene(primaryStage));

        // Creating an Image object for main App icon
        Image icon = new Image("file:src/assets/icon.png");

        // Adding the Image object to the icons of the Stage
        primaryStage.getIcons().add(icon);
        // Setting the stage to not be resizable
        primaryStage.setResizable(false);
        // setting the stage to not be maximized
        primaryStage.setMaximized(false);

        primaryStage.show();
    }

    // method to load data from the files
    public static void loadData() {
        DoctorInterface.loadData();
        PatientInterface.loadData();
        AppointmentInterface.loadData();
        DiagnosisInterface.loadData();
        TreatmentInterface.loadData();
        System.out.println("\u001B[32m" + "[#] Data load successfully." + "\u001B[0m");
    }

}
