public class SortArray {
        public static void main(String[] args) {
            int[] numbers = {100,200,5,10,-2,8,5,5,6};

            // فراخوانی تابع مرتب‌سازی
            customSort(numbers);

            // چاپ آرایه مرتب‌شده با حلقه for
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i] + " ");
            }
        }

        public static void customSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // مقدار‌های دو عنصر را جابجا می‌کنیم
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }

