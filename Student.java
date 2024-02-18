import java.util.ArrayList;

/**
 * The Student class represents a student user in the system, extending the User class.
 */
public class Student extends User {
    private ArrayList<Course> takenCourses;  // List of courses taken by the student
    private ArrayList<Course> currentCourses; // List of courses currently enrolled by the student
    private int currentCredit; // Current total credit hours taken by the student

    /**
     * Constructor to initialize a new Student object.
     * @param id The ID of the student.
     * @param name The name of the student.
     * @param username The username of the student.
     * @param password The password of the student.
     */
    public Student(int id, String name, String username, String password) {
        super(id, name, username, password, "Student");
        this.takenCourses = new ArrayList<Course>();
        this.currentCourses = new ArrayList<Course>();
        this.currentCredit = 0;
    }

    /**
     * Retrieves the list of courses taken by the student.
     * @return The list of taken courses.
     */
    public ArrayList<Course> getTakenCourses() {
        return takenCourses;
    }

    /**
     * Retrieves the list of current courses enrolled by the student.
     * @return The list of current courses.
     */
    public ArrayList<Course> getCurrentCourses() {
        return currentCourses;
    }

    /**
     * Retrieves the current total credit hours taken by the student.
     * @return The current total credit hours.
     */
    public int getCurrentCredit() {
        return currentCredit;
    }

    /**
     * Adds a course to the list of current courses enrolled by the student.
     * @param course The course to be added.
     */
    public void addCourse(Course course) {
        currentCourses.add(course);
    }

    /**
     * Removes a course from the list of current courses enrolled by the student.
     * @param course The course to be removed.
     */
    public void dropCourse(Course course) {
        currentCourses.remove(course);
    }

    /**
     * Increases the current total credit hours taken by the student.
     * @param courseCredit The credit hours of the course being added.
     */
    public void addCurrentCredit(int courseCredit) {
        this.currentCredit += courseCredit;
    }

    public void setCredit(int courseCredit) {
        this.currentCredit = courseCredit;
    }

    /**
     * Generates a string representation of the student object.
     * @return The string representation of the student object.
     */
    @Override
    public String toString() {
        return "ID: " + getId() + " Name: " + getName();
    }
}

