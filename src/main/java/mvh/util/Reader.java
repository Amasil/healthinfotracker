/**
 * A health information tracking program
 * Amasil Rahim Zihad
 * Code heavily adapted from my university project done with Fabiha Fairuzz Subha.
 */
package mvh.util;

import mvh.app.MainController;
import mvh.user.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    //We know that the information will always be in this order.
    static final int USER_NAME = 0;
    static final int USER_AGE = 1;
    static final int USER_GEN = 2;
    static final int USER_WEIGHT = 3;
    static final int USER_HEIGHT = 4;

    /**
     * Reads information from a file
     *
     * @param fileInput The input file containing the user information to be read
     */
    public static void reader(File fileInput) throws IOException {
        //Creating a file reader and a buffered reader
        FileReader file_reader = new FileReader(fileInput);
        BufferedReader b_reader = new BufferedReader(file_reader);

        //Setting the variables
        String userName;
        String userGender;
        double userAge;
        double userWeight;
        double userHeight;


        if (fileInput.exists() && fileInput.canRead()) {
            try {
                //Looping through the file to read all lines of information from the file
                String line = b_reader.readLine();
                if (line == null) {
                    System.err.println("File is empty!");
                } else {
                    while (line != null) {
                        //The file is csv so separating them and storing them in a string
                        String[] userInfo = line.split(",");
                        //Checking the gender of the user to assign the information accordingly
                        //Assigning the information of the file to variables
                        try {
                            userName = userInfo[USER_NAME];
                            if (MainController.userInfo.containsKey(userName)) {
                                System.err.println("The user " + userName + " already exists");
                            } else {
                                try {
                                    userGender = userInfo[USER_GEN];
                                    //User Gender can only be M or N or F
                                    if (!userGender.equals("M") && !userGender.equals("N") && !userGender.equals("F")) {
                                        System.err.println("There is a problem with assigning " + userName + "’s gender.");
                                    } else {
                                        //Abbreviating the M, N and F.
                                        if (userInfo[USER_GEN].equals("M")) {
                                            userGender = "Male";
                                        }
                                        if (userInfo[USER_GEN].equals("F")) {
                                            userGender = "Female";
                                        }
                                        if (userInfo[USER_GEN].equals("N")) {
                                            userGender = "Preferred not to say";
                                        }
                                        try {
                                            userAge = Double.parseDouble(userInfo[USER_AGE]);
                                            //Age has to be a positive number
                                            if (userAge <= 0) {
                                                System.err.println(userName + "’s age is 0 or a negative number");
                                            } else {
                                                try {
                                                    //Weight has to be a positive number
                                                    userWeight = Double.parseDouble(userInfo[USER_WEIGHT]);
                                                    if (userWeight <= 0) {
                                                        System.err.println(userName + "’s weight is 0 or a negative number");
                                                    } else {
                                                        try {
                                                            //Height has to be a positive number
                                                            userHeight = Double.parseDouble(userInfo[USER_HEIGHT]);
                                                            if (userHeight <= 0) {
                                                                System.err.println(userName + "’s height is 0 or a negative number");
                                                            } else {
                                                                User user = new User();
                                                                user.setName(userName);
                                                                user.setAge((int) userAge);
                                                                user.setWeight(userWeight);
                                                                user.setHeight(userHeight);
                                                                user.setGender(userGender);
                                                                MainController.userInfo.put(userName, user);
                                                                MainController.users.add(userName);
                                                            }
                                                        } catch (Exception e) {
                                                            System.err.println("There was a problem parsing the Height of " + userName);
                                                        }
                                                    }
                                                } catch (Exception e) {
                                                    System.err.println("There was a problem parsing the weight of " + userName);
                                                }
                                            }
                                        } catch (Exception e) {
                                            System.err.println("There was a problem parsing the age of " + userName);
                                        }
                                    }
                                } catch (Exception e) {
                                    System.err.println("There was a problem assigning the gender of " + userName);
                                }
                            }
                        } catch (Exception e) {
                            System.err.println("Hello");
                        }
                        //Read the next line
                        line = b_reader.readLine();
                    }
                }
            } catch (Exception e) {
                System.err.println("There is an Issue with the file");
            }
        }
    }
}
