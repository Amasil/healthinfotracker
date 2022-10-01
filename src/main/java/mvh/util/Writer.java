/**
 * A health information tracking program
 * *Members:
 * Fabiha Fairuzz Subha
 * Amasil Rahim Zihad
 */
package mvh.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Writer {

    /**
     * Writes the calorie information in a file
     *
     * @param outInfo The information that the user wants to save in a file
     */
    public static void writer(HashMap<Integer, String> outInfo) throws IOException {

        File newFile = new File("User.txt");
        //If file does not exist create new file
        newFile.createNewFile();

        //Checking if the file exits and can write on it
        if (newFile.exists() && newFile.canWrite()) {
            try {
                //Append so that information is added to the next line
                FileWriter f_writer = new FileWriter(newFile, true);
                BufferedWriter b_writer = new BufferedWriter(f_writer);

                //Writing the information to the file
                for (Integer i : outInfo.keySet()) {
                    b_writer.write(i + "," + outInfo.get(i));
                    b_writer.newLine();
                }
                b_writer.flush();
                b_writer.close();
                //Exception handled
            } catch (IOException e) {
                System.err.println("Cannot access the file to write it!");
            }
        } else {
            System.err.println("Cannot access the file to write it!");
        }
    }

    /**
     * Writes the user information to a file
     *
     * @param fileSave   The name of the file to write to
     * @param userName   The name of the user that is manually entered if the user doesn't exist
     * @param userAge    The age of the user that is manually entered if the user doesn't exist
     * @param userGender The gender of the user that is manually entered if the user doesn't exist
     * @param userWeight The weight of the user that is manually entered if the user doesn't exist
     * @param userHeight The height of the user that is manually entered if the user doesn't exist
     */
    public static void fileWriter(File fileSave, String userName, String userAge, String userGender, String userWeight, String userHeight) throws IOException {

        fileSave.createNewFile();

        //Checking if the file exist and can write on it
        if (fileSave.exists() && fileSave.canWrite()) {
            try {
                //Setting up the writer
                FileWriter f_writer = new FileWriter(fileSave, true);
                BufferedWriter b_writer = new BufferedWriter(f_writer);

                //Getting the user info from the hashmap
                b_writer.write(userName + "," + userAge + "," + userGender + "," + userWeight + "," + userHeight + "\n");
                b_writer.flush();
                b_writer.close();
                //Exception handled
            } catch (IOException e) {
                System.err.println("File not found");
            }
        } else {
            System.err.println("Can't Write to file");
        }
    }
}
