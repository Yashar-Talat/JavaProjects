// Concrete class representing a generic course
class GenericCourse extends Course {
    public GenericCourse(String name) {
        super(name);
    }

    @Override
    public void someCourseMethod() {
        System.out.println("Generic course specific method.");
    }
}
