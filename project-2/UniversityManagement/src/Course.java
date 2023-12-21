import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;// نام درس
    private static List<String> courseNames = new ArrayList<>(); // لیست برای نگهداری نام درس‌ها


    public Course(String name) {
        this.name = name;
        courseNames.add(name); // در هنگام ساختن یک شیء Course، نام آن به لیست اضافه می‌شود
    }

    public String getName() {
        return name;
    }


}
