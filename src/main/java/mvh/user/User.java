/**
 * A health information tracking program
 * *Members:
 * Fabiha Fairuzz Subha
 * Amasil Rahim Zihad
 */
package mvh.user;

public class User {


    public String userName;
    public String userGender;
    public double userAge;
    public double userWeight;
    public double userHeight;

    public User(String name, double age, String gender, double weight, double height) {
        userName = name;
        userGender = gender;
        userAge = age;
        userWeight = weight;
        userHeight = height;
    }

    //Getter
    public String getUserName() {
        return userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public double getUserAge() {
        return userAge;
    }

    public double getUserWeight() {
        return userWeight;
    }

    public double getUserHeight() {
        return userHeight;
    }

    //ToString method created
    public String toString() {
        return String.format("""
                Name: %s\s
                Gender: %s\s
                Age: %s\s
                Weight in Kgs: %s\s
                Height in centimeters: %s\s
                """, userName, userGender, (int) userAge, userWeight, userHeight);
    }

}
