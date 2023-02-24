/**
 * A health information tracking program
 * *Members:
 * Fabiha Fairuzz Subha
 * Amasil Rahim Zihad
 */
package mvh.user;

public class User {


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
