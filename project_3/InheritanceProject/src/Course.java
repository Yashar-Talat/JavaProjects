// Abstract class representing a Course
abstract class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void someCourseMethod(); // Abstract method for demonstration
}

