import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    void BMITest_1() {
        double weight = 56;
        double height = 156;

        String expResult = "23.01";
        String actResult = Project.BMI(weight, height);
        assertEquals(expResult,actResult);
    }
    @Test
    void BMITest_2() {
        double weight = 40;
        double height = 170;

        String expResult = "13.84";
        String actResult = Project.BMI(weight, height);
        assertEquals(expResult,actResult);
    }
    @Test
    void BMITest_3() {
        double weight = 79;
        double height = 168;

        String expResult = "27.99";
        String actResult = Project.BMI(weight, height);
        assertEquals(expResult,actResult);
    }
    @Test
    void BMITest_4() {
        double weight = 89;
        double height = 169;

        String expResult = "31.16";
        String actResult = Project.BMI(weight, height);
        assertEquals(expResult,actResult);
    }


    @Test
    void BMI_CompareTest_1() {
        String BMI = "23.01";

        String expResult = "You are normal weight";
        String actResult = Project.BMI_Compare(BMI);
        assertEquals(expResult, actResult);
    }
    @Test
    void BMI_CompareTest_2() {
        String BMI = "13.84";

        String expResult = "You are underweight";
        String actResult = Project.BMI_Compare(BMI);
        assertEquals(expResult, actResult);
    }
    @Test
    void BMI_CompareTest_3() {
        String BMI = "27.99";

        String expResult = "You are overweight";
        String actResult = Project.BMI_Compare(BMI);
        assertEquals(expResult, actResult);
    }
    @Test
    void BMI_CompareTest_4() {
        String BMI = "31.16";

        String expResult = "You are obese";
        String actResult = Project.BMI_Compare(BMI);
        assertEquals(expResult, actResult);
    }


    @Test
    void estimateCalories() {

    }
}