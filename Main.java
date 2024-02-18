import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

/**
 * The Main class serves as the entry point of the program and contains various methods for user authentication,
 * user and course creation, and registration validation.
 */
public class Main {

    /**
     * ArrayLists to store instances of different user types and courses, loaded from files using FileIO class.
     */
    static ArrayList<User> listAdmins = FileIO.adminReader();
    static ArrayList<Lecturer> listLecturers = FileIO.lecturerReader();
    static ArrayList<Student> listStudents = FileIO.studentReader();
    static ArrayList<Course> listCourses = FileIO.courseReader();
    static Trimester trimester = new Trimester();

    /**
     * The main method of the program.
     * Displays initial lists of users, launches the GUI, and displays lists again after GUI execution.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        System.out.println(listStudents);
        System.out.println(listLecturers);
        System.out.println(listAdmins);

        GUI.main(args);

        System.out.println(listStudents);
        System.out.println(listLecturers);
        System.out.println(listAdmins);
    }

    /**
     * Authenticates users based on provided username and password.
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The authenticated user object or null if authentication fails.
     */
    public static User authenticate(String username, String password) {
        for (User admin : listAdmins) {
            if (admin.getUsername().equalsIgnoreCase(username) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        for (Lecturer lecturer : listLecturers) {
            if (lecturer.getUsername().equalsIgnoreCase(username) && lecturer.getPassword().equals(password)) {
                return lecturer;
            }
        }
        for (Student student : listStudents) {
            if (student.getUsername().equalsIgnoreCase(username) && student.getPassword().equals(password)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Creates a new user of specified type (Student or Lecturer).
     * @param id The ID of the user.
     * @param name The name of the user.
     * @param username The username of the user.
     * @param password The password of the user.
     * @param userType The type of user (Student or Lecturer).
     * @return True if user creation is successful, false otherwise.
     */
    public static boolean createUser(int id, String name, String username, String password, String userType) {
        if (userType.equalsIgnoreCase("Student")) {
            for (User user : listStudents) {
                if (user.getId() == id) {
                    return false;
                }
            }
            Student newStudent = new Student(id, name, username, password);
            listStudents.add(newStudent);
        } else if (userType.equalsIgnoreCase("Lecturer")) {
            for (User user : listLecturers) {
                if (user.getId() == id) {
                    return false;
                }
            }
            Lecturer newLecturer = new Lecturer(id, name, username, password);
            listLecturers.add(newLecturer);
        }
        return true;
    }

    /**
     * Creates a new course.
     * @param code The code of the course.
     * @param credit The credit value of the course.
     * @param preCredit The prerequisite credit value of the course.
     * @param preReq The list of prerequisite course codes.
     * @return True if course creation is successful, false otherwise.
     */
    public static boolean createCourse(String code, int credit, int preCredit, Set<String> preReq) {
        for (Course course : listCourses) {
            if (course.getCode().equals(code)) {
                return false;
            }
        }
        Course newCourse = new Course(code, credit, preCredit, preReq);
        listCourses.add(newCourse);
        return true;
    }

    /**
     * Validates registration of a student for a course.
     * @param student The student object.
     * @param course The course object.
     * @return True if registration is valid, false otherwise.
     */
    public static boolean validateRegister(Student student, Course course) {
        Trimester trimester = new Trimester();
        if (student.getCurrentCredit() + course.getCredit() > trimester.getMaxCredit()) {
            return false;
        }

        for (String preReqCode : course.getPre()) {
            boolean found = false;
            for (Course takenCourse : student.getTakenCourses()) {
                if (preReqCode.equals(takenCourse.getCode())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        if (course.getPreCredit() > student.getCurrentCredit()) {
            return false;
        }

        return true;
    }


    public static String nextTrimester() {

        for (Student student : Main.listStudents) {
            if (student.getCurrentCredit() < trimester.getMinCredit()) {
                return ("Error: Student " + student.getId() + " has not acquired the minimum required credit hours");
            }
        }
    
        for (Student student : Main.listStudents) {
            Iterator<Course> iterator = student.getCurrentCourses().iterator();
            while (iterator.hasNext()) {
                Course course = iterator.next();
                student.getTakenCourses().add(course);
                iterator.remove();
            }
            student.setCredit(0);
        }
    
        trimester.addCount();
        return "Success";
    }
}
