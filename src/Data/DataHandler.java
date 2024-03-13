package Data;
import java.io.*;
import java.util.ArrayList;

public class DataHandler {
    // Creating a generic method to retrieve data from a file and return an ArrayList of objects of type U
    public static <U> ArrayList<U> getData(String fileName) {
        ArrayList<U> dataList = new ArrayList<>();
        try {
            // Obtain the current working directory
            File currentDirectory = new File(new File("").getAbsolutePath());

            // Construct the file object representing the file to be read
            File fileToRead = new File(currentDirectory, "src/files/" + fileName);

            if(fileToRead.exists()){
                // Create the FileInputStream with the file object
                FileInputStream fileInputStream = new FileInputStream(fileToRead);

                ObjectInputStream in = new ObjectInputStream(fileInputStream);

                // Read the ArrayList from the ObjectInputStream
                dataList = (ArrayList<U>) in.readObject();

                // Close the streams
                in.close();
                fileInputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return dataList;
    }

    public static <U> void saveData(ArrayList<U> dataList, String fileName) {
        try {
            // Obtain the current working directory
            File currentDirectory = new File(new File("").getAbsolutePath());
            // Construct the file object representing the file to be created
            File fileToCreate = new File(currentDirectory, "src/files/" + fileName);

            // Create the FileOutputStream with the file object
            FileOutputStream fileOutputStream = new FileOutputStream(fileToCreate);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

            // Write the ArrayList to the ObjectOutputStream
            out.writeObject(dataList);

            // Close the streams
            out.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
