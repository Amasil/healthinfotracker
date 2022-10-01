# CPSC233W22Project

# Author: Amasil Rahim Zihad & Fabiha Fairuzz Subha

# UCID: 30164830 & 30148674

## Version: 2.2

### This is fitness tracking program that allows the user to input their information and get back various results from that

### Running  the jar file

- We will need [Java](https://www.oracle.com/java/technologies/downloads/) installed.
  (Recommended version is at least java 18)

### To check the version:

- Type "java -version" in terminal or cmd which will show the version.  
  We will also need [javafx-sdk](https://gluonhq.com/products/javafx/).

- After downloading javafx-sdk and extract it and note the path where it was extracted.

- To run the program navigate to its folder and then open a terminal or cmd windows there and write the following:

- > java --module-path "javafx-sdk path here\lib" --add-modules javafx.controls,javafx.fxml -jar CPSC233W22Project.jar

- So if javafx-sdk is in "C:\Program Files\Java\" the cmd command code would be:

- > java --module-path "C:\Program Files\Java\javafx-sdk-18\lib" --add-modules javafx.controls,javafx.fxml -jar
  CPSC233W22Project.jar

- Or on macOS if javafx-sdk is in "/Library/Java/JavaVirtualMachines/" the terminal command would be:

- > java --module-path "/Library/Java/JavaVirtualMachines/javafx-sdk-18/lib" --add-modules javafx.controls,javafx.fxml
  -jar CPSC233W22Project.jar

## Features

- Add multiple users and view their information.
- Read information of a user from a file.
- Write the user information to a file.
- Display the bmi or the weight status of the users.
- Add the amount of calorie burnt in day of a user and display the highest amount burnt in a day or total calorie lost
  for that user.
- Allows the user to enter a certain weight goal and provide information on how much exercise is needed to reach that
  goal.

## Running the GUI

<div align="center"><a href="https://imgbox.com/jkcUQsRx" target="_blank"><img src="https://images2.imgbox.com/44/55/jkcUQsRx_o.png" alt="The GUI" height="610" width="850"/></a></div>

- Running the .jar file like that should run the program and a GUI window titled **This Is A Fitness Tracking Program**
  should appear
- This is a tracking program that will allow the user to track their weight and calories
- For further details of the program and its authors, the user can go to the *Help* option in menu bar and look at the *
  About*
- The user can either manually enter their data or can load a file with already entered information of the user.
- In this program, the user can enter details for up to 10 people and track their data too.
- The menu portion of the program is in the middle which the user can use to interact and get their desired feedbacks or
  calculations shown in the *view box* on the right side.

<div align="center"><a href="https://imgbox.com/KuIqeCEL" target="_blank"><img src="https://images2.imgbox.com/08/14/KuIqeCEL_o.png" height="550" width="300" alt="View Options Photo"/></a></div>

- There is also an option to save the calorie burnt information of the user to a file
- At the very bottom there is a status bar which shows if any changes were made or any error occurred. The program can
  also save the information of the people that the user changed/created in a .txt file that can be later loaded to get
  the same information. This can be done with the *Save* as option in *File* in the menu bar.

To exit the program, the user can simply press the close button on the window or use the *Quit* option in the *File*
option in menu

