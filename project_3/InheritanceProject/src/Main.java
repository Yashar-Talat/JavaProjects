import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            University<Student> university = new University<>();
            boolean exit = false;
            while (!exit) {
                System.out.println("\nMenu:");
                System.out.println("1. Add Student");
                System.out.println("2. Add Course");
                System.out.println("3. Add Grades for All Students");
                System.out.println("4. Display All Students");
                System.out.println("5. Display Highest Grade in Course");
                System.out.println("6. Display Grades for All Students in Course");
                System.out.println("7. Display Student with Highest Grade in Course");
                System.out.println("8. Display All Courses");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String studentName = scanner.next();
                        System.out.print("Enter student ID: ");
                        int studentId = scanner.nextInt();
                        university.addStudent(new UndergraduateStudent(studentName, studentId));
                        break;
                    case 2:
                        System.out.print("Enter course name: ");
                        String courseName = scanner.next();
                        university.addCourse(new GenericCourse(courseName));
                        break;
                    case 3:
                        university.addGradesForAllStudents();
                        break;
                    case 4:
                        university.displayAllStudents();
                        break;
                    case 5:
                        System.out.print("Enter the course name: ");
                        String highestGradeCourse = scanner.next();
                        university.displayHighestGradeInCourse(highestGradeCourse);
                        break;
                    case 6:
                        System.out.print("Enter the course name: ");
                        String allGradesCourse = scanner.next();
                        university.displayGradesForAllStudentsInCourse(allGradesCourse);
                        break;
                    case 7:
                        System.out.print("Enter the course name: ");
                        String highestGradeStudentCourse = scanner.next();
                        university.displayStudentWithHighestGradeInCourse(highestGradeStudentCourse);
                        break;
                    case 8:
                        university.displayAllCourses();
                        break;
                    case 9:
                        exit = true;
                        System.out.println("Exiting the program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 9.");
                }
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}