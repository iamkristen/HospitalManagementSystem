package helper;

import java.io.*;
import java.util.ArrayList;

public class DataHandler {
    // Defining constant for directory path
    private static final String DIRECTORY_PATH = System.getProperty("user.dir");

    public static <U> ArrayList<U> getData(String fileName) {
        ArrayList<U> dataList = new ArrayList<>();
        try {
            // Constructing the file object representing the file to be read
            File directory = new File(DIRECTORY_PATH);
            File fileToRead = new File(directory + "/src/data/", fileName);

            if (fileToRead.exists()) {
                // Creating the FileInputStream with the file object
                FileInputStream fileInputStream = new FileInputStream(fileToRead);
                ObjectInputStream in = new ObjectInputStream(fileInputStream);

                // Reading the ArrayList from the ObjectInputStream
                dataList = (ArrayList<U>) in.readObject();

                // Closing the streams
                in.close();
                fileInputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        }
        return dataList;
    }

    public static <U> void saveData(ArrayList<U> dataList, String fileName) {
        try {
            // Constructing the file object representing the file to be created
            File directory = new File(DIRECTORY_PATH);
            File fileToCreate = new File(directory + "/src/data/", fileName);

            // Creating the directories if they don't exist
            directory.mkdirs();

            // Creating the file if it doesn't exist
            if (!fileToCreate.exists()) {
                fileToCreate.createNewFile();
            }

            // Creating the FileOutputStream with the file object
            FileOutputStream fileOutputStream = new FileOutputStream(fileToCreate);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

            // Writing the ArrayList to the ObjectOutputStream
            out.writeObject(dataList);

            // Closing the streams
            out.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
