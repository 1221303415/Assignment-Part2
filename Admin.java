import java.io.FileWriter;
import java.io.IOException;

public class Admin {
    public static void createStudent(int id, String name, String username, String password) {
        try (FileWriter writer = new FileWriter("student_accounts.txt", true)) {
            // Create student information string with a newline character at the end
            String studentInfo = id + ", " + name + ", " + username + ", " + password + "\n";
            writer.write(studentInfo);
            System.out.println("Student created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void createLecturer(int id, String name, String username, Course course, String password) {
        try (FileWriter writer = new FileWriter("lecturer_accounts.txt", true)) {
            // Create lecturer information string with a newline character at the end
            String lecturerInfo = id + ", " + name + ", " + username + ", " + password + ", " + course.getCode() + "\n";
            writer.write(lecturerInfo);
            System.out.println("Lecturer created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void createCourse(String code, int credit, int preCredit, Course preReq1, Course preReq2, Course preReq3) {
        try (FileWriter writer = new FileWriter("courses.txt", true)) {
            // Create course information string with a newline character at the end
            String courseInfo = code + ", " + credit + ", " + preCredit + ", ";
            if (preReq1 != null)
                courseInfo += preReq1.getCode();
            courseInfo += ", ";
            if (preReq2 != null)
                courseInfo += preReq2.getCode();
            courseInfo += ", ";
            if (preReq3 != null)
                courseInfo += preReq3.getCode();
            courseInfo += "\n";
            writer.write(courseInfo);
            System.out.println("Course created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}



