public class CompareArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 8};

        boolean result = compareArrays(arr1, arr2);

        System.out.println("Are arr1 and arr2 equal? " + result); // باید true چاپ کند
    }

    public static boolean compareArrays(int[] arr1, int[] arr2) {
        // اگر اندازه‌ی دو آرایه متفاوت باشد، آنها قطعاً مساوی نیستند
        if (arr1.length != arr2.length) {
            return false;
        }

        // پیمایش عناصر دو آرایه و مقایسه آنها
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false; // حداقل یک جفت عنصر متفاوت است
            }
        }

        // همه عناصر یکسان هستند
        return true;
    }
}
