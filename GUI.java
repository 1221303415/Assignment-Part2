import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GUI extends Application {

    private Stage primaryStage;
    private Scene mainScene = MainScene();
    private Scene adminScene = AdminScene();
    private Scene lecturerScene;
    private Scene studentScene;
    private Scene createStudentScene = CreateStudentScene();
    private Scene createLecturerScene = CreateLecturerScene();
    private Scene createCourseScene = CreateCourseScene();

    User user;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Course Management System");

        showScene(mainScene);
    }

    private Scene MainScene() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Label nameLabel = new Label("Username: ");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password: ");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");

        GridPane.setConstraints(nameLabel, 0, 0);
        GridPane.setConstraints(usernameField, 1, 0);
        GridPane.setConstraints(passwordLabel, 0, 1);
        GridPane.setConstraints(passwordField, 1, 1);
        GridPane.setConstraints(loginButton, 1, 2);

        loginButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();
            user = Main.authenticate(username, password);
            if (user != null){
                if (user.getUserType().equals("Admin")) {
                    showScene(adminScene);
                }
                else if (user.getUserType().equals("Lecturer")) {
                    lecturerScene = LecturerScene();
                    showScene(lecturerScene);
                }
                else if (user.getUserType().equals("Student")) {
                    studentScene = StudentScene();
                    showScene(studentScene);
                }
            }
            else {
                showPopup(AlertType.INFORMATION, "Invalid Credentials");
            }

            usernameField.clear();
            passwordField.clear();
        });

        grid.getChildren().addAll(nameLabel, usernameField, passwordLabel, passwordField, loginButton);
        return new Scene(grid, 640 , 360);
    }

    private Scene AdminScene() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        // view all course student lecturer

        Label userLabel = new Label("admin");
        Button createStudentButton = new Button("Create Student");
        Button createLecturerButton = new Button("Create Lecturer");
        Button createCourseButton = new Button("Create Course");
        Button nextTrimesterButton = new Button("Next Trimester");
        Button logoutButton = new Button("Logout");

        GridPane.setConstraints(userLabel, 0, 0);
        GridPane.setConstraints(createStudentButton, 0, 1);
        GridPane.setConstraints(createLecturerButton, 0, 2);
        GridPane.setConstraints(createCourseButton, 0, 3);
        GridPane.setConstraints(nextTrimesterButton, 0, 4);
        GridPane.setConstraints(logoutButton, 0, 5);

        createStudentButton.setOnAction(e -> {
            showScene(createStudentScene);
        });
        
        createLecturerButton.setOnAction(e -> {
            showScene(createLecturerScene);
        });
        
        createCourseButton.setOnAction(e -> {
            showScene(createCourseScene);
        });

        nextTrimesterButton.setOnAction(e -> {
            
        });

        logoutButton.setOnAction(e -> {
            showScene(mainScene);
        });

        grid.getChildren().addAll(userLabel, createStudentButton, createLecturerButton, createCourseButton, nextTrimesterButton, logoutButton);

        return new Scene(grid, 640 , 360);
    }

    private Scene CreateStudentScene() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            showScene(adminScene);
        });

        Label userLabel = new Label("admin");
        
        Label idLabel = new Label("Id: ");
        TextField idField = new TextField();
        Label nameLabel = new Label("Name: ");
        TextField nameField = new TextField();
        Label usernameLabel = new Label("Username: ");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password: ");
        PasswordField passwordField = new PasswordField();

        Button submitButton = new Button("Submit");
        
        GridPane.setConstraints(userLabel, 0, 0);
        GridPane.setConstraints(idLabel, 0, 1);
        GridPane.setConstraints(idField, 1, 1);
        GridPane.setConstraints(nameLabel, 0, 2);
        GridPane.setConstraints(nameField, 1, 2);
        GridPane.setConstraints(usernameLabel, 0, 3);
        GridPane.setConstraints(usernameField, 1, 3);
        GridPane.setConstraints(passwordLabel, 0, 4);
        GridPane.setConstraints(passwordField, 1, 4);
        GridPane.setConstraints(submitButton, 1, 5);

        submitButton.setOnAction(e -> {
            Integer id = null;
            String name = nameField.getText().trim();
            String username = usernameField.getText().trim();
            // String course = courseCombo.getValue();
            String password = passwordField.getText().trim();
            try {
                id = Integer.parseInt(idField.getText().trim());
                if (Main.createUser(id, name, username, password, "Student")) {
                    showPopup(AlertType.INFORMATION, "Student Created");
                }
                else {
                    showPopup(AlertType.ERROR, "Id already taken");
                }
            }
            catch (NumberFormatException ex) {
                showPopup(AlertType.ERROR, "Id need to be int");
            }
        });

        
        grid.getChildren().addAll(backButton, idLabel, idField, nameLabel, nameField, usernameLabel, usernameField, passwordLabel, passwordField, submitButton);

        return new Scene(grid, 640 , 360);
    }

    private Scene CreateLecturerScene() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            showScene(adminScene);
        });

        Label userLabel = new Label("admin");
        
        Label idLabel = new Label("Id: ");
        TextField idField = new TextField();
        Label nameLabel = new Label("Name: ");
        TextField nameField = new TextField();
        Label usernameLabel = new Label("Username: ");
        TextField usernameField = new TextField();
        Label courseLabel = new Label("Assign Course: ");
        ComboBox<Course> courseCombo = new ComboBox<Course>();
        for (Course course: Main.listCourses) {
            courseCombo.getItems().add(course);
        }
        Label passwordLabel = new Label("Password: ");
        PasswordField passwordField = new PasswordField();
        
        Button submitButton = new Button("Submit");
        
        GridPane.setConstraints(userLabel, 0, 0);
        GridPane.setConstraints(idLabel, 0, 1);
        GridPane.setConstraints(idField, 1, 1);
        GridPane.setConstraints(nameLabel, 0, 2);
        GridPane.setConstraints(nameField, 1, 2);
        GridPane.setConstraints(usernameLabel, 0, 3);
        GridPane.setConstraints(usernameField, 1, 3);
        GridPane.setConstraints(courseLabel, 0, 4);
        GridPane.setConstraints(courseCombo, 1, 4);
        GridPane.setConstraints(passwordLabel, 0, 5);
        GridPane.setConstraints(passwordField, 1, 5);
        GridPane.setConstraints(submitButton, 1, 6);
        
        submitButton.setOnAction(e -> {
            Integer id = null;
            String name = nameField.getText().trim();
            String username = usernameField.getText().trim();
            Course course = courseCombo.getSelectionModel().getSelectedItem();
            String password = passwordField.getText().trim();
            try {
                id = Integer.parseInt(idField.getText().trim());
                if (Main.createUser(id, name, username, password, "Lecturer")) {
                    Main.listLecturers.getLast().addCourse(course);
                    showPopup(AlertType.INFORMATION, "Lecturer Created");
                }
                else {
                    showPopup(AlertType.ERROR, "Id already taken");
                }
            }
            catch (NumberFormatException ex) {
                showPopup(AlertType.ERROR, "Id need to be int");
            }
        });
        
        
        grid.getChildren().addAll(backButton, idLabel, idField, nameLabel, nameField, usernameLabel, usernameField, courseLabel, courseCombo, passwordLabel, passwordField, submitButton);
        
        return new Scene(grid, 640 , 360);
    }
    
    private Scene CreateCourseScene() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            showScene(adminScene);
        });
        
        Label userLabel = new Label("admin");
        
        Label codeLabel = new Label("Code: ");
        TextField codeField = new TextField();
        Label creditLabel = new Label("Credit: ");
        TextField creditField = new TextField();
        Label preCreditLabel = new Label("Pre-requisite Hour: ");
        TextField preCreditField = new TextField();
        Label preReqLabel = new Label("Pre-requisite Course: ");
        ComboBox<Course> preReqCombo1 = new ComboBox<Course>();
        ComboBox<Course> preReqCombo2 = new ComboBox<Course>();
        ComboBox<Course> preReqCombo3 = new ComboBox<Course>();
        for (Course course: Main.listCourses) {
            preReqCombo1.getItems().add(course);
            preReqCombo2.getItems().add(course);
            preReqCombo3.getItems().add(course);
        }
        Button submitButton = new Button("Submit");
        
        GridPane.setConstraints(userLabel, 0, 0);
        GridPane.setConstraints(codeLabel, 0, 1);
        GridPane.setConstraints(codeField, 1, 1);
        GridPane.setConstraints(creditLabel, 0, 2);
        GridPane.setConstraints(creditField, 1, 2);
        GridPane.setConstraints(preCreditLabel, 0, 3);
        GridPane.setConstraints(preCreditField, 1, 3);
        GridPane.setConstraints(preReqLabel, 0, 4);
        GridPane.setConstraints(preReqCombo1, 1, 4);
        GridPane.setConstraints(preReqCombo2, 1, 5);
        GridPane.setConstraints(preReqCombo3, 1, 6);
        GridPane.setConstraints(submitButton, 1, 7);

        submitButton.setOnAction(e -> {
            Integer credit = null;
            Integer preCredit = null;
            String code = codeField.getText().trim();
            Course preReq1 = preReqCombo1.getSelectionModel().getSelectedItem();
            Course preReq2 = preReqCombo2.getSelectionModel().getSelectedItem();
            Course preReq3 = preReqCombo3.getSelectionModel().getSelectedItem();
            HashSet<String> preReqSet = new HashSet<>();
            
            if (preReq1 != null) {
                preReqSet.add(preReq1.getCode());
            }
            if (preReq2 != null) {
                preReqSet.add(preReq2.getCode());
            }
            if (preReq3 != null) {
                preReqSet.add(preReq3.getCode());
            }
            try {
                credit = Integer.parseInt(creditField.getText().trim());
                preCredit = Integer.parseInt(preCreditField.getText().trim());
                ArrayList<String> preReq = new ArrayList<>(preReqSet);
                if (Main.createCourse(code, credit, preCredit, preReq)) {
                    System.out.println(Main.listCourses);
                    showPopup(AlertType.INFORMATION, "Course Created");
                }
                else {
                    showPopup(AlertType.ERROR, "Course Code already taken");
                }
            }
            catch (NumberFormatException ex) {
                showPopup(AlertType.ERROR, "Credit and Pre-requisite Hour need to be int");
            }
            
            codeField.clear();
            creditField.clear();
            preCreditField.clear();
            preReqCombo1.getSelectionModel().clearSelection();
            preReqCombo2.getSelectionModel().clearSelection();
            preReqCombo3.getSelectionModel().clearSelection();
        });
        
        grid.getChildren().addAll(backButton, codeLabel, codeField, creditLabel, creditField, preCreditLabel, preCreditField, preReqLabel, preReqCombo1, preReqCombo2, preReqCombo3, submitButton);
        
        return new Scene(grid, 640 , 360);
    }
    
    private Scene LecturerScene() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        
        if (user != null) {
            Label codeLabel = new Label("Assign Course: ");
            Lecturer lecturer = (Lecturer) user;
            ArrayList<Course> courses = lecturer.getAssignCourses();
            Label userLabel = new Label("Lecturer");
            ArrayList<String> display = new ArrayList<>();
            if (courses != null) {
                for (Course course : courses) {
                    display.add(course.getCode());
                }
                codeLabel = new Label("Assign Course: " + display);
            }
            Label studentLabel = new Label("Students: ");
            ListView<String> studentListView = new ListView<>();
            
            for (Course course : courses){
                Set<Student> students = course.getStudents();
                studentListView.getItems().addAll(students.toString());
            }
            
            Button logoutButton = new Button("Logout");
            
            GridPane.setConstraints(userLabel, 0, 0);
            GridPane.setConstraints(codeLabel, 0, 1);
            GridPane.setConstraints(studentLabel, 0, 2);
            GridPane.setConstraints(studentListView, 1, 2);
            GridPane.setConstraints(logoutButton, 1, 3);
            
            logoutButton.setOnAction(e -> {
                showScene(mainScene);
            });
    
            grid.getChildren().addAll(userLabel, codeLabel, studentLabel, studentListView, logoutButton);
        }
        
        return new Scene(grid, 640 , 360);
    }



    private Scene StudentScene() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        
        if (user != null) {
            Student student = (Student) user;
            
            Label userLabel = new Label("student");
            
            Label takenCourseLabel = new Label("Taken: ");
            Label currentCourseLabel = new Label("Current: ");
            Label untakenCourseLabel = new Label("Untaken: ");
            
            ArrayList<Course> takenCourses = student.getTakenCourses();
            ArrayList<Course> currentCourses = student.getCurrentCourses();
            ArrayList<Course> untakenCourses = new ArrayList<>(Main.listCourses);

            ArrayList<String> display = new ArrayList<>();
            for (Course course : takenCourses) {
                display.add(course.getCode());
            }
            takenCourseLabel = new Label("Taken: " + display);
            untakenCourses.removeAll(takenCourses);
            for (Course course : currentCourses) {
                display.add(course.getCode());
            }
            currentCourseLabel = new Label("Current: " + display);
            untakenCourses.removeAll(currentCourses);
            for (Course course : untakenCourses) {
                display.add(course.getCode());
            }
            untakenCourseLabel = new Label("Untaken: " + display);
            
            
            Label courseLabel = new Label("Course: ");
            ComboBox<Course> courseCombo = new ComboBox<Course>();
            for (Course course: untakenCourses) {
                courseCombo.getItems().add(course);
            }
            
            Button registerButton = new Button("Register Course");
            Button logoutButton = new Button("Logout");
            
            GridPane.setConstraints(userLabel, 0, 0);
            GridPane.setConstraints(takenCourseLabel, 0, 1);
            GridPane.setConstraints(currentCourseLabel, 0, 2);
            GridPane.setConstraints(untakenCourseLabel, 0, 3);
            GridPane.setConstraints(courseLabel, 0, 4);
            GridPane.setConstraints(courseCombo, 1, 4);
            GridPane.setConstraints(registerButton, 1, 5);
            GridPane.setConstraints(logoutButton, 1, 7);
            
            registerButton.setOnAction(e -> {
                Course course = courseCombo.getSelectionModel().getSelectedItem();
                System.out.println(course);
                if (course != null) {
                    if (Main.validateRegister(student, course)) {
                        Main.listCourses.add(course);
                        student.addCourse(course);
                        student.addCurrentCredit(course.getCredit());
                        // kick the user out cause idk how to refresh scene lol
                        showScene(mainScene);
                    }
                    else {
                        showPopup(AlertType.INFORMATION, "Cannot Register");
                    }
                }
                courseCombo.getSelectionModel().clearSelection();

            });

            logoutButton.setOnAction(e -> {
                showScene(mainScene);
            });
    
            grid.getChildren().addAll(userLabel, takenCourseLabel, currentCourseLabel, untakenCourseLabel, courseLabel, courseCombo, registerButton, logoutButton);
        }
        return new Scene(grid);
    }
    
    private void showScene(Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showPopup(AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}