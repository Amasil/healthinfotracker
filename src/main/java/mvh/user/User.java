/**
 * A health information tracking program
 * *Members:
 * Fabiha Fairuzz Subha
 * Amasil Rahim Zihad
 */
package mvh.user;

public class User {


    //    public String userName;
//    public String userGender;
//    public double userAge;
//    public double userWeight;
//    public double userHeight;
//
//    public User(String name, double age, String gender, double weight, double height) {
//        userName = name;
//        userGender = gender;
//        userAge = age;
//        userWeight = weight;
//        userHeight = height;
//    }
//
//    //Getter
//    public String getUserName() {
//        return userName;
//    }
//
//    public String getUserGender() {
//        return userGender;
//    }
//
//    public double getUserAge() {
//        return userAge;
//    }
//
//    public double getUserWeight() {
//        return userWeight;
//    }
//
//    public double getUserHeight() {
//        return userHeight;
//    }
//
//    public void setName(String name) {
//    }
//
//    public void setAge(int age) {
//    }
//
//    public void setGender(String gender) {
//    }
//
//    public void setWeight(double weight) {
//    }
//
//    public void setHeight(double height) {
//    }


    private String name;
    private int age;
    private String gender;
    private double weight;
    private double height;

    public User() {
        this.name = "";
        this.age = 0;
        this.gender = "";
        this.weight = 0.0;
        this.height = 0.0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    //ToString method created
    public String toString() {
        return String.format("""
                Name:\t%s\s
                Gender:\t%s\s
                Age:\t%s\s
                Weight:\t%s kg\s
                Height:\t%s c.m\s
                """, name, gender, age, weight, height);
    }

}
