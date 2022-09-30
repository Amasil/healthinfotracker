/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * Date: March 2nd, 2022- April 15, 2022.
 * Tutorial 05 and Tutorial 10.
 * Project Final Submission
 */
package mvh.util;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Calculations {
    //Constants

    //Calories needed to burn 1 kg
    final static int CALORIES = 7700;

    //Conversion from cm square to meter square
    final static int CONVERSION = 10000;

    /**
     * Calculates the BMI of the user and returns it in a formatted to a two decimal point.
     *
     * @param weight The weight of the user
     * @param height The height of the user
     * @return The BMI in formatted to two decimal points
     */
    public static String bmi(double weight, double height) {
        double calculatedBMI = weight * CONVERSION / (height * height);
        return String.format("%.2f", calculatedBMI);

    }

    /**
     * Compares the bmi of the user and checks the weight status
     *
     * @param weight The weight of the user
     * @param height The height of the user
     * @return Returns the result of comparison as a string
     */
    public static String bmiCompare(double weight, double height) {
        double bmi = weight * CONVERSION / (height * height);
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";

    }

    /**
     * Calculates the estimated calories needed to reach a certain goal
     *
     * @param kg_input The kg amount entered by the user
     * @return Returns the estimated calories needed
     */

    public static double estimateCalories(double kg_input) {
        return (kg_input * CALORIES);
    }


    /**
     * Calculates how much exercise the user needs to do to reach a certain goal
     *
     * @param total_calories Total number of calories needed to burn to lose the user inputted weight
     * @param weight         The weight of the user
     */
    public static String estimateExercise(String choiceOfSpeed, String exerciseChoice, double total_calories, double weight, double weightDiff, double weightGoal) {

        String output = "";
        if (exerciseChoice.equals("Cycling")) {
            //MET constant value for cycling
            //Met are constant values, so we just assign them to an array.
            //Formula from omni calculator https://www.omnicalculator.com/sports/calories-burned-biking
            //https://www.bing.com/images/search?view=detailV2&ccid=yadDUQDJ&id=87120523BFFA7EC2BB481F4F72EA93EEF131C32A&thid=OIP.yadDUQDJzCrTGscl7VKGxwHaER&mediaurl=https%3a%2f%2fwww.researchgate.net%2fprofile%2fPongpisit_Wuttidittachotti%2fpublication%2f269927658%2ffigure%2fdownload%2ftbl2%2fAS%3a668512750161926%401536397268552%2fExamples-of-MET-values-for-cycling-jogging-and-walking.png&cdnurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fR.c9a7435100c9cc2ad31ac725ed5286c7%3frik%3dKsMx8e6T6nJPHw%26pid%3dImgRaw%26r%3d0&exph=491&expw=850&q=cycling+met+chart&simid=608045430922565507&FORM=IRPRST&ck=9961DBCB589AF095617EC992BB417D2E&selectedIndex=0&idpp=overlayview&ajaxhist=0&ajaxserp=0
            int[] array = {6, 8, 10}; //Order respective to the options below

            switch (choiceOfSpeed) {
                case "16-19 km/h" -> {

                    double ex_burnt = (total_calories * 200) / (array[0] * weight * 3.5 * 60);
                    //Assigning the string to variable
                    output = "You need to cycle " + String.format("%.1f", ex_burnt) + " hours" + "\n" + "at 16-19 km/h to burn " + String.format("%.1f", total_calories ) + " calories" + "\n" + "and lose " + weightDiff + " kgs to reach " + "\n" + "the weight goal of " + weightGoal + " kgs";

                }
                case "19-22 km/h" -> {

                    double ex_burnt = (total_calories * 200) / (array[1] * weight * 3.5 * 60);
                    //Assigning the string to variable
                    output = "You need to cycle " + String.format("%.1f", ex_burnt) + " hours" + "\n" + "at 19-22 km/h to burn " + String.format("%.1f", total_calories ) + " calories" + "\n" + "and lose " + weightDiff + " kgs to reach " + "\n" + "the weight goal of " + weightGoal + " kgs";

                }
                case "22-25 km/h" -> {

                    double ex_burnt = (total_calories * 200) / (array[2] * weight * 3.5 * 60);
                    //Assigning the string to variable
                    output = "You need to cycle " + String.format("%.1f", ex_burnt) + " hours" + "\n" + "at 22-25 km/h to burn " + String.format("%.1f", total_calories ) + " calories" + "\n" + "and lose " + weightDiff + " kgs to reach " + "\n" + "the weight goal of " + weightGoal + " kgs";
                }
            }

        } else if (exerciseChoice.equals("Running")) {

            //MET constant value for running
            //Met are constant values, so we just assign them to an array.
            //Formula from omni calculator https://www.omnicalculator.com/sports/calories-burned-biking
            //https://www.bing.com/images/search?view=detailV2&ccid=yadDUQDJ&id=87120523BFFA7EC2BB481F4F72EA93EEF131C32A&thid=OIP.yadDUQDJzCrTGscl7VKGxwHaER&mediaurl=https%3a%2f%2fwww.researchgate.net%2fprofile%2fPongpisit_Wuttidittachotti%2fpublication%2f269927658%2ffigure%2fdownload%2ftbl2%2fAS%3a668512750161926%401536397268552%2fExamples-of-MET-values-for-cycling-jogging-and-walking.png&cdnurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fR.c9a7435100c9cc2ad31ac725ed5286c7%3frik%3dKsMx8e6T6nJPHw%26pid%3dImgRaw%26r%3d0&exph=491&expw=850&q=cycling+met+chart&simid=608045430922565507&FORM=IRPRST&ck=9961DBCB589AF095617EC992BB417D2E&selectedIndex=0&idpp=overlayview&ajaxhist=0&ajaxserp=0

            int[] array2 = {5, 8, 11}; //Order respective to the options below

            switch (choiceOfSpeed) {
                case "6-7 km/h" -> {

                    double ex_burnt = (total_calories * 200) / (array2[0] * weight * 3.5 * 60);
                    //Assigning the string to variable
                    output = "You need to run " + String.format("%.1f", ex_burnt) + " hours" + "\n" + "at 6-7 km/h to burn " + String.format("%.1f", total_calories ) + " calories" + "\n" + "and lose " + weightDiff + " kgs to reach " + "\n" + "the weight goal of " + weightGoal + " kgs";

                }
                case "7-8 km/h" -> {

                    double ex_burnt = (total_calories * 200) / (array2[1] * weight * 3.5 * 60);
                    //Assigning the string to variable
                    output = "You need to run " + String.format("%.1f", ex_burnt) + " hours" + "\n" + "at 7-8 km/h to burn " + String.format("%.1f", total_calories ) + " calories" + "\n" + "and lose " + weightDiff + " kgs to reach " + "\n" + "the weight goal of " + weightGoal + " kgs";

                }
                case "9-11 km/h" -> {

                    double ex_burnt = (total_calories * 200) / (array2[2] * weight * 3.5 * 60);
                    //Assigning the string to variable
                    output = "You need to run " + String.format("%.1f", ex_burnt) + " hours" + "\n" + "at 9-11 km/h to burn " + String.format("%.1f", total_calories ) + " calories" + "\n" + "and lose " + weightDiff + " kgs to reach " + "\n" + "the weight goal of " + weightGoal + " kgs";
                }
            }
        }
        return output;
    }

    /**
     * @param calInfo The arraylist containing the data read from the saved file
     * @return Number of total calories burnt
     */
    public static int getTotalCalories(String inputName, HashMap<String, ArrayList<Integer>> calInfo) {

        int sum = 0;
        //Initialising an arraylist
        ArrayList<Integer> calories;
        boolean keyCheck = calInfo.containsKey(inputName);
        if (keyCheck) {
            try {
                //Getting the information of the user using the key of the hashmap
                calories = calInfo.get(inputName);

                //Looping through the arraylist assigned to the user key of the hashmap
                for (int i : calories) {
                    //Adding the calories
                    sum = sum + i;
                }
                //Exception handled
            } catch (NumberFormatException e) {
                System.err.println("Cannot convert string to integer type");
            }
        }
        return sum;
    }

    /**
     * Gets the maximum number of calories burnt in a day
     *
     * @param calInfo The arraylist containing the data read from the saved file
     */
    public static int getMaxCalories(String inputName, HashMap<String, ArrayList<Integer>> calInfo) {

        ArrayList<Integer> calories = null;
        boolean keyCheck = calInfo.containsKey(inputName);
        //Loop through the arrayList and add information
        if (keyCheck) {
            try {
                //Getting the information of the user using the key of the hashmap
                calories = calInfo.get(inputName);

                //Exception handled
            } catch (NumberFormatException nfe) {
                System.err.println("Cannot convert string to integer type");
            }
        }
        //Sorting to get calories in order.
        assert calories != null;
        Collections.sort(calories);
        return calories.get(calories.size() - 1);
    }
}
