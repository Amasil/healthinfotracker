/**
 * A health information tracking program
 * *Members:
 * Fabiha Fairuzz Subha
 * Amasil Rahim Zihad
 */
package mvh.app;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mvh.user.User;
import mvh.util.Calculations;
import mvh.util.Reader;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class MainController {
    //Store the data of user
    private User user;
    //A hashmap to organize the data
    public static HashMap<String, Object> userInfo = new HashMap<>();
    //An observable list is set up here which will display all users.
    public static ObservableList<String> users = FXCollections.observableArrayList();
    //Constant to Convert Pound to kg.
    final double lbToKg = 0.4536;
    @FXML
    FileChooser fileChooser = new FileChooser();
    @FXML
    private ComboBox<String> viewUser;
    @FXML
    private ComboBox<String> changeUser;
    @FXML
    private ComboBox<String> calorieUser;
    @FXML
    private ComboBox<String> viewInfoType;
    @FXML
    private ComboBox<String> exerciseChoice;
    @FXML
    private ComboBox<String> choiceOfSpeed;
    @FXML
    private ComboBox<String> userGender;
    @FXML
    private ComboBox<String> userGenderChange;
    @FXML
    private ComboBox<String> weightChoice;
    @FXML
    private ComboBox<String> weightChoiceChange;
    @FXML
    private ComboBox<String> heightChoice;
    @FXML
    private ComboBox<String> heightChoiceChange;
    @FXML
    private ComboBox<String> calorieViewType;
    @FXML
    private ComboBox<String> exerciseKGLB;
    @FXML
    private TextField userName;
    @FXML
    private TextField userAge;
    @FXML
    private TextField userWeight;
    @FXML
    private TextField userHeight;
    @FXML
    private TextField userNameChange;
    @FXML
    private TextField userAgeChange;
    @FXML
    private TextField userWeightChange;
    @FXML
    private TextField userHeightChange;
    @FXML
    private TextField calorieAmount;
    @FXML
    private TextField weightExercise;
    @FXML
    private Label leftStatus;
    @FXML
    private Label rightStatus;
    @FXML
    private TextArea viewDetails;
    @FXML
    private DatePicker inputDatePicker;
    @FXML
    private String name;
    @FXML
    private String gender;
    @FXML
    private boolean keyCheck;
    @FXML
    private double weight;
    @FXML
    private double height;
    @FXML
    private int age;

    /**
     * Starts the program and puts the choices in the choiceBox.
     */
    @FXML
    public void initialize() {
        //Setting Up the choice boxes with the required options
        //Clear will make sure the options aren't repeated
        //Set to get a default value

        //User Input User Number
        //User Gender
        userGender.getItems().clear();
        userGender.setValue("Male");
        userGender.getItems().addAll("Male", "Female", "Preferred not to say");

        userGenderChange.getItems().clear();
        userGenderChange.setValue("Male");
        userGenderChange.getItems().addAll("Male", "Female", "Preferred not to say");

        //User weight input kg or lb
        exerciseKGLB.getItems().clear();
        exerciseKGLB.setValue("KG");
        exerciseKGLB.getItems().addAll("KG", "LB");

        //User input height, cm or meter.
        heightChoice.getItems().clear();
        heightChoice.setValue("C.M.");
        heightChoice.getItems().addAll("C.M.", "Meter");

        //User input height, cm or meter.
        heightChoiceChange.getItems().clear();
        heightChoiceChange.setValue("C.M.");
        heightChoiceChange.getItems().addAll("C.M.", "Meter");

        //Special option
        //User number to add calorie burnt for
        calorieUser.getItems().clear();
        calorieUser.setValue("None");
        calorieUser.setItems(users);

        //Weight to be lost
        weightChoice.getItems().clear();
        weightChoice.setValue("KG");
        weightChoice.getItems().addAll("KG", "LB");

        //Weight to be lost
        weightChoiceChange.getItems().clear();
        weightChoiceChange.setValue("KG");
        weightChoiceChange.getItems().addAll("KG", "LB");

        //Calorie view option
        calorieViewType.getItems().clear();
        calorieViewType.setValue("Total Calorie Lost");
        calorieViewType.getItems().addAll("Total Calorie Lost", "Most amount burnt");

        //Exercise selection option
        exerciseChoice.getItems().clear();
        exerciseChoice.setValue("Running");
        exerciseChoice.getItems().addAll("Running", "Cycling");

        //View Info user number
        viewUser.getItems().clear();
        viewUser.setValue("None");
        viewUser.setItems(users);

        //addChange.getItems().clear();
        //addChange.setValue("Add User");
        //addChange.getItems().addAll("Add User", "Change");


        changeUser.getItems().clear();
        changeUser.setValue("None");
        changeUser.setItems(users);


        //BMI View
        viewInfoType.getItems().clear();
        viewInfoType.setValue("View BMI");
        viewInfoType.getItems().addAll("View BMI", "View Weight Status");
        choiceOfSpeed.setValue("6-7 km/h");

        inputDatePicker.setValue(LocalDate.now());
    }

    /**
     * A method made for setting the error message
     *
     * @param message Message that gets printed on status
     */
    private void extractedFail(String message) {
        leftStatus.setText(message);
        leftStatus.setTextFill(Color.RED);
        rightStatus.setText("");
    }


    /**
     * A method made for setting the colour of the status message
     */
    private void extractedSuccess() {
        rightStatus.setTextFill(Color.GREEN);
        leftStatus.setText("");
    }

    /**
     * Initialize the choice box to select the speed of exercise
     */
    @FXML
    void exerciseSpeed() {
        //If the option chosen is Running
        if (exerciseChoice.getValue().equals("Running")) {
            choiceOfSpeed.getItems().clear();
            choiceOfSpeed.setValue("6-7 km/h");
            choiceOfSpeed.getItems().addAll("6-7 km/h", "7-8 km/h", "9-11 km/h");
        }
        //If the option chosen is walking
        else {
            choiceOfSpeed.getItems().clear();
            choiceOfSpeed.setValue("16-19 km/h");
            choiceOfSpeed.getItems().addAll("16-19 km/h", "19-22 km/h", "22-25 km/h");
        }
    }

    /**
     * Adding an User
     */
    @FXML
    void createUser() {
        try {
            //IF any of the field is empty the program will show an Error.
            if (userName.getText().equals("") || userAge.getText().equals("") || userWeight.getText().equals("") || userHeight.getText().equals("")) {
                extractedFail("Please Enter All Information to Add User");
            } else {
                try {
                    //Getting the name and the gender of the user
                    name = userName.getText();
                    //Checking if that user exists or not
                    keyCheck = userInfo.containsKey(name);
                    //If the user doesn't exist we will add that user
                    if (keyCheck) {
                        extractedFail("The User " + name + " already exists.");
                    } else {
                        gender = String.valueOf(userGender.getValue());
                        //Trying To get valid input from the user
                        try {
                            age = Integer.parseInt(userAge.getText());
                            //Age Can't be Negative or 0
                            if (age < 0) {
                                extractedFail("Age can't be a negative number");
                            } else if (age == 0) {
                                extractedFail("Age can't be 0");
                            } else {
                                try {
                                    //If the option chosen is kilograms
                                    if (weightChoice.getValue().equals("KG")) {
                                        weight = Double.parseDouble(userWeight.getText());
                                    }
                                    //If the option chosen is pounds
                                    else {
                                        //Converting the lbs to kg
                                        weight = lbToKg * Double.parseDouble(userWeight.getText());
                                    }
                                    //Weight Can't be Negative or 0
                                    if (weight < 0) {
                                        extractedFail("Weight can't be a negative number");
                                    } else if (weight == 0) {
                                        extractedFail("Weight can't Be 0");
                                    } else {
                                        weight = Double.parseDouble(String.format("%.1f", weight));
                                        try {
                                            //If height is cm
                                            if (heightChoice.getValue().equals("C.M.")) {
                                                height = Double.parseDouble(userHeight.getText());
                                            } else {
                                                //Converting meter to cm
                                                height = 100 * Double.parseDouble(userHeight.getText());
                                            }
                                            //Height Can't be negative or 0
                                            if (height < 0) {
                                                extractedFail("Height can't be a negative number");
                                            } else if (height == 0) {
                                                extractedFail("Height can't be 0");
                                            } else {
                                                try {
                                                    //Creating the user
                                                    user = new User();
                                                    user.setName(name);
                                                    user.setAge(age);
                                                    user.setGender(gender);
                                                    user.setHeight(height);
                                                    user.setWeight(weight);
                                                    userInfo.put(name, user);
                                                    leftStatus.setText("");
                                                    rightStatus.setText("User Added! Choose from menu");
                                                    extractedSuccess();
                                                    //viewDetails.setText("");
                                                    //Adding the username to the choiceBox so that it can be viewed
                                                    users.add(name);
                                                    viewUser.setValue("Select");
                                                } catch (Exception e) {
                                                    extractedFail("Couldn't add user");
                                                }
                                            }
                                        } catch (Exception e) {
                                            extractedFail("Enter A Positive Number For Height");
                                        }
                                    }
                                } catch (Exception e) {
                                    extractedFail("Enter A Positive Number For Weight");
                                }
                            }
                        } catch (Exception e) {
                            extractedFail("Enter A Positive Number For Age");
                        }
                    }
                } catch (Exception e) {
                    extractedFail("Please Enter All Information");
                }
            }
        } catch (Exception e) {
            extractedFail("There was an error with the information");
        }
    }

    /**
     * Change the information of a user
     */
    @FXML
    void changeName() {
        name = changeUser.getValue();
        if (Objects.equals(name, "None") || (user == null)) {
            extractedFail("Please Select an user");
        } else if (userInfo.containsKey(name)) {
            User user = (User) userInfo.get(name);
            String newName = userNameChange.getText();
            user.setName(newName);
            user.setAge(user.getAge());
            user.setWeight(user.getWeight());
            user.setHeight(user.getHeight());
            user.setGender(user.getGender());
            userInfo.put(newName, user);
            leftStatus.setText("");
            rightStatus.setText("");
            extractedSuccess();
            users.remove(name);
            users.add(newName);
            viewUser.setValue("Select");
        }
    }


    /**
     * Change the information of a user
     */
    @FXML
    void changeAge() {
        name = changeUser.getValue();
        if (Objects.equals(name, "None") || (user == null)) {
            extractedFail("Please Select an user");
        } else if (userInfo.containsKey(name)) {
            User user = (User) userInfo.get(name);
            String newName = userNameChange.getText();
            user.setName(newName);
            user.setAge(user.getAge());
            user.setWeight(user.getWeight());
            user.setHeight(user.getHeight());
            user.setGender(user.getGender());
            userInfo.put(newName, user);
            leftStatus.setText("");
            rightStatus.setText("");
            extractedSuccess();
            users.remove(name);
            users.add(newName);
            viewUser.setValue("Select");
        }
    }

    /**
     * Change the information of a user
     */
    @FXML
    void changeGender() {
        name = changeUser.getValue();
        if (Objects.equals(name, "None") || (user == null)) {
            extractedFail("Please Select an user");
        } else if (userInfo.containsKey(name)) {
            User user = (User) userInfo.get(name);
            String newName = userNameChange.getText();
            user.setName(newName);
            user.setAge(user.getAge());
            user.setWeight(user.getWeight());
            user.setHeight(user.getHeight());
            user.setGender(user.getGender());
            userInfo.put(newName, user);
            leftStatus.setText("");
            rightStatus.setText("");
            extractedSuccess();
            users.remove(name);
            users.add(newName);
            viewUser.setValue("Select");
        }
    }

    /**
     * Change the information of a user
     */
    @FXML
    void changeWeight() {
        name = changeUser.getValue();
        if (Objects.equals(name, "None") || (user == null)) {
            extractedFail("Please Select an user");
        } else if (userInfo.containsKey(name)) {
            User user = (User) userInfo.get(name);
            String newName = userNameChange.getText();
            user.setName(newName);
            user.setAge(user.getAge());
            user.setWeight(user.getWeight());
            user.setHeight(user.getHeight());
            user.setGender(user.getGender());
            userInfo.put(newName, user);
            leftStatus.setText("");
            rightStatus.setText("");
            extractedSuccess();
            users.remove(name);
            users.add(newName);
            viewUser.setValue("Select");
        }
    }

    /**
     * Change the information of a user
     */
    @FXML
    void changeHeight() {
        name = changeUser.getValue();
        if (Objects.equals(name, "None") || (user == null)) {
            extractedFail("Please Select an user");
        } else if (userInfo.containsKey(name)) {
            User user = (User) userInfo.get(name);
            String newName = userNameChange.getText();
            user.setName(newName);
            user.setAge(user.getAge());
            user.setWeight(user.getWeight());
            user.setHeight(user.getHeight());
            user.setGender(user.getGender());
            userInfo.put(newName, user);
            leftStatus.setText("");
            rightStatus.setText("");
            extractedSuccess();
            users.remove(name);
            users.add(newName);
            viewUser.setValue("Select");
        }
    }

    /**
     * Change the information of a user
     */
    @FXML
    void changeUser() {
        try {
            //If any of the field is empty the program will show an Error.
            if (userName.getText().equals("") || userAge.getText().equals("") || userWeight.getText().equals("") || userHeight.getText().equals("")) {
                extractedFail("Please Enter All Information to Change User");
            } else {
                name = userName.getText();
                //Checking if that user exists or not
                keyCheck = userInfo.containsKey(name);
                //If the user doesn't exist we will add that user
                if (!keyCheck) {
                    try {
                        //Getting the name and the gender of the user
                        gender = String.valueOf(userGender.getValue());
                        //Trying To get valid input from the user
                        try {
                            age = Integer.parseInt(userAge.getText());
                            //Age Can't be Negative or 0
                            if (age < 0) {
                                extractedFail("Age can't be a negative number");
                            } else if (age == 0) {
                                extractedFail("Age can't be 0");
                            } else {
                                try {
                                    //If the option chosen is kilograms
                                    if (weightChoice.getValue().equals("KG")) {
                                        weight = Double.parseDouble(userWeight.getText());
                                    }
                                    //If the option chosen is pounds
                                    else {
                                        //Converting the lbs to kg
                                        weight = lbToKg * Double.parseDouble(userWeight.getText());
                                    }
                                    //Weight Can't be Negative or 0
                                    if (weight < 0) {
                                        extractedFail("Weight can't be a negative number");
                                    } else if (weight == 0) {
                                        extractedFail("Weight can't Be 0");
                                    } else {
                                        weight = Double.parseDouble(String.format("%.1f", weight));
                                        try {
                                            //If height is cm
                                            if (heightChoice.getValue().equals("C.M.")) {
                                                height = Double.parseDouble(userHeight.getText());
                                            } else {
                                                //Converting meter to cm
                                                height = 100 * Double.parseDouble(userHeight.getText());
                                            }
                                            //Height Can't be negative or 0
                                            if (height < 0) {
                                                extractedFail("Height can't be a negative number");
                                            } else if (height == 0) {
                                                extractedFail("Height can't be 0");
                                            } else {
                                                try {
                                                    //Creating the user
                                                    // user = new User(name, age, gender, weight, height);
                                                    userInfo.put(name, user);
                                                    leftStatus.setText("");
                                                    rightStatus.setText("User Didn't Exist so Added User! Choose from menu");
                                                    extractedSuccess();
                                                    viewDetails.setText("");
                                                    users.add(name);
                                                    viewUser.setValue("Select");
                                                } catch (Exception e) {
                                                    extractedFail("Couldn't add user");
                                                }
                                            }
                                        } catch (Exception e) {
                                            extractedFail("Enter A Positive Number For Height");
                                        }
                                    }
                                } catch (Exception e) {
                                    extractedFail("Enter A Positive Number For Weight");
                                }
                            }
                        } catch (Exception e) {
                            extractedFail("Enter A Positive Number For Age");
                        }
                    } catch (Exception e) {
                        extractedFail("Please Enter All Information");
                    }
                }
                //If the user exists we replace the user
                if (keyCheck) {
                    //Getting the name and the gender of the user
                    name = userName.getText();
                    gender = String.valueOf(userGender.getValue());
                    //Trying To get valid input from the user
                    try {
                        age = Integer.parseInt(userAge.getText());
                        //Age Can't be Negative or 0
                        if (age < 0) {
                            extractedFail("Age can't be a negative number");
                        } else if (age == 0) {
                            extractedFail("Age can't be 0");
                        } else {
                            try {
                                //If the option chosen is kilograms
                                if (weightChoice.getValue().equals("KG")) {
                                    weight = Double.parseDouble(userWeight.getText());
                                }
                                //If the option chosen is anything else
                                else {
                                    //Converting the lbs to kg
                                    weight = lbToKg * Double.parseDouble(userWeight.getText());
                                }
                                //Weight Can't be Negative or 0
                                if (weight < 0) {
                                    extractedFail("Weight can't be a negative number");
                                } else if (weight == 0) {
                                    extractedFail("Weight can't Be 0");
                                } else {
                                    weight = Double.parseDouble(String.format("%.1f", weight));
                                    try {
                                        //If height is cm
                                        if (heightChoice.getValue().equals("C.M.")) {
                                            height = Double.parseDouble(userHeight.getText());
                                        } else {
                                            //Converting meter to cm
                                            height = 100 * Double.parseDouble(userHeight.getText());
                                        }
                                        //Height can't be negative or 0
                                        if (height < 0) {
                                            extractedFail("Height can't' be a negative number");
                                        } else if (height == 0) {
                                            extractedFail("Height can't be 0");
                                        } else {
                                            try {
                                                //Creating the user
                                                //user = new User(name, age, gender, weight, height);
                                                userInfo.put(name, user);
                                                rightStatus.setText("Changed Information! Choose from menu");
                                                extractedSuccess();
                                                viewDetails.setText("");
                                                users.add(name);
                                                viewUser.setValue("Select");
                                            } catch (Exception e) {
                                                extractedFail("Couldn't change user Information");
                                            }
                                        }
                                    } catch (Exception e) {
                                        extractedFail("Enter A Positive Number For Height");
                                    }
                                }
                            } catch (Exception e) {
                                extractedFail("Enter A Positive Number For Weight");
                            }
                        }
                    } catch (Exception e) {
                        extractedFail("Enter A Positive Number For Age");
                    }
                }
            }
        } catch (Exception e) {
            extractedFail("Please Enter All Information");
        }
    }


    /**
     * Allows the user to view Information of a user
     */
    @FXML
    void viewInfo() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserDetails.fxml"));
        Parent root = loader.load();
        UserDetailsController userDetailsController = loader.getController();

        try {
            //Getting the username
            name = viewUser.getValue();
            if (name.equals("Select")) {
                extractedFail("Please Select an user");
            } else {
                System.out.println(userInfo.get(name).toString());
                userDetailsController.viewUserDetails.setText(userInfo.get(name).toString());
                rightStatus.setText("User Info Printed! View above");
                extractedSuccess();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setTitle("User Information");
                stage.show();
            }
            //Exception handled
        } catch (Exception e) {
            extractedFail("No user Information found! Add user or Load From File");
        }
    }


    /**
     * Allows the user to choose their choice of exercise and get feedbacks
     */
    @FXML
    void viewExercise() {
        try {
            //Getting the user number
            name = viewUser.getValue();
            keyCheck = userInfo.containsKey(name);
            try {
                if (weightExercise.getText().equals("")) {
                    extractedFail("Please Enter A Weight Goal");
                } else {
                    try {
                        //If the option chosen is kilograms
                        double exerciseWeight;
                        if (exerciseKGLB.getValue().equals("KG")) {
                            exerciseWeight = Double.parseDouble(weightExercise.getText());
                        }
                        //If the option chosen is anything else
                        else {
                            //Converting the lbs to kg
                            exerciseWeight = lbToKg * Double.parseDouble(weightExercise.getText());
                        }
                        if (exerciseWeight <= 0) {
                            extractedFail("Please Enter A Positive Weight Goal");
                        } else {
                            exerciseWeight = Double.parseDouble(String.format("%.1f", exerciseWeight));
                            //Getting the user choice
                            String choice = exerciseChoice.getValue();
                            //Getting the speed of exercise
                            String speed = choiceOfSpeed.getValue();
                            //Checking if that user exists or not
                            if (keyCheck) {
                                //Getting the user info associated with the user number
                                user = (User) userInfo.get(name);
                                //weight = user.getUserWeight();
                                //Getting the weight difference.
                                double weightDifference = weight - exerciseWeight;
                                //If the weight difference is 0
                                if (weightDifference < 0) {
                                    leftStatus.setText("");
                                    rightStatus.setText("");
                                    viewDetails.setText("Just Eat More.");
                                }
                                //If the weight difference is negative.
                                else if (weightDifference == 0) {
                                    leftStatus.setText("");
                                    rightStatus.setText("");
                                    viewDetails.setText("You are already at this weight");
                                } else {

                                    //Calling the estimate calories option method
                                    double calories = Calculations.estimateCalories(weightDifference);

                                    //Calling the exercise option method
                                    String exercise = Calculations.estimateExercise(speed, choice, calories, weight, weightDifference, exerciseWeight);
                                    viewDetails.setText(exercise);
                                    rightStatus.setText("Requested info shown!");
                                    extractedSuccess();
                                }
                            } else {
                                extractedFail("No user Information found! Add user or Load From File");
                            }
                        }
                    } catch (Exception e) {
                        extractedFail("Enter A positive number for weight goal");
                    }
                }
            } catch (Exception e) {
                extractedFail("Enter A positive number for weight goal");
            }
        } catch (Exception e) {
            extractedFail("No user Information found! Add user or Load From File");
        }
    }

    /**
     * Allows the user to check their BMI
     */
    @FXML
    void viewBMI() {
        try {
            //Getting the user number
            name = viewUser.getValue();
            //Checking if that user exists or not
            keyCheck = userInfo.containsKey(name);
            //If the option chosen is view Bmi
            if (viewInfoType.getValue().equals("View BMI")) {
                //If the user exists
                if (keyCheck) {
                    //Gets the user information to view information
                    user = (User) userInfo.get(name);
                    // weight = user.getUserWeight();
//                    height = user.getUserHeight();

                    viewDetails.setText(name + "’s " + "BMI is " + Calculations.bmi(weight, height) + ".");

                    rightStatus.setText("Requested info shown!");
                    extractedSuccess();
                } else {
                    extractedFail("No user Information found! Add user or Load From File");
                }
            }
            //If the option chosen is weight status
            else {
                //If the user exists
                if (keyCheck) {
                    //Gets the user information to view information
                    user = (User) userInfo.get(name);
                    //    weight = user.getUserWeight();
                    //  height = user.getUserHeight();

                    viewDetails.setText(name + " is " + Calculations.bmiCompare(weight, height) + ".");

                    rightStatus.setText("Requested info shown!");
                    extractedSuccess();
                } else {
                    extractedFail("No user Information found! Add user or Load From File");
                }
            }
        } catch (Exception e) {
            extractedFail("No user Information found! Add user or Load From File");
        }
    }

    /**
     * Allows the user to add calories burnt to a file.
     */
    @FXML
    void addCalorieBurnt() {
//        try {
//            //Getting the burnt calorie amount from the user
//            int userNumber = calorieUser.getValue();
//            //If the user didn't input anything it will ask them to input
//            if (calorieAmount.getText().equals("")) {
//                extractedFail("Please Enter Calorie Amount");
//            } else {
//                try {
//                    int calorie = Integer.parseInt(calorieAmount.getText());
//                    //Calorie Amount shouldn't be a negative number
//                    if (calorie < 0) {
//                        extractedFail("Please Enter 0 or a positive number for calorie Amount");
//                    } else {
//                        //Creating a hashmap with the users' calorie information
//                        HashMap<Integer, String> calorieInfo = new HashMap<>();
//                        calorieInfo.put(userNumber, String.valueOf(calorie));
//                        //Writing the information to a file
//                        Writer.writer(calorieInfo);
//                        rightStatus.setText("Calorie added to file!");
//                        extractedSuccess();
//                        viewDetails.setText("");
//                    }
//                } catch (Exception e) {
//                    extractedFail("Please Enter 0 or a positive number for calorie Amount");
//                }
//            }
//        } catch (Exception e) {
//            extractedFail("Cannot be added to file!");
//        }
    }

    /**
     * Allows the user to check the calorie info of the user
     */
    @FXML
    void viewCalorieInfo() {

        name = viewUser.getValue();
        keyCheck = userInfo.containsKey(name);
        try {
            //Creating a hashmap to store the calories of the user read from a file
            //Checking if the file has that key
            //Getting the user choice
            if (calorieViewType.getValue().equals("Total Calorie Lost")) {
                if (keyCheck) {
                    try {
                        File outFile = new File("User.txt");
                        HashMap<String, ArrayList<Integer>> calorieInfo = Reader.outReader(name, outFile);
                        //Calling the total calories' method to get the output
                        int totalCalories = Calculations.getTotalCalories(name, calorieInfo);
                        viewDetails.setText("Total calories lost " + totalCalories);
                        rightStatus.setText("Requested info shown!");
                        extractedSuccess();
                    } catch (Exception e) {
                        extractedFail("Couldn't Read File");
                    }
                } else {
                    extractedFail("No user Information found! Add user or Load From File");
                }

            } else {
                if (keyCheck) {
                    try {
                        //Calling the max calories' method to get the output
                        File outFile = new File("User.txt");
                        HashMap<String, ArrayList<Integer>> calorieInfo = Reader.outReader(name, outFile);
                        int maxCalories = Calculations.getMaxCalories(name, calorieInfo);
                        viewDetails.setText("Maximum calories lost in a day is" + maxCalories);
                        rightStatus.setText("Requested info shown!");
                        extractedSuccess();
                    } catch (Exception e) {
                        extractedFail("No user Information found! Add user or Load From File");
                    }
                } else {
                    extractedFail("No user Information found! Add user or Load From File");
                }
            }
        } catch (Exception e) {
            extractedFail("No user Information found! Add user or Load From File");
        }
    }

    /**
     * Allows the user to load a file and get user information from that file
     */
    @FXML
    void loadButton() {
        try {
            //File chooser setup
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text File", "*.txt"));
            fileChooser.setTitle("Open File");
            File file = fileChooser.showOpenDialog(new Stage());

            //Calling the reader method to read the file the user has loaded
            Reader.reader(file);
            if (userInfo.isEmpty()) {
                extractedFail("There was a problem reading the file");
            } else {
                rightStatus.setText("File opened");
                extractedSuccess();
                viewUser.setValue("Select");
                leftStatus.setText("");
            }
            //Exception handled
        } catch (Exception e) {
            extractedFail("File cannot be read! Choose Another File");
        }
    }

    /**
     * Allows the user to save the information of the user to a file
     */
    @FXML
    void saveButton() {
        //Surrounding with a try/catch to handle exceptions
        //Calling the writer to write information in it
        try {
            //Checking if there is any user or not
            if (userInfo.isEmpty()) {
                extractedFail("Please Add users First");
            } else {
                //File chooser setup
                fileChooser.setInitialDirectory(new File("."));
                fileChooser.setInitialFileName("UserInfo.txt");
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text File", "*.txt"));
                File fileSave = fileChooser.showSaveDialog(new Stage());
                //If file doesn't exist we create the file
                if (!fileSave.exists()) {
                    try {
                        fileSave.createNewFile();
                    } catch (Exception e) {
                        //The Error message
                        extractedFail("Error: Could not create file");
                    }
                }
                //Then if the file exists and be written on
                if (fileSave.exists() && fileSave.canWrite()) {
                    try {
                        //Looping through the hashmap to get the information of all the user and then writing them to the file
//                        for (String i : userInfo.keySet()) {
//                            user = (User) userInfo.get(i);
//                            //Assigning the info to the variables
//                        //    name = user.getUserName();
//                       //     String age = String.valueOf(user.getUserAge());
//                            //Abbreviating the gender to write to a file
//
//                       //     if (user.getUserGender().equals("Male")) {
//                                gender = "M";
//                            }
//                            if (user.getUserGender().equals("Female")) {
//                                gender = "F";
//                            }
//                            if (user.getUserGender().equals("Preferred not to say")) {
//                                gender = "N";
//                            }
//                            String weight = String.valueOf(user.getUserWeight());
//                            String height = String.valueOf(user.getUserHeight());
//                            //Writing them to the file.
//                            Writer.fileWriter(fileSave, name, age, gender, weight, height);
//                        }
                        rightStatus.setText("File Saved");
                        extractedSuccess();
                        viewDetails.setText("");
                    } catch (Exception e) {
                        //The Error message
                        extractedFail("Error: Could not write to file");
                    }
                }
            }
            //Catching exception
        } catch (Exception e) {
            extractedFail("Add Users First");
        }
    }

    /**
     * Shows the information of the creator of the program.
     */
    @FXML
    void viewAbout() {
        //Creating the alert box
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("About Authors");
        alert.setContentText("""
                This is fitness tracking program.
                Version: 3
                               
                Amasil Rahim Zihad
                Email: amasilrahim.zihad@ucalgary.ca
                """);
        //Showing the alert
        alert.showAndWait();
    }

    /**
     * Allows the user to quit the program.
     */
    @FXML
    void closeButton() {
        //Exiting the application
        Platform.exit();
    }
}
