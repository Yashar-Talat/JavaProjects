public class Student {
    private String studentName;
    private int studentId;
    private int[] grades;

    public Student(String studentName, int studentId, int numCourses) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.grades = new int[numCourses];
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getGrade(int courseIndex) {
        return grades[courseIndex];
    }

    public void setGrade(int courseIndex, int grade) {
        grades[courseIndex] = grade;
    }
}

