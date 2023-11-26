public class Course {
    private String name;
    private static String[] courseNames = new String[10];
    private static int courseIdCounter = 1;

    public Course(String name) {
        this.name = name;
        courseNames[courseIdCounter++] = name;
    }

    public String getName() {
        return name;
    }

//    public static String getCourseNameById(int courseId) {
//        return courseNames[courseId];
//    }
}
