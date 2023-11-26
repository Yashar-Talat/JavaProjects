import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the maximum number of students: ");
        int maxStudents = scanner.nextInt();
        System.out.print("Enter the maximum number of courses: ");
        int maxCourses = scanner.nextInt();

        University university = new University(maxStudents, maxCourses);

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
                    university.addStudent(scanner, maxCourses);
                    break;
                case 2:
                    university.addCourse(scanner);
                    break;
                case 3:
                    university.addGradesForAllStudents();
                    break;
                case 4:
                    university.displayAllStudents();
                    break;
                case 5:
                    university.displayHighestGradeInCourse();
                    break;
                case 6:
                    university.displayGradesForAllStudentsInCourse();
                    break;
                case 7:
                    university.displayStudentWithHighestGradeInCourse();
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
    }
}