/**
 * A health information tracking program
 * Amasil Rahim Zihad
 * Code heavily adapted from my university project done with Fabiha Fairuzz Subha.
 */
package mvh.app;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mvh.user.User;
import mvh.util.Calculations;
import mvh.util.Reader;
import mvh.util.Writer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;


@SuppressWarnings("ResultOfMethodCallIgnored")
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
    private ComboBox<String> exerciseKGLB;
    @FXML
    private ComboBox<String> changeOptions;
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
    private TextField weightExercise;
    @FXML
    private Label leftStatus;
    @FXML
    private Label rightStatus;
    @FXML
    private String name;
    @FXML
    private double weight;
    @FXML
    private double height;


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

        //Weight to be lost
        weightChoice.getItems().clear();
        weightChoice.setValue("KG");
        weightChoice.getItems().addAll("KG", "LB");

        //Weight to be lost
        weightChoiceChange.getItems().clear();
        weightChoiceChange.setValue("KG");
        weightChoiceChange.getItems().addAll("KG", "LB");

        //Exercise selection option
        exerciseChoice.getItems().clear();
        exerciseChoice.setValue("Running");
        exerciseChoice.getItems().addAll("Running", "Cycling");

        //Exercise selection option
        changeOptions.getItems().clear();
        changeOptions.setValue("Select");
        changeOptions.getItems().addAll("Name", "Age", "Gender", "Weight", "Height");

        //View Info user number
        viewUser.getItems().clear();
        viewUser.setValue("None");
        viewUser.setItems(users);


        changeUser.getItems().clear();
        changeUser.setValue("None");
        changeUser.setItems(users);

        //BMI View
        viewInfoType.getItems().clear();
        viewInfoType.setValue("View BMI");
        viewInfoType.getItems().addAll("View BMI", "View Weight Status");
        choiceOfSpeed.setValue("6-7 km/h");

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
                    boolean keyCheck = userInfo.containsKey(name);
                    //If the user doesn't exist we will add that user
                    if (keyCheck) {
                        extractedFail("The User " + name + " already exists.");
                    } else {
                        String gender = String.valueOf(userGender.getValue());
                        //Trying To get valid input from the user
                        try {
                            int age = Integer.parseInt(userAge.getText());
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
                                                    users.add(name);
                                                    viewUser.setValue("Select");
                                                    changeUser.setValue("Select");
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

    @FXML
    void changeTrigger() {
        try {
            name = changeUser.getValue();
            if (Objects.equals(name, "None") || (userInfo == null)) {
                extractedFail("Please Add Users First");
            } else if (Objects.equals(name, "Select")) {
                extractedFail("Please select an User");
            } else {
                String changeOptionValue = changeOptions.getValue();
                if (Objects.equals(changeOptionValue, "Name")) {
                    changeName();
                } else if (Objects.equals(changeOptionValue, "Age")) {
                    changeAge();
                } else if (Objects.equals(changeOptionValue, "Gender")) {
                    changeGender();
                } else if (Objects.equals(changeOptionValue, "Weight")) {
                    changeWeight();
                } else if (Objects.equals(changeOptionValue, "Height")) {
                    changeHeight();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Change the information of a user
     */
    @FXML
    void changeName() {
        try {
            name = changeUser.getValue();
            String newName = userNameChange.getText();
            if (Objects.equals(userNameChange.getText(), "")) {
                extractedFail("Please Enter An Username");
            } else {
                User user = (User) userInfo.get(name);
                user.setName(newName);
                user.setAge(user.getAge());
                user.setWeight(user.getWeight());
                user.setHeight(user.getHeight());
                user.setGender(user.getGender());
                users.remove(name);
                changeUserMap(user, newName);
            }
        } catch (Exception e) {
            extractedFail("Please Enter An Username");
        }
    }

    /**
     * Change the information of a user
     */
    @FXML
    void changeAge() {

        //Trying To get valid input from the user
        try {
            int newAge = Integer.parseInt(userAgeChange.getText());
            //Age Can't be Negative or 0
            if (newAge < 0) {
                extractedFail("Age can't be a negative number");
            } else if (newAge == 0) {
                extractedFail("Age can't be 0");
            } else {
                User user = (User) userInfo.get(name);
                user.setName(user.getName());
                user.setAge(newAge);
                user.setWeight(user.getWeight());
                user.setHeight(user.getHeight());
                user.setGender(user.getGender());
                changeUserMap(user, name);
            }
        } catch (Exception e) {
            extractedFail("Enter A Positive Number For Age");
        }
    }

    /**
     * Change the information of a user
     */
    @FXML
    void changeGender() {
        try {
            //Getting the name and the gender of the user
            String newGender = String.valueOf(userGenderChange.getValue());
            User user = (User) userInfo.get(name);
            user.setName(user.getName());
            user.setAge(user.getAge());
            user.setWeight(user.getWeight());
            user.setHeight(user.getHeight());
            user.setGender(newGender);
            changeUserMap(user, name);
        } catch (Exception e) {
            extractedFail("Please Select an user");
        }
    }

    /**
     * Change the information of a user
     */
    @FXML
    void changeWeight() {
        try {
            //If the option chosen is kilograms
            double newWeight;
            if (weightChoiceChange.getValue().equals("KG")) {
                newWeight = Double.parseDouble(userWeightChange.getText());
            }
            //If the option chosen is pounds
            else {
                //Converting the lbs to kg
                newWeight = lbToKg * Double.parseDouble(userWeightChange.getText());
            }
            //Weight Can't be Negative or 0
            if (newWeight < 0) {
                extractedFail("Weight can't be a negative number");
            } else if (newWeight == 0) {
                extractedFail("Weight can't Be 0");
            } else {
                newWeight = Double.parseDouble(String.format("%.1f", newWeight));
                User user = (User) userInfo.get(name);
                user.setName(user.getName());
                user.setAge(user.getAge());
                user.setWeight(newWeight);
                user.setHeight(user.getHeight());
                user.setGender(user.getGender());
                changeUserMap(user, name);
            }
        } catch (Exception e) {
            extractedFail("Enter A Positive Number For Weight");
        }
    }

    /**
     * Change the information of a user
     */
    @FXML
    void changeHeight() {
        try {
            //If height is cm
            double newHeight;
            if (heightChoiceChange.getValue().equals("C.M.")) {
                newHeight = Double.parseDouble(userHeightChange.getText());
            } else {
                //Converting meter to cm
                newHeight = 100 * Double.parseDouble(userHeightChange.getText());
            }
            //Height Can't be negative or 0
            if (newHeight < 0) {
                extractedFail("Height can't be a negative number");
            } else if (newHeight == 0) {
                extractedFail("Height can't be 0");
            } else {
                User user = (User) userInfo.get(name);
                user.setName(user.getName());
                user.setAge(user.getAge());
                user.setWeight(user.getWeight());
                user.setHeight(newHeight);
                user.setGender(user.getGender());
                changeUserMap(user, name);
            }
        } catch (Exception e) {
            extractedFail("Enter A Positive Number For Height");
        }
    }

    private void changeUserMap(User user, String name) {
        userInfo.put(name, user);
        users.remove(name);
        users.add(name);
        extractedSuccess();
        leftStatus.setText("");
        rightStatus.setText("");
        viewUser.setValue("Select");
        changeUser.setValue("Select");
    }


    /**
     * Allows the user to view Information of a user
     */
    @FXML
    void viewInfo() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewDetails.fxml"));
        Parent root = loader.load();
        DetailsController detailsController = loader.getController();
        try {
            //Getting the username
            name = viewUser.getValue();
            if (Objects.equals(name, "None") || Objects.equals(name, "Select") || (userInfo == null)) {
                extractedFail("Please Select an user");
            } else {
                detailsController.viewDetails.setText(userInfo.get(name).toString());
                rightStatus.setText("User Info Printed! View above");
                extractedSuccess();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setTitle("Information");
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
    void viewExercise() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewDetails.fxml"));
        Parent root = loader.load();
        DetailsController detailsController = loader.getController();
        try {
            //Getting the user number
            name = viewUser.getValue();
            try {
                if (Objects.equals(name, "None") || Objects.equals(name, "Select") || (userInfo == null)) {
                    extractedFail("Please Select an user");
                } else {
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
                                    //Getting the user info associated with the user number
                                    user = (User) userInfo.get(name);
                                    weight = user.getWeight();
                                    //Getting the weight difference.
                                    double weightDifference = weight - exerciseWeight;
                                    //If the weight difference is 0
                                    if (weightDifference < 0) {
                                        leftStatus.setText("");
                                        rightStatus.setText("");
                                        detailsController.viewDetails.setText("Just Eat More.");
                                        Stage stage = new Stage();
                                        stage.setScene(new Scene(root));
                                        stage.setResizable(false);
                                        stage.setTitle("Information");
                                        stage.show();
                                        rightStatus.setText("Requested info shown!");
                                        extractedSuccess();
                                    }
                                    //If the weight difference is negative.
                                    else if (weightDifference == 0) {
                                        leftStatus.setText("");
                                        rightStatus.setText("");
                                        detailsController.viewDetails.setText("You are already at this weight");
                                        Stage stage = new Stage();
                                        stage.setScene(new Scene(root));
                                        stage.setResizable(false);
                                        stage.setTitle("Information");
                                        stage.show();
                                        rightStatus.setText("Requested info shown!");
                                        extractedSuccess();
                                    } else {
                                        //Calling the estimate calories option method
                                        double calories = Calculations.estimateCalories(weightDifference);
                                        //Calling the exercise option method
                                        String exercise = Calculations.estimateExercise(speed, choice, calories, weight, weightDifference, exerciseWeight);
                                        detailsController.viewDetails.setText(exercise);
                                        Stage stage = new Stage();
                                        stage.setScene(new Scene(root));
                                        stage.setResizable(false);
                                        stage.setTitle("Information");
                                        stage.show();
                                        rightStatus.setText("Requested info shown!");
                                        extractedSuccess();
                                    }
                                }
                            } catch (Exception e) {
                                extractedFail("Enter A positive number for weight goal");
                            }
                        }
                    } catch (Exception e) {
                        extractedFail("Enter A positive number for weight goal");
                    }
                }
            } catch (Exception e) {
                extractedFail("Please Select An User");
            }
        } catch (Exception e) {
            extractedFail("Please Select An User");
        }
    }

    /**
     * Allows the user to check their BMI
     */
    @FXML
    void viewBMI() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BmiView.fxml"));
        Parent root = loader.load();
        DetailsController detailsController = loader.getController();
        try {
            //Getting the username
            name = viewUser.getValue();
            if (Objects.equals(name, "None") || Objects.equals(name, "Select") || (userInfo == null)) {
                extractedFail("Please Select an user");
            } else {
                if (viewInfoType.getValue().equals("View BMI")) {
                    //Gets the user information to view information
                    user = (User) userInfo.get(name);
                    weight = user.getWeight();
                    height = user.getHeight();
                    detailsController.viewDetails.setText(name + " 's BMI is " + Calculations.bmi(weight, height) + ".");
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setResizable(false);
                    stage.setTitle("Information");
                    stage.show();
                    rightStatus.setText("Requested info shown!");
                    extractedSuccess();
                }
                //If the option chosen is weight status
                else {
                    //Gets the user information to view information
                    user = (User) userInfo.get(name);
                    weight = user.getWeight();
                    height = user.getHeight();
                    detailsController.viewDetails.setText(name + " is " + Calculations.bmiCompare(weight, height) + ".");
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setResizable(false);
                    stage.setTitle("Information");
                    stage.show();
                    rightStatus.setText("Requested info shown!");
                    extractedSuccess();
                }

            }
            //Exception handled
        } catch (Exception e) {
            extractedFail("Please Select an user");
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
                        for (String i : userInfo.keySet()) {
                            user = (User) userInfo.get(i);
                            //Assigning the info to the variables
                            name = user.getName();
                            String age = String.valueOf(user.getAge());
                            String gender = "";
                            //Abbreviating the gender to write to a file

                            if (user.getGender().equals("Male")) {
                                gender = "M";
                            }
                            if (user.getGender().equals("Female")) {
                                gender = "F";
                            }
                            if (user.getGender().equals("Preferred not to say")) {
                                gender = "N";
                            }
                            String weight = String.valueOf(user.getWeight());
                            String height = String.valueOf(user.getHeight());
                            //Writing them to the file.
                            Writer.fileWriter(fileSave, name, age, gender, weight, height);
                        }
                        rightStatus.setText("File Saved");
                        extractedSuccess();
                    } catch (Exception e) {
                        //The Error message
                        extractedFail("Error: Could not write to file");
                    }
                }
            }
            //Catching exception
        } catch (
                Exception e) {
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
                This is basic health information tracking program.
                Uses Hashmaps to store user information and display them.
                Version: 3
                               
                Amasil Rahim Zihad
                Email: amasilrahim.zihad@ucalgary.ca
                Email: amasilrahimzihad@gmail.com
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
