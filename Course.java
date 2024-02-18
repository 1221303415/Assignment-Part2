import java.util.HashSet;
import java.util.Set;

/**
 * Represents a course offered in an educational institution.
 */
public class Course {
    private String code;            // The code of the course
    private int credit;             // The credit hours of the course
    private int preCredit;          // The credit hours of prerequisite courses
    private Set<String> preReq;     // Set of prerequisite course codes
    private Set<Student> students;  // Set of students enrolled in the course
    private Lecturer lecturer;      // The lecturer teaching the course

    /**
     * Constructs a course with the specified details.
     *
     * @param code      The code of the course.
     * @param credit    The credit hours of the course.
     * @param preCredit The credit hours of prerequisite courses.
     * @param preReq    Set of prerequisite course codes.
     */
    public Course(String code, int credit, int preCredit, Set<String> preReq) {
        this.code = code;
        this.credit = credit;
        this.preCredit = preCredit;
        this.preReq = preReq;
        this.students = new HashSet<>();
    }

    /**
     * Retrieves the credit hours of the course.
     *
     * @return The credit hours of the course.
     */
    public int getCredit() {
        return credit;
    }

    /**
     * Retrieves the code of the course.
     *
     * @return The code of the course.
     */
    public String getCode() {
        return code;
    }

    /**
     * Retrieves the set of prerequisite course codes.
     *
     * @return The set of prerequisite course codes.
     */
    public Set<String> getPre() {
        return preReq;
    }

    /**
     * Retrieves the credit hours of prerequisite courses.
     *
     * @return The credit hours of prerequisite courses.
     */
    public int getPreCredit() {
        return preCredit;
    }

    /**
     * Retrieves the set of prerequisite course codes.
     *
     * @return The set of prerequisite course codes.
     */
    public Set<String> getPreReq() {
        return preReq;
    }

    /**
     * Retrieves the set of students enrolled in the course.
     *
     * @return The set of students enrolled in the course.
     */
    public Set<Student> getStudents() {
        return students;
    }

    /**
     * Retrieves the lecturer teaching the course.
     *
     * @return The lecturer teaching the course.
     */
    public Lecturer getLecturer() {
        return lecturer;
    }

    /**
     * Adds a student to the course.
     *
     * @param student The student to be added to the course.
     */
    public void addStudent(Student student) {
        if (students != null) {
            students.add(student);
        }
    }

    /**
     * Generates a string representation of the course.
     *
     * @return A string representation of the course.
     */
    @Override
    public String toString() {
        return code + ", " + credit + " credits" + ", Pre-requisite: " + preReq + ", " + preCredit + " credits";
    }
}


