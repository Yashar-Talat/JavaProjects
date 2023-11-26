import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of Students: ");
        int numStudents = scanner.nextInt();
        System.out.print("Number of Courses: ");
        int numCourses = scanner.nextInt();
        int[][] grades = new int[numStudents][numCourses];
        int[] studentIDs = new int[numStudents];
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Student ID: ");
            studentIDs[i] = scanner.nextInt();
        }
        int[] courseIDs = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            System.out.print("Course ID: ");
            courseIDs[i] = scanner.nextInt();
        }
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < numCourses; j++) {
                System.out.print("Student ID " + studentIDs[i] + ", Course ID " + courseIDs[j] + ", Grade: ");
                grades[i][j] = scanner.nextInt();
            }
        }

        // Find highest and lowest grades for each course
        for (int j = 0; j < numCourses; j++) {
            int highestGrade = Integer.MIN_VALUE;
            int lowestGrade = Integer.MAX_VALUE;
            int highestStudentID = -1;
            int lowestStudentID = -1;

            for (int i = 0; i < numStudents; i++) {
                if (grades[i][j] > highestGrade) {
                    highestGrade = grades[i][j];
                    highestStudentID = studentIDs[i];
                }
                if (grades[i][j] < lowestGrade) {
                    lowestGrade = grades[i][j];
                    lowestStudentID = studentIDs[i];
                }
            }

            System.out.println("Course ID " + courseIDs[j] + ", Student ID " + highestStudentID + ", Highest Grade: " + highestGrade);
            System.out.println("Course ID " + courseIDs[j] + ", Student ID " + lowestStudentID + ", Lowest Grade: " + lowestGrade);
        }
    }
}