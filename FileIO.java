import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Utility class for reading data from files.
 */
public class FileIO {

    /**
     * Reads administrator accounts from a file and returns a list of users.
     *
     * @return An ArrayList containing User objects representing administrators.
     */
    public static ArrayList<User> adminReader() {
        ArrayList<User> listUsers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("admin_accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                listUsers.add(new User(null, null, parts[0].trim(), parts[1].trim(), "Admin"));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return listUsers;
    }

    /**
     * Reads lecturer accounts from a file and returns a list of lecturers.
     *
     * @return An ArrayList containing Lecturer objects representing lecturers.
     */
    public static ArrayList<Lecturer> lecturerReader() {
        ArrayList<Lecturer> listLecturers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("lecturer_accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Integer id = null;
                try {
                    id = Integer.parseInt(parts[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid id: " + e.getMessage());
                }
                String name = parts[1].trim();
                String username = parts[2].trim();
                String password = parts[3].trim();

                listLecturers.add(new Lecturer(id, name, username, password));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return listLecturers;
    }

    /**
     * Reads student accounts from a file and returns a list of students.
     *
     * @return An ArrayList containing Student objects representing students.
     */
    public static ArrayList<Student> studentReader() {
        ArrayList<Student> listStudents = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("student_accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                listStudents.add(new Student(Integer.parseInt(parts[0]), parts[1].trim(), parts[2].trim(), parts[3].trim()));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return listStudents;
    }

    /**
     * Reads course information from a file and returns a list of courses.
     *
     * @return An ArrayList containing Course objects representing courses.
     */
    public static ArrayList<Course> courseReader() {
        ArrayList<Course> listCourses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("courses.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String code = parts[0].trim();
                int credit = 0;
                int preCredits = 0;
                try {
                    credit = Integer.parseInt(parts[1].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid credit: " + e.getMessage());
                }

                HashSet<String> preReq = new HashSet<>();
                if (parts.length > 2) {
                    try {
                        preCredits = Integer.parseInt(parts[2].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid pre h: " + e.getMessage());
                    }
                    for (int i = 3; i < parts.length; i++) {
                        preReq.add(parts[i].trim());
                    }
                }
                listCourses.add(new Course(code, credit, preCredits, preReq));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return listCourses;
    }

    /**
     * Main method for testing the file reading functionalities.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println(courseReader());
    }
}
