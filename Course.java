import java.util.HashSet;
import java.util.Set;

public class Course {
    private String code;
    private int credit;
    private int preCredit;
    private Set<String> preReq;
    private Set<Student> students;
    private Lecturer lecturer;

    public Course(String code, int credit, int preCredit, Set<String> preReq) {
        this.code = code;
        this.credit = credit;
        this.preCredit = preCredit;
        this.preReq = preReq;
        this.students = new HashSet<>();
    }

    public int getCredit() {
        return credit;
    }

    public String getCode() {
        return code;
    }

    public Set<String> getPre() {
        return preReq;
    }

    public int getPreCredit() {
        return preCredit;
    }

    public Set<String> getPreReq() {
        return preReq;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }
    
    
    public void addStudent(Student student) {
        if (students != null) {
            students.add(student);
        }
    }

    @Override
    public String toString() {
        return code + ", " + credit + " credits" + ", Pre-requisite: " + preReq + ", " + preCredit + " credits";
    }

}


