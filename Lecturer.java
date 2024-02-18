import java.util.ArrayList;

public class Lecturer extends User {
    private ArrayList<Course> assignCourses;

    public Lecturer(int id, String name, String username, String password) {
        super(id, name, username, password, "Lecturer");
        this.assignCourses = new ArrayList<Course>();
    }

    public void addCourse(Course course) {
        assignCourses.add(course);
    }

    public ArrayList<Course> getAssignCourses() {
        return assignCourses;
    }

    public String toString(){
        return "Lecturer: " + getUsername() + ", Course:" + getAssignCourses();
    }
}
