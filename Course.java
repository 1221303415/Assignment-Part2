/**
 * Represents a course offered by a university.
 */
public class Course {
    // Fields
    private String code;            // Course code
    private int credit;             // Number of credits for the course
    private int preCredit;          // Number of credits for prerequisites
    private Set<String> preReq;     // Set of prerequisites represented by course codes
    private Set<Student> students;  // Set of students enrolled in the course

    /**
     * Constructs a Course object with the given parameters.
     *
     * @param code      the course code
     * @param credit    the number of credits for the course
     * @param preCredit the number of credits for prerequisites
     * @param preReq2   an ArrayList of strings representing the prerequisites by course codes
     */
    public Course(String code, int credit, int preCredit, ArrayList<String> preReq2) {
        this.code = code;
        this.credit = credit;
        this.preCredit = preCredit;
        this.preReq = new HashSet<>(preReq2);  // Convert ArrayList to HashSet
        this.students = new HashSet<>();
    }

    // Getter methods

    /**
     * Gets the number of credits for the course.
     *
     * @return the number of credits
     */
    public int getCredit() {
        return credit;
    }

    /**
     * Gets the course code.
     *
     * @return the course code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the set of prerequisites represented by course codes.
     *
     * @return the set of prerequisites
     */
    public Set<String> getPre() {
        return preReq;
    }

    /**
     * Gets the number of credits for prerequisites.
     *
     * @return the number of credits for prerequisites
     */
    public int getPreCredit() {
        return preCredit;
    }

    /**
     * Gets the set of students enrolled in the course.
     *
     * @return the set of students
     */
    public Set<Student> getStudents() {
        return students;
    }

    /**
     * Returns a string representation of the course.
     *
     * @return a string containing the course code, number of credits, prerequisites, and credits for prerequisites
     */
    @Override
    public String toString() {
        return code + ", " + credit + " credits" + ", Pre-requisite: " + preReq + ", " + preCredit + " credits";
    }
}

}


