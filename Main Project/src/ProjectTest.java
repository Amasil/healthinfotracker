/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * <p>
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 1 Tutorial 10
 */


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {
    /**
     *Testing for various height and weight and to see if the output matches our desired output
     */

    @Test
    void BMITest_1() {
        double weight = 56;
        double height = 1.56;

        String expResult = "23.01";
        String actResult = Project.BMI(weight, height);
        assertEquals(expResult,actResult);
    }
    @Test
    void BMITest_2() {
        double weight = 40;
        double height = 1.70;

        String expResult = "13.84";
        String actResult = Project.BMI(weight, height);
        assertEquals(expResult,actResult);
    }
    @Test
    void BMITest_3() {
        double weight = 79;
        double height = 1.68;

        String expResult = "27.99";
        String actResult = Project.BMI(weight, height);
        assertEquals(expResult,actResult);
    }
    @Test
    void BMITest_4() {
        double weight = 89;
        double height = 1.69;

        String expResult = "31.16";
        String actResult = Project.BMI(weight, height);
        assertEquals(expResult,actResult);
    }

    /**
     * Testing to see if bmi comparison produces the desired result.
     */
    //For normal weight
    @Test
    void BMI_CompareTest_1() {
        double weight = 56;
        double height = 1.56;

        String expResult = "You are normal weight";
        String actResult = Project.BMI_Compare(weight, height);
        assertEquals(expResult, actResult);
    }
    //For underweight
    @Test
    void BMI_CompareTest_2() {
        double weight = 40;
        double height = 1.70;

        String expResult = "You are underweight";
        String actResult = Project.BMI_Compare(weight, height);
        assertEquals(expResult, actResult);
    }
    //For overweight
    @Test
    void BMI_CompareTest_3() {
        double weight = 79;
        double height = 1.68;

        String expResult = "You are overweight";
        String actResult = Project.BMI_Compare(weight, height);
        assertEquals(expResult, actResult);
    }
    //For obese
    @Test
    void BMI_CompareTest_4() {
        double weight = 89;
        double height = 1.69;

        String expResult = "You are obese";
        String actResult = Project.BMI_Compare(weight, height);
        assertEquals(expResult, actResult);
    }

    //Test to see if estimated calories needed to reach a certain goal is the same as desired
    @Test
    void estimateCaloriesTest_1() {
        int kg_input = 2;

        int expResult = 15400;
        int actResult = Project.estimateCalories(kg_input);
        assertEquals(expResult, actResult);
    }
    @Test
    void estimateCaloriesTest_2() {
        int kg_input = 6;

        int expResult = 46200;
        int actResult = Project.estimateCalories(kg_input);
        assertEquals(expResult, actResult);
    }
    @Test
    void estimateCaloriesTest_3() {
        int kg_input = 10;

        int expResult = 77000;
        int actResult = Project.estimateCalories(kg_input);
        assertEquals(expResult, actResult);
    }
    @Test
    void estimateCaloriesTest_4() {
        int kg_input = 9;

        int expResult = 69300;
        int actResult = Project.estimateCalories(kg_input);
        assertEquals(expResult, actResult);
    }







}