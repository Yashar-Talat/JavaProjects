public class SearchSayyed {
    public static void main(String[] args) {
        String[] names = {"سیدعلی", "حسن", "سیدمحمد", "سیدجواد", "محمدرضا"};
        int count = 0;

        for (int i = 0; i < names.length; i++) {
            if (names[i].startsWith("سید")) {
                count++;
            }
        }

        System.out.println("تعداد نام‌هایی که با سید شروع می‌شوند: " + count);
    }
}
