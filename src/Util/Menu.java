/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package Util;


import java.io.*;
import java.util.*;
import java.util.Scanner;

import Main.*;
import Util.*;


public final class Menu {

    /**
     * Getting the users information and storing it in a hashmap.
     */

    public static void getUserInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your name:");
        String name;
        name = scanner.nextLine();
        System.out.println("Please Enter your Gender (F for Female, M for Male or N if preferred not to say):");
        String gender;
        gender = scanner.nextLine();
//Get user age,height,weight and make sure they are valid numbers
        double age = getUserAge();
        double weight = getUserWeight();
        double height = getUserHeight();


        User user = new User();

        user.setUserName(name);
        user.setUserGender(gender);
        user.setUserAge(age);
        user.setUserWeight(weight);
        user.setUserHeight(height);

        Main.getUserChoice(user);
    }

    /**
     * This function makes sure the user inputs a valid number because age has to be over 0.
     *
     * @return returns the age of the user
     */

    public static double getUserAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your age:");
        double userAge = scanner.nextDouble();
        //If the age is less than or equals to zero ask the user for input again.
        if (userAge < 0 || userAge == 0) {
            System.out.println("The input is not valid, height cannot be a negative number or zero");
            userAge = getUserAge();
        }
        return userAge;
    }

    /**
     * This function makes sure the user inputs a valid number because weight has to be over 0.
     *
     * @return returns the weight of the user
     */

    public static double getUserWeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your weight in Kilograms:");
        double userWeight = scanner.nextDouble();
        //If the weight is less than or equals to zero ask the user for input again.
        if (userWeight < 0 || userWeight == 0) {
            System.out.println("The input is not valid, height cannot be a negative number or zero");
            userWeight = getUserWeight();
        }
        return userWeight;
    }

    /**
     * This function makes sure the user inputs a valid number because height has to be over 0.
     *
     * @return returns the height of the user
     */


    public static double getUserHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your height in centimeters:");
        double userHeight = scanner.nextDouble();
        //If the height is less than or equals to zero ask the user for input again.
        if (userHeight < 0 || userHeight == 0) {
            System.out.println("The input is not valid, height cannot be a negative number or zero");
            userHeight = getUserHeight();
        }
        return userHeight;
    }


}
