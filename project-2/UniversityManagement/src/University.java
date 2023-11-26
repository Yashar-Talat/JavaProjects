import java.util.Scanner;

public class University {
    private Student[][] students;
    private Course[] courses;
    private int numberOfStudents;
    private int numberOfCourses;

    public University(int maxStudents, int maxCourses) {
        students = new Student[maxStudents][];
        courses = new Course[maxCourses];
    }

    public void addStudent(Scanner scanner, int maxCourses) {
        if (numberOfStudents < students.length) {
            System.out.print("Enter student name: ");
            String studentName = scanner.next();
            System.out.print("Enter student ID: ");
            int studentId = scanner.nextInt();
            Student student = new Student(studentName, studentId, maxCourses);
            students[numberOfStudents++] = new Student[]{student};
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Maximum number of students reached.");
        }
    }

    public void addCourse(Scanner scanner) {
        if (numberOfCourses < courses.length) {
            System.out.print("Enter course name: ");
            String courseName = scanner.next();
            courses[numberOfCourses++] = new Course(courseName);
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Maximum number of courses reached.");
        }
    }

    public void addGradesForAllStudents() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numberOfStudents; i++) {
            for (int j = 0; j < numberOfCourses; j++) {
                System.out.print("Enter grade for student " + students[i][0].getStudentName() +
                        " in course " + courses[j].getName() + ": ");
                students[i][0].setGrade(j, scanner.nextInt());
            }
        }
        System.out.println("Grades added successfully.");
    }

    public void displayAllStudents() {
        System.out.println("\nAll Students:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student Name: " + students[i][0].getStudentName() +
                    ", Student ID: " + students[i][0].getStudentId());
        }
    }

    public void displayAllCourses() {
        System.out.println("\nAll Courses:");
        for (int i = 0; i < numberOfCourses; i++) {
            System.out.println("Course Name: " + courses[i].getName());
        }
    }

    public void displayHighestGradeInCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the course name: ");
        String courseName = scanner.next();

        int courseIndex = findCourseIndex(courseName);
        if (courseIndex != -1) {
            boolean isFirstStudent = true;
            int maxGrade = 0;
            Student topStudent = null;

            for (int i = 0; i < numberOfStudents; i++) {
                int grade = students[i][0].getGrade(courseIndex);
                if (isFirstStudent || grade > maxGrade) {
                    isFirstStudent = false;
                    maxGrade = grade;
                    topStudent = students[i][0];
                }
            }

            if (topStudent != null) {
                System.out.println("Top student in course " + courseName + ": " +
                        "Student Name: " + topStudent.getStudentName() +
                        ", Student ID: " + topStudent.getStudentId() +
                        ", Grade: " + maxGrade);
            } else {
                System.out.println("No student in course " + courseName + ".");
            }
        } else {
            System.out.println("Course not found.");
        }
    }


    public void displayGradesForAllStudentsInCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the course name: ");
        String courseName = scanner.next();

        int courseIndex = findCourseIndex(courseName);
        if (courseIndex != -1) {
            System.out.println("\nGrades for all students in course " + courseName + ":");
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.println("Student Name: " + students[i][0].getStudentName() +
                        ", Student ID: " + students[i][0].getStudentId() +
                        ", Grade: " + students[i][0].getGrade(courseIndex));
            }
        } else {
            System.out.println("Course not found.");
        }
    }

    public void displayStudentWithHighestGradeInCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the course name: ");
        String courseName = scanner.next();

        int courseIndex = findCourseIndex(courseName);
        if (courseIndex != -1) {
            boolean firstStudent = true;
            int maxGrade = 0;
            Student topStudent = null;

            for (int i = 0; i < numberOfStudents; i++) {
                int grade = students[i][0].getGrade(courseIndex);
                if (firstStudent || grade > maxGrade) {
                    firstStudent = false;
                    maxGrade = grade;
                    topStudent = students[i][0];
                }
            }

            if (topStudent != null) {
                System.out.println("Top student in course " + courseName + ": " +
                        "Student Name: " + topStudent.getStudentName() +
                        ", Student ID: " + topStudent.getStudentId() +
                        ", Grade: " + maxGrade);
            } else {
                System.out.println("No student in course " + courseName + ".");
            }
        } else {
            System.out.println("Course not found.");
        }
    }


    private int findCourseIndex(String courseName) {
        for (int i = 0; i < numberOfCourses; i++) {
            if (courses[i].getName().equals(courseName)) {
                return i;
            }
        }
        return -1;
    }
}
