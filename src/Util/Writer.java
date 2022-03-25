/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    /**
     *
     * @param out_info The information that the user wants to save in a file
     * @throws IOException
     */
    public static void writer(int out_info) throws IOException {


        File newFile = new File ("User.txt");
        newFile.createNewFile();

        //Checking if the file exits and can write on it
        if (newFile.exists() && newFile.canWrite()) {
            try {
                FileWriter f_writer = new FileWriter(newFile, true);
                BufferedWriter b_writer = new BufferedWriter(f_writer);

                    b_writer.write(out_info + "\n");

                b_writer.flush();
            } catch (IOException e) {
                System.err.println("Cannot access the file to write it!");
            }
        } else {
            System.err.println("Cannot access the file to write it!");
            System.exit(1);
        }
    }
}
