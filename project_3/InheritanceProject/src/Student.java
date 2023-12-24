import java.util.List;

// Abstract class representing a Student
abstract class Student {
    private String studentName;
    private int studentId;

    public Student(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    // Abstract method for adding grades
    public abstract void addGrades(List<Course> courses) throws Exception;

    // Abstract method for getting a grade
    public abstract int getGrade(int courseIndex);
}

