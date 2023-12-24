import java.util.ArrayList;
import java.util.List;

// Generic class representing a University
public class University<T extends Student> {
    private List<T> students;
    private List<Course> courses;

    public University() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public void addStudent(T student) {
        try {
            int studentId = student.getStudentId();
            // Check if the student ID is positive before adding
            if (studentId > 0) {
                // Check if the student ID is already in use
                for (T existingStudent : students) {
                    if (existingStudent.getStudentId() == studentId) {
                        throw new IllegalArgumentException("Student ID " + studentId + " is already in use.");
                    }
                }
                students.add(student);
            } else {
                throw new IllegalArgumentException("Invalid student ID. Must be a positive integer.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public void addCourse(Course course) {
        try {
            // Check if the course name is not the same (case-insensitive)
            for (Course existingCourse : courses) {
                if (existingCourse.getName().equalsIgnoreCase(course.getName())) {
                    throw new IllegalArgumentException("Course with name " + course.getName() + " already exists.");
                }
            }
            courses.add(course);
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding course: " + e.getMessage());
        }
    }

    // Method to add grades for all students
    public void addGradesForAllStudents() {
        try {
            // Check if there are no students
            if (students.isEmpty()) {
                throw new IllegalStateException("No students found. Cannot add grades. First add student");
            }
            // Check if there are no courses
            if (courses.isEmpty()) {
                throw new IllegalStateException("No courses found. Cannot add grades. First add courses");
            }
            for (T student : students) {
                try {
                    System.out.println("Adding grades for student: " + student.getStudentName());
                    student.addGrades(courses);
                } catch (Exception e) {
                    System.out.println("Error adding grades for student " + student.getStudentName() + ": " + e.getMessage());
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("Error adding grades for all students: " + e.getMessage());
        }
    }

    // Method to display all students
    public void displayAllStudents() {
        try {
            // Check if there are no students
            if (students.isEmpty()) {
                throw new IllegalStateException("No students found. Cannot display students.");
            }

            for (T student : students) {
                System.out.println("Student Name: " + student.getStudentName() +
                        ", Student ID: " + student.getStudentId());
            }
        } catch (IllegalStateException e) {
            System.out.println("Error displaying all students: " + e.getMessage());
        }
    }

    // Method to display all courses
    public void displayAllCourses() {
        try {
            // Check if there are no courses
            if (courses.isEmpty()) {
                throw new IllegalStateException("No courses found. Cannot display courses.");
            }

            for (Course course : courses) {
                System.out.println("Course Name: " + course.getName());
            }
        } catch (IllegalStateException e) {
            System.out.println("Error displaying all courses: " + e.getMessage());
        }
    }

    // Method to display the highest grade in a course
    public void displayHighestGradeInCourse(String courseName) {
        try {
            int courseIndex = findCourseIndex(courseName);
            if (courseIndex != -1) {
                boolean isFirstStudent = true;
                int maxGrade = 0;

                for (Student student : students) {
                    int grade = student.getGrade(courseIndex);
                    if (isFirstStudent || grade > maxGrade) {
                        isFirstStudent = false;
                        maxGrade = grade;
                    }
                }

                if (!isFirstStudent) {
                    System.out.println("Highest grade in course " + courseName + ": " + maxGrade);
                } else {
                    System.out.println("No student in course " + courseName + ".");
                }
            } else {
                throw new IllegalArgumentException("Course not found.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to display grades for all students in a course
    public void displayGradesForAllStudentsInCourse(String courseName) {
        try {
            int courseIndex = findCourseIndex(courseName);
            if (courseIndex != -1) {
                System.out.println("\nGrades for all students in course " + courseName + ":");
                for (Student student : students) {
                    System.out.println("Student Name: " + student.getStudentName() +
                            ", Student ID: " + student.getStudentId() +
                            ", Grade: " + student.getGrade(courseIndex));
                }
            } else {
                throw new IllegalArgumentException("Course not found.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to display the student with the highest grade in a course
    public void displayStudentWithHighestGradeInCourse(String courseName) {
        try {
            int courseIndex = findCourseIndex(courseName);
            if (courseIndex != -1) {
                boolean isFirstStudent = true;
                int maxGrade = 0;
                Student topStudent = null;

                for (Student student : students) {
                    int grade = student.getGrade(courseIndex);
                    if (isFirstStudent || grade > maxGrade) {
                        isFirstStudent = false;
                        maxGrade = grade;
                        topStudent = student;
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
                throw new IllegalArgumentException("Course not found.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Private method to find the index of a course
    private int findCourseIndex(String courseName) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(courseName)) {
                return i;
            }
        }
        return -1;
    }
}

